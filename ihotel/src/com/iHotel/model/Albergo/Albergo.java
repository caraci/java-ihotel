package com.iHotel.model.Albergo;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Utility.Periodo;
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
	private ArrayList<Camera> _camere;
	
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
	 * Metodo per ricavare l'oggetto MCamera a partire dalla stringa contenente il suo numero.
	 * 
	 * @param numeroCamera Stringa contenente il numero della camera da ricavare.
	 * @return cameraRicercata Camera che ha il numero passato come parametro.
	 */
	public Camera getCameraDaNumero(String numeroCamera) {
		Camera cameraRicercata = null;
		for (Iterator<Camera> iterator = _camere.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
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
	public ArrayList<Camera> cercaCamereLibereInPeriodoDaTipologia(Periodo periodo, String tipologia){
		ArrayList<Camera> lista_camere = new ArrayList<Camera>();
		for (Iterator<Camera> iterator = _camere.iterator(); iterator.hasNext();) {
			Camera camera = iterator.next();
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
	public ArrayList<Camera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere
	 */
	public void set_camere(ArrayList<Camera> _camere) {
		this._camere = _camere;
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