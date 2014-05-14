/**
 * 
 */
package com.iHotel.model.Utility;

/**
 * Questa classe rappresenta un indirizzo
 * @author Alessandro
 * 
 */
public class Indirizzo {
	
	/*Attributi e costruttore*/
	private String _viaResidenza;
	private int _civico;
	
	public Indirizzo(){
		
	}
	
	/**
	 * @return the _viaResidenza
	 */
	public String get_viaResidenza() {
		return _viaResidenza;
	}
	/**
	 * @param _viaResidenza the _viaResidenza to set
	 */
	public void set_viaResidenza(String _viaResidenza) {
		this._viaResidenza = _viaResidenza;
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
