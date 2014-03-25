package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class CameraOccupata extends CameraState {

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

}
