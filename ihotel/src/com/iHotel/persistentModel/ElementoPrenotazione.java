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

/**
 * @author Eugenio
 */
public class ElementoPrenotazione extends com.iHotel.persistentModel.APersistentModel {
	public ElementoPrenotazione() {
	}
	
	private int ID;
	
	private com.iHotel.persistentModel.Prenotazione _prenotazione;
	
	com.iHotel.persistentModel.Camera _camera;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_prenotazione(com.iHotel.persistentModel.Prenotazione value) {
		this._prenotazione = value;
	}
	
	public com.iHotel.persistentModel.Prenotazione get_prenotazione() {
		return _prenotazione;
	}
	
	public void set_camera(com.iHotel.persistentModel.Camera value) {
		this._camera = value;
	}
	
	public com.iHotel.persistentModel.Camera get_camera() {
		return _camera;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
