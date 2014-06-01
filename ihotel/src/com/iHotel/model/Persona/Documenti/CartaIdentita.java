/**
 * 
 */
package com.iHotel.model.Persona.Documenti;

import com.iHotel.model.Persona.Residenza;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe che rappresenta il documento "Carta d'identità".
 * 
 * @author Alessandro
 */
public class CartaIdentita extends Documento {
	
	/**
	 * Stato civile.
	 */
	private String _statoCivile;
	/**
	 * Professione.
	 */
	private String _professione;
	/**
	 * Statura.
	 */
	private float _statura;
	/**
	 * Colore capelli.
	 */
	private String _coloreCapelli;
	/**
	 * Colore occhi.
	 */
	private String _coloreOcchi;
	/**
	 * Segni particolari.
	 */
	private String _segniParticolari;
	
	//Costruttore di default
	public CartaIdentita(){
		
	}
	/**
	 * Costruttore con tutti i parametri 
	 * 
	 * @param nome Nome del titolare del documento
	 * @param cognome Cognome del titolare del documento
	 * @param dataNascita Giorno di nascita del titolare del documento
	 * @param cittaNascita Città di nascita del titolare del documento
	 * @param dataRilascio Giorno di rilascio del documento
	 * @param dataScadenza Giorno di scadenza del documento
	 * @param enteRilascio Ente che ha rilasciato il documento
	 * @param numeroDocumento Numero del documento
	 * @param residenza Residenza del titolare del documento
	 * @param statoCivile Stato civile del titolare del documento
	 * @param professione Professione del titolare del documento
	 * @param statura Statura del titolare del documento
	 * @param coloreCapelli Colore dei capelli del titolare del documento
	 * @param coloreOcchi Colore degli occhi del titolare del documento
	 * @param segniParticolari Segni particolari del titolare del documento
	 */
	public CartaIdentita(String nome, String cognome, Giorno dataNascita,String cittaNascita,Giorno dataRilascio, Giorno dataScadenza,String enteRilascio, String numeroDocumento,Residenza residenza,
			String statoCivile, String professione, float statura,String coloreCapelli, String coloreOcchi, String segniParticolari){
		super(nome,cognome,dataNascita, cittaNascita, dataRilascio, dataScadenza, enteRilascio, numeroDocumento,residenza);
		
		this.set_statoCivile(statoCivile);
		this.set_professione(professione);
		this.set_statura(statura);
		this.set_coloreCapelli(coloreCapelli);
		this.set_coloreOcchi(coloreOcchi);
		this.set_segniParticolari(segniParticolari);
		
	}

	/**
	 * @return the _statoCivile
	 */
	public String get_statoCivile() {
		return _statoCivile;
	}


	/**
	 * @param _statoCivile the _statoCivile to set
	 */
	public void set_statoCivile(String _statoCivile) {
		this._statoCivile = _statoCivile;
	}


	/**
	 * @return the _professione
	 */
	public String get_professione() {
		return _professione;
	}


	/**
	 * @param _professione the _professione to set
	 */
	public void set_professione(String _professione) {
		this._professione = _professione;
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
	 * @return the _coloreCapelli
	 */
	public String get_coloreCapelli() {
		return _coloreCapelli;
	}


	/**
	 * @param _coloreCapelli the _coloreCapelli to set
	 */
	public void set_coloreCapelli(String _coloreCapelli) {
		this._coloreCapelli = _coloreCapelli;
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


	/**
	 * @return the _segniParticolari
	 */
	public String get_segniParticolari() {
		return _segniParticolari;
	}


	/**
	 * @param _segniParticolari the _segniParticolari to set
	 */
	public void set_segniParticolari(String _segniParticolari) {
		this._segniParticolari = _segniParticolari;
	}
	
	

}
