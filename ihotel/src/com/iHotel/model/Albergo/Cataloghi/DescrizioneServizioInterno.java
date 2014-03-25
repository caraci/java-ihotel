package com.iHotel.model.Albergo.Cataloghi;

import java.util.LinkedList;

public class DescrizioneServizioInterno {
	
	/*-------------------------- Attributi --------------------------*/
	private String _codice;
	private String _descrizione;
	private LinkedList<PrezzoServizioInterno> _prezziServizio;
	
	/*-------------------------- Getter e setter --------------------------*/

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
	 * @return the _prezziServizio
	 */
	public LinkedList<PrezzoServizioInterno> get_prezziServizio() {
		return _prezziServizio;
	}
	/**
	 * @param _prezziServizio the _prezziServizio to set
	 */
	public void set_prezziServizio(LinkedList<PrezzoServizioInterno> _prezziServizio) {
		this._prezziServizio = _prezziServizio;
	}

}