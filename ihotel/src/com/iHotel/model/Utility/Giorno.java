/**
 * 
 */
package com.iHotel.model.Utility;

import java.util.Calendar;

/**
 * Classe che modella un giorno nel formato giorno-mese-anno
 * @author Eugenio
 *
 */
public class Giorno {
	
	/* ----------------------------------------- Attributi e costruttore ------------------------------------- */
	/**
	 * Giorno
	 */
	private int _giorno;
	/**
	 * Mese
	 */
	private int _mese;
	/**
	 * Anno
	 */
	private int _anno;

	/**
	 * Costruttore della classe Giorno.
	 * 
	 * @param giorno
	 * @param mese
	 * @param anno 
	 */
	public Giorno(int giorno, int mese, int anno) {
		set_giorno(giorno);
		set_mese(mese);
		set_anno(anno);
	}
	/**
	 * Costruttore
	 */
	public Giorno() {}
	/* ----------------------------- Metodi di instanza -------------------------- */
	/**
	 * Metodo per ottenere un oggetto della classe MyDate dall'instanza della classe Giorno.
	 * 
	 * @return Classe myDate relativa a questo giorno.
	 */
	public MyDate toMyDate() {
		MyDate date = new MyDate();
		date.set(get_anno(), get_mese(), get_giorno());
		return date;
	}
	/**
	 * Metodo per ottenere il giorno odierno.
	 * 
	 * @return Giorno odierno.
	 */
	public static Giorno getGiornoOdierno() {
		Giorno giornoOdierno = new Giorno();
		// Creo un oggetto myDate
		MyDate dataOdierna = new MyDate();
		// Setto la dataOdierna alla data
		dataOdierna.setDataOdierna();
		// Converto dataOdierna in giornoOdierno
		giornoOdierno = dataOdierna.toGiorno();
		
		return giornoOdierno;
	}
	/**
	 * Metodo per confrontare due giorni per vedere se uno è maggiore di un altro.
	 * 
	 * @param giornoDaComparare Giorno da comparare
	 * @return 1 se la data dell'istanza è maggiore di quella della richiesta. 0 se le date sono uguali. -1 altrimenti.
	 */
	public int compara(Giorno giornoDaComparare) {
		MyDate dataIstanza = this.toMyDate();
		MyDate dataRichiesta = giornoDaComparare.toMyDate();
		// Effettuo il confronto.
		int esito = dataIstanza.compareTo(dataRichiesta);
		return esito;
	}
	/**
	 * Metodo per aggiungere un certo quantitativo di giorno, positivo o negativo, al giorno dell'istanza.
	 * 
	 * @param numeroGiorniDaAggiungere Numero intero o positivo di giorni da aggiungere.
	 */
	public Giorno addToGiorno(int numeroGiorniDaAggiungere) {			
		// Modifico la data di inizio
		MyDate nuovoGiornoDate = this.toMyDate();
		nuovoGiornoDate.add(Calendar.DAY_OF_MONTH, numeroGiorniDaAggiungere);
		// Assegno 
		Giorno nuovoGiorno = new Giorno();
		nuovoGiorno = nuovoGiornoDate.toGiorno();		
		// Fornisco
		return nuovoGiorno;
	}
	/**
	 * Stringa contenente le informazioni del giorno.
	 */
	public String toString() {
		return _giorno + "-" + _mese + "-" + _anno; 
	}
	/* -------------------------- Getter, Setter ----------------------------------- */
	/**
	 * @return the _giorno
	 */
	public int get_giorno() {
		return _giorno;
	}

	/**
	 * @param _giorno the _giorno to set
	 */
	public void set_giorno(int _giorno) {
		this._giorno = _giorno;
	}

	/**
	 * @return the _mese
	 */
	public int get_mese() {
		return _mese;
	}

	/**
	 * @param _mese the _mese to set
	 */
	public void set_mese(int _mese) {
		this._mese = _mese;
	}

	/**
	 * @return the _anno
	 */
	public int get_anno() {
		return _anno;
	}

	/**
	 * @param _anno the _anno to set
	 */
	public void set_anno(int _anno) {
		this._anno = _anno;
	}

}
