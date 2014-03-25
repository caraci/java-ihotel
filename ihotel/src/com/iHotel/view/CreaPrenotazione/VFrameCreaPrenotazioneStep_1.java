package com.iHotel.view.CreaPrenotazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.view.View;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

import net.sourceforge.jdatepicker.*;

@SuppressWarnings("serial")
public class VFrameCreaPrenotazioneStep_1 extends View {

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
    private JDatePanel datePanelFine, datePanelInizio;
    /* CheckBoxes */
    private JCheckBox[] checkBoxesTipologie;
    
	
    /**
     * Costruttore privato - pattern Singleton
     */
	private VFrameCreaPrenotazioneStep_1() {
		super();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameCreaPrenotazioneStep_1 Instanza unica di questa classe.
	 */
    public static VFrameCreaPrenotazioneStep_1 getInstance() {
    	if(instance == null) {
            instance = new VFrameCreaPrenotazioneStep_1();
         }
         return instance;
    }
	
	/**
	 * Metodo per aggiungere la porzione in alto a sinistra della finestra.
	 */
	private void addPanelTopLeft() {
		// PanelTopLeft
		panelTopLeft = _creaPrenotazioneFactory.getPanel();
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
	 * Metodo per aggiungere la porzione in alto a destra della finestra.
	 */
	private void addPanelTopRight() {
		// PanelTopRight
		panelTopRight = _creaPrenotazioneFactory.getPanel();
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
	/**
	 * Metodo per aggiungere la porzione in basso a sinistra della finestra, con le tipologie di camere che � possibile scegliere.
	 * @param tipologieCamere Tipologie di camere presenti nell'albergo.
	 */
	private void addPanelBottomLeft(ArrayList<String> tipologieCamere) {
		// PanelBottomLeft
		panelBottomLeft = _creaPrenotazioneFactory.getPanel();
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
	/**
	 * Metodo per aggiungere la porzione di finestra in basso a destra.
	 */
	private void addPanelBottomRight() {
		// PanelBottomRight
		panelBottomRight = _creaPrenotazioneFactory.getPanel();
		panelBottom.add(panelBottomRight);
		// Layout PanelBottomRight
		panelBottomRight.setLayout(new BorderLayout(0, 0));
		
		btnAvanti = new JButton("Avanti");
		panelBottomRight.add(btnAvanti, BorderLayout.SOUTH);
	}
	/**
	 * Metodo per creare il frame.
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
				// Recupero il controllore e invoco il metodo per cercare le camere libere.
				CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
				gestisciPrenotazione.cercaCamereLibere(dataInizio, dataFine, tipologieSelezionate);
			}
		});
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO - implement VFrameCreaPrenotazioneStep_1.main
		throw new UnsupportedOperationException();
	}
}
