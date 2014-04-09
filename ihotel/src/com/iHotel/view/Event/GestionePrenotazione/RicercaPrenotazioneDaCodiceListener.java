/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_RicercaPrenotazioneDaCodice;

/**
 * @author Eugenio
 *
 */
public class RicercaPrenotazioneDaCodiceListener extends MouseAdapter {

	/* ---------------- Attributi e costruttore -------------------- */
	VFGP_RicercaPrenotazioneDaCodice _ricercaPrenotazioneDaCodice;
	
	public RicercaPrenotazioneDaCodiceListener() {
		_ricercaPrenotazioneDaCodice=VFGP_RicercaPrenotazioneDaCodice.getInstance();
	}
	/* ----------------- Metodi di instanza --------------------- */
	@Override
	/**
	 * Con questo metodo si va a gestire l'evento dovuto al click sul bottone atto al caricamento di una prenotazione
	 * mediante il suo codice identificativo.
	 */
	public void mouseClicked(MouseEvent e) {		
		CModificaPrenotazione gestorePrenotazione = CModificaPrenotazione.getInstance();
		gestorePrenotazione.recuperaPrenotazioneDaCodice(_ricercaPrenotazioneDaCodice.get_txtReservationCode().getText());
	}
}
