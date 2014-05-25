/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.ArrayList;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class LeafOttieniAmmontareCaparraPrenotanteStrategy extends
		ComponentOttieniAmmontareCaparraStrategy {
	/**
	 * Lista contenente i vinvoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> _vincoliPrenotante;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliStrategiaPrenotante
	 */
	public LeafOttieniAmmontareCaparraPrenotanteStrategy(ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> vincoliStrategiaPrenotante) {
		_vincoliPrenotante=vincoliStrategiaPrenotante;
	}

	@Override
	public Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno) {
		// TODO Auto-generated method stub
		return null;
	}

}
