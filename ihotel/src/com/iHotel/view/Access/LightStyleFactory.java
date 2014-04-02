/**
 * 
 */
package com.iHotel.view.Access;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Eugenio
 *
 */
public class LightStyleFactory implements StyleAbstractFactory {

	/* -------------------------------- Attributi e costruttore -------------------------------*/
	private static LightStyleFactory instance = null;
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private LightStyleFactory() {}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return CGestisciPrenotazione Instanza unica di questa classe
	 */
    public static LightStyleFactory getInstance() {
    	if(instance == null) {
            instance = new LightStyleFactory();
         }
         return instance;
    }
    /* --------------------------------- Metodi di instanza -------------------------------------- */
	@Override
	public JPanel getPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		return panel;
	}

	
	@Override
	public JLabel getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JCheckBox getCheckBox() {
		// TODO Auto-generated method stub
		return null;
	}

}
