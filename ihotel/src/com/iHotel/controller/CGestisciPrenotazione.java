package com.iHotel.controller;

import com.iHotel.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class CGestisciPrenotazione {
	
	private static CGestisciPrenotazione instance = null;
	private MPrenotazione _prenotazione;
	private MAlbergo _albergo;
    
	/**
	 * @return the _albergo
	 */
	public MAlbergo get_albergo() {
		return _albergo;
	}

	/**
	 * @param _albergo the _albergo to set
	 */
	public void set_albergo(MAlbergo _albergo) {
		this._albergo = _albergo;
	}
	
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
	public ArrayList<ArrayList<MCamera>> cercaCamereLibere(int gi, int mi, int ai, int gf, int mf, int af, ArrayList<String> Tipologie) {
		MPeriodo periodo = new MPeriodo();
		periodo.set_giornoInizio(gi);
		periodo.set_meseInizio(mi);
		periodo.set_annoInizio(ai);
		periodo.set_giornoFine(gf);
		periodo.set_meseFine(mf);
		periodo.set_annoFine(af);
		ArrayList<ArrayList<MCamera>> camereLibereDalleTipologie = new ArrayList<ArrayList<MCamera>>();
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			 camereLibereDalleTipologie.add(_albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next()));
		}
		return camereLibereDalleTipologie;
	}

}