/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.utility.UDefaultLoader;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe addetta alla gestione dell'evento per caricare la finestra per aggiungere servizi interni
 * ad una camera di una prenotazione.
 * 
 * @author Eugenio
 */
public class CaricaAggiungiServiziListener extends MouseAdapter {
	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per aggiungere servizi
	 * ad una camera della prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per tornare alla gestione della prenotazione.
		//CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		//modificaPrenotazione.aggiungiServiziCamera();
		ServizioInterno servizio = UDialogManager.getInstance().getDialogAggiungiServizioInterno();
	}
}
