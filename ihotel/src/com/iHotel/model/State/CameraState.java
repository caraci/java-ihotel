/**
 * 
 */
package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Utility.Periodo;

/**
 * @author Eugenio
 *
 */
public abstract class CameraState {
	/* -------------------------- Attributi ---------------------------------- */
	protected Periodo _periodo;
	
	/* ------------------------ Metodi di instanza --------------------------- */
	
	public abstract LinkedList<CameraState> occupaInPeriodo(Periodo periodo);
	public abstract boolean isLiberaInPeriodo(Periodo periodo);
	
	/* -------------------------- Getter, Setter ----------------------------- */
	/**
	 * @return the _periodo
	 */
	public Periodo get_periodo() {
		return _periodo;
	}
	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
}

