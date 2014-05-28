/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione.CheckIn;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaPrenotazione;

/**
 * @author Eugenio
 *
 */
public class EffettuaCheckInListener extends MouseAdapter {

	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Attraverso il gestore per la modifica della prenotazione, effettuo il checkin.
		CModificaPrenotazione.getInstance().effettuaCheckIn();;
	}

}
