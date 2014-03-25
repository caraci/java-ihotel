/**
 * 
 */
package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public abstract class CameraState {
	/* -------------------------- Attributi ---------------------------------- */
	protected Periodo _periodo;
	protected ArrayList<Ospite> _ospiti;
	protected ArrayList<ServizioInterno> _serviziInterni;
	
	/* ------------------------ Metodi di instanza --------------------------- */
	
	public abstract LinkedList<CameraState> occupaInPeriodo(Periodo periodo);
	public abstract boolean isLiberaInPeriodo(Periodo periodo);
	public abstract Prezzo getPrezzoTotaleServizi(Periodo periodo);
	public abstract void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo);
	
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

