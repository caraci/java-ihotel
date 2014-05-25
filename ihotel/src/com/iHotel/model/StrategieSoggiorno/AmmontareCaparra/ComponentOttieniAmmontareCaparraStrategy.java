/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public abstract class ComponentOttieniAmmontareCaparraStrategy {

	public abstract Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno);
	public void addStrategy(ComponentOttieniAmmontareCaparraStrategy strategy) {
		// Do nothing
	}
}
