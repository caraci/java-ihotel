package com.iHotel.model;

import java.util.*;

public class MDescrizioneCamera {

	private ArrayList<MPrezzoCamera> _prezziCamera;
	private String _tipologia;


	/**
	 * @return the _prezziCamera
	 */
	public ArrayList<MPrezzoCamera> get_prezziCamera() {
		return _prezziCamera;
	}

	/**
	 * @param _prezziCamera the _prezziCamera to set
	 */
	public void set_prezziCamera(ArrayList<MPrezzoCamera> _prezziCamera) {
		this._prezziCamera = _prezziCamera;
	}

	/**
	 * 
	 * @param periodo
	 */
	public void getPrezzoCamera(MPeriodo periodo) {
		// TODO - implement MDescrizioneCamera.getPrezzoCamera
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodo
	 * @param tipologie
	 */
	public void isLibera(MPeriodo periodo, java.util.List<java.lang.String> tipologie) {
		// TODO - implement MDescrizioneCamera.isLibera
		throw new UnsupportedOperationException();
	}

	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * 
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}

}