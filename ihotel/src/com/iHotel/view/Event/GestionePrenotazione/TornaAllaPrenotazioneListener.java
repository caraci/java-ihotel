/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento per tornare alla finestra relativa alle informazioni della prenotazione
 * a partire dalla finestra relativa alle informazioni della camera.
 * 
 * @author Eugenio
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
		CModificaSoggiorno.getInstance().terminaGestioneCamera();
	}
}
