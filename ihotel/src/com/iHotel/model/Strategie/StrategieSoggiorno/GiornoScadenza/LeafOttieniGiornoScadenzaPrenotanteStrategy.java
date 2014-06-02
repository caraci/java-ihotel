/**
 * 
 */
package com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe strategia semplice che implementa l'algoritmo per il calcolo del giorno di scadenza entro cui versare
 * la caparra in base al numero di prenotazioni che il cliente ha effettuato in passato.
 * @author Eugenio
 *
 */
public class LeafOttieniGiornoScadenzaPrenotanteStrategy extends
		ComponentOttieniGiornoScadenzaStrategy {

	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> _vincoliPrenotante;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliPrenotante Lista contenente i vincoli per questa strategia.
	 */
	public LeafOttieniGiornoScadenzaPrenotanteStrategy(ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> vincoliPrenotante) {
		_vincoliPrenotante = vincoliPrenotante;
	}
	
	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		// Prendo il prenotante del soggiorno
		ClientePrenotante prenotante = soggiorno.get_prenotante();
		// Prendo il numero di prenotazioni effettuate dal cliente prenotante
		int numeroPrenotazioniClientePrenotante = prenotante.get_numeroPrenotazioni();
		// Istanzio variabili
		int numeroMinimoPrenotazioni, numeroMassimoPrenotazioni;
		int quantiGiorniPrimaRichiedereGaranzia=0;
		// Ciclo sui vincoli per vedere entro quanti giorni prima va richiesto l'invio della garanzia
		for (Iterator<VincoloStrategiaPrenotanteGiornoScadenza> iterator = _vincoliPrenotante.iterator(); iterator.hasNext();) {
			VincoloStrategiaPrenotanteGiornoScadenza vincoloPrenotante = (VincoloStrategiaPrenotanteGiornoScadenza) iterator.next();
			// Prendo gli estremi del vincolo
			numeroMinimoPrenotazioni = vincoloPrenotante.get_numeroPrenotazioniMin();
			numeroMassimoPrenotazioni = vincoloPrenotante.get_numeroPrenotazioniMax();
			// Cerco la fascia contenente il numero di prenotazioni del cliente prenotante.
			if ((numeroMinimoPrenotazioni <= numeroPrenotazioniClientePrenotante) && (numeroPrenotazioniClientePrenotante <= numeroMassimoPrenotazioni )) {
				// Assegno il giusto valore indicante entro quanti giorni prima richiedere a garanzia
				quantiGiorniPrimaRichiedereGaranzia = vincoloPrenotante.get_quantiGiorniPrimaRichiedere();
			}
			
		}
		// Prendo il giorno di inizio del soggiorno.
		Giorno giornoInizioSoggiorno = soggiorno.get_periodo().get_dataInizio();
		// Assegno il nuovo giorno ad una nuovo oggetto.
		Giorno giornoScadenza = giornoInizioSoggiorno.addToGiorno(-quantiGiorniPrimaRichiedereGaranzia);
		
		return giornoScadenza;
	}



}
