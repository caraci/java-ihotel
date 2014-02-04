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

public class StatoCamera extends com.iHotel.persistentModel.APersistentModel {
	public StatoCamera() {
	}
	
	private int ID;
	
	com.iHotel.persistentModel.Periodo _periodo;
	
	private com.iHotel.persistentModel.Camera _camera;
	
	private boolean _libera;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_libera(boolean value) {
		this._libera = value;
	}
	
	public boolean get_libera() {
		return _libera;
	}
	
	public void set_camera(com.iHotel.persistentModel.Camera value) {
		this._camera = value;
	}
	
	public com.iHotel.persistentModel.Camera get_camera() {
		return _camera;
	}
	
	public void set_periodo(com.iHotel.persistentModel.Periodo value) {
		this._periodo = value;
	}
	
	public com.iHotel.persistentModel.Periodo get_periodo() {
		return _periodo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
