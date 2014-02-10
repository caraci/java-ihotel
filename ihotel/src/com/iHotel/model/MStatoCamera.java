package com.iHotel.model;

import java.util.GregorianCalendar;

public class MStatoCamera {

	private MPeriodo _periodo;
	private boolean _libera;
	
	
	/**
	 * Metodo per verificare se lo stato è libero in un periodo.
	 * 
	 * @param periodo
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodo) {
		
		// Data di inizio della richiesta di prenotazione
		GregorianCalendar dataInizioPrenotazione= new GregorianCalendar();
		dataInizioPrenotazione.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		// Data di fine della richiesta di prenotazione
		GregorianCalendar dataFinePrenotazione= new GregorianCalendar();
		dataFinePrenotazione.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		// Data di inizio dello MStatoCamera
		GregorianCalendar dataInizio = new GregorianCalendar();
		dataInizio.set(_periodo.get_annoInizio(), _periodo.get_meseInizio(), _periodo.get_giornoInizio());
		// Data di fine dello MStatoCamera
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(_periodo.get_annoFine(), _periodo.get_meseFine(), _periodo.get_giornoFine());
		
		
		// Controllo se il periodo è corretto
		
		if(dataInizio.compareTo(dataFinePrenotazione)!=1 && dataInizio.compareTo(dataInizioPrenotazione)!=-1 ||
				dataFine.compareTo(dataInizioPrenotazione)!=-1 && dataFine.compareTo(dataFinePrenotazione)!=1)
		{
			
			if(_libera==true){
				
				return true;
			} else {
				
				return false;
			}
		} else {
			return false;
		}	
	} 
	
	public MStatoCamera getStatoContenente(MPeriodo periodo){
		return null;
	}
	
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
	

}