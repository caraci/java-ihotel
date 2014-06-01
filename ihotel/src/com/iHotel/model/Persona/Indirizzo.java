/**
 * 
 */
package com.iHotel.model.Persona;

/**
 * Questa classe rappresenta un indirizzo
 * @author Alessandro
 * 
 */
public class Indirizzo {
	
	/**
	 * Nome della via.
	 */
	private String _via;
	/**
	 * Civico della via.
	 */
	private int _civico;
	
	/**
	 * Costruttore di default.
	 */
	public Indirizzo() {}
	
	/**
	 * Costruttore con tutti i parametri
	 * 
	 * @param viaResidenza Via o piazza
	 * @param civico Numero civico
	 */
	public Indirizzo(String viaResidenza, int civico){
		this.set_via(viaResidenza);
		this.set_civico(civico);
	}
	
	/**
	 * @return the _via
	 */
	public String get_via() {
		return _via;
	}
	/**
	 * @param _via the _via to set
	 */
	public void set_via(String _via) {
		this._via = _via;
	}
	/**
	 * @return the _civico
	 */
	public int get_civico() {
		return _civico;
	}
	/**
	 * @param _civico the _civico to set
	 */
	public void set_civico(int _civico) {
		this._civico = _civico;
	}

}
