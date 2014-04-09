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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.MostraInformazioniServizioListener;

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
	// JPanel
	private JPanel _pnlTop;
	private JPanel _pnlMiddle;
		private JPanel _pnlMiddleLeft;
		private JPanel _pnlMiddleRight;
	private JPanel _pnlBottom;
	// JLabel
	private JLabel _lblScegliServizio;
	
	/* JComboBox */
	private JComboBox<JLabel> _comboBoxServizi;
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
		// JLabel
		_lblScegliServizio=_viewFactory.getLabel();
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
	
	public JPanel creaPanelTop() {
		
		return _pnlTop;
	}
	public JPanel creaPanelMiddle() {
		_pnlMiddle.setLayout(new GridLayout(2, 1, 10, 10));
		// Creo i pannelli destro e sinistro e li aggiungo al pnlMiddle.
		_pnlMiddle.add(creaPanelMiddleLeft());
		_pnlMiddle.add(creaPanelMiddleRight());
		return _pnlMiddle;
	}
	public JPanel creaPanelMiddleLeft() {
		
		return _pnlMiddleLeft;
	}
	public JPanel creaPanelMiddleRight() {
		
		return _pnlMiddleRight;
	}
	public JPanel creaPanelBottom() {
		
		return _pnlBottom;
	}
	
	public JPanel creaPanelListaServizi(HashMap<String,DescrizioneServizioInterno> descrizioniServizi) {
		// Setto il layout al panel.
		_pnlMiddleLeft.setLayout(new BoxLayout(_pnlMiddleLeft, BoxLayout.PAGE_AXIS));
		// Aggiungo la label al panel.
		_lblScegliServizio.setText("Scegli un servizio:");
		_pnlMiddleLeft.add(_lblScegliServizio);
		// Aggiungo spaziatura statica
		_pnlMiddleLeft.add(Box.createRigidArea(new Dimension(0,20)));
		// Ciclo sui servizi interni per creare la comboBox.
		for (Iterator<String> iterator = descrizioniServizi.keySet().iterator(); iterator.hasNext();) {
			String codiceServizio = (String) iterator.next();
			// Chiedo una nuova label alla factory e ne setto il testo.
			JLabel lblServizioInterno=_viewFactory.getLabel();
			lblServizioInterno.setText(descrizioniServizi.get(codiceServizio).get_nome());
			// Aggiungo l'eventListener alla label, e fornisco il codice del servizio.
			lblServizioInterno.addMouseListener(new MostraInformazioniServizioListener(codiceServizio));
			// Aggiungo la label alla comboBox
			_comboBoxServizi.addItem(lblServizioInterno);
		}
		_pnlMiddleLeft.add(_comboBoxServizi);
		return _pnlMiddleLeft;
	}
	public void creaFrame(HashMap<String,DescrizioneServizioInterno> descrizioniServizi) {
		// Setto titolo del frame.
		setTitle("iHotel - Gestione Prenotazione - Aggiungi servizi alla camera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Pannello per creare la lista dei servizi
		creaPanelListaServizi(descrizioniServizi);
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
