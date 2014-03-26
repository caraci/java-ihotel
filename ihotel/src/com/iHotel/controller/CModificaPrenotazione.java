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
	 * @return Instanza unica di questa classe
	 */
    public static CModificaPrenotazione getInstance() {
    	if(instance == null) {
            instance = new CModificaPrenotazione();
         }
         return instance;
    }
	/* ------------------------- Metodi di instanza ---------------------------------- */
    
    /**
     * Metodo per aggiungere un servizio alla camera selezionata, relativa alla prenotazione che si sta
     * modificando.
     * @param dataServizio Data per il quale si richiede il servizio interno.
     */
    public void aggiungiServizio(GregorianCalendar dataServizio){
    	
    }
    /**
     * Metodo per mostrare l'interfaccia per aggiungere nuovi servizi alla camera della prenotazione.
     */
    public void aggiungiServiziCamera(){
    	
    }
    /**
     * Metodo per mostrare le informazioni relative ad un servizio interno.
     * @param codiceServizio Codice del servizio da mostrare
     */
    public void scegliServizioDaCodice(String codiceServizio){
    	    	
    }
    /**
     * Metodo per mostrare l'interfaccia per il caricamento della prenotazione da gestire.
     */
	public void gestionePrenotazione() {
		// TODO - implement CModificaPrenotazione.modificaPrenotazione
		throw new UnsupportedOperationException();
	}
	/**
	 * Metodo per mostrare l'interfaccia per la gestione della prenotazione, relativa al codice fornito.
	 * @param codicePrenotazione Codice della prenotazione da caricare.
	 */
	public void recuperaPrenotazioneDaCodice(String codicePrenotazione) {
		// TODO - implement CModificaPrenotazione.recuperaPrenotazioneDaCodice
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo per mostrare l'interfaccia contenente le informazioni sulla camera, relativa al numero fornito. 
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