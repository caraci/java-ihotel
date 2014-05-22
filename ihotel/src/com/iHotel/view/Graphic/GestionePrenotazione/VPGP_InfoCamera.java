/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;


import java.awt.BorderLayout;
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
import com.iHotel.view.Event.GestionePrenotazione.CaricaAggiungiServiziListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;
import com.iHotel.view.Utility.UtoString;

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
	private Camera _camera;
	/**
	 * Periodo a cui si riferisce la gestione della camera.
	 */
	private Periodo _periodo;
	/**
	 * Factory con la responsabilità di conoscere i sistemi esterni con i quali è collegato l'albergo.
	 */
	private ServiceFactory _serviceFactory;

	//JPanel
	private JPanel _pnlMiddleLeft, _pnlMiddleCenter, _pnlMiddleRight;
				   
	// JScrollPane
	private JScrollPane _scrollPaneMiddleRightPayTv,_scrollPaneMiddleRightTelefono;
	
	//Label
	private JLabel _lblInfoCamera, _lblOspitiCamera,_lblServiziInterniRichiesti;
	
	//Button
	private JButton _btnAggiungiServizi, _btnTornaPrenotazione;

	/**
	 * Costruttore privato - Pattern Singleton
	 */
	public VPGP_InfoCamera() {
		_serviceFactory=ServiceFactory.getInstance();
		
		/*Istanzio gli oggetti da mostrare nell'interfaccia*/
		
		/*Panel*/
		_pnlMiddleLeft = _viewFactory.getPanel();
		_pnlMiddleCenter =_viewFactory.getPanel();
		_pnlMiddleRight=_viewFactory.getPanel();
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
		_panelMiddle.add(creaPanelMiddleCenter());				
		_panelMiddle.add(creaPanelMiddleRight());		
	}
	/**
	 * Metodo per creare il pannello contenente la lista degli ospiti della camera.
	 * 
	 * @return Pannello centrale sinistro.
	 */
	private JPanel creaPanelMiddleLeft(){
		// Setto il layout al panel.
		_pnlMiddleLeft.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblOspitiCamera.setText("Ospiti della camera:");
		_pnlMiddleLeft.add(_lblOspitiCamera);
		// Ciclo sugli ospiti della camera
		for (Iterator<Ospite> iterator = _camera.getOspitiInPeriodo(_periodo).iterator(); iterator.hasNext();) {
			Ospite ospite = (Ospite) iterator.next();
			// Creo una label per inserire nome e cognome dell'ospite
			JLabel lblOspite = _viewFactory.getLabel();
			lblOspite.setText(UtoString.getInstance().ospiteToString(ospite));
			// Aggiungo la label al pannello
			_pnlMiddleLeft.add(lblOspite);
		}
		return _pnlMiddleLeft;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi interni richiesti.
	 * 
	 * @return Pannello centrale.
	 */
	private JPanel creaPanelMiddleCenter(){
		// Setto il layout al panel.
		_pnlMiddleCenter.setLayout(new BoxLayout(_pnlMiddleCenter, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblServiziInterniRichiesti.setText("Servizi interni richiesti:");
		_pnlMiddleCenter.add(_lblServiziInterniRichiesti);
		
		/*Scorre l'array dei servizi interni collegati alla camera e li inserisce in un array di label*/
		for (Iterator<ServizioInterno> iterator = _camera.getServiziInterniInPeriodo(_periodo).iterator(); iterator.hasNext();) {
			ServizioInterno servizioInterno = (ServizioInterno) iterator.next();
			// Creo una label per inserire le informazioni del servizio
			JLabel lblServizioInterno=_viewFactory.getLabel();
			lblServizioInterno.setText(UtoString.getInstance().servizioInternoInPrenotazioneToString(servizioInterno));
			/*Aggiungo la label del servizio al panel*/
			_pnlMiddleCenter.add(lblServizioInterno);
			/*Aggiungo lo spazio*/
			_pnlMiddleCenter.add(Box.createRigidArea(new Dimension(0,15)));
		}
		
		return _pnlMiddleCenter;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi esterni richiesti.
	 * 
	 * @return Pannello centrale destro.
	 */
	private JPanel creaPanelMiddleRight(){
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
	private JScrollPane creaPanelMiddleRightPayTv() {
		// Creo pannello nel quale inserisco i servizi della PayTv.
		JPanel pnlServiziPayTv = _viewFactory.getPanel(false);
		// Setto Layout
		pnlServiziPayTv.setLayout(new BoxLayout(pnlServiziPayTv, BoxLayout.PAGE_AXIS));
		
		// Pannello Intestazione
		JPanel pnlIntestazione = _viewFactory.getPanel(false);
		pnlIntestazione.setLayout(new BorderLayout(0,0));
		// Label intestazione
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Servizi PayTv:");
		// Aggiungo lblIntestazione al pnlIntestazione
		pnlIntestazione.add(lblIntestazione);
		
		// Pannello lista servizi
		JPanel pnlListaServizi = _viewFactory.getPanel(false);
		pnlListaServizi.setLayout(new BoxLayout(pnlListaServizi,BoxLayout.PAGE_AXIS));
		
		// Recupero la lista di servizi di PayTv
		ArrayList<ServizioPayTv> serviziPayTv = _serviceFactory.get_payTvAdapter().getElencoServiziPayTvCameraInPeriodo(_camera, _periodo);
		
		// Ciclo sui servizi per aggiungerli al pnlListaServizi
		for (Iterator<ServizioPayTv> iterator = serviziPayTv.iterator(); iterator.hasNext();) {
			ServizioPayTv servizioPayTv = (ServizioPayTv) iterator.next();
			// Creo la label per il servizio
			JLabel lblServizioPayTv = _viewFactory.getLabel();
			lblServizioPayTv.setText(UtoString.getInstance().servizioPayTv(servizioPayTv));
			// Aggiungo lbl al pannello
			pnlListaServizi.add(lblServizioPayTv);
			// Aggiungo spaziatura
			pnlListaServizi.add(Box.createVerticalStrut(3));
		}
		
		// Aggiungo elementi al pnlServiziTelefono
		pnlServiziPayTv.add(pnlIntestazione);
		pnlServiziPayTv.add(Box.createVerticalStrut(10));
		pnlServiziPayTv.add(pnlListaServizi);
		
		// Setto il viewport allo scrollPane
		_scrollPaneMiddleRightPayTv.setViewportView(pnlServiziPayTv);
		
		return _scrollPaneMiddleRightPayTv;
	}
	/**
	 * Metodo per fornire il pannello contenente la lista dei servizi di telefonia in camera.
	 * 
	 * @return Pannello contenente la lista dei servizi del telefono.
	 */
	private JScrollPane creaPanelMiddleRightTelefono() {
		// Creo pannello nel quale inserisco i servizi del telefono.
		JPanel pnlServiziTelefono = _viewFactory.getPanel(false);
		// Setto Layout
		pnlServiziTelefono.setLayout(new BoxLayout(pnlServiziTelefono, BoxLayout.PAGE_AXIS));
		
		// Pannello Intestazione
		JPanel pnlIntestazione = _viewFactory.getPanel(false);
		pnlIntestazione.setLayout(new BorderLayout(0,0));
		// Label intestazione
		JLabel lblIntestazione = _viewFactory.getLabelIntestazione_2();
		lblIntestazione.setText("Servizi Telefono:");
		// Aggiungo lblIntestazione al pnlIntestazione
		pnlIntestazione.add(lblIntestazione);
		
		// Pannello lista servizi
		JPanel pnlListaServizi = _viewFactory.getPanel(false);
		pnlListaServizi.setLayout(new BoxLayout(pnlListaServizi,BoxLayout.PAGE_AXIS));
		
		// Recupero la lista di servizi di Telefonia
		ArrayList<ServizioTelefono> serviziTelefono = _serviceFactory.get_telephoneAdapter().getElencoServiziTelefonoCameraInPeriodo(_camera, _periodo);
		
		// Ciclo sui servizi per aggiungerli al pnlListaServizi
		for (Iterator<ServizioTelefono> iterator = serviziTelefono.iterator(); iterator.hasNext();) {
			ServizioTelefono servizioTelefono = (ServizioTelefono) iterator.next();
			// Creo la label per il servizio
			JLabel lblServizioTelefono = _viewFactory.getLabel();
			lblServizioTelefono.setText(UtoString.getInstance().servizioTelefono(servizioTelefono));
			// Aggiungo lbl al pannello
			pnlListaServizi.add(lblServizioTelefono);
			// Aggiungo spaziatura
			pnlListaServizi.add(Box.createVerticalStrut(3));
		}
		
		// Aggiungo elementi al pnlServiziTelefono
		pnlServiziTelefono.add(pnlIntestazione);
		pnlServiziTelefono.add(Box.createVerticalStrut(10));
		pnlServiziTelefono.add(pnlListaServizi);
		
		// Setto il viewport allo scrollPane
		_scrollPaneMiddleRightTelefono.setViewportView(pnlServiziTelefono);
		
		return _scrollPaneMiddleRightTelefono;
	}
	@Override
	protected void creaPanelBottom() {
		/*Setto il testo dei bottoni*/
		_btnAggiungiServizi.setText("Aggiungi servizi");
		_btnTornaPrenotazione.setText("Torna alla prenotazione");
		/*Aggiungo il listener al click sul bottone*/
		_btnAggiungiServizi.addMouseListener(new CaricaAggiungiServiziListener());
		_btnTornaPrenotazione.addMouseListener(new TornaAllaPrenotazioneListener());
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


}
