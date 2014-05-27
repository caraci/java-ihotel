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
public class EffettuaCheckInListener extends MouseAdapter {

	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Attraverso il controllore CCheckIn effettuo il checkin.
		CCheckIn.getInstance().effettuaCheckIn();
	}

}
