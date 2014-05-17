 package com.iHotel.view.Graphic;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.view.ViewFrame;
import com.iHotel.view.Event.CaricaCreaNuovaPrenotazioneListener;
import com.iHotel.view.Event.CaricaGestionePrenotazioneListener;

/**
 * Classe addetta alla realizzazione della finestra iniziale dell'applicazione.
 * 
 * @author Eugenio
 */
@SuppressWarnings("serial")
public class VFrameHome extends ViewFrame {
	
	/*JButton*/
	private JButton _btnCreaPrenotazione,_btnModificaPrenotazione;
	/*JLabel*/
	private JLabel _lblInstructions;

	/* Singleton */
	private static VFrameHome instance = null;
	
	/**
     * Costruttore privato - pattern Singleton
     */
	private VFrameHome() {
		super();
		
		/*Button*/
		_btnCreaPrenotazione = _viewFactory.getButton();
		_btnModificaPrenotazione = _viewFactory.getButton();
		
		/*Label*/
		_lblInstructions= _viewFactory.getLabelIntestazione_1();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
    public static VFrameHome getInstance() {
    	if(instance == null) {
            instance = new VFrameHome();
         }
         return instance;
    }
    @Override
	public void removeInstance() {
    	instance = null;
	}
    @Override
    protected void creaPanelTop(){
    	_lblInstructions.setText("Scegli l'operazione che vuoi fare.");
    	_panelTop.add(_lblInstructions);
    }
    @Override
    protected void creaPanelMiddle(){
    	/*Setto il layout*/
    	_panelMiddle.setLayout(new GridLayout(2, 1, 0, 10));
    	/*Setto il testo dei pulsanti*/
    	_btnCreaPrenotazione.setText("Crea nuova prenotazione");   	   	
		_btnModificaPrenotazione.setText("Gestisci prenotazione");
		
		/*Aggiungo i pulsanti al pannello*/
		_panelMiddle.add(_btnCreaPrenotazione);
		_panelMiddle.add(_btnModificaPrenotazione);
		
		// Assegniamo l'eventListener al JButton btnCreaPrenotazione
		_btnCreaPrenotazione.addMouseListener(new CaricaCreaNuovaPrenotazioneListener()); 
		// Assegniamo l'eventListener al JButton btnModificaPrenotazione
		_btnModificaPrenotazione.addMouseListener(new CaricaGestionePrenotazioneListener());
    }
    @Override
	public void creaPanelBottom() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Create the frame.
	 */
	public void creaFrame() {
		setTitle("iHotel - Home");		
		
		/*Setto il testo alla label*/
		creaPanelTop();
		creaPanelMiddle();
	}
	/* ------------------------ Getter, Setter -------------------------------- */
	/**
	 * @return the _contentPane
	 */
	public JPanel get_contentPane() {
		return _contentPane;
	}
	/**
	 * @param _contentPane the _contentPane to set
	 */
	public void set_contentPane(JPanel _contentPane) {
		this._contentPane = _contentPane;
	}
	/**
	 * @return the _panelTop
	 */
	public JPanel get_panelTop() {
		return _panelTop;
	}
	/**
	 * @param _panelTop the _panelTop to set
	 */
	public void set_panelTop(JPanel _panelTop) {
		this._panelTop = _panelTop;
	}
	/**
	 * @return the _panelBottom
	 */
	public JPanel get_panelBottom() {
		return _panelBottom;
	}
	/**
	 * @param _panelBottom the _panelBottom to set
	 */
	public void set_panelBottom(JPanel _panelBottom) {
		this._panelBottom = _panelBottom;
	}
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
