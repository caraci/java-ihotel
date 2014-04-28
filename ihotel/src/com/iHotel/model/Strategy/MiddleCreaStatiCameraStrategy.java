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
 * Classe addetta alla creazione di nuovi stati camera, quando il periodo della prenotazione che si vuole effettuare è 
 * contenuto all'interno dello stato camera, con i giorni iniziali e finali differenti.
 * 
 * @author Eugenio
 */
public class MiddleCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
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
