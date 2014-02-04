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

public class CatalogoCamere extends com.iHotel.persistentModel.APersistentModel {
	public CatalogoCamere() {
	}
	
	private int ID;
	
	private java.util.Set _descrizioniCamere = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_descrizioniCamere(java.util.Set value) {
		this._descrizioniCamere = value;
	}
	
	public java.util.Set get_descrizioniCamere() {
		return _descrizioniCamere;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
