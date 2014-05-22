/**
 * 
 */
package com.iHotel.view.Utility;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

/**
 * Classe che ha il compito di generare un pannello per inserire l'orario.
 * 
 * @author Alessandro
 *
 */
public class UMostraOrario {
	
	/*Attributi e costruttore*/
	
	private StyleAbstractFactory _viewFactory;
	
	/** Pattern Singleton*/
	private static UMostraOrario instance;
	
	private JPanel _panelOrario;
	private JLabel _lblOre, _lblMinuti;
	private JComboBox<String> _ore;
	private JComboBox<String> _minuti;
	
	
	private UMostraOrario(){
		_viewFactory = ViewFactory.getInstance().getStyleFactory();
		_panelOrario = _viewFactory.getPanel();
		_lblOre = _viewFactory.getLabel();
		_lblMinuti = _viewFactory.getLabel();
		_ore = new JComboBox<String>();
		_minuti = new JComboBox<String>();
	}
	
	/**
	 * Pattern Singleton
	 * @return istanza singola di UMostraOrario
	 */
	public static UMostraOrario getInstance(){
		if (instance == null){
			instance = new UMostraOrario();
		}
		return instance;
	}
	
	public JPanel creaOrarioDefault(){
		_panelOrario.setLayout(new GridLayout(1, 4,5,5));
		_panelOrario.setBackground(_viewFactory.getColorContentPane());
		//Creo la combobox per i minuti
		for(int i = 0; i<60;i++){
			_minuti.addItem(String.valueOf(i));
		}
		//Creo la combobox per le ore
		for (int i = 0; i<24;i++){
			_ore.addItem(String.valueOf(i));
		}
		/*Label*/
		_lblMinuti.setText("Minuti: ");
		_lblOre.setText("Ore: ");
		
		_panelOrario.add(_lblOre, 0);
		_panelOrario.add(_ore,1);
		_panelOrario.add(_lblMinuti,2);
		_panelOrario.add(_minuti,3);
		
		return _panelOrario;
		
		
		
	}

}
