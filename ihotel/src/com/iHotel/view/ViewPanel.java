/**
 * 
 */
package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public abstract class ViewPanel extends JPanel {
	
	/**
	 * Pannello superiore della pagina.
	 */
	protected JPanel _panelTop;
	/**
	 * Pannello centrale della pagina.
	 */
	protected JPanel _panelMiddle;
	/**
	 * Pannello inferiore della pagina.
	 */
	protected JPanel _panelBottom;
	/**
	 * Factory dei componenti grafici.
	 */
	protected StyleAbstractFactory _viewFactory;
	/**
	 * Costruttore
	 */
	protected ViewPanel() {
		super();
		// Prendo la factory dei componenti dell'interfaccia
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		// Setto il colore di sfondo del pannello.
		setBackground(_viewFactory.getColorContentPane());
		// Setto il bordo al pannello
		setBorder(new EmptyBorder(5, 5, 5, 5));
		// Setto layout al panel
		setLayout(new BorderLayout());
		
		// Creo i pannelli
		_panelTop=_viewFactory.getPanel();
		_panelMiddle=_viewFactory.getPanelMiddle();
		_panelBottom=_viewFactory.getPanel();
		
		// Setto le dimensioni dei pannelli in base alla dimensione della schermata.
		/*	il panelTop � alto il 10% della pagina,
		 * 	il panelMiddle � alto l'70%, 
		 * 	il panelBottom � alto il 10%
		 */
		// Altezza, Larghezza - Pannello
		int pnlWidth = getWidth();
		int pnlHeight = getHeight();
		
		// Dimensioni pannelli top, middle, bottom.
		Dimension dimTop = new Dimension((int)(0.95*pnlWidth),(int)((0.09)*(pnlHeight)));
		Dimension dimMiddle = new Dimension((int)(0.95*pnlWidth),(int)((0.7)*(pnlHeight)));
		Dimension dimBottom = new Dimension((int)(0.95*pnlWidth),(int)((0.09)*(pnlHeight)));
		
		// Setto le dimensioni preferite dei pannelli
		_panelTop.setPreferredSize(dimTop);
		_panelMiddle.setPreferredSize(dimMiddle);
		_panelBottom.setPreferredSize(dimBottom);
		
		// Aggiungo i pannelli al contentPane
		add(_panelTop, BorderLayout.PAGE_START);
		add(_panelMiddle, BorderLayout.CENTER);
		add(_panelBottom, BorderLayout.PAGE_END);
	}
	
	/* -------------------------------- Metodi di istanza ----------------------------------- */

	/**
	 * Metodo per creare il panelTop.
	 */
	protected abstract void creaPanelTop();
	/**
	 * Metodo per creare il panelMiddle.
	 */
	protected abstract void creaPanelMiddle();
	/**
	 * Metodo per creare il panelBottom.
	 */
	protected abstract void creaPanelBottom();
	/**
	 * Metodo per creare un pannello con un certo numero di pulsanti.
	 * 
	 * @param panel Pannello sul quale si vuole creare la pulsantiera.
	 * @param numeroColonne Numero di colonne nel quale si vuole effettuare la suddivisione della larghezza.
	 * @param Bottoni Bottoni che si vogliono inserire.
	 */
	protected void creaPanelPulsanti(JPanel panel, int numeroColonne, HashMap<Integer, JButton> Bottoni) {
		// Setto layout
		panel.setLayout(new GridLayout(1, numeroColonne, 0, 5));
		// Lista dei pannelli
		JPanel[] panelHolder = new JPanel[numeroColonne]; 
		// Aggiungo un pannello per ogni colonna che si vuole usare
		for (int i = 0; i < numeroColonne; i++) {
			panelHolder[i]=_viewFactory.getPanel();
			// Aggiungo del margine
			panelHolder[i].setBorder(new EmptyBorder(5, 5, 5, 5));
			// Aggiungo gestore del layout a griglia per adattare il componente da inserire alla dimensione del pannello
			panelHolder[i].setLayout(new GridLayout(1,1,0,0));
			// Aggiungo il pannello[i] al pannello da editare.
			panel.add(panelHolder[i]);
		}
		// Ciclo sulla mappa dei bottoni e li dispongo nella giusta posizione
		for (Iterator<Integer> iterator = Bottoni.keySet().iterator(); iterator.hasNext();) {
			Integer indicePannello = (Integer) iterator.next();
			// Bottone da aggiungere.
			JButton bottone = Bottoni.get(indicePannello);
			// Aggiungo il bottone al giusto pannello
			panelHolder[indicePannello].add(bottone);	
			// Adatto il bottone al panel padre.		
		}
	}

	/* -------------------------------- Getter, Setter ------------------------------------- */

	/**
	 * @return the _panelTop
	 */
	protected JPanel get_panelTop() {
		return _panelTop;
	}
	/**
	 * @param _panelTop the _panelTop to set
	 */
	protected void set_panelTop(JPanel _panelTop) {
		this._panelTop = _panelTop;
	}
	/**
	 * @return the _panelMiddle
	 */
	protected JPanel get_panelMiddle() {
		return _panelMiddle;
	}
	/**
	 * @param _panelMiddle the _panelMiddle to set
	 */
	protected void set_panelMiddle(JPanel _panelMiddle) {
		this._panelMiddle = _panelMiddle;
	}
	/**
	 * @return the _panelBottom
	 */
	protected JPanel get_panelBottom() {
		return _panelBottom;
	}
	/**
	 * @param _panelBottom the _panelBottom to set
	 */
	protected void set_panelBottom(JPanel _panelBottom) {
		this._panelBottom = _panelBottom;
	}
	/**
	 * @return the _viewFactory
	 */
	protected StyleAbstractFactory get_viewFactory() {
		return _viewFactory;
	}
	/**
	 * @param _viewFactory the _viewFactory to set
	 */
	protected void set_viewFactory(StyleAbstractFactory _viewFactory) {
		this._viewFactory = _viewFactory;
	}
}
