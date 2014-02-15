package com.iHotel.controller;

import com.iHotel.model.*;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;
import com.iHotel.view.VFrameCreaPrenotazioneStep_2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
	public double aggiungiElementoPrenotazione(String numeroCamera) {
		MCamera camera = new MCamera();
		// Ricavo la MCamera a partire dalla stringa contenente il suo numero.
		camera = _albergo.getCameraDaNumero(numeroCamera);
		// Aggiungo la camera all'elemento prenotazione
		_prenotazione.addElementoPrenotazione(camera);
		// Restituisco il totale della prenotazione in seguito all'aggiunta della camera
		return _prenotazione.getTotal();
	}
	/**
	 * Metodo per ricercare le camere libere nell'albergo ed appartenenti a tipologie differenti.
	 * @param DataInizio
	 * @param DataFine
	 * @param Tipologie
	 */
	public void cercaCamereLibere(GregorianCalendar dataInizio, GregorianCalendar dataFine, ArrayList<String> Tipologie) {
		
		/* Setto il periodo ricevuto dall'interfaccia */
		MPeriodo periodo = new MPeriodo();
		/* Setto la data di inizio */
		periodo.setDataInizioDaData(dataInizio);
		/* Setto la data di fine*/
		periodo.setDataFineDaData(dataFine);
		/* Setto il periodo alla prenotazione */
		_prenotazione.set_periodo(periodo);
		// Struttura dati nella quale andremo a salvare le informazioni relative alle camere libere.
		ArrayList<ArrayList<String>> camereLibereString = new ArrayList<ArrayList<String>>();
		
		// Ciclo sulle tipologie
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			String tipologia = iterator.next();
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
		// Mostro finestra Step 2
		VFrameCreaPrenotazioneStep_2 frameCreaPrenotazioneStep_2 = VFrameCreaPrenotazioneStep_2.getInstance();
		frameCreaPrenotazioneStep_2.creaFrame(camereLibereString);			
		frameCreaPrenotazioneStep_2.setVisible(true);
		// Nascondo finestra Step 1
		VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = VFrameCreaPrenotazioneStep_1.getInstance();
		frameCreaPrenotazioneStep_1.setVisible(false);
		
	}
	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param telefono
	 */
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono) {
		// Aggiungo l'ospite alla prenotazione
		_prenotazione.addOspite(nome, cognome, eMail, telefono);
		// 
	}
	/* -------------------------- Getter, Setter -------------------- */
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
	 * @return the _prenotazione
	 */
	public MPrenotazione get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(MPrenotazione _prenotazione) {
		this._prenotazione = _prenotazione;
	}

}
