/**
 * 
 */
package com.iHotel.view;

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
public class ViewPanel extends JPanel {

	/**
	 * Factory dei componenti grafici.
	 */
	private StyleAbstractFactory _viewFactory;
	/**
	 * Costruttore
	 */
	public ViewPanel() {
		super();
		// Prendo la factory dei componenti dell'interfaccia
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		// Setto il colore di sfondo del pannello.
		this.setBackground(_viewFactory.getColorContentPane());
	}
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

}
