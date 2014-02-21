/**
 * 
 */
package com.iHotel.persistence;

/**
 * @author Eugenio
 *
 */
public class PCamera extends PersistentManager {
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PCamera instance=null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private PCamera(){}
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 * @return
	 */
	public static PCamera getInstance(){
		if(instance == null) {
            instance = new PCamera();
         }
         return instance;
	}
	public void dio() {
		
	}
}
