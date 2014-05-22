/**
 * 
 */
package com.iHotel.model.Albergo;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Ora;

/**
 * Questa classe serve a modellare un servizio interno all'albergo, per cui la struttura ricettiva
 * non si appoggia a sistemi esterni di gestione. (e.g.: fiori in camera, champagne in camera).
 * 
 * @author Alessandro
 */
public class ServizioInterno {
	
	/*----------------------- Attributi e costruttore -----------------------*/
	private String _codice;	
	private Giorno _giorno;	
	private String _note;
	private Ora _ora;
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
	 * @return the _giorno
	 */
	public Giorno get_giorno() {
		return _giorno;
	}

	/**
	 * @param _giorno the _giorno to set
	 */
	public void set_giorno(Giorno _giorno) {
		this._giorno = _giorno;
	}

	/**
	 * @return the _note
	 */
	public String get_note() {
		return _note;
	}

	/**
	 * @param _note the _note to set
	 */
	public void set_note(String _note) {
		this._note = _note;
	}

}
