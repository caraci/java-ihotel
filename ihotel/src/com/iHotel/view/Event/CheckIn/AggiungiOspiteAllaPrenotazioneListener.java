/**
 * 
 */
package com.iHotel.view.Event.CheckIn;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.iHotel.model.State.CameraContext;
import com.iHotel.view.Graphic.CheckIn.VFC_AggiungiOspiti;

/**
 * @author Eugenio
 *
 */
public class AggiungiOspiteAllaPrenotazioneListener implements ActionListener {
	
	/* ------------------------- Attributi e costruttore ---------------------- */
	/**
	 * Pannello contenente la lista degli ospiti.
	 */
	private JPanel _pnlMiddleRight_ListaOspiti;
	/**
	 * Frame per il quale si sta gestendo l'evento.
	 */
	private VFC_AggiungiOspiti _frameAggiungiOspiti;
	/**
	 * Camera alla quale si vule aggiungere l'ospite.
	 */
	private CameraContext _camera;
	/**
	 * Costruttore.
	 * 
	 * @param camera Camera alla quale si vuole aggiungere l'ospite
	 * @param pnlMiddleRight Pannello contenente la lista degli ospiti.
	 */
	public AggiungiOspiteAllaPrenotazioneListener(CameraContext camera, JPanel pnlMiddleRight) {
		_pnlMiddleRight_ListaOspiti=pnlMiddleRight;
		_camera=camera;
		_frameAggiungiOspiti=VFC_AggiungiOspiti.getInstance();
	}
	
	/* -------------------------- Metodi di instanza ---------------------------- */

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO - Aggiungo l'ospite alla prenotazione
		
		
		// Prendo il layout del pannello
		CardLayout cardLayout = (CardLayout) _pnlMiddleRight_ListaOspiti.getLayout();
		// Aggiungo una nuova scheda al pannello.
		_pnlMiddleRight_ListaOspiti.add(_frameAggiungiOspiti.creaPanelListaOspiti(_camera));
		// Mostro la prossima scheda
		cardLayout.next(_pnlMiddleRight_ListaOspiti);
		
	}

}
