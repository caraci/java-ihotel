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
public class LeafOttieniGiornoScadenzaPrenotanteStrategy extends
		ComponentOttieniGiornoScadenzaStrategy {

	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> _vincoliPrenotante;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliPrenotante Lista contenente i vincoli per questa strategia.
	 */
	public LeafOttieniGiornoScadenzaPrenotanteStrategy(ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> vincoliPrenotante) {
		_vincoliPrenotante = vincoliPrenotante;
	}

	@Override
	public Giorno getGiornoScadenza() {
		// TODO Auto-generated method stub
		return null;
	}

}
