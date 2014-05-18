/**
 * 
 */
package com.iHotel.view.Event.CheckIn;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.iHotel.controller.CCheckIn;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Persona.Documenti.CartaIdentita;
import com.iHotel.model.Persona.Documenti.Documento;
import com.iHotel.model.Persona.Documenti.Passaporto;
import com.iHotel.model.Persona.Documenti.Patente;
import com.iHotel.view.Graphic.CheckIn.VFC_AggiungiOspiti_PanelCamera;

/**
 * @author Eugenio
 *
 */
public class AggiungiOspiteAllaPrenotazioneListener implements ActionListener {
	
	/* ------------------------- Attributi e costruttore ---------------------- */
	/**
	 * Pannello contenente la lista degli ospiti.
	 */
	private VFC_AggiungiOspiti_PanelCamera _panelCamera;
	/**
	 * Costruttore.
	 * 
	 * @param pnlMiddleRight Pannello contenente la lista degli ospiti.
	 */
	public AggiungiOspiteAllaPrenotazioneListener(VFC_AggiungiOspiti_PanelCamera panelCamera) {
		_panelCamera=panelCamera;
	}
	
	/* -------------------------- Metodi di instanza ---------------------------- */

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Inserire le giuste informazioni dell'ospite.
		
		// Carico il gestore del checkIn.
		CCheckIn checkIn = CCheckIn.getInstance();
		// Aggiungo l'ospite alla prenotazione.
		checkIn.aggiungiOspite(_panelCamera.get_camera(), getOspiteInserito());
		
		// Prendo il pannello dove si va a mostrare la lista degli ospiti
		JPanel pnlMiddleRight = _panelCamera.get_pnlMiddleRight();
		// Prendo il layout del pannello
		CardLayout cardLayout = (CardLayout) pnlMiddleRight.getLayout();
		// Aggiungo una nuova scheda al pannello.
		pnlMiddleRight.add(_panelCamera.creaPanelListaOspiti());
		// Mostro la prossima scheda
		cardLayout.next(pnlMiddleRight);
	}
	/**
	 * Metodo per ottenere il giusto ospite.
	 * 
	 * @return
	 */
	public Ospite getOspiteInserito() {
		Ospite ospite = new Ospite();
		
		// Ricavo il documento  che si è scelto di inserire.
		String tipoDocumento=(String) _panelCamera.get_comboBoxTipologieDocumenti().getSelectedItem();
		// Ricavo il giusto documento
		Documento documentoOspite;
		// Scelgo in base al tipoDocumento quale documento creare.
		switch (tipoDocumento) {
		case "CartaIdentita":
			documentoOspite=getCartaIdentita();
			break;
		case "Patente":
			documentoOspite=getPatente();
			break;
		case "Passaporto":
			documentoOspite=getPassaporto();
			break;
		default:
			documentoOspite=null;
			break;
		}
		// Aggiungo il documento all'ospite
		
		ospite.set_documento(documentoOspite);
		return ospite;
	}
	/**
	 * Metodo per ottenere le informazioni della carta d'identità.
	 * @return
	 */
	public CartaIdentita getCartaIdentita() {
		CartaIdentita cartaIdentita = new CartaIdentita();
		
		return cartaIdentita;
	}
	/**
	 * Metodo per ottenere le informazioni della patente.
	 * @return
	 */
	public Patente getPatente() {
		Patente patente = new Patente();
		
		return patente;
	}
	/**
	 * Metodo per ottenere le informazioni del passaporto.
	 * @return
	 */
	public Passaporto getPassaporto() {
		Passaporto passaporto = new Passaporto();
		
		return passaporto;
	}
	
	

}
