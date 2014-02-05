package com.iHotel.model;

import java.util.*;

public class MCamera {

	private HashMap<MPeriodo, MStatoCamera> _statiCamera;
	private String _numero;
	private String _tipologia;

	/**
	 * @return the _statiCamera
	 */
	public HashMap<MPeriodo, MStatoCamera> get_statiCamera() {
		return _statiCamera;
	}

	/**
	 * @param _statiCamera the _statiCamera to set
	 */
	public void set_statiCamera(HashMap<MPeriodo, MStatoCamera> _statiCamera) {
		this._statiCamera = _statiCamera;
	}

	/**
	 * 
	 * @param periodo
	 * @param tipologia
	 */
	public void isLibera(MPeriodo periodo, java.util.List<java.lang.String> tipologia) {
		// TODO - implement MCamera.isLibera
		throw new UnsupportedOperationException();
	}

	public String get_numero() {
		return this._numero;
	}

	/**
	 * 
	 * @param _numero
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
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