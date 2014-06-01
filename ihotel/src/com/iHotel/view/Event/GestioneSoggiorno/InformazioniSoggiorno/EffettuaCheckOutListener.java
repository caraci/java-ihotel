/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;

/**
 * Classe addetta alla gestione dell'evento per effettuare il check out.
 * @author Eugenio
 *
 */
public class EffettuaCheckOutListener extends MouseAdapter {
	
	private SoggiornoContextSubject _soggiorno;
	
	/**
	 * Costruttore
	 * @param soggiorno Passato come parametro
	 */
	public EffettuaCheckOutListener(SoggiornoContextSubject soggiorno){
		_soggiorno = soggiorno;
	}

	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Attraverso il controllore CCheckOut effettuo il checkout.
		CModificaSoggiorno.getInstance().effettuaCheckOut();
		// Torno alla gestione della prenotazione
		CModificaSoggiorno.getInstance().recuperaSoggiornoDaCodice(_soggiorno.get_codice());
	}
}
