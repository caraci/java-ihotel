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
public class VincoloStrategiaDurataSoggiornoGiornoScadenza {

	private int _numeroNottiMin;
	private int _numeroNottiMax;
	private int _quantiGiorniPrimaRichiedere;
	
	/**
	 * 
	 * @param numeroNottiMin
	 * @param numeroNottiMax
	 * @param quantiGiorniPrimaRichiedere
	 */
	public VincoloStrategiaDurataSoggiornoGiornoScadenza(int numeroNottiMin,
												   int numeroNottiMax,
												   int quantiGiorniPrimaRichiedere) {
		set_numeroNottiMin(numeroNottiMin);
		set_numeroNottiMax(numeroNottiMax);
		set_quantiGiorniPrimaRichiedere(quantiGiorniPrimaRichiedere);
	}

	/**
	 * @return the _numeroNottiMin
	 */
	public int get_numeroNottiMin() {
		return _numeroNottiMin;
	}

	/**
	 * @param _numeroNottiMin the _numeroNottiMin to set
	 */
	public void set_numeroNottiMin(int _numeroNottiMin) {
		this._numeroNottiMin = _numeroNottiMin;
	}

	/**
	 * @return the _numeroNottiMax
	 */
	public int get_numeroNottiMax() {
		return _numeroNottiMax;
	}

	/**
	 * @param _numeroNottiMax the _numeroNottiMax to set
	 */
	public void set_numeroNottiMax(int _numeroNottiMax) {
		this._numeroNottiMax = _numeroNottiMax;
	}

	/**
	 * @return the _quantiGiorniPrimaRichiedere
	 */
	public int get_quantiGiorniPrimaRichiedere() {
		return _quantiGiorniPrimaRichiedere;
	}

	/**
	 * @param _quantiGiorniPrimaRichiedere the _quantiGiorniPrimaRichiedere to set
	 */
	public void set_quantiGiorniPrimaRichiedere(int _quantiGiorniPrimaRichiedere) {
		this._quantiGiorniPrimaRichiedere = _quantiGiorniPrimaRichiedere;
	}
	
}
