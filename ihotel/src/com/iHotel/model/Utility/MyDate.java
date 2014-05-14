/**
 * 
 */
package com.iHotel.model.Utility;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe addetta alle gestione delle date.
 * 
 * @author Eugenio
 */
@SuppressWarnings("serial")
public class MyDate extends GregorianCalendar {
	/**
	 * Costruttore.
	 */
	public MyDate() {
		super();
		// Azzero i campi relativi ad ora, minuto e secondo.
		this.clear();
	}
	
	/* ------------- Metodi di instanza --------------------- */
	/**
	 * Metodo per fornire un oggetto della classe Giorno da uno della classe MyDate.
	 * @return Oggetto della classe Giorno.
	 */
	public Giorno toGiorno() {
		Giorno giorno = new Giorno();
		giorno.set_giorno(this.get(Calendar.DATE));
		giorno.set_mese(this.get(Calendar.MONTH));
		giorno.set_anno(this.get(Calendar.YEAR));
		return giorno;
	}
}
