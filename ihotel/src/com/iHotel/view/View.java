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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

/**
 * Classe a capo della gerarchia di tutte le finestre, dell'applicazione. Definisce una struttra di base per le finestre, e 
 * dei metodi di base da implementare.
 * 
 * @author Gabriele
 */
@SuppressWarnings("serial")
public abstract class View extends JFrame {
	
	/* ----------------------------- Attributi e costruttore --------------------- */
	/* ContentPane */
	protected JPanel _contentPane;
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
	/* Factory */
	protected StyleAbstractFactory _viewFactory;
	/**
	 * Costruttore.
	 */
	protected View(){
		// Richiedo la factory corretta.
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		// Setto il contentPane
		_contentPane=_viewFactory.getContentPane();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Aggiungo il contentPane al Frame
		setContentPane(_contentPane);
		// Operazione di default in chiusura.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(50, 50, 1280, 700);
		
		//ora preparo il layout interno al contentPane
		
		//prendo i pannelli
		_panelTop=_viewFactory.getPanel();
		_panelMiddle=_viewFactory.getPanelMiddle();
		_panelBottom=_viewFactory.getPanel();
		
		//Aggiungo i pannelli al contentPane
		_contentPane.add(_panelTop,BorderLayout.PAGE_START);
		_contentPane.add(_panelMiddle,BorderLayout.CENTER);
		_contentPane.add(_panelBottom,BorderLayout.PAGE_END);
		
		//Setto le dimensioni dei pannelli in base alla dimensione della schermata.
		/*	il panelTop è alto il 10% della pagina,
		 * 	il panelMiddle è alto l'70%, 
		 * 	il panelBottom è alto il 10%
		 */
		_panelTop.setPreferredSize(new Dimension((int)(0.95*getWidth()),(int)((0.09)*(getHeight()))));
		_panelMiddle.setPreferredSize(new Dimension((int)(0.95*getWidth()),(int)((0.7)*(getHeight()))));
		_panelBottom.setPreferredSize(new Dimension((int)(0.95*getWidth()), (int)((0.09)*(getHeight()))));	
	}
	/* ----------------------------- Metodi di instanza ---------------------------- */
	/**
	 * Metodo per rimuovere l'instanza, dall'attributo statico.
	 */
	public abstract void removeInstance();
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
	 * @return Pannello contenente i bottoni
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
