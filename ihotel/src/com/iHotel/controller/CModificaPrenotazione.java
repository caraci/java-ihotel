package com.iHotel.controller;

import com.iHotel.model.*;

public class CModificaPrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private static CModificaPrenotazione instance = null;
	private PrenotazioneSubject _prenotazione2;
	private CameraContext _numeroCamera2;

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
	public PrenotazioneSubject get_prenotazione2() {
		return _prenotazione2;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione2(PrenotazioneSubject _prenotazione) {
		this._prenotazione2 = _prenotazione;
	}

	/**
	 * @return the _numeroCamera
	 */
	public CameraContext get_numeroCamera2() {
		return _numeroCamera2;
	}

	/**
	 * @param _numeroCamera the _numeroCamera to set
	 */
	public void set_numeroCamera2(CameraContext _numeroCamera) {
		this._numeroCamera2 = _numeroCamera;
	}

}