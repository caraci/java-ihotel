/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento per caricare la finestra per la gestione di una camera relativa
 * ad una prenotazione.
 * 
 * @author Eugenio
 */
public class GestisciCameraPrenotazioneListener extends MouseAdapter {

	/* ---------------- Attributi e Costruttore ------------------ */
	/**
	 * Numero della camera per la quale si vuole caricare la finestra.
	 */
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
		CModificaSoggiorno modificaPrenotazione = CModificaSoggiorno.getInstance();
		modificaPrenotazione.gestioneCamera(_numeroCamera);
	}

}
