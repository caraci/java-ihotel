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
public class TornaAllaPrenotazioneListener extends MouseAdapter {
	
	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per tornare alla
	 * gestione della prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla gestione della prenotazione.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		modificaPrenotazione.terminaGestioneCamera();
	}
}
