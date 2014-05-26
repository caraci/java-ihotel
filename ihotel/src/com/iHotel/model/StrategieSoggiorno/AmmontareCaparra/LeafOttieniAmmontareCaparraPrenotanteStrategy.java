/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class LeafOttieniAmmontareCaparraPrenotanteStrategy extends
		ComponentOttieniAmmontareCaparraStrategy {
	/**
	 * Lista contenente i vinvoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> _vincoliPrenotante;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliStrategiaPrenotante
	 */
	public LeafOttieniAmmontareCaparraPrenotanteStrategy(ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> vincoliStrategiaPrenotante) {
		_vincoliPrenotante=vincoliStrategiaPrenotante;
	}

	@Override
	public Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno) {
		// Prendo il prenotante del soggiorno
		ClientePrenotante prenotante = soggiorno.getPrenotante();
		// Prendo il numero di prenotazioni effettuate dal cliente prenotante
		int numeroPrenotazioniClientePrenotante = prenotante.get_numeroPrenotazioni();
		// Istanzio variabili
		int numeroMinimoPrenotazioni, numeroMassimoPrenotazioni;
		int percentualeDaRichiedere=0;
		// Ciclo sui vincoli per vedere che percentuale sull'ammontare della prenotazione richiedere per la camera
		for (Iterator<VincoloStrategiaPrenotanteAmmontareCaparra> iterator = _vincoliPrenotante.iterator(); iterator.hasNext();) {
			VincoloStrategiaPrenotanteAmmontareCaparra vincoloPrenotante = (VincoloStrategiaPrenotanteAmmontareCaparra) iterator.next();
			// Prendo gli estremi del vincolo
			numeroMinimoPrenotazioni = vincoloPrenotante.get_numeroPrenotazioniMin();
			numeroMassimoPrenotazioni = vincoloPrenotante.get_numeroPrenotazioniMax();
			// Cerco la fascia contenente il numero di prenotazioni del cliente prenotante.
			if ((numeroMinimoPrenotazioni <= numeroPrenotazioniClientePrenotante) && (numeroPrenotazioniClientePrenotante <= numeroMassimoPrenotazioni )) {
				// Assegno il giusto valore indicante entro quanti giorni prima richiedere a garanzia
				percentualeDaRichiedere = vincoloPrenotante.get_percentualeDaRichiedere();
			}	
		}
		// Importo delle camere per la prenotazione
		Prezzo importoTotaleCamerePrenotazione = soggiorno.get_importoTotaleCamere();
		// Creo il prezzo contenente l'ammontare della caparra in base alla percentuale.
		Prezzo ammontareCaparra = importoTotaleCamerePrenotazione.getImportoPercentuale(percentualeDaRichiedere);
		
		return ammontareCaparra;
	}

}
