/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CCheckIn;

/**
 * @author Alessandro
 *
 */
public class CheckInPrenotazioneListener extends MouseAdapter {
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in degli ospiti.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per gestire una camera di una prenotazione.
		CCheckIn checkIn = CCheckIn.getInstance();
		checkIn.aggiungiOspitiAllaPrenotazione();
	}
}
