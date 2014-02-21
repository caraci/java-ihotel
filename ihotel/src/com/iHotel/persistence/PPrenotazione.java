/**
 * 
 */
package com.iHotel.persistence;
/**
 * @author Eugenio
 *
 */
public class PPrenotazione extends PersistentManager {
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PPrenotazione instance=null;
	/**
	 * Costruttore privato - Pattern Singleton.
	 */
	private PPrenotazione(){}
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton.
	 * @return
	 */
	public static PPrenotazione getInstance(){
		if(instance == null) {
            instance = new PPrenotazione();
         }
         return instance;
	}
}
