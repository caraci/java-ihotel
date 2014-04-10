/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

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

import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.MostraDettagliServizioListener;

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
	private JPanel _pnlTop;
	private JPanel _pnlMiddle;
		private JPanel _pnlMiddleLeft;
		private JPanel _pnlMiddleRight;
	private JPanel _pnlBottom;
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
		_pnlTop=_viewFactory.getPanel();
		_pnlMiddle=_viewFactory.getPanel();
		_pnlMiddleLeft=_viewFactory.getPanel();
		_pnlMiddleRight=_viewFactory.getPanel();
		_pnlBottom=_viewFactory.getPanel();
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
	
	/**
	 * Metodo per creare il pannello superiore.
	 * @return Pannello superiore.
	 */
	public JPanel creaPanelTop() {
		// Setto il layout al panel
		_pnlTop.setLayout(new GridLayout(2, 1, 10, 10));
		// Setto il testo alla label
		_lblAggiungiServizi.setText("Aggiungi servizi per la camera" + _camera.get_numero() + " :");
		// Aggiungo la label al panel
		_pnlTop.add(_lblAggiungiServizi);
		return _pnlTop;
	}
	/**
	 * Metodo per creare il pannello centrale
	 * @return Pannello centrale.
	 */
	public JPanel creaPanelMiddle() {
		// Setto il layout al panel
		_pnlMiddle.setLayout(new GridLayout(1, 2, 10, 10));
		// Creo i pannelli destro e sinistro e li aggiungo al pnlMiddle.
		_pnlMiddle.add(creaPanelMiddleLeft());
		_pnlMiddle.add(creaPanelMiddleRight());
		return _pnlMiddle;
	}
	/**
	 * Metodo per creare il pannello contenente la lista dei servizi interni.
	 * @return Pannello centrale sinistro.
	 */
	public JPanel creaPanelMiddleLeft() {
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
	public JPanel creaPanelMiddleRight() {
		// Setto il layout al panel
		_pnlMiddleRight.setLayout(new BoxLayout(_pnlMiddleRight, BoxLayout.PAGE_AXIS));
		// Setto il testo della Label
		_lblScegliServizio.setText("Aggiungi un servizio, scegliendo tra uno di quelli proposti.");
		// Aggiungo la Label al panel
		_pnlMiddleRight.add(_lblScegliServizio);
		return _pnlMiddleRight;
	}
	/**
	 * Metodo per creare il pannello inferiore della pagina, quello contenente i bottoni per tornare alla pagina
	 * precedente e per aggiungere il servizio in analisi.
	 * @return Pannello inferiore.
	 */
	public JPanel creaPanelBottom() {
		_pnlBottom.setLayout(new GridLayout(1, 2, 5, 30));
		// Setto il testo ai bottoni
		_btnAggiungiServizio.setText("Aggiungi servizio");
		_btnTornaAllaCamera.setText("Torna alla camera");
		// Setto il pulsante per aggiungere un servizio disabilitato
		_btnAggiungiServizio.setEnabled(false);
		// Aggiungo i bottoni al pannello
		_pnlBottom.add(_btnTornaAllaCamera);
		_pnlBottom.add(_btnAggiungiServizio);
		return _pnlBottom;
	}
	
	public void creaFrame(HashMap<String,DescrizioneServizioInterno> descrizioniServizi, CameraContext camera) {
		// Setto titolo del frame.
		setTitle("iHotel - Gestione Prenotazione - Aggiungi servizi alla camera");
		// Pannello per creare la lista dei servizi
		_contentPane.setLayout(new BoxLayout(_contentPane, BoxLayout.PAGE_AXIS));
		// Setto gli attributi dell'interfaccia attraverso ciò che ricevo per parametro.
		_camera = camera;
		_descrizioniServizi=descrizioniServizi;
		// Aggiungo i pannelli al _contentPane
		_contentPane.add(creaPanelTop());
		_contentPane.add(creaPanelMiddle());
		_contentPane.add(creaPanelBottom());
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
}
