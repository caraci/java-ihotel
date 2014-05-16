package com.iHotel.model.Persona;

import com.iHotel.model.Persona.Documenti.Documento;



/**
 * Questa classe rappresenta il concetto di "Ospite" di un albergo del modo reale.
 * @author Alessandro
 *
 */
public class Ospite extends Cliente{

	/* ----------------- Attributi e Costruttore -------------------- */
	
	/** Documento associato all'ospite*/
	private Documento _documento;
	
	
	//Costruttore di default
	public Ospite() {
		
	}
	
	/**
	 * Costruttore con parametri
	 * @param nome 		Nome dell'ospite
	 * @param cognome 	Cognome dell'ospite
	 * @param codice	Codice del cliente ospite
	 * @param documento	Documento dell'ospite
	 */
	public Ospite(String nome, String cognome,String codice, Documento documento){
		super(nome,cognome,codice);
		this.set_documento(documento);
		
	}
	/* ----------------- Getter, Setter ------------------------------*/
	
	
	/**
	 * @return the _documento
	 */
	public Documento get_documento() {
		return _documento;
	}
	/**
	 * @param _documento the _documento to set
	 */
	public void set_documento(Documento _documento) {
		this._documento = _documento;
	}

}