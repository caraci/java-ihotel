/**
 * 
 */
package com.iHotel.view.Utility;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.view.Access.ViewFactory;

/**
 * Classe che ha il compito di generare un pannello per inserire l'orario.
 * 
 * @author Alessandro
 *
 */
public class UMostraOrario {
	
	/*Attributi e costruttore*/
	
	private ViewFactory _viewF
	
	/** Pattern Singleton*/
	private UMostraOrario instance;
	
	private JPanel _panelOrario;
	private JLabel _ore, _minuti;
	
	private UMostraOrario(){
		_panelOrario = _
	}
	
	/**
	 * Pattern Singleton
	 * @return istanza singola di UMostraOrario
	 */
	public UMostraOrario getInstance(){
		if (instance == null){
			instance = new UMostraOrario();
		}
		return instance;
	}

}
