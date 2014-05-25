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
public class LeafOttieniGiornoScadenzaDurataSoggiornoStrategy extends
		ComponentOttieniGiornoScadenzaStrategy {
	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> _vincoliDurataSoggiorno;

	/**
	 * Costruttore.
	 * 
	 * @param vincoliDurataSoggiorno Vincoli per questa strategia
	 */
	public LeafOttieniGiornoScadenzaDurataSoggiornoStrategy(ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> vincoliDurataSoggiorno) {
		_vincoliDurataSoggiorno=vincoliDurataSoggiorno;
	}

	@Override
	public Giorno getGiornoScadenza() {
		// TODO Auto-generated method stub
		return null;
	}

}
