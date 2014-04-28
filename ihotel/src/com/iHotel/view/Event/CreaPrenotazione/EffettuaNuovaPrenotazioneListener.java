/**
 * 
 */
package com.iHotel.view.Event.CreaPrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.view.Graphic.CreaPrenotazione.VFCP_SelezioneCamereDatiOspite_Observer;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe addetta alla gestione dell'evento per completare l'inserimento di una nuova prenotazione.
 * 
 * @author Eugenio
 */
public class EffettuaNuovaPrenotazioneListener extends MouseAdapter {

	/* ---------------------- Attributi e Costruttore ---------------------- */
	private VFCP_SelezioneCamereDatiOspite_Observer _selezioneCamereDatiOspite;
	/**
	 * Costruttore.
	 */
	public EffettuaNuovaPrenotazioneListener() {
		super();
		_selezioneCamereDatiOspite=VFCP_SelezioneCamereDatiOspite_Observer.getInstance();
	}
	
	/* ---------------------- Metodi di instanza ------------------------ */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone relativo alla
	 * creazione di una nuova prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo.
		CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
		// Invoco il metodo passando come parametro la stringa contenente il numero di camera.
		gestisciPrenotazione.concludiPrenotazione(_selezioneCamereDatiOspite.get_txtNome().getText(), 
												  _selezioneCamereDatiOspite.get_txtCognome().getText(), 
												  _selezioneCamereDatiOspite.get_txteMail().getText(), 
												  _selezioneCamereDatiOspite.get_txtTelefono().getText());
		
		// Recupero il codice della prenotazione appena inserita
		String codicePrenotazione = CCreaPrenotazione.getInstance().get_prenotazione().get_codice();
		// Mostro la dialog per confermare l'inserimento della prenotazione.
		UDialogManager.getInstance().showDialogConfermaPrenotazione(codicePrenotazione);
		
	}

}
