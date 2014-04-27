package com.iHotel.model.Utility;

import java.util.Calendar;

public class Periodo {

	/* ----------------------------------------- Attributi e costruttore ------------------------------------- */
	private int _giornoInizio;
	private int _meseInizio;
	private int _annoInizio;
	
	private int _giornoFine;
	private int _meseFine;
	private int _annoFine;
	
	/**
	 * Costruttore privato - pattern Singleton
	 */	
	public Periodo() {}
	/* --------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per verificare che il periodo passato come paramentro coincide esattamente con il periodo relativo 
	 * all'oggetto sul quale si sta invocando il metodo.
	 * 
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo è contenuto. False altrimenti.
	 */
	public boolean coincideCon(Periodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		MyDate dataInizioRichiesta = new MyDate();
		MyDate dataFineRichiesta = new MyDate();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = new MyDate();
		MyDate dataFinePeriodo = new MyDate();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo se il periodoRichiesta coincide con il periodo dell'istanza
		if(dataInizioPeriodo.compareTo(dataInizioRichiesta)==0 && dataFinePeriodo.compareTo(dataFineRichiesta)==0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	
	/**
	 * Metodo per verificare che il periodo passato come paramentro è contenuto all'interno del periodo relativo all'oggetto
	 * sul quale si sta invocando il metodo.
	 * 
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo è contenuto. False altrimenti.
	 */
	public boolean contiene (Periodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		MyDate dataInizioRichiesta = new MyDate();
		MyDate dataFineRichiesta = new MyDate();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = new MyDate();
		MyDate dataFinePeriodo = new MyDate();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo se il periodoRichiesta è contenuto in periodo.
		if(dataInizioPeriodo.compareTo(dataInizioRichiesta)<=0 && dataFinePeriodo.compareTo(dataFineRichiesta)>=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che la data passata come paramentro è contenuta all'interno del periodo relativo all'oggetto
	 * sul quale si sta invocando il metodo.
	 * 
	 * @param dataRichiesta Data da confrontare
	 * @return True se la data è contenuta. False altrimenti.
	 */
	public boolean contieneData(MyDate dataRichiesta) {
		boolean esito;
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = new MyDate();
		MyDate dataFinePeriodo = new MyDate();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo se il periodoRichiesta è contenuto in periodo.
		if(dataInizioPeriodo.compareTo(dataRichiesta)<=0 && dataFinePeriodo.compareTo(dataRichiesta)>=0) {
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
	public boolean sovrappone (Periodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		MyDate dataInizioRichiesta = new MyDate();
		MyDate dataFineRichiesta = new MyDate();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = new MyDate();
		MyDate dataFinePeriodo = new MyDate();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
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
	public boolean segue (Periodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		MyDate dataFineRichiesta = new MyDate();
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = new MyDate();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		// Controllo se il periodo della instanza segue quello della richiesta.
		if (dataInizioPeriodo.compareTo(dataFineRichiesta)==0) {
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
	public boolean anticipa (Periodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		MyDate dataInizioRichiesta = new MyDate();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		// Periodo dell'instanza
		MyDate dataFinePeriodo = new MyDate();
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo se il periodo della instanza segue quello della richiesta.
		if (dataInizioRichiesta.compareTo(dataFinePeriodo)==0) {
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
	public boolean contenutoTraPeriodi (Periodo periodoPrecedente, Periodo periodoSuccessivo) {
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
	public void setDataInizioPeriodoDaDataInizioPeriodo(Periodo periodo){
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
	public void setDataInizioPeriodoDaDataFinePeriodo(Periodo periodo){
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
	public void setDataFinePeriodoDaDataFinePeriodo(Periodo periodo){
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
	public void setDataFinePeriodoDaDataInizioPeriodo(Periodo periodo){
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
	public boolean IniziaStessoGiornoInizioDi(Periodo periodo){
		boolean esito;	
		// Periodo richiesta
		MyDate dataInizioRichiesta = new MyDate();
		dataInizioRichiesta.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = new MyDate();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		// Controllo
		if (dataInizioRichiesta.compareTo(dataInizioPeriodo)==0) {
			esito=true;			
		} else {
			esito=false;
		}
		return esito;
	}
	/**
	 * Metodo che confronta il giorno di fine dell'istanza su cui è invocato, con quello del periodo passato
	 * come parametro.
	 * @param periodo
	 * @return True se i periodi finiscono lo stesso giorno. False altrimenti.
	 */
	public boolean FinisceStessoGiornoFineDi(Periodo periodo){
		boolean esito;	
		// Periodo richiesta
		MyDate dataFineRichiesta = new MyDate();
		dataFineRichiesta.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		// Periodo dell'instanza
		MyDate dataFinePeriodo = new MyDate();
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo
		if (dataFineRichiesta.compareTo(dataFinePeriodo)==0) {
			esito=true;
		} else {
			esito=false;
		}
		return esito;
	}
	/**
	 * Metodo per settare la data di inizio del periodo da una data.
	 * 
	 * @param data Data attraverso la quale si setta l'inizio del periodo.
	 */
	public void setDataInizioDaData (MyDate data) {
		this.set_giornoInizio(data.get(Calendar.DATE));
		this.set_meseInizio(data.get(Calendar.MONTH));
		this.set_annoInizio(data.get(Calendar.YEAR));
	}
	/**
	 * Metodo per settare la data di fine del periodo da una data.
	 * 
	 * @param data Data attraverso la quale si setta la fine del periodo.
	 */
	public void setDataFineDaData(MyDate data) {
		this.set_giornoFine(data.get(Calendar.DATE));
		this.set_meseFine(data.get(Calendar.MONTH));
		this.set_annoFine(data.get(Calendar.YEAR));
	}
	/**
	 * Metodo per fornire la data relativa al giorno di inizio del periodo.
	 * 
	 * @return Data del giorno di inizio del periodo.
	 */
	public MyDate getDataInizio() {
		MyDate dataInizio = new MyDate();
		dataInizio.set(get_annoInizio(), get_meseInizio(), get_giornoInizio());
		return dataInizio;
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
}