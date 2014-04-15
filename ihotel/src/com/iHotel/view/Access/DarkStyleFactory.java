package com.iHotel.view.Access;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DarkStyleFactory implements StyleAbstractFactory {

	/* -------------------------------- Attributi e costruttore -------------------------------*/
	private static DarkStyleFactory instance = null;
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private DarkStyleFactory() {}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return CGestisciPrenotazione Instanza unica di questa classe
	 */
    public static DarkStyleFactory getInstance() {
    	if(instance == null) {
            instance = new DarkStyleFactory();
         }
         return instance;
    }
    /* --------------------------------- Metodi di instanza -------------------------------------- */
	@Override
	public JPanel getPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(BorderFactory.createLineBorder(Color.white));
		return panel;
	}

	@Override
	public JLabel getLabel() {
		JLabel label = new JLabel();
		label.setBackground(new Color(30, 30, 30));
		label.setForeground(new Color(255,255,255));
		return label;
	}
	
	@Override
	public JButton getButton(){
		JButton button = new JButton();
		button.setBackground(new Color(50, 50, 50));
		button.setForeground(new Color(255,255,255));
		return button;
	}
	@Override
	public JTextField getTextField() {
		JTextField text = new JTextField();
		text.setBackground(new Color(255, 255, 255));
		text.setForeground(new Color(0, 0, 0));
		return text;
	}
	@Override
	public JCheckBox getCheckBox() {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setBackground(new Color(255, 255, 255));
		checkBox.setForeground(new Color(0, 0, 0));
		return checkBox;
	}

}
