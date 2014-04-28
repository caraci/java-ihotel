/**
 * 
 */
package com.iHotel.model.Albergo;

import com.iHotel.model.Utility.Periodo;

/**
 * Questa classe serve a modellare un servizio interno all'albergo, per cui la struttura ricettiva
 * non si appoggia a sistemi esterni di gestione. (e.g.: fiori in camera, champagne in camera)
 * @author Alessandro
 *
 */
public class ServizioInterno {
	
	/*----------------------- Attributi e costruttore -----------------------*/
	private String _codice;
	/**ATTENZIONE!!! questo periodo ha lo stesso giorno di inizio e di fine, perchè modella una data. 
	 * Un servizio, infatti, è associato per un giorno particolare alla camera. 
	*/
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
