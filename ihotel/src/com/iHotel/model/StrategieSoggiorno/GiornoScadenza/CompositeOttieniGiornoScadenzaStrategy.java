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
	/**
	 * Costruttore.
	 */
	protected CompositeOttieniGiornoScadenzaStrategy() {
		_strategie = new ArrayList<ComponentOttieniGiornoScadenzaStrategy>();
	}
	
	@Override
	public void addStrategy(ComponentOttieniGiornoScadenzaStrategy strategy) {
		_strategie.add(strategy);
	}

	@Override
	public abstract Giorno getGiornoScadenza();

	/**
	 * @return the _strategie
	 */
	public ArrayList<ComponentOttieniGiornoScadenzaStrategy> get_strategie() {
		return _strategie;
	}

	/**
	 * @param _strategie the _strategie to set
	 */
	public void set_strategie(
			ArrayList<ComponentOttieniGiornoScadenzaStrategy> _strategie) {
		this._strategie = _strategie;
	}

}
