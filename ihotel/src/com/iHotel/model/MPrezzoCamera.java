package com.iHotel.model;

import java.util.GregorianCalendar;



public class MPrezzoCamera {

	/* -------------------------- Attributi ------------------------------- */
	private MPeriodo _periodo;
	private double _prezzo;
	
	/* ---------------------- Metodi di instanza --------------------------- */ 
	/**
	 * Metodo per farsi restituire un MPrezzoCamera, se il periodo passato come parametro, ha almeno un giorno in comune 
	 * con quello relativo all'oggetto su cui si invoca il metodo.
	 * @param periodo
	 * @return MPrezzoCamera
	 */
	public MPrezzoCamera getPrezzoInPeriodo(MPeriodo periodo){
		
		// Periodo di richiesta
			// Data di inizio
			GregorianCalendar dataInizioPrenotazione= new GregorianCalendar();
			dataInizioPrenotazione.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
			// Data di fine
			GregorianCalendar dataFinePrenotazione= new GregorianCalendar();
			dataFinePrenotazione.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		// Periodo dell' MPrezzoCamera
			// Data di inizio del MPrezzoCamera
			GregorianCalendar dataInizioPrezzo = new GregorianCalendar();
			dataInizioPrezzo.set(_periodo.get_annoInizio(), _periodo.get_meseInizio(), _periodo.get_giornoInizio());
			// Data di fine del MPrezzoCamera
			GregorianCalendar dataFinePrezzo= new GregorianCalendar();
			dataFinePrezzo.set(_periodo.get_annoFine(), _periodo.get_meseFine(), _periodo.get_giornoFine());
			
		if(dataInizioPrezzo.compareTo(dataFinePrenotazione)!=1 && dataInizioPrezzo.compareTo(dataInizioPrenotazione)!=-1 ||
				dataFinePrezzo.compareTo(dataInizioPrenotazione)!=-1 && dataFinePrezzo.compareTo(dataFinePrenotazione)!=1) {
			return this;
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @return double
	 * Metodo che restituisce il prezzo relativo a un MPrezzoCamera
	 */
	public double get_prezzo() {
		return this._prezzo;
	}

	/**
	 * 
	 * @param _prezzo
	 * Metodo che setta il prezzo relativo a un MPrezzoCamera
	 */
	public void set_prezzo(double _prezzo) {
		this._prezzo = _prezzo;
	}

	/**
	 * 
	 * @return double
	 * Metodo che restituisce il periodo relativo a un MPrezzoCamera
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}
	
	/**
	 * @param _periodo 
	 * Metodo che setta il periodo relativo a un MPrezzoCamera
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	

}