package com.iHotel.view.CreaPrenotazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.model.Utility.MyDate;
import com.iHotel.view.View;

import net.sourceforge.jdatepicker.*;

@SuppressWarnings("serial")
public class VFCP_SelezionePeriodoTipologie extends View {

	/* Singleton */
	private static VFCP_SelezionePeriodoTipologie instance = null;
	/* ContentPane */
	private JPanel _contentPane;
    /* Panel */
    private JPanel _panelTop, _panelBottom;
    private JPanel _panelTopLeft, _panelTopRight;
    private JPanel _panelBottomLeft, _panelBottomRight;
    private JButton _btnAvanti;
    /* JDatePanel */
    private JDatePanel _datePanelFine, _datePanelInizio;
    /* CheckBoxes */
    private JCheckBox[] _checkBoxesTipologie;
    
	
    /**
     * Costruttore privato - pattern Singleton
     */
	private VFCP_SelezionePeriodoTipologie() {
		super();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameCreaPrenotazioneStep_1 Instanza unica di questa classe.
	 */
    public static VFCP_SelezionePeriodoTipologie getInstance() {
    	if(instance == null) {
            instance = new VFCP_SelezionePeriodoTipologie();
         }
         return instance;
    }
	
	/**
	 * Metodo per aggiungere la porzione in alto a sinistra della finestra.
	 */
	private void addPanelTopLeft() {
		// PanelTopLeft
		_panelTopLeft = _creaPrenotazioneFactory.getPanel();
		_panelTop.add(_panelTopLeft);
		_panelTopLeft.setLayout(new BoxLayout(_panelTopLeft, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		JLabel lblDataDiInizio = new JLabel("Data di inizio:");
		_panelTopLeft.add(lblDataDiInizio);
		// Spaziatore 
		_panelTopLeft.add(Box.createVerticalGlue());
		// JDatePanel data inizio
		_datePanelInizio = JDateComponentFactory.createJDatePanel();
		_panelTopLeft.add((Component) _datePanelInizio);
	}
	/**
	 * Metodo per aggiungere la porzione in alto a destra della finestra.
	 */
	private void addPanelTopRight() {
		// PanelTopRight
		_panelTopRight = _creaPrenotazioneFactory.getPanel();
		_panelTop.add(_panelTopRight);
		_panelTopRight.setLayout(new BoxLayout(_panelTopRight, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		JLabel lblDataDiFine = new JLabel("Data di fine:");
		_panelTopRight.add(lblDataDiFine);
		// Spaziatore 
		_panelTopRight.add(Box.createVerticalGlue());
		// JDatePanel data inizio
		_datePanelFine = JDateComponentFactory.createJDatePanel();
		_panelTopRight.add((Component) _datePanelFine);
	}
	/**
	 * Metodo per aggiungere la porzione in basso a sinistra della finestra, con le tipologie di camere che è possibile scegliere.
	 * @param tipologieCamere Tipologie di camere presenti nell'albergo.
	 */
	private void addPanelBottomLeft(ArrayList<String> tipologieCamere) {
		// PanelBottomLeft
		_panelBottomLeft = _creaPrenotazioneFactory.getPanel();
		_panelBottom.add(_panelBottomLeft);
		// Layout PanelBottomLeft
		_panelBottomLeft.setLayout(new BoxLayout(_panelBottomLeft, BoxLayout.PAGE_AXIS));
		// Label Tipologie
		JLabel lblTipologie = new JLabel("Tipologie:");
		_panelBottomLeft.add(lblTipologie);
		// Spaziatura dinamica
		_panelBottomLeft.add(Box.createVerticalGlue());
		
		// Creo i checkBoxes e li aggiungo al panelBottomLeft
		int numero_tipologie = tipologieCamere.size();
		_checkBoxesTipologie = new JCheckBox[numero_tipologie];
		for (int i = 0; i < tipologieCamere.size(); i++) {
			String tipologia = tipologieCamere.get(i);
			_checkBoxesTipologie[i] = new JCheckBox();
			_checkBoxesTipologie[i].setText(tipologia);
			_panelBottomLeft.add(_checkBoxesTipologie[i]);
			// Spaziatura dinamica
			_panelBottomLeft.add(Box.createVerticalGlue());
		}
	}
	/**
	 * Metodo per aggiungere la porzione di finestra in basso a destra.
	 */
	private void addPanelBottomRight() {
		// PanelBottomRight
		_panelBottomRight = _creaPrenotazioneFactory.getPanel();
		_panelBottom.add(_panelBottomRight);
		// Layout PanelBottomRight
		_panelBottomRight.setLayout(new BorderLayout(0, 0));
		
		_btnAvanti = new JButton("Avanti");
		_panelBottomRight.add(_btnAvanti, BorderLayout.SOUTH);
	}
	/**
	 * Metodo per creare il frame.
	 */
	public void creaFrame(ArrayList<String> tipologieCamere) {
		setTitle("iHotel - Crea nuova prenotazione - Step 1 di 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(50, 50, 1024, 500);
		_contentPane = new JPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_contentPane);
		_contentPane.setLayout(new GridLayout(2, 1, 10, 10));
			
		// PanelTop
		_panelTop = new JPanel();
		_panelTop.setForeground(new Color(0, 0, 0));
		_contentPane.add(_panelTop);
		_panelTop.setLayout(new GridLayout(1, 2, 20, 20));
				
		// PanelTopLeft
		addPanelTopLeft();
		// PanelTopRight
		addPanelTopRight();
				
		// PanelBottom
		_panelBottom = new JPanel();
		_contentPane.add(_panelBottom);
		_panelBottom.setLayout(new GridLayout(1, 2, 20, 20));
				
		// PanelBottomLeft
		addPanelBottomLeft(tipologieCamere);		
		// PanelBottomRigth
		addPanelBottomRight();
				
		/* ---------------------- Eventi ------------------------------------- */
	
		// Assegniamo l'eventListener al JButton btnAvanti
		_btnAvanti.addMouseListener(new MouseAdapter() {
			// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> tipologieSelezionate = new ArrayList<String>();
				boolean tipologiaStato;
				// Controllo lo stato di tutte le CheckBox per verificare le tipologie inserite dall'utente
				for (int i = 0; i < get_checkBoxesTipologie().length; i++) {
					tipologiaStato=get_checkBoxesTipologie()[i].isSelected();
					if (tipologiaStato) {
						// Aggiungo le tipologie scelte dall'utente
						tipologieSelezionate.add(get_checkBoxesTipologie()[i].getText());
					}	
				}
				// Data inizio
				int annoInizio 	 = get_datePanelInizio().getModel().getYear();
				int meseInizio 	 = get_datePanelInizio().getModel().getMonth();
				int giornoInizio = get_datePanelInizio().getModel().getDay();
				// Data fine
				int annoFine 	 = get_datePanelFine().getModel().getYear();
				int meseFine 	 = get_datePanelFine().getModel().getMonth();
				int giornoFine 	 = get_datePanelFine().getModel().getDay();
				
				// Data inizio
				MyDate dataInizio = new MyDate();
				dataInizio.set(annoInizio, meseInizio, giornoInizio);
				// Data fine
				MyDate dataFine = new MyDate();
				dataFine.set(annoFine, meseFine, giornoFine);		
				// Recupero il controllore e invoco il metodo per cercare le camere libere.
				CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
				gestisciPrenotazione.cercaCamereLibere(dataInizio, dataFine, tipologieSelezionate);
			}
		});
	}
	/* ------------------------- Getter, Setter ------------------------------------- */
	/**
	 * @return the _datePanelFine
	 */
	public JDatePanel get_datePanelFine() {
		return _datePanelFine;
	}
	/**
	 * @param _datePanelFine the _datePanelFine to set
	 */
	public void set_datePanelFine(JDatePanel _datePanelFine) {
		this._datePanelFine = _datePanelFine;
	}
	/**
	 * @return the _datePanelInizio
	 */
	public JDatePanel get_datePanelInizio() {
		return _datePanelInizio;
	}
	/**
	 * @param _datePanelInizio the _datePanelInizio to set
	 */
	public void set_datePanelInizio(JDatePanel _datePanelInizio) {
		this._datePanelInizio = _datePanelInizio;
	}
	/**
	 * @return the _checkBoxesTipologie
	 */
	public JCheckBox[] get_checkBoxesTipologie() {
		return _checkBoxesTipologie;
	}
	/**
	 * @param _checkBoxesTipologie the _checkBoxesTipologie to set
	 */
	public void set_checkBoxesTipologie(JCheckBox[] _checkBoxesTipologie) {
		this._checkBoxesTipologie = _checkBoxesTipologie;
	}
	
}
