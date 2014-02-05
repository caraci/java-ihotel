package com.iHotel.model;

import java.util.*;

public class MCatalogoCamere {

	private HashMap<String,MDescrizioneCamera> _descrizioniCamere;

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

}