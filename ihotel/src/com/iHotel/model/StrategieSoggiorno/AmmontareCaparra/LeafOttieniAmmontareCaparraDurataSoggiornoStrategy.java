/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class LeafOttieniAmmontareCaparraDurataSoggiornoStrategy extends
		ComponentOttieniAmmontareCaparraStrategy {
	
	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> _vincoliDurataSoggiorno;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliStrategiaDurataSoggiorno
	 */
	public LeafOttieniAmmontareCaparraDurataSoggiornoStrategy(ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> vincoliStrategiaDurataSoggiorno) {
		_vincoliDurataSoggiorno=vincoliStrategiaDurataSoggiorno;
	}

	@Override
	public Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno) {
		// Prendo il periodo del soggiorno
		Periodo periodoSoggiorno = soggiorno.get_periodo();
		// Vedo la lunghezza del periodo del soggiorno.
		int numeroNottiSoggiorno = periodoSoggiorno.getNottiPeriodo();
		// Istanzio variabili
		int numeroMinimoNotti, numeroMassimoNotti;
		int percentualeDaRichiedere=0;
		// Ciclo sui vincoli per vedere che percentuale sull'ammontare della prenotazione richiedere per la camera
		for (Iterator<VincoloStrategiaDurataSoggiornoAmmontareCaparra> iterator = _vincoliDurataSoggiorno.iterator(); iterator.hasNext();) {
			VincoloStrategiaDurataSoggiornoAmmontareCaparra vincoloDurataSoggiorno = (VincoloStrategiaDurataSoggiornoAmmontareCaparra) iterator.next();
			// Prendo gli estremi del vincolo
			numeroMinimoNotti = vincoloDurataSoggiorno.get_numeroNottiMin();
			numeroMassimoNotti = vincoloDurataSoggiorno.get_numeroNottiMax();
			// Cerco la fascia contenente il numero di notti della prenotazione
			if ((numeroMinimoNotti <= numeroNottiSoggiorno) && (numeroNottiSoggiorno <= numeroMassimoNotti )) {
				// Assegno il giusto valore indicante entro quanti giorni prima richiedere a garanzia
				percentualeDaRichiedere = vincoloDurataSoggiorno.get_percentualeDaRichiedere();
			}
		}
		// Importo delle camere per la prenotazione
		Prezzo importoTotaleCamerePrenotazione = soggiorno.get_importoTotaleCamere();
		// Creo il prezzo contenente l'ammontare della caparra in base alla percentuale.
		Prezzo ammontareCaparra = importoTotaleCamerePrenotazione.getImportoPercentuale(percentualeDaRichiedere);
				
		return ammontareCaparra;
	}

}
