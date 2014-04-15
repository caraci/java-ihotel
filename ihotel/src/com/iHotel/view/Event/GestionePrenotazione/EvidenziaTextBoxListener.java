/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_RicercaPrenotazioneDaCodice;



/**
 * @author Alessandro
 *
 */
public class EvidenziaTextBoxListener extends MouseAdapter {

	/*Attributi*/
	private VFGP_RicercaPrenotazioneDaCodice _ricercaPrenotazione;
	
	/*Costruttore*/
	public EvidenziaTextBoxListener(){
		_ricercaPrenotazione = VFGP_RicercaPrenotazioneDaCodice.getInstance();
	}
	
	@Override
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sulla casella di testo e gli si cambia colore
	 */
	public void mouseClicked(MouseEvent e) {
		_ricercaPrenotazione.get_txtReservationCode().setBackground(new Color(150,150,200));
	}

}
