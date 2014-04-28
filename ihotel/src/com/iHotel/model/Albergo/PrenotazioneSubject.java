package com.iHotel.model.Albergo;

import java.util.*;

import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Observer.ISubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe rappresenta il concetto di "Prenotazione" di una stanza d'albergo del mondo reale. 
 * Poichè per necessità di design era necessario aggiornare alcuni oggetti software in seguito al cambiamento di uno degli 
 * attributi di un'oggetto di questa classe (e.g.: si aggiunge una camera alla prenotazione, deve essere notificato un 
 * cambiamento di prezzo all'operatore che si trova davanti al pc) questa classe è stata realizzata sfruttando il design
 * pattern "Observer". In particolare implementa la classe ISubject.
 * @author Alessandro
 *
 */
public class PrenotazioneSubject implements ISubject {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	//Vengono mantenute le maniglie alle camere della prenotazione
	private ArrayList<CameraContext> _camerePrenotate;
	//Vengono mantenute le maniglie agli osservatori di questa istanza - Pattern Observer
	private ArrayList<IObserver> _osservatori;
	//Il periodo della prenotazione va dal giorno in cui l'ospite inizia il soggiorno, al giorno in cui l'ospite 
	//termina il soggiorono e lascia la struttura ricettiva
	private Periodo _periodo;
	private boolean _completata;
	private Ospite _prenotante;
	private Prezzo _total;
	private String _codice;
	/**
	 * Costruttore.
	 */
	public PrenotazioneSubject() {
		_camerePrenotate = new ArrayList<CameraContext>();
		_osservatori = new ArrayList<IObserver>();
		_total = new Prezzo();
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
		for (Iterator<CameraContext> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			CameraContext camera = (CameraContext) iterator.next();
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
		CameraContext cameraPrenotata;
		cameraPrenotata=_camerePrenotate.get(_camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia=cameraPrenotata.get_tipologia();
		descrizione=CatalogoCamere.getInstance().getDescrizioneDaTipologia(tipologia);
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		_total.somma(descrizione.calcolaPrezzoInPeriodo(_periodo));
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato della prenotazione.
		this.Notify();
	}
	/**
	 * Metodo per aggiungere una camera alla prenotazione.
	 * @param camera Camera da aggiungere alla prenotazione.
	 */
	public void addCamera(CameraContext camera) {
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
		_prenotante = new Ospite();
		_prenotante.set_nome(nome);		
		_prenotante.set_cognome(cognome);
		_prenotante.set_eMail(eMail);
		_prenotante.set_telefono(telefono);
	}
	/**
	 * Metodo che restituisce l'ospite titolare della prenotazione.
	 * 
	 * @return prenotante Ospite titolare dlela prenotazione.
	 */
	public Ospite getPrenotante(){
		return this._prenotante;
	}
	/**
	 * Metodo per occupare le camere della prenotazione.
	 */
	public void occupaCamere() {
		for (Iterator<CameraContext> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			CameraContext cameraPrenotata = (CameraContext) iterator.next();
			cameraPrenotata.occupaInPeriodoState(_periodo);
		}
	}
	/* -------------------------------- Getter, Setter ------------------------------------------ */
	/**
	 * @return _elementiPrenotazione
	 */
	public ArrayList<CameraContext> get_camerePrenotate() {
		return _camerePrenotate;
	}

	/**
	 * @param _elementiPrenotazione
	 */
	public void set_camerePrenotate(ArrayList<CameraContext> _elementiPrenotazione) {
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
		return this._total;
	}
	/**
	 * @param _total the total to set
	 */
	public void set_total(Prezzo _total) {
		this._total = _total;
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
}