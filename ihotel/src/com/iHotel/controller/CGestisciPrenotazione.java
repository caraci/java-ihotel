package com.iHotel.controller;

import com.iHotel.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class CGestisciPrenotazione {
	
	private static CGestisciPrenotazione instance = null;
	private MPrenotazione _prenotazione;
	private int _albergo;
    private CGestisciPrenotazione() {
    	// Private constructor prevents instantiation from other classes
    }
	
    /**
	 * 
	 * @param albergo
	 */
	public void setAlbergo(int albergo){
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
	public ArrayList<ArrayList<MCamera>> cercaCamereLibere(int gi, int mi, int ai, int gf, int mf,, int af, ArrayList<String> Tipologie) {
		MPeriodo periodo = new MPeriodo();
		periodo.set_gi(gi);
		periodo.set_mi(mi);
		periodo.set_ai(ai);
		periodo.set_gf(gf);
		periodo.set_mf(mf);
		periodo.set_af(af);
		ArrayList<ArrayList<MCamera>> camere_libere_dalle_tipologie = new ArrayList<ArrayList<MCamera>>();
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext()) {
			 camere_libere_dalle_tipologie.add(_albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next().));
		}
		return camere_libere_dalle_tipologie;
	}

}