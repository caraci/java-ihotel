/**
 * 
 */
package com.iHotel.view.Graphic.CheckIn;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
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
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.view.ViewPanel;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;
import com.iHotel.view.Event.CheckIn.AggiungiOspiteAllaPrenotazioneListener;
import com.iHotel.view.Event.CheckIn.ScegliDocumentoListener;
import com.iHotel.view.Utility.UtoString;


/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFC_AggiungiOspiti_PanelCamera extends ViewPanel {

	private Camera _camera;
	private SoggiornoContextSubject _prenotazione;
	/* JLabel */
	private JLabel _lblNome,_lblCognome,_lblIntestazioneMiddleLeft,_lblCittaNascita,_lblCittaResidenza,
				   _lblIntestazioneCartaIdentita,_lblCartaIdentitaCodice,_lblCartaIdentitaEnte,_lblIntestazionePatente,
				   _lblPatenteCodice,_lblPatenteEnte,_lblIntestazionePassaporto,_lblPassaportoCodice,_lblPassaportoEnte,
				   _lblCartaIdentitaDataRilascio,_lblCartaIdentitaDataScadenza, _lblPatenteDataRilascio,_lblPatenteDataScadenza,
				   _lblPassaportoDataRilascio,_lblPassaportoDataScadenza,_lblDataNascita;
	/* JTextField */
	private JTextField _txtCartaIdentitaCodice, _txtCartaIdentitaEnte, _txtNome, _txtCognome, _txtCittaNascita,
					   _txtCittaResidenza,_txtPatenteEnte,_txtPatenteCodice,_txtPassaportoCodice,_txtPassaportoEnte;
	/* JPanel */
	private JPanel _pnlMiddleRight,_pnlMiddleLeft,_panelCameraDatiOspite,_pnlTipoDocumento,_pnlContieniDocumento,_pnlCartaIdentita,
				   _pnlCartaIdentitaDati,_pnlBtnAggiungiOspite,_pnlPatente,_pnlPatenteDati,_pnlPassaporto,_pnlPassaportoDati;
	/* JComboBox */
	private JComboBox<String> _comboBoxTipologieDocumenti;
	/* JButton */
	private JButton _btnAggiungiOspite;
	private StyleAbstractFactory _viewFactory;
	/* JDatePicker */
	private JDatePicker _dataRilascioCartaIdentita,_dataScadenzaCartaIdentita,_dataRilascioPatente,_dataScadenzaPatente,
						_dataRilascioPassaporto,_dataScadenzaPassaporto,_dataNascita;
	
	/**
	 * Costruttore.
	 * 
	 * @param camera Camera che si sta visualizzando.
	 */
	public VFC_AggiungiOspiti_PanelCamera(Camera camera, SoggiornoContextSubject prenotazione) {
		super();
		_camera=camera;
		_prenotazione=prenotazione;
		// Prendo la factory dei componenti dell'interfaccia
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		// JPanel
		_pnlMiddleRight=_viewFactory.getPanel(true);
		_pnlMiddleLeft=_viewFactory.getPanel(true);
		_panelCameraDatiOspite=_viewFactory.getPanel(false);
		_pnlTipoDocumento=_viewFactory.getPanel(false);
		_pnlContieniDocumento=_viewFactory.getPanel(false);
		_pnlCartaIdentita=_viewFactory.getPanel(false);
		_pnlCartaIdentitaDati=_viewFactory.getPanel(false);
		_pnlBtnAggiungiOspite=_viewFactory.getPanel(false);
		_pnlPatente=_viewFactory.getPanel(false);
		_pnlPatenteDati=_viewFactory.getPanel(false);
		_pnlPassaporto=_viewFactory.getPanel(false);
		_pnlPassaportoDati=_viewFactory.getPanel(false);
		// JLabel
		_lblIntestazioneMiddleLeft=_viewFactory.getLabelIntestazione_2();
		_lblIntestazioneCartaIdentita=_viewFactory.getLabelIntestazione_2();
		_lblIntestazionePatente=_viewFactory.getLabelIntestazione_2();
		_lblIntestazionePassaporto=_viewFactory.getLabelIntestazione_2();
		_lblCartaIdentitaCodice=_viewFactory.getLabel();
		_lblCartaIdentitaEnte=_viewFactory.getLabel();
		_lblNome=_viewFactory.getLabel();
		_lblCognome=_viewFactory.getLabel();
		_lblCittaNascita=_viewFactory.getLabel();
		_lblCittaResidenza=_viewFactory.getLabel();
		_lblDataNascita=_viewFactory.getLabel();
		_lblPatenteCodice=_viewFactory.getLabel();
		_lblPatenteEnte=_viewFactory.getLabel();
		_lblPassaportoCodice=_viewFactory.getLabel();
		_lblPassaportoEnte=_viewFactory.getLabel();
		_lblCartaIdentitaDataRilascio=_viewFactory.getLabel();
		_lblCartaIdentitaDataScadenza=_viewFactory.getLabel();
		_lblPatenteDataRilascio=_viewFactory.getLabel();
		_lblPatenteDataScadenza=_viewFactory.getLabel();
		_lblPassaportoDataRilascio=_viewFactory.getLabel();
		_lblPassaportoDataScadenza=_viewFactory.getLabel();
		
		// JTextField
		_txtNome=_viewFactory.getTextField();
		_txtCognome=_viewFactory.getTextField();
		_txtCittaNascita=_viewFactory.getTextField();
		_txtCittaResidenza=_viewFactory.getTextField();
		_txtCartaIdentitaCodice=_viewFactory.getTextField();
		_txtCartaIdentitaEnte=_viewFactory.getTextField();
		_txtPatenteEnte = _viewFactory.getTextField();
		_txtPatenteCodice = _viewFactory.getTextField();
		_txtPassaportoCodice = _viewFactory.getTextField();
		_txtPassaportoEnte = _viewFactory.getTextField();
		// JComboBox
		_comboBoxTipologieDocumenti=new JComboBox<String>();
		// JButton
		_btnAggiungiOspite=_viewFactory.getButtonAvanti();
		// JDatePicker
		_dataRilascioCartaIdentita = JDateComponentFactory.createJDatePicker();
		_dataScadenzaCartaIdentita = JDateComponentFactory.createJDatePicker();
		_dataRilascioPatente = JDateComponentFactory.createJDatePicker();
		_dataScadenzaPatente = JDateComponentFactory.createJDatePicker();
		_dataRilascioPassaporto = JDateComponentFactory.createJDatePicker();
		_dataScadenzaPassaporto = JDateComponentFactory.createJDatePicker();
		_dataNascita = JDateComponentFactory.createJDatePicker();
		/* Creo il pannello */
		this.creaPanelCamera();
	}
	
	/**
	 * Metodo per creare un pannello relativo ad una camera. In particolare si costituisce
	 * di una parte per l'inserimento dei dati degli ospiti della camera, e di una parte
	 * per visualizzare la lista degli ospiti della camera.
	 */
	private void creaPanelCamera() {
		// Setto il layout 1 riga - 2 colonne - 5px tra righe - 0px tra colonne
		this.setLayout(new GridLayout(1, 2, 5, 5));
		_pnlMiddleLeft = creaPanelMiddleLeft();
		_pnlMiddleRight = creaPanelMiddleRight();
		// Panel inserimento dati
		this.add(_pnlMiddleLeft);
		// Panel lista ospiti
		this.add(_pnlMiddleRight);
	}
	
	/**
	 * Metodo per creare la parte centrale sinistra della pagina.
	 * 
	 * @return
	 */
	private JPanel creaPanelMiddleLeft() {
		// Setto Layout pnlMiddleLeft
		_pnlMiddleLeft.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Creo lo scollPane nel quale inserirò il necessario per inserire i dati del nuovo ospite.
		JScrollPane scrollPaneCameraDatiOspite = _viewFactory.getScrollPane();
		// Setto layout panel.
		_panelCameraDatiOspite.setLayout(new BoxLayout(_panelCameraDatiOspite, BoxLayout.PAGE_AXIS));
		// Intestazione del pannello
		JPanel pnlIntestazione = _viewFactory.getPanel(false);
		pnlIntestazione.setLayout(new BorderLayout(0, 0));
		_lblIntestazioneMiddleLeft.setText("Aggiungi ospite:");
		// Aggiungo label al pnlIntestazione
		pnlIntestazione.add(_lblIntestazioneMiddleLeft);
		// Aggiungo intestazione e spaziatura al pannello
		_panelCameraDatiOspite.add(pnlIntestazione);
		_panelCameraDatiOspite.add(Box.createVerticalStrut(15));
		// Pannello info generali ospite
		_panelCameraDatiOspite.add(creaPanelInformazioniOspiteGenerale());
		_panelCameraDatiOspite.add(Box.createVerticalGlue());
		// pnlDocumento
		_panelCameraDatiOspite.add(creaPanelDocumento());
		_panelCameraDatiOspite.add(Box.createVerticalGlue());
	
		// Aggiungo il JPanel con i dati dell'ospite allo JScrollPane
		scrollPaneCameraDatiOspite.setViewportView(_panelCameraDatiOspite);
		
		// Aggiungo gli elementi al _pnlMiddleLeft
		_pnlMiddleLeft.add(scrollPaneCameraDatiOspite);
		_pnlMiddleLeft.add(creaPanelBottoneInserisciOspite());
		
		return _pnlMiddleLeft;
	}
	/**
	 * Metodo per fornire il pannello contenente le informazioni generali dell'ospite.
	 * 
	 * @return
	 */
	private JPanel creaPanelInformazioniOspiteGenerale() {
		JPanel pnlInformazioniOspiteGenerale = _viewFactory.getPanel(false);
		// Setto layout
		pnlInformazioniOspiteGenerale.setLayout(new GridLayout(5, 2, 5, 5));
		
		// Nome
		_lblNome.setText("Nome:");
		// Cognome
		_lblCognome.setText("Cognome:");
		// Città nascita
		_lblCittaNascita.setText("Città Nascita:");
		// Città residenza
		_lblCittaResidenza.setText("Città Residenza:");
		// Data di nascita
		_lblDataNascita.setText("Data di nascita:");
		// Aggiungo componenti al pannello
		
		// Riga 1
		pnlInformazioniOspiteGenerale.add(_lblNome);
		pnlInformazioniOspiteGenerale.add(_txtNome);
		// Riga 2
		pnlInformazioniOspiteGenerale.add(_lblCognome);		
		pnlInformazioniOspiteGenerale.add(_txtCognome);
		// Riga 3
		pnlInformazioniOspiteGenerale.add(_lblCittaResidenza);
		pnlInformazioniOspiteGenerale.add(_txtCittaResidenza);
		// Riga 4
		pnlInformazioniOspiteGenerale.add(_lblCittaNascita);
		pnlInformazioniOspiteGenerale.add(_txtCittaNascita);
		// Riga 5
		pnlInformazioniOspiteGenerale.add(_lblDataNascita);
		pnlInformazioniOspiteGenerale.add((Component) _dataNascita);
		
		return pnlInformazioniOspiteGenerale;
	}
	
	/**
	 * Metodo per creare il pannello del documento.
	 * 
	 * @return
	 */
	private JPanel creaPanelDocumento() {
		_pnlContieniDocumento.setLayout(new BoxLayout(_pnlContieniDocumento, BoxLayout.PAGE_AXIS));
		// Aggiungo tipologie di documenti alla comboBox
		_comboBoxTipologieDocumenti.addItem("CartaIdentita");
		_comboBoxTipologieDocumenti.addItem("Patente");
		_comboBoxTipologieDocumenti.addItem("Passaporto");
		/* 
		* Assegno il gestore dell'evento alla JComboBox per visualizzare il tipo di documento corretto.
		* Fornisco come parametro il pannello pnlTipoDocumento in quanto poi alla scelta di uno o di uno o
		* di un altro dovrà fornire quello corretto.
		*/
		_comboBoxTipologieDocumenti.addItemListener(new ScegliDocumentoListener(this));
		// Setto il layout al pannello per le informazioni sul documento.
		_pnlTipoDocumento.setLayout(new CardLayout());
		// Recupero il gestore del layout
		CardLayout cardLayout = (CardLayout) _pnlTipoDocumento.getLayout();
		// Aggiungo le schede
		_pnlTipoDocumento.add(creaPanelCartaIdentita(), "CartaIdentita");
		_pnlTipoDocumento.add(creaPanelPatente(), "Patente");
		_pnlTipoDocumento.add(creaPanelPassaporto(), "Passaporto");
		// Mostro la scheda relativa alla carta d'identita
		cardLayout.show(_pnlTipoDocumento, "CartaIdentita");
		// Aggiungo il _pnlTipoDocumento a _pnlContieniDocumento;
		_pnlContieniDocumento.add(_comboBoxTipologieDocumenti);
		_pnlContieniDocumento.add(_pnlTipoDocumento);
		
		return _pnlContieniDocumento;
	}
	/**
	 * Pannello per inserire le informazioni della carta d'identità.
	 * 
	 * @return
	 */
	private JPanel creaPanelCartaIdentita() {
		// Setto layout
		_pnlCartaIdentita.setLayout(new BoxLayout(_pnlCartaIdentita, BoxLayout.PAGE_AXIS));
		// Intestazione
		JPanel pnlIntestazione = _viewFactory.getPanel(false);
		pnlIntestazione.setLayout(new BorderLayout(0, 0));
		_lblIntestazioneCartaIdentita.setText("Dati carta d'identità:");
		// Setto layout.
		_pnlCartaIdentitaDati.setLayout(new GridLayout(4, 2, 5, 5));
		// Codice.
		_lblCartaIdentitaCodice.setText("Codice:");
		// Ente.
		_lblCartaIdentitaEnte.setText("Ente:");
		// Data di rilascio
		_lblCartaIdentitaDataRilascio.setText("Data rilascio:");
		// Data di scadenza
		_lblCartaIdentitaDataScadenza.setText("Data rilascio:");
		
		// Aggiungo campi al pannello pnlCartaIdentitaDati
		// riga 1
		_pnlCartaIdentitaDati.add(_lblCartaIdentitaCodice);
		_pnlCartaIdentitaDati.add(_lblCartaIdentitaEnte);
		// riga 2
		_pnlCartaIdentitaDati.add(_txtCartaIdentitaCodice);
		_pnlCartaIdentitaDati.add(_txtCartaIdentitaEnte);
		// riga 3
		_pnlCartaIdentitaDati.add(_lblCartaIdentitaDataRilascio);
		_pnlCartaIdentitaDati.add(_lblCartaIdentitaDataScadenza);
		// riga 4
		_pnlCartaIdentitaDati.add((Component) _dataRilascioCartaIdentita);
		_pnlCartaIdentitaDati.add((Component) _dataScadenzaCartaIdentita);
		
		// Aggiungo intestazione al pnlIntestazione
		pnlIntestazione.add(_lblIntestazioneCartaIdentita);
		
		// Aggiungo campi al pannello pnlCartaIdentita
		_pnlCartaIdentita.add(pnlIntestazione);
		_pnlCartaIdentita.add(Box.createVerticalStrut(15));
		_pnlCartaIdentita.add(_pnlCartaIdentitaDati);
		
		return _pnlCartaIdentita;
	}
	/**
	 * Pannello per inserire le informazioni della patente.
	 * 
	 * @return
	 */
	private JPanel creaPanelPatente() {
		// Setto layout
		_pnlPatente.setLayout(new BoxLayout(_pnlPatente, BoxLayout.PAGE_AXIS));
		// Intestazione
		JPanel pnlIntestazione = _viewFactory.getPanel(false);
		pnlIntestazione.setLayout(new BorderLayout(0, 0));
		_lblIntestazionePatente.setText("Dati Patente:");
		// Setto layout.
		_pnlPatenteDati.setLayout(new GridLayout(4, 2, 5, 5));
		// Codice.
		_lblPatenteCodice.setText("Codice:");
		// Ente.
		_lblPatenteEnte.setText("Ente:");
		// Data di rilascio
		_lblPatenteDataRilascio.setText("Data rilascio:");
		// Data di scadenza
		_lblPatenteDataScadenza.setText("Data rilascio:");
		
		// Aggiungo campi al pannello _pnlPatenteDati
		// riga 1
		_pnlPatenteDati.add(_lblPatenteCodice);
		_pnlPatenteDati.add(_lblPatenteEnte);
		// riga 2
		_pnlPatenteDati.add(_txtPatenteCodice);
		_pnlPatenteDati.add(_txtPatenteEnte);
		// riga 3
		_pnlPatenteDati.add(_lblPatenteDataRilascio);
		_pnlPatenteDati.add(_lblPatenteDataScadenza);
		// riga 4
		_pnlPatenteDati.add((Component) _dataRilascioPatente);
		_pnlPatenteDati.add((Component) _dataScadenzaPatente);
		
		// Aggiungo label al _pnlIntestazione
		pnlIntestazione.add(_lblIntestazionePatente);
		
		// Aggiungo campi al pannello _pnlPatente
		_pnlPatente.add(pnlIntestazione);
		_pnlPatente.add(Box.createVerticalStrut(15));
		_pnlPatente.add(_pnlPatenteDati);
		
		return _pnlPatente;
	}
	/**
	 * Pannello per inserire le informazioni del passaporto.
	 * 
	 * @return
	 */
	private JPanel creaPanelPassaporto() {
		// Setto layout
		_pnlPassaporto.setLayout(new BoxLayout(_pnlPassaporto, BoxLayout.PAGE_AXIS));
		// Intestazione
		JPanel pnlIntestazione = _viewFactory.getPanel(false);
		pnlIntestazione.setLayout(new BorderLayout(0, 0));
		_lblIntestazionePassaporto.setText("Dati Passaporto:");
		// Setto layout.
		_pnlPassaportoDati.setLayout(new GridLayout(4, 2, 5, 5));
		// Codice.
		_lblPassaportoCodice.setText("Codice:");
		// Ente.
		_lblPassaportoEnte.setText("Ente:");
		// Data di rilascio
		_lblPassaportoDataRilascio.setText("Data rilascio:");
		// Data di scadenza
		_lblPassaportoDataScadenza.setText("Data rilascio:");
		
		// Aggiungo campi al pannello pnlPassaportoDati
		// riga 1
		_pnlPassaportoDati.add(_lblPassaportoCodice);
		_pnlPassaportoDati.add(_lblPassaportoEnte);
		// riga 2
		_pnlPassaportoDati.add(_txtPassaportoCodice);
		_pnlPassaportoDati.add(_txtPassaportoEnte);
		// riga 3
		_pnlPassaportoDati.add(_lblPassaportoDataRilascio);
		_pnlPassaportoDati.add(_lblPassaportoDataScadenza);
		// riga 4
		_pnlPassaportoDati.add((Component) _dataRilascioPassaporto);
		_pnlPassaportoDati.add((Component) _dataScadenzaPassaporto);
		
		// Aggiungo label al _pnlIntestazione
		pnlIntestazione.add(_lblIntestazionePassaporto);
		
		// Aggiungo campi al pannello pnlPassaporto
		_pnlPassaporto.add(pnlIntestazione);
		_pnlPassaporto.add(Box.createVerticalStrut(15));
		_pnlPassaporto.add(_pnlPassaportoDati);
		
		return _pnlPassaporto;
	}
	/**
	 * Metodo per creare il pannello, contenente il bottone per aggiungere l'ospite alla prenotazione.
	 * 
	 * @return
	 */
	private JPanel creaPanelBottoneInserisciOspite() {	
		_btnAggiungiOspite.setText("Aggiungi ospite");
		// Aggiungo l'eventListener al btnAggiungiOspite
		_btnAggiungiOspite.addActionListener(new AggiungiOspiteAllaPrenotazioneListener(this));
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(1, _btnAggiungiOspite);
		// Creo la pulsantiera.
		Integer numeroColonne = 2;
		creaPanelPulsanti(_pnlBtnAggiungiOspite, numeroColonne, Bottoni);
		
		return _pnlBtnAggiungiOspite;
	}
	/**
	 * Metodo per creare la parte centrale destra della pagina.
	 * 
	 * @return
	 */
	private JPanel creaPanelMiddleRight() {
		// Setto il layout al panelContenitore
		_pnlMiddleRight.setLayout(new CardLayout());
		// Aggiuno la lista degli ospiti al _pnlMiddleRight.
		_pnlMiddleRight.add(creaPanelListaOspiti());
		
		return _pnlMiddleRight;
	}
	/**
	 * Metodo per creare il pannello dove si mostrano gli ospiti della camera.
	 * 
	 * @return
	 */
	public JScrollPane creaPanelListaOspiti() {
		// ScrollPanel nel quale si inserirà la lista.
		JScrollPane scrollPaneCameraListaOspiti = _viewFactory.getScrollPane();
		// Pannello dove inserisco la lista degli ospiti.
		JPanel panelListaOspiti = _viewFactory.getPanel(false);
		// Setto il layout al panelListaOspiti
		panelListaOspiti.setLayout(new BoxLayout(panelListaOspiti, BoxLayout.PAGE_AXIS));
		// Intestazione del pannello
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Ospiti camera: " + _camera.get_numero());
		// Aggiungo intestazione e spaziatura al pannello
		panelListaOspiti.add(lblIntestazione);
		panelListaOspiti.add(Box.createVerticalStrut(15));
		// Lista degli ospiti della camera per la prenotazione.
		ArrayList<Ospite> ospitiCamera = _camera.getOspitiInPeriodo(_prenotazione.get_periodo());
		// Ciclo sugli ospiti della camera.
		for (Iterator<Ospite> iterator = ospitiCamera.iterator(); iterator.hasNext();) {
			Ospite ospite = (Ospite) iterator.next();
			// Nome Cognome
			JLabel lblOspite = _viewFactory.getLabel();
			lblOspite.setText(UtoString.getInstance().ospiteToString(ospite));
			// Aggiungo elementi al panel
			panelListaOspiti.add(lblOspite);
			// Aggiungo spaziatura
			panelListaOspiti.add(Box.createVerticalStrut(5));
		}
		// Aggiungo il JPanel con la lista degli ospiti allo JScrollPane
		scrollPaneCameraListaOspiti.setViewportView(panelListaOspiti);
		
		return scrollPaneCameraListaOspiti;
	}
	/* ------------------------------ Getter , Setter --------------------------------- */
	/**
	 * @return the _pnlMiddleRight
	 */
	public JPanel get_pnlMiddleRight() {
		return _pnlMiddleRight;
	}

	/**
	 * @param _pnlMiddleRight the _pnlMiddleRight to set
	 */
	public void set_pnlMiddleRight(JPanel _pnlMiddleRight) {
		this._pnlMiddleRight = _pnlMiddleRight;
	}

	/**
	 * @return the _pnlTipoDocumento
	 */
	public JPanel get_pnlTipoDocumento() {
		return _pnlTipoDocumento;
	}

	/**
	 * @param _pnlTipoDocumento the _pnlTipoDocumento to set
	 */
	public void set_pnlTipoDocumento(JPanel _pnlTipoDocumento) {
		this._pnlTipoDocumento = _pnlTipoDocumento;
	}

	/**
	 * @return the _camera
	 */
	public Camera get_camera() {
		return _camera;
	}

	/**
	 * @param _camera the _camera to set
	 */
	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}

	/**
	 * @return the _comboBoxTipologieDocumenti
	 */
	public JComboBox<String> get_comboBoxTipologieDocumenti() {
		return _comboBoxTipologieDocumenti;
	}

	/**
	 * @param _comboBoxTipologieDocumenti the _comboBoxTipologieDocumenti to set
	 */
	public void set_comboBoxTipologieDocumenti(
			JComboBox<String> _comboBoxTipologieDocumenti) {
		this._comboBoxTipologieDocumenti = _comboBoxTipologieDocumenti;
	}

	/**
	 * @return the _lblNome
	 */
	public JLabel get_lblNome() {
		return _lblNome;
	}

	/**
	 * @param _lblNome the _lblNome to set
	 */
	public void set_lblNome(JLabel _lblNome) {
		this._lblNome = _lblNome;
	}

	/**
	 * @return the _lblCognome
	 */
	public JLabel get_lblCognome() {
		return _lblCognome;
	}

	/**
	 * @param _lblCognome the _lblCognome to set
	 */
	public void set_lblCognome(JLabel _lblCognome) {
		this._lblCognome = _lblCognome;
	}

	/**
	 * @return the _txtNome
	 */
	public JTextField get_txtNome() {
		return _txtNome;
	}

	/**
	 * @param _txtNome the _txtNome to set
	 */
	public void set_txtNome(JTextField _txtNome) {
		this._txtNome = _txtNome;
	}

	/**
	 * @return the _txtCognome
	 */
	public JTextField get_txtCognome() {
		return _txtCognome;
	}

	/**
	 * @param _txtCognome the _txtCognome to set
	 */
	public void set_txtCognome(JTextField _txtCognome) {
		this._txtCognome = _txtCognome;
	}

	/**
	 * @return the _dataRilascioCartaIdentita
	 */
	public JDatePicker get_dataRilascioCartaIdentita() {
		return _dataRilascioCartaIdentita;
	}

	/**
	 * @param _dataRilascioCartaIdentita the _dataRilascioCartaIdentita to set
	 */
	public void set_dataRilascioCartaIdentita(JDatePicker _dataRilascioCartaIdentita) {
		this._dataRilascioCartaIdentita = _dataRilascioCartaIdentita;
	}

	/**
	 * @return the _dataScadenzaCartaIdentita
	 */
	public JDatePicker get_dataScadenzaCartaIdentita() {
		return _dataScadenzaCartaIdentita;
	}

	/**
	 * @param _dataScadenzaCartaIdentita the _dataScadenzaCartaIdentita to set
	 */
	public void set_dataScadenzaCartaIdentita(JDatePicker _dataScadenzaCartaIdentita) {
		this._dataScadenzaCartaIdentita = _dataScadenzaCartaIdentita;
	}

	/**
	 * @return the _dataRilascioPatente
	 */
	public JDatePicker get_dataRilascioPatente() {
		return _dataRilascioPatente;
	}

	/**
	 * @param _dataRilascioPatente the _dataRilascioPatente to set
	 */
	public void set_dataRilascioPatente(JDatePicker _dataRilascioPatente) {
		this._dataRilascioPatente = _dataRilascioPatente;
	}

	/**
	 * @return the _dataScadenzaPatente
	 */
	public JDatePicker get_dataScadenzaPatente() {
		return _dataScadenzaPatente;
	}

	/**
	 * @param _dataScadenzaPatente the _dataScadenzaPatente to set
	 */
	public void set_dataScadenzaPatente(JDatePicker _dataScadenzaPatente) {
		this._dataScadenzaPatente = _dataScadenzaPatente;
	}

	/**
	 * @return the _dataRilascioPassaporto
	 */
	public JDatePicker get_dataRilascioPassaporto() {
		return _dataRilascioPassaporto;
	}

	/**
	 * @param _dataRilascioPassaporto the _dataRilascioPassaporto to set
	 */
	public void set_dataRilascioPassaporto(JDatePicker _dataRilascioPassaporto) {
		this._dataRilascioPassaporto = _dataRilascioPassaporto;
	}

	/**
	 * @return the _dataScadenzaPassaporto
	 */
	public JDatePicker get_dataScadenzaPassaporto() {
		return _dataScadenzaPassaporto;
	}

	/**
	 * @param _dataScadenzaPassaporto the _dataScadenzaPassaporto to set
	 */
	public void set_dataScadenzaPassaporto(JDatePicker _dataScadenzaPassaporto) {
		this._dataScadenzaPassaporto = _dataScadenzaPassaporto;
	}

	/**
	 * @return the _dataNascita
	 */
	public JDatePicker get_dataNascita() {
		return _dataNascita;
	}

	/**
	 * @param _dataNascita the _dataNascita to set
	 */
	public void set_dataNascita(JDatePicker _dataNascita) {
		this._dataNascita = _dataNascita;
	}

	/**
	 * @return the _txtCartaIdentitaCodice
	 */
	public JTextField get_txtCartaIdentitaCodice() {
		return _txtCartaIdentitaCodice;
	}

	/**
	 * @param _txtCartaIdentitaCodice the _txtCartaIdentitaCodice to set
	 */
	public void set_txtCartaIdentitaCodice(JTextField _txtCartaIdentitaCodice) {
		this._txtCartaIdentitaCodice = _txtCartaIdentitaCodice;
	}

	/**
	 * @return the _txtCartaIdentitaEnte
	 */
	public JTextField get_txtCartaIdentitaEnte() {
		return _txtCartaIdentitaEnte;
	}

	/**
	 * @param _txtCartaIdentitaEnte the _txtCartaIdentitaEnte to set
	 */
	public void set_txtCartaIdentitaEnte(JTextField _txtCartaIdentitaEnte) {
		this._txtCartaIdentitaEnte = _txtCartaIdentitaEnte;
	}

	/**
	 * @return the _txtCittaNascita
	 */
	public JTextField get_txtCittaNascita() {
		return _txtCittaNascita;
	}

	/**
	 * @param _txtCittaNascita the _txtCittaNascita to set
	 */
	public void set_txtCittaNascita(JTextField _txtCittaNascita) {
		this._txtCittaNascita = _txtCittaNascita;
	}

	/**
	 * @return the _txtCittaResidenza
	 */
	public JTextField get_txtCittaResidenza() {
		return _txtCittaResidenza;
	}

	/**
	 * @param _txtCittaResidenza the _txtCittaResidenza to set
	 */
	public void set_txtCittaResidenza(JTextField _txtCittaResidenza) {
		this._txtCittaResidenza = _txtCittaResidenza;
	}

	/**
	 * @return the _txtPatenteEnte
	 */
	public JTextField get_txtPatenteEnte() {
		return _txtPatenteEnte;
	}

	/**
	 * @param _txtPatenteEnte the _txtPatenteEnte to set
	 */
	public void set_txtPatenteEnte(JTextField _txtPatenteEnte) {
		this._txtPatenteEnte = _txtPatenteEnte;
	}

	/**
	 * @return the _txtPatenteCodice
	 */
	public JTextField get_txtPatenteCodice() {
		return _txtPatenteCodice;
	}

	/**
	 * @param _txtPatenteCodice the _txtPatenteCodice to set
	 */
	public void set_txtPatenteCodice(JTextField _txtPatenteCodice) {
		this._txtPatenteCodice = _txtPatenteCodice;
	}

	/**
	 * @return the _txtPassaportoCodice
	 */
	public JTextField get_txtPassaportoCodice() {
		return _txtPassaportoCodice;
	}

	/**
	 * @param _txtPassaportoCodice the _txtPassaportoCodice to set
	 */
	public void set_txtPassaportoCodice(JTextField _txtPassaportoCodice) {
		this._txtPassaportoCodice = _txtPassaportoCodice;
	}

	/**
	 * @return the _txtPassaportoEnte
	 */
	public JTextField get_txtPassaportoEnte() {
		return _txtPassaportoEnte;
	}

	/**
	 * @param _txtPassaportoEnte the _txtPassaportoEnte to set
	 */
	public void set_txtPassaportoEnte(JTextField _txtPassaportoEnte) {
		this._txtPassaportoEnte = _txtPassaportoEnte;
	}
}