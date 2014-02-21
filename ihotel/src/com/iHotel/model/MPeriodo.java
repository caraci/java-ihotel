package com.iHotel.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.iHotel.utility.UDefaultLoader;

public class MPeriodo {

	/* ----------------------------------------- Attributi e costruttore ------------------------------------- */
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
	
	/**
	 * Costruttore privato - pattern Singleton
	 */	
	public MPeriodo() {
		/*
		 * Si prendono minutoInizio, oraInizio, minutoFine e oraFine dal defaultLoader, togliendo dalla classe  
		 * MPeriodo la responsabilità di recuperare i dati di default.
		 */
		
		UDefaultLoader defaultLoader = UDefaultLoader.getInstance();
		ArrayList<Integer> orarioDefault = new ArrayList<Integer>();
		orarioDefault = defaultLoader.getMinutoOraInizioMinutoOraFine();
		_minutoInizio = orarioDefault.get(0).intValue();
		_oraInizio= orarioDefault.get(1).intValue();
		_minutoFine = orarioDefault.get(2).intValue();
		_oraFine=orarioDefault.get(3).intValue();
	}
	/* --------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per verificare che il periodo passato come paramentro è contenuto all'interno del periodo relativo all'oggetto
	 * sul quale si sta invocando il metodo.
	 * 
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo è contenuto. False altrimenti.
	 */
	public boolean contiene (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio(), periodoRichiesta.get_oraInizio(), periodoRichiesta.get_minutoInizio(),1);
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine(), periodoRichiesta.get_oraFine(), periodoRichiesta.get_minutoFine(),0);
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio, _oraInizio, _minutoInizio,0);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine, _oraFine, _minutoFine,59);
		// Controllo se il periodoRichiesta è contenuto in periodo.
		if(dataInizioPeriodo.compareTo(dataInizioRichiesta)<=0 && dataFinePeriodo.compareTo(dataFineRichiesta) >=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo passato come parametro si sovrappone con quello passato come parametro.
	 * 
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo si sovrappone. False altrimenti.
	 */
	public boolean sovrappone (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio(), periodoRichiesta.get_oraInizio(), periodoRichiesta.get_minutoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine(), periodoRichiesta.get_oraFine(), periodoRichiesta.get_minutoFine());
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio, _oraInizio, _minutoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine, _oraFine, _minutoFine);
		// Controllo se periodoRichiesta si sovrapponde con periodo.
		if(dataInizioPeriodo.compareTo(dataFineRichiesta)<=0 && dataFinePeriodo.compareTo(dataInizioRichiesta) >=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo dell'instanza segue quello del periodo passato come parametro.
	 * 
	 * @param periodoRichiesta Periodo da analizzare.
	 * @return True se il periodo dell'instanza precede quello passato per parametro. False altrimenti.
	 */
	public boolean segue (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		// Controllo se il periodo della instanza segue quello della richiesta.
		if (
		   dataInizioPeriodo.get(Calendar.DATE) == dataFineRichiesta.get(Calendar.DATE) &&
		   dataInizioPeriodo.get(Calendar.MONTH) == dataFineRichiesta.get(Calendar.MONTH) &&
		   dataInizioPeriodo.get(Calendar.YEAR) == dataFineRichiesta.get(Calendar.YEAR)
		   ) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo dell'instanza anticipa quello del periodo passato come parametro.
	 * 
	 * @param periodoRichiesta Periodo da analizzare.
	 * @return True se il periodo dell'instanza anticipa quello passato per parametro. False altrimenti.
	 */
	public boolean anticipa (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		// Periodo dell'instanza
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo se il periodo della instanza segue quello della richiesta.
		if (
		   dataInizioRichiesta.get(Calendar.DATE) == dataFinePeriodo.get(Calendar.DATE) &&
		   dataInizioRichiesta.get(Calendar.MONTH) == dataFinePeriodo.get(Calendar.MONTH) &&
		   dataInizioRichiesta.get(Calendar.YEAR) == dataFinePeriodo.get(Calendar.YEAR)
		   ) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo dell'instanza è esattamente compreso tra due periodi. 
	 * Per esattamente si intende che non sono presenti "buchi" tra il periodo precedente e quello successivo.
	 * 
	 * @param periodoPrecedente Periodo precedente a quello dell'instanza.
	 * @param periodoSuccessivo Periodo successivo a quello dell'instanza.
	 * @return True se il periodo dell'instanza è esattamente contenuto. False altrimenti.
	 */
	public boolean contenutoTraPeriodi (MPeriodo periodoPrecedente, MPeriodo periodoSuccessivo) {
		boolean esito;
		// Controllo se il periodo è esattamente contenuto tra due periodi
		if(this.segue(periodoPrecedente) && this.anticipa(periodoSuccessivo)) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo che setta la data inizio dell'istanza su cui è invocato, alla data di inizio del periodo
	 * passato come parametro.
	 * 
	 * @param periodo
	 */
	public void setDataInizioPeriodoDaDataInizioPeriodo(MPeriodo periodo){
		this.set_minutoInizio(periodo.get_minutoInizio());
		this.set_oraInizio(periodo.get_oraInizio());
		this.set_giornoInizio(periodo.get_giornoInizio());
		this.set_meseInizio(periodo.get_meseInizio());
		this.set_annoInizio(periodo.get_annoInizio());
	}
	/**
	 * Metodo che setta la data di inizio dell'istanza su cui è invocato, alla data di fine del periodo
	 * passato come parameto. Per ora e minuto si prendono i parametri di "default" _minutoInizio e _oraInizio,
	 * altrimenti il periodo comincerebbe in un orario sbagliato.
	 * 
	 * @param periodo
	 */
	public void setDataInizioPeriodoDaDataFinePeriodo(MPeriodo periodo){
		this.set_minutoInizio(this.get_minutoInizio());
		this.set_oraInizio(this.get_oraInizio());
		this.set_giornoInizio(periodo.get_giornoFine());
		this.set_meseInizio(periodo.get_meseFine());
		this.set_annoInizio(periodo.get_annoFine());
	}
	/**
	 * Metodo che setta la data di fine del periodo dell'istanza su cui è invocato, alla fine del periodo
	 * passato come parametro.
	 * 
	 * @param periodo
	 */
	public void setDataFinePeriodoDaDataFinePeriodo(MPeriodo periodo){		
		this.set_minutoFine(periodo.get_minutoFine());
		this.set_oraFine(periodo.get_oraFine());
		this.set_giornoFine(periodo.get_giornoFine());
		this.set_meseFine(periodo.get_meseFine());
		this.set_annoFine(periodo.get_annoFine());
		
	}	
	/**
	 * Metodo che setta la data di fine del periodo su cui è invocato, alla data di inizio del periodo
	 * passato come parametro. Per ora e minuto si assegnano i valori di default presi da _oraFine, _minutoFine
	 * altrimenti la data di fine sarebbe sbagliata.
	 * 
	 * @param periodo
	 */
	public void setDataFinePeriodoDaDataInizioPeriodo(MPeriodo periodo){
		this.set_minutoFine(this.get_minutoFine());
		this.set_oraFine(this.get_oraFine());
		this.set_giornoFine(periodo.get_giornoInizio());
		this.set_meseFine(periodo.get_meseInizio());
		this.set_annoFine(periodo.get_annoInizio());
	}
	/**
	 * Metodo che confronta il giorno di inizio dell'istanza su cui è invocato, con quello del periodo passato
	 * come parametro.
	 * 
	 * @param periodo
	 * @return True se i giorni di inizio sono uguali. False altrimenti.
	 */
	public boolean IniziaStessoGiornoInizioDi(MPeriodo periodo){
		if (this.get_giornoInizio()==periodo.get_giornoInizio()&&
				this.get_meseInizio()==periodo.get_meseInizio()&&
				this.get_annoInizio()==periodo.get_annoInizio()){
			return true;			
		}
		return false;
	}
	/**
	 * Metodo che confronta il giorno di fine dell'istanza su cui è invocato, con quello del periodo passato
	 * come parametro.
	 * @param periodo
	 * @return True se i periodi finiscono lo stesso giorno. False altrimenti.
	 */
	public boolean FinisceStessoGiornoFineDi(MPeriodo periodo){
		if(this.get_giornoFine()==periodo.get_giornoFine()&&
				this.get_meseFine()==periodo.get_meseFine()&&
				this.get_annoFine()==periodo.get_annoFine()){
			return true;
		}
		return false;
	}
	/**
	 * Metodo per settare la data di inizio del periodo da una data.
	 * 
	 * @param data Data attraverso la quale si setta l'inizio del periodo.
	 */
	public void setDataInizioDaData (GregorianCalendar data) {
		this.set_giornoInizio(data.get(Calendar.DATE));
		this.set_meseInizio(data.get(Calendar.MONTH));
		this.set_annoInizio(data.get(Calendar.YEAR));
	}
	/**
	 * Metodo per settare la data di fine del periodo da una data.
	 * 
	 * @param data Data attraverso la quale si setta la fine del periodo.
	 */
	public void setDataFineDaData(GregorianCalendar data) {
		this.set_giornoFine(data.get(Calendar.DATE));
		this.set_meseFine(data.get(Calendar.MONTH));
		this.set_annoFine(data.get(Calendar.YEAR));
	}
	
	
	/* ------------------------- Getter, Setter ------------------------------------- */
	/**
	 * @return _annoFine
	 */
	public int get_annoFine() {
		return _annoFine;
	}
	/**
	 * @param _annoFine 
	 */
	public void set_annoFine(int _annoFine) {
		this._annoFine = _annoFine;
	}
	/**
	 * @return _meseFine
	 */
	public int get_meseFine() {
		return _meseFine;
	}
	/**
	 * @param _meseFine 
	 */
	public void set_meseFine(int _meseFine) {
		this._meseFine = _meseFine;
	}
	/**
	 * @return _giornoFine
	 */
	public int get_giornoFine() {
		return _giornoFine;
	}
	/**
	 * @param _giornoFine
	 */
	public void set_giornoFine(int _giornoFine) {
		this._giornoFine = _giornoFine;
	}
	/**
	 * @return _annoInizio
	 */
	public int get_annoInizio() {
		return _annoInizio;
	}
	/**
	 * @param _annoInizio
	 */
	public void set_annoInizio(int _annoInizio) {
		this._annoInizio = _annoInizio;
	}
	/**
	 * @return _meseInizio
	 */
	public int get_meseInizio() {
		return _meseInizio;
	}
	/**
	 * @param _meseInizio
	 */
	public void set_meseInizio(int _meseInizio) {
		this._meseInizio = _meseInizio;
	}
	/**
	 * @return _giornoInizio
	 */
	public int get_giornoInizio() {
		return _giornoInizio;
	}
	/**
	 * @param _giornoInizio
	 */
	public void set_giornoInizio(int _giornoInizio) {
		this._giornoInizio = _giornoInizio;
	}
	/**
	 * @return _oraInizio
	 */
	public int get_oraInizio() {
		return _oraInizio;
	}
	/**
	 * @param _oraInizio
	 */
	public void set_oraInizio(int _oraInizio) {
		this._oraInizio = _oraInizio;
	}
	/**
	 * @param _oraFine
	 */
	public void set_oraFine(int _oraFine) {
		this._oraFine = _oraFine;
	}
	/**
	 * @return _oraFine
	 */
	public int get_oraFine() {
		return _oraFine;
	}
	/**
	 * @param _minutoInizio
	 */
	public void set_minutoInizio(int _minutoInizio) {
		this._minutoInizio = _minutoInizio;
	}
	/**
	 * @return _minutoInizio
	 */
	public int get_minutoInizio() {
		return _minutoInizio;
	}
	/**
	 * @param _minutoFine
	 */
	public void set_minutoFine(int _minutoFine) {
		this._minutoFine= _minutoFine;
	}
	/**
	 * @return _minutoFine
	 */
	public int get_minutoFine() {
		return _minutoFine;
	}
	
	
	

	
	
	

}