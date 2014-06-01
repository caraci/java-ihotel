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
	/**
	 * Codice del servizio interno.
	 */
	private String _codice;	
	/**
	 * Giorno del servizio.
	 */
	private Giorno _giorno;
	/**
	 * Orario del servizio.
	 */
	private Ora _ora;
	/**
	 * Note sul servizio.
	 */
	private String _note;

	/**
	 * Costruttore di default
	 */
	public ServizioInterno(){}
	
	/**
	 * Costruttore.
	 * 
	 * @param codice Codice del servizio.
	 * @param giorno Giorno in cui è stato richiesto il servizio.
	 * @param note Sono le informazioni aggiuntive utili per fornire il servizio.
	 * @param ora Ora cui bisogna fornire il servizio.
	 */
	public ServizioInterno(String codice, Giorno giorno, String note, Ora ora){
		set_codice(codice);
		set_giorno(giorno);
		set_note(note);
		set_ora(ora);
	}
	
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

	/**
	 * @return the _ora
	 */
	public Ora get_ora() {
		return _ora;
	}

	/**
	 * @param _ora the _ora to set
	 */
	public void set_ora(Ora _ora) {
		this._ora = _ora;
	}

}