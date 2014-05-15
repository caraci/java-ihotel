/**
 * 
 */
package com.iHotel.model.Persona;

/**
 * Classe che modella una persona che effettua una prenotazione
 * @author Alessandro
 *
 */
public class ClientePrenotante extends Persona{
	
	/*Attributi e costruttore*/
	private String _codiceCartaDiCredito;
	
	//Costruttore di default
	public ClientePrenotante(){
		
	}
	/**
	 * Costruttore di un cliente prenotante con tutti gli attributi
	 * @param nome della persona che sta effettuando la prenotazione
	 * @param cognome della persona che sta effettuando la prenotazione
	 * @param codiceCartaDiCredito codice della carta di credito della persona che sta effettuando la prenotazione:
	 * 		  In alcuni casi può essere null, se la carta di credito non è richiesta.
	 */
	public ClientePrenotante(String nome, String cognome,String email, String telefono, String codiceCartaDiCredito){
		super(nome,cognome,email,telefono);
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

}
