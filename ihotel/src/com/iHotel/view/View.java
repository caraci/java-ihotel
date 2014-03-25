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
public class View extends JFrame {
	
	/* Factory */
	protected StyleAbstractFactory _creaPrenotazioneFactory;
	
	protected View(){
		// Richiedo la factory corretta.
		_creaPrenotazioneFactory=ViewFactory.getInstance().getStyleFactory();
	}

}
