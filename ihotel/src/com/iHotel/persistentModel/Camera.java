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

public class Camera extends com.iHotel.persistentModel.APersistentModel {
	public Camera() {
	}
	
	private int ID;
	
	private com.iHotel.persistentModel.Albergo _albergo;
	
	private java.util.Set _statiCamera = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_albergo(com.iHotel.persistentModel.Albergo value) {
		this._albergo = value;
	}
	
	public com.iHotel.persistentModel.Albergo get_albergo() {
		return _albergo;
	}
	
	public void set_statiCamera(java.util.Set value) {
		this._statiCamera = value;
	}
	
	public java.util.Set get_statiCamera() {
		return _statiCamera;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
