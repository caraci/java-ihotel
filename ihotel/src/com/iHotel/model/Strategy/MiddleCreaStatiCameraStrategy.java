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
 * @author Eugenio
 *
 */
public class MiddleCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	/**
	 * Metodo per creare nuovi stati della camera, quando il periodo dello stato ed il periodo della richiesta
	 * iniziano e finiscono in giorni differenti.
	 */
	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<CameraState> nuoviStati = new LinkedList<CameraState>();
		// Nuovi stati
		
			// - Libero Sinistra
			Periodo periodoLiberoSx = new Periodo();
			// Imposto il nuovo periodo
			periodoLiberoSx.setDataInizioPeriodoDaDataInizioPeriodo(cameraState.get_periodo());
			periodoLiberoSx.setDataFinePeriodoDaDataInizioPeriodo(periodoRichiesta);
			// Setto il periodo allo stato
			CameraState cameraStateLiberoSx = new CameraStateLibera();
			cameraStateLiberoSx.set_periodo(periodoLiberoSx);
			
			// - Occupato 
			CameraState cameraStateOccupato = new CameraStateOccupata();
			cameraStateOccupato.set_periodo(periodoRichiesta);
			
			// - Libero Destra
			Periodo periodoLiberoDx = new Periodo();
			// Imposto il nuovo periodo
			periodoLiberoDx.setDataInizioPeriodoDaDataFinePeriodo(periodoRichiesta);
			periodoLiberoDx.setDataFinePeriodoDaDataFinePeriodo(cameraState.get_periodo());
			// Setto il periodo allo stato
			CameraState cameraStateLiberoDx = new CameraStateLibera();
			cameraStateLiberoDx.set_periodo(periodoLiberoDx);
			
		// Aggiungo stati alla lista
		nuoviStati.add(cameraStateLiberoSx);
		nuoviStati.add(cameraStateOccupato);
		nuoviStati.add(cameraStateLiberoDx);
		
		return nuoviStati;
	}

}
