/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.GridLayout;

import javax.swing.*;

import com.iHotel.view.View;
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
	private JPanel _panelTop, _panelMiddle, _panelBottom;
	/*Label*/
	private JLabel _labelInstruction;
	/*TextField*/
	private JTextField _txtReservationCode;
	/*Button*/
	private JButton _btnReservationRecover;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_RicercaPrenotazioneDaCodice() {
		// JPanel
		_panelTop=_viewFactory.getPanel();
		_panelMiddle=_viewFactory.getPanel();
		_panelBottom=_viewFactory.getPanel();
		// JLabel
		_labelInstruction=_viewFactory.getLabel();
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
	
	private void addTopPanel(){
		_labelInstruction.setText("Inserisci qui sotto il codice della prenotazione che vuoi cercare");
		_panelTop.setLayout(new GridLayout(1, 1, 10, 10));
		_panelTop.add(_labelInstruction);
		_contentPane.add(_panelTop);
	}
	
	private void addMiddlePanel(){
		_txtReservationCode.setFocusable(true);
		_panelMiddle.setLayout(new GridLayout(1, 1, 10, 10));		
		_panelMiddle.add(_txtReservationCode);
		_contentPane.add(_panelMiddle);
		
	}
	
	private void addButtomPanel(){
		_btnReservationRecover.setText("Cerca prenotazione");	
		_panelBottom.setLayout(new GridLayout(1, 1, 10, 10));
		_panelBottom.add(_btnReservationRecover);
		_contentPane.add(_panelBottom);
	}
	
	public void creaFrame(){
		// Imposto il titolo e l'operazione in chiusura alla finestra
		setTitle("iHotel - Gestione Prenotazione - Inserimento codice per recuperare la prenotazione");
		
		// setto i valori dell'etichetta, metto il cursore sul campo di testo e impongo il testo del pulsante
		_contentPane.setLayout(new GridLayout(3, 1, 10,10));		
				
		addTopPanel();
		addMiddlePanel();
		addButtomPanel();
		
		// Aggiungo l'eventListener a _btnReservationRecover
		_btnReservationRecover.addMouseListener(new RicercaPrenotazioneDaCodiceListener());
		
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
