/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;

import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.AggiungiServizioListener;
import com.iHotel.view.Event.GestionePrenotazione.MostraDettagliServizioListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaCameraListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_AggiungiServiziInterni extends View {
	/* ----------------------------- Attributi e Costruttore ----------------- */
	// Singleton
	private static VFGP_AggiungiServiziInterni instance=null;
	private HashMap<String,DescrizioneServizioInterno> _descrizioniServizi;
	private CameraContext _camera;
	// JPanel
		private JPanel _pnlMiddleLeft;
		private JPanel _pnlMiddleRight;
	// JLabel
	private JLabel _lblScegliServizio, _lblAggiungiServizi;
	// JButton
	private JButton _btnAggiungiServizio, _btnTornaAllaCamera;
	/* JComboBox */
	private JComboBox<String> _comboBoxServizi;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private VFGP_AggiungiServiziInterni() {
		// TODO - Usare pattern Singleton
		_comboBoxServizi=new JComboBox<>();
		// JPanel
		_pnlMiddleLeft=_viewFactory.getPanel();
		_pnlMiddleRight=_viewFactory.getPanel();
		// JLabel
		_lblAggiungiServizi=_viewFactory.getLabel();
		_lblScegliServizio=_viewFactory.getLabel();
		// JButton
		_btnAggiungiServizio=_viewFactory.getButton();
		_btnTornaAllaCamera=_viewFactory.getButton();
	}
	/* ------------------------------- Metodi di classe -------------------------- */
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern singleton
	 */
	public static VFGP_AggiungiServiziInterni getInstance() {
    	if(instance == null) {
            instance = new VFGP_AggiungiServiziInterni();
         }
         return instance;
    }
	/* ------------------------------ Metodi di instanza ------------------------ */
	@Override
    public void removeInstance() {
    	instance = null;
	}
	@Override
	protected void creaPanelTop() {
		// Setto il layout al panel
		_panelTop.setLayout(new GridLayout(2, 1, 10, 10));
		// Setto il testo alla label
		_lblAggiungiServizi.setText("Aggiungi servizi per la camera" + _camera.get_numero() + " :");
		// Aggiungo la label al panel
		_panelTop.add(_lblAggiungiServizi);
	}
	@Override
	protected void creaPanelMiddle() {
		// Setto il layout al panel
		_panelMiddle.setLayout(new GridLayout(1, 2, 10, 10));
		// Creo i pannelli destro e sinistro e li aggiungo al pnlMiddle.
		_panelMiddle.add(creaPanelMiddleLeft());
		_panelMiddle.add(creaPanelMiddleRight());
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi interni.
	 * @return Pannello centrale sinistro.
	 */
	private JPanel creaPanelMiddleLeft() {
		// Setto il layout al panel.
		_pnlMiddleLeft.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblScegliServizio.setText("Scegli un servizio:");
		_pnlMiddleLeft.add(_lblScegliServizio);
		// Aggiungo spaziatura statica
		_pnlMiddleLeft.add(Box.createRigidArea(new Dimension(0,20)));
		// Ciclo sui servizi interni per creare la comboBox.
		for (Iterator<String> iterator = _descrizioniServizi.keySet().iterator(); iterator.hasNext();) {
			String codiceServizio = (String) iterator.next();
			// Aggiungo la stringa del nome del servizio alla comboBox
			_comboBoxServizi.addItem(_descrizioniServizi.get(codiceServizio).get_nome());
		}
		// Assegno il gestore dell'evento alla JComboBox
		_comboBoxServizi.addItemListener(new MostraDettagliServizioListener());
		// Aggiungo la comboBox al Panel
		_pnlMiddleLeft.add(_comboBoxServizi);
		return _pnlMiddleLeft;
	}
	/**
	 * Metodo per creare il pannello nella parte centrale destra della pagina.
	 * @return Pannello centrale destro.
	 */
	private JPanel creaPanelMiddleRight() {
		// Setto il layout al panel
		_pnlMiddleRight.setLayout(new CardLayout());
		// Recupero il descrittore
		String codiceServizio = CatalogoServiziInterni.getInstance().getCodiceServizioDaNome(_comboBoxServizi.getItemAt(0));
		DescrizioneServizioInterno descrizioneServizio = CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(codiceServizio);	
		// Aggiungo il panel del descrittore al padre
		_pnlMiddleRight.add(creaPanelDescrittore(descrizioneServizio));
		return _pnlMiddleRight;
	}
	/**
	 * Metodo per creare il pannello contenente le informazioni di un servizio.
	 * A differenza degli altri metodi usati per costruire l'interfaccia è pubblico visto
	 * che viene usato da un gestore dell'evento.
	 * @see com.iHotel.view.Event.GestionePrenotazione.MostraDettagliServizioListener.java
	 * @param descrizioneServizio Descrittore del servizio
	 * @return Pannello relativo al descrittore del servizio.
	 */
	public JPanel creaPanelDescrittore(DescrizioneServizioInterno descrizioneServizio) {
		// Pannello per il servizio
		JPanel pnlDescrittoreServizio=_viewFactory.getPanel();
		// Setto il gestore del Layout al panel
		pnlDescrittoreServizio.setLayout(new BoxLayout(pnlDescrittoreServizio, BoxLayout.PAGE_AXIS));
		// Codice servizio
		JLabel lblCodice=_viewFactory.getLabel();
		lblCodice.setText("Codice del servizio: " + descrizioneServizio.get_codice());
		pnlDescrittoreServizio.add(lblCodice);
		// Nome servizio
		JLabel lblNome=_viewFactory.getLabel();
		lblNome.setText("Nome del servizio: " + descrizioneServizio.get_nome());
		pnlDescrittoreServizio.add(lblNome);
		// JDatePanel data servizio
		JDatePanel datePanelServizio = JDateComponentFactory.createJDatePanel();
		pnlDescrittoreServizio.add((Component) datePanelServizio);
		// Aggiungo il bottone per aggiungere il servizio
		JButton btnAggiungiServizio = _viewFactory.getButtonAvanti();
		btnAggiungiServizio.setText("Aggiungi servizio");
		pnlDescrittoreServizio.add(btnAggiungiServizio);
		// Aggiungo l'eventListener al bottone per aggiungere un servizio
		btnAggiungiServizio.addMouseListener(new AggiungiServizioListener(datePanelServizio, descrizioneServizio.get_codice()));
		
		return pnlDescrittoreServizio;
	}
	@Override
	protected void creaPanelBottom() {
		// Setto il testo al bottone
		_btnTornaAllaCamera.setText("Torna alla camera");
		// Aggiungo l'eventListener al bottone per tornare alla gestione della camera
		_btnTornaAllaCamera.addMouseListener(new TornaAllaCameraListener());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(0,_btnTornaAllaCamera);
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
	}
	
	public void creaFrame(HashMap<String,DescrizioneServizioInterno> descrizioniServizi, CameraContext camera) {
		// Setto titolo del frame.
		setTitle("iHotel - Gestione Prenotazione - Aggiungi servizi alla camera");
		// Setto gli attributi dell'interfaccia attraverso ciò che ricevo per parametro.
		_camera = camera;
		_descrizioniServizi=descrizioniServizi;
		// Creo i pannelli
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
	}
	/* ----------------------------- Getter, Setter ------------------------------- */
	/**
	 * @return the _descrizioniServizi
	 */
	public HashMap<String, DescrizioneServizioInterno> get_descrizioniServizi() {
		return _descrizioniServizi;
	}
	/**
	 * @param _descrizioniServizi the _descrizioniServizi to set
	 */
	public void set_descrizioniServizi(
			HashMap<String, DescrizioneServizioInterno> _descrizioniServizi) {
		this._descrizioniServizi = _descrizioniServizi;
	}
	/**
	 * @return the _pnlMiddleRight
	 */
	public JPanel get_pnlMiddleRight() {
		return _pnlMiddleRight;
	}
	/**
	 * @param _pnlMiddleRight the _pnlMiddleRight to set
	 */
	public void set_pnlMiddleRight(JPanel _pnlMiddleRight) {
		this._pnlMiddleRight = _pnlMiddleRight;
	}
	/**
	 * @return the _btnAggiungiServizio
	 */
	public JButton get_btnAggiungiServizio() {
		return _btnAggiungiServizio;
	}
	/**
	 * @param _btnAggiungiServizio the _btnAggiungiServizio to set
	 */
	public void set_btnAggiungiServizio(JButton _btnAggiungiServizio) {
		this._btnAggiungiServizio = _btnAggiungiServizio;
	}
}
