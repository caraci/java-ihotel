package com.iHotel.model.ForeignSystem.PayTv;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Questa classe ha il compito di descrivere il servizio esterno di "Pay tv" in tutte le sue caratteristiche.
 * 
 * @author Alessandro
 */
public class ServizioPayTv {
	/**
	 * Codice del servizio payTv.
	 */
	private String _codice;
	/**
	 * Stringa contenente la descrizione dell'evento.
	 */
	private String _evento;
	/**
	 * Prezzo del servizio.
	 */
	private Prezzo _prezzo;
	/**
	 * Giorno del servizio.
	 */
	private Giorno _giorno;
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
	 * @return the _evento
	 */
	public String get_evento() {
		return _evento;
	}
	/**
	 * @param _evento the _evento to set
	 */
	public void set_evento(String _evento) {
		this._evento = _evento;
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