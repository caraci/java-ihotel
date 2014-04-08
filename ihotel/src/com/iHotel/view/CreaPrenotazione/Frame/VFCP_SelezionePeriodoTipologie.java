package com.iHotel.view.CreaPrenotazione.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.View;
import com.iHotel.view.CreaPrenotazione.Event.RicercaCamereLibereListener;

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
    private ArrayList<JCheckBox> _checkBoxesTipologie = new ArrayList<JCheckBox>();
    
	
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
		_panelTopLeft = _viewFactory.getPanel();
		_panelTop.add(_panelTopLeft);
		_panelTopLeft.setLayout(new BoxLayout(_panelTopLeft, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		JLabel lblDataDiInizio = _viewFactory.getLabel();
		lblDataDiInizio.setText("Data di inizio:");
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
		_panelTopRight = _viewFactory.getPanel();
		_panelTop.add(_panelTopRight);
		_panelTopRight.setLayout(new BoxLayout(_panelTopRight, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		JLabel lblDataDiFine = _viewFactory.getLabel();
		lblDataDiFine.setText("Data di fine:");
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
		_panelBottomLeft = _viewFactory.getPanel();
		_panelBottom.add(_panelBottomLeft);
		// Layout PanelBottomLeft
		_panelBottomLeft.setLayout(new BoxLayout(_panelBottomLeft, BoxLayout.PAGE_AXIS));
		// Label Tipologie
		JLabel lblTipologie = _viewFactory.getLabel();
		lblTipologie.setText("Tipologie:");
		_panelBottomLeft.add(lblTipologie);
		// Spaziatura dinamica
		_panelBottomLeft.add(Box.createVerticalGlue());
		// Creo i checkBoxes e li aggiungo al panelBottomLeft
		int numero_tipologie = tipologieCamere.size();
		
		
		for (int i = 0; i<numero_tipologie;i++){
			_checkBoxesTipologie.add(_viewFactory.getCheckBox());
			String tipologia = tipologieCamere.get(i);
			_checkBoxesTipologie.get(i).setText(tipologia);
			_panelBottomLeft.add(_checkBoxesTipologie.get(i));
			_panelBottomLeft.add(Box.createVerticalGlue());				
		}			
		
	}
	/**
	 * Metodo per aggiungere la porzione di finestra in basso a destra.
	 */
	private void addPanelBottomRight() {
		// PanelBottomRight
		_panelBottomRight = _viewFactory.getPanel();
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
	
		// Assegniamo l'eventListener al JButton btnAvanti
		_btnAvanti.addMouseListener(new RicercaCamereLibereListener());
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
	public ArrayList<JCheckBox> get_checkBoxesTipologie() {
		return _checkBoxesTipologie;
	}
	/**
	 * @param _checkBoxesTipologie the _checkBoxesTipologie to set
	 */
	public void set_checkBoxesTipologie(ArrayList<JCheckBox> _checkBoxesTipologie) {
		this._checkBoxesTipologie = _checkBoxesTipologie;
	}
	
}
