package com.iHotel.model;



public class MPrezzoCamera {

	private MPeriodo _periodo;
	private double _prezzo;
	

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
	public double get_prezzo() {
		return this._prezzo;
	}

	/**
	 * 
	 * @param _prezzo
	 */
	public void set_prezzo(double _prezzo) {
		this._prezzo = _prezzo;
	}

	public MPeriodo get_periodo() {
		return _periodo;
	}

	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	

}