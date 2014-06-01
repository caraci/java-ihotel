/**
 * 
 */
package com.iHotel.model.Persona.Documenti;

import com.iHotel.model.Persona.Residenza;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe che ha il compito di modellare un domcumento identificativo
 * @author Alessandro
 *
 */
public class Documento {
	
	/**
	 * Nome.
	 */
	protected String _nomeTitolare;
	/**
	 * Cognome.
	 */
	protected String _cognomeTitolare;
	/**
	 * Data di nascita.
	 */
	protected Giorno _dataDiNascita;
	/**
	 * Città di nascita.
	 */
	protected String _cittaDiNascita;
	/**
	 * Data di rilascio del documento.
	 */
	protected Giorno _dataDiRilascio;
	/**
	 * Data di scadenza.
	 */
	protected Giorno _dataDiScadenza;
	/**
	 * Ente rilasciatario.
	 */
	protected String _enteRilasciatario;
	/**
	 * Numero del documento.
	 */
	protected String _numeroDocumento;
	/**
	 * Residenza.
	 */
	protected Residenza _residenza;
	
	/**
	 * Costruttore di default.
	 */
	public Documento() {}
	
	/**
	 * Costruttore con tutti i parametri
	 * 
	 * @param nome 				Nome dell'intestatario del documento
	 * @param cognome 			Cognome dell'intestatario del documento
	 * @param dataNascita 		Giorno di nascita dell'intestatario del documento
	 * @param cittaNascita 		Città di nascita dell'intestatario del documento
	 * @param dataRilascio 		Data di rilascio del documento
	 * @param dataScadenza 		Data di scadenza del documento
	 * @param enteRilascio 		Ente che ha rilasciato il documento
	 * @param numeroDocumento 	Numero del documento
	 * @param residenza 		Residenza del titolare del documento
	 */
	public Documento(String nome, String cognome, Giorno dataNascita,String cittaNascita,Giorno dataRilascio, Giorno dataScadenza,String enteRilascio, String numeroDocumento,Residenza residenza){
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

	/**
	 * @return the _nomeTitolare
	 */
	public String get_nomeTitolare() {
		return _nomeTitolare;
	}

	/**
	 * @param _nomeTitolare the _nomeTitolare to set
	 */
	public void set_nomeTitolare(String _nomeTitolare) {
		this._nomeTitolare = _nomeTitolare;
	}

	/**
	 * @return the _cognomeTitolare
	 */
	public String get_cognomeTitolare() {
		return _cognomeTitolare;
	}

	/**
	 * @param _cognomeTitolare the _cognomeTitolare to set
	 */
	public void set_cognomeTitolare(String _cognomeTitolare) {
		this._cognomeTitolare = _cognomeTitolare;
	}

	/**
	 * @return the _dataDiNascita
	 */
	public Giorno get_dataDiNascita() {
		return _dataDiNascita;
	}

	/**
	 * @param _dataDiNascita the _dataDiNascita to set
	 */
	public void set_dataDiNascita(Giorno _dataDiNascita) {
		this._dataDiNascita = _dataDiNascita;
	}

	/**
	 * @return the _cittaDiNascita
	 */
	public String get_cittaDiNascita() {
		return _cittaDiNascita;
	}

	/**
	 * @param _cittaDiNascita the _cittaDiNascita to set
	 */
	public void set_cittaDiNascita(String _cittaDiNascita) {
		this._cittaDiNascita = _cittaDiNascita;
	}

	/**
	 * @return the _dataDiRilascio
	 */
	public Giorno get_dataDiRilascio() {
		return _dataDiRilascio;
	}

	/**
	 * @param _dataDiRilascio the _dataDiRilascio to set
	 */
	public void set_dataDiRilascio(Giorno _dataDiRilascio) {
		this._dataDiRilascio = _dataDiRilascio;
	}

	/**
	 * @return the _dataDiScadenza
	 */
	public Giorno get_dataDiScadenza() {
		return _dataDiScadenza;
	}

	/**
	 * @param _dataDiScadenza the _dataDiScadenza to set
	 */
	public void set_dataDiScadenza(Giorno _dataDiScadenza) {
		this._dataDiScadenza = _dataDiScadenza;
	}

	/**
	 * @return the _enteRilasciatario
	 */
	public String get_enteRilasciatario() {
		return _enteRilasciatario;
	}

	/**
	 * @param _enteRilasciatario the _enteRilasciatario to set
	 */
	public void set_enteRilasciatario(String _enteRilasciatario) {
		this._enteRilasciatario = _enteRilasciatario;
	}

	/**
	 * @return the _numeroDocumento
	 */
	public String get_numeroDocumento() {
		return _numeroDocumento;
	}

	/**
	 * @param _numeroDocumento the _numeroDocumento to set
	 */
	public void set_numeroDocumento(String _numeroDocumento) {
		this._numeroDocumento = _numeroDocumento;
	}

	/**
	 * @return the _residenza
	 */
	public Residenza get_residenza() {
		return _residenza;
	}

	/**
	 * @param _residenza the _residenza to set
	 */
	public void set_residenza(Residenza _residenza) {
		this._residenza = _residenza;
	}
}
