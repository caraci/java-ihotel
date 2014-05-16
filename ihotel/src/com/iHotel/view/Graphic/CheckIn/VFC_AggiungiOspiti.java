/**
 * 
 */
package com.iHotel.view.Graphic.CheckIn;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Persona.Documento;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.State.CameraContext;
import com.iHotel.utility.UStartup;
import com.iHotel.view.View;
import com.iHotel.view.Event.CheckIn.AggiungiOspiteAllaPrenotazioneListener;
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
	private JLabel _lblTitolo;
	/**
	 * 
	 */
	public VFC_AggiungiOspiti() {
		_panelMiddleTabbed=_viewFactory.getTabbedPane();
		// Bottoni
		_btnTerminaCheckin=_viewFactory.getButtonAvanti();
		_btnTornaPrenotazione=_viewFactory.getButton();
		// Label
		_lblTitolo=_viewFactory.getLabelIntestazione_1();
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
    	ArrayList<CameraContext> camerePrenotazione = _prenotazione.get_camerePrenotate();
    	// Ciclo sulle camere per aggiungere i tab.
    	for (Iterator<CameraContext> iterator = camerePrenotazione.iterator(); iterator.hasNext();) {
			CameraContext camera = (CameraContext) iterator.next();
			// Creo panel per tab
			JPanel panelCamera = creaPanelCamera(camera);
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
	 * 
	 * @param camera
	 * @return
	 */
	private JPanel creaPanelCamera(CameraContext camera) {
		JPanel panelCamera = _viewFactory.getPanel();
		// Setto il layout 1 riga - 2 colonne - 5px tra righe - 0px tra colonne
		panelCamera.setLayout(new GridLayout(1, 2, 5, 0));
		// Panel inserimento dati
		panelCamera.add(creaPanelMiddleLeft(camera));
		// Panel lista ospiti
		panelCamera.add(creaPanelMiddleRight(camera));
		return panelCamera;
	}
	/**
	 * Metodo per creare la parte centrale sinistra della pagina.
	 * @return
	 */
	private JScrollPane creaPanelMiddleLeft(CameraContext camera) {
		JScrollPane scrollPaneCameraDatiOspite = _viewFactory.getScrollPane();
		// Creo il panel.
		JPanel panelCameraDatiOspite = _viewFactory.getPanel();
		// Setto layout panel.
		panelCameraDatiOspite.setLayout(new BoxLayout(panelCameraDatiOspite, BoxLayout.PAGE_AXIS));
		// Intestazione del pannello
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Ospiti camera: " + camera.get_numero());
		// Aggiungo intestazione e spaziatura al pannello
		panelCameraDatiOspite.add(lblIntestazione);
		panelCameraDatiOspite.add(Box.createVerticalStrut(15));
		// Dati ospite
			// Nome
			JLabel lblNome = _viewFactory.getLabelIntestazione_2();
			lblNome.setText("Nome:");
			JTextField txtNome = _viewFactory.getTextField();
			// Cognome
			JLabel lblCognome = _viewFactory.getLabelIntestazione_2();
			lblCognome.setText("Cognome:");
			JTextField txtCognome = _viewFactory.getTextField();
			// JComboBox - Scelta tipo documento
			JCheckBox comboBoxTipoDocumento = _viewFactory.getCheckBox();
			
			// Pannello in cui inserire le informazioni sul documento
			JPanel pnlTipoDocumento = _viewFactory.getPanel();
			// Setto il layout al pannello per le informazioni sul documento.
			pnlTipoDocumento.setLayout(new CardLayout());
		
		// Creo pannello in cui inserire il bottone avanti
			JPanel pnlBtnAggiungiOspite = _viewFactory.getPanel();		
			// Bottone per aggiungere ospite
			JButton btnAggiungiOspite = _viewFactory.getButtonAvanti();
			btnAggiungiOspite.setText("Aggiungi ospite");
			// Aggiungo l'eventListener al btnAggiungiOspite
			btnAggiungiOspite.addActionListener(new AggiungiOspiteAllaPrenotazioneListener());
			// Struttura dati dove si salvano i bottoni con la relativa posizione.
			HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
			// Aggiungo il bottone alla struttura.
			Bottoni.put(1, btnAggiungiOspite);
			// Creo la pulsantiera.
			Integer numeroColonne = 2;
			creaPanelPulsanti(pnlBtnAggiungiOspite, numeroColonne, Bottoni);
			
		// Aggiungo campi al panel
			// Nome
			panelCameraDatiOspite.add(lblNome);
			panelCameraDatiOspite.add(Box.createVerticalGlue());
			panelCameraDatiOspite.add(txtNome);
			// Cognome
			panelCameraDatiOspite.add(lblCognome);
			panelCameraDatiOspite.add(Box.createVerticalGlue());
			panelCameraDatiOspite.add(txtCognome);
			// ComboBox Scelta tipo documento
			
			
			// pnlBottone
			panelCameraDatiOspite.add(Box.createVerticalStrut(15));
			panelCameraDatiOspite.add(pnlBtnAggiungiOspite);
	
		
		
		// Aggiungo il JPanel con i dati dell'ospite allo JScrollPane
		scrollPaneCameraDatiOspite.setViewportView(panelCameraDatiOspite);
		
		return scrollPaneCameraDatiOspite;
	}
	/**
	 * Metodo per creare il pannello corretto in base al tipo di documento.
	 * @return
	 */
	private JPanel creaPanelDocumento(Documento documento) {
		// Recupero l'effettivo documento concreto
		Class<? extends Documento> documentoConcreto = documento.getClass();
		String tipoDocumento = documentoConcreto.getName();
		
		switch (tipoDocumento) {
		case "CartaIdentita":
			
			break;
		case "Passaporto":
			break;
		case "Patente":
			
			break;
		default:
			break;
		}
		
		JPanel pnlDocumento = _viewFactory.getPanel();
		
		return pnlDocumento;
	}
	/**
	 * Metodo per creare la parte centrale destra della pagina.
	 * 
	 * @param camera
	 * @return
	 */
	private JScrollPane creaPanelMiddleRight(CameraContext camera) {
		// panelContenitore a cui applico il card Layout
		JPanel panelListaConenitore = _viewFactory.getPanel();
		// Setto il layout al panelContenitore
		panelListaConenitore.setLayout(new CardLayout());
		// ScrollPane nel quale inserisco il panel per la lista.
		JScrollPane scrollPaneCameraListaOspiti = _viewFactory.getScrollPane();		
		// Aggiungo il JPanel con la lista degli ospiti allo JScrollPane
		scrollPaneCameraListaOspiti.setViewportView(creaPanelListaOspiti(camera));
		// Aggiuno lo scrollPane al panelContenitore
		panelListaConenitore.add(scrollPaneCameraListaOspiti);
		return scrollPaneCameraListaOspiti;
	}
	/**
	 * Metodo per creare il pannello dove si mostrano gli ospiti della camera.
	 * 
	 * @param camera
	 * @return
	 */
	private JPanel creaPanelListaOspiti(CameraContext camera) {
		JPanel panelListaOspiti = _viewFactory.getPanel();
		// Setto il layout al panelListaOspiti
		panelListaOspiti.setLayout(new BoxLayout(panelListaOspiti, BoxLayout.PAGE_AXIS));
		// Intestazione del pannello
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Ospiti camera: " + camera.get_numero());
		// Aggiungo intestazione e spaziatura al pannello
		panelListaOspiti.add(lblIntestazione);
		panelListaOspiti.add(Box.createVerticalStrut(15));
		// Lista degli ospiti della camera per la prenotazione.
		ArrayList<Ospite> ospitiCamera = camera.getOspitiInPeriodo(_prenotazione.get_periodo());
		// Ciclo sugli ospiti della camera.
		for (Iterator<Ospite> iterator = ospitiCamera.iterator(); iterator.hasNext();) {
			Ospite ospite = (Ospite) iterator.next();
			// Nome Cognome
			JLabel lblNomeCognome = _viewFactory.getLabel();
			lblNomeCognome.setText(ospite.get_nome() + " " + ospite.get_cognome());
			// Aggiungo elementi al panel
			panelListaOspiti.add(lblNomeCognome);
			// Aggiungo spaziatura
			panelListaOspiti.add(Box.createVerticalGlue());
		}
		return panelListaOspiti;
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
