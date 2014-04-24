/**
 * 
 */
package com.iHotel.view.Access;

import com.iHotel.utility.UDefaultLoader;

/**
 * @author Eugenio
 *
 */
public class ViewFactory {
	/* Singleton */
	private static ViewFactory instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private ViewFactory() {}
	/**
	 * Metodo per ottenere l'instanza unica di questa classe - Pattern Singleton.
	 */
	public static ViewFactory getInstance() {
		if(instance==null) {
			instance = new ViewFactory();
		}
		return instance;
	}
	/**
	 * Metodo per fornire la factory per la creazione dell'interfaccia grafica secondo un certo stile.
	 * @return Factory che fornisce i componenti grafici.
	 */
	public StyleAbstractFactory getStyleFactory() {
		// Leggo da file esterno quale Factory utilizzare
        String stile = UDefaultLoader.getInstance().getStileInterfaccia();
        // Factory da restituire
        StyleAbstractFactory styleAbstractFactory;
        switch (stile) {
		case "light":
			styleAbstractFactory = LightStyleFactory.getInstance();
			break; 
		case "dark":
			styleAbstractFactory = DarkStyleFactory.getInstance();
			break;
		default:
			// Di default fornisco la factory "light"
			styleAbstractFactory = LightStyleFactory.getInstance();
			break;
		}
		return styleAbstractFactory;
	}
}
