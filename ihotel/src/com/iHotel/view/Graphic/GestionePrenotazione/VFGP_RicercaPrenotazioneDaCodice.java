/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.RicercaPrenotazioneDaCodiceListener;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VFGP_RicercaPrenotazioneDaCodice extends View {
	
	/*Content pane*/
	private JPanel contentPane;
	/*Panel*/
	private JPanel panelTop, panelMiddle, panelBottom;
	/*Label*/
	private JLabel _labelInstruction;
	/*TextField*/
	private JTextField _txtReservationCode;
	/*Button*/
	private JButton _btnReservationRecover;
	private String _codicePrenotazione;
	
	
	private static VFGP_RicercaPrenotazioneDaCodice instance = null;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_RicercaPrenotazioneDaCodice() {};	
	
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
		_labelInstruction = _viewFactory.getLabel();
		_labelInstruction.setText("Inserisci qui sotto il codice della prenotazione che vuoi cercare");		
		panelTop = new JPanel();
		panelTop.setLayout(new GridLayout(1, 1, 10, 10));
		panelTop.add(_labelInstruction);
		contentPane.add(panelTop);
	}
	
	private void addMiddlePanel(){
		_txtReservationCode = new JTextField();
		_txtReservationCode.setFocusable(true);
		panelMiddle =new JPanel();
		panelMiddle.setLayout(new GridLayout(1, 1, 10, 10));		
		panelMiddle.add(_txtReservationCode);
		contentPane.add(panelMiddle);
		
	}
	
	private void addButtomPanel(){
		
		_btnReservationRecover = new JButton();
		_btnReservationRecover.setText("Cerca prenotazione");		
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridLayout(1, 1, 10, 10));
		panelBottom.add(_btnReservationRecover);
		contentPane.add(panelBottom);
		
	}
	
	public void creaFrame(){
		// Imposto il titolo e l'operazione in chiusura alla finestra
		setTitle("iHotel - Gestione Prenotazione - Inserimento codice per recuperare la prenotazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(50, 50, 800, 400);
		
		
		// setto i valori dell'etichetta, metto il cursore sul campo di testo e impongo il testo del pulsante
			
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 10,10));		
				
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
