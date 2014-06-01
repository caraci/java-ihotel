/**
 * 
 */
package com.iHotel.model.Persona.Documenti;

import com.iHotel.model.Persona.Persona;

/**
 * Classe che modella una carta di credito.
 * 
 * @author Alessandro
 */
public class CartaDiCredito {
	
	/**
	 * Titolare della carta di credito o bancomat.
	 */
	private Persona _titolare;
	/**
	 * Numero della carta di credito o bancomat.
	 */
	private String _numero;
	
	/**
	 * Costruttore di default.
	 */
	public CartaDiCredito() {}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param titolare Titolare della carta di credito
	 * @param numero Numero della carta di credito
	 */
	public CartaDiCredito(Persona titolare,String numero){
		this.set_titolare(titolare);
		this.set_numero(numero);
	}
	/**
	 * @return the _titolare
	 */
	public Persona get_titolare() {
		return _titolare;
	}
	/**
	 * @param _titolare the _titolare to set
	 */
	public void set_titolare(Persona _titolare) {
		this._titolare = _titolare;
	}
	/**
	 * @return the _numero
	 */
	public String get_numero() {
		return _numero;
	}
	/**
	 * @param _numero the _numero to set
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
	}
	

}
