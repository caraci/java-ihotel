package com.iHotel.controller;

import com.iHotel.model.*;

public class CModificaPrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private static CModificaPrenotazione instance = null;
	private MPrenotazioneSubject _prenotazione;
	private MCamera _numeroCamera;

	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CModificaPrenotazione() {}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return CModificaPrenotazione Instanza unica di questa classe
	 */
    public static CModificaPrenotazione getInstance() {
    	if(instance == null) {
            instance = new CModificaPrenotazione();
         }
         return instance;
    }
	/* ------------------------- Metodi di instanza ---------------------------------- */
	public void modificaPrenotazione() {
		// TODO - implement CModificaPrenotazione.modificaPrenotazione
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param codice
	 */
	public void recuperaPrenotazioneDaCodice(String codice) {
		// TODO - implement CModificaPrenotazione.recuperaPrenotazioneDaCodice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroCamera
	 */
	public void modificaServiziCamera(String numeroCamera) {
		// TODO - implement CModificaPrenotazione.modificaServiziCamera
		throw new UnsupportedOperationException();
	}
	/* ----------------------- Getter, Setter -------------------------- */
	/**
	 * @return the _prenotazione
	 */
	public MPrenotazioneSubject get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(MPrenotazioneSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

	/**
	 * @return the _numeroCamera
	 */
	public MCamera get_numeroCamera() {
		return _numeroCamera;
	}

	/**
	 * @param _numeroCamera the _numeroCamera to set
	 */
	public void set_numeroCamera(MCamera _numeroCamera) {
		this._numeroCamera = _numeroCamera;
	}

}