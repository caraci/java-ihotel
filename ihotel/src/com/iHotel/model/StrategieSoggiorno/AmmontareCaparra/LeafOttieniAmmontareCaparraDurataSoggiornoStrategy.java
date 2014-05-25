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
public class LeafOttieniAmmontareCaparraDurataSoggiornoStrategy extends
		ComponentOttieniAmmontareCaparraStrategy {
	
	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> _vincoliDurataSoggiorno;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliStrategiaDurataSoggiorno
	 */
	public LeafOttieniAmmontareCaparraDurataSoggiornoStrategy(ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> vincoliStrategiaDurataSoggiorno) {
		_vincoliDurataSoggiorno=vincoliStrategiaDurataSoggiorno;
	}

	@Override
	public Prezzo getAmmontareCaparra(SoggiornoContextSubject soggiorno) {
		// TODO Auto-generated method stub
		return null;
	}

}
