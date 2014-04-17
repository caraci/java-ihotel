/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.CaricaAggiungiServiziListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_InfoCamera extends View {

	/* ----------------------------- Attributi e costruttore -------------------------------- */
	private CameraContext _camera;
	private PrenotazioneSubject _prenotazione;

	//JPanel
	private JPanel _pnlMiddleLeft, _pnlMiddleCenter, _pnlMiddleRight;

	//Label
	private JLabel _lblInfoCamera, _lblOspitiCamera,_lblServiziInterniRichiesti, _lblServiziEsterniRichiesti;
	private ArrayList<JLabel> _lblServizioInternoRichiesto;
	
	//Button
	private JButton _btnAggiungiServizi, _btnTornaPrenotazione;
		
	//Singleton
	private static VFGP_InfoCamera instance=null;
	

	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private VFGP_InfoCamera() {
		/*Istanzio gli oggetti da mostrare nell'interfaccia*/
		
		/*Panel*/
		_pnlMiddleLeft = _viewFactory.getPanel();
		_pnlMiddleCenter =_viewFactory.getPanel();
		_pnlMiddleRight=_viewFactory.getPanel();
	
		
		/*Label*/
		_lblInfoCamera=_viewFactory.getLabel();
		_lblOspitiCamera= _viewFactory.getLabel();
		_lblServiziInterniRichiesti=_viewFactory.getLabel();
		_lblServiziEsterniRichiesti=_viewFactory.getLabel();
		
		/*Button*/
		_btnAggiungiServizi=_viewFactory.getButton();
		_btnTornaPrenotazione=_viewFactory.getButton();	
	}
	
	/* ------------------------- Metodi di classe ---------------------------- */
	
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton
	 */
	public static VFGP_InfoCamera getInstance() {
    	if(instance == null) {
            instance = new VFGP_InfoCamera();
         }
         return instance;
    }
	/* -------------------------- Metodi di instanza -------------------------- */
	@Override
	protected void creaPanelTop() {
		// Setto il layout al panel
		_panelTop.setLayout(new GridLayout(2, 1, 10, 10));
		// Setto il testo alla label
		_lblInfoCamera.setText("Informazioni sulla camera" + _camera.get_numero() + " :");
		// Aggiungo la label al panel
		_panelTop.add(_lblInfoCamera);
	}

	@Override
	protected void creaPanelMiddle() {
		// Setto il layout al panel
		_panelMiddle.setLayout(new GridLayout(1, 2, 10, 10));
		// Creo i pannelli destro e sinistro e li aggiungo al pnlMiddle.
		_panelMiddle.add(creaPanelMiddleLeft());
		_panelMiddle.add(creaPanelMiddleCenter());				
		_panelMiddle.add(creaPanelMiddleRight());		
	}
	/**
	 * Metodo per creare il pannello contenente la lista degli ospiti della camera.
	 * @return Pannello centrale sinistro.
	 */
	private JPanel creaPanelMiddleLeft(){
		// Setto il layout al panel.
		_pnlMiddleLeft.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblOspitiCamera.setText("Ospiti della camera");
		return _pnlMiddleLeft;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi interni richiesti.
	 * @return Pannello centrale sinistro.
	 */
	private JPanel creaPanelMiddleCenter(){
		// Setto il layout al panel.
		_pnlMiddleCenter.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblServiziInterniRichiesti.setText("Servizi interni richiesti");
		
		ArrayList<ServizioInterno> serviziInterni = _camera.getServiziInterniInPeriodo(_prenotazione.get_periodo());
		/*Scorre l'array dei servizi interni collegati alla camera e li inserisce in un array di label*/
		for (Iterator<ServizioInterno> iterator = serviziInterni.iterator(); iterator.hasNext();) {
			ServizioInterno servizioInterno = (ServizioInterno) iterator.next();
			JLabel lblServizioInterno=_viewFactory.getLabel();
			lblServizioInterno.setText(servizioInterno.get_codice()+servizioInterno.get_data());
			_lblServizioInternoRichiesto.add(lblServizioInterno);
			/*Aggiungo ogni servizio al panel*/
			_pnlMiddleCenter.add(lblServizioInterno);
			/*Aggiungo lo spazio*/
			_pnlMiddleCenter.add(Box.createRigidArea(new Dimension(0,15)));
		}
		
		return _pnlMiddleCenter;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi esterni richiesti.
	 * @return Pannello centrale destro.
	 */
	private JPanel creaPanelMiddleRight(){
		// Setto il layout al panel.
		_pnlMiddleRight.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblServiziEsterniRichiesti.setText("Servizi esterni richiesti");
		return _pnlMiddleRight;
	}
	@Override
	protected void creaPanelBottom() {
		/*Setto il testo dei bottoni*/
		_btnAggiungiServizi.setText("Aggiungi servizi");
		_btnTornaPrenotazione.setText("Torna alla prenotazione");
		
		/*Aggiungo i pulsanti al panelBottom*/
		_panelBottom.add(_btnAggiungiServizi);
		_panelBottom.add(_btnTornaPrenotazione);
		
		/*Aggiungo il listener al click sul bottone*/
		_btnAggiungiServizi.addMouseListener(new CaricaAggiungiServiziListener());
		_btnTornaPrenotazione.addMouseListener(new TornaAllaPrenotazioneListener());
	}

	/* ----------------------------- Getter, Setter ---------------------------------- */
	
	/**
	 * @return the _btnAggiungiServizi
	 */
	public JButton get_btnAggiungiServizi() {
		return _btnAggiungiServizi;
	}

	/**
	 * @param _btnAggiungiServizi the _btnAggiungiServizi to set
	 */
	public void set_btnAggiungiServizi(JButton _btnAggiungiServizi) {
		this._btnAggiungiServizi = _btnAggiungiServizi;
	}

	/**
	 * @return the _btnTornaPrenotazione
	 */
	public JButton get_btnTornaPrenotazione() {
		return _btnTornaPrenotazione;
	}

	/**
	 * @param _btnTornaPrenotazione the _btnTornaPrenotazione to set
	 */
	public void set_btnTornaPrenotazione(JButton _btnTornaPrenotazione) {
		this._btnTornaPrenotazione = _btnTornaPrenotazione;
	}


}
