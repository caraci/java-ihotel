package com.iHotel.model;

public class MOspite {

	private String _nome;
	private String _cognome;
	private String _eMail;
	private String _telefono;

	public MOspite (String nome, String cognome, String eMail, String telefono) {
		set_nome(nome);
		set_cognome(cognome);
		set_eMail(eMail);
		set_telefono(telefono);
	}
	/**
	 * 
	 * @return
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * 
	 * @param _nome
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * 
	 * @return
	 */
	public String get_cognome() {
		return this._cognome;
	}

	/**
	 * 
	 * @param _cognome
	 */
	public void set_cognome(String _cognome) {
		this._cognome = _cognome;
	}
	/**
	 * @return the _eMail
	 */
	public String get_eMail() {
		return _eMail;
	}
	/**
	 * @param _eMail the _eMail to set
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}
	/**
	 * @return the _telefono
	 */
	public String get_telefono() {
		return _telefono;
	}
	/**
	 * @param _telefono the _telefono to set
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}

}