package com.iHotel.model;

public class MPrezzoCamera {

	private MPeriodo _periodo;
	private int _prezzo;

	public int get_prezzo() {
		return this._prezzo;
	}

	/**
	 * 
	 * @param _prezzo
	 */
	public void set_prezzo(int _prezzo) {
		this._prezzo = _prezzo;
	}

	public MPeriodo get_periodo() {
		return _periodo;
	}

	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	/*
	 * 
	 * @param periodo
	 */
	public MPrezzoCamera getPrezzoInPeriodo(MPeriodo periodo){
		return this;
	}

}