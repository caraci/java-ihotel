package com.iHotel.model.ForeignSystem.Telephone;

public class ServizioTelefono {
	/* -------------------- Attributi -------------------------------- */
	private String _codice;
	private String _descrizione;
	private int _durata;
	private double _prezzo;
	/* --------------------- Getter, Setter ---------------------------- */
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
	 * @return the _durata
	 */
	public int get_durata() {
		return _durata;
	}
	/**
	 * @param _durata the _durata to set
	 */
	public void set_durata(int _durata) {
		this._durata = _durata;
	}
	/**
	 * @return the _prezzo
	 */
	public double get_prezzo() {
		return _prezzo;
	}
	/**
	 * @param _prezzo the _prezzo to set
	 */
	public void set_prezzo(double _prezzo) {
		this._prezzo = _prezzo;
	}

}