package com.iHotel.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class VFrameCreaPrenotazioneStep_1 extends JFrame {

	private JPanel contentPane;
    /* Panel generali del ContentPane */
    private JPanel panelTop, panelBottom;
    private JPanel panelTopLeft;
    private JPanel panelTopRight;
    private JPanel panelBottomLeft;
    private JPanel panelBottomRight;
    private JButton btnAvanti;
    private JButton btnBannnanzi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VFrameCreaPrenotazioneStep_1 frame = new VFrameCreaPrenotazioneStep_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VFrameCreaPrenotazioneStep_1() {
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
					JDatePanel datePanelInizio = JDateComponentFactory.createJDatePanel();
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
					// Label Data di inizio
					JLabel lblTipologie = new JLabel("Tipologie:");
					panelBottomLeft.add(lblTipologie);
					// Spaziatura dinamica
					panelBottomLeft.add(Box.createVerticalGlue());
					// CheckBox - Singola
					JCheckBox checkBoxSingola = new JCheckBox();
					checkBoxSingola.setText("Singola");
					panelBottomLeft.add(checkBoxSingola);
					// Spaziatura dinamica
					panelBottomLeft.add(Box.createVerticalGlue());
					// CheckBox - Doppia
					JCheckBox checkBoxDoppia = new JCheckBox();
					checkBoxDoppia.setText("Doppia");
					panelBottomLeft.add(checkBoxDoppia);
					// Spaziatura dinamica
					panelBottomLeft.add(Box.createVerticalGlue());
					// CheckBox - Tripla
					JCheckBox checkBoxTripla = new JCheckBox();
					checkBoxTripla.setText("Tripla");
					// Spaziatura dinamica
					panelBottomLeft.add(checkBoxTripla);
					panelBottomLeft.add(Box.createVerticalGlue());
			
				// PanelBottomRight
				panelBottomRight = new JPanel();
				panelBottom.add(panelBottomRight);
				// Layout PanelBottomRight
				panelBottomRight.setLayout(new BorderLayout(0, 0));
				
				btnBannnanzi = new JButton("BANNNANZI");
				panelBottomRight.add(btnBannnanzi, BorderLayout.SOUTH);
				
					
				
				
				
				
			
	}

}
