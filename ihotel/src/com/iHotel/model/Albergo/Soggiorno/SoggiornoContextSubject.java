package com.iHotel.model.Albergo.Soggiorno;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Observer.ISubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe rappresenta il concetto di "Prenotazione" di una stanza d'albergo del mondo reale. 
 * Poich� per necessit� di design era necessario aggiornare alcuni oggetti software in seguito al cambiamento di uno degli 
 * attributi di un'oggetto di questa classe (e.g.: si aggiunge una camera alla prenotazione, deve essere notificato un 
 * cambiamento di prezzo all'operatore che si trova davanti al pc) questa classe � stata realizzata sfruttando il design
 * pattern "Observer". In particolare implementa la classe ISubject.
 * 
 * @author Alessandro
 */
public class SoggiornoContextSubject implements ISubject {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	/**
	 * Vengono mantenute le maniglie alle camere della prenotazione.
	 */
	private ArrayList<Camera> _camerePrenotate;
	/**
	 * Vengono mantenute le maniglie agli osservatori di questa istanza - Pattern Observer
	 */
	private ArrayList<IObserver> _osservatori;
	
	/**
	 * Vengono mantenute le informazioni sui pagamenti, la chiave stringa � l'identificativo del pagamento
	 */
	private ArrayList<Pagamento> _pagamenti;
	/**
	 * Il periodo della prenotazione va dal giorno in cui l'ospite inizia il soggiorno, al giorno in cui l'ospite 
	 * termina il soggiorono e lascia la struttura ricettiva.
	 */
	private Periodo _periodo;
	private boolean _completata;
	private ClientePrenotante _prenotante;
	private Prezzo _importoTotalCamere;
	private String _codice;
	/**
	 * Costruttore.
	 */
	public SoggiornoContextSubject() {
		_camerePrenotate = new ArrayList<Camera>();
		_osservatori = new ArrayList<IObserver>();
		_importoTotalCamere = new Prezzo();
		_pagamenti= new ArrayList<Pagamento>();
	}
	
	/* ----------------------------------- Metodi di classe ------------------------------------------- */
	/**
	 * Metodo per generare il codice della prenotazione.
	 * 
	 * @return Codice della prenotazione, legato al timestamp del sistema.
	 */
	public static String generaCodice(){
		long codice;
		codice = Calendar.getInstance().getTime().getTime();
		return String.valueOf(codice);
	}
	
	/* ----------------------------------- Metodi di instanza ----------------------------------------- */
	
	/* ----------- Pattern Observer -------- */
	@Override
	public void Attach(IObserver observer) {
		_osservatori.add(observer);
	}
	@Override
	public void Detach(IObserver observer) {
		_osservatori.remove(observer);
	}
	@Override
	public void Notify() {
		for (Iterator<IObserver> iterator = _osservatori.iterator(); iterator.hasNext();) {
			IObserver observer = (IObserver) iterator.next();
			observer.Update();
		}
	}
	/* ------------ /Pattern Observer -------- */
	/**
	 * Metodo per ottenere il prezzo dei servizi interni di una prenotazione.
	 * @return Prezzo dei servizi interni di una prenotazione.
	 */
	public Prezzo getPrezzoServiziInterni(){
		Prezzo prezzo = new Prezzo();
		// Ciclo su tutte le camere
		for (Iterator<Camera> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
			prezzo.somma(camera.getPrezzoServiziInPeriodo(_periodo));
		}
		return prezzo;
	}
	
	/**
	 * Metodo per calcolare il totale di una prenotazione
	 */
	public void calcolaTotale(){
		DescrizioneCamera descrizione;
		// Prendo l'ultima camera aggiunta.
		Camera cameraPrenotata;
		cameraPrenotata=_camerePrenotate.get(_camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia=cameraPrenotata.get_tipologia();
		descrizione=CatalogoCamere.getInstance().getDescrizioneDaTipologia(tipologia);
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		_importoTotalCamere.somma(descrizione.calcolaPrezzoInPeriodo(_periodo));
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato della prenotazione.
		this.Notify();
	}
	
	/**
	 * Metodo per calcolare l'importo gi� pagato
	 */
	public Prezzo calcolaTotalePagamenti(){
		Prezzo pagamenti= new Prezzo();
		for (Iterator<Pagamento> iterator = _pagamenti.iterator(); iterator.hasNext();) {
			Pagamento pagamento = (Pagamento) iterator.next();
			pagamenti.somma(pagamento.get_importo());
		}
		return pagamenti;
	}
	
	/**
	 * Metodo per calcolare il rimanente importo da pagare
	 */
	public Prezzo calcolaTotaleDaPagare(){
		Prezzo importoDaPagare = new Prezzo();
		Prezzo totaleServiziEsterni = new Prezzo();
		
		totaleServiziEsterni = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(this);
		importoDaPagare.somma(_importoTotalCamere);
		importoDaPagare.somma(totaleServiziEsterni);
		importoDaPagare.somma(this.getPrezzoServiziInterni());
		importoDaPagare.sottrai(this.calcolaTotalePagamenti());
		
		return importoDaPagare;
	}
	
	
	/**
	 * Metodo per aggiungere una camera alla prenotazione.
	 * @param camera Camera da aggiungere alla prenotazione.
	 */
	public void addCamera(Camera camera) {
		_camerePrenotate.add(camera);
	}
	/**
	 * Metodo per aggiungere l'ospite prenotante.
	 * 
	 * @param nome Nome dell'ospite.
	 * @param cognome Cognome dell'ospite.
	 * @param eMail eMail dell'ospite.
	 * @param telefono Telefono dell'ospite.
	 */
	public void addPrenotante(String nome, String cognome, String eMail, String telefono) {
		_prenotante = new ClientePrenotante();
		_prenotante.set_nome(nome);		
		_prenotante.set_cognome(cognome);
		_prenotante.set_email(eMail);
		_prenotante.set_telefono(telefono);
	}
	/**
	 * Metodo che restituisce l'ospite titolare della prenotazione.
	 * 
	 * @return prenotante Ospite titolare dlela prenotazione.
	 */
	public ClientePrenotante getPrenotante(){
		return this._prenotante;
	}
	/**
	 * Metodo per occupare le camere della prenotazione.
	 */
	public void occupaCamere() {
		for (Iterator<Camera> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			Camera cameraPrenotata = (Camera) iterator.next();
			cameraPrenotata.occupaInPeriodoState(_periodo);
		}
	}
	/* -------------------------------- Getter, Setter ------------------------------------------ */
	/**
	 * @return _elementiPrenotazione
	 */
	public ArrayList<Camera> get_camerePrenotate() {
		return _camerePrenotate;
	}

	/**
	 * @param _elementiPrenotazione
	 */
	public void set_camerePrenotate(ArrayList<Camera> _elementiPrenotazione) {
		this._camerePrenotate = _elementiPrenotazione;
	}

	/**
	 * @return  _periodo
	 */
	public Periodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo 
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * @return _completata 
	 */
	public boolean get_completata() {
		return this._completata;
	}
	/**
	 * @param _completata 
	 */
	public void set_completata(boolean _completata) {
		this._completata = _completata;
	}
	/**
	 * @return _total 
	 */
	public Prezzo get_total() {
		return this._importoTotalCamere;
	}
	/**
	 * @param _total the total to set
	 */
	public void set_total(Prezzo _total) {
		this._importoTotalCamere = _total;
	}

	/**
	 * @return the _codice
	 */
	public String get_codice() {
		return _codice;
	}

	/**
	 * @param _codice the _codice to set
	 */
	public void set_codice(String _codice) {
		this._codice = _codice;
	}

	/**
	 * @return the _pagamenti
	 */
	public ArrayList<Pagamento> get_pagamenti() {
		return _pagamenti;
	}

	/**
	 * Metodo per aggiungere un pagamento alla prenotazione
	 * @param tipoDiPagamento 	E' il tipo di pagamento effettuato, ad esempio contanti
	 * @param pagamento			E' l'oggetto pagamento
	 */
	public void add_pagamento(Pagamento pagamento) {
		//Aggiungo il pagamento nella mappa, correttamente rispetto alla posizione
		this._pagamenti.add(pagamento);
	}
}