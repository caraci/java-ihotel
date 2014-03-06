package com.iHotel.model;

import java.util.*;

import com.iHotel.model.Utility.MPeriodo;

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
	 * Metodo che restituisce tutti i prezzi di una tipologia, in un determinato periodo.
	 * 
	 * @param periodo Periodo in cui si prendono i prezzi di una tipologia.
	 * @param tipologia Tipologia di camera di cui si vuole il prezzo in un periodo.
	 * @return Collezione contenente l'insieme dei prezzi relativi ad una tipologia di camera.
	 */
	public ArrayList<MPrezzoCamera> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		// Ricavo la descrizione della camera a partire dalla tipologia.
		MDescrizioneCamera descrizioneCamera = getDescrizioneDaTipologia(tipologia);	
		return descrizioneCamera.getPrezziInPeriodo(periodo);
	}
	
	/**
	 * Metodo che restituisce la descrizione della camera di una specifica tipologia.
	 * 
	 * @param tipologia	Tipologia di camera di cui si vuole avere la descrizione.
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