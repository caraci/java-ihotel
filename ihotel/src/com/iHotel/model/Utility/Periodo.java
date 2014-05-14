package com.iHotel.model.Utility;


/**
 * Classe addetta alla gestione del periodo.
 * 
 * @author Eugenio
 */
public class Periodo {

	/* ----------------------------------------- Attributi e costruttore ------------------------------------- */
	private Giorno _dataInizio;
	private Giorno _dataFine;
	
	public Periodo() {}
	/**
	 * Costruttore della classe Periodo.
	 * @param dataInizio Data inizio del periodo.
	 * @param dataFine Data fine del periodo.
	 */
	public Periodo(Giorno dataInizio, Giorno dataFine) {
		set_dataInizio(dataInizio);
		set_dataFine(dataFine);
	}
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
		MyDate dataInizioRichiesta = periodoRichiesta.get_dataInizio().toMyDate();
		MyDate dataFineRichiesta = periodoRichiesta.get_dataFine().toMyDate();
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
		MyDate dataFinePeriodo = _dataFine.toMyDate();
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
	public boolean contiene(Periodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		MyDate dataInizioRichiesta = periodoRichiesta.get_dataInizio().toMyDate();
		MyDate dataFineRichiesta = periodoRichiesta.get_dataFine().toMyDate();
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
		MyDate dataFinePeriodo = _dataFine.toMyDate();
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
	 * @param giornoServizio Giorno da confrontare.
	 * @return True se la data è contenuta. False altrimenti.
	 */
	public boolean contieneData(Giorno giornoServizio) {
		boolean esito;
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
		MyDate dataFinePeriodo = _dataFine.toMyDate();
		// Giorno -> myDate
		MyDate dataServizio = giornoServizio.toMyDate();
		// Controllo se il periodoRichiesta è contenuto in periodo.
		if(dataInizioPeriodo.compareTo(dataServizio)<=0 && dataFinePeriodo.compareTo(dataServizio)>=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;			
	}
	/**
	 * Metodo per verificare se un periodo contiene un giorno.
	 * @param giornoRichiesta Giorno da analizzare
	 * @return True se il giorno è contenuto. False altrimenti.
	 */
	public boolean contieneGiorno(Giorno giornoRichiesta) {
		boolean esito;
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
		MyDate dataFinePeriodo = _dataFine.toMyDate();
		// Data da analizzare
		MyDate dataRichiesta = giornoRichiesta.toMyDate();
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
		MyDate dataInizioRichiesta = periodoRichiesta.get_dataInizio().toMyDate();
		MyDate dataFineRichiesta = periodoRichiesta.get_dataFine().toMyDate();
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
		MyDate dataFinePeriodo = _dataFine.toMyDate();
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
		MyDate dataFineRichiesta = periodoRichiesta.get_dataFine().toMyDate();
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
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
		MyDate dataInizioRichiesta = periodoRichiesta.get_dataInizio().toMyDate();
		// Periodo dell'instanza
		MyDate dataFinePeriodo = _dataFine.toMyDate();
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
		_dataInizio=periodo.get_dataInizio();
	}
	/**
	 * Metodo che setta la data di inizio dell'istanza su cui è invocato, alla data di fine del periodo
	 * passato come parameto. Per ora e minuto si prendono i parametri di "default" _minutoInizio e _oraInizio,
	 * altrimenti il periodo comincerebbe in un orario sbagliato.
	 * 
	 * @param periodo
	 */
	public void setDataInizioPeriodoDaDataFinePeriodo(Periodo periodo){
		_dataInizio=periodo.get_dataFine();
	}
	/**
	 * Metodo che setta la data di fine del periodo dell'istanza su cui è invocato, alla fine del periodo
	 * passato come parametro.
	 * 
	 * @param periodo
	 */
	public void setDataFinePeriodoDaDataFinePeriodo(Periodo periodo){
		_dataFine=periodo.get_dataFine();
		
	}	
	/**
	 * Metodo che setta la data di fine del periodo su cui è invocato, alla data di inizio del periodo
	 * passato come parametro. Per ora e minuto si assegnano i valori di default presi da _oraFine, _minutoFine
	 * altrimenti la data di fine sarebbe sbagliata.
	 * 
	 * @param periodo
	 */
	public void setDataFinePeriodoDaDataInizioPeriodo(Periodo periodo){
		_dataFine=periodo.get_dataInizio();
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
		MyDate dataInizioRichiesta = periodo.get_dataInizio().toMyDate();
		// Periodo dell'instanza
		MyDate dataInizioPeriodo = _dataInizio.toMyDate();
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
		MyDate dataFineRichiesta = periodo.get_dataFine().toMyDate();
		// Periodo dell'instanza
		MyDate dataFinePeriodo = _dataFine.toMyDate();
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
		set_dataInizio(data.toGiorno());
	}
	/**
	 * Metodo per settare la data di fine del periodo da una data.
	 * 
	 * @param data Data attraverso la quale si setta la fine del periodo.
	 */
	public void setDataFineDaData(MyDate data) {
		set_dataFine(data.toGiorno());
	}
	
	/* ------------------------ Getter, Setter ----------------------------- */
	/**
	 * @return the _dataInizio
	 */
	public Giorno get_dataInizio() {
		return _dataInizio;
	}
	/**
	 * @param _dataInizio the _dataInizio to set
	 */
	public void set_dataInizio(Giorno _dataInizio) {
		this._dataInizio = _dataInizio;
	}
	/**
	 * @return the _dataFine
	 */
	public Giorno get_dataFine() {
		return _dataFine;
	}
	/**
	 * @param _dataFine the _dataFine to set
	 */
	public void set_dataFine(Giorno _dataFine) {
		this._dataFine = _dataFine;
	}
}