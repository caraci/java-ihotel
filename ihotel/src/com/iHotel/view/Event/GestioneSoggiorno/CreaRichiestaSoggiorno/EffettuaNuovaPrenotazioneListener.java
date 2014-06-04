/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno.CreaRichiestaSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iHotel.controller.CCreaRichiestaSoggiorno;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestioneSoggiorno.CreaRichiestaSoggiorno.VPCP_SelezioneCamereDatiOspite_Observer;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe addetta alla gestione dell'evento per completare l'inserimento di una nuova prenotazione.
 * 
 * @author Eugenio
 */
public class EffettuaNuovaPrenotazioneListener extends MouseAdapter {

	/* ---------------------- Attributi e Costruttore ---------------------- */
	private VPCP_SelezioneCamereDatiOspite_Observer _selezioneCamereDatiOspite;
	/**
	 * Costruttore.
	 */
	public EffettuaNuovaPrenotazioneListener() {
		super();
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Recupero il contentPane del frame.
		JPanel contentPane = (JPanel) viewFrame.getContentPane();
		// Recupero il panel corretto
		_selezioneCamereDatiOspite= (VPCP_SelezioneCamereDatiOspite_Observer) contentPane.getComponent(0);
	}
	
	/* ---------------------- Metodi di instanza ------------------------ */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone relativo alla
	 * creazione di una nuova prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo.
		CCreaRichiestaSoggiorno gestisciPrenotazione = CCreaRichiestaSoggiorno.getInstance();
		// Creo il cliente prenotante.
		ClientePrenotante clientePrenotante = new ClientePrenotante();
		clientePrenotante.set_nome(_selezioneCamereDatiOspite.get_txtNome().getText());
		clientePrenotante.set_cognome(_selezioneCamereDatiOspite.get_txtCognome().getText());
		clientePrenotante.set_email(_selezioneCamereDatiOspite.get_txteMail().getText());
		clientePrenotante.set_telefono(_selezioneCamereDatiOspite.get_txtTelefono().getText());
		// Invoco il metodo passando come parametro la stringa contenente il numero di camera.
		gestisciPrenotazione.concludiRichiestaSoggiorno(clientePrenotante);
		
		// Recupero il codice della prenotazione appena inserita
		String codicePrenotazione = CCreaRichiestaSoggiorno.getInstance().get_soggiorno().get_codice();
		// Mostro la dialog per confermare l'inserimento della prenotazione.
		UDialogManager.showDialogConfermaPrenotazione(codicePrenotazione);
		
	}

}
