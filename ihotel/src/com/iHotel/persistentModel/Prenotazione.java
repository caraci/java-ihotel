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

public class Prenotazione extends com.iHotel.persistentModel.APersistentModel {
	public Prenotazione() {
	}
	
	private int ID;
	
	com.iHotel.persistentModel.Periodo _periodo;
	
	private com.iHotel.persistentModel.Ospite _ospite;
	
	private com.iHotel.persistentModel.Albergo _albergo;
	
	private boolean _completa;
	
	private java.util.Set _elementiPrenotazione = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_completa(boolean value) {
		this._completa = value;
	}
	
	public boolean get_completa() {
		return _completa;
	}
	
	public void set_albergo(com.iHotel.persistentModel.Albergo value) {
		this._albergo = value;
	}
	
	public com.iHotel.persistentModel.Albergo get_albergo() {
		return _albergo;
	}
	
	public void set_ospite(com.iHotel.persistentModel.Ospite value) {
		this._ospite = value;
	}
	
	public com.iHotel.persistentModel.Ospite get_ospite() {
		return _ospite;
	}
	
	public void set_periodo(com.iHotel.persistentModel.Periodo value) {
		this._periodo = value;
	}
	
	public com.iHotel.persistentModel.Periodo get_periodo() {
		return _periodo;
	}
	
	public void set_elementiPrenotazione(java.util.Set value) {
		this._elementiPrenotazione = value;
	}
	
	public java.util.Set get_elementiPrenotazione() {
		return _elementiPrenotazione;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
