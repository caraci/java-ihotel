package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class CameraStateOccupata extends CameraState {

	@Override
	/**
	 * 
	 */
	public LinkedList<CameraState> occupaInPeriodo(Periodo periodo) {
		return null;
	}

	@Override
	public boolean isLiberaInPeriodo(Periodo periodo) {
		return false;
	}

	@Override
	public Prezzo getPrezzoTotaleServizi(Periodo periodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiungiServizioInPeriodo(ServizioInterno servizio,
			Periodo periodo) {
		// TODO Auto-generated method stub
		
	}

}
