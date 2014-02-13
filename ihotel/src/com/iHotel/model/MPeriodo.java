package com.iHotel.model;

import java.util.GregorianCalendar;

public class MPeriodo {

	/* --------------------- Attributi -------------------------- */
	private int _giornoInizio;
	private int _meseInizio;
	private int _annoInizio;
	private int _oraInizio;
	private int _minutoInizio;
	
	private int _giornoFine;
	private int _meseFine;
	private int _annoFine;
	private int _oraFine;
	private int _minutoFine;
	
	
	/* --------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per verificare che il periodo passato come paramentro è contenuto all'interno del periodo relativo all'oggetto
	 * sul quale si sta invocando il metodo.
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo è contenuto. False altrimenti.
	 */
	public boolean contiene (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio, _oraInizio, _minutoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine, _oraFine, _minutoFine);
		if(dataInizioPeriodo.compareTo(dataInizioRichiesta)<=0 && dataFinePeriodo.compareTo(dataFineRichiesta) >=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo passato come parametro si sovrappone con quello passato come parametro 
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo si sovrappone. False altrimenti.
	 */
	public boolean sovrappone (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		if(dataInizioPeriodo.compareTo(dataFineRichiesta)<=0 && dataFinePeriodo.compareTo(dataInizioRichiesta) >=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	
	/* ------------------------- Getter, Setter ------------------------------------- */
	/**
	 * @return _annoFine
	 * Metodo che restituisce l'intero che rappresenta l'anno della data di fine periodo
	 */
	public int get_annoFine() {
		return _annoFine;
	}
	/**
	 * @param _annoFine 
	 * Metodo che setta l'intero che rappresenta l'anno della data di fine periodo
	 */
	public void set_annoFine(int _annoFine) {
		this._annoFine = _annoFine;
	}
	/**
	 * @return _meseFine
	 * metodo che restituisce l'intero che rappresenta il mese della data di fine periodo
	 */
	public int get_meseFine() {
		return _meseFine;
	}
	/**
	 * @param _meseFine 
	 * Metodo che setta l'intero che rappresenta il mese della data di fine periodo
	 */
	public void set_meseFine(int _meseFine) {
		this._meseFine = _meseFine;
	}
	/**
	 * @return the _giornoFine
	 * Metodo che restituisce l'intero che rappresenta il giorno della data di fine periodo
	 */
	public int get_giornoFine() {
		return _giornoFine;
	}
	/**
	 * @param _giornoFine
	 * Metodo che setta l'intero che rappresenta il giorno della data di fine periodo
	 */
	public void set_giornoFine(int _giornoFine) {
		this._giornoFine = _giornoFine;
	}
	/**
	 * @return the _annoInizio
	 * Metodo che restituisce l'intero che rappresenta l'anno della data di inizio periodo
	 */
	public int get_annoInizio() {
		return _annoInizio;
	}
	/**
	 * @param _annoInizio the _annoInizio to set
	 * Metodo che setta l'intero che rappresenta l'anno della data di inizio periodo
	 */
	public void set_annoInizio(int _annoInizio) {
		this._annoInizio = _annoInizio;
	}
	/**
	 * @return the _meseInizio
	 * Metodo che restituisce l'intero che rappresenta il mese della data di inizio periodo
	 */
	public int get_meseInizio() {
		return _meseInizio;
	}
	/**
	 * @param _meseInizio
	 * Metodo che setta l'intero che rappresenta il mese della data di inizio periodo 
	 */
	public void set_meseInizio(int _meseInizio) {
		this._meseInizio = _meseInizio;
	}
	/**
	 * @return the _giornoInizio
	 * Metodo che restituisce l'intero che rappresenta il giorno della data di inizio periodo
	 */
	public int get_giornoInizio() {
		return _giornoInizio;
	}
	/**
	 * @param _giornoInizio
	 * Metodo che setta l'intero che rappresenta il giorno della data di inizio periodo 
	 */
	public void set_giornoInizio(int _giornoInizio) {
		this._giornoInizio = _giornoInizio;
	}
	
	

	
	
	

}