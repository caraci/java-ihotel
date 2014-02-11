package com.iHotel.controller;

import com.iHotel.model.*;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;
import com.iHotel.view.VFrameCreaPrenotazioneStep_2;

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
	 * Metodo per aggiungere una Camera alla prenotazione
	 * @param numeroCamera Stringa contenente il numero della camera
	 * @return 
	 */
	public boolean aggiungiElementoPrenotazione(String numeroCamera) {
		MCamera camera = new MCamera();
		// Ricavo la MCamera a partire dalla stringa contenente il suo numero.
		camera = _albergo.getCameraDaNumero(numeroCamera);
		_prenotazione.addElementoPrenotazione(camera);
		return true;
	}
	/**
	 * Metodo per ricercare le camere libere nell'albergo ed appartenenti a tipologie differenti.
	 * @param DataInizio
	 * @param DataFine
	 * @param Tipologie
	 */
	public void cercaCamereLibere(int gi, int mi, int ai, int gf, int mf, int af, ArrayList<String> Tipologie) {
		
		/* Setto il periodo ricevuto dall'interfaccia */
		MPeriodo periodo = new MPeriodo();
		/* Setto la data di inizio */
		periodo.set_giornoInizio(gi);
		periodo.set_meseInizio(mi);
		periodo.set_annoInizio(ai);
		/* Setto la data di fine*/
		periodo.set_giornoFine(gf);
		periodo.set_meseFine(mf);
		periodo.set_annoFine(af);	
		/* Setto il periodo alla prenotazione */
		_prenotazione.set_periodo(periodo);
	
		String tipologia;
		ArrayList<ArrayList<String>> camereLibereString = new ArrayList<ArrayList<String>>();
		
		// Ciclo sulle tipologie
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			tipologia = iterator.next();
			ArrayList<MCamera> camereLibereTipologia = new ArrayList<MCamera>();
			ArrayList<String> camereLibereTipologiaString= new ArrayList<String>();			 
			// Aggiunto al primo posto nell'ArrayList la tipologia di camere.
			camereLibereTipologiaString.add(0, tipologia);			
			camereLibereTipologia = _albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, tipologia);		
			for (Iterator<MCamera> iteratorCamereLibere = camereLibereTipologia.iterator(); iteratorCamereLibere.hasNext();) {
				// Aggiungo il numero della camera all'ArrayList
				camereLibereTipologiaString.add(iteratorCamereLibere.next().get_numero());
			}
			// Aggiungo l'ArrayList delle stringhe relative a tutte le camere appartenenti ad una tipologia
			camereLibereString.add(camereLibereTipologiaString);
		}
		
		//mostro finestra 2
		VFrameCreaPrenotazioneStep_2 frameCreaPrenotazioneStep_2 = VFrameCreaPrenotazioneStep_2.getInstance();
		frameCreaPrenotazioneStep_2.creaFrame(camereLibereString);			
		frameCreaPrenotazioneStep_2.setVisible(true);
		//Nascondo finestra 1
		VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = VFrameCreaPrenotazioneStep_1.getInstance();
		frameCreaPrenotazioneStep_1.setVisible(false);
		
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
