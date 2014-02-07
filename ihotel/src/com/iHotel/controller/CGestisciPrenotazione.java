package com.iHotel.controller;

import com.iHotel.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class CGestisciPrenotazione {
	
	private static CGestisciPrenotazione instance = null;
	private MPrenotazione _prenotazione;
	private MAlbergo _albergo;
    private CGestisciPrenotazione() {
    	// Private constructor prevents instantiation from other classes
    }
	
    public void setAlbergo(MAlbergo albergo){
    	_albergo =albergo;
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
	public ArrayList<ArrayList<MCamera>> cercaCamereLibere(long DataInizio, long DataFine, ArrayList<String> Tipologie) {
		MPeriodo periodo = new MPeriodo();
		periodo.set_dataInizio(DataInizio);
		periodo.set_dataFine(DataFine);
		ArrayList<ArrayList<MCamera>> camere_libere_dalle_tipologie = new ArrayList<ArrayList<MCamera>>();
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			 camere_libere_dalle_tipologie.add(_albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next().toString()));
		}
		return camere_libere_dalle_tipologie;
		
	}

}