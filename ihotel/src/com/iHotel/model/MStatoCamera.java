package com.iHotel.model;

import java.util.GregorianCalendar;

public class MStatoCamera {

	private MPeriodo _periodo;
	private boolean _libera;
	
	
	/**
	 * @param periodo
	 * @return boolean
	 * Metodo per verificare se lo stato è libero in un periodo.
	 * 
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodoRichiesta) {
		// Controllo se il periodo dello statoCamera contiene il periodo della richiesta e se lo stato è libero.
		if(_periodo.contiene(periodoRichiesta) && _libera==true) {
			return true;
		} else {
			return false;
		}		
	} 
	
	
	/** Metodo che restituisce lo stato camera se il periodo su cui è definito lo stato contiene il periodo 
	 * che riguarda la prenotazione
	 * @param periodo
	 * @return this
	 * */
	public MStatoCamera getStatoContenente(MPeriodo periodo){
			
		if(this.get_periodo().contiene(periodo)==true){
			return this;
		}
		else return null;
	}
	
	/**
	 * @return the _periodo
	 * Metodo che restituisce il periodo dello statoCamera
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo
	 * metodo che setta il periodo dello statoCamera
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * 
	 * @return
	 * Metodo
	 */
	public boolean get_libera() {
		return this._libera;
	}

	/**
	 * 
	 * @param _libera
	 * Metodo che setta 
	 */
	public void set_libera(boolean _libera) {
		this._libera = _libera;
	}
	

}