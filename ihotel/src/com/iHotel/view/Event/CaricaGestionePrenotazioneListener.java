/**
 * 
 */
package com.iHotel.view.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.view.Utility.UDialogManager;

/**
 * @author Eugenio
 *
 */
public class CaricaGestionePrenotazioneListener extends MouseAdapter {

	@Override
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sul bottone per la gestione di una prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {		
		//Creo la Input dialog
		String codice = UDialogManager.getInstance().getDialogInserimentoCodice();
		/*controllo se il codice inserito è non nullo. In questo caso faccio partire la procedura per recuperare
		 la prenotazione dal codice*/
		if(codice != null){
			//Recupero il controllore
			CModificaPrenotazione gestorePrenotazione = CModificaPrenotazione.getInstance();
			//Recupero la prenotazione dal codice
			gestorePrenotazione.recuperaPrenotazioneDaCodice(codice);
		}
	}

}
