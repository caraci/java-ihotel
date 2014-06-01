/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe concreta, di tipo strategia composita, per il calcolo della caparra del soggiorno che sia più
 * favorevole all'albergo che al cliente.
 * @author Eugenio
 *
 */
public class CompositeOttieniAmmontareCaparraMigliorePerHotelStrategy extends
			CompositeOttieniAmmontareCaparraStrategy {

	@Override
	public Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno) {
		// Prezzo di default
		Prezzo ammontareCaparraMigliorePerHotel = null;
		// Ciclo sulle strategie presenti nell'oggetto composito
		for (Iterator<ComponentOttieniAmmontareCaparraStrategy> iterator = _strategie.iterator(); iterator.hasNext();) {
			ComponentOttieniAmmontareCaparraStrategy strategiaLeaf = (ComponentOttieniAmmontareCaparraStrategy) iterator.next();
			// Controllo se è presente un prezzo iniziale
			if (ammontareCaparraMigliorePerHotel != null) {
				// Ricavo l'ammontare della caparra fornito dalla strategia in analisi
				Prezzo ammontareCaparraStrategia = strategiaLeaf.getAmmontareCaparra(soggiorno);
				// Controllo se il prezzo scelto finora è maggiore di quello proposto da questa strategia
				if(!ammontareCaparraMigliorePerHotel.isMaggioreDi(ammontareCaparraStrategia)) {
					// Setto il nuovo importo migliore per la caparra.
					ammontareCaparraMigliorePerHotel=ammontareCaparraStrategia;
				}
			} else {
				// Si entra in questo ramo solo la prima volta per inserire un primo prezzo.
				ammontareCaparraMigliorePerHotel=strategiaLeaf.getAmmontareCaparra(soggiorno);
			}
		}
		return ammontareCaparraMigliorePerHotel;
	}

}
