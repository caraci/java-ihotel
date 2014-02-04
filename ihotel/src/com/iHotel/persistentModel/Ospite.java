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

public class Ospite extends com.iHotel.persistentModel.APersistentModel {
	public Ospite() {
	}
	
	private int ID;
	
	private String _nome;
	
	private String _cognome;
	
	private String _email;
	
	private String _telefono;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void set_nome(String value) {
		this._nome = value;
	}
	
	public String get_nome() {
		return _nome;
	}
	
	public void set_cognome(String value) {
		this._cognome = value;
	}
	
	public String get_cognome() {
		return _cognome;
	}
	
	public void set_email(String value) {
		this._email = value;
	}
	
	public String get_email() {
		return _email;
	}
	
	public void set_telefono(String value) {
		this._telefono = value;
	}
	
	public String get_telefono() {
		return _telefono;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
