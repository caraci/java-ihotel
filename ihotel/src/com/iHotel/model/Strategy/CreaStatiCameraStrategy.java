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

	public LinkedList<CameraState> creaNuoviStati(CameraState cameraState, Periodo periodoRichiesta);
}
