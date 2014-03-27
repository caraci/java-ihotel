/**
 * 
 */
package com.iHotel.view.GestionePrenotazione;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.view.View;

/**
 * @author Alessandro
 *
 */
public class VFGP_InserimentoCodicePrenotazione extends View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panelTop,panelMiddle, panelBottom;
	private JLabel _labelInstruction;
	private JTextField _txtReservationCode;
	private JButton _btnReservationRecover;
	private String _codicePrenotazione;
	
	
	private static VFGP_InserimentoCodicePrenotazione instance = null;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_InserimentoCodicePrenotazione() {};	
	
	/**
	 * Metodo che consente di avere una sola istanza della schermata
	 * @return
	 */
	public static VFGP_InserimentoCodicePrenotazione getInstance(){
		if (instance == null){
			instance = new VFGP_InserimentoCodicePrenotazione();
		}
		return instance;
	}
	
	public void creaFrame(){
		// Imposto il titolo e l'operazione in chiusura alla finestra
		setTitle("iHotel - Gestione Prenotazione - Inserimento codice per recuperare la prenotazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(50, 50, 800, 400);
		
		// setto i valori dell'etichetta, metto il cursore sul campo di testo e impongo il testo del pulsante
		_labelInstruction = new JLabel();
		_labelInstruction.setText("Inserisci qui sotto il codice della prenotazione che vuoi cercare");
		
		_txtReservationCode = new JTextField();
		_txtReservationCode.setFocusable(true);
		
		_btnReservationRecover = new JButton();
		_btnReservationRecover.setText("Cerca prenotazione");
		
		panelTop = new JPanel();
		panelTop.setLayout(new GridLayout(1, 1, 10, 10));
		panelTop.add(_labelInstruction);
		
		panelMiddle =new JPanel();
		panelMiddle.setLayout(new GridLayout(1, 1, 10, 10));		
		panelMiddle.add(_txtReservationCode);
		
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridLayout(1, 1, 10, 10));
		panelBottom.add(_btnReservationRecover);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 10,10));		
				
		contentPane.add(panelTop);
		contentPane.add(panelMiddle);
		contentPane.add(panelBottom);
		
		//listener al _btnReservationRecover
		_btnReservationRecover.addMouseListener(new MouseAdapter() {
			// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				_codicePrenotazione = _txtReservationCode.getText();
				// Recupero il controllore e invoco il metodo per cercare la prenotazione.
				CModificaPrenotazione gestorePrenotazione = CModificaPrenotazione.getInstance();
				try {
					gestorePrenotazione.recuperaPrenotazioneDaCodice(_codicePrenotazione);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	

}
