/**
 * 
 */
package com.iHotel.model.Strategy;

import java.util.LinkedList;

import com.iHotel.model.State.CameraOccupata;
import com.iHotel.model.State.CameraState;
import com.iHotel.model.Utility.Periodo;

/**
 * @author Eugenio
 *
 */
public class AllCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	/**
	 * Metodo per creare nuovi stati della camera, quando il periodo dello stato ed il periodo della richiesta
	 * iniziano e finiscio gli stessi giorni.
	 */
	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<CameraState> nuoviStati = new LinkedList<CameraState>();
		// Nuovo stato occupato
		CameraState cameraStateOccupato = new CameraOccupata();
		cameraStateOccupato.set_periodo(periodoRichiesta);
		// Aggiungo stato alla lista
		nuoviStati.add(cameraStateOccupato);
		return nuoviStati;
	}

}
