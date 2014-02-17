package com.iHotel.model;

import java.util.*;

public class MCatalogoCamere {

	/* ----------------------------------- Attributi e costruttore ---------------------------------- */
	
	private HashMap<String,MDescrizioneCamera> _descrizioniCamere=new HashMap<String,MDescrizioneCamera>();
	// Singleton
	private static MCatalogoCamere instance = null;
	
	/**
	 * Costruttore privato - pattern singleton
	 */
	private MCatalogoCamere() {}
	
	/* ---------------------------- Metodi di classe ----------------------------- */	
	
	public static MCatalogoCamere getInstance() {
    	if(instance == null) {
            instance = new MCatalogoCamere();
         }
         return instance;
    }
	
	/* --------------------------- Metodi di instanza --------------------------------- */
	
	/**
	 * Metodo che restituisce tutte le camere di una tipologia con i relativi prezzi in un determinato periodo
	 * 
	 * @param periodo	 Periodo in cui si prendono i prezzi di una tipologia
	 * @param tipologia	 Tipologia di camera di cui si vuole il prezzo in un periodo
	 * @return			 Mappa contenente l'insieme dei prezzi relativi a tipologie di camere differenti.
	 */
	public HashMap<String,ArrayList<MPrezzoCamera>> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		// Ricavo la descrizione della camera a partire dalla tipologia.
		MDescrizioneCamera descrizioneCamera = getDescrizioneDaTipologia(tipologia);
		// Creo una mappa nella quale andrò a salvare tutti i prezzi nel formato . <k,v> = <tipologia, ArrayList<MPrezzoCamera>
		HashMap<String,ArrayList<MPrezzoCamera>> mappaPrezziCamera  = new HashMap<String,ArrayList<MPrezzoCamera>>();
		mappaPrezziCamera.put(tipologia, descrizioneCamera.getPrezziInPeriodo(periodo));
		return mappaPrezziCamera;
	}
	
	/**
	 * Metodo che restituisce la descrizione della camera di una specifica tipologia
	 * 
	 * @param	tipologia	Tipologia di camera di cui si vuole avere la descrizione
	 */
	public MDescrizioneCamera getDescrizioneDaTipologia(String tipologia){
		return _descrizioniCamere.get(tipologia);
	}
	
	/* ------------------------------- Getter e Setter -------------------------- */
	
	/**
	 * @return  _descrizioniCamere 
	 */
	public HashMap<String,MDescrizioneCamera> get_descrizioniCamere() {
		return _descrizioniCamere;
	}

	/**
	 * @param _descrizioniCamere 
	 */
	public void set_descrizioniCamere(HashMap<String,MDescrizioneCamera> _descrizioniCamere) {
		this._descrizioniCamere = _descrizioniCamere;
	}
}