package com.iHotel.model;

public class MPeriodo implements Cloneable {

	private int _giornoInizio;
	private int _meseInizio;
	private int _annoInizio;
	
	private int _giornoFine;
	private int _meseFine;
	private int _annoFine;
	
	/**
	 * @throws CloneNotSupportedException 
	 * @Override
	 */
	public MPeriodo clone() throws CloneNotSupportedException {
	    return (MPeriodo)super.clone();
	}
	
	
	/**
	 * @return the _annoFine
	 */
	public int get_annoFine() {
		return _annoFine;
	}
	/**
	 * @param _annoFine the _annoFine to set
	 */
	public void set_annoFine(int _annoFine) {
		this._annoFine = _annoFine;
	}
	/**
	 * @return the _meseFine
	 */
	public int get_meseFine() {
		return _meseFine;
	}
	/**
	 * @param _meseFine the _meseFine to set
	 */
	public void set_meseFine(int _meseFine) {
		this._meseFine = _meseFine;
	}
	/**
	 * @return the _giornoFine
	 */
	public int get_giornoFine() {
		return _giornoFine;
	}
	/**
	 * @param _giornoFine the _giornoFine to set
	 */
	public void set_giornoFine(int _giornoFine) {
		this._giornoFine = _giornoFine;
	}
	/**
	 * @return the _annoInizio
	 */
	public int get_annoInizio() {
		return _annoInizio;
	}
	/**
	 * @param _annoInizio the _annoInizio to set
	 */
	public void set_annoInizio(int _annoInizio) {
		this._annoInizio = _annoInizio;
	}
	/**
	 * @return the _meseInizio
	 */
	public int get_meseInizio() {
		return _meseInizio;
	}
	/**
	 * @param _meseInizio the _meseInizio to set
	 */
	public void set_meseInizio(int _meseInizio) {
		this._meseInizio = _meseInizio;
	}
	/**
	 * @return the _giornoInizio
	 */
	public int get_giornoInizio() {
		return _giornoInizio;
	}
	/**
	 * @param _giornoInizio the _giornoInizio to set
	 */
	public void set_giornoInizio(int _giornoInizio) {
		this._giornoInizio = _giornoInizio;
	}
	
	

	
	
	

}