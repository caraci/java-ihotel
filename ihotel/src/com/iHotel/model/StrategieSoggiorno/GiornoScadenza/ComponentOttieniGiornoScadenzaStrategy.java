/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

import com.iHotel.model.Utility.Giorno;

/**
 * @author Eugenio
 *
 */
public abstract class ComponentOttieniGiornoScadenzaStrategy {
	
	public abstract Giorno getGiornoScadenza();
	public void addStrategy(ComponentOttieniGiornoScadenzaStrategy strategy) {
		// Do nothing
	}

}
