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
public class GestisciCameraPrenotazioneListener extends MouseAdapter {

	/* ---------------- Attributi e Costruttore ------------------ */
	private String _numeroCamera;
	/**
	 * Costruttore.
	 * @param numeroCamera Numero della camera da gestire.
	 */
	public GestisciCameraPrenotazioneListener(String numeroCamera) {
		super();
		_numeroCamera=numeroCamera;
	}
	/* ---------------- Metodi di instanza ------------------------ */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per gestire una camera
	 * relativa ad una prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per gestire una camera di una prenotazione.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		modificaPrenotazione.gestioneCamera(_numeroCamera);
	}

}
