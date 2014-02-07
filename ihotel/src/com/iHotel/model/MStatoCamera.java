package com.iHotel.model;

import java.util.GregorianCalendar;

public class MStatoCamera {

	private MPeriodo _periodo;
	private boolean _libera;

	/**
	 * @return the _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * 
	 * @return
	 */
	public boolean get_libera() {
		return this._libera;
	}

	/**
	 * 
	 * @param _libera
	 */
	public void set_libera(boolean _libera) {
		this._libera = _libera;
	}
	/*
	 * 
	 * @param periodo
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodo){
		
		GregorianCalendar dataInizioPrenotazione= new GregorianCalendar();
		dataInizioPrenotazione.set(periodo.get_ai(), periodo.get_mi(), periodo.get_gi());
		
		GregorianCalendar dataFinePrenotazione= new GregorianCalendar();
		dataFinePrenotazione.set(periodo.get_af(), periodo.get_mf(), periodo.get_gf());
		
		GregorianCalendar dataInizio= new GregorianCalendar();
		dataInizio.set(_periodo.get_ai(), _periodo.get_mi(), _periodo.get_gi());
		
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(_periodo.get_af(), _periodo.get_mf(), _periodo.get_gf());

		if(dataInizioPrenotazione.compareTo(dataInizio)==-1 && dataInizioPrenotazione.compareTo()
				){}
		
		
		
		
		if( _periodo.get_dataFine()<= periodo.get_dataFine() && _periodo.get_dataFine()>=periodo.get_dataInizio() || 
				_periodo.get_dataInizio()<=periodo.get_dataFine()&& _periodo.get_dataInizio()>=periodo.get_dataInizio()){
			System.out.print("periodo buono");
			if (this.get_libera()==false){
				System.out.print("falso");
				return false;
			}
		}
		System.out.print("vero");
		return true;
	}

}