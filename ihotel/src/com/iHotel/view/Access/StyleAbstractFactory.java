/**
 * 
 */
package com.iHotel.view.Access;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Eugenio
 *
 */
public interface StyleAbstractFactory {
	public JPanel getPanel();
	public JLabel getLabel();
	public JLabel getLabelIntestazione_1();
	public JLabel getLabelIntestazione_2();
	public JButton getButton();
	public JButton getButtonAvanti();
	public JTextField getTextField();
	public JCheckBox getCheckBox();
}
