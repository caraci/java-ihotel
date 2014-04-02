/**
 * 
 */
package com.iHotel.view;

import javax.swing.JFrame;

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
	
	protected View(){
		// Richiedo la factory corretta.
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
	}

}
