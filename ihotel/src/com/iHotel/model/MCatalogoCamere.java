package com.iHotel.model;

import java.util.*;

public class MCatalogoCamere {

	// Attributi
	private HashMap<String,MDescrizioneCamera> _descrizioniCamere;
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
		for (Map.Entry<String, MDescrizioneCamera> entry : _descrizioniCamere.entrySet()) {
			if (entry.getKey().equals(tipologia)){		    
				return entry.getValue();
			}		    
		}
		return null;
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
	 * @param periodo
	 * @param tipologie
	 */
	public void getPrezziCamere(MPeriodo periodo, java.util.List<java.lang.String> tipologie) {
		// TODO - implement MCatalogoCamere.getPrezziCamere
		throw new UnsupportedOperationException();
	}
	/*
	 * 
	 * @param  periodo
	 * @param tipologia
	 */
	public HashMap<String,ArrayList<MPrezzoCamera>> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		HashMap<String,ArrayList<MPrezzoCamera>> p  = new HashMap<String,ArrayList<MPrezzoCamera>>();
		return p;
	}
	
	

}