/**
 * 
 */
package com.iHotel.model.DocumentiIdentita;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Residenza;

/**
 * Classe che ha il compito di modellare un domcumento identificativo
 * @author Alessandro
 *
 */
public class Documento {
	
	/*Attributi e costruttore*/
	protected String _nomeTitolare;
	protected String _cognomeTitolare;
	protected Giorno _dataDiNascita;
	protected String _cittaDiNascita;
	protected Giorno _dataDiRilascio;
	protected Giorno _dataDiScadenza;
	protected String _enteRilasciatario;
	protected String _numeroDocumento;
	protected Residenza _residenza;
	
	public Documento(){
		
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
