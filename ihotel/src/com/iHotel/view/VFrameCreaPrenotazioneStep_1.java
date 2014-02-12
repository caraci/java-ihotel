package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.iHotel.controller.CGestisciPrenotazione;

import net.sourceforge.jdatepicker.*;

public class VFrameCreaPrenotazioneStep_1 extends JFrame {

	/* Singleton */
	private static VFrameCreaPrenotazioneStep_1 instance = null;
	/* ContentPane */
	private JPanel contentPane;
    /* Panel */
    private JPanel panelTop, panelBottom;
    private JPanel panelTopLeft, panelTopRight;
    private JPanel panelBottomLeft, panelBottomRight;
    private JButton btnAvanti;
    /* JDatePanel */
    JDatePanel datePanelFine, datePanelInizio;
    /* CheckBoxes */
    private JCheckBox[] checkBoxesTipologie;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VFrameCreaPrenotazioneStep_1 frame = VFrameCreaPrenotazioneStep_1.getInstance();
					frame.creaFrame(new ArrayList<String>());
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private VFrameCreaPrenotazioneStep_1() {
    	// Private constructor prevents instantiation from other classes
    }
	/**
	 * 
	 * @return CGestisciPrenotazione
	 */
    public static VFrameCreaPrenotazioneStep_1 getInstance() {
    	if(instance == null) {
            instance = new VFrameCreaPrenotazioneStep_1();
         }
         return instance;
    }
	
	/**
	 * Metodo per aggiungere la porzione in alto a sinistra della finestra
	 */
	private void addPanelTopLeft() {
		// PanelTopLeft
		panelTopLeft = new JPanel();
		panelTop.add(panelTopLeft);
		panelTopLeft.setLayout(new BoxLayout(panelTopLeft, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		JLabel lblDataDiInizio = new JLabel("Data di inizio:");
		panelTopLeft.add(lblDataDiInizio);
		// Spaziatore 
		panelTopLeft.add(Box.createVerticalGlue());
		// JDatePanel data inizio
		datePanelInizio = JDateComponentFactory.createJDatePanel();
		panelTopLeft.add((Component) datePanelInizio);
	}
	/**
	 * Metodo per aggiungere la porzione in alto a destra della finestra
	 */
	private void addPanelTopRight() {
		// PanelTopRight
		panelTopRight = new JPanel();
		panelTop.add(panelTopRight);
		panelTopRight.setLayout(new BoxLayout(panelTopRight, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		JLabel lblDataDiFine = new JLabel("Data di fine:");
		panelTopRight.add(lblDataDiFine);
		// Spaziatore 
		panelTopRight.add(Box.createVerticalGlue());
		// JDatePanel data inizio
		datePanelFine = JDateComponentFactory.createJDatePanel();
		panelTopRight.add((Component) datePanelFine);
	}
	
	private void addPanelBottomLeft(ArrayList<String> tipologieCamere) {
		// PanelBottomLeft
		panelBottomLeft = new JPanel();
		panelBottom.add(panelBottomLeft);
		// Layout PanelBottomLeft
		panelBottomLeft.setLayout(new BoxLayout(panelBottomLeft, BoxLayout.PAGE_AXIS));
		// Label Tipologie
		JLabel lblTipologie = new JLabel("Tipologie:");
		panelBottomLeft.add(lblTipologie);
		// Spaziatura dinamica
		panelBottomLeft.add(Box.createVerticalGlue());
		
		// Creo i checkBoxes e li aggiungo al panelBottomLeft
		int numero_tipologie = tipologieCamere.size();
		checkBoxesTipologie = new JCheckBox[numero_tipologie];
		for (int i = 0; i < tipologieCamere.size(); i++) {
			String tipologia = tipologieCamere.get(i);
			checkBoxesTipologie[i] = new JCheckBox();
			checkBoxesTipologie[i].setText(tipologia);
			panelBottomLeft.add(checkBoxesTipologie[i]);
			// Spaziatura dinamica
			panelBottomLeft.add(Box.createVerticalGlue());
		}
	}
	private void addPanelBottomRight() {
		// PanelBottomRight
		panelBottomRight = new JPanel();
		panelBottom.add(panelBottomRight);
		// Layout PanelBottomRight
		panelBottomRight.setLayout(new BorderLayout(0, 0));
		
		btnAvanti = new JButton("Avanti");
		panelBottomRight.add(btnAvanti, BorderLayout.SOUTH);
	}
	/**
	 * Metodo per creare il frame
	 */
	public void creaFrame(ArrayList<String> tipologieCamere) {
		setTitle("iHotel - Crea nuova prenotazione - Step 1 di 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(50, 50, 1024, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
			
		// PanelTop
		panelTop = new JPanel();
		panelTop.setForeground(new Color(0, 0, 0));
		contentPane.add(panelTop);
		panelTop.setLayout(new GridLayout(1, 2, 20, 20));
				
		// PanelTopLeft
		addPanelTopLeft();
		// PanelTopRight
		addPanelTopRight();
				
		// PanelBottom
		panelBottom = new JPanel();
		contentPane.add(panelBottom);
		panelBottom.setLayout(new GridLayout(1, 2, 20, 20));
				
		// PanelBottomLeft
		addPanelBottomLeft(tipologieCamere);		
		// PanelBottomRigth
		addPanelBottomRight();
				
		/* ---------------------- Eventi ------------------------------------- */

		// Assegniamo l'eventListener al JButton btnAvanti
		btnAvanti.addMouseListener(new MouseAdapter() {
			// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> tipologieSelezionate = new ArrayList<String>();
				boolean tipologiaStato;
				// Controllo lo stato di tutte le CheckBox per verificare le tipologie inserite dall'utente
				for (int i = 0; i < checkBoxesTipologie.length; i++) {
					tipologiaStato=checkBoxesTipologie[i].isSelected();
					if (tipologiaStato) {
						// Aggiungo le tipologie scelte dall'utente
						tipologieSelezionate.add(checkBoxesTipologie[i].getText());
					}	
				}
				// Data inizio
				int annoInizio 	 = datePanelInizio.getModel().getYear();
				int meseInizio 	 = datePanelInizio.getModel().getMonth();
				int giornoInizio = datePanelInizio.getModel().getDay();
				// Data fine
				int annoFine 	 = datePanelFine.getModel().getYear();
				int meseFine 	 = datePanelFine.getModel().getMonth();
				int giornoFine 	 = datePanelFine.getModel().getDay();
				
				// Data inizio
				GregorianCalendar dataInizio = new GregorianCalendar();
				dataInizio.set(annoInizio, meseInizio, giornoInizio);
				// Data fine
				GregorianCalendar dataFine = new GregorianCalendar();
				dataFine.set(annoFine, meseFine, giornoFine);
				// Decremento di uno perchè nella logica si ragiona per notti. Mentre l'utilizzatore indica il giorno di arrivo e 
				// il giorno di partenza.
				dataFine.add(Calendar.DATE, -1);
				
				// Recupero il controllore e invoco il metodo.
				CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
				gestisciPrenotazione.cercaCamereLibere(dataInizio, dataFine, tipologieSelezionate);
			}
		});
	}
}
