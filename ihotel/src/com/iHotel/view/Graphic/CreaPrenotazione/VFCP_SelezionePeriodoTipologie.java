package com.iHotel.view.Graphic.CreaPrenotazione;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import com.iHotel.view.ViewFrame;
import com.iHotel.view.Event.CreaPrenotazione.RicercaCamereLibereListener;

import net.sourceforge.jdatepicker.*;

/**
 * Classe addetta alla realizzazione della finestra per effettuare una nuova prenotazione. In particolare
 * con questa finestra si vanno ad indicare il periodo di richiesta e le tipologie a cui si è interessati.
 * 
 * @author Eugenio
 */
@SuppressWarnings("serial")
public class VFCP_SelezionePeriodoTipologie extends ViewFrame {

	/**
	 * Tipologie di camere presenti nell'albergo.
	 */
	private ArrayList<String> _tipologieCamere; 
    /* Panel */
    private JPanel _panelTopLeft, _panelTopRight;
    private JPanel _panelBottomLeft;
    /* JButton */
    private JButton _btnAvanti;
    /* JDatePanel */
    private JDatePanel _datePanelFine, _datePanelInizio;
    /* JLabel */
    private JLabel _lblTitolo, _lblTipologie, _lblDataDiInizio, _lblDataDiFine;
    /* CheckBoxes */
    private ArrayList<JCheckBox> _checkBoxesTipologie;
    
    /* Singleton */
	private static VFCP_SelezionePeriodoTipologie instance = null;
	
    /**
     * Costruttore privato - pattern Singleton
     */
	private VFCP_SelezionePeriodoTipologie() {
		super();
		// JPanel
		_panelTopLeft = _viewFactory.getPanel();
		_panelTopRight = _viewFactory.getPanel();
		_panelBottomLeft = _viewFactory.getPanel();
		// JLabel
		_lblDataDiInizio = _viewFactory.getLabelIntestazione_2();
		_lblDataDiFine = _viewFactory.getLabelIntestazione_2();
		_lblTipologie = _viewFactory.getLabelIntestazione_2();
		_lblTitolo=_viewFactory.getLabelIntestazione_1();
		// JButton
		_btnAvanti=_viewFactory.getButtonAvanti();
		// CheckBox
		_checkBoxesTipologie = new ArrayList<JCheckBox>();
	}
	/* ----------------------------- Metodi di classe ---------------------------- */ 
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
    public static VFCP_SelezionePeriodoTipologie getInstance() {
    	if(instance == null) {
            instance = new VFCP_SelezionePeriodoTipologie();
         }
         return instance;
    }
    /* ------------------------- Metodi di instanza ------------------------------- */
    @Override
    public void removeInstance() {
    	instance = null;
	}
    @Override
    protected void creaPanelTop() {
    	// Layout PanelTop
    	_panelTop.setLayout(new BorderLayout(0, 0));
		/*Testo della label*/
		_lblTitolo.setText("Scegli il periodo e le tipologie di camere.");
		/*Aggiungo la label al centro*/
		_panelTop.add(_lblTitolo, BorderLayout.CENTER);
    }
    @Override
    protected void creaPanelMiddle() {
    	// Setto il layout al panelMiddle
    	_panelMiddle.setLayout(new GridLayout(2, 1, 10, 10));
    	// Aggiungo i panel al panelMiddle
    	_panelMiddle.add(creaPanelMiddleTopLeft());
    	_panelMiddle.add(creaPanelMiddleTopRight());
    	_panelMiddle.add(creaPanelMiddleBottomLeft());
    }

	/**
	 * Metodo per aggiungere la porzione centrale, in alto a sinistra.
	 * 
	 * @return Pannello centrale in alto a sinistra.
	 */
	private JPanel creaPanelMiddleTopLeft() {
		// PanelTopLeft
		_panelTopLeft.setLayout(new BoxLayout(_panelTopLeft, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		_lblDataDiInizio.setText("Data di inizio:");
		_panelTopLeft.add(_lblDataDiInizio);
		// Spaziatore 
		_panelTopLeft.add(Box.createVerticalGlue());
		// JDatePanel data inizio
		_datePanelInizio = JDateComponentFactory.createJDatePanel();
		_panelTopLeft.add((Component) _datePanelInizio);
		
		return _panelTopLeft;
	}
	/**
	 * Metodo per aggiungere la porzione centrale, in alto a destra.
	 * 
	 * @return Pannelo centrale in alto a destra.
	 */
	private JPanel creaPanelMiddleTopRight() {
		// PanelTopRight
		_panelTopRight.setLayout(new BoxLayout(_panelTopRight, BoxLayout.PAGE_AXIS));
		// Label Data di inizio
		_lblDataDiFine.setText("Data di fine:");
		_panelTopRight.add(_lblDataDiFine);
		// Spaziatore 
		_panelTopRight.add(Box.createVerticalGlue());
		// JDatePanel data inizio
		_datePanelFine = JDateComponentFactory.createJDatePanel();
		_panelTopRight.add((Component) _datePanelFine);
		
		return _panelTopRight;
	}
	/**
	 * Metodo per aggiungere la porzione in basso a sinistra della finestra.
	 * 
	 * @return Pannello centrale in basso a sinistra.
	 */
	private JPanel creaPanelMiddleBottomLeft() {
		// Layout PanelBottomLeft
		_panelBottomLeft.setLayout(new BoxLayout(_panelBottomLeft, BoxLayout.PAGE_AXIS));
		// Label Tipologie
		_lblTipologie.setText("Tipologie:");
		_panelBottomLeft.add(_lblTipologie);
		// Spaziatura dinamica
		_panelBottomLeft.add(Box.createVerticalGlue());
		// Prendo il numero di tipologie di camere.
		int numero_tipologie = _tipologieCamere.size();	
		// Ciclo sulle tipologie per aggiungere le checkbox.
		for (int i = 0; i<numero_tipologie;i++){
			_checkBoxesTipologie.add(_viewFactory.getCheckBox());
			String tipologia = _tipologieCamere.get(i);
			_checkBoxesTipologie.get(i).setText(tipologia);
			_panelBottomLeft.add(_checkBoxesTipologie.get(i));
			_panelBottomLeft.add(Box.createVerticalGlue());				
		}			
		
		return _panelBottomLeft;
	}
	@Override
	protected void creaPanelBottom() {
		// Testo JButton avanti.
		_btnAvanti.setText("Avanti");
		// Assegniamo l'eventListener al JButton btnAvanti
		_btnAvanti.addMouseListener(new RicercaCamereLibereListener());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(5,_btnAvanti);
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
	}
	/**
	 * Metodo per creare il frame.
	 */
	public void creaFrame(ArrayList<String> tipologieCamere) {
		setTitle("iHotel - Crea nuova prenotazione - Step 1 di 2");
		// Setto l'attributo contenente le tipologie di camere
		_tipologieCamere=tipologieCamere;

		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();

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
