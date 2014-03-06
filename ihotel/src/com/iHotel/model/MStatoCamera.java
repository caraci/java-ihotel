package com.iHotel.model;

import com.iHotel.model.Utility.MPeriodo;

public class MStatoCamera {

	/* ------------------------ Attributi ---------------- */
	private MPeriodo _periodo;
	private boolean _libera;
	
	/* --------------------- Metodi di instanza ---------------- */
	/**
	 * Metodo per verificare se lo stato è libero in un periodo.
	 * 
	 * @param periodo Periodo da controllare
	 * @return boolean True se libero. False altrimenti.
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodoRichiesta) {
		// Controllo se il periodo dello statoCamera contiene il periodo della richiesta e se lo stato è libero.
		if(_periodo.contiene(periodoRichiesta) && _libera==true) {
			return true;
		} else {
			return false;
		}		
	} 
	/** 
	 * Metodo che restituisce l'instanza stessa, se il suo periodo, contiene quello ricevuto per paramentro.
	 * 
	 * @param periodo Periodo da controllare.
	 * @return this 
	 * */
	public MStatoCamera getStatoContenente(MPeriodo periodo){
			
		if(this.get_periodo().contiene(periodo)==true){
			return this;
		}
		else return null;
	}
	/* ----------------------- Getter, Setter ------------------- */
	/**
	 * @return _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * @return  _libera
	 */
	public boolean get_libera() {
		return this._libera;
	}

	/**
	 * @param _libera
	 */
	public void set_libera(boolean _libera) {
		this._libera = _libera;
	}
	

}