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
	protected Prezzo _prezzoServizi;
	/**
	 * Costruttore
	 */
	protected CameraState() {
		_serviziInterni=new ArrayList<ServizioInterno>();
		_ospiti=new ArrayList<Ospite>();
	}
	/* ------------------------ Metodi di instanza --------------------------- */
	
	public abstract LinkedList<CameraState> occupaInPeriodo(Periodo periodo);
	public abstract boolean isLiberaInPeriodo(Periodo periodo);
	public abstract Prezzo getPrezzoTotaleServizi(Periodo periodo);
	public abstract void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo);
	public abstract ArrayList<ServizioInterno> getServiziInterni();
	public abstract ArrayList<Ospite> getOspiti();
	
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
	/**
	 * @return the _prezzoServizi
	 */
	public Prezzo get_prezzoServizi() {
		return _prezzoServizi;
	}
	/**
	 * @param _prezzoServizi the _prezzoServizi to set
	 */
	public void set_prezzoServizi(Prezzo _prezzoServizi) {
		this._prezzoServizi = _prezzoServizi;
	}
}

