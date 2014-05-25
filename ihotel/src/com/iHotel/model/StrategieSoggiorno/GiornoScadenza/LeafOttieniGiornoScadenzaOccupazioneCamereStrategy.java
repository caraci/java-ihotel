/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;

import java.util.ArrayList;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;

/**
 * @author Eugenio
 *
 */
public class LeafOttieniGiornoScadenzaOccupazioneCamereStrategy extends
		ComponentOttieniGiornoScadenzaStrategy {

	/**
	 * Lista contenente i vincoli per questa strategia.
	 */
	private ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza> _vincoliOccupazioneCamere;
	/**
	 * Costruttore.
	 * 
	 * @param vincoliOccupazioneCamere Lista contenente i vincoli per questa strategia
	 */
	public LeafOttieniGiornoScadenzaOccupazioneCamereStrategy(ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza> vincoliOccupazioneCamere) {
		_vincoliOccupazioneCamere=vincoliOccupazioneCamere;
	}
	
	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		// TODO Auto-generated method stub
		return null;
	}


}
