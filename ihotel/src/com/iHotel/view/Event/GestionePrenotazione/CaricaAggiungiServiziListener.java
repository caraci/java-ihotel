/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestionePrenotazione.VPGP_InfoCamera;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe addetta alla gestione dell'evento per caricare la finestra per aggiungere servizi interni
 * ad una camera di una prenotazione.
 * 
 * @author Eugenio
 */
public class CaricaAggiungiServiziListener extends MouseAdapter {
	
	private VPGP_InfoCamera _infoCamera;
	
	/**
	 * Costruttore
	 */
	public CaricaAggiungiServiziListener(){
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Recupero il contentPane del frame.
		JPanel contentPane = (JPanel) viewFrame.getContentPane();
		//Recupero il pannello contenente i servizi
		_infoCamera = (VPGP_InfoCamera) contentPane.getComponent(0);
	}
	/* ---------------- Metodi di instanza -------------------- */
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per aggiungere servizi
	 * ad una camera della prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Invoco la creazione della dialog per l'inserimento del servizio. Mi viene restituito il servizio
		//costruito con le informazioni inserite dall'utente
		ServizioInterno servizio = UDialogManager.getInstance().getDialogAggiungiServizioInterno();
		// Recupero il controllore e invoco il metodo per tornare alla gestione della prenotazione.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		//Invoco il metodo per l'aggiunta del servizio
		modificaPrenotazione.aggiungiServizio(servizio);
		//Creo il pannello dei servizi interni
		JPanel panelServiziInterni = _infoCamera.getPanelServiziInterni();
		//Recuper il layout
		CardLayout cardLayout = (CardLayout) panelServiziInterni.getLayout();
		//Aggiungo un nuovo pannello di servizi interni
		panelServiziInterni.add(_infoCamera.creaPanelMiddleCenter());
		//Mostro il pannello appena creato
		cardLayout.next(panelServiziInterni);
	}
}