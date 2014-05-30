/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento per tornare alla gestione della camera, dalla finestra per aggiungere
 * i servizi interni alla prenotazione.
 * 
 * @author Eugenio
 */
public class TornaAllaCameraListener extends MouseAdapter {
	
	/* ------------------------------------ Metodi di instanza --------------------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per tornare alla
	 * gestione della camera.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla gestione della camera della prenotazione.
		CModificaSoggiorno modificaPrenotazione = CModificaSoggiorno.getInstance();
		modificaPrenotazione.gestioneCamera(modificaPrenotazione.get_camera().get_numero());
	}
	
	

}
