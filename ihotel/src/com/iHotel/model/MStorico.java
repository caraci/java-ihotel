package com.iHotel.model;

import java.util.*;

public class MStorico {

	/* ------------------------------- Attributi e Costruttore ----------------------------- */
	// Singleton 
	private static MStorico instance = null;
	private ArrayList<MPrenotazioneSubject> _prenotazioni;
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private MStorico() {}
	/* -------------------------------- Metodi di classe ----------------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern singleton
	 * @return instance 
	 */
	public static MStorico getInstance() {
    	if(instance == null) {
            instance = new MStorico();
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
	public void addPrenotazione(MPrenotazioneSubject prenotazione) {
		_prenotazioni.add(prenotazione);
	}
	/* --------------------------------- Getter, Setter ---------------------------------- */
	
	/**
	 * @return _prenotazioni
	 */
	public ArrayList<MPrenotazioneSubject> get_prenotazioni() {
		return _prenotazioni;
	}

	/**
	 * @param _prenotazioni
	 */
	public void set_prenotazioni(ArrayList<MPrenotazioneSubject> _prenotazioni) {
		this._prenotazioni = _prenotazioni;
	}

}