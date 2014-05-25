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

	private int _numeroCamereLibereMin;
	private int _numeroCamereLibereMax;
	private int _quantiGiorniPrimaRichiedere;
	
	/**
	 * 
	 * @param numeroCamereLibereMin
	 * @param numeroCamereLibereMax
	 * @param quantiGiorniPrimaRichiedere
	 */
	public VincoloStrategiaOccupazioneCamereGiornoScadenza(int numeroCamereLibereMin,
														   int numeroCamereLibereMax,
														   int quantiGiorniPrimaRichiedere) {
		_numeroCamereLibereMin=numeroCamereLibereMin;
		_numeroCamereLibereMax=numeroCamereLibereMax;
		_quantiGiorniPrimaRichiedere=quantiGiorniPrimaRichiedere;
	}

	/**
	 * @return the _numeroCamereLibereMin
	 */
	public int get_numeroCamereLibereMin() {
		return _numeroCamereLibereMin;
	}

	/**
	 * @return the _numeroCamereLibereMax
	 */
	public int get_numeroCamereLibereMax() {
		return _numeroCamereLibereMax;
	}

	/**
	 * @return the _quantiGiorniPrimaRichiedere
	 */
	public int get_quantiGiorniPrimaRichiedere() {
		return _quantiGiorniPrimaRichiedere;
	}

	

}
