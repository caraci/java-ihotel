/**
 * 
 */
package com.iHotel.model.Persona;

/**
 * Classe che modella una persona che effettua una prenotazione
 * @author Alessandro
 *
 */
public class ClientePrenotante extends Cliente{
	
	/*Attributi e costruttore*/
	private String _codiceCartaDiCredito;
	private String _email;
	private String _telefono;
	
	//Costruttore di default
	public ClientePrenotante(){
		
	}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param nome 					Nome del cliente prenotante
	 * @param cognome				Cognome del cliente prenotante
	 * @param codice				Codice del cliente prenotante
	 * @param email					Email del cliente prenotante
	 * @param telefono				Telefono del cliente prenotante
	 * @param codiceCartaDiCredito	Codice della carta di credito del cliente prenotante
	 */
	public ClientePrenotante(String nome, String cognome, String codice, String email, String telefono, String codiceCartaDiCredito){
		super(nome,cognome,codice);
		this.set_email(email);
		this.set_telefono(telefono);
		this.set_codiceCartaDiCredito(codiceCartaDiCredito);
	}

	/**
	 * @return the _codiceCartaDiCredito
	 */
	public String get_codiceCartaDiCredito() {
		return _codiceCartaDiCredito;
	}

	/**
	 * @param _codiceCartaDiCredito the _codiceCartaDiCredito to set
	 */
	public void set_codiceCartaDiCredito(String _codiceCartaDiCredito) {
		this._codiceCartaDiCredito = _codiceCartaDiCredito;
	}
	/**
	 * @return the _email
	 */
	public String get_email() {
		return _email;
	}
	/**
	 * @param _email the _email to set
	 */
	public void set_email(String _email) {
		this._email = _email;
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
