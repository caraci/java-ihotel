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
	/**
	 * Numero minimo di prenotazioni che il cliente prenotante ha effettuato in passato, per questo vincolo
	 */
	private int _numeroPrenotazioniMin;
	/**
	 * Numero massimo di prenotazioni che il cliente prenotante ha effettuato in passato, per questo vincolo
	 */
	private int _numeroPrenotazioniMax;
	/**
	 * Numero di giorni, antecedenti all'inizio del soggiorno, entro cui bisogna ricevere 
	 * la caparra dal cliente
	 */
	private int _quantiGiorniPrimaRichiedere;
	/**
	 * Costruttore per il vincolo della strategia dell'ospite.
	 * 
	 * @param numeroPrenotazioniMin Numero prenotazioni minimo per questo vincolo.
	 * @param numeroPrenotazioniMax Numero prenotazioni massimo per questo vincolo.
	 * @param quantiGiorniPrimaRichiedere Numero di notti prima dell'inizio del soggiorno entro il quale
	 * richiedere l'invio della garanzia.
	 */
	public VincoloStrategiaPrenotanteGiornoScadenza( int numeroPrenotazioniMin, 
									int numeroPrenotazioniMax, 
									int quantiGiorniPrimaRichiedere) 
	{
		_numeroPrenotazioniMin=numeroPrenotazioniMin;
		_numeroPrenotazioniMax=numeroPrenotazioniMax;
		_quantiGiorniPrimaRichiedere=quantiGiorniPrimaRichiedere;
	}
	/**
	 * @return the _numeroPrenotazioniMin
	 */
	public int get_numeroPrenotazioniMin() {
		return _numeroPrenotazioniMin;
	}
	/**
	 * @return the _numeroPrenotazioniMax
	 */
	public int get_numeroPrenotazioniMax() {
		return _numeroPrenotazioniMax;
	}
	/**
	 * @return the _quantiGiorniPrimaRichiedere
	 */
	public int get_quantiGiorniPrimaRichiedere() {
		return _quantiGiorniPrimaRichiedere;
	}
}
