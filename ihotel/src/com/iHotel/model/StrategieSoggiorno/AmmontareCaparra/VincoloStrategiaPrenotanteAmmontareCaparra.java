/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

/**
 * Questa classe rappresenta il generico vincolo per la strategia relativa al calcolo
 * dell'ammontare della caparra che deve fornire il prenotante, tenendo conto del prenotante.
 * 
 * @author Eugenio
 */
public class VincoloStrategiaPrenotanteAmmontareCaparra {
	/**
	 * Numero minimo di prenotazioni, da parte dello stesso prenotante, per cui vale il vincolo
	 */
	private int _numeroPrenotazioniMin;
	/**
	 * Numero minimo di prenotazioni, da parte dello stesso prenotante, per cui vale il vincolo
	 */
	private int _numeroPrenotazioniMax;
	/**
	 * Percentuale, sul totale del soggiorno, da richiedere come caparra
	 */
	private int _percentualeDaRichiedere;
	/**
	 * Costruttore.
	 * 
	 * @param numeroPrenotazioniMin Numero prenotazioni minimo per questo vincolo.
	 * @param numeroPrenotazioniMax Numero prenotazioni massimo per questo vincolo.
	 * @param percentualeDaRichiedere Percentuale di sull'ammontare della prenotazione da richiedere come caparra.
	 */
	public VincoloStrategiaPrenotanteAmmontareCaparra(
			int numeroPrenotazioniMin, int numeroPrenotazioniMax,
			int percentualeDaRichiedere) {
		set_numeroPrenotazioniMin(numeroPrenotazioniMin);
		set_numeroPrenotazioniMax(numeroPrenotazioniMax);
		set_percentualeDaRichiedere(percentualeDaRichiedere);
	}
	/**
	 * @return the _numeroPrenotazioniMin
	 */
	public int get_numeroPrenotazioniMin() {
		return _numeroPrenotazioniMin;
	}
	/**
	 * @param _numeroPrenotazioniMin the _numeroPrenotazioniMin to set
	 */
	public void set_numeroPrenotazioniMin(int _numeroPrenotazioniMin) {
		this._numeroPrenotazioniMin = _numeroPrenotazioniMin;
	}
	/**
	 * @return the _numeroPrenotazioniMax
	 */
	public int get_numeroPrenotazioniMax() {
		return _numeroPrenotazioniMax;
	}
	/**
	 * @param _numeroPrenotazioniMax the _numeroPrenotazioniMax to set
	 */
	public void set_numeroPrenotazioniMax(int _numeroPrenotazioniMax) {
		this._numeroPrenotazioniMax = _numeroPrenotazioniMax;
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
