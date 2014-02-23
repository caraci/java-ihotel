package com.iHotel.controller;
import com.iHotel.model.*;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;
import com.iHotel.view.VFrameCreaPrenotazioneStep_2;
import com.iHotel.view.VFrameHome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

public class CGestisciPrenotazione {
	
	/* -------------------------------- Attributi e costruttore -------------------------------*/
	private static CGestisciPrenotazione instance = null;
	private MAlbergo _albergo;
	private MPrenotazione _prenotazione;
    
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CGestisciPrenotazione() {}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return CGestisciPrenotazione Instanza unica di questa classe
	 */
    public static CGestisciPrenotazione getInstance() {
    	if(instance == null) {
            instance = new CGestisciPrenotazione();
         }
         return instance;
    }
    /* --------------------------------- Metodi di instanza -------------------------------------- */
    /**
     * Metodo per creare una nuova prenotazione
     * @throws IOException 
     */
	public void creaNuovaPrenotazione() throws IOException {
		// Carico l'albergo mediante pattern Singleton
		_albergo = MAlbergo.getInstance();
		// Creo la nuova prenotazione
		_prenotazione = new MPrenotazione();
		// Creo l'arrayList nel quale si vanno ad inserire le tipologie di camere note.
		ArrayList<String> tipologieCamere = new ArrayList<String>();
		tipologieCamere.addAll(_albergo.get_catalogoCamere().get_descrizioniCamere().keySet());
		// Nascondo VFrameHome e mostro VFrameCreaPrenotazioneStep1
		VFrameHome.getInstance().setVisible(false);
		VFrameCreaPrenotazioneStep_1 frameCreaPrenotazione1 = VFrameCreaPrenotazioneStep_1.getInstance();
		frameCreaPrenotazione1.creaFrame(tipologieCamere);
		frameCreaPrenotazione1.setVisible(true);
		
	}
	/**
	 * Metodo per aggiungere una Camera alla prenotazione ed ottenere il totale di quest'ultima.
	 * @param numeroCamera Stringa contenente il numero della camera.
	 * @return Costo totale della prenotazione in seguito all'aggiunta della camera.
	 */
	public double aggiungiCameraAllaPrenotazione(String numeroCamera) {
		MCamera camera = null;
		// Ricavo la MCamera a partire dalla stringa contenente il suo numero.
		camera = _albergo.getCameraDaNumero(numeroCamera);
		// Aggiungo la camera all'elemento prenotazione
		_prenotazione.addCamera(camera);
		// Restituisco il totale della prenotazione in seguito all'aggiunta della camera
		return _prenotazione.getTotal();
	}
	/**
	 * Metodo per ricercare le camere libere nell'albergo, appartenenti a tipologie differenti.
	 * 
	 * @param DataInizio Data di inizio ricerca.
	 * @param DataFine Data di fine ricerca
	 * @param Tipologie Tipologie di camere da ricercare.
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
	 * Metodo per concludere una prenotazione.
	 * 
	 * @param nome Nome dell'ospite.
	 * @param cognome Cognome dell'ospite.
	 * @param email e-Mail dell'ospite.
	 * @param telefono Telefono dell'ospite.
	 */
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono) {
		// Aggiungo l'ospite alla prenotazione
		_prenotazione.addPrenotante(nome, cognome, eMail, telefono);
		// Occupo le camere scelte dall'utente
		_prenotazione.occupaCamere();
		// Stampo l'elenco di stati della camera
		LinkedList<MStatoCamera> stati = new LinkedList<MStatoCamera>();
		stati=_prenotazione.get_camerePrenotate().get(0).get_statiCamera();
		for (Iterator<MStatoCamera> iterator = stati.iterator(); iterator.hasNext();) {
			MStatoCamera mStatoCamera = (MStatoCamera) iterator.next();
			System.out.println("Inizio: " + mStatoCamera.get_periodo().get_giornoInizio() + " " + mStatoCamera.get_periodo().get_meseInizio());
			System.out.println("Fine: " + mStatoCamera.get_periodo().get_giornoFine() + " " + mStatoCamera.get_periodo().get_meseFine());
		}
		// Setto la prenotazione come completata
		_prenotazione.set_completata(true);
		// Aggiungo la prenotazione all'albergo
		_albergo.addPrenotazione(_prenotazione);
		// Salvataggio degli oggetti da Ram -> Persistenza.
		try {
			//PCamera.getInstance().store(_albergo.get_camere());	
			PPrenotazione.getInstance().store(_prenotazione);
		} finally {
			PPrenotazione.getInstance().close();
		}
	}
	/* -------------------------- Getter, Setter -------------------- */
	/**
	 * @return _albergo
	 */
	public MAlbergo get_albergo() {
		return _albergo;
	}

	/**
	 * @param _albergo
	 */
	public void set_albergo(MAlbergo _albergo) {
		this._albergo = _albergo;
	}
	/**
	 * @return _prenotazione
	 */
	public MPrenotazione get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione
	 */
	public void set_prenotazione(MPrenotazione _prenotazione) {
		this._prenotazione = _prenotazione;
	}

}
