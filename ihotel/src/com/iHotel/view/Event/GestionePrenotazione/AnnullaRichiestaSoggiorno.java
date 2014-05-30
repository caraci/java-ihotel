/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CCreaRichiestaSoggiorno;
import com.iHotel.controller.CModificaSoggiorno;

/**
 * @author Gabriele
 *
 */
public class AnnullaRichiestaSoggiorno extends MouseAdapter {
	/* --------------------- Metodi di instanza ------------------ */
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click, per annullare la richiesta di soggiorno.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla schermata principale.
		CCreaRichiestaSoggiorno richiestaSoggiorno = CCreaRichiestaSoggiorno.getInstance();
		richiestaSoggiorno.annullaRichiestaSoggiorno();
		
	}

}
