/**
 * 
 */
package com.iHotel.model.ForeignSystem;

import com.iHotel.model.Utility.MyDate;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public class ServizioEsterno {
	/*----------------------- Attributi e costruttore -----------------------*/
	private String _codice;
	private Prezzo _prezzo;
	private String _descrizione;
	private MyDate _data;
	
	public ServizioEsterno(){
		
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
	 * @return the _data
	 */
	public MyDate get_data() {
		return _data;
	}

	/**
	 * @param _data the _data to set
	 */
	public void set_data(MyDate _data) {
		this._data = _data;
	}

}
