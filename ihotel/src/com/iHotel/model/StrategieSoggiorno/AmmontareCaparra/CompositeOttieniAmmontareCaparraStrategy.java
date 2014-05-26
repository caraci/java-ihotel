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

	/**
	 * @return the _strategie
	 */
	public ArrayList<ComponentOttieniAmmontareCaparraStrategy> get_strategie() {
		return _strategie;
	}

	/**
	 * @param _strategie the _strategie to set
	 */
	public void set_strategie(
			ArrayList<ComponentOttieniAmmontareCaparraStrategy> _strategie) {
		this._strategie = _strategie;
	}
}
