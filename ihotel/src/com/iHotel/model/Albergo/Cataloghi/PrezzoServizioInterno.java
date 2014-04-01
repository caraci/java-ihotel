package com.iHotel.model.Albergo.Cataloghi;


import com.iHotel.model.Utility.*;

public class PrezzoServizioInterno {

	/* -------------------------- Attributi ----------------------------------- */
	private Periodo _periodo;
	private Prezzo _prezzo;
	/* -------------------------- Metodi di instanza ----------------------------------- */
	
	/**
	 * Metodo per ottenere il prezzo relativo al servizio, se il periodo di richiesta è contenuto
	 * in quello dell'instanza su cui si invoca il metodo.
	 * @param periodoRichiesta Periodo di richiesta
	 * @return Prezzo relativo al servizo se il periodo è valido. Null altrimenti.
	 */
	public Prezzo getPrezzoInData(MyDate dataServizio) {
		Prezzo prezzo = null;
		
		return prezzo;
	}
	
	/* -------------------------- Getter, Setter ----------------------------------- */
	/**
	 * @return the _periodo
	 */
	public Periodo get_periodo() {
		return _periodo;
	}
	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * @return the _prezzo
	 */
	public Prezzo get_prezzo() {
		return _prezzo;
	}
	/**
	 * @param _prezzo the _prezzo to set
	 */
	public void set_prezzo(Prezzo _prezzo) {
		this._prezzo = _prezzo;
	}

}