package com.iHotel.model;

import java.util.Currency;

public class MPrezzoCamera {

	private MPeriodo _periodo;
	private Currency _prezzo;
	

	/**
	 * 
	 * @param periodo
	 */
	public MPrezzoCamera getPrezzoInPeriodo(MPeriodo periodo){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Currency get_prezzo() {
		return this._prezzo;
	}

	/**
	 * 
	 * @param _prezzo
	 */
	public void set_prezzo(Currency _prezzo) {
		this._prezzo = _prezzo;
	}

	public MPeriodo get_periodo() {
		return _periodo;
	}

	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	

}