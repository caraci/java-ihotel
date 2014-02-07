package com.iHotel.view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.iHotel.controller.CGestisciPrenotazione;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class VFrameCreaPrenotazioneStep_1 extends JFrame {

	private JPanel contentPane;
    /* Panel */
    private JPanel panelTop, panelBottom;
    private JPanel panelTopLeft, panelTopRight;
    private JPanel panelBottomLeft, panelBottomRight;
    private JButton btnAvanti;
    /* Variabili */
    private ArrayList<String> tipologie;
    private boolean singola_stato = false;
    private boolean doppia_stato = false;
    private boolean tripla_stato = false; 
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VFrameCreaPrenotazioneStep_1 frame = new VFrameCreaPrenotazioneStep_1(tipologie);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VFrameCreaPrenotazioneStep_1(Set<String> tipologie_camere) {
		setTitle("iHotel - Crea nuova prenotazione");
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
					panelTopLeft = new JPanel();
					panelTop.add(panelTopLeft);
					panelTopLeft.setLayout(new BoxLayout(panelTopLeft, BoxLayout.PAGE_AXIS));
					// Label Data di inizio
					JLabel lblDataDiInizio = new JLabel("Data di inizio:");
					panelTopLeft.add(lblDataDiInizio);
					// Spaziatore 
					panelTopLeft.add(Box.createVerticalGlue());
					// JDatePanel data inizio
					final JDatePanel datePanelInizio = JDateComponentFactory.createJDatePanel();
					panelTopLeft.add((Component) datePanelInizio);
				
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
					JDatePanel dataPanelFine = JDateComponentFactory.createJDatePanel();
					panelTopRight.add((Component) dataPanelFine);
					
				
			// PanelBottom
			panelBottom = new JPanel();
			contentPane.add(panelBottom);
			panelBottom.setLayout(new GridLayout(1, 2, 20, 20));
				
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
					
					for (Iterator<String> iterator = tipologie_camere.iterator(); iterator.hasNext();) {
						String string = (String) iterator.next();
						
					}
					// CheckBox - Singola
					final JCheckBox checkBoxSingola = new JCheckBox();
					checkBoxSingola.setText("Singola");
					panelBottomLeft.add(checkBoxSingola);
					// Spaziatura dinamica
					panelBottomLeft.add(Box.createVerticalGlue());
					// CheckBox - Doppia
					final JCheckBox checkBoxDoppia = new JCheckBox();
					checkBoxDoppia.setText("Doppia");
					panelBottomLeft.add(checkBoxDoppia);
					// Spaziatura dinamica
					panelBottomLeft.add(Box.createVerticalGlue());
					// CheckBox - Tripla
					final JCheckBox checkBoxTripla = new JCheckBox();
					checkBoxTripla.setText("Tripla");
					// Spaziatura dinamica
					panelBottomLeft.add(checkBoxTripla);
					panelBottomLeft.add(Box.createVerticalGlue());
			
				// PanelBottomRight
				panelBottomRight = new JPanel();
				panelBottom.add(panelBottomRight);
				// Layout PanelBottomRight
				panelBottomRight.setLayout(new BorderLayout(0, 0));
				
				btnAvanti = new JButton("Avanti");
				panelBottomRight.add(btnAvanti, BorderLayout.SOUTH);
				
				// Eventi

				// Click sul checkBoxSingola
				checkBoxSingola.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						singola_stato = checkBoxSingola.isSelected();
						if (singola_stato) {
							JOptionPane.showMessageDialog(null, "selezionata");
						} else {
							JOptionPane.showMessageDialog(null, "non selezionata");
						}
					}
				});
				// Click sul checkBoxDoppia
				checkBoxDoppia.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						doppia_stato = checkBoxDoppia.isSelected();
						if (doppia_stato) {
							JOptionPane.showMessageDialog(null, "selezionata");
						} else {
							JOptionPane.showMessageDialog(null, "non selezionata");
						}
					}
				});
				// Click sul checkBoxTripla
				checkBoxTripla.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						doppia_stato = checkBoxTripla.isSelected();
						if (doppia_stato) {
							JOptionPane.showMessageDialog(null, "selezionata");
						} else {
							JOptionPane.showMessageDialog(null, "non selezionata");
						}
					}
				});
				// Click sul bottoneAvanti
				btnAvanti.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (singola_stato == true) {
							tipologie.add("Singola");
						}
						if (doppia_stato == true) {
							tipologie.add("Doppia");
						}
						if (tripla_stato == true) {
							tipologie.add("Tripla");
						}
						int anno_inizio = datePanelInizio.getModel().getYear();
						int mese_inizio = datePanelInizio.getModel().getMonth();
						int giorno_inizio = datePanelInizio.getModel().getDay();
					
						
						JOptionPane.showMessageDialog(null, anno_inizio + " " + mese_inizio + " " + giorno_inizio);
						
						//CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
						//gestisciPrenotazione.cercaCamereLibere(12312312312L, 12312312312L, tipologie);
					}
				});
				
				
			
	}

}
