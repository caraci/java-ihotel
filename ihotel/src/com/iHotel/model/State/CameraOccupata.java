package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Utility.Periodo;

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

}
