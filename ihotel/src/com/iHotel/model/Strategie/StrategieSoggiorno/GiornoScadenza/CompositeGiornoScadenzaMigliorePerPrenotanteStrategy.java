/**
 * 
 */
package com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza;

import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe strategia composita concreta per il calcolo del giorno entro cui versare la caparra, più favorevole per il cliente.
 * @author Eugenio
 *
 */
public class CompositeGiornoScadenzaMigliorePerPrenotanteStrategy extends CompositeOttieniGiornoScadenzaStrategy {

	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		
		// Giorno di scadenza relativo alla prima strategia.
		Giorno giornoScadenzaPiuVicinoDaInizioSoggiorno = null;
		// Ciclo sulle strategie di cui si compone la strategia composita
		for (Iterator<ComponentOttieniGiornoScadenzaStrategy> iterator = _strategie.iterator(); iterator.hasNext();) {
			ComponentOttieniGiornoScadenzaStrategy strategiaLeaf = (ComponentOttieniGiornoScadenzaStrategy) iterator.next();
			// Controllo se è presente un giorno di scadenza iniziale
			if (giornoScadenzaPiuVicinoDaInizioSoggiorno != null) {
				// Ricavo il giorno di scadenza fornito dalla strategia in analisi
				Giorno giornoScadenzaStrategia = strategiaLeaf.getGiornoScadenza(soggiorno);
				// Controllo se il giornoScadenzaStrategia è più vicino all'inizio del soggiorno rispetto al giorno attualmente scelto.
				if (giornoScadenzaStrategia.compara(giornoScadenzaPiuVicinoDaInizioSoggiorno) > 0) {
					// Assegno il nuovo valore per il giorno di scadenza.
					giornoScadenzaPiuVicinoDaInizioSoggiorno=giornoScadenzaStrategia;
				}
			} else {
				// Si entra in questo ramo solo la prima volta per inserire un primo giorno di scadenza.
				giornoScadenzaPiuVicinoDaInizioSoggiorno=strategiaLeaf.getGiornoScadenza(soggiorno);
			}	
		}
		return giornoScadenzaPiuVicinoDaInizioSoggiorno;
	}
}
