/**
 * 
 */
package com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza;


import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe strategia composta concreta, per il calcolo del giorno entro cui versare la caparra, migliore per l'albergo.
 * @author Eugenio
 *
 */
public class CompositeGiornoScadenzaMigliorePerHotelStrategy extends CompositeOttieniGiornoScadenzaStrategy {

	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		
		// Giorno di scadenza relativo alla prima strategia.
		Giorno giornoScadenzaPiuLontanoDaInizioSoggiorno = null;
		// Ciclo sulle strategie di cui si compone la strategia composita
		for (Iterator<ComponentOttieniGiornoScadenzaStrategy> iterator = _strategie.iterator(); iterator.hasNext();) {
			ComponentOttieniGiornoScadenzaStrategy strategiaLeaf = (ComponentOttieniGiornoScadenzaStrategy) iterator.next();
			// Controllo se è presente un giorno di scadenza iniziale
			if (giornoScadenzaPiuLontanoDaInizioSoggiorno != null) {
				// Ricavo il giorno di scadenza fornito dalla strategia in analisi
				Giorno giornoScadenzaStrategia = strategiaLeaf.getGiornoScadenza(soggiorno);
				// Controllo se il giornoScadenzaStrategia è più vicino all'inizio del soggiorno rispetto al giorno attualmente scelto.
				if (giornoScadenzaStrategia.compara(giornoScadenzaPiuLontanoDaInizioSoggiorno) < 0) {
					// Assegno il nuovo valore per il giorno di scadenza.
					giornoScadenzaPiuLontanoDaInizioSoggiorno=giornoScadenzaStrategia;
				}
			} else {
				// Si entra in questo ramo solo la prima volta per inserire un primo giorno di scadenza.
				giornoScadenzaPiuLontanoDaInizioSoggiorno=strategiaLeaf.getGiornoScadenza(soggiorno);
			}	
		}
		return giornoScadenzaPiuLontanoDaInizioSoggiorno;
	}
}
