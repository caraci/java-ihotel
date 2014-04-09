/**
 * 
 */
package com.iHotel.view;

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
public class View extends JFrame {
	
	/* Factory */
	protected StyleAbstractFactory _viewFactory;
	/* ContentPane */
	protected JPanel _contentPane;
	
	protected View(){
		// Richiedo la factory corretta.
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		// Setto il contentPane
		_contentPane=_viewFactory.getPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Aggiungo il contentPane al Frame
		setContentPane(_contentPane);
		// Operazione di default in chiusura.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(50, 50, 1024, 500);	
	}

}
