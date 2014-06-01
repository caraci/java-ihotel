/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno.CheckIn;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.view.Utility.UDialogManager;

/**
 * @author Eugenio
 *
 */
public class EffettuaCheckInListener extends MouseAdapter {

	private SoggiornoContextSubject _soggiorno;
	
	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Costruttore
	 * @param soggiorno Soggiorno passato come parametro
	 */
	public EffettuaCheckInListener(SoggiornoContextSubject soggiorno){
		_soggiorno = soggiorno;
	}
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Attraverso il gestore per la modifica della prenotazione, effettuo il checkin.
		CModificaSoggiorno.getInstance().effettuaCheckIn();
		// Torno alla gestione della prenotazione
		CModificaSoggiorno.getInstance().recuperaSoggiornoDaCodice(_soggiorno.get_codice());
		//Visualizzo la dialog
		UDialogManager.getDialogAvvenutoCheckIn();
	}

}
