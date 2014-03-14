package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iHotel.controller.CCreaPrenotazione;

@SuppressWarnings("serial")
public class VFrameHome extends JFrame {

	/* Singleton */
	private static VFrameHome instance = null;
	private JPanel contentPane;
	private JButton _btnCreaPrenotazione;

	/**
     * Costruttore privato - pattern Singleton
     */
	private VFrameHome() {}
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		_btnCreaPrenotazione = new JButton();
		_btnCreaPrenotazione.setText("Crea nuova prenotazione");
		contentPane.add(_btnCreaPrenotazione);
		
		// Assegniamo l'eventListener al JButton btnCreaPrenotazione
				_btnCreaPrenotazione.addMouseListener(new MouseAdapter() {
					// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
					@Override
					public void mouseClicked(MouseEvent e) {
						// Recupero il controllore e invoco il metodo per cercare le camere libere.
						CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
						try {
							gestisciPrenotazione.creaNuovaPrenotazione();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
	}

}
