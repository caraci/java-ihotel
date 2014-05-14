/**
 * 
 */
package com.iHotel.model.DocumentiIdentita;

/**
 * Classe che rappresenta il documento "Carta d'identità"
 * @author Alessandro
 *
 */
public class CartaIdentita extends Documento {
	
	/*Attributi e costruttore*/
	private String _statoCivile;
	private String _professione;
	private float _statura;
	private String _coloreCapelli;
	private String _coloreOcchi;
	private String _segniParticolari;
	
	public CartaIdentita(){
		
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
