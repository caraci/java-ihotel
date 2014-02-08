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
		dataInizioPrenotazione.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		
		GregorianCalendar dataFinePrenotazione= new GregorianCalendar();
		dataFinePrenotazione.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		GregorianCalendar dataInizio= new GregorianCalendar();
		dataInizio.set(_periodo.get_annoInizio(), _periodo.get_meseInizio(), _periodo.get_giornoInizio());
		
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(_periodo.get_annoFine(), _periodo.get_meseFine(), _periodo.get_giornoFine());

		//controllo se il periodo è corretto
		if(dataInizio.compareTo(dataFinePrenotazione)==-1 && dataInizio.compareTo(dataInizioPrenotazione)==1 ||
				dataFine.compareTo(dataInizioPrenotazione)==1 && dataFine.compareTo(dataFinePrenotazione)==-1)
		{
			if(_libera){
				return true;
			} else {
				return false;
			}
			
			
		} else {
			return false;
		}
		
	}

}