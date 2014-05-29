 package com.iHotel.view.Graphic;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.Storico;
import com.iHotel.view.ViewPanelContentPane;
import com.iHotel.view.Event.CaricaCreaNuovaPrenotazioneListener;
import com.iHotel.view.Event.CaricaGestionePrenotazioneListener;

/**
 * Classe addetta alla realizzazione della finestra iniziale dell'applicazione.
 * 
 * @author Eugenio
 */
@SuppressWarnings("serial")
public class VP_Home extends ViewPanelContentPane {
	
	/* ---------------------- Attributi, Costruttore --------------------- */
	
	private Storico _storico;
	/*JButton*/
	private JButton _btnCreaPrenotazione,_btnModificaPrenotazione;
	/*JLabel*/
	private JLabel _lblInstructions;
	/*JPanel*/
	private JPanel _pnlMiddleTop, _pnlMiddleBottom;
	
	/**
     * Costruttore privato - pattern Singleton
     */
	public VP_Home() {
		super();
		/*Button*/
		_btnCreaPrenotazione = _viewFactory.getButton();
		_btnModificaPrenotazione = _viewFactory.getButton();
		/*Label*/
		_lblInstructions= _viewFactory.getLabelIntestazione_1();
		/*JPanel*/
		_pnlMiddleTop=_viewFactory.getPanel(false);
		_pnlMiddleBottom=_viewFactory.getPanel(false);
	}
	
	/* --------------------- Metodi di istanza ---------------------- */
	
    @Override
    protected void creaPanelTop(){
    	_lblInstructions.setText("Scegli l'operazione che vuoi fare.");
    	_panelTop.add(_lblInstructions);
    }
    @Override
    protected void creaPanelMiddle(){
    	/*Setto il layout*/
    	_panelMiddle.setLayout(new GridLayout(2, 1, 0, 10));
		/*Aggiungo PanelMiddleTop */
    	_panelMiddle.add(creaPanelMiddleTop());
    	/* Aggiungo PanelMiddleBottom */
    	_panelMiddle.add(creaPanelMiddleBottom());

    }
    /**
     * Metodo per creare il pannello relativo alla parte centrale superiore della finestra.
     * 
     * @return
     */
    public JPanel creaPanelMiddleTop() {
    	// Setto layout
    	_pnlMiddleTop.setLayout(new GridLayout(2,1,0,5));
    	/*Setto il testo dei pulsanti*/
    	_btnCreaPrenotazione.setText("Crea nuova prenotazione");   	   	
		_btnModificaPrenotazione.setText("Gestisci prenotazione");	
		// Assegniamo l'eventListener al JButton btnCreaPrenotazione
		_btnCreaPrenotazione.addMouseListener(new CaricaCreaNuovaPrenotazioneListener()); 
		// Assegniamo l'eventListener al JButton btnModificaPrenotazione
		_btnModificaPrenotazione.addMouseListener(new CaricaGestionePrenotazioneListener());
		/*Aggiungo i pulsanti al pannello*/
		_pnlMiddleTop.add(_btnCreaPrenotazione);
		_pnlMiddleTop.add(_btnModificaPrenotazione);
		
    	return _pnlMiddleTop;
    }
    /**
     * Metodo per creare il pannello relativo alla parte centrale inferiore della finestra.
     * @return
     */
    public JPanel creaPanelMiddleBottom() {
    	
    	return _pnlMiddleBottom;
    }
    @Override
	public void creaPanelBottom() {
		// TODO Auto-generated method stub	
	}
	/**
	 * Create the Panel.
	 */
	public void creaPanel() {	
		// Setto lo storico come attributo del pannello.
		_storico=Storico.getInstance();
		// Creo il pannello.
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
	}
	/* ------------------------ Getter, Setter -------------------------------- */
	/**
	 * @return the _btnCreaPrenotazione
	 */
	public JButton get_btnCreaPrenotazione() {
		return _btnCreaPrenotazione;
	}
	/**
	 * @param _btnCreaPrenotazione the _btnCreaPrenotazione to set
	 */
	public void set_btnCreaPrenotazione(JButton _btnCreaPrenotazione) {
		this._btnCreaPrenotazione = _btnCreaPrenotazione;
	}
	/**
	 * @return the _btnModificaPrenotazione
	 */
	public JButton get_btnModificaPrenotazione() {
		return _btnModificaPrenotazione;
	}
	/**
	 * @param _btnModificaPrenotazione the _btnModificaPrenotazione to set
	 */
	public void set_btnModificaPrenotazione(JButton _btnModificaPrenotazione) {
		this._btnModificaPrenotazione = _btnModificaPrenotazione;
	}
}
