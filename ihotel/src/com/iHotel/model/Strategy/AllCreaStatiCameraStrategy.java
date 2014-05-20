/**
 * 
 */
package com.iHotel.model.Strategy;

import java.util.LinkedList;

import com.iHotel.model.Albergo.Camera.StatoCamera;
import com.iHotel.model.Albergo.Camera.StatoCameraOccupata;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe addetta alla creazione di nuovi stati camera, quando il periodo della prenotazione che si vuole effettuare è uguale 
 * al periodo dello stato camera contenente.
 * 
 * @author Eugenio
 */
public class AllCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	public LinkedList<StatoCamera> creaNuoviStati(StatoCamera cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<StatoCamera> nuoviStati = new LinkedList<StatoCamera>();
		// Nuovo stato occupato
		StatoCamera cameraStateOccupato = new StatoCameraOccupata();
		cameraStateOccupato.set_periodo(periodoRichiesta);
		// Aggiungo stato alla lista
		nuoviStati.add(cameraStateOccupato);
		return nuoviStati;
	}

}
