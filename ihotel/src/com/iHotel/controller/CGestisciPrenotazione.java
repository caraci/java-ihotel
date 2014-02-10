package com.iHotel.controller;

import com.iHotel.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class CGestisciPrenotazione {
	
	/* Singleton */
	private static CGestisciPrenotazione instance = null;
	private MAlbergo _albergo;
	private MPrenotazione _prenotazione;
    
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CGestisciPrenotazione() {}
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
	 * @param camera
	 */
	public boolean aggiungiElementoPrenotazione(MCamera camera) {
		return false;
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
		/* Setto la data di inizio */
		/*periodo.set_giornoInizio(gi);
		periodo.set_meseInizio(mi);
		periodo.set_annoInizio(ai);
		/* Setto la data di fine */ 
		/*periodo.set_giornoFine(gf);
		periodo.set_meseFine(mf);
		periodo.set_annoFine(af);*/
		periodo.set_giornoInizio(1);
		periodo.set_meseInizio(0);
		periodo.set_annoInizio(2014);
		periodo.set_giornoFine(2);
		periodo.set_meseFine(0);
		periodo.set_annoFine(2014);
		// Recupero l'interfaccia relativa al primo step della prenotazione mediante singleton
		//VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = VFrameCreaPrenotazioneStep_1.getInstance();
		//frameCreaPrenotazioneStep_1.setVisible(false);
		
		//ArrayList<ArrayList<MCamera>> camereLibereDalleTipologie = new ArrayList<ArrayList<MCamera>>();
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			
			 //camereLibereDalleTipologie.add(_albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next()));
			ArrayList<MCamera> tmp = new ArrayList<MCamera>();
			tmp = _albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, iterator.next());
			for (Iterator<MCamera> iterator_camere_libere = tmp.iterator(); iterator_camere_libere.hasNext();) {
				System.out.println(iterator_camere_libere.next().get_numero());
			}
		}
		
		//return camereLibereDalleTipologie;
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
	public void concludiPrenotazione(String nome, String cognome, String email, String telefono) {
		// TODO - implement CGestisciPrenotazione.concludiPrenotazione
		throw new UnsupportedOperationException();
	}

}
