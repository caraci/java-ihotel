/**
 * 
 */
package com.iHotel.model.Strategy;

import java.util.LinkedList;

import com.iHotel.model.Albergo.Camera.StatoCamera;
import com.iHotel.model.Albergo.Camera.StatoCameraLibera;
import com.iHotel.model.Albergo.Camera.StatoCameraOccupata;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe addetta alla creazione di nuovi stati camera, quando il periodo della prenotazione che si vuole effettuare finisce
 * lo stesso giorno dello stato contenente.
 * 
 * @author Eugenio
 */
public class RightCreaStatiCameraStrategy implements CreaStatiCameraStrategy {

	@Override
	public LinkedList<StatoCamera> creaNuoviStati(StatoCamera cameraState, Periodo periodoRichiesta) {
		// Lista da restituire
		LinkedList<StatoCamera> nuoviStati = new LinkedList<StatoCamera>();
		// Nuovi stati
			// - Occupato 
			StatoCamera cameraStateOccupato = new StatoCameraOccupata();
			cameraStateOccupato.set_periodo(periodoRichiesta);
			// - Libero
			Periodo periodoLibero = new Periodo();
			// Imposto il nuovo periodo
			periodoLibero.setDataInizioPeriodoDaDataInizioPeriodo(cameraState.get_periodo());
			periodoLibero.setDataFinePeriodoDaDataInizioPeriodo(periodoRichiesta);
			// Setto il periodo allo stato
			StatoCamera cameraStateLibero = new StatoCameraLibera();
			cameraStateLibero.set_periodo(periodoLibero);
			
		// Aggiungo stati alla lista
		nuoviStati.add(cameraStateLibero);
		nuoviStati.add(cameraStateOccupato);
		return nuoviStati;
	}

}
