/**
 * 
 */
package com.iHotel.view.Graphic.CheckIn;


import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.State.CameraContext;
import com.iHotel.utility.UStartup;
import com.iHotel.view.View;
import com.iHotel.view.Event.CheckIn.TerminaCheckInListener;
import com.iHotel.view.Event.CheckIn.TornaAllaPrenotazioneDaCheckInListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFC_AggiungiOspiti extends View {
	
	/* ----------------- Attributi e Costruttore ----------------------- */
	
	private PrenotazioneSubject _prenotazione;
	
	private JTabbedPane _panelMiddleTabbed;
	private JButton _btnTerminaCheckin, _btnTornaPrenotazione;
	/**
	 * 
	 */
	public VFC_AggiungiOspiti() {
		_panelMiddleTabbed=_viewFactory.getTabbedPane();
		// Bottoni
		_btnTerminaCheckin=_viewFactory.getButtonAvanti();
		_btnTornaPrenotazione=_viewFactory.getButton();
	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#removeInstance()
	 */
	@Override
	public void removeInstance() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelTop()
	 */
	@Override
	protected void creaPanelTop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelMiddle()
	 */
	@Override
	protected void creaPanelMiddle() {
		// Setto il layout al panelMiddle
    	_panelMiddle.setLayout(new BoxLayout(_panelMiddle, BoxLayout.PAGE_AXIS));
    	// Creo il tabbedPane
    	ArrayList<CameraContext> camerePrenotazione = _prenotazione.get_camerePrenotate();
    	// Ciclo sulle camere per aggiungere i tab.
    	for (Iterator<CameraContext> iterator = camerePrenotazione.iterator(); iterator.hasNext();) {
			CameraContext camera = (CameraContext) iterator.next();
			// Creo panel per tab
			JPanel panelCamera = creaPanelCamera();
			// Aggiungo tab al tabbedPane
			_panelMiddleTabbed.addTab("Camera " + camera.get_numero(), panelCamera);
			// Aggiungo il tabbedPane al panelMiddle
			_panelMiddle.add(_panelMiddleTabbed);
		}

	}
	/**
	 * Metodo per creare un pannello relativo ad una camera. In particolare si costituisce
	 * di una parte per l'inserimento dei dati degli ospiti della camera, e di una parte
	 * per visualizzare la lista degli ospiti della camera.
	 * @return
	 */
	private JPanel creaPanelCamera() {
		JPanel panelCamera = _viewFactory.getPanel();
		// Setto il layout 1 riga - 2 colonne - 5px tra righe - 0px tra colonne
		panelCamera.setLayout(new GridLayout(1, 2, 5, 0));
		// Panel inserimento dati
		panelCamera.add(creaPanelCameraDatiOspite());
		// Panel lista ospiti
		panelCamera.add(creaPanelCameraListaOspiti());
		return panelCamera;
	}
	/**
	 * Metodo per ottenere un pannello per inserire i dati dell'ospite.
	 * @return
	 */
	private JScrollPane creaPanelCameraDatiOspite() {
		JScrollPane scrollPaneCameraDatiOspite = _viewFactory.getScrollPane();
		// Creo il panel.
		JPanel panelCameraDatiOspite = _viewFactory.getPanel();
		// Setto layout panel.
		panelCameraDatiOspite.setLayout(new BoxLayout(panelCameraDatiOspite, BoxLayout.PAGE_AXIS));
		// Dati ospite
			// Nome
			JLabel lblNome = _viewFactory.getLabelIntestazione_2();
			lblNome.setText("Nome:");
			JTextField txtNome = _viewFactory.getTextField();
			// Cognome
			JLabel lblCognome = _viewFactory.getLabelIntestazione_2();
			lblCognome.setText("Cognome:");
			JTextField txtCognome = _viewFactory.getTextField();
		
			
		// Aggiungo campi al panel
			// Nome
			panelCameraDatiOspite.add(lblNome);
			panelCameraDatiOspite.add(Box.createVerticalGlue());
			panelCameraDatiOspite.add(txtNome);
			// Cognome
			panelCameraDatiOspite.add(lblCognome);
			panelCameraDatiOspite.add(Box.createVerticalGlue());
			panelCameraDatiOspite.add(txtCognome);
		
		// Aggiungo il JPanel con i dati dell'ospite allo JScrollPane
		scrollPaneCameraDatiOspite.setViewportView(panelCameraDatiOspite);
		
		return scrollPaneCameraDatiOspite;
	}
	/**
	 * Metodo per ottenere il pannello contenente la lista degli ospiti della camera per
	 * una specifica prenotazione.
	 * @return
	 */
	private JPanel creaPanelCameraListaOspiti() {
		JPanel panelCameraListaOspiti = _viewFactory.getPanel();
		
		return panelCameraListaOspiti;
	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelBottom()
	 */
	@Override
	protected void creaPanelBottom() {
		// Button completa prenotazione.
		_btnTerminaCheckin.setText("Termina CheckIn");
		// Assegniamo l'eventListener al JButton btnTerminaCheckin.
		_btnTerminaCheckin.addMouseListener(new TerminaCheckInListener());
		
		// Button torna alla prenotazione.
		_btnTornaPrenotazione.setText("Torna Prenotazione");
		// Assegniamo l'eventListener al JButton btnTerminaCheckin.
		_btnTornaPrenotazione.addMouseListener(new TornaAllaPrenotazioneDaCheckInListener());
		
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
	public void creaFrame(PrenotazioneSubject prenotazione) {
		setTitle("iHotel - Check in");
		// Setto la prenotazione
		_prenotazione=prenotazione;

		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Inizializzo lo strato di dominio
		UStartup start = new UStartup();
		start.inizializza();
		// Prendo una prenotazione
		HashMap<String,PrenotazioneSubject> prenotazioni = Storico.getInstance().get_prenotazioni();
		PrenotazioneSubject prenotazione = prenotazioni.get("1400100535949");
		// Creo il frame
		VFC_AggiungiOspiti frame = new VFC_AggiungiOspiti();
		frame.creaFrame(prenotazione);
		frame.setVisible(true);
	
	}
	
	/* ---------------------- Getter, Setter ----------------------------- */

	/**
	 * @return the _prenotazione
	 */
	public PrenotazioneSubject get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(PrenotazioneSubject _prenotazione) {
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
