/**
 * 
 */
package com.iHotel.model.Persona.Documenti;

import com.iHotel.model.Persona.Residenza;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe che rappresenta il documento "Passaporto"
 * @author Alessandro
 *
 */
public class Passaporto extends Documento {
	
	/*Attributi e costruttore*/
	private String _tipo;
	private String _codicePaese;
	private String _sesso;
	/**
	 * In un passaporto possono essere riportate fino a 3 residenze
	 */
	private Residenza _residenza2;
	private Residenza _residenza3;
	private float _statura;
	private String _coloreOcchi;
	
	//Costruttore di default
	public Passaporto(){
		
	}
	
	/**
	 * Costruttore con tutti i parametri
	 * 
	 * @param nome 				Nome del titolare del documento
	 * @param cognome			Cognome del titolare del documento
	 * @param dataNascita 		Giorno di nascita del titolare del documento
	 * @param cittaNascita 		Città di nascita del titolare del documento
	 * @param dataRilascio 		Giorno di rilascio del documento
	 * @param dataScadenza 		Giorno di scadenza del documento
	 * @param enteRilascio 		Ente che ha rilasciato il documento
	 * @param numeroDocumento	Numero del documento
	 * @param residenza 		Residenza del titolare del documento
	 * @param tipo				Tipo di passaporto
	 * @param codicePaese		Codice della nazione di appartenenza
	 * @param sesso				Sesso del titolare
	 * @param residenza2		Seconda residenza del titolare (se cel'ha)
	 * @param residenza3		Terza residenza del titolare (se cel'ha)
	 * @param Statura			Statura del titolare
	 * @param coloreOcchi		Colore degli occhi del titolare
	 */
	public Passaporto(String nome, String cognome, Giorno dataNascita,String cittaNascita,Giorno dataRilascio, Giorno dataScadenza,String enteRilascio, String numeroDocumento,Residenza residenza,
			String tipo, String codicePaese, String sesso,Residenza residenza2, Residenza residenza3,float Statura, String coloreOcchi){
		
		super(nome,cognome,dataNascita, cittaNascita, dataRilascio, dataScadenza, enteRilascio, numeroDocumento,residenza);
		
		this.set_tipo(tipo);
		this.set_codicePaese(codicePaese);
		this.set_sesso(sesso);
		this.set_residenza2(residenza2);
		this.set_residenza3(residenza3);
		this.set_statura(Statura);
		this.set_coloreOcchi(coloreOcchi);
		
	}
	

	/**
	 * @return the _tipo
	 */
	public String get_tipo() {
		return _tipo;
	}

	/**
	 * @param _tipo the _tipo to set
	 */
	public void set_tipo(String _tipo) {
		this._tipo = _tipo;
	}

	/**
	 * @return the _codicePaese
	 */
	public String get_codicePaese() {
		return _codicePaese;
	}

	/**
	 * @param _codicePaese the _codicePaese to set
	 */
	public void set_codicePaese(String _codicePaese) {
		this._codicePaese = _codicePaese;
	}

	/**
	 * @return the _sesso
	 */
	public String get_sesso() {
		return _sesso;
	}

	/**
	 * @param _sesso the _sesso to set
	 */
	public void set_sesso(String _sesso) {
		this._sesso = _sesso;
	}

	/**
	 * @return the _residenza2
	 */
	public Residenza get_residenza2() {
		return _residenza2;
	}

	/**
	 * @param _residenza2 the _residenza2 to set
	 */
	public void set_residenza2(Residenza _residenza2) {
		this._residenza2 = _residenza2;
	}

	/**
	 * @return the _residenza3
	 */
	public Residenza get_residenza3() {
		return _residenza3;
	}

	/**
	 * @param _residenza3 the _residenza3 to set
	 */
	public void set_residenza3(Residenza _residenza3) {
		this._residenza3 = _residenza3;
	}

	/**
	 * @return the _statura
	 */
	public float get_statura() {
		return _statura;
	}

	/**
	 * @param _statura the _statura to set
	 */
	public void set_statura(float _statura) {
		this._statura = _statura;
	}

	/**
	 * @return the _coloreOcchi
	 */
	public String get_coloreOcchi() {
		return _coloreOcchi;
	}

	/**
	 * @param _coloreOcchi the _coloreOcchi to set
	 */
	public void set_coloreOcchi(String _coloreOcchi) {
		this._coloreOcchi = _coloreOcchi;
	}

}
