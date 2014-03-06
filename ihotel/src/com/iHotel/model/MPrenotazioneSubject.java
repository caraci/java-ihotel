package com.iHotel.model;

import java.util.*;

import com.iHotel.model.Utility.MPeriodo;
import com.iHotel.view.Observer;

public class MPrenotazioneSubject implements Subject {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	private ArrayList<MCamera> _camerePrenotate = new ArrayList<MCamera>();
	private ArrayList<Observer> _osservatori = new ArrayList<com.iHotel.view.Observer>();
	private MPeriodo _periodo;
	private boolean _completata;
	private MOspite _prenotante;
	private double _total;
	private String _codice;
	
	public MPrenotazioneSubject() {}
	/* ----------------------------------- Metodi di instanza ----------------------------------------- */
	
	/* ----------- Pattern Observer -------- */
	@Override
	public void Attach(com.iHotel.view.Observer observer) {
		_osservatori.add(observer);
		
	}
	@Override
	public void Detach(com.iHotel.view.Observer observer) {
		_osservatori.remove(observer);
	}
	@Override
	public void Notify() {
		for (Iterator<com.iHotel.view.Observer> iterator = _osservatori.iterator(); iterator.hasNext();) {
			com.iHotel.view.Observer observer = (com.iHotel.view.Observer) iterator.next();
			observer.Update();
		}
		
	}
	/* ------------ /Pattern Observer -------- */
	/**
	 * Metodo per calcolare il totale di una prenotazione
	 */
	public void calcolaTotale(){
		// Cicliamo su tutti gli elementi della prenotazione.
		MCatalogoCamere catalogo=MCatalogoCamere.getInstance();
		MDescrizioneCamera descrizione= new MDescrizioneCamera();
		// Prendo l'ultima camera aggiunta.
		MCamera cameraPrenotata = new MCamera();
		cameraPrenotata=_camerePrenotate.get(_camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia = cameraPrenotata.get_tipologia();
		descrizione=catalogo.getDescrizioneDaTipologia(tipologia);
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		_total+=descrizione.calcolaPrezzoInPeriodo(_periodo);				
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato della prenotazione.
		this.Notify();
	}
	/**
	 * Metodo per aggiungere un elemento alla prenotazione.
	 * @param camera Camera da aggiungere alla prenotazione
	 */
	public void addCamera(MCamera camera) {
		_camerePrenotate.add(camera);
	}
	/**
	 * Metodo per aggiungere l'ospite prenotante.
	 * @param nome Nome dell'ospite.
	 * @param cognome Cognome dell'ospite.
	 * @param eMail eMail dell'ospite.
	 * @param telefono Telefono dell'ospite.
	 */
	public void addPrenotante(String nome, String cognome, String eMail, String telefono) {
		_prenotante = new MOspite();
		_prenotante.set_nome(nome);		
		_prenotante.set_cognome(cognome);
		_prenotante.set_eMail(eMail);
		_prenotante.set_telefono(telefono);
	}
	/**
	 * Metodo per occupare le camere della prenotazione.
	 */
	public void occupaCamere() {
		for (Iterator<MCamera> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			MCamera cameraPrenotata = (MCamera) iterator.next();
			cameraPrenotata.occupaInPeriodo(_periodo);
		}
	}
		
	/* -------------------------------- Getter, Setter ------------------------------------------ */
	/**
	 * @return _elementiPrenotazione
	 */
	public ArrayList<MCamera> get_camerePrenotate() {
		return _camerePrenotate;
	}

	/**
	 * @param _elementiPrenotazione
	 */
	public void set_camerePrenotate(ArrayList<MCamera> _elementiPrenotazione) {
		this._camerePrenotate = _elementiPrenotazione;
	}

	/**
	 * @return  _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo 
	 */
	public void set_periodo(MPeriodo _periodo) {
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
	public double get_total() {
		return this._total;
	}
	/**
	 * @param _total the total to set
	 */
	public void set_total(double _total) {
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