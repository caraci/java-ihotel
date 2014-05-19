package com.iHotel.controller;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.Graphic.VFrameHome;
import com.iHotel.view.Graphic.CreaPrenotazione.VFCP_SelezioneCamereDatiOspite_Observer;
import com.iHotel.view.Graphic.CreaPrenotazione.VFCP_SelezionePeriodoTipologie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
     * @throws IOException 
     */
	public void creaNuovaPrenotazione() {
		// Creo la nuova prenotazione
		_prenotazione = new PrenotazioneSubject();
		// Creo l'arrayList nel quale si vanno ad inserire le tipologie di camere note.
		ArrayList<String> tipologieCamere = new ArrayList<String>();
		tipologieCamere.addAll(CatalogoCamere.getInstance().getTipologieCamere());
		// Mostro VFrameCreaPrenotazioneStep1
		VFCP_SelezionePeriodoTipologie frameCreaPrenotazione1 = VFCP_SelezionePeriodoTipologie.getInstance();
		frameCreaPrenotazione1.creaFrame(tipologieCamere);
		ViewHandler.getInstance().showFrame(frameCreaPrenotazione1);
		
	}
	/**
	 * Metodo per aggiungere una camera alla prenotazione.
	 * @param numeroCamera Stringa contenente il numero della camera che si vuole aggiungere.
	 */
	public void aggiungiCameraAllaPrenotazione(String numeroCamera) {
		CameraContext camera = null;
		// Ricavo la MCamera a partire dalla stringa contenente il suo numero.
		camera = _albergo.getCameraDaNumero(numeroCamera);
		// Aggiungo la camera all'elemento prenotazione
		_prenotazione.addCamera(camera);
		// Calcolo il nuovo totale
		_prenotazione.calcolaTotale();
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
		Periodo periodo = new Periodo();
		/* Setto la data di inizio */
		periodo.set_dataInizio(dataInizio);
		/* Setto la data di fine*/
		periodo.set_dataFine(dataFine);
		/* Setto il periodo alla prenotazione */
		_prenotazione.set_periodo(periodo);
		// Struttura dati nella quale andremo a salvare le camera libere suddivise per tipologia.
		HashMap<String, ArrayList<CameraContext>> camereLibere = new HashMap<String, ArrayList<CameraContext>>();
		
		// Ciclo sulle tipologie
		for (Iterator<String> iterator = Tipologie.iterator(); iterator.hasNext();) {
			String tipologia = iterator.next();
			// Struttura dati nella quale si inseriranno le camere disponibili.
			ArrayList<CameraContext> camereLibereTipologia = new ArrayList<CameraContext>();	
			// Inserisco nella lista le camere disponibili.
			camereLibereTipologia = _albergo.cercaCamereLibereInPeriodoDaTipologia(periodo, tipologia);		
			// Aggiungo le camere appartenenti ad una tipologia
			camereLibere.put(tipologia, camereLibereTipologia);
		}	
		VFCP_SelezioneCamereDatiOspite_Observer frameCreaPrenotazioneStep_2 = VFCP_SelezioneCamereDatiOspite_Observer.getInstance();
		// Per il pattern Observer aggiungo l'observer alla prenotazione.
		_prenotazione.Attach((IObserver) frameCreaPrenotazioneStep_2);
		// Per il pattern Observer aggiungo il subject all'observer.
		frameCreaPrenotazioneStep_2.set_prenotazioneSubject(_prenotazione);
		// Mostro finestra Step 2
		frameCreaPrenotazioneStep_2.creaFrame(camereLibere);			
		ViewHandler.getInstance().showFrame(frameCreaPrenotazioneStep_2);
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
		// Aggiungo l'ospite alla prenotazione
		_prenotazione.addPrenotante(nome, cognome, eMail, telefono);
		// Occupo le camere scelte dall'utente
		_prenotazione.occupaCamere();
		// Setto la prenotazione come completata
		_prenotazione.set_completata(true);
		// Setto il codice alla prenotazione
		_prenotazione.set_codice(PrenotazioneSubject.generaCodice());
		// Aggiungo la prenotazione allo storico
		Storico storico = Storico.getInstance();
		storico.addPrenotazione(_prenotazione);
		// Rimuovo l'observer dal subject
		VFCP_SelezioneCamereDatiOspite_Observer frameCreaPrenotazioneStep_2 = VFCP_SelezioneCamereDatiOspite_Observer.getInstance();
		_prenotazione.Detach((IObserver) frameCreaPrenotazioneStep_2);
		// Salvataggio degli oggetti da Ram -> Persistenza.
		try {
			PPrenotazione.getInstance().store(_prenotazione);
		} catch(Exception e) {
			// TODO
		}
		// Torno alla schermata iniziale.
		VFrameHome frameHome = VFrameHome.getInstance();
		frameHome.creaFrame();
		ViewHandler.getInstance().showFrame(frameHome);
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
	public PrenotazioneSubject get_prenotazione() {
		return this._prenotazione;
	}
	/**
	 * 
	 * @param _prenotazione
	 */
	public void set_prenotazione(PrenotazioneSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

}
