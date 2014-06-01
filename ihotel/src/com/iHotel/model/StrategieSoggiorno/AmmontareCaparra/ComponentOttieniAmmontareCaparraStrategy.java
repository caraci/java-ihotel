/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe astratta a capo della gerarchia delle strategie per il calcolo dell'importo della caparra, in base
 * alle politiche aziendali.
 * @author Eugenio
 *
 */
public abstract class ComponentOttieniAmmontareCaparraStrategy {
	/**
	 * Metodo che restituisce l'ammontare della caparra sulla base delle politiche aziendali.
	 * @param soggiorno Soggiorno per il quale si vuole calcolare la caparra
	 * @return L'ammontare della caparra calcolato
	 */
	public abstract Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno);
	/**
	 * Metodo che serve ad aggiungere una strategia semplice o composta, ad una strategia composta. 
	 * @param strategy La strategia da aggiungere
	 */
	public void addStrategy(ComponentOttieniAmmontareCaparraStrategy strategy) {
		// Do nothing
	}
}
