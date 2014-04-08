/**
 * 
 */
package com.iHotel.view.CreaPrenotazione.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.view.CreaPrenotazione.Frame.VFCP_SelezioneCamereDatiOspite_Observer;

/**
 * @author Eugenio
 *
 */
public class AggiungiCameraPrenotazioneListener extends MouseAdapter {

	/* -------------------- Attributi e Costruttore ----------------------- */
	private VFCP_SelezioneCamereDatiOspite_Observer _selezioneCamereDatiOspite;
	
	public AggiungiCameraPrenotazioneListener() {
		super();
		_selezioneCamereDatiOspite=VFCP_SelezioneCamereDatiOspite_Observer.getInstance();
	}
	/* ------------------- Metodi di instanza ----------------------------- */
	@Override
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone relativo all'aggiunta
	 * di una camera alla prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {
		JButton btn;
		// Ricavo il JButton che ha generato l'evento
		btn=(JButton) e.getComponent();
		// Ricavo la sua posizione nell'ArrayList di JButton
		int numeroLista=_selezioneCamereDatiOspite.get_btnNumeriCamereDisponibili().indexOf(btn);
		// Recupero il controllore e invoco il metodo.
		CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
		// Aggiungo la camera alla prenotazione e carico il totale.
		gestisciPrenotazione.aggiungiCameraAllaPrenotazione(_selezioneCamereDatiOspite.get_lblNumeriCamereDisponibili().get(numeroLista).getText());
		// Cambio testo al bottone
		btn.setText("Rimuovi camera");
	}

}
