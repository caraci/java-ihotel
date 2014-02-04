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

public class Albergo extends com.iHotel.persistentModel.APersistentModel {
	public Albergo() {
	}
	
	private int ID;
	
	com.iHotel.persistentModel.CatalogoCamere _catalogoCamere;
	
	private String nome;
	
	private java.util.Set _prenotazioni = new java.util.HashSet();
	
	private java.util.Set _camere = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void set_prenotazioni(java.util.Set value) {
		this._prenotazioni = value;
	}
	
	public java.util.Set get_prenotazioni() {
		return _prenotazioni;
	}
	
	
	public void set_camere(java.util.Set value) {
		this._camere = value;
	}
	
	public java.util.Set get_camere() {
		return _camere;
	}
	
	
	public void set_catalogoCamere(com.iHotel.persistentModel.CatalogoCamere value) {
		this._catalogoCamere = value;
	}
	
	public com.iHotel.persistentModel.CatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
