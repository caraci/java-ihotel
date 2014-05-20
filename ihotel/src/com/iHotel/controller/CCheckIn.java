/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.persistence.PCamera;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.Graphic.CheckIn.VFC_AggiungiOspiti;

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
		// Chiedo a CModificaPrenotazione la prenotazione che si sta gestendo
		set_prenotazione(CModificaPrenotazione.getInstance().get_prenotazione());
		// Preparo l'interfaccia da visualizzare
		VFC_AggiungiOspiti aggiungiOspiti = VFC_AggiungiOspiti.getInstance();
		aggiungiOspiti.creaFrame(_prenotazione);
		// Visualizzo la nuova interfaccia.
		ViewHandler.getInstance().showFrame(aggiungiOspiti);
	}
	/**
	 * Metodo per aggiungere un ospite alla camera.
	 * 
	 * @param camera Camera alla quale si vuole aggiungere l'ospite.
	 * @param ospite Ospite da aggiungere alla camera.
	 */
	public void aggiungiOspite(Camera camera, Ospite ospite) {
		// Periodo nel quale aggiungiamo l'ospite
		Periodo periodo = _prenotazione.get_periodo();
		// Aggiungo l'ospite alla camera
		camera.aggiungiOspiteInPeriodo(ospite, periodo);
		// Salvo nel db lo stato camera in seguito all'aggiornamento.
    	PCamera.getInstance().store(camera.getStatoCameraInPeriodo(periodo));
	}
	/**
	 * Metodo per terminare il checkIn per la camera.
	 */
	public void terminaCheckIn() {
		
	}
	/**
	 * Metodo per tornare alla gestione della prenotazione.
	 */
	public void tornaAllaPrenotazione() {
		// Fornisco la prenotazione de gestire a CModificaPrenotazione
		CModificaPrenotazione.getInstance().recuperaPrenotazioneDaCodice(_prenotazione.get_codice());
	}

}
