/**
 * 
 */
package com.iHotel.view.Graphic.CheckIn;

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
import javax.swing.JTextField;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.ViewPanel;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;
import com.iHotel.view.Event.CheckIn.AggiungiOspiteAllaPrenotazioneListener;
import com.iHotel.view.Event.CheckIn.ScegliDocumentoListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFC_AggiungiOspiti_PanelCamera extends ViewPanel {

	private CameraContext _camera;
	private PrenotazioneSubject _prenotazione;
	/* JLabel */
	private JLabel _lblNome,_lblCognome,_lblIntestazioneMiddleLeft,_lblCittaNascita,_lblCittaResidenza,
				   _lblIntestazioneCartaIdentita,_lblCartaIdentitaCodice,_lblCartaIdentitaEnte,_lblIntestazionePatente,
				   _lblPatenteCodice,_lblPatenteEnte,_lblIntestazionePassaporto,_lblPassaportoCodice,_lblPassaportoEnte;
	/* JTextField */
	private JTextField _txtCartaIdentitaCodice, _txtCartaIdentitaEnte, _txtNome, _txtCognome, _txtCittaNascita,
					   _txtCittaResidenza,_txtPatenteEnte,_txtPatenteCodice,_txtPassaportoCodice,_txtPassaportoEnte;
	/* JPanel */
	private JPanel _pnlMiddleRight,_panelCameraDatiOspite,_pnlTipoDocumento,_pnlContieniDocumento,_pnlCartaIdentita,
				   _pnlCartaIdentitaDati,_pnlBtnAggiungiOspite,_pnlPatente,_pnlPatenteDati,_pnlPassaporto,_pnlPassaportoDati;
	/* JScrollPane */
	private JScrollPane _scrollPnlMiddleLeft;
	/* JComboBox */
	private JComboBox<String> _comboBoxTipologieDocumenti;
	/* JButton */
	private JButton _btnAggiungiOspite;
	private StyleAbstractFactory _viewFactory;
	
	/**
	 * Costruttore.
	 * 
	 * @param camera Camera che si sta visualizzando.
	 */
	public VFC_AggiungiOspiti_PanelCamera(CameraContext camera, PrenotazioneSubject prenotazione) {
		super();
		_camera=camera;
		_prenotazione=prenotazione;
		// Prendo la factory dei componenti dell'interfaccia
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		// JPanel
		_pnlMiddleRight=_viewFactory.getPanel(true);
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
		_lblPatenteCodice=_viewFactory.getLabel();
		_lblPatenteEnte=_viewFactory.getLabel();
		_lblPassaportoCodice=_viewFactory.getLabel();
		_lblPassaportoEnte=_viewFactory.getLabel();
		
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
		_scrollPnlMiddleLeft = creaPanelMiddleLeft();
		_pnlMiddleRight = creaPanelMiddleRight();
		// Panel inserimento dati
		this.add(_scrollPnlMiddleLeft);
		// Panel lista ospiti
		this.add(_pnlMiddleRight);
	}
	
	/**
	 * Metodo per creare la parte centrale sinistra della pagina.
	 * 
	 * @return
	 */
	private JScrollPane creaPanelMiddleLeft() {
		JScrollPane scrollPaneCameraDatiOspite = _viewFactory.getScrollPane();
		// Setto layout panel.
		_panelCameraDatiOspite.setLayout(new BoxLayout(_panelCameraDatiOspite, BoxLayout.PAGE_AXIS));
		// Intestazione del pannello
		_lblIntestazioneMiddleLeft.setText("Aggiungi ospite:");
	
		// Aggiungo intestazione e spaziatura al pannello
		_panelCameraDatiOspite.add(_lblIntestazioneMiddleLeft);
		_panelCameraDatiOspite.add(Box.createVerticalStrut(15));
		// Pannello info generali ospite
		_panelCameraDatiOspite.add(creaPanelInformazioniOspiteGenerale());
		_panelCameraDatiOspite.add(Box.createVerticalGlue());
		// pnlDocumento
		_panelCameraDatiOspite.add(creaPanelDocumento());
		_panelCameraDatiOspite.add(Box.createVerticalGlue());
		// pnlBottone
		_panelCameraDatiOspite.add(Box.createVerticalStrut(15));
		_panelCameraDatiOspite.add(creaPanelBottoneInserisciOspite());
	
		// Aggiungo il JPanel con i dati dell'ospite allo JScrollPane
		scrollPaneCameraDatiOspite.setViewportView(_panelCameraDatiOspite);
		
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
		_lblNome.setText("Nome:");
		// Cognome
		_lblCognome.setText("Cognome:");
		// Citt� nascita
		_lblCittaNascita.setText("Citt� Nascita:");
		// Citt� residenza
		_lblCittaResidenza.setText("Citt� Nascita:");
		
		// Aggiungo componenti al pannello
		
		// Riga 1
		pnlInformazioniOspiteGenerale.add(_lblNome);
		pnlInformazioniOspiteGenerale.add(_lblCognome);
		// Riga 2
		pnlInformazioniOspiteGenerale.add(_txtNome);		
		pnlInformazioniOspiteGenerale.add(_txtCognome);
		// Riga 3
		pnlInformazioniOspiteGenerale.add(_lblCittaResidenza);
		pnlInformazioniOspiteGenerale.add(_lblCittaNascita);
		// Riga 4
		pnlInformazioniOspiteGenerale.add(_txtCittaResidenza);
		pnlInformazioniOspiteGenerale.add(_txtCittaNascita);
		
		return pnlInformazioniOspiteGenerale;
	}
	
	/**
	 * Metodo per creare il pannello del documento.
	 * 
	 * @return
	 */
	private JPanel creaPanelDocumento() {
		_pnlContieniDocumento.setLayout(new BoxLayout(_pnlContieniDocumento, BoxLayout.PAGE_AXIS));
		// TODO - Aggiungo tipologie di documenti alla comboBox
		_comboBoxTipologieDocumenti.addItem("CartaIdentita");
		_comboBoxTipologieDocumenti.addItem("Patente");
		_comboBoxTipologieDocumenti.addItem("Passaporto");
		/* 
		* Assegno il gestore dell'evento alla JComboBox per visualizzare il tipo di documento corretto.
		* Fornisco come parametro il pannello pnlTipoDocumento in quanto poi alla scelta di uno o di uno o
		* di un altro dovr� fornire quello corretto.
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
	 * Pannello per inserire le informazioni della carta d'identit�.
	 * 
	 * @return
	 */
	private JPanel creaPanelCartaIdentita() {
		// Setto layout
		_pnlCartaIdentita.setLayout(new BoxLayout(_pnlCartaIdentita, BoxLayout.PAGE_AXIS));
		// Intestazione
		_lblIntestazioneCartaIdentita.setText("Dati carta d'identit�:");
		// Setto layout.
		_pnlCartaIdentitaDati.setLayout(new GridLayout(2, 2, 5, 5));
		// Codice.
		_lblCartaIdentitaCodice.setText("Codice:");
		// Ente.
		_lblCartaIdentitaEnte.setText("Ente:");
		
		// Aggiungo campi al pannello pnlCartaIdentitaDati
		// riga 1
		_pnlCartaIdentitaDati.add(_lblCartaIdentitaCodice);
		_pnlCartaIdentitaDati.add(_lblCartaIdentitaEnte);
		// riga 2
		_pnlCartaIdentitaDati.add(_txtCartaIdentitaCodice);
		_pnlCartaIdentitaDati.add(_txtCartaIdentitaEnte);
		
		// Aggiungo campi al pannello pnlCartaIdentita
		_pnlCartaIdentita.add(_lblIntestazioneCartaIdentita);
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
		_lblIntestazionePatente.setText("Dati Patente:");
		// Setto layout.
		_pnlPatenteDati.setLayout(new GridLayout(2, 2, 5, 5));
		// Codice.
		_lblPatenteCodice.setText("Codice:");
		// Ente.
		_lblPatenteEnte.setText("Ente:");
		
		// Aggiungo campi al pannello _pnlPatenteDati
		// riga 1
		_pnlPatenteDati.add(_lblPatenteCodice);
		_pnlPatenteDati.add(_lblPatenteEnte);
		// riga 2
		_pnlPatenteDati.add(_txtPatenteCodice);
		_pnlPatenteDati.add(_txtPatenteEnte);
		
		// Aggiungo campi al pannello _pnlPatente
		_pnlPatente.add(_lblIntestazionePatente);
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
		_lblIntestazionePassaporto.setText("Dati Passaporto:");
		// Setto layout.
		_pnlPassaportoDati.setLayout(new GridLayout(2, 2, 5, 5));
		// Codice.
		_lblPassaportoCodice.setText("Codice:");
		// Ente.
		_lblPassaportoEnte.setText("Ente:");
		
		// Aggiungo campi al pannello pnlPassaportoDati
		// riga 1
		_pnlPassaportoDati.add(_lblPassaportoCodice);
		_pnlPassaportoDati.add(_lblPassaportoEnte);
		// riga 2
		_pnlPassaportoDati.add(_txtPassaportoCodice);
		_pnlPassaportoDati.add(_txtPassaportoEnte);
		
		// Aggiungo campi al pannello pnlPassaporto
		_pnlPassaporto.add(_lblIntestazionePassaporto);
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
		// ScrollPanel nel quale si inserir� la lista.
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
			JLabel lblNomeCognome = _viewFactory.getLabel();
			lblNomeCognome.setText(ospite.get_nome() + " " + ospite.get_cognome());
			// Aggiungo elementi al panel
			panelListaOspiti.add(lblNomeCognome);
			// Aggiungo spaziatura
			panelListaOspiti.add(Box.createVerticalGlue());
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
}
