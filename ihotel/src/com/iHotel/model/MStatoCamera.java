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
	
	
	/**
	 * @param periodo
	 * @return 
	 * */
	public MStatoCamera getStatoContenente(MPeriodo periodo){
		
		// Data di inizio del periodo contenuto
		GregorianCalendar dataInizioPeriodoContenuto= new GregorianCalendar();
		dataInizioPeriodoContenuto.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		// Data di fine del periodo contenuto
		GregorianCalendar dataFinePeriodoContenuto= new GregorianCalendar();
		dataFinePeriodoContenuto.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		// Data di inizio dello MStatoCamera
		GregorianCalendar dataInizio = new GregorianCalendar();
		dataInizio.set(_periodo.get_annoInizio(), _periodo.get_meseInizio(), _periodo.get_giornoInizio());
		// Data di fine dello MStatoCamera
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(_periodo.get_annoFine(), _periodo.get_meseFine(), _periodo.get_giornoFine());
		
		if(dataInizio.compareTo(dataInizioPeriodoContenuto)!=1 && dataFine.compareTo(dataFinePeriodoContenuto)!=-1){
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