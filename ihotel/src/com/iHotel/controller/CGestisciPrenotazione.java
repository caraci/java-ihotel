package com.iHotel.controller;

import com.iHotel.model.*;
import java.util.ArrayList;

public class CGestisciPrenotazione {
	
	private static CGestisciPrenotazione instance = null;
	private MPrenotazione _prenotazione;
	
    private CGestisciPrenotazione() {
    	// Private constructor prevents instantiation from other classes
    }
	
	/**
	 * 
	 * @return CGestisciPrenotazione
	 */
    public static CGestisciPrenotazione getInstance() {
    	if(instance == null) {
            instance = new CGestisciPrenotazione();
         }
         return instance;
    }
    /**
     * Creazione della prenotazione
     */
	public void creaNuovaPrenotazione() {
		_prenotazione = new MPrenotazione();
	}

	/**
	 * 
	 * @param ep
	 */
	public void aggiungiElementoPrenotazione(MElementoPrenotazione ep) {
		// TODO - implement CGestisciPrenotazione.aggiungiElementoPrenotazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param telefono
	 */
	public void concludiPrenotazione(String nome, String cognome, String email, int telefono) {
		// TODO - implement CGestisciPrenotazione.concludiPrenotazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param DataInizio
	 * @param DataFine
	 * @param Tipologie
	 */
	public void cercaCamereLibere(long DataInizio, long DataFine, ArrayList<String> Tipologie) {
		// TODO - implement CGestisciPrenotazione.cercaCamereLibere
		throw new UnsupportedOperationException();
	}

}