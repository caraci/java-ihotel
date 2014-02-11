package com.iHotel.model;

import java.util.GregorianCalendar;



public class MPrezzoCamera {

	private MPeriodo _periodo;
	private double _prezzo;
	

	/**
	 * 
	 * @param periodo
	 */
	public MPrezzoCamera getPrezzoInPeriodo(MPeriodo periodo){
		
		//trasformo il periodo per cui bisogna richiedere il prezzo in data
		// Data di inizio
		GregorianCalendar dataInizioRichiesta= new GregorianCalendar();
		dataInizioRichiesta.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		// Data di fine
		GregorianCalendar dataFineRichiesta= new GregorianCalendar();
		dataFineRichiesta.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		//Prendo il periodo associato al prezzo e lo trasformo in date
		// Data di inizio del MPrezzoCamera
		GregorianCalendar dataInizioPrezzo = new GregorianCalendar();
		dataInizioPrezzo.set(_periodo.get_annoInizio(), _periodo.get_meseInizio(), _periodo.get_giornoInizio());
		// Data di fine del MPrezzoCamera
		GregorianCalendar dataFinePrezzo= new GregorianCalendar();
		dataFinePrezzo.set(_periodo.get_annoFine(), _periodo.get_meseFine(), _periodo.get_giornoFine());
		
		// Controllo se il periodo è corretto
		
		if(dataFineRichiesta.compareTo(dataInizioPrezzo)==-1 || dataInizioRichiesta.compareTo(dataFinePrezzo)==1)
		{
			return null;
		}else {
			return this;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public double get_prezzo() {
		return this._prezzo;
	}

	/**
	 * 
	 * @param _prezzo
	 */
	public void set_prezzo(double _prezzo) {
		this._prezzo = _prezzo;
	}

	public MPeriodo get_periodo() {
		return _periodo;
	}

	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	

}