package com.iHotel.model.ForeignSystem.Telephone;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Questa classe ha il compito di descrivere il servizio esterno di "Telefono in camera" in tutte le sue caratteristiche.
 * 
 * @author Alessandro
 */
public class ServizioTelefono {
	//TODO al momento la classe risulta essere vuota, poichè per il caso d'uso in questione non 
	//è stato necessario modellare completamente il servizio di "Telefono in camera".
	private String _codice;
	private String _telefonoMittente;
	private String _telefonoDestinatario;
	private Prezzo _prezzo;
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
	 * @return the _telefonoMittente
	 */
	public String get_telefonoMittente() {
		return _telefonoMittente;
	}
	/**
	 * @param _telefonoMittente the _telefonoMittente to set
	 */
	public void set_telefonoMittente(String _telefonoMittente) {
		this._telefonoMittente = _telefonoMittente;
	}
	/**
	 * @return the _telefonoDestinatario
	 */
	public String get_telefonoDestinatario() {
		return _telefonoDestinatario;
	}
	/**
	 * @param _telefonoDestinatario the _telefonoDestinatario to set
	 */
	public void set_telefonoDestinatario(String _telefonoDestinatario) {
		this._telefonoDestinatario = _telefonoDestinatario;
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