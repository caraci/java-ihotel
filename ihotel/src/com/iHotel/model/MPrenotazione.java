package com.iHotel.model;

import java.util.*;

public class MPrenotazione {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	private ArrayList<MCamera> _camerePrenotate = new ArrayList<MCamera>();
	private MPeriodo _periodo;
	private boolean _completata;
	private MOspite _prenotante=new MOspite();
	
	public MPrenotazione() {}
	/* ----------------------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per ottenere il totale di una prenotazione.
	 * 
	 * @return Totale della prenotazione.
	 */
	public double getTotal(){
		// Variabile nella quale andiamo a salvare il totale.
		double total=0;
		// Cicliamo su tutti gli elementi della prenotazione.
		MCatalogoCamere catalogo=MCatalogoCamere.getInstance();
		MDescrizioneCamera descrizione= new MDescrizioneCamera();
		for (Iterator<MCamera> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			MCamera cameraPrenotata = (MCamera) iterator.next();
			String tipologia = cameraPrenotata.get_tipologia();
			descrizione=catalogo.getDescrizioneDaTipologia(tipologia);
			total+=descrizione.calcolaPrezzoInPeriodo(_periodo);		
		}
		return total;				
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
	public void addPrenotante(String nome, String cognome, String eMail, String telefono){
	
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
	 * @param _completata 
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

}