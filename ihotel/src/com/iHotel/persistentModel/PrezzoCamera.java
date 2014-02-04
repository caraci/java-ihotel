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

public class PrezzoCamera extends com.iHotel.persistentModel.APersistentModel {
	public PrezzoCamera() {
	}
	
	private int ID;
	
	com.iHotel.persistentModel.Periodo _periodo;
	
	private com.iHotel.persistentModel.DescrizioneCamera _descrizioneCamera;
	
	private int _prezzo;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_prezzo(int value) {
		this._prezzo = value;
	}
	
	public int get_prezzo() {
		return _prezzo;
	}
	
	public void set_descrizioneCamera(com.iHotel.persistentModel.DescrizioneCamera value) {
		this._descrizioneCamera = value;
	}
	
	public com.iHotel.persistentModel.DescrizioneCamera get_descrizioneCamera() {
		return _descrizioneCamera;
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
