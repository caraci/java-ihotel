package com.iHotel.controller;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.VP_Home;
import com.iHotel.view.Graphic.CreaPrenotazione.VPCP_SelezioneCamereDatiOspite_Observer;
import com.iHotel.view.Graphic.CreaPrenotazione.VPCP_SelezionePeriodoTipologie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Questa classe rappresenta il controllore che ha il compito di gestire il caso d'uso "Crea Prenotazione"
 * @author Alessandro
 *
 */
public class CCreaPrenotazione extends CGestionePrenotazione {
	
	/* -------------------------------- Attributi e costruttore -------------------------------*/
	/**
	 * Attributo privato - Pattern Singleton
	 */
	private static CCreaPrenotazione instance = null;
    
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CCreaPrenotazione() {
		this.set_albergo(Albergo.getInstance());
	}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
    public static CCreaPrenotazione getInstance() {
    	if(instance == null) {
            instance = new CCreaPrenotazione();
         }
         return instance;
    }
    /* --------------------------------- Metodi di instanza -------------------------------------- */
    /**
     * Metodo per creare una nuova prenotazione
     */
	public void creaNuovaPrenotazione() {
		// Creo la nuova prenotazione
		_prenotazione = new SoggiornoContextSubject();
		// Creo l'arrayList nel quale si vanno ad inserire le tipologie di camere note.
		ArrayList<String> tipologieCamere = new ArrayList<String>();
		tipologieCamere.addAll(CatalogoCamere.getInstance().getTipologieCamere());
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPCP_SelezionePeriodoTipologie selezionePeriodoTipologie = new VPCP_SelezionePeriodoTipologie();
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(selezionePeriodoTipologie);
		// Creo il frame
		selezionePeriodoTipologie.creaPanel(tipologieCamere);	
	}
	/**
	 * Metodo per aggiungere una camera alla prenotazione.
	 * 
	 * @param numeroCamera Stringa contenente il numero della camera che si vuole aggiungere.
	 */
	public void aggiungiCameraAllaPrenotazione(String numeroCamera) {
		// Ricavo la Camera a partire dalla stringa contenente il suo numero.
		Camera camera = _albergo.getCameraDaNumero(numeroCamera);
		// Aggiungo la camera all'elemento prenotazione
		_prenotazione.addCamera(camera);
	}
	/**
	 * Metodo per ricercare le camere libere nell'albergo, appartenenti a tipologie differenti.
	 * 
	 * @param dataInizio Data di inizio ricerca.
	 * @param dataFine Data di fine ricerca.
	 * @param Tipologie Tipologie di camere da ricercare.
	 */
	public void cercaCamereLibere(Giorno dataInizio, Giorno dataFine, ArrayList<String> Tipologie) {
		
		/* Setto il periodo ricevuto dall'interfaccia */
		Periodo periodo = new Periodo(dataInizio,dataFine);
		/* Setto il periodo alla prenotazione */
		_prenotazione.set_periodo(periodo);
		// Struttura dati nella quale andremo a salvare le camera libere suddivise per tipologia.
		HashMap<String, ArrayList<Camera>> camereLibere = _albergo.cercaCamereLibereInPeriodoDaTipologie(periodo, Tipologie);		
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPCP_SelezioneCamereDatiOspite_Observer selezioneCamereDatiOspite = new VPCP_SelezioneCamereDatiOspite_Observer();
		// Per il pattern Observer aggiungo l'observer alla prenotazione.
		_prenotazione.Attach((IObserver) selezioneCamereDatiOspite);
		// Per il pattern Observer aggiungo il subject all'observer.
		selezioneCamereDatiOspite.set_prenotazioneSubject(_prenotazione);
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(selezioneCamereDatiOspite);
		// Creo il frame
		selezioneCamereDatiOspite.creaPanel(camereLibere);	
	}
	/**
	 * Metodo per concludere una prenotazione.
	 * 
	 * @param nome Nome dell'ospite.
	 * @param cognome Cognome dell'ospite.
	 * @param eMail e-Mail dell'ospite.
	 * @param telefono Telefono dell'ospite.
	 */
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono) {
		// Rimuovo l'osservatore dalla prenotazione.
		_prenotazione.Detach((IObserver) ViewFrameApplication.getInstance().get_pnlAttuale());
		// Concludo la richiesta di soggiorno
		_prenotazione.concludiPrenotazione(nome, cognome, eMail, telefono);
		// Aggiungo la prenotazione allo storico
		Storico storico = Storico.getInstance();
		storico.addPrenotazione(_prenotazione);
		// Salvataggio degli oggetti da Ram -> Persistenza.
		try {
			PPrenotazione.getInstance().store(_prenotazione);
		} catch(Exception e) {
			// TODO
		}
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VP_Home panelHome = new VP_Home();
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(panelHome);
		// Creo il frame
		panelHome.creaPanel();
	}
	/* -------------------------- Getter, Setter -------------------- */
	/**
	 * @return _albergo
	 */
	public Albergo get_albergo() {
		return _albergo;
	}

	/**
	 * @param _albergo
	 */
	public void set_albergo(Albergo _albergo) {
		this._albergo = _albergo;
	}
	/**
	 * 
	 * @return _prenotazione
	 */
	public SoggiornoContextSubject get_prenotazione() {
		return this._prenotazione;
	}
	/**
	 * 
	 * @param _prenotazione
	 */
	public void set_prenotazione(SoggiornoContextSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

}
