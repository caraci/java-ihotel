/**
 * 
 */
package com.iHotel.model.Persona;

/**
 * Classe che modella un cliente della struttura ricettiva.
 * 
 * @author Alessandro
 */
public class Cliente extends Persona {
	
	/**
	 * Codice del cliente.
	 */
	private String _codiceCliente;
	
	/**
	 * Costruttore di default.
	 */
	public Cliente() {}
	/**
	 * Costruttore con parametri.
	 * 
	 * @param nome Nome del cliente	
	 * @param cognome Cognome del cliente
	 * @param codice Codice del cliente
	 */
	public Cliente(String nome, String cognome, String codice){
		super(nome,cognome);
		this.set_codiceCliente(codice);
	}

	/**
	 * @return the _codiceCliente
	 */
	public String get_codiceCliente() {
		return _codiceCliente;
	}

	/**
	 * @param _codiceCliente the _codiceCliente to set
	 */
	public void set_codiceCliente(String _codiceCliente) {
		this._codiceCliente = _codiceCliente;
	}
	

}
