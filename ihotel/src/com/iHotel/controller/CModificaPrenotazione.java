package com.iHotel.controller;


import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.persistence.PCamera;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.VP_Home;
import com.iHotel.view.Graphic.GestionePrenotazione.VPGP_AggiungiServiziInterni;
import com.iHotel.view.Graphic.GestionePrenotazione.VPGP_InfoCamera;
/**
 * Questa classe rappresenta il controllore che ha il compito di gestire il caso d'uso "Modifica Prenotazione"
 * @author Alessandro
 *
 */
public class CModificaPrenotazione extends CGestionePrenotazione {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	/**
	 * Attributo privato - Pattern Singleton
	 */
	private static CModificaPrenotazione instance = null;
	/**
	 * Attributo che mantiene la maniglia alla camera che si sta gestendo, all'interno della prenotazione corrente
	 */
	private Camera _camera;

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
	 * Metodo per mostrare l'interfaccia contenente le informazioni sulla camera, relativa al numero fornito. 
	 * @param numeroCamera 
	 */
	public void gestioneCamera(String numeroCamera) {
		// Ricavo la camera da visualizzare e la salvo come attributo del controllore.
		_camera=_albergo.getCameraDaNumero(numeroCamera);
		// Ricavo il periodo della prenotazione.
		Periodo periodo = _prenotazione.get_periodo();
		
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPGP_InfoCamera infoCamera = new VPGP_InfoCamera();
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(infoCamera);
		// Creo il frame
		infoCamera.creaPanel(_camera, periodo);
	}
	/**
     * Metodo per mostrare l'interfaccia per aggiungere nuovi servizi alla camera della prenotazione.
     */
	public void aggiungiServiziCamera(){
		//VPGP_AggiungiServiziInterni aggiungiServiziInterni = VPGP_AggiungiServiziInterni.getInstance();
		// Creo l'interfaccia fornendo l'insieme di descrittori dei servizi interni
		//aggiungiServiziInterni.creaPanel(CatalogoServiziInterni.getInstance().get_descrizioneServizi(), _camera);
		// Mostro vfgpAggiungiServiziInterni
		//ViewHandler.getInstance().showFrame(aggiungiServiziInterni);
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
    	// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VP_Home panelHome = new VP_Home();
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(panelHome);
		// Creo il frame
		panelHome.creaPanel();
    }
	/* ----------------------- Getter, Setter -------------------------- */

    /**
	 * @return the _prenotazione
	 */
	public SoggiornoContextSubject get_prenotazione() {
		return _prenotazione;
	}
	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(SoggiornoContextSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}
	/**
	 * @return the _camera
	 */
	public Camera get_camera() {
		return _camera;
	}
	/**
	 * @param _camera the _camera to set
	 */
	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}
}