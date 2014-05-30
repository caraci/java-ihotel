package com.iHotel.controller;


import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.persistence.PCamera;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Access.ViewPanelFactory;
import com.iHotel.view.Graphic.VP_Home;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoCamera;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno;
import com.iHotel.view.Graphic.GestioneSoggiorno.CheckIn.VPC_AggiungiOspiti;
/**
 * Questa classe rappresenta il controllore che ha il compito di gestire il caso d'uso "Modifica Prenotazione"
 * @author Alessandro
 *
 */
public class CModificaSoggiorno {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	/**
	 * Attributo privato - Pattern Singleton
	 */
	private static CModificaSoggiorno instance = null;
	/**
	 * Attributo che mantiene la maniglia alla camera che si sta gestendo, all'interno della prenotazione corrente
	 */
	private Camera _camera;

	/**
	 * Prenotazione che si sta gestendo.
	 */
	private SoggiornoContextSubject _soggiorno;
	
	/**
	 * Albergo che si sta analizzando.
	 */
	private Albergo _albergo;
	
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CModificaSoggiorno() {
		_albergo=Albergo.getInstance();
	}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
    public static CModificaSoggiorno getInstance() {
    	if(instance == null) {
            instance = new CModificaSoggiorno();
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
		Periodo periodo = _soggiorno.get_periodo();
		
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPGP_InfoCamera infoCamera = ViewPanelFactory.getPanelInfoCamera(_soggiorno);
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(infoCamera);
		// Creo il frame
		infoCamera.creaPanel(_camera, periodo);
	}
	/**
     * Metodo che aggiunge un servizio interno alla camera selezionata.
     *    
     * @param servizio E' il servizio interno creato.
     */
    public void aggiungiServizio(ServizioInterno servizio){
    	//Recuper il periodo della prenotazione
    	Periodo periodo = _soggiorno.get_periodo();
    	//Aggiungo il servizio alla camera, nel periodo della prenotazione
    	_camera.aggiungiServizioInPeriodo(servizio, periodo);
    	
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
    	recuperaPrenotazioneDaCodice(_soggiorno.get_codice());
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
    
	/**
	 * Metodo per caricare la finestra per effettuare il checkIn.
	 */
	public void aggiungiOspitiAllaPrenotazione() {
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPC_AggiungiOspiti aggiungiOspiti = new VPC_AggiungiOspiti();
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(aggiungiOspiti);
		// Creo il frame
		aggiungiOspiti.creaPanel(_soggiorno);
	}
	/**
	 * Metodo per aggiungere un ospite alla camera.
	 * 
	 * @param camera Camera alla quale si vuole aggiungere l'ospite.
	 * @param ospite Ospite da aggiungere alla camera.
	 */
	public void aggiungiOspite(Camera camera, Ospite ospite) {
		// Periodo nel quale aggiungiamo l'ospite
		Periodo periodo = _soggiorno.get_periodo();
		// Aggiungo l'ospite alla camera
		camera.aggiungiOspiteInPeriodo(ospite, periodo);
		// Salvo nel db lo stato camera in seguito all'aggiornamento.
    	PCamera.getInstance().store(camera.getStatoCameraInPeriodo(periodo));
	}
	/**
	 * Metodo per terminare il checkIn per la camera.
	 */
	public void effettuaCheckIn() {
		// Effettuo il check in per il soggiorno
		_soggiorno.effettuaCheckIn();
		// Salvo nel db il soggiorno in seguito al cambio di stato
		PPrenotazione.getInstance().store(_soggiorno);		
	}
	/**
	 * Metodo per terminare il checkIn per la camera.
	 */
	public void effettuaCheckOut() {
		// Effettuo il check in per il soggiorno
		_soggiorno.effettuaCheckOut();
		// Salvo nel db il soggiorno in seguito al cambio di stato
		PPrenotazione.getInstance().store(_soggiorno);
		// Torno alla gestione della prenotazione
		this.recuperaPrenotazioneDaCodice(_soggiorno.get_codice());
	}
	/**
	 * Metodo per tornare alla gestione della prenotazione.
	 */
	public void tornaAllaPrenotazione() {
		// Fornisco la prenotazione de gestire a CModificaPrenotazione
		this.recuperaPrenotazioneDaCodice(_soggiorno.get_codice());
	}
	/**
	 * Metodo per mostrare l'interfaccia per la gestione del soggiorno, relativo al codice fornito.
	 * 
	 * @param codiceSoggiorno Codice della soggiorno da caricare.
	 */
	public void recuperaPrenotazioneDaCodice(String codiceSoggiorno) {
		// Recupero la prenotazione dallo storico.
		_soggiorno=Storico.getInstance().recuperaSoggiornoDaCodice(codiceSoggiorno);		
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPGP_InfoSoggiorno infoPrenotazione = ViewPanelFactory.getPanelInfoSoggiorno(_soggiorno);
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(infoPrenotazione);
		// Creo il frame
		infoPrenotazione.creaPanel(_soggiorno);
	}
    
	/* ----------------------- Getter, Setter -------------------------- */

    /**
	 * @return the _prenotazione
	 */
	public SoggiornoContextSubject get_soggiorno() {
		return _soggiorno;
	}
	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_soggiorno(SoggiornoContextSubject _prenotazione) {
		this._soggiorno = _prenotazione;
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
	/**
	 * @return the _albergo
	 */
	public Albergo get_albergo() {
		return _albergo;
	}

	/**
	 * @param _albergo the _albergo to set
	 */
	public void set_albergo(Albergo _albergo) {
		this._albergo = _albergo;
	}
}