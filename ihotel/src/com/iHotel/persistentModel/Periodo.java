/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package com.iHotel.persistentModel;

public class Periodo extends com.iHotel.persistentModel.APersistentModel {
	public Periodo() {
	}
	
	private int ID;
	
	private java.util.Date _dataInizio;
	
	private java.util.Date _dataFine;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_dataInizio(java.util.Date value) {
		this._dataInizio = value;
	}
	
	public java.util.Date get_dataInizio() {
		return _dataInizio;
	}
	
	public void set_dataFine(java.util.Date value) {
		this._dataFine = value;
	}
	
	public java.util.Date get_dataFine() {
		return _dataFine;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
