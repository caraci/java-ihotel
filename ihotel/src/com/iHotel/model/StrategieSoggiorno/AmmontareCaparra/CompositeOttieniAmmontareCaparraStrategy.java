/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.ArrayList;

/**
 * @author Eugenio
 *
 */
public abstract class CompositeOttieniAmmontareCaparraStrategy extends
		ComponentOttieniAmmontareCaparraStrategy {
	
	/**
	 * Strategie di cui si compone l'oggetto.
	 */
	protected ArrayList<ComponentOttieniAmmontareCaparraStrategy> _strategie;
	/**
	 * Costruttore.
	 */
	protected CompositeOttieniAmmontareCaparraStrategy() {
		_strategie = new ArrayList<ComponentOttieniAmmontareCaparraStrategy>();
	}

	@Override
	public void addStrategy(ComponentOttieniAmmontareCaparraStrategy strategy) {
		_strategie.add(strategy);
	}
}
