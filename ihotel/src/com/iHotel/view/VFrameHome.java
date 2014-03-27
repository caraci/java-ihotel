package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.JDateComponentFactory;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.controller.CModificaPrenotazione;

@SuppressWarnings("serial")
public class VFrameHome extends View {

	/* Singleton */
	private static VFrameHome instance = null;
	private JPanel contentPane;
	private JPanel panelTop, panelBottom;
	private JButton _btnCreaPrenotazione;
	private JButton _btnModificaPrenotazione;

	/**
     * Costruttore privato - pattern Singleton
     */
	private VFrameHome() {
		super();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameHome Instanza unica di questa classe.
	 */
    public static VFrameHome getInstance() {
    	if(instance == null) {
            instance = new VFrameHome();
         }
         return instance;
    }
	/**
	 * Create the frame.
	 */
	public void creaFrame() {
		setTitle("iHotel - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		
		
		panelTop = new JPanel();
		panelTop.setLayout(new GridLayout(1, 1, 20, 20));
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridLayout(1, 1, 20, 20));
		
		_btnCreaPrenotazione = new JButton();
		_btnCreaPrenotazione.setText("Crea nuova prenotazione");
		
		_btnModificaPrenotazione = new JButton();
		_btnModificaPrenotazione.setText("Gestisci prenotazione");

		panelTop.add(_btnCreaPrenotazione);		
		panelBottom.add(_btnModificaPrenotazione);
		contentPane.add(panelTop);
		contentPane.add(panelBottom);
		
		
		
		// Assegniamo l'eventListener al JButton btnCreaPrenotazione
		_btnCreaPrenotazione.addMouseListener(new MouseAdapter() {
			// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
			@Override
			public void mouseClicked(MouseEvent e) {
				// Recupero il controllore e invoco il metodo per cercare le camere libere.
				CCreaPrenotazione creatorePrenotazione = CCreaPrenotazione.getInstance();
				try {
					creatorePrenotazione.creaNuovaPrenotazione();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// Assegniamo l'eventListener al JButton btnModificaPrenotazione
		_btnModificaPrenotazione.addMouseListener(new MouseAdapter() {
			// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
			@Override
			public void mouseClicked(MouseEvent e) {
				// Recupero il controllore e invoco il metodo per cercare le camere libere.
				CModificaPrenotazione gestorePrenotazione = CModificaPrenotazione.getInstance();
				try {
					gestorePrenotazione.gestionePrenotazione();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	

}
