/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

import java.util.ArrayList;

import com.iHotel.model.Utility.Giorno;

/**
 * @author Eugenio
 *
 */
public abstract class CompositeOttieniGiornoScadenzaStrategy extends
		ComponentOttieniGiornoScadenzaStrategy {
	/**
	 * Strategie di cui si compone l'oggetto.
	 */
	protected ArrayList<ComponentOttieniGiornoScadenzaStrategy> _strategie;
	
	@Override
	public void addStrategy(ComponentOttieniGiornoScadenzaStrategy strategy) {
		_strategie.add(strategy);
	}

	@Override
	public abstract Giorno getGiornoScadenza();

}
