/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe strategia semplice per il calcolo del giorno entro cui versare la caparra, in base alla durata del soggiorno.
 * @author Eugenio
 *
 */
public class LeafOttieniGiornoScadenzaDurataSoggiornoStrategy extends
		ComponentOttieniGiornoScadenzaStrategy {
	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> _vincoliDurataSoggiorno;

	/**
	 * Costruttore.
	 * 
	 * @param vincoliDurataSoggiorno Vincoli per questa strategia
	 */
	public LeafOttieniGiornoScadenzaDurataSoggiornoStrategy(ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> vincoliDurataSoggiorno) {
		_vincoliDurataSoggiorno=vincoliDurataSoggiorno;
	}

	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		// Prendo il periodo del soggiorno
		Periodo periodoSoggiorno = soggiorno.get_periodo();
		// Vedo la lunghezza del periodo del soggiorno.
		int numeroNottiSoggiorno = periodoSoggiorno.getNottiPeriodo();
		// Istanzio variabili
		int numeroMinimoNotti, numeroMassimoNotti;
		int quantiGiorniPrimaRichiedereGaranzia=0;
		// Ciclo sui vincoli per vedere entro quanti giorni prima va richiesto l'invio della garanzia
		for (Iterator<VincoloStrategiaDurataSoggiornoGiornoScadenza> iterator = _vincoliDurataSoggiorno.iterator(); iterator.hasNext();) {
			VincoloStrategiaDurataSoggiornoGiornoScadenza vincoloDurataSoggiorno = (VincoloStrategiaDurataSoggiornoGiornoScadenza) iterator.next();
			// Prendo gli estremi del vincolo
			numeroMinimoNotti = vincoloDurataSoggiorno.get_numeroNottiMin();
			numeroMassimoNotti = vincoloDurataSoggiorno.get_numeroNottiMax();
			// Cerco la fascia contenente il numero di notti della prenotazione
			if ((numeroMinimoNotti <= numeroNottiSoggiorno) && (numeroNottiSoggiorno <= numeroMassimoNotti )) {
				// Assegno il giusto valore indicante entro quanti giorni prima richiedere a garanzia
				quantiGiorniPrimaRichiedereGaranzia = vincoloDurataSoggiorno.get_quantiGiorniPrimaRichiedere();
			}
		}
		// Prendo il giorno di inizio del soggiorno.
		Giorno giornoInizioSoggiorno = soggiorno.get_periodo().get_dataInizio();
		// Assegno il nuovo giorno ad una nuovo oggetto.
		Giorno giornoScadenza = giornoInizioSoggiorno.addToGiorno(-quantiGiorniPrimaRichiedereGaranzia);
		
		return giornoScadenza;
	}

}
