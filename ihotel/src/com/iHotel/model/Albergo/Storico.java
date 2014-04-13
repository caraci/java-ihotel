package com.iHotel.model.Albergo;

import java.util.*;

public class Storico {

	/* ------------------------------- Attributi e Costruttore ----------------------------- */
	// Singleton 
	private static Storico instance = null;
	private HashMap<String,PrenotazioneSubject> _prenotazioni;
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
	 * Metodo per ottenere una prenotazione a partire dal suo codice.
	 * @param codice Codice della prenotazione
	 * @return Prenotazione ricercata
	 */
	public PrenotazioneSubject recuperaPrenotazioneDaCodice(String codice) {
		return _prenotazioni.get(codice);
	}

	/**
	 * Metodo per aggiungere una prenotazione allo storico
	 * @param prenotazione Prenotazione da aggiungere.
	 */
	public void addPrenotazione(PrenotazioneSubject prenotazione) {
		_prenotazioni.put(prenotazione.get_codice(), prenotazione);
	}
	/* --------------------------------- Getter, Setter ---------------------------------- */
	
	/**
	 * @return _prenotazioni
	 */
	public HashMap<String,PrenotazioneSubject> get_prenotazioni() {
		return _prenotazioni;
	}

	/**
	 * @param _prenotazioni
	 */
	public void set_prenotazioni(HashMap<String,PrenotazioneSubject> _prenotazioni) {
		this._prenotazioni = _prenotazioni;
	}

}