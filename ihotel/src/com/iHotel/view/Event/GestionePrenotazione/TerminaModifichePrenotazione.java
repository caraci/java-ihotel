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
public class TerminaModifichePrenotazione extends MouseAdapter {

	/* --------------------- Metodi di instanza ------------------ */
	@Override
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click, per terminare la gestione di una prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla schermata principale.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		modificaPrenotazione.terminaGestionePrenotazione();
	}

}
