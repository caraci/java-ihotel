/**
 * 
 */
package com.iHotel.view.Event.CheckIn;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CCheckIn;

/**
 * @author Eugenio
 *
 */
public class TornaAllaPrenotazioneDaCheckInListener extends MouseAdapter {

	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per tornare alla prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Attraverso il controllore CCheckIn torno alla gestione della prenotazione
		CCheckIn.getInstance().tornaAllaPrenotazione();
	}
}
