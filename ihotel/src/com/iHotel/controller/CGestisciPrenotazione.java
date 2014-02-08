package com.iHotel.controller;

import com.iHotel.model.*;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;

import java.util.ArrayList;
import java.util.Iterator;

public class CGestisciPrenotazione {
	
	/* Singleton */
	private static CGestisciPrenotazione instance = null;
	private MPrenotazione _prenotazione;
	private MAlbergo _albergo;
    
	
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
	public void cercaCamereLibere(int gi, int mi, int ai, int gf, int mf, int af, ArrayList<String> Tipologie) {
		/* Setto il periodo ricevuto dall'interfaccia */
		MPeriodo periodo = new MPeriodo();
		periodo.set_giornoInizio(gi);
		periodo.set_meseInizio(mi);
		periodo.set_annoInizio(ai);
		periodo.set_giornoFine(gf);
		periodo.set_meseFine(mf);
		periodo.set_annoFine(af);
		// Recupero l'interfaccia relativa al primo step della prenotazione mediante singleton
		VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = VFrameCreaPrenotazioneStep_1.getInstance();
		frameCreaPrenotazioneStep_1.setVisible(false);
		ArrayList<ArrayList<MCamera>> camereLibereDalleTipologie = new ArrayList<ArrayList<MCamera>>();
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			 //camereLibereDalleTipologie.add(_albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next()));
			System.out.println(_albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next()).get(0).get_numero());
		}
		
		//return camereLibereDalleTipologie;
	}

}