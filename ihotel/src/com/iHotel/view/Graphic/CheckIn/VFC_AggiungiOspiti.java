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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.State.CameraContext;
import com.iHotel.utility.UStartup;
import com.iHotel.view.ViewFrame;
import com.iHotel.view.Event.CheckIn.AggiungiOspiteAllaPrenotazioneListener;
import com.iHotel.view.Event.CheckIn.ScegliDocumentoListener;
import com.iHotel.view.Event.CheckIn.TerminaCheckInListener;
import com.iHotel.view.Event.CheckIn.TornaAllaPrenotazioneDaCheckInListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFC_AggiungiOspiti extends ViewFrame {
	
	/* -------------------------------- Attributi e Costruttore ----------------------------------------- */
	
	private PrenotazioneSubject _prenotazione;
	
	private JTabbedPane _panelMiddleTabbed;
	private JButton _btnTerminaCheckin, _btnTornaPrenotazione;
	private JLabel _lblTitolo;
	/**
	 * Unica instanza della classe - Pattern Singleton
	 */
	private static VFC_AggiungiOspiti instance=null;
	/**
	 * Costruttore privato - Pattern singleton.
	 */
	private VFC_AggiungiOspiti() {
		_panelMiddleTabbed=_viewFactory.getTabbedPane();
		// Bottoni
		_btnTerminaCheckin=_viewFactory.getButtonAvanti();
		_btnTornaPrenotazione=_viewFactory.getButton();
		// Label
		_lblTitolo=_viewFactory.getLabelIntestazione_1();
	}
	/* ------------------------------------------ Metodi di classe ----------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
	public static VFC_AggiungiOspiti getInstance() {
		if(instance == null) {
            instance = new VFC_AggiungiOspiti();
         }
         return instance;
	}
	/* -------------------------------------------- Metodi di instanza ------------------------------------- */
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
			
			_panelMiddleTabbed.addTab("Camera " + camera.get_numero(), new VFC_AggiungiOspiti_PanelCamera(camera));
			//_panelMiddleTabbed.addTab("Camera " + camera.get_numero(), panelCamera);
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
		JPanel panelCamera = _viewFactory.getPanelMiddle();
		// Setto il layout 1 riga - 2 colonne - 5px tra righe - 0px tra colonne
		panelCamera.setLayout(new GridLayout(1, 2, 5, 0));
		JPanel pnlMiddleRight = creaPanelMiddleRight(camera);
		JScrollPane pnlMiddleLeft = creaPanelMiddleLeft(camera, pnlMiddleRight);
		// Panel inserimento dati
		panelCamera.add(pnlMiddleLeft);
		// Panel lista ospiti
		panelCamera.add(pnlMiddleRight);
		return panelCamera;
	}
	/**
	 * Metodo per creare la parte centrale sinistra della pagina.
	 * 
	 * @param camera Camera che si sta analizzando.
	 * @param pnlMiddleRight Pannello contenente la lista degli ospiti di questa camera.
	 * @return
	 */
	private JScrollPane creaPanelMiddleLeft(CameraContext camera, JPanel pnlMiddleRight) {
		JScrollPane scrollPaneCameraDatiOspite = _viewFactory.getScrollPane();
		// Creo il panel.
		JPanel panelCameraDatiOspite = _viewFactory.getPanel(true);
		// Setto layout panel.
		panelCameraDatiOspite.setLayout(new BoxLayout(panelCameraDatiOspite, BoxLayout.PAGE_AXIS));
		// Intestazione del pannello
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Aggiungi ospite:");
		
		// ComboBox Scelta tipo documento
		JComboBox<String> comboBoxTipologieDocumenti = new JComboBox<String>();
			// TODO - Aggiungo tipologie di documenti alla comboBox
		comboBoxTipologieDocumenti.addItem("CartaIdentita");
		comboBoxTipologieDocumenti.addItem("Patente");
		comboBoxTipologieDocumenti.addItem("Passaporto");
			
		// Pannello in cui inserire le informazioni sul documento
		JPanel pnlTipoDocumento = _viewFactory.getPanel(false);
		// Setto il layout al pannello per le informazioni sul documento.
		pnlTipoDocumento.setLayout(new CardLayout());
		// Inizializzo il pnlTipoDocumento
		creaPanelDocumento(pnlTipoDocumento);
		/* 
		* Assegno il gestore dell'evento alla JComboBox per visualizzare il tipo di documento corretto.
		* Fornisco come parametro il pannello pnlTipoDocumento in quanto poi alla scelta di uno o di uno o
		* di un altro dovrà fornire quello corretto.
		*/
		comboBoxTipologieDocumenti.addItemListener(new ScegliDocumentoListener(pnlTipoDocumento));
			
		// Aggiungo campi al panel
		// Aggiungo intestazione e spaziatura al pannello
		panelCameraDatiOspite.add(lblIntestazione);
		panelCameraDatiOspite.add(Box.createVerticalStrut(15));
		// Pannello info generali ospite
		panelCameraDatiOspite.add(creaPanelInformazioniOspiteGenerale());
		panelCameraDatiOspite.add(Box.createVerticalGlue());
		// ComboBox
		panelCameraDatiOspite.add(comboBoxTipologieDocumenti);
		panelCameraDatiOspite.add(Box.createVerticalGlue());
		// pnlTipoDocumento
		panelCameraDatiOspite.add(pnlTipoDocumento);
		panelCameraDatiOspite.add(Box.createVerticalGlue());
		// pnlBottone
		panelCameraDatiOspite.add(Box.createVerticalStrut(15));
		panelCameraDatiOspite.add(creaPanelBottoneInserisciOspite(camera,pnlMiddleRight));
	
		// Aggiungo il JPanel con i dati dell'ospite allo JScrollPane
		scrollPaneCameraDatiOspite.setViewportView(panelCameraDatiOspite);
		
		return scrollPaneCameraDatiOspite;
	}
	/**
	 * Metodo per fornire il pannello contenente le informazioni generali dell'ospite.
	 * 
	 * @return
	 */
	private JPanel creaPanelInformazioniOspiteGenerale() {
		JPanel pnlInformazioniOspiteGenerale = _viewFactory.getPanel(false);
		// Setto layout
		pnlInformazioniOspiteGenerale.setLayout(new GridLayout(4, 2, 0, 0));
		
		// Nome
		JLabel lblNome = _viewFactory.getLabelIntestazione_2();
		lblNome.setText("Nome:");
		JTextField txtNome = _viewFactory.getTextField();
		// Cognome
		JLabel lblCognome = _viewFactory.getLabelIntestazione_2();
		lblCognome.setText("Cognome:");
		JTextField txtCognome = _viewFactory.getTextField();
		// Città nascita
		JLabel lblCittaNascita = _viewFactory.getLabelIntestazione_2();
		lblCittaNascita.setText("Città Nascita:");
		JTextField txtCittaNascita = _viewFactory.getTextField();
		// Città residenza
		JLabel lblCittaResidenza = _viewFactory.getLabelIntestazione_2();
		lblCittaResidenza.setText("Città Nascita:");
		JTextField txtCittaResidenza = _viewFactory.getTextField();
		
		// Aggiungo componenti al pannello
		
		// Riga 1
		pnlInformazioniOspiteGenerale.add(lblNome);
		pnlInformazioniOspiteGenerale.add(lblCognome);
		// Riga 2
		pnlInformazioniOspiteGenerale.add(txtNome);		
		pnlInformazioniOspiteGenerale.add(txtCognome);
		// Riga 3
		pnlInformazioniOspiteGenerale.add(lblCittaResidenza);
		pnlInformazioniOspiteGenerale.add(lblCittaNascita);
		// Riga 4
		pnlInformazioniOspiteGenerale.add(txtCittaResidenza);
		pnlInformazioniOspiteGenerale.add(txtCittaNascita);
		
		return pnlInformazioniOspiteGenerale;
	}
	/**
	 * Metodo per creare il pannello corretto in base al tipo di documento.
	 * 
	 * @return
	 */
	private void creaPanelDocumento(JPanel pnlTipoDocumento) {
		// Recupero il gestore del layout
		CardLayout cardLayout = (CardLayout) pnlTipoDocumento.getLayout();
		// Aggiungo le schede
		pnlTipoDocumento.add(creaPanelCartaIdentita(), "CartaIdentita");
		pnlTipoDocumento.add(creaPanelPatente(), "Patente");
		pnlTipoDocumento.add(creaPanelPassaporto(), "Passaporto");
		// Mostro la scheda relativa alla carta d'identita
		cardLayout.show(pnlTipoDocumento, "CartaIdentita");
	}
	/**
	 * Pannello per inserire le informazioni della carta d'identità.
	 * 
	 * @return
	 */
	private JPanel creaPanelCartaIdentita() {
		JPanel pnlCartaIdentita = _viewFactory.getPanel(false);
		// Setto layout
		pnlCartaIdentita.setLayout(new BoxLayout(pnlCartaIdentita, BoxLayout.PAGE_AXIS));
		// Intestazione
		JLabel lblIntestazioneCartaIdentita = _viewFactory.getLabelIntestazione_2();
		lblIntestazioneCartaIdentita.setText("Dati carta d'identità:");
		// Pannello per i dati.
		JPanel pnlCartaIdentitaDati = _viewFactory.getPanel(false);
		// Setto layout.
		pnlCartaIdentitaDati.setLayout(new GridLayout(2, 2, 5, 5));
		// Codice.
		JLabel lblCodice = _viewFactory.getLabelIntestazione_2();
		lblCodice.setText("Codice:");
		JTextField txtCodice = _viewFactory.getTextField();
		// Ente.
		JLabel lblEnte = _viewFactory.getLabelIntestazione_2();
		lblEnte.setText("Ente:");
		JTextField txtEnte = _viewFactory.getTextField();
		
		// Aggiungo campi al pannello pnlCartaIdentitaDati
		// riga 1
		pnlCartaIdentitaDati.add(lblCodice);
		pnlCartaIdentitaDati.add(lblEnte);
		// riga 2
		pnlCartaIdentitaDati.add(txtCodice);
		pnlCartaIdentitaDati.add(txtEnte);
		
		// Aggiungo campi al pannello pnlCartaIdentita
		pnlCartaIdentita.add(lblIntestazioneCartaIdentita);
		pnlCartaIdentita.add(Box.createVerticalStrut(15));
		pnlCartaIdentita.add(pnlCartaIdentitaDati);
		
		return pnlCartaIdentita;
	}
	/**
	 * Pannello per inserire le informazioni della patente.
	 * 
	 * @return
	 */
	private JPanel creaPanelPatente() {
		
		JPanel pnlPatente = _viewFactory.getPanel(false);
		// Setto layout
		pnlPatente.setLayout(new BoxLayout(pnlPatente, BoxLayout.PAGE_AXIS));
		// Intestazione
		JLabel lblIntestazionePatente = _viewFactory.getLabelIntestazione_2();
		lblIntestazionePatente.setText("Dati Patente:");
		// Pannello per i dati.
		JPanel pnlPatenteDati = _viewFactory.getPanel(false);
		// Setto layout.
		pnlPatenteDati.setLayout(new GridLayout(2, 2, 5, 5));
		// Codice.
		JLabel lblCodice = _viewFactory.getLabelIntestazione_2();
		lblCodice.setText("Codice:");
		JTextField txtCodice = _viewFactory.getTextField();
		// Ente.
		JLabel lblEnte = _viewFactory.getLabelIntestazione_2();
		lblEnte.setText("Ente:");
		JTextField txtEnte = _viewFactory.getTextField();
		
		// Aggiungo campi al pannello pnlPatenteDati
		// riga 1
		pnlPatenteDati.add(lblCodice);
		pnlPatenteDati.add(lblEnte);
		// riga 2
		pnlPatenteDati.add(txtCodice);
		pnlPatenteDati.add(txtEnte);
		
		// Aggiungo campi al pannello pnlCartaIdentita
		pnlPatente.add(lblIntestazionePatente);
		pnlPatente.add(Box.createVerticalStrut(15));
		pnlPatente.add(pnlPatenteDati);
		
		return pnlPatente;
	}
	/**
	 * Pannello per inserire le informazioni del passaporto.
	 * 
	 * @return
	 */
	private JPanel creaPanelPassaporto() {
		JPanel pnlPassaporto = _viewFactory.getPanel(false);
		// Setto layout
		pnlPassaporto.setLayout(new BoxLayout(pnlPassaporto, BoxLayout.PAGE_AXIS));
		// Intestazione
		JLabel lblIntestazionePassaporto = _viewFactory.getLabelIntestazione_2();
		lblIntestazionePassaporto.setText("Dati Passaporto:");
		// Pannello per i dati.
		JPanel pnlPassaportoDati = _viewFactory.getPanel(false);
		// Setto layout.
		pnlPassaportoDati.setLayout(new GridLayout(2, 2, 5, 5));
		// Codice.
		JLabel lblCodice = _viewFactory.getLabelIntestazione_2();
		lblCodice.setText("Codice:");
		JTextField txtCodice = _viewFactory.getTextField();
		// Ente.
		JLabel lblEnte = _viewFactory.getLabelIntestazione_2();
		lblEnte.setText("Ente:");
		JTextField txtEnte = _viewFactory.getTextField();
		
		// Aggiungo campi al pannello pnlPassaportoDati
		// riga 1
		pnlPassaportoDati.add(lblCodice);
		pnlPassaportoDati.add(lblEnte);
		// riga 2
		pnlPassaportoDati.add(txtCodice);
		pnlPassaportoDati.add(txtEnte);
		
		// Aggiungo campi al pannello pnlPassaporto
		pnlPassaporto.add(lblIntestazionePassaporto);
		pnlPassaporto.add(Box.createVerticalStrut(15));
		pnlPassaporto.add(pnlPassaportoDati);
		
		return pnlPassaporto;
	}
	/**
	 * Metodo per creare il pannello, contenente il bottone per aggiungere l'ospite alla prenotazione.
	 * 
	 * @param camera Camera che si sta gestendo
	 * @param pnlMiddleRight Pannello contenente la lista degli ospiti per la camera in analisi.
	 * @return
	 */
	private JPanel creaPanelBottoneInserisciOspite(CameraContext camera, JPanel pnlMiddleRight) {
		// Creo pannello in cui inserire il bottone avanti
		JPanel pnlBtnAggiungiOspite = _viewFactory.getPanel(false);		
		// Bottone per aggiungere ospite
		JButton btnAggiungiOspite = _viewFactory.getButtonAvanti();
		btnAggiungiOspite.setText("Aggiungi ospite");
		// Aggiungo l'eventListener al btnAggiungiOspite
		btnAggiungiOspite.addActionListener(new AggiungiOspiteAllaPrenotazioneListener(camera,pnlMiddleRight));
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(1, btnAggiungiOspite);
		// Creo la pulsantiera.
		Integer numeroColonne = 2;
		creaPanelPulsanti(pnlBtnAggiungiOspite, numeroColonne, Bottoni);
		
		return pnlBtnAggiungiOspite;
	}
	/**
	 * Metodo per creare la parte centrale destra della pagina.
	 * 
	 * @param camera
	 * @return
	 */
	private JPanel creaPanelMiddleRight(CameraContext camera) {
		// panelContenitore a cui applico il card Layout
		JPanel panelListaConenitore = _viewFactory.getPanel(true);
		// Setto il layout al panelContenitore
		panelListaConenitore.setLayout(new CardLayout());
		// ScrollPane nel quale inserisco il panel per la lista.
		JScrollPane scrollPaneCameraListaOspiti = _viewFactory.getScrollPane();		
		// Aggiungo il JPanel con la lista degli ospiti allo JScrollPane
		scrollPaneCameraListaOspiti.setViewportView(creaPanelListaOspiti(camera));
		// Aggiuno lo scrollPane al panelContenitore
		panelListaConenitore.add(scrollPaneCameraListaOspiti);
		
		return panelListaConenitore;
	}
	/**
	 * Metodo per creare il pannello dove si mostrano gli ospiti della camera.
	 * 
	 * @param camera
	 * @return
	 */
	public JPanel creaPanelListaOspiti(CameraContext camera) {
		JPanel panelListaOspiti = _viewFactory.getPanel(false);
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
		PrenotazioneSubject prenotazione = prenotazioni.get("1400256191901");
		// Creo il frame
		VFC_AggiungiOspiti frame = VFC_AggiungiOspiti.getInstance();
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
