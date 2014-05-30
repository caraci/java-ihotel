/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * @author Eugenio
 *
 */
public class EffettuaCheckOutListener extends MouseAdapter {

	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Attraverso il controllore CCheckOut effettuo il checkout.ù
		CModificaSoggiorno.getInstance().effettuaCheckOut();
	}
}
