/**
 * 
 */
package com.iHotel.model.Persona;

import com.iHotel.model.Persona.Documenti.CartaDiCredito;

/**
 * Classe che modella una persona che effettua una prenotazione
 * @author Alessandro
 *
 */
public class ClientePrenotante extends Cliente{
	
	/*Attributi e costruttore*/
	
	private CartaDiCredito _cartaDiCredito;
	/**
	 * eMail del prenotante.
	 */
	private String _email;
	/**
	 * Telefono del prenotante.
	 */
	private String _telefono;
	/**
	 * Numero delle prenotazioni effettuate dal cliente.
	 */
	private int _numeroPrenotazioni;
	
	/**
	 * Costruttore di deufalt. 
	 */
	public ClientePrenotante(){
		set_numeroPrenotazioni(0);
		set_cartaDiCredito(null);
	}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param nome Nome del cliente prenotante
	 * @param cognome Cognome del cliente prenotante
	 * @param codice Codice del cliente prenotante
	 * @param email Email del cliente prenotante
	 * @param telefono Telefono del cliente prenotante
	 * @param cartaDiCredito Carta di credito del cliente prenotante
	 */
	public ClientePrenotante(String nome, String cognome, String codice, String email, String telefono, CartaDiCredito cartaDiCredito){
		super(nome,cognome,codice);
		this.set_email(email);
		this.set_telefono(telefono);
		this.set_cartaDiCredito(cartaDiCredito);
	}

	/**
	 * @return the _codiceCartaDiCredito
	 */
	public CartaDiCredito get_codiceCartaDiCredito() {
		return _cartaDiCredito;
	}

	/**
	 * @param _codiceCartaDiCredito the _codiceCartaDiCredito to set
	 */
	public void set_cartaDiCredito(CartaDiCredito _cartaDiCredito) {
		this._cartaDiCredito = _cartaDiCredito;
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

	/**
	 * @return the _numeroPrenotazioni
	 */
	public int get_numeroPrenotazioni() {
		return _numeroPrenotazioni;
	}

	/**
	 * @param _numeroPrenotazioni the _numeroPrenotazioni to set
	 */
	public void set_numeroPrenotazioni(int _numeroPrenotazioni) {
		this._numeroPrenotazioni = _numeroPrenotazioni;
	}
	

}
