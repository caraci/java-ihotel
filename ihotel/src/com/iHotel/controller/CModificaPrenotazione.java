package com.iHotel.controller;

import java.util.GregorianCalendar;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.State.CameraContext;

public class CModificaPrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private static CModificaPrenotazione instance = null;
	private PrenotazioneSubject _prenotazione;
	private CameraContext _camera;
	private String _codiceServizio;

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
    
    public void aggiungiServizio(GregorianCalendar dataServizio){
    	
    }
    public void aggiungiServiziCamera(){
    	
    }
    
    public void scegliServizioDaCodice(String codiceServizio){
    	    	
    }
    
	public void gestionePrenotazione() {
		// TODO - implement CModificaPrenotazione.modificaPrenotazione
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param codice
	 */
	public void recuperaPrenotazioneDaCodice(String codicePrenotazione) {
		// TODO - implement CModificaPrenotazione.recuperaPrenotazioneDaCodice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numeroCamera
	 */
	public void gestioneCamera(String numeroCamera) {
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
		return this._camera;
	}

	public void set_numeroCamera(CameraContext _numeroCamera) {
		this._camera = _numeroCamera;
	}
	/**
	 * @return the _codiceServizio
	 */
	public String get_codiceServizio() {
		return _codiceServizio;
	}
	/**
	 * @param _codiceServizio the _codiceServizio to set
	 */
	public void set_codiceServizio(String _codiceServizio) {
		this._codiceServizio = _codiceServizio;
	}

}