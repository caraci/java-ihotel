package com.iHotel.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.MyDate;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.VFrameHome;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.GestionePrenotazione.VFGP_AggiungiServiziInterni;
import com.iHotel.view.GestionePrenotazione.VFGP_InfoCamera;
import com.iHotel.view.GestionePrenotazione.VFGP_InfoPrenotazione;
import com.iHotel.view.GestionePrenotazione.VFGP_RicercaPrenotazioneDaCodice;

public class CModificaPrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private static CModificaPrenotazione instance = null;
	private PrenotazioneSubject _prenotazione;
	private CameraContext _camera;
	private String _codiceServizio;
	private Albergo _albergo;

	/**
	 * Costruttore privato - pattern Singleton
	 * @throws IOException 
	 */
	private CModificaPrenotazione() throws IOException {
		_albergo=Albergo.getInstance();
	}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * @throws IOException 
	 */
    public static CModificaPrenotazione getInstance() throws IOException {
    	if(instance == null) {
            instance = new CModificaPrenotazione();
         }
         return instance;
    }
	/* ------------------------- Metodi di instanza ---------------------------------- */
    
    /**
     * Metodo che termina l'aggiunta dei servizi e restituisce la schermata precedente
     */
    public void terminaAggiuntaServiziCamera(){
    	// Mostro l'interfaccia relativa alla camera, utilizzando il metodo del controllore.
    	gestioneCamera(_camera.get_numero());
    }
    /**
     * Metodo che conclude la gestione della camera
     */
    public void terminaGestioneCamera(){
    	// Mostro l'interfaccia relativa alla camera, utilizzando il metodo del controllore.
    	recuperaPrenotazioneDaCodice(_prenotazione.get_codice());
    }
    /**
     * Metodo che conclude la gestione della prenotazione
     */
    public void terminaGestionePrenotazione(){
    	// Creo l'interfaccia iniziale.
    	VFrameHome frameHome=VFrameHome.getInstance();
    	frameHome.creaFrame();
    	// Mostro l'interfaccia iniziale.
    	ViewHandler.getInstance().showFrame(frameHome);
    }
    /**
     * Metodo per aggiungere un servizio alla camera selezionata, relativa alla prenotazione che si sta
     * modificando.
     * @param dataServizio Data per il quale si richiede il servizio interno.
     */
    public void aggiungiServizio(MyDate dataServizio){
    	// Creo il nuovo oggetto di tipo ServizioInterno
    	ServizioInterno servizioInterno = new ServizioInterno();
    	servizioInterno.set_codice(_codiceServizio);
    	servizioInterno.set_data(dataServizio);
    	// Ricavo il periodo della prenotazione
    	Periodo periodo = _prenotazione.get_periodo();
    	// Aggiungo il servizio interno alla Camera che si sta gestendo, fornendo periodo e servizio.
    	_camera.aggiungiServizioInPeriodo(servizioInterno, periodo);
    }
    /**
     * Metodo per mostrare l'interfaccia per aggiungere nuovi servizi alla camera della prenotazione.
     */
    public void aggiungiServiziCamera(){
    	VFGP_AggiungiServiziInterni aggiungiServiziInterni = VFGP_AggiungiServiziInterni.getInstance();
    	// Creo l'interfaccia fornendo l'insieme di descrittori dei servizi interni
    	aggiungiServiziInterni.creaFrame(CatalogoServiziInterni.getInstance().get_descrizioneServizi());
    	// Mostro vfgpAggiungiServiziInterni
    	ViewHandler.getInstance().showFrame(aggiungiServiziInterni);
    }
    /**
     * Metodo per mostrare le informazioni relative ad un servizio interno.
     * @param codiceServizio Codice del servizio da mostrare
     */
    public DescrizioneServizioInterno scegliServizioDaCodice(String codiceServizio){
    	// Setto il codice del servizio scelto come attributo del controllore
    	_codiceServizio=codiceServizio;
    	// Fornisco il descrittore all'interfaccia.
    	return CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(_codiceServizio);
    }
    /**
     * Metodo per mostrare l'interfaccia 
     */
	public void gestionePrenotazione() {
		VFGP_RicercaPrenotazioneDaCodice ricercaPrenotazioneDaCodice = VFGP_RicercaPrenotazioneDaCodice.getInstance();
		ricercaPrenotazioneDaCodice.creaFrame();
		ViewHandler.getInstance().showFrame(ricercaPrenotazioneDaCodice);
	}
	/**
	 * Metodo per mostrare l'interfaccia per la gestione della prenotazione, relativa al codice fornito.
	 * @param codicePrenotazione Codice della prenotazione da caricare.
	 */
	public void recuperaPrenotazioneDaCodice(String codicePrenotazione) {
		// Recupero la prenotazione dallo storico.
		_prenotazione=Storico.getInstance().recuperaPrenotazioneDaCodice(codicePrenotazione);
		// Recupero il prezzo dei servizi esterni della prenotazione.
		Prezzo prezzo=_albergo.getPrezzoServiziEsterniPrenotazione(_prenotazione);
		
		VFGP_InfoPrenotazione infoPrenotazione=VFGP_InfoPrenotazione.getInstance();
		// Creo l'interfaccia relativa alla prenotazione
		infoPrenotazione.creaFrame(_prenotazione,prezzo);
		// Mostro l'interfaccia relativa alla gestione della prenotazione
		ViewHandler.getInstance().showFrame(infoPrenotazione);
	}

	/**
	 * Metodo per mostrare l'interfaccia contenente le informazioni sulla camera, relativa al numero fornito. 
	 * @param numeroCamera 
	 */
	public void gestioneCamera(String numeroCamera) {
		// Ricavo la camera da visualizzare e la salvo come attributo del controllore.
		_camera=_albergo.getCameraDaNumero(numeroCamera);
		// Ricavo il periodo della prenotazione.
		Periodo periodo = _prenotazione.get_periodo();
		// Ricavo i servizi esterni della camera nel periodo della prenotazione.
		ArrayList<ServizioEsterno> serviziEsterni = _albergo.getElencoServiziEsterniCameraInPeriodo(_camera,periodo);
		// Preparo l'interfaccia da visualizzare
		VFGP_InfoCamera infoCamera = VFGP_InfoCamera.getInstance();
		infoCamera.creaFrame(_camera, serviziEsterni);
		// Visualizzo la nuova interfaccia.
		ViewHandler.getInstance().showFrame(infoCamera);
	}
	/* ----------------------- Getter, Setter -------------------------- */

	public PrenotazioneSubject get_prenotazione() {
		return this._prenotazione;
	}

	public void set_prenotazione(PrenotazioneSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

	public CameraContext get_numeroCamera() {
		return this._camera;
	}

	public void set_numeroCamera(CameraContext _numeroCamera) {
		this._camera = _numeroCamera;
	}
	/**
	 * @return the _codiceServizio
	 */
	public String get_codiceServizio() {
		return _codiceServizio;
	}
	/**
	 * @param _codiceServizio the _codiceServizio to set
	 */
	public void set_codiceServizio(String _codiceServizio) {
		this._codiceServizio = _codiceServizio;
	}

}