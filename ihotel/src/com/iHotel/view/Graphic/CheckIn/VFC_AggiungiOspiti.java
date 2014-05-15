/**
 * 
 */
package com.iHotel.view.Graphic.CheckIn;

import java.util.HashMap;

import javax.swing.JTabbedPane;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.utility.UStartup;
import com.iHotel.view.View;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFC_AggiungiOspiti extends View {
	
	/* ----------------- Attributi e Costruttore ----------------------- */
	
	private PrenotazioneSubject _prenotazione;
	
	private JTabbedPane _panelMiddleTabbed;

	/**
	 * 
	 */
	public VFC_AggiungiOspiti() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#removeInstance()
	 */
	@Override
	public void removeInstance() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelTop()
	 */
	@Override
	protected void creaPanelTop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelMiddle()
	 */
	@Override
	protected void creaPanelMiddle() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iHotel.view.View#creaPanelBottom()
	 */
	@Override
	protected void creaPanelBottom() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Metodo per creare il frame.
	 */
	public void creaFrame(PrenotazioneSubject prenotazione) {
		setTitle("iHotel - Check in");
		// Setto la prenotazione
		_prenotazione=prenotazione;

		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Inizializzo lo strato di dominio
		UStartup start = new UStartup();
		start.inizializza();
		// Prendo una prenotazione
		HashMap<String,PrenotazioneSubject> prenotazioni = Storico.getInstance().get_prenotazioni();
		PrenotazioneSubject prenotazione = prenotazioni.get("1400100535949");
		// Creo il frame
		VFC_AggiungiOspiti frame = new VFC_AggiungiOspiti();
		frame.creaFrame(prenotazione);
		frame.setVisible(true);
	
	}
	
	/* ---------------------- Getter, Setter ----------------------------- */

	/**
	 * @return the _prenotazione
	 */
	public PrenotazioneSubject get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	public void set_prenotazione(PrenotazioneSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

	/**
	 * @return the _panelMiddleTabbed
	 */
	public JTabbedPane get_panelMiddleTabbed() {
		return _panelMiddleTabbed;
	}

	/**
	 * @param _panelMiddleTabbed the _panelMiddleTabbed to set
	 */
	public void set_panelMiddleTabbed(JTabbedPane _panelMiddleTabbed) {
		this._panelMiddleTabbed = _panelMiddleTabbed;
	}

}
