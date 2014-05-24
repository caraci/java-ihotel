/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

/**
 * Questa classe rappresenta il generico vincolo per la strategia relativa a quanti giorni
 * prima richiedere l'invio o del bonifico o della carta di credito, relativo alla durata del soggiorno.
 * 
 * @author Eugenio
 */
public class VincoloStrategiaDurataSoggiornoStrategy {

	private String _numeroNottiMin;
	private String _numeroNottiMax;
	private String _quantiGiorniPrimaRichiedere;
	
	/**
	 * 
	 * @param numeroNottiMin
	 * @param numeroNottiMax
	 * @param quantiGiorniPrimaRichiere
	 */
	public VincoloStrategiaDurataSoggiornoStrategy(String numeroNottiMin,
												   String numeroNottiMax,
												   String quantiGiorniPrimaRichiere) {
		_numeroNottiMin=numeroNottiMin;
		_numeroNottiMax=numeroNottiMax;
		_quantiGiorniPrimaRichiedere=quantiGiorniPrimaRichiere;
	}

	/**
	 * @return the _numeroNottiMin
	 */
	public String get_numeroNottiMin() {
		return _numeroNottiMin;
	}

	/**
	 * @param _numeroNottiMin the _numeroNottiMin to set
	 */
	public void set_numeroNottiMin(String _numeroNottiMin) {
		this._numeroNottiMin = _numeroNottiMin;
	}

	/**
	 * @return the _numeroNottiMax
	 */
	public String get_numeroNottiMax() {
		return _numeroNottiMax;
	}

	/**
	 * @param _numeroNottiMax the _numeroNottiMax to set
	 */
	public void set_numeroNottiMax(String _numeroNottiMax) {
		this._numeroNottiMax = _numeroNottiMax;
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
