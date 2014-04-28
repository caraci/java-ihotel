/**
 * 
 */
package com.iHotel.view.Event.CreaPrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.iHotel.controller.CCreaPrenotazione;

/**
 * Classe addetta alla gestione dell'evento per aggiungere una camera alla prenotazione.
 * 
 * @author Eugenio
 */
public class AggiungiCameraPrenotazioneListener extends MouseAdapter {

	/* -------------------- Attributi e Costruttore ----------------------- */
	/**
	 * Numero di camera che si vuole aggiungere alla prenotazione.
	 */
	private String _numeroCamera;
	/**
	 * Costruttore.
	 * 
	 * @param numeroCamera Numero della camera da aggiungere.
	 */
	public AggiungiCameraPrenotazioneListener(String numeroCamera) {
		_numeroCamera=numeroCamera;
	}
	/* ------------------- Metodi di instanza ----------------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone relativo all'aggiunta
	 * di una camera alla prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn;
		// Ricavo il JButton che ha generato l'evento
		btn=(JButton) e.getComponent();
		// Rimuovo il listener e lo disabilito. 
		btn.removeMouseListener(this);
		btn.setEnabled(false);
		// Recupero il controllore e invoco il metodo.
		CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
		// Aggiungo la camera alla prenotazione e carico il totale.
		gestisciPrenotazione.aggiungiCameraAllaPrenotazione(_numeroCamera);
	}

}
