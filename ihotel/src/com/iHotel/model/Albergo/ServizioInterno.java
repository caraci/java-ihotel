/**
 * 
 */
package com.iHotel.model.Albergo;

import com.iHotel.model.Utility.Periodo;

/**
 * @author Gabriele
 *
 */
public class ServizioInterno {
	
	/*----------------------- Attributi e costruttore -----------------------*/
	private String _codice;
	private Periodo _periodo;
	/**
	 * Costruttore.
	 */
	public ServizioInterno(){}
	
	/*----------------------- Setter e getter -----------------------*/
	/**
	 * @return the _codice
	 */
	public String get_codice() {
		return _codice;
	}

	/**
	 * @param _codice the _codice to set
	 */
	public void set_codice(String _codice) {
		this._codice = _codice;
	}

	/**
	 * @return the _data
	 */
	public Periodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _data the _data to set
	 */
	public void set_periodo(Periodo _data) {
		this._periodo = _data;
	}

}
