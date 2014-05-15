/**
 * 
 */
package com.iHotel.view.Access;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


/**
 * Classe addetta alla fornitura di elementi grafici di uno stile "Light".
 * 
 * @author Eugenio
 */
public class LightStyleFactory implements StyleAbstractFactory {

	/* -------------------------------- Attributi e costruttore -------------------------------*/

	//singleton
	private static LightStyleFactory instance = null;
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private LightStyleFactory() {}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
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
		panel.setBackground(new Color(200, 200, 200));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		return panel;
	}
	@Override
	public JPanel getContentPane() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		return panel;
	}
	
	@Override
	public JTabbedPane getTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();
		return tabbedPane;
	}
	
	@Override
	public JScrollPane getScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(200, 200, 200));
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
		return scrollPane;
	}
	
	@Override
	public JLabel getLabel() {
		JLabel label = new JLabel();
		label.setBackground(new Color(150, 150, 150));
		label.setForeground(new Color(20,20,20));
		return label;
	}
	@Override
	public JLabel getLabelIntestazione_1() {
		JLabel label=getLabel();
		// Setto il font.
		Font font = new Font("Serif", Font.BOLD, 20);
		label.setFont(font);
		return label;
	}
	@Override
	public JLabel getLabelIntestazione_2() {
		JLabel label=getLabel();
		// Setto il font.
		Font font = new Font("Serif", Font.BOLD, 16);
		label.setFont(font);
		return label;	}
	@Override
	public JButton getButton() {
		JButton button = new JButton();
		button.setBackground(new Color(240, 240, 240));
		button.setForeground(new Color(30,30,30));
		return button;
	}
	@Override
	public JButton getButtonAvanti() {
		JButton button=getButton();
		// Setto il font.
		Font font = new Font("Serif", Font.BOLD, 12);
		button.setFont(font);
		// Setto colori - Sfondo Vere - Testo Nero
		button.setBackground(new Color(127,255,0));
		button.setForeground(new Color(0,0,0));
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
		checkBox.setBackground(new Color(200, 200, 200));
		checkBox.setForeground(new Color(0, 0, 0));
		return checkBox;
	}
	@Override
	public JPanel getPanelMiddle() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		return panel;
	}
}
