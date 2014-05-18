/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Persona.Ospite;

/**
 * @author Eugenio
 *
 */
public class CCheckIn extends CGestionePrenotazione {
	/**
	 * Instanza unica della classe - Pattern Singleton
	 */
	private static CCheckIn instance=null;
	/**
	 * 
	 */
	private CCheckIn() {}
	/* ------------------------- Metodi statici --------------------------- */
	/**
	* Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	*/
	public static CCheckIn getInstance() {
		if(instance == null) {
            instance = new CCheckIn();
         }
         return instance;
	}
	/* ------------------------ Metodi di classe ------------------------- */
	/**
	 * Metodo per caricare la finestra per effettuare il checkIn.
	 */
	public void iniziaCheckIn() {
		
	}
	/**
	 * 
	 * @param camera
	 * @param ospite
	 */
	public void aggiungiOspite(CameraContext camera, Ospite ospite) {
		
	}
	/**
	 * 
	 */
	public void terminaCheckIn() {
		
	}

}
