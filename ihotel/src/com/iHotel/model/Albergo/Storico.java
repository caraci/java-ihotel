package com.iHotel.model.Albergo;

import java.util.*;

public class Storico {

	/* ------------------------------- Attributi e Costruttore ----------------------------- */
	// Singleton 
	private static Storico instance = null;
	private ArrayList<PrenotazioneSubject> _prenotazioni;
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private Storico() {}
	/* -------------------------------- Metodi di classe ----------------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern singleton
	 * @return instance 
	 */
	public static Storico getInstance() {
    	if(instance == null) {
            instance = new Storico();
         }
         return instance;
    }
	/* ------------------------------ Metodi di instanza ----------------------------------- */
	/**
	 * 
	 * @param codice
	 */
	public void recuperaPrenotazioneDaCodice(String codice) {
		// TODO - implement MStorico.recuperaPrenotazioneDaCodice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prenotazione
	 */
	public void addPrenotazione(PrenotazioneSubject prenotazione) {
		_prenotazioni.add(prenotazione);
	}
	/* --------------------------------- Getter, Setter ---------------------------------- */
	
	/**
	 * @return _prenotazioni
	 */
	public ArrayList<PrenotazioneSubject> get_prenotazioni() {
		return _prenotazioni;
	}

	/**
	 * @param _prenotazioni
	 */
	public void set_prenotazioni(ArrayList<PrenotazioneSubject> _prenotazioni) {
		this._prenotazioni = _prenotazioni;
	}

}