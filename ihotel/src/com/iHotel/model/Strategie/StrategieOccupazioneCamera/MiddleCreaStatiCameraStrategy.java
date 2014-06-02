/**
 * 
 */
package com.iHotel.model.Strategie.StrategieOccupazioneCamera;

import java.util.LinkedList;

import com.iHotel.model.Albergo.Camera.StatoCamera;
import com.iHotel.model.Albergo.Camera.StatoCameraLibera;
import com.iHotel.model.Albergo.Camera.StatoCameraOccupata;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe addetta alla creazione di nuovi stati camera, quando il periodo della prenotazione che si vuole effettuare è 
 * contenuto all'interno dello stato camera, con i giorni iniziali e finali differenti.
 * 
 * @author Eugenio
 */
public class MiddleCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	public LinkedList<StatoCamera> creaNuoviStati(StatoCamera cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<StatoCamera> nuoviStati = new LinkedList<StatoCamera>();
		// Nuovi stati
		
			// - Libero Sinistra
			Periodo periodoLiberoSx = new Periodo();
			// Imposto il nuovo periodo
			periodoLiberoSx.setDataInizioPeriodoDaDataInizioPeriodo(cameraState.get_periodo());
			periodoLiberoSx.setDataFinePeriodoDaDataInizioPeriodo(periodoRichiesta);
			// Setto il periodo allo stato
			StatoCamera cameraStateLiberoSx = new StatoCameraLibera();
			cameraStateLiberoSx.set_periodo(periodoLiberoSx);
			
			// - Occupato 
			StatoCamera cameraStateOccupato = new StatoCameraOccupata();
			cameraStateOccupato.set_periodo(periodoRichiesta);
			
			// - Libero Destra
			Periodo periodoLiberoDx = new Periodo();
			// Imposto il nuovo periodo
			periodoLiberoDx.setDataInizioPeriodoDaDataFinePeriodo(periodoRichiesta);
			periodoLiberoDx.setDataFinePeriodoDaDataFinePeriodo(cameraState.get_periodo());
			// Setto il periodo allo stato
			StatoCamera cameraStateLiberoDx = new StatoCameraLibera();
			cameraStateLiberoDx.set_periodo(periodoLiberoDx);
			
		// Aggiungo stati alla lista
		nuoviStati.add(cameraStateLiberoSx);
		nuoviStati.add(cameraStateOccupato);
		nuoviStati.add(cameraStateLiberoDx);
		
		return nuoviStati;
	}

}
