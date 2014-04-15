/**
 * 
 */
package com.iHotel.view.Access;

import java.awt.Color;

import javax.swing.BorderFactory;
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
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		return panel;
	}

	
	@Override
	public JLabel getLabel() {
		JLabel label = new JLabel();
		return label;
	}
	@Override
	public JLabel getLabelIntestazione_1() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JLabel getLabelIntestazione_2() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JButton getButton() {
		JButton button = new JButton();
		return button;
	}
	@Override
	public JButton getButtonAvanti() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JTextField getTextField() {
		JTextField text = new JTextField();
		return text;
	}
	@Override
	public JCheckBox getCheckBox() {
		JCheckBox checkBox = new JCheckBox();
		return checkBox;
	}
	
	
	

}
