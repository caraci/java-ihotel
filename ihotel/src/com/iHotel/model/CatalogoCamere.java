package com.iHotel.model;

import java.util.*;

import com.iHotel.model.Utility.Periodo;

public class CatalogoCamere {

	/* ----------------------------------- Attributi e costruttore ---------------------------------- */
	
	private HashMap<String,DescrizioneCamera> _descrizioniCamere=new HashMap<String,DescrizioneCamera>();
	// Singleton
	private static CatalogoCamere instance = null;
	
	/**
	 * Costruttore privato - pattern singleton
	 */
	private CatalogoCamere() {}
	
	/* ---------------------------- Metodi di classe ----------------------------- */	
	
	public static CatalogoCamere getInstance() {
    	if(instance == null) {
            instance = new CatalogoCamere();
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
	public ArrayList<PrezzoCamera> getPrezziInPeriodoDaTipologia(Periodo periodo, String tipologia){
		// Ricavo la descrizione della camera a partire dalla tipologia.
		DescrizioneCamera descrizioneCamera = getDescrizioneDaTipologia(tipologia);	
		return descrizioneCamera.getPrezziInPeriodo(periodo);
	}
	
	/**
	 * Metodo che restituisce la descrizione della camera di una specifica tipologia.
	 * 
	 * @param tipologia	Tipologia di camera di cui si vuole avere la descrizione.
	 */
	public DescrizioneCamera getDescrizioneDaTipologia(String tipologia){
		return _descrizioniCamere.get(tipologia);
	}
	
	/* ------------------------------- Getter e Setter -------------------------- */
	
	/**
	 * @return  _descrizioniCamere 
	 */
	public HashMap<String,DescrizioneCamera> get_descrizioniCamere() {
		return _descrizioniCamere;
	}

	/**
	 * @param _descrizioniCamere 
	 */
	public void set_descrizioniCamere(HashMap<String,DescrizioneCamera> _descrizioniCamere) {
		this._descrizioniCamere = _descrizioniCamere;
	}
}