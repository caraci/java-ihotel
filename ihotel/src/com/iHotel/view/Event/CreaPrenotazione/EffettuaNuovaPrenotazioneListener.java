/**
 * 
 */
package com.iHotel.view.Event.CreaPrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.view.Graphic.VFrameHome;
import com.iHotel.view.Graphic.CreaPrenotazione.VFCP_SelezioneCamereDatiOspite_Observer;

/**
 * @author Eugenio
 *
 */
public class EffettuaNuovaPrenotazioneListener extends MouseAdapter {

	/* ---------------------- Attributi e Costruttore ---------------------- */
	private VFCP_SelezioneCamereDatiOspite_Observer _selezioneCamereDatiOspite;
	
	public EffettuaNuovaPrenotazioneListener() {
		super();
		_selezioneCamereDatiOspite=VFCP_SelezioneCamereDatiOspite_Observer.getInstance();
	}
	
	/* ---------------------- Metodi di instanza ------------------------ */
	@Override
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone relativo alla
	 * creazione di una nuova prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo.
		CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
		// Invoco il metodo passando come parametro la stringa contenente il numero di camera.
		gestisciPrenotazione.concludiPrenotazione(_selezioneCamereDatiOspite.get_txtNome().getText(), 
												  _selezioneCamereDatiOspite.get_txtCognome().getText(), 
												  _selezioneCamereDatiOspite.get_txteMail().getText(), 
												  _selezioneCamereDatiOspite.get_txtTelefono().getText());
		// Mostro la dialog per confermare l'inserimento della prenotazione.
		String codicePrenotazione = CCreaPrenotazione.getInstance().get_prenotazione().get_codice();
		JOptionPane.showMessageDialog(VFrameHome.getInstance(), "La prenotazione è stata creata, codice: " + codicePrenotazione);
		
	}

}
