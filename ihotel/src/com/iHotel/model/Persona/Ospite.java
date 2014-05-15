package com.iHotel.model.Persona;



/**
 * Questa classe rappresenta il concetto di "Ospite" di un albergo del modo reale.
 * @author Alessandro
 *
 */
public class Ospite extends Persona{

	/* ----------------- Attributi e Costruttore -------------------- */
	
	/** Documento associato all'ospite*/
	private Documento _documento;
	
	
	//Costruttore di default
	public Ospite() {
		
	}
	/**
	 * Costruttore con tutti gli attributi di un ospite
	 * 
	 * @param nome 		Nome dell'ospite
	 * @param cognome 	Cognome dell'ospite
	 * @param email 	Indirizzo email dell'ospite
	 * @param telefono 	Numero di telefono dell'ospite
	 * @param documento Documento dell'ospite
	 */
	public Ospite(String nome, String cognome, String email, String telefono, Documento documento){
		super(nome,cognome,email,telefono);
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