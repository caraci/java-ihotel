/**
 * 
 */
package com.iHotel.model.Strategy;

import java.util.LinkedList;

import com.iHotel.model.State.CameraStateOccupata;
import com.iHotel.model.State.CameraState;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe addetta alla creazione di nuovi stati camera, quando il periodo della prenotazione che si vuole effettuare è uguale 
 * al periodo dello stato camera contenente.
 * 
 * @author Eugenio
 */
public class AllCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<CameraState> nuoviStati = new LinkedList<CameraState>();
		// Nuovo stato occupato
		CameraState cameraStateOccupato = new CameraStateOccupata();
		cameraStateOccupato.set_periodo(periodoRichiesta);
		// Aggiungo stato alla lista
		nuoviStati.add(cameraStateOccupato);
		return nuoviStati;
	}

}
