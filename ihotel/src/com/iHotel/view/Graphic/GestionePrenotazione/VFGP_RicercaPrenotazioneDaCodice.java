/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.EvidenziaTextBoxListener;
import com.iHotel.view.Event.GestionePrenotazione.RicercaPrenotazioneDaCodiceListener;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VFGP_RicercaPrenotazioneDaCodice extends View {

	private String _codicePrenotazione;
	// Singleton
	private static VFGP_RicercaPrenotazioneDaCodice instance = null;
	
	/*Panel*/
	private JPanel _panelMiddleTop, _panelMiddleBottom;
	
	/*Label*/
	private JLabel _lblTitolo, _labelInstruction;
	
	/*TextField*/
	private JTextField _txtReservationCode;
	
	/*Button*/
	private JButton _btnReservationRecover;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_RicercaPrenotazioneDaCodice() {
		
		// JPanel
		_panelMiddleTop=_viewFactory.getPanel();
		_panelMiddleBottom=_viewFactory.getPanel();
		// JLabel
		_labelInstruction=_viewFactory.getLabel();
		_lblTitolo= _viewFactory.getLabel();
		// JButton
		_btnReservationRecover=_viewFactory.getButton();
		// JTextField
		_txtReservationCode=_viewFactory.getTextField();
	};	
	
	/**
	 * Metodo che consente di avere una sola istanza della schermata
	 * @return
	 */
	public static VFGP_RicercaPrenotazioneDaCodice getInstance(){
		if (instance == null){
			instance = new VFGP_RicercaPrenotazioneDaCodice();
		}
		return instance;
	}
	@Override
	protected void creaPanelTop() {
		/*Testo della label*/
		_lblTitolo.setText("Inserimento Codice della prenotazione");
		/*Aggiungo la label*/
		_panelTop.add(_lblTitolo);
	}

	@Override
	protected void creaPanelMiddle() {
		/*Setto il layout*/
		_panelMiddle.setLayout(new BorderLayout());
		
		/*Aggiungo i pannelli superiore e inferiore*/
		_panelMiddle.add(creaPanelMiddleTop(),BorderLayout.PAGE_START);
		_panelMiddle.add(creaPanelMiddleBottom(),BorderLayout.CENTER);	
	}
	/**
	 * Metodo che aggiunge il pannello alto al panelMiddle
	 * @return _panelMiddleTop Il pannello alto del panelMiddle
	 */
	private JPanel creaPanelMiddleTop(){
		/*Setto il testo dell'etichetta*/
		_labelInstruction.setText("Inserisci qui sotto il codice della prenotazione che vuoi cercare");
		_panelMiddleTop.add(_labelInstruction);
		/*Restituisco il pannello*/
		return _panelMiddleTop;
	}
	/**
	 * Aggiungo il pannello basso al panelMiddle
	 * @return _panelMiddleBottom Il pannello basso del panelMiddle
	 */
	private JPanel creaPanelMiddleBottom(){
		/*Setto il layout*/
		_panelMiddleBottom.setLayout(new BoxLayout(_panelMiddleBottom, BoxLayout.Y_AXIS));
		_panelMiddleBottom.add(Box.createRigidArea(new Dimension(0,15)));
		/*Setto il focus sulla casella di testo*/
		_txtReservationCode.setFocusable(true);
		_txtReservationCode.setBackground(new Color(99,150,55));
		_txtReservationCode.setSize(new Dimension(200,100));
		/*Aggiungo la casella di testo al pannello*/
		_panelMiddleBottom.add(_txtReservationCode,BorderLayout.CENTER);
		
		_txtReservationCode.addMouseListener(new EvidenziaTextBoxListener());
		/*Restituisco il pannello*/
		return _panelMiddleBottom;
	}

	@Override
	protected void creaPanelBottom() {
		/*Setto il layout*/
		_panelBottom.setLayout(new BorderLayout());
		
		/*Testo del pulsante e lo aggiungo*/
		_btnReservationRecover.setText("Cerca prenotazione");
		_panelBottom.add(_btnReservationRecover,BorderLayout.EAST);
		// Aggiungo l'eventListener a _btnReservationRecover
		_btnReservationRecover.addMouseListener(new RicercaPrenotazioneDaCodiceListener());
	}
	
	/**
	 * Metodo che crea il frame
	 */
	public void creaFrame(){
		// Imposto il titolo e l'operazione in chiusura alla finestra
		setTitle("iHotel - Gestione Prenotazione - Inserimento codice per recuperare la prenotazione");
		
		/*Aggiungo i pannelli*/			
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
	}
	
	/* -------------------- Getter, Setter ----------------------- */

	/**
	 * @return the _codicePrenotazione
	 */
	public String get_codicePrenotazione() {
		return _codicePrenotazione;
	}

	/**
	 * @param _codicePrenotazione the _codicePrenotazione to set
	 */
	public void set_codicePrenotazione(String _codicePrenotazione) {
		this._codicePrenotazione = _codicePrenotazione;
	}

	/**
	 * @return the _txtReservationCode
	 */
	public JTextField get_txtReservationCode() {
		return _txtReservationCode;
	}

	/**
	 * @param _txtReservationCode the _txtReservationCode to set
	 */
	public void set_txtReservationCode(JTextField _txtReservationCode) {
		this._txtReservationCode = _txtReservationCode;
	}
}
