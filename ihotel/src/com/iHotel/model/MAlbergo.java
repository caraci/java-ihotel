package com.iHotel.model;

import java.io.IOException;
import java.util.*;

import com.iHotel.utility.UDefaultLoader;


public class MAlbergo {
    
	/* -------------------- Attributi e costruttore --------------------------*/
	
 	private MCatalogoCamere _catalogoCamere;
 	private MStorico _storico;
	private ArrayList<MCamera> _camere;
	private String _nome;
	private String _telefono;
	private String _PIVA;
	private String _eMail;
	// Singleton 
	private static MAlbergo instance = null;
	
	/**
	 * Costruttore privato - pattern Singleton
	 * @throws IOException 
	 */
	private MAlbergo() throws IOException {
		/*
		 * Si prendono nome, telefono, partita IVA e email dal defaultLoader, togliendo dalla classe  
		 * MAlbergo la responsabilità di recuperare i dati di default.
		 */
		UDefaultLoader defaultLoader = UDefaultLoader.getInstance();
        ArrayList<String> informazioniAlbergo = new ArrayList<String>();
        informazioniAlbergo =defaultLoader.getInformazioniAlbergo();
        _nome = informazioniAlbergo.get(0);
        _telefono = informazioniAlbergo.get(1);
        _PIVA = informazioniAlbergo.get(2);
        _eMail=informazioniAlbergo.get(3);


	}
	
	/* ----------------------------- Metodi di classe -----------------------*/
	
	/**
	 * 
	 * @return instance
	 * @throws IOException 
	 */
	public static MAlbergo getInstance() throws IOException {
    	if(instance == null) {
            instance = new MAlbergo();
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
	public MCamera getCameraDaNumero(String numeroCamera) {
		MCamera cameraRicercata = null; // = new MCamera();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera camera = (MCamera) iterator.next();
			if (camera.get_numero().equals(numeroCamera)) {
				cameraRicercata = camera;
			}
		}
		return cameraRicercata;
	}
	/**
	 * Restituisce una lista di camere libere data una tipologia e un periodo.
	 * 
	 * @param periodo il periodo per cui si vogliono ricercare le camere libere
	 * @param tipologia è la tipologia delle camere da ricercare
	 * @return lista_camere lista contenente le camere libere della tipologia indicata, nel periodo indicato
	 */
	public ArrayList<MCamera> cercaCamereLibereInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		ArrayList<MCamera> lista_camere = new ArrayList<MCamera>();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera camera = iterator.next();
			if (camera.get_tipologia().equals(tipologia)){
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
	public MCatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}

	/**
	 * @param _catalogoCamere 
	 */
	public void set_catalogoCamere(MCatalogoCamere _catalogoCamere) {
		this._catalogoCamere = _catalogoCamere;
	}


	/**
	 * @return the _storico
	 */
	public MStorico get_storico() {
		return _storico;
	}

	/**
	 * @param _storico the _storico to set
	 */
	public void set_storico(MStorico _storico) {
		this._storico = _storico;
	}

	/**
	 * @return _camere
	 */
	public ArrayList<MCamera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere
	 */
	public void set_camere(ArrayList<MCamera> _camere) {
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