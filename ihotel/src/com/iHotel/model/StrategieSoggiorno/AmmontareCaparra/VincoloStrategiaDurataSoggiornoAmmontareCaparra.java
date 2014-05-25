/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

/**
 * Questa classe rappresenta il generico vincolo per la strategia relativa al calcolo
 * dell'ammontare della caparra che deve fornire il prenotante, tenendo conto della durata del soggiorno.
 * 
 * @author Eugenio
 */
public class VincoloStrategiaDurataSoggiornoAmmontareCaparra {

	private int _numeroNottiMin;
	private int _numeroNottiMax;
	private int _percentualeDaRichiedere;
	
	/**
	 * Costruttore.
	 * 
	 * @param numeroNottiMin Numero notti minimo per questo vincolo.
	 * @param numeroNottiMax Numero notti massimo per questo vincolo.
	 * @param percentualeDaRichiedere Percentuale di sull'ammontare della prenotazione da richiedere come caparra.
	 */
	public VincoloStrategiaDurataSoggiornoAmmontareCaparra(int numeroNottiMin,
												   int numeroNottiMax,
												   int percentualeDaRichiedere) {
		set_numeroNottiMin(numeroNottiMin);
		set_numeroNottiMax(numeroNottiMax);
		set_percentualeDaRichiedere(percentualeDaRichiedere);
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
	 * @return the _percentualeDaRichiedere
	 */
	public int get_percentualeDaRichiedere() {
		return _percentualeDaRichiedere;
	}

	/**
	 * @param _percentualeDaRichiedere the _percentualeDaRichiedere to set
	 */
	public void set_percentualeDaRichiedere(int _percentualeDaRichiedere) {
		this._percentualeDaRichiedere = _percentualeDaRichiedere;
	}
}
