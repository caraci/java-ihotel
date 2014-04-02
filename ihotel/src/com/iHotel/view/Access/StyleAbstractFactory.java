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
	public JButton getButton();
	public JTextField getTextField();
	public JCheckBox getCheckBox();
}
