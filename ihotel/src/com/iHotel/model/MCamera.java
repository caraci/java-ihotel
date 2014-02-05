package com.iHotel.model;

import java.util.*;

public class MCamera {

	private Collection<MStatoCamera> _statiCamera;
	private String _numero;
	private String _tipologia;

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