/**
 * 
 */
package com.iHotel.model.Persona;

/**
 * Classe che modella una persona del mondo reale, in modo semplice, con pochi attributi
 * @author Alessandro
 *
 */
public class Persona {
	
	/*Attributi e costruttore*/
	private String _nome;
	private String _cognome;
	//Recapiti
	private String _eMail;
	private String _telefono;
	
	//Costruttore di default
	public Persona(){
		
	}
	
	/**
	 * Costruttore della persona con nome e cognome 
	 * @param nome Nome della persona
	 * @param cognome Cognome della persona
	 * @param email Indirizzo email della persona
	 * @param telefono Numero di telefono della persona
	 */
	public Persona(String nome, String cognome, String email, String telefono){
		this.set_nome(nome);
		this.set_cognome(cognome);
		this.set_eMail(email);
		this.set_telefono(telefono);
	}

	/**
	 * @return the _nome
	 */
	public String get_nome() {
		return _nome;
	}

	/**
	 * @param _nome the _nome to set
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	/**
	 * @return the _cognome
	 */
	public String get_cognome() {
		return _cognome;
	}

	/**
	 * @param _cognome the _cognome to set
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
	

}
