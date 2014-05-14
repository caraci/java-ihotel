/**
 * 
 */
package com.iHotel.model.DocumentiIdentita;

import com.iHotel.model.Utility.Residenza;

/**
 * Classe che rappresenta il documento "Passaporto"
 * @author Alessandro
 *
 */
public class Passaporto extends Documento {
	
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
