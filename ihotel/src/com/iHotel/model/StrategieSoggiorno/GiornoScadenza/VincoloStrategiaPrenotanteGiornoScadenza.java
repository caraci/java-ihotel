/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

/**
 * Questa classe rappresenta il generico vincolo per la strategia relativa a quanti giorni
 * prima richiedere l'invio o del bonifico o della carta di credito, relativo all'ospite.
 * 
 * @author Eugenio
 */
public class VincoloStrategiaPrenotanteGiornoScadenza {

	private String _numeroPrenotazioniMin;
	private String _numeroPrenotazioniMax;
	private String _quantiGiorniPrimaRichiedere;
	/**
	 * Costruttore per il vincolo della strategia dell'ospite.
	 * 
	 * @param numeroPrenotazioniMin Numero prenotazioni minimo per questo vincolo.
	 * @param numeroPrenotazioniMax Numero prenotazioni massimo per questo vincolo.
	 * @param quantiGiorniPrimaRichiedere Numero di notti prima dell'inizio del soggiorno entro il quale
	 * richiedere l'invio della garanzia.
	 */
	public VincoloStrategiaPrenotanteGiornoScadenza( String numeroPrenotazioniMin, 
									String numeroPrenotazioniMax, 
									String quantiGiorniPrimaRichiedere) 
	{
		_numeroPrenotazioniMin=numeroPrenotazioniMin;
		_numeroPrenotazioniMax=numeroPrenotazioniMax;
		_quantiGiorniPrimaRichiedere=quantiGiorniPrimaRichiedere;
	}
	/**
	 * @return the _numeroPrenotazioniMin
	 */
	public String get_numeroPrenotazioniMin() {
		return _numeroPrenotazioniMin;
	}
	/**
	 * @param _numeroPrenotazioniMin the _numeroPrenotazioniMin to set
	 */
	public void set_numeroPrenotazioniMin(String _numeroPrenotazioniMin) {
		this._numeroPrenotazioniMin = _numeroPrenotazioniMin;
	}
	/**
	 * @return the _numeroPrenotazioniMax
	 */
	public String get_numeroPrenotazioniMax() {
		return _numeroPrenotazioniMax;
	}
	/**
	 * @param _numeroPrenotazioniMax the _numeroPrenotazioniMax to set
	 */
	public void set_numeroPrenotazioniMax(String _numeroPrenotazioniMax) {
		this._numeroPrenotazioniMax = _numeroPrenotazioniMax;
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
