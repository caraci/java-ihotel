package com.iHotel.model;

import java.util.*;

public class MCatalogoCamere {

	// Attributi
	private HashMap<String,MDescrizioneCamera> _descrizioniCamere=new HashMap<String,MDescrizioneCamera>();
	// Singleton
	private static MCatalogoCamere instance = null;
	
	/**
	 * Costruttore privato - pattern singleton
	 */
	private MCatalogoCamere() {}
	
	// Metodi di classe	
	public static MCatalogoCamere getInstance() {
    	if(instance == null) {
            instance = new MCatalogoCamere();
         }
         return instance;
    }
	
	// Metodi di instanza
	// Getter, Setter
	public MDescrizioneCamera getDescrizioneDaTipologia(String tipologia){
		return _descrizioniCamere.get(tipologia);
	}
	/**
	 * @return the _descrizioniCamere
	 */
	public HashMap<String,MDescrizioneCamera> get_descrizioniCamere() {
		return _descrizioniCamere;
	}

	/**
	 * @param _descrizioniCamere the _descrizioniCamere to set
	 */
	public void set_descrizioniCamere(HashMap<String,MDescrizioneCamera> _descrizioniCamere) {
		this._descrizioniCamere = _descrizioniCamere;
	}

	
	/**
	 * 
	 * @param  periodo
	 * @param tipologia
	 */
	public HashMap<String,ArrayList<MPrezzoCamera>> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		// Ricavo la descrizione della camera a partire dalla tipologia.
		MDescrizioneCamera descrizioneCamera = getDescrizioneDaTipologia(tipologia);
		// Creo una mappa nella quale andrò a salvare tutti i prezzi nel formato . <k,v> = <tipologia, ArrayList<MPrezzoCamera>
		HashMap<String,ArrayList<MPrezzoCamera>> mappaPrezziCamera  = new HashMap<String,ArrayList<MPrezzoCamera>>();
		mappaPrezziCamera.put(tipologia, descrizioneCamera.getPrezziInPeriodo(periodo));
		return mappaPrezziCamera;
	}
	
	

}