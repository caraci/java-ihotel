/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento per terminare le modifiche di una prenotazione.
 * 
 * @author Eugenio
 */
public class TerminaModifichePrenotazione extends MouseAdapter {

	/* --------------------- Metodi di instanza ------------------ */
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click, per terminare la gestione di una prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla schermata principale.
		CModificaSoggiorno modificaPrenotazione = CModificaSoggiorno.getInstance();
		modificaPrenotazione.terminaGestionePrenotazione();
	}

}
