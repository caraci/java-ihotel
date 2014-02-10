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
			return this;
		}else {
			return null;
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