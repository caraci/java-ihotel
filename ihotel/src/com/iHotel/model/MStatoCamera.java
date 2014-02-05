package com.iHotel.model;

public class MStatoCamera {

	private MPeriodo _periodo;
	private boolean _libera;

	/**
	 * @return the _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}

	public boolean get_libera() {
		return this._libera;
	}

	/**
	 * 
	 * @param _libera
	 */
	public void set_libera(boolean _libera) {
		this._libera = _libera;
	}

}