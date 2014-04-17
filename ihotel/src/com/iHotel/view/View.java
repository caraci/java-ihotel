/**
 * 
 */
package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

/**
 * @author Gabriele
 *
 */
@SuppressWarnings("serial")
public abstract class View extends JFrame {
	
	/* ----------------------------- Attributi e costruttore --------------------- */
	/* Factory */
	protected StyleAbstractFactory _viewFactory;
	/* ContentPane */
	protected JPanel _contentPane;
	/* 
	   La struttura della finestra è divisa in 3 pannelli, top, middle e bottom. 
	   Tutte le pagine devono rispettare questa struttura
	 */
	protected JPanel _panelTop,_panelMiddle,_panelBottom;
	/**
	 * Costruttore 
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
		_panelMiddle=_viewFactory.getPanel();
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
	 * Metodo per creare il panelTop
	 */
	protected abstract void creaPanelTop();
	/**
	 * Metodo per creare il panelMiddle
	 */
	protected abstract void creaPanelMiddle();
	/**
	 * Metodo per creare il panelBottom
	 */
	protected abstract void creaPanelBottom();

}
