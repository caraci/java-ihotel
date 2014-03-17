package com.iHotel.controller;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.State.CameraContext;

public class CModificaPrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private static CModificaPrenotazione instance = null;
	private PrenotazioneSubject _prenotazione;
	private CameraContext _numeroCamera;

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

	public PrenotazioneSubject get_prenotazione() {
		return this._prenotazione;
	}

	public void set_prenotazione(PrenotazioneSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

	public CameraContext get_numeroCamera() {
		return this._numeroCamera;
	}

	public void set_numeroCamera(CameraContext _numeroCamera) {
		this._numeroCamera = _numeroCamera;
	}

}