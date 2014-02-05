package com.iHotel.model;

public class MOspite {

	private String _nome;
	private String _cognome;
	private String eMail;
	private String telefono;

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

	public String getEMail() {
		return this.eMail;
	}

	/**
	 * 
	 * @param eMail
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}