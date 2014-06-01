/**
 * 
 */
package com.iHotel.model.Persona;

/**
 * Questa classe modella la residenza del mondo reale, con città e indirizzo.
 * @author Alessandro
 *
 */
public class Residenza {
	
	/**
	 * Città di residenza.
	 */
	private String _cittaResidenza;
	/**
	 * Indirizzo della residenza.
	 */
	private Indirizzo _indirizzoResidenza;
	
	/**
	 * Costruttore di default.
	 */
	public Residenza(){}
	/**
	 * Costruttore con parametri.
	 * 
	 * @param citta Città di residenza
	 * @param indirizzo	Indirizzo di residenza
	 */
	public Residenza(String citta, Indirizzo indirizzo){
		this.set_cittaResidenza(citta);
		this.set_indirizzoResidenza(indirizzo);
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
