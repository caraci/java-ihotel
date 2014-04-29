package com.iHotel.model.Albergo;

import java.util.*;

import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.ForeignSystem.IServiceSystem;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.utility.UDefaultLoader;

/**
 * Questa classe rappresenta il concetto di "Albergo" del mondo reale.
 * @author Alessandro
 *
 */
public class Albergo {
    
	/* -------------------- Attributi e costruttore --------------------------*/
	
 	private CatalogoCamere _catalogoCamere;
 	private CatalogoServiziInterni _catalogoServiziInterni;
 	private Storico _storico;
	private ArrayList<CameraContext> _camere;
	/**
	 * Mantiene le maniglie ai sistemi esterni cui l'albergo si poggia per la gestione dei servizi esterni e.g.: telefono e pay tv
	 */
	private ArrayList<IServiceSystem> _sistemiServiziEsterni;
	
	private String _nome;
	private String _telefono;
	private String _PIVA;
	private String _eMail;
	// Attributo privato - Pattern Singleto 
	private static Albergo instance = null;
	
	
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private Albergo() {
		/*
		 * Si prendono nome, telefono, partita IVA e email dal defaultLoader, togliendo dalla classe  
		 * MAlbergo la responsabilità di recuperare i dati di default.
		 */
		UDefaultLoader defaultLoader = UDefaultLoader.getInstance();
        ArrayList<String> informazioniAlbergo;
        informazioniAlbergo=defaultLoader.getInformazioniAlbergo();
        _nome = informazioniAlbergo.get(0);
        _telefono = informazioniAlbergo.get(1);
        _PIVA = informazioniAlbergo.get(2);
        _eMail=informazioniAlbergo.get(3);
        // Ricavo dalla factory tutti i sistemi esterni addetti alla gestione dei servizi.
        _sistemiServiziEsterni=ServiceFactory.getInstance().getSistemiServiziEsterni();
	}
	
	/* ----------------------------- Metodi di classe -----------------------*/
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton
	 * @return instance
	 */
	public static Albergo getInstance() {
    	if(instance == null) {
            instance = new Albergo();
         }
         return instance;
    }
	/* -------------------- Metodi di instanza ----------------------*/
	/**
	 * Metodo per ottenere tutti i servizi esterni di una camera in un periodo.
	 * 
	 * @param camera Camera da analizzare.
	 * @param periodo Periodo di richiesta.
	 * @return Lista di servizi relativi ad una camera
	 */
	public ArrayList<ServizioEsterno> getElencoServiziEsterniCameraInPeriodo(CameraContext camera, Periodo periodo){
		ArrayList<ServizioEsterno> serviziEsterniCamera = new ArrayList<ServizioEsterno>();
		// Ciclo sui sistemi di servizi esterni
		for (Iterator<IServiceSystem> iterator = _sistemiServiziEsterni.iterator(); iterator.hasNext();) {
			IServiceSystem sistemaServiziEsterno = (IServiceSystem) iterator.next();
			// Aggiungo i servizi esterni dovuti allo specifico sistema esterno.
			serviziEsterniCamera.addAll(sistemaServiziEsterno.getElencoServiziCameraInPeriodo(camera,periodo));
		}
		return serviziEsterniCamera;
	}
	/**
	 * Metodo per ottenere il prezzo dei servizi esterni correlati ad una prenotazione.
	 * 
	 * @param prenotazione Prenotazione da analizzare.
	 * @return Prezzo totale dei servizi esterni correlati ad una prenotazione.
	 */
	public Prezzo getPrezzoServiziEsterniPrenotazione(PrenotazioneSubject prenotazione){
		Prezzo prezzo = new Prezzo();
		// Ciclo sui sistemi di servizi esterni
		for (Iterator<IServiceSystem> iterator = _sistemiServiziEsterni.iterator(); iterator.hasNext();) {
			IServiceSystem sistemaServiziEsterno = (IServiceSystem) iterator.next();
			// Sommo il totale dei prezzi dovuti alla prenotazione
			prezzo.somma(sistemaServiziEsterno.getPrezzoTotaleServiziPrenotazione(prenotazione));
		}
		return prezzo;
	}
	/**
	 * Metodo per ricavare l'oggetto MCamera a partire dalla stringa contenente il suo numero.
	 * 
	 * @param numeroCamera Stringa contenente il numero della camera da ricavare.
	 * @return cameraRicercata Camera che ha il numero passato come parametro.
	 */
	public CameraContext getCameraDaNumero(String numeroCamera) {
		CameraContext cameraRicercata = null;
		for (Iterator<CameraContext> iterator = _camere.iterator(); iterator.hasNext();) {
			CameraContext camera = (CameraContext) iterator.next();
			if (camera.get_numero().equals(numeroCamera)) {
				cameraRicercata = camera;
			}
		}
		return cameraRicercata;
	}
	/**
	 * Restituisce una lista di camere libere di una tipologia e in un periodo.
	 * 
	 * @param periodo Periodo per cui si vogliono ricercare le camere libere.
	 * @param tipologia Tipologia delle camere da ricercare.
	 * @return Lista contenente le camere libere della tipologia indicata, nel periodo indicato.
	 */
	public ArrayList<CameraContext> cercaCamereLibereInPeriodoDaTipologia(Periodo periodo, String tipologia){
		ArrayList<CameraContext> lista_camere = new ArrayList<CameraContext>();
		for (Iterator<CameraContext> iterator = _camere.iterator(); iterator.hasNext();) {
			CameraContext camera = iterator.next();
			// Controllo se la tipologia della camera è uguale a quella per cui stiamo cercando informazioni
			if (camera.get_tipologia().equals(tipologia)){
				// Controllo se la camera è libera nel periodo richiesto.
				if(camera.isLiberaInPeriodo(periodo)==true){
					lista_camere.add(camera);
				}
			}
		}
		return lista_camere;
	}

	/*---------------------- Getter e Setter --------------------*/
	/**
	 * @return _catalogoCamere
	 */
	public CatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}

	/**
	 * @param _catalogoCamere 
	 */
	public void set_catalogoCamere(CatalogoCamere _catalogoCamere) {
		this._catalogoCamere = _catalogoCamere;
	}


	/**
	 * @return the _catalogoServizi
	 */
	public CatalogoServiziInterni get_catalogoServizi() {
		return _catalogoServiziInterni;
	}

	/**
	 * @param _catalogoServizi the _catalogoServizi to set
	 */
	public void set_catalogoServizi(CatalogoServiziInterni _catalogoServizi) {
		this._catalogoServiziInterni = _catalogoServizi;
	}

	/**
	 * @return the _storico
	 */
	public Storico get_storico() {
		return _storico;
	}

	/**
	 * @param _storico the _storico to set
	 */
	public void set_storico(Storico _storico) {
		this._storico = _storico;
	}

	/**
	 * @return _camere
	 */
	public ArrayList<CameraContext> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere
	 */
	public void set_camere(ArrayList<CameraContext> _camere) {
		this._camere = _camere;
	}
	/**
	 * @return the _sistemiServiziEsterni
	 */
	public ArrayList<IServiceSystem> get_sistemiServiziEsterni() {
		return _sistemiServiziEsterni;
	}

	/**
	 * @param _sistemiServiziEsterni the _sistemiServiziEsterni to set
	 */
	public void set_sistemiServiziEsterni(ArrayList<IServiceSystem> _sistemiServiziEsterni) {
		this._sistemiServiziEsterni = _sistemiServiziEsterni;
	}

	/**
	 * @return _nome
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * @param _nome 
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * @return _telefono 
	 */
	public String get_telefono() {
		return this._telefono;
	}

	/**
	 * @param _telefono 
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}
	/**
	 * @return _PIVA 
	 */
	public String get_PIVA() {
		return this._PIVA;
	}

	/**
	 * @param _PIVA 
	 */
	public void set_PIVA(String _PIVA) {
		this._PIVA = _PIVA;
	}
	/**
	 * @return _email 
	 */
	public String get_eMail() {
		return this._eMail;
	}

	/**
	 * @param _eMail 
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}	 

}