package com.iHotel.view.ViewAccess;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		return panel;
	}

	@Override
	public JLabel gelLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
