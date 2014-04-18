/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaPrenotazione;

/**
 * @author Eugenio
 *
 */
public class TornaAllaCameraListener extends MouseAdapter {
	
	/* ------------------------------------ Metodi di instanza --------------------------------- */
	@Override
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per tornare alla
	 * gestione della camera.
	 */
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla gestione della camera della prenotazione.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		System.out.println(modificaPrenotazione.get_camera().get_numero());
		modificaPrenotazione.gestioneCamera(modificaPrenotazione.get_camera().get_numero());
	}
	
	

}
