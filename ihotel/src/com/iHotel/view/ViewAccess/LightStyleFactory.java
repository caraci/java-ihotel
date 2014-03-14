/**
 * 
 */
package com.iHotel.view.ViewAccess;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	public JLabel gelLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
