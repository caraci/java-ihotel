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
	/**
	 * Factory componenti grafici
	 */
	private StyleAbstractFactory _viewFactory;
	
	/** Pattern Singleton*/
	private static UMostraOrario instance;
	
	/**
	 * JPanel che conterrà l'orario
	 */
	private JPanel _panelOrario;
	/**
	 * JLabel con informazioni su ore e minuti
	 */
	private JLabel _lblOre, _lblMinuti;
	
	/**
	 * JComboBox contenenti l'elenco delle ore e dei minuti
	 */
	private JComboBox<String> _ore,_minuti;
	
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private UMostraOrario(){
		//Setto la factory degli elementi grafici
		_viewFactory = ViewFactory.getInstance().getStyleFactory();		
		/*JPanel*/
		_panelOrario = _viewFactory.getPanel();
		/*JLabel*/
		_lblOre = _viewFactory.getLabel();
		_lblMinuti = _viewFactory.getLabel();
		/*JComboBox*/
		_ore = new JComboBox<String>();
		_minuti = new JComboBox<String>();
	}
	
	/**
	 * Pattern Singleton
	 * 
	 * @return istanza singola di UMostraOrario
	 */
	public static UMostraOrario getInstance(){
		if (instance == null){
			instance = new UMostraOrario();
		}
		return instance;
	}
	
	/**
	 * Metodo che crea il pannello contenente le combobox di ora e minuti
	 * 
	 * @return il pannello contenente le etichette e le combobox
	 */
	public JPanel creaOrarioDefault(){
		/*Setto il layout a 1 riga e 4 colonne*/
		_panelOrario.setLayout(new GridLayout(1, 4, 5, 5));
		/*Setto il colore*/
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
		
		/*Aggiungo gli elementi al pannello, con la posizione corretta*/
		_panelOrario.add(_lblOre, 0);
		_panelOrario.add(_ore,1);
		_panelOrario.add(_lblMinuti,2);
		_panelOrario.add(_minuti,3);
		
		/*Restituisco il pannello*/
		return _panelOrario;	
	}
	/**
	 * Metodo che restituisce l'ora selezionata nella combobox delle ore
	 * 
	 * @return Ora selezionata
	 */
	public int getOraSelezionata(){
		//Recupero il valore selezionato dalla combobox
		String ora = (String) _ore.getSelectedItem();
		//Restituisco il valore
		return Integer.parseInt(ora);
	}
	
	/**
	 * Metodo che restituisce i minuti selezionati nella combobox dei minuti
	 * 
	 * @return minuto selezionato
	 */
	public int getMinutoSelezionato(){
		//Recupero il valore selezionato dalla combobox
		String minuti = (String) _minuti.getSelectedItem();
		//Restituisco il valore
		return Integer.parseInt(minuti);
	}
}

