/**
 * 
 */
package com.iHotel.model.Utility;

/**
 * @author Alessandro
 *
 */
public class Residenza {
	
	/*Attributi e costruttore*/
	private String _cittaResidenza;
	private Indirizzo _indirizzoResidenza;
	
	public Residenza(){
		
	}
	
	/**
	 * @return the _cittaResidenza
	 */
	public String get_cittaResidenza() {
		return _cittaResidenza;
	}
	/**
	 * @param _cittaResidenza the _cittaResidenza to set
	 */
	public void set_cittaResidenza(String _cittaResidenza) {
		this._cittaResidenza = _cittaResidenza;
	}
	/**
	 * @return the _indirizzoResidenza
	 */
	public Indirizzo get_indirizzoResidenza() {
		return _indirizzoResidenza;
	}
	/**
	 * @param _indirizzoResidenza the _indirizzoResidenza to set
	 */
	public void set_indirizzoResidenza(Indirizzo _indirizzoResidenza) {
		this._indirizzoResidenza = _indirizzoResidenza;
	}

}
