package com.iHotel.model.Albergo;

import com.iHotel.model.DocumentiIdentita.Documento;


/**
 * Questa classe rappresenta il concetto di "Ospite" di un albergo del modo reale.
 * @author Alessandro
 *
 */
public class Ospite{

	/* ----------------- Attributi e Costruttore -------------------- */
	private String _nome;
	private String _cognome;
	/** Documento associato all'ospite*/
	private Documento _documento;
	/*Recapiti*/
	private String _eMail;
	private String _telefono;

	public Ospite() {
		
	}
	/* ----------------- Getter, Setter ------------------------------*/
	/**
	 * @return _nome
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * @param _nome
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * @return _cognome
	 */
	public String get_cognome() {
		return this._cognome;
	}

	/**
	 * @param _cognome
	 */
	public void set_cognome(String _cognome) {
		this._cognome = _cognome;
	}
	/**
	 * @return _eMail
	 */
	public String get_eMail() {
		return _eMail;
	}
	/**
	 * @param _eMail
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}
	/**
	 * @return _telefono
	 */
	public String get_telefono() {
		return _telefono;
	}
	/**
	 * @param _telefono
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}
	/**
	 * @return the _documento
	 */
	public Documento get_documento() {
		return _documento;
	}
	/**
	 * @param _documento the _documento to set
	 */
	public void set_documento(Documento _documento) {
		this._documento = _documento;
	}

}