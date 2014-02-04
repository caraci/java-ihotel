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

public class DescrizioneCamera extends com.iHotel.persistentModel.APersistentModel {
	public DescrizioneCamera() {
	}
	
	private int ID;
	
	private com.iHotel.persistentModel.CatalogoCamere _catalogoCamere;
	
	private java.util.Set _prezziCamera = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_catalogoCamere(com.iHotel.persistentModel.CatalogoCamere value) {
		this._catalogoCamere = value;
	}
	
	public com.iHotel.persistentModel.CatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}
	
	public void set_prezziCamera(java.util.Set value) {
		this._prezziCamera = value;
	}
	
	public java.util.Set get_prezziCamera() {
		return _prezziCamera;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
