package com.iHotel.controller;

import com.iHotel.model.*;

public class CGestisciPrenotazione {
	
	private static CGestisciPrenotazione instance = null;
	private MPrenotazione _prenotazione;
	
    private CGestisciPrenotazione() {
    	MPrenotazione _prenotazione = new MPrenotazione();
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
	public void creaNuovaPrenotazione() {
		// TODO - implement CGestisciPrenotazione.creaNuovaPrenotazione
		throw new UnsupportedOperationException();
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
	public void concludiPrenotazione(java.lang.String nome, java.lang.String cognome, java.lang.String email, int telefono) {
		// TODO - implement CGestisciPrenotazione.concludiPrenotazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param DataInizio
	 * @param DataFine
	 * @param Tipologie
	 */
	public void cercaCamereLibere(java.util.Date DataInizio, java.util.Date DataFine, java.util.ArrayList<java.lang.String> Tipologie) {
		// TODO - implement CGestisciPrenotazione.cercaCamereLibere
		throw new UnsupportedOperationException();
	}

}