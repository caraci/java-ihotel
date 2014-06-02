/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniCamera;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.ForeignSystem.PayTv.ServizioPayTv;
import com.iHotel.model.ForeignSystem.Telephone.ServizioTelefono;
import com.iHotel.view.ViewPanelContentPane;
import com.iHotel.view.Event.GestioneSoggiorno.InformazioniCamera.AggiungiServiziListener;
import com.iHotel.view.Event.GestioneSoggiorno.InformazioniCamera.TornaAlSoggiornoDaInfoCameraListener;
import com.iHotel.view.Utility.UtoPanel;

/**
 * Classe addetta alla realizzazione della finestra relativa al mostrare le informazioni di una camera
 * in relazione ad una prenotazione.
 * 
 * @author Eugenio
 */
@SuppressWarnings("serial")
public class VPGP_InfoCamera extends ViewPanelContentPane {

	/* ----------------------------- Attributi e costruttore -------------------------------- */
	/**
	 * Camera di cui si mostrano le informazioni.
	 */
	protected Camera _camera;
	/**
	 * Periodo a cui si riferisce la gestione della camera.
	 */
	protected Periodo _periodo;
	/**
	 * Factory con la responsabilità di conoscere i sistemi esterni con i quali è collegato l'albergo.
	 */
	protected ServiceFactory _serviceFactory;

	//JPanel
	protected JPanel _pnlMiddleLeft, _pnlMiddleRight,_pnlServiziPayTv,_pnlServiziTelefono, _pnlServiziInterni;
				   
	// JScrollPane
	protected JScrollPane _scrollPaneMiddleRightPayTv,_scrollPaneMiddleRightTelefono;
	
	//Label
	protected JLabel _lblInfoCamera, _lblOspitiCamera,_lblServiziInterniRichiesti;
	
	//Button
	protected JButton _btnAggiungiServizi, _btnTornaPrenotazione;

	/**
	 * Costruttore privato - Pattern Singleton
	 */
	public VPGP_InfoCamera() {
		_serviceFactory=ServiceFactory.getInstance();
		
		/*Istanzio gli oggetti da mostrare nell'interfaccia*/
		
		/*Panel*/
		_pnlMiddleLeft = _viewFactory.getPanel();
		_pnlMiddleRight=_viewFactory.getPanel();
		_pnlServiziPayTv=_viewFactory.getPanel(false);
		_pnlServiziTelefono=_viewFactory.getPanel(false);
		_pnlServiziInterni = _viewFactory.getPanel();
		/*JScrollPane*/
		_scrollPaneMiddleRightPayTv=_viewFactory.getScrollPane();
		_scrollPaneMiddleRightTelefono=_viewFactory.getScrollPane();
		
		/*Label*/
		_lblInfoCamera=_viewFactory.getLabelIntestazione_1();
		_lblOspitiCamera= _viewFactory.getLabelIntestazione_2();
		_lblServiziInterniRichiesti=_viewFactory.getLabelIntestazione_2();
		
		/*Button*/
		_btnAggiungiServizi=_viewFactory.getButtonAvanti();
		_btnTornaPrenotazione=_viewFactory.getButton();	
	}
	/* -------------------------- Metodi di instanza -------------------------- */
	@Override
	protected void creaPanelTop() {
		// Setto il layout al panel
		_panelTop.setLayout(new BorderLayout(0, 0));
		// Setto il testo alla label
		_lblInfoCamera.setText("Informazioni sulla camera" + _camera.get_numero() + " :");
		// Aggiungo la label al panel
		_panelTop.add(_lblInfoCamera);
	}
	@Override
	protected void creaPanelMiddle() {
		// Setto il layout al panel
		_panelMiddle.setLayout(new GridLayout(1, 3, 10, 10));
		// Creo i pannelli destro e sinistro e li aggiungo al pnlMiddle.
		_panelMiddle.add(creaPanelMiddleLeft());
		//Pannello contenente i servizi interni
		_pnlServiziInterni.setLayout(new CardLayout());
		/*Costruisco il pannello dei servizi*/
		_pnlServiziInterni.add(creaPanelMiddleCenter());
		
		_panelMiddle.add(_pnlServiziInterni);
		_panelMiddle.add(creaPanelMiddleRight());		
	}
	/**
	 * Metodo per creare il pannello contenente la lista degli ospiti della camera.
	 * 
	 * @return Pannello centrale sinistro.
	 */
	protected JPanel creaPanelMiddleLeft(){
		// Setto il layout al panel.
		_pnlMiddleLeft.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblOspitiCamera.setText("Ospiti della camera:");
		_pnlMiddleLeft.add(_lblOspitiCamera);
		// Ciclo sugli ospiti della camera
		for (Iterator<Ospite> iterator = _camera.getOspitiInPeriodo(_periodo).iterator(); iterator.hasNext();) {
			Ospite ospite = (Ospite) iterator.next();
			// Aggiungo la label al pannello
			_pnlMiddleLeft.add(UtoPanel.ospiteToPanel(ospite));
		}
		return _pnlMiddleLeft;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi interni richiesti.
	 * 
	 * @return Pannello centrale.
	 */
	public JScrollPane creaPanelMiddleCenter(){
		
		/*Creo un JScrollPane*/
		JScrollPane scrollPaneServiziInterni = _viewFactory.getScrollPane();
		/*Creo un JPanel*/
		JPanel panelServiziInterni = _viewFactory.getPanel();
		
		// Setto il layout al panel.
		panelServiziInterni.setLayout(new BoxLayout(panelServiziInterni, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblServiziInterniRichiesti.setText("Servizi interni richiesti:");
		panelServiziInterni.add(_lblServiziInterniRichiesti);
		
		/*Scorre l'array dei servizi interni collegati alla camera e li inserisce in un array di label*/
		for (Iterator<ServizioInterno> iterator = _camera.getServiziInterniInPeriodo(_periodo).iterator(); iterator.hasNext();) {
			ServizioInterno servizioInterno = (ServizioInterno) iterator.next();
			// Aggiungo al pannello un pannello contenente le informazioni del servizio			
			panelServiziInterni.add(UtoPanel.servizioInternoInPrenotazioneToPanel(servizioInterno));
			/*Aggiungo lo spazio*/
			panelServiziInterni.add(Box.createRigidArea(new Dimension(0,15)));
		}
		
		/*Aggiungo il pannello allo scrollPane*/
		scrollPaneServiziInterni.setViewportView(panelServiziInterni);;
		/*Restituisco lo scrollPane*/
		return scrollPaneServiziInterni;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi esterni richiesti.
	 * 
	 * @return Pannello centrale destro.
	 */
	protected JPanel creaPanelMiddleRight(){
		// Setto il layout al panel.
		_pnlMiddleRight.setLayout(new GridLayout(2, 1, 5, 0));
		// Aggiungo il pannello dei servizi della PayTv
		_pnlMiddleRight.add(creaPanelMiddleRightPayTv());
		// Aggiungo il pannelo dei servizi del Telefono
		_pnlMiddleRight.add(creaPanelMiddleRightTelefono());
		
		return _pnlMiddleRight;
	}
	/**
	 * Metodo per fornire il pannello contenente la lista dei servizi di payTv in camera.
	 * 
	 * @return Pannello contenente la lista dei servizi di payTv.
	 */
	protected JScrollPane creaPanelMiddleRightPayTv() {
		// Setto Layout
		_pnlServiziPayTv.setLayout(new BoxLayout(_pnlServiziPayTv, BoxLayout.PAGE_AXIS));	

		// Label intestazione
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Servizi PayTv:");
		
		// Pannello lista servizi
		JPanel pnlListaServizi = _viewFactory.getPanel(false);
		pnlListaServizi.setLayout(new BoxLayout(pnlListaServizi,BoxLayout.PAGE_AXIS));
		
		// Recupero la lista di servizi di PayTv
		ArrayList<ServizioPayTv> serviziPayTv = _serviceFactory.get_payTvAdapter().getElencoServiziPayTvCameraInPeriodo(_camera, _periodo);
		
		// Ciclo sui servizi per aggiungerli al pnlListaServizi
		for (Iterator<ServizioPayTv> iterator = serviziPayTv.iterator(); iterator.hasNext();) {
			ServizioPayTv servizioPayTv = (ServizioPayTv) iterator.next();
			// Aggiungo lbl al pannello
			pnlListaServizi.add(UtoPanel.servizioPayTvToPanel(servizioPayTv));
			// Aggiungo spaziatura
			pnlListaServizi.add(Box.createVerticalStrut(3));
		}
		
		// Aggiungo elementi al pnlServiziTelefono
		_pnlServiziPayTv.add(lblIntestazione);
		_pnlServiziPayTv.add(Box.createVerticalStrut(10));
		_pnlServiziPayTv.add(pnlListaServizi);
		
		// Setto il viewport allo scrollPane
		_scrollPaneMiddleRightPayTv.setViewportView(_pnlServiziPayTv);
		
		return _scrollPaneMiddleRightPayTv;
	}
	/**
	 * Metodo per fornire il pannello contenente la lista dei servizi di telefonia in camera.
	 * 
	 * @return Pannello contenente la lista dei servizi del telefono.
	 */
	protected JScrollPane creaPanelMiddleRightTelefono() {
		// Setto Layout
		_pnlServiziTelefono.setLayout(new BoxLayout(_pnlServiziTelefono, BoxLayout.PAGE_AXIS));
		
		// Label intestazione
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Servizi Telefono:");
		
		// Pannello lista servizi
		JPanel pnlListaServizi = _viewFactory.getPanel(false);
		pnlListaServizi.setLayout(new BoxLayout(pnlListaServizi,BoxLayout.PAGE_AXIS));
		
		// Recupero la lista di servizi di Telefonia
		ArrayList<ServizioTelefono> serviziTelefono = _serviceFactory.get_telephoneAdapter().getElencoServiziTelefonoCameraInPeriodo(_camera, _periodo);
		
		// Ciclo sui servizi per aggiungerli al pnlListaServizi
		for (Iterator<ServizioTelefono> iterator = serviziTelefono.iterator(); iterator.hasNext();) {
			ServizioTelefono servizioTelefono = (ServizioTelefono) iterator.next();
			// Aggiungo lbl al pannello
			pnlListaServizi.add(UtoPanel.servizioTelefono(servizioTelefono));
			// Aggiungo spaziatura
			pnlListaServizi.add(Box.createVerticalStrut(3));
		}
		
		// Aggiungo elementi al pnlServiziTelefono
		_pnlServiziTelefono.add(lblIntestazione);
		_pnlServiziTelefono.add(Box.createVerticalStrut(10));
		_pnlServiziTelefono.add(pnlListaServizi);
		
		// Setto il viewport allo scrollPane
		_scrollPaneMiddleRightTelefono.setViewportView(_pnlServiziTelefono);
		
		return _scrollPaneMiddleRightTelefono;
	}
	@Override
	protected void creaPanelBottom() {
		/*Setto il testo dei bottoni*/
		_btnAggiungiServizi.setText("Aggiungi servizi");
		_btnTornaPrenotazione.setText("Indietro");
		/*Aggiungo il listener al click sul bottone*/
		_btnAggiungiServizi.addMouseListener(new AggiungiServiziListener());
		_btnTornaPrenotazione.addMouseListener(new TornaAlSoggiornoDaInfoCameraListener());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo i bottoni alla struttura.
		Bottoni.put(0,_btnTornaPrenotazione);
		Bottoni.put(5,_btnAggiungiServizi);
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
	}
	/**
	 * Metodo per creare il frame relativo alle informazioni della camera in merito alla prenotazione.
	 * 
	 * @param camera Camera di cui si vogliono mostrare le informazioni.
	 * @param periodo Periodo al quale si riferisce la gestione della camera.
	 */
	public void creaPanel(Camera camera, Periodo periodo) {
		// Setto gli attributi dell'interfaccia
		_camera=camera;
		_periodo=periodo;
		// Creo i pannelli
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
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
	/**
	 * Metodo che restituisce il pannello dei servizi interni
	 * 
	 * @return Pannello dei servizi interni
	 */
	public JPanel getPanelServiziInterni(){
		return this._pnlServiziInterni;
	}


}
