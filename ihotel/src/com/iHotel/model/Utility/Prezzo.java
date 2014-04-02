
package com.iHotel.model.Utility;

public class Prezzo {

	/* ----------------- Attributi --------------------- */
	private double _importo;
	private String _valuta;
	
	public Prezzo() {
		_importo = 0;
		_valuta = "Euro";
	}
	
	/* ----------------- Metodi di instanza --------------------- */

	public Prezzo somma(Prezzo prezzo){
		double importo = this.get_importo() + prezzo.get_importo();
		this.set_importo(importo);
		return this;
	}
	
	/* ----------------- Getter, Setter --------------------- */
	/**
	 * @return the _importo
	 */
	public double get_importo() {
		return _importo;
	}
	/**
	 * @param _importo the _importo to set
	 */
	public void set_importo(double _importo) {
		this._importo = _importo;
	}
	/**
	 * @return the _valuta
	 */
	public String get_valuta() {
		return _valuta;
	}
	/**
	 * @param _valuta the _valuta to set
	 */
	public void set_valuta(String _valuta) {
		this._valuta = _valuta;
	}

}