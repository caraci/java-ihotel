package com.iHotel.model.Albergo;

import com.iHotel.model.Utility.Periodo;

public class PrezzoCamera {

	/* -------------------------- Attributi ------------------------------- */
	private Periodo _periodo;
	private double _prezzo;
	
	/* ---------------------- Metodi di instanza --------------------------- */ 
	/**
	 * Metodo per farsi restituire un MPrezzoCamera, se il periodo passato come parametro, ha almeno un giorno in comune 
	 * con quello relativo all'oggetto su cui si invoca il metodo.
	 * 
	 * @param periodo Periodo per il quale si vuole ottenere l' MPrezzoCamera corretto.
	 * @return MPrezzoCamera relativo al periodo inserito.
	 */
	public PrezzoCamera getPrezzoInPeriodo(Periodo periodo){
		if(this.get_periodo().contiene(periodo) || this.get_periodo().sovrappone(periodo)) {
			return this;
		} else{
			return null;
		}
	}
	/* ------------------------------------- Getter, Setter ------------------------------- */
	/**
	 * @return double
	 */
	public double get_prezzo() {
		return this._prezzo;
	}

	/**
	 * @param _prezzo
	 */
	public void set_prezzo(double _prezzo) {
		this._prezzo = _prezzo;
	}

	/**
	 * @return double
	 */
	public Periodo get_periodo() {
		return _periodo;
	}
	
	/** 
	 * @param _periodo 
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
	

}