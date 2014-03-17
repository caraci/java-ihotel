package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Strategy.CreaStatiCameraStrategy;
import com.iHotel.model.Strategy.CreaStatiCameraStrategyFactory;
import com.iHotel.model.Utility.Periodo;

public class CameraLibera extends CameraState {

	@Override
	/**
	 * 
	 */
	public LinkedList<CameraState> occupaInPeriodo(Periodo periodoRichiesta) {
		LinkedList<CameraState> nuoviStatiCamera=null;
		// Controllo che il periodo della richiesta è contenuto nel periodo dell'instanza.
		if (_periodo.contiene(periodoRichiesta)) {
			CreaStatiCameraStrategy creaStatiCameraStrategy = CreaStatiCameraStrategyFactory.getInstance().getStrategy(_periodo, periodoRichiesta);
			nuoviStatiCamera=creaStatiCameraStrategy.creaNuoviStati(this, periodoRichiesta);
		}
		return nuoviStatiCamera;
	}

	@Override
	/**
	 * Controllo se il periodo dello stato della camera, contiene il periodo ricevuto come parametro.
	 */
	public boolean isLiberaInPeriodo(Periodo periodo) {
		boolean esito;
		if(this.get_periodo().contiene(periodo)) {
			esito=true;
		} else {
			esito=false;
		}
		return esito;
	}
}
