/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

/**
 * Questa classe rappresenta il generico vincolo per la strategia relativa a quanti giorni
 * prima richiedere l'invio o del bonifico o della carta di credito, relativo all'occupazione delle camere.
 * 
 * @author Eugenio
 */
public class VincoloStrategiaOccupazioneCamereGiornoScadenza {

	private String _numeroCamereLibereMin;
	private String _numeroCamereLibereMax;
	private String _quantiGiorniPrimaRichiedere;
	
	/**
	 * 
	 * @param numeroCamereLibereMin
	 * @param numeroCamereLibereMax
	 * @param quantiGiorniPrimaRichiere
	 */
	public VincoloStrategiaOccupazioneCamereGiornoScadenza(String numeroCamereLibereMin,
														   String numeroCamereLibereMax,
														   String quantiGiorniPrimaRichiere) {
		_numeroCamereLibereMin=numeroCamereLibereMin;
		_numeroCamereLibereMax=numeroCamereLibereMax;
		_quantiGiorniPrimaRichiedere=quantiGiorniPrimaRichiere;
	}

	/**
	 * @return the _numeroCamereLibereMin
	 */
	public String get_numeroCamereLibereMin() {
		return _numeroCamereLibereMin;
	}

	/**
	 * @param _numeroCamereLibereMin the _numeroCamereLibereMin to set
	 */
	public void set_numeroCamereLibereMin(String _numeroCamereLibereMin) {
		this._numeroCamereLibereMin = _numeroCamereLibereMin;
	}

	/**
	 * @return the _numeroCamereLibereMax
	 */
	public String get_numeroCamereLibereMax() {
		return _numeroCamereLibereMax;
	}

	/**
	 * @param _numeroCamereLibereMax the _numeroCamereLibereMax to set
	 */
	public void set_numeroCamereLibereMax(String _numeroCamereLibereMax) {
		this._numeroCamereLibereMax = _numeroCamereLibereMax;
	}

	/**
	 * @return the _quantiGiorniPrimaRichiedere
	 */
	public String get_quantiGiorniPrimaRichiedere() {
		return _quantiGiorniPrimaRichiedere;
	}

	/**
	 * @param _quantiGiorniPrimaRichiedere the _quantiGiorniPrimaRichiedere to set
	 */
	public void set_quantiGiorniPrimaRichiedere(String _quantiGiorniPrimaRichiedere) {
		this._quantiGiorniPrimaRichiedere = _quantiGiorniPrimaRichiedere;
	}

}
