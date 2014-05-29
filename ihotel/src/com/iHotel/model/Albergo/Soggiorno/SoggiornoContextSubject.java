package com.iHotel.model.Albergo.Soggiorno;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Observer.ISubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe rappresenta il concetto di "Prenotazione" di una stanza d'albergo del mondo reale. 
 * Poichè per necessità di design era necessario aggiornare alcuni oggetti software in seguito al cambiamento di uno degli 
 * attributi di un'oggetto di questa classe (e.g.: si aggiunge una camera alla prenotazione, deve essere notificato un 
 * cambiamento di prezzo all'operatore che si trova davanti al pc) questa classe è stata realizzata sfruttando il design
 * pattern "Observer". In particolare implementa la classe ISubject.
 * 
 * @author Alessandro
 */
public class SoggiornoContextSubject implements ISubject {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	/**
	 * Lista delle camere prenotate per questo soggiorno.
	 */
	private ArrayList<Camera> _camerePrenotate;
	/**
	 * Lista degli osservatori di questo oggetto - Pattern Observer
	 */
	private ArrayList<IObserver> _osservatori;
	
	/**
	 * Lista dei pagamenti effettuati a favore del soggiorno.
	 */
	private ArrayList<Pagamento> _pagamenti;
	/**
	 * Il periodo della prenotazione va dal giorno in cui l'ospite inizia il soggiorno, al giorno in cui l'ospite 
	 * termina il soggiorno e lascia la struttura ricettiva.
	 */
	private Periodo _periodo;
	/**
	 * Cliente prenotante del soggiorno.
	 */
	private ClientePrenotante _prenotante;
	/**
	 * Importo totale per le camere riservate da questo soggiorno.
	 */
	private Prezzo _importoTotaleCamere;
	/**
	 * Codice identificativo del soggiorno.
	 */
	private String _codice;
	/**
	 * Giorno limite entro il quale deve essere fornito, o una carta di credito o un bonifico a favore della richiesta di soggiorno.
	 */
	private Giorno _giornoScadenzaInvioGaranzia;
	/**
	 * Ammontare della caparra da versare per garantire la prenotazione
	 */
	private Prezzo _ammontareCaparra;
	/**
	 * Stato in cui si trova il soggiorno - Pattern State
	 */
	private SoggiornoState _soggiornoState;
	/**
	 * 	Importo totale pagamenti ricevuti per il soggiorno
	 */
	private Prezzo _importoTotalePagamenti;
	
	/**
	 * Costruttore.
	 */
	public SoggiornoContextSubject() {
		_camerePrenotate = new ArrayList<Camera>();
		_osservatori = new ArrayList<IObserver>();
		_importoTotaleCamere = new Prezzo();
		_pagamenti= new ArrayList<Pagamento>();
		_ammontareCaparra = new Prezzo();
		_soggiornoState = new SoggiornoPrenotato(this);
		_importoTotalePagamenti = new Prezzo();
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
	 * 
	 * @return Prezzo dei servizi interni di una prenotazione.
	 */
	public Prezzo getPrezzoServiziInterni(){
		// Passo la richiesta allo stato attuale
		Prezzo prezzoServiziInterni = _soggiornoState.getPrezzoServiziInterni();
		
		return prezzoServiziInterni;
	}
	/**
	 * Metodo per calcolare il totale delle camere di una prenotazione
	 */
	public void calcolaImportoTotaleCamere(){
		// Passo la richiesta allo stato attuale
		_soggiornoState.calcolaImportoTotaleCamere();
	}
	/**
	 * Metodo che calcola la differenza tra l'importo totale della prenotazione (comprensivo di prezzo di
	 * camere, servizi interni ed esterni) e l'importo già versato (con uno o più versamenti)
	 */
	public Prezzo calcolaImportoRimanenteDaPagare(){
		// Passo la richiesta allo stato attuale
		return _soggiornoState.calcolaImportoRimanenteDaPagare();
	}
	/**
	 * Metodo per aggiungere una camera alla prenotazione.
	 * 
	 * @param camera Camera da aggiungere alla prenotazione.
	 */
	public void addCamera(Camera camera) {
		// Passo la richiesta allo stato attuale
		_soggiornoState.addCamera(camera);
	}
	/**
	 * Metodo per aggiungere l'ospite prenotante.
	 * 
	 * @param nome Nome del prenotante.
	 * @param cognome Cognome del prenotante
	 * @param eMail eMail del prenotante.
	 * @param telefono Telefono del prenotante.
	 */
	public void addPrenotante(String nome, String cognome, String eMail, String telefono) {
		// Passo la richiesta allo stato attuale
		_soggiornoState.addPrenotante(nome, cognome, eMail, telefono);
	}
	/**
	 * Metodo per occupare le camere della prenotazione.
	 */
	public void occupaCamere() {
		// Passo la richiesta allo stato attuale
		_soggiornoState.occupaCamere();
	}
	/**
	 * Metodo per aggiungere un pagamento alla prenotazione.
	 * 
	 * @param pagamento Pagamento effettuato a favore del soggiorno.
	 */
	public void addPagamento(Pagamento pagamento) {
		// Passo la richiesta allo stato attuale
		_soggiornoState.addPagamento(pagamento);
	}
	/**
	 * Metodo per concludere la richiesta di soggiorno.
	 * 
	 * @param nome Nome del prenotante.
	 * @param cognome Cognome del prenotante.
	 * @param eMail eMail del prenotante.
	 * @param telefono Telefono del prenotante.
	 */
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono) {
		// Passo la richiesta allo stato attuale
		_soggiornoState.concludiPrenotazione(nome, cognome, eMail, telefono);
	}
	/**
	 * Metodo per effettuare il check in del soggiorno.
	 */
	public void effettuaCheckIn() {
		// Passo la richiesta allo stato attuale
		SoggiornoState statoSuccessivo = _soggiornoState.effettuaCheckIn();
		// Setto il nuovo stato del soggiorno
		this.set_soggiornoState(statoSuccessivo);
	}
	/**
	 * Metodo per effettuare il check out della del soggiorno.
	 */
	public void effettuaCheckOut() {
		// Passo la richiesta allo stato attuale
		SoggiornoState statoSuccessivo = _soggiornoState.effettuaCheckOut();
		// Setto il nuovo stato del soggiorno
		this.set_soggiornoState(statoSuccessivo);
		
	}
	
	/**
	 * Metodo che calcola il costo totale del soggiorno comprensivo di totale camere, totale servizi
	 * interni e totale servizi esterni
	 * 
	 * @return Il costo totale della prenotazione
	 */
	public Prezzo calcolaCostoTotaleSoggiorno(){
		//Delego allo state attuale
		return _soggiornoState.calcolaCostoTotaleSoggiorno();
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
	 * @return _prenotante
	 */
	public ClientePrenotante get_prenotante(){
		return this._prenotante;
	}
	/**
	 * @param _prenotante the _prenotante to set
	 */
	public void set_prenotante(ClientePrenotante _prenotante) {
		this._prenotante = _prenotante;
	}

	/**
	 * @return _total 
	 */
	public Prezzo get_importoTotaleCamere() {
		return this._importoTotaleCamere;
	}
	/**
	 * @param _total the total to set
	 */
	public void set_importoTotaleCamere(Prezzo _total) {
		this._importoTotaleCamere = _total;
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
	 * @return the _giornoScadenzaInvioGaranzia
	 */
	public Giorno get_giornoScadenzaInvioGaranzia() {
		return _giornoScadenzaInvioGaranzia;
	}
	
	/**
	 * @param _giornoScadenzaInvioGaranzia the _giornoScadenzaInvioGaranzia to set
	 */
	public void set_giornoScadenzaInvioGaranzia(Giorno _giornoScadenzaInvioGaranzia) {
		this._giornoScadenzaInvioGaranzia = _giornoScadenzaInvioGaranzia;
	}

	/**
	 * @return the _pagamenti
	 */
	public ArrayList<Pagamento> get_pagamenti() {
		return _pagamenti;
	}

	/**
	 * @param _pagamenti the _pagamenti to set
	 */
	public void set_pagamenti(ArrayList<Pagamento> _pagamenti) {
		this._pagamenti = _pagamenti;
	}

	/**
	 * @return the _ammontareCaparra
	 */
	public Prezzo get_ammontareCaparra() {
		return _ammontareCaparra;
	}

	/**
	 * @param _ammontareCaparra the _ammontareCaparra to set
	 */
	public void set_ammontareCaparra(Prezzo _ammontareCaparra) {
		this._ammontareCaparra = _ammontareCaparra;
	}

	/**
	 * @return the _statoSoggiorno
	 */
	public SoggiornoState get_soggiornoState() {
		return _soggiornoState;
	}

	/**
	 * @param _statoSoggiorno the _statoSoggiorno to set
	 */
	public void set_soggiornoState(SoggiornoState _statoSoggiorno) {
		this._soggiornoState = _statoSoggiorno;
	}

	/**
	 * @return the _importoTotalePagamenti
	 */
	public Prezzo get_importoTotalePagamenti() {
		return _importoTotalePagamenti;
	}

	/**
	 * @param _importoTotalePagamenti the _importoTotalePagamenti to set
	 */
	public void set_importoTotalePagamenti(Prezzo _importoTotalePagamenti) {
		this._importoTotalePagamenti = _importoTotalePagamenti;
	}
}