/**
 * 
 */
package com.iHotel.model.Strategy;

import com.iHotel.model.State.CameraState;
import com.iHotel.model.Utility.Periodo;
import java.util.LinkedList;

/**
 * @author Eugenio
 *
 */
public interface CreaStatiCameraStrategy {
	/**
	 * Metodo per creare nuovi stati della camera in seguito all'occupazione di quest'ultima in un certo periodo.
	 * @param cameraState Stato camera nel quale si va ad inserire la nuova prenotazione.
	 * @param periodoRichiesta Periodo in cui si effettua l'occupazione.
	 * @return Lista di stati camera coerenti con l'occupazione.
	 */
	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta);
}
