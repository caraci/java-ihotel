package com.iHotel.controller;

import java.util.ArrayList;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.persistence.PCamera;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.Graphic.VFrameHome;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_AggiungiServiziInterni;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_InfoCamera;
import com.iHotel.view.Graphic.GestionePrenotazione.VFPG_InfoPrenotazione;
/**
 * Questa classe rappresenta il controllore che ha il compito di gestire il caso d'uso "Modifica Prenotazione"
 * @author Alessandro
 *
 */
public class CModificaPrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	/**
	 * Attributo privato - Pattern Singleton
	 */
	private static CModificaPrenotazione instance = null;
	/**
	 * Attributo che mantiene la maniglia alla prenotazione che si sta modificando
	 */
	private PrenotazioneSubject _prenotazione;
	/**
	 * Attributo che mantiene la maniglia alla camera che si sta gestendo, all'interno della prenotazione corrente
	 */
	private CameraContext _camera;
	private Albergo _albergo;

	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CModificaPrenotazione() {
		_albergo=Albergo.getInstance();
	}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
    public static CModificaPrenotazione getInstance() {
    	if(instance == null) {
            instance = new CModificaPrenotazione();
         }
         return instance;
    }
	/* ------------------------- Metodi di instanza ---------------------------------- */
    
	/**
	 * Metodo per mostrare l'interfaccia per la gestione della prenotazione, relativa al codice fornito.
	 * @param codicePrenotazione Codice della prenotazione da caricare.
	 */
	public void recuperaPrenotazioneDaCodice(String codicePrenotazione) {
		// Recupero la prenotazione dallo storico.
		_prenotazione=Storico.getInstance().recuperaPrenotazioneDaCodice(codicePrenotazione);
		// Recupero il prezzo dei servizi esterni della prenotazione.
		Prezzo prezzo=_albergo.getPrezzoServiziEsterniPrenotazione(_prenotazione);
		// Prendo l'interfaccia correlata.
		VFPG_InfoPrenotazione infoPrenotazione = VFPG_InfoPrenotazione.getInstance();
		// Creo l'interfaccia relativa alla prenotazione
		infoPrenotazione.creaFrame(_prenotazione, prezzo);		
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
		infoCamera.creaFrame(_camera,_prenotazione, serviziEsterni);
		// Visualizzo la nuova interfaccia.
		ViewHandler.getInstance().showFrame(infoCamera);
	}
	/**
     * Metodo per mostrare l'interfaccia per aggiungere nuovi servizi alla camera della prenotazione.
     */
	public void aggiungiServiziCamera(){
		VFGP_AggiungiServiziInterni aggiungiServiziInterni = VFGP_AggiungiServiziInterni.getInstance();
		// Creo l'interfaccia fornendo l'insieme di descrittori dei servizi interni
		aggiungiServiziInterni.creaFrame(CatalogoServiziInterni.getInstance().get_descrizioneServizi(), _camera);
		// Mostro vfgpAggiungiServiziInterni
		ViewHandler.getInstance().showFrame(aggiungiServiziInterni);
	}
    /**
     * Metodo per aggiungere un servizio alla camera selezionata, relativa alla prenotazione che si sta
     * modificando.
     * 
     * @param dataServizio Data per il quale si richiede il servizio interno.
     * @param codiceServizio Codice del servizio da mostrare
     */
    public void aggiungiServizio(Giorno dataServizio, String codiceServizio){
    	// Creo il nuovo oggetto di tipo ServizioInterno
    	ServizioInterno servizioInterno = new ServizioInterno();
    	servizioInterno.set_codice(codiceServizio);
    	// Aggiungo la data al servizio.
    	servizioInterno.set_giorno(dataServizio);
    	// Ricavo il periodo della prenotazione
    	Periodo periodo = _prenotazione.get_periodo();
    	// Aggiungo il servizio interno alla Camera che si sta gestendo, fornendo periodo e servizio.
    	_camera.aggiungiServizioInPeriodo(servizioInterno, periodo);
    	
    	// Salvo nel db lo stato camera in seguito all'aggiornamento.
    	PCamera.getInstance().store(_camera.getStatoCameraInPeriodo(periodo));
    }	
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
	/* ----------------------- Getter, Setter -------------------------- */

    /**
	 * @return the _prenotazione
	 */
	public PrenotazioneSubject get_prenotazione() {
		return _prenotazione;
	}
	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(PrenotazioneSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}
	/**
	 * @return the _camera
	 */
	public CameraContext get_camera() {
		return _camera;
	}
	/**
	 * @param _camera the _camera to set
	 */
	public void set_camera(CameraContext _camera) {
		this._camera = _camera;
	}
}