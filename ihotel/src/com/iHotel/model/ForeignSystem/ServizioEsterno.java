/**
 * 
 */
package com.iHotel.model.ForeignSystem;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Questa classe ha il compito di modellare un servizio esterno. Viene utilizzata per riassumere le caratteristiche
 * comuni che hanno i possibili servizi esterni all'albergo.
 * 
 * @author Alessandro
 */
public class ServizioEsterno {
	/*----------------------- Attributi e costruttore -----------------------*/
	private String _codice;
	private Prezzo _prezzo;
	private String _descrizione;
	
	private Giorno _giorno;
	/**
	 * Costruttore.
	 */
	public ServizioEsterno(){}
	
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

	/**
	 * @return the _descrizione
	 */
	public String get_descrizione() {
		return _descrizione;
	}

	/**
	 * @param _descrizione the _descrizione to set
	 */
	public void set_descrizione(String _descrizione) {
		this._descrizione = _descrizione;
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

}
