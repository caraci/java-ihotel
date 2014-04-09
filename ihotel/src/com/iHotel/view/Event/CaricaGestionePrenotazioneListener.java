/**
 * 
 */
package com.iHotel.view.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaPrenotazione;

/**
 * @author Eugenio
 *
 */
public class CaricaGestionePrenotazioneListener extends MouseAdapter {

	@Override
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sul bottone per la gestione di una prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per gestire una prenotazione.
		CModificaPrenotazione gestorePrenotazione = CModificaPrenotazione.getInstance();
		gestorePrenotazione.gestionePrenotazione();
	}

}
