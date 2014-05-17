/**
 * 
 */
package com.iHotel.view.Event.CheckIn;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

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
		// TODO - Aggiungo l'ospite alla prenotazione
		
		// Prendo il pannello dove si va a mostrare la lista degli ospiti
		JPanel pnlMiddleRight = _panelCamera.get_pnlMiddleRight();
		// Prendo il layout del pannello
		CardLayout cardLayout = (CardLayout) pnlMiddleRight.getLayout();
		// Aggiungo una nuova scheda al pannello.
		pnlMiddleRight.add(_panelCamera.creaPanelListaOspiti());
		// Mostro la prossima scheda
		cardLayout.next(pnlMiddleRight);
		
	}

}
