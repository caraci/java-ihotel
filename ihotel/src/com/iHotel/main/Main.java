package com.iHotel.main;

import com.iHotel.utility.UStartup;
import com.iHotel.view.ViewFrame;

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException {	
		// Inizializzo lo strato di dominio.
		UStartup startup = new UStartup();
		startup.inizializza();
		// Creo il frame dell'applicazione
		ViewFrame viewFrame = ViewFrame.getInstance();
		// Mostro il frame
		viewFrame.setVisible(true);
	}
}
