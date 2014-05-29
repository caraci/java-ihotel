/**
 * 
 */
package com.iHotel.view.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe addetta alla gestione dell'evento per gestire una prenotazione precedentemente inserita.
 * 
 * @author Eugenio
 */
public class CaricaGestionePrenotazioneListener extends MouseAdapter {

	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sul bottone per la gestione di una prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {		
		//Creo la Input dialog
		String codice = UDialogManager.getDialogInserimentoCodice();
		/*controllo se il codice inserito è non nullo. In questo caso faccio partire la procedura per recuperare
		 la prenotazione dal codice*/
		if(codice != null){
			//Recupero il controllore
			CModificaSoggiorno gestorePrenotazione = CModificaSoggiorno.getInstance();
			//Recupero la prenotazione dal codice
			gestorePrenotazione.recuperaPrenotazioneDaCodice(codice);
		}
	}

}
