/**
 * 
 */
package com.iHotel.model.Strategy;

import java.util.LinkedList;

import com.iHotel.model.State.CameraLibera;
import com.iHotel.model.State.CameraOccupata;
import com.iHotel.model.State.CameraState;
import com.iHotel.model.Utility.Periodo;

/**
 * @author Eugenio
 *
 */
public class RightCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	/**
	 * Metodo per creare nuovi stati della camera, quando il periodo dello stato ed il periodo della richiesta
	 * finiscono lo stesso giorno, ma iniziano in giorni differenti.
	 */
	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<CameraState> nuoviStati = new LinkedList<CameraState>();
		// Nuovi stati
			// - Occupato 
			CameraState cameraStateOccupato = new CameraOccupata();
			cameraStateOccupato.set_periodo(periodoRichiesta);
			// - Libero
			Periodo periodoLibero = new Periodo();
			// Imposto il nuovo periodo
			periodoLibero.setDataInizioPeriodoDaDataInizioPeriodo(cameraState.get_periodo());
			periodoLibero.setDataFinePeriodoDaDataInizioPeriodo(periodoRichiesta);
			// Setto il periodo allo stato
			CameraState cameraStateLibero = new CameraLibera();
			cameraStateLibero.set_periodo(periodoLibero);
			
		// Aggiungo stati alla lista
		nuoviStati.add(cameraStateLibero);
		nuoviStati.add(cameraStateOccupato);
		return nuoviStati;
	}

}
