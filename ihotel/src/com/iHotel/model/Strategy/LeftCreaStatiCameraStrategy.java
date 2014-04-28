/**
 * 
 */
package com.iHotel.model.Strategy;

import java.util.LinkedList;

import com.iHotel.model.State.CameraStateLibera;
import com.iHotel.model.State.CameraStateOccupata;
import com.iHotel.model.State.CameraState;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe addetta alla creazione di nuovi stati camera, quando il periodo della prenotazione che si vuole effettuare inizia
 * lo stesso giorno dello stato camera contenente.
 * 
 * @author Eugenio
 */
public class LeftCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<CameraState> nuoviStati = new LinkedList<CameraState>();
		// Nuovi stati
			// - Occupato 
			CameraState cameraStateOccupato = new CameraStateOccupata();
			cameraStateOccupato.set_periodo(periodoRichiesta);
			// - Libero
			Periodo periodoLibero = new Periodo();
			// Imposto il nuovo periodo
			periodoLibero.setDataInizioPeriodoDaDataFinePeriodo(periodoRichiesta);
			periodoLibero.setDataFinePeriodoDaDataFinePeriodo(cameraState.get_periodo());
			// Setto il periodo allo stato
			CameraState cameraStateLibero = new CameraStateLibera();
			cameraStateLibero.set_periodo(periodoLibero);
			
		// Aggiungo stati alla lista
		nuoviStati.add(cameraStateOccupato);
		nuoviStati.add(cameraStateLibero);
		return nuoviStati;
	}

}
