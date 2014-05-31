/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno.CheckIn;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.view.ViewPanelContentPane;
import com.iHotel.view.Event.GestioneSoggiorno.CheckIn.EffettuaCheckInListener;
import com.iHotel.view.Event.GestioneSoggiorno.InformazioniCamera.TornaAlSoggiornoDaInfoCameraListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VPC_AggiungiOspiti extends ViewPanelContentPane {
	
	/* -------------------------------- Attributi e Costruttore ----------------------------------------- */
	/**
	 * Prenotazione per il quale si sta effettuando il check in.
	 */
	private SoggiornoContextSubject _prenotazione;
	
	private JTabbedPane _panelMiddleTabbed;
	private JButton _btnTerminaCheckin, _btnTornaPrenotazione;
	private JLabel _lblTitolo;
	
	/**
	 * Costruttore.
	 */
	public VPC_AggiungiOspiti() {
		_panelMiddleTabbed=_viewFactory.getTabbedPane();
		// Bottoni
		_btnTerminaCheckin=_viewFactory.getButtonAvanti();
		_btnTornaPrenotazione=_viewFactory.getButton();
		// Label
		_lblTitolo=_viewFactory.getLabelIntestazione_1();
	}
	/* -------------------------------------------- Metodi di instanza ------------------------------------- */

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelTop()
	 */
	@Override
	protected void creaPanelTop() {
		// Layout PanelTop
    	_panelTop.setLayout(new BorderLayout(0, 0));
		/*Testo della label*/
		_lblTitolo.setText("Inserisci gli ospiti nelle camere.");
		/*Aggiungo la label al centro*/
		_panelTop.add(_lblTitolo, BorderLayout.CENTER);
	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelMiddle()
	 */
	@Override
	protected void creaPanelMiddle() {
		// Setto il layout al panelMiddle
    	_panelMiddle.setLayout(new BoxLayout(_panelMiddle, BoxLayout.PAGE_AXIS));
    	// Creo il tabbedPane
    	ArrayList<Camera> camerePrenotazione = _prenotazione.get_camerePrenotate();
    	// Ciclo sulle camere per aggiungere i tab.
    	for (Iterator<Camera> iterator = camerePrenotazione.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
			// Aggiungo tab al tabbedPane
			_panelMiddleTabbed.addTab("Camera " + camera.get_numero(), new VPC_AggiungiOspiti_PanelCamera(camera,_prenotazione));
			//_panelMiddleTabbed.addTab("Camera " + camera.get_numero(), panelCamera);
			// Aggiungo il tabbedPane al panelMiddle
			_panelMiddle.add(_panelMiddleTabbed);
		}
	}
					
	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelBottom()
	 */
	@Override
	protected void creaPanelBottom() {
		// Button completa prenotazione.
		_btnTerminaCheckin.setText("Termina \n CheckIn");
		// Assegniamo l'eventListener al JButton btnTerminaCheckin.
		_btnTerminaCheckin.addMouseListener(new EffettuaCheckInListener(_prenotazione));
		// Button torna alla prenotazione.
		_btnTornaPrenotazione.setText("Torna \n Prenotazione");
		// Assegniamo l'eventListener al JButton btnTerminaCheckin.
		_btnTornaPrenotazione.addMouseListener(new TornaAlSoggiornoDaInfoCameraListener());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(0, _btnTornaPrenotazione);
		Bottoni.put(5,_btnTerminaCheckin);
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
	}
	
	/**
	 * Metodo per creare il frame.
	 */
	public void creaPanel(SoggiornoContextSubject prenotazione) {
		// Setto la prenotazione
		_prenotazione=prenotazione;

		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();	
	}
	
	/* ---------------------- Getter, Setter ----------------------------- */

	/**
	 * @return the _prenotazione
	 */
	public SoggiornoContextSubject get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(SoggiornoContextSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

	/**
	 * @return the _panelMiddleTabbed
	 */
	public JTabbedPane get_panelMiddleTabbed() {
		return _panelMiddleTabbed;
	}

	/**
	 * @param _panelMiddleTabbed the _panelMiddleTabbed to set
	 */
	public void set_panelMiddleTabbed(JTabbedPane _panelMiddleTabbed) {
		this._panelMiddleTabbed = _panelMiddleTabbed;
	}

}
