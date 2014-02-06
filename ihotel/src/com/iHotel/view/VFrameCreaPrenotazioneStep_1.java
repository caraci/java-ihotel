package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

public class VFrameCreaPrenotazioneStep_1 extends JFrame {

	private JPanel contentPane;

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
			// Creo Pannello Top
			JPanel panelTop = new JPanel();
			panelTop.setForeground(new Color(0, 0, 0));
			contentPane.add(panelTop);
				// Setto il tipo di Layout al PanelTop
				panelTop.setLayout(new GridLayout(3, 2, 0, 0));
				
				// 1^ Riga - Panel Top
				
				// Label Data di inizio
				JLabel lblDataDiInizio = new JLabel("Data di inizio:");
				panelTop.add(lblDataDiInizio);
				// Contenitore Selettori data inizio
				JPanel panelDataInizio = new JPanel();
				panelTop.setForeground(new Color(20, 0, 0));
				panelTop.add(panelDataInizio);
				// Setto il layour al PanelDataInizio
				panelDataInizio.setLayout(new BoxLayout(panelDataInizio, BoxLayout.X_AXIS));
					
					// Label Giorno inizio
					JLabel lblGiorno = new JLabel("Giorno:");
					panelDataInizio.add(lblGiorno);
					// ComboBox dei giorni iniziali
					JComboBox comboBoxGiornoInizio = new JComboBox();
					panelDataInizio.add(comboBoxGiornoInizio);
					// Label Mese inizio
					JLabel lblMese = new JLabel("Mese:");
					panelDataInizio.add(lblMese);
					// ComboBox del mese di inizio
					JComboBox comboBoxMeseInizio = new JComboBox();
					panelDataInizio.add(comboBoxMeseInizio);
					// Label anno inizio
					JLabel lblAnno = new JLabel("Anno:");
					panelDataInizio.add(lblAnno);
					// ComboBox del mese di inizio
					JComboBox comboBoxAnnoInizio = new JComboBox();
					panelDataInizio.add(comboBoxAnnoInizio);
					
				// 2^ Riga - Panel Top
				
				// Label Data fine
				JLabel lblDataDiFine = new JLabel("Data di fine:");
				panelTop.add(lblDataDiFine);
				// Contenitore Selettori data fine
				JPanel panelDataFine = new JPanel();
				panelTop.setForeground(new Color(20, 0, 0));
				panelTop.add(panelDataFine);		
				panelDataFine.setLayout(new BoxLayout(panelDataFine, BoxLayout.X_AXIS));
			
			// Panello Bottom
			JPanel panelBottom = new JPanel();
			contentPane.add(panelBottom);
	}

}
