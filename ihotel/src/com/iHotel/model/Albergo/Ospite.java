package com.iHotel.model.Albergo;

import com.iHotel.model.Utility.Giorno;

/**
 * Questa classe rappresenta il concetto di "Ospite" di un albergo del modo reale.
 * @author Alessandro
 *
 */
public class Ospite{

	/* ----------------- Attributi e Costruttore -------------------- */
	private String _nome;
	private String _cognome;
	private Giorno _dataNascita;
	private String _cittadinanza;
	private String _cittaResidenza;
	private String _indirizzoResidenza;
	/*Documento*/
	private String _tipoDocumento;
	private String _numeroDocumento;
	private String _enteRilascioDocumento;
	/*Recapiti*/
	private String _eMail;
	private String _telefono;

	public Ospite() {
		
	}
	/* ----------------- Getter, Setter ------------------------------*/
	/**
	 * @return _nome
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * @param _nome
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * @return _cognome
	 */
	public String get_cognome() {
		return this._cognome;
	}

	/**
	 * @param _cognome
	 */
	public void set_cognome(String _cognome) {
		this._cognome = _cognome;
	}
	/**
	 * @return the _dataNascita
	 */
	public Giorno get_dataNascita() {
		return _dataNascita;
	}
	/**
	 * @param _dataNascita the _dataNascita to set
	 */
	public void set_dataNascita(Giorno _dataNascita) {
		this._dataNascita = _dataNascita;
	}
	/**
	 * @return the _cittadinanza
	 */
	public String get_cittadinanza() {
		return _cittadinanza;
	}
	/**
	 * @param _cittadinanza the _cittadinanza to set
	 */
	public void set_cittadinanza(String _cittadinanza) {
		this._cittadinanza = _cittadinanza;
	}
	/**
	 * @return the _cittaResidenza
	 */
	public String get_cittaResidenza() {
		return _cittaResidenza;
	}
	/**
	 * @param _cittaResidenza the _cittaResidenza to set
	 */
	public void set_cittaResidenza(String _cittaResidenza) {
		this._cittaResidenza = _cittaResidenza;
	}
	/**
	 * @return the _indirizzoResidenza
	 */
	public String get_indirizzoResidenza() {
		return _indirizzoResidenza;
	}
	/**
	 * @param _indirizzoResidenza the _indirizzoResidenza to set
	 */
	public void set_indirizzoResidenza(String _indirizzoResidenza) {
		this._indirizzoResidenza = _indirizzoResidenza;
	}
	/**
	 * @return the _tipoDocumento
	 */
	public String get_tipoDocumento() {
		return _tipoDocumento;
	}
	/**
	 * @param _tipoDocumento the _tipoDocumento to set
	 */
	public void set_tipoDocumento(String _tipoDocumento) {
		this._tipoDocumento = _tipoDocumento;
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
	 * @return the _enteRilascioDocumento
	 */
	public String get_enteRilascioDocumento() {
		return _enteRilascioDocumento;
	}
	/**
	 * @param _enteRilascioDocumento the _enteRilascioDocumento to set
	 */
	public void set_enteRilascioDocumento(String _enteRilascioDocumento) {
		this._enteRilascioDocumento = _enteRilascioDocumento;
	}
	/**
	 * @return _eMail
	 */
	public String get_eMail() {
		return _eMail;
	}
	/**
	 * @param _eMail
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}
	/**
	 * @return _telefono
	 */
	public String get_telefono() {
		return _telefono;
	}
	/**
	 * @param _telefono
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}

}