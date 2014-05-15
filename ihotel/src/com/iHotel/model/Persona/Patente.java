/**
 * 
 */
package com.iHotel.model.Persona;

import com.iHotel.model.Utility.Giorno;

/**
 * Classe che descrive il documento "Patente"
 * Mancano le categorie di patente conseguite
 * @author Alessandro
 *
 */
public class Patente extends Documento{
	
	//Costruttore di default
	public Patente(){
		
	}
	
	/**
	 * Costruttore con tutti i parametri
	 * 
	 * @param nome 				Nome dell'intestatario del documento
	 * @param cognome			Cognome dell'intestatario del documento
	 * @param dataNascita 		Giorno di nascita dell'intestatario del documento
	 * @param cittaNascita 		Città di nascita dell'intestatario del documento
	 * @param dataRilascio 		Data di rilascio del documento
	 * @param dataScadenza 		Data di scadenza del documento
	 * @param enteRilascio 		Ente che ha rilasciato il documento
	 * @param numeroDocumento 	Numero del documento
	 * @param residenza 		Residenza del titolare del documento
	 */
	public Patente(String nome, String cognome, Giorno dataNascita,String cittaNascita,Giorno dataRilascio, Giorno dataScadenza,String enteRilascio, String numeroDocumento,Residenza residenza){
		this.set_nomeTitolare(nome);
		this.set_cognomeTitolare(cognome);
		this.set_dataDiNascita(dataNascita);
		this.set_cittaDiNascita(cittaNascita);
		this.set_dataDiRilascio(dataRilascio);
		this.set_dataDiScadenza(dataScadenza);
		this.set_enteRilasciatario(enteRilascio);
		this.set_numeroDocumento(numeroDocumento);
		this.set_residenza(residenza);
	}

}
