/**
 * 
 */
package com.iHotel.view.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CCreaRichiestaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento per caricare la finestra per creare una nuova prenotazione.
 * 
 * @author Eugenio
 */
public class CaricaCreaNuovaPrenotazioneListener extends MouseAdapter {
	
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sul bottone per la creazione di una nuova 
	 * prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo relativo alla creazione di una nuova prenotazione.
		CCreaRichiestaSoggiorno creatorePrenotazione = CCreaRichiestaSoggiorno.getInstance();
		creatorePrenotazione.creaNuovaRichiestaSoggiorno();
	}

}
