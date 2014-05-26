/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class CompositeOttieniAmmontareCaparraMigliorePerPrenotanteStrategy extends
		CompositeOttieniAmmontareCaparraStrategy {

	@Override
	public Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno) {
		// Prezzo di default
		Prezzo ammontareCaparraMigliorePerPrenotante = null;
		// Ciclo sulle strategie presenti nell'oggetto composito
		for (Iterator<ComponentOttieniAmmontareCaparraStrategy> iterator = _strategie.iterator(); iterator.hasNext();) {
			ComponentOttieniAmmontareCaparraStrategy strategiaLeaf = (ComponentOttieniAmmontareCaparraStrategy) iterator.next();
			// Controllo se è presente un prezzo iniziale
			if (ammontareCaparraMigliorePerPrenotante != null) {
				// Ricavo l'ammontare della caparra fornito dalla strategia in analisi
				Prezzo ammontareCaparraStrategia = strategiaLeaf.getAmmontareCaparra(soggiorno);
				// Controllo se il prezzo scelto finora è maggiore di quello proposto da questa strategia
				if(ammontareCaparraMigliorePerPrenotante.isMaggioreDi(ammontareCaparraStrategia)) {
					// Setto il nuovo importo migliore per la caparra.
					ammontareCaparraMigliorePerPrenotante=ammontareCaparraStrategia;
				}
			} else {
				// Si entra in questo ramo solo la prima volta per inserire un primo prezzo.
				ammontareCaparraMigliorePerPrenotante=strategiaLeaf.getAmmontareCaparra(soggiorno);
			}
		}
		return ammontareCaparraMigliorePerPrenotante;
	}

}
