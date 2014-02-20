/**
 * 
 */
package com.iHotel.persistence;



/**
 * @author Eugenio
 *
 */
public class PDescrizioneCamera extends PersistentManager{
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PDescrizioneCamera instance=null;
	/**
	 * Costruttore privato - Pattern Singleton.
	 */
	private PDescrizioneCamera(){}
	
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 * @return
	 */
	public static PDescrizioneCamera getInstance(){
		if(instance == null) {
            instance = new PDescrizioneCamera();
         }
         return instance;
	}
}
