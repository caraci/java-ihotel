/**
 * 
 */
package com.iHotel.utility;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.persistence.PCamera;
import com.iHotel.persistence.PDescrizioneCamera;
import com.iHotel.persistence.PDescrizioneServiziInterni;
import com.iHotel.persistence.PPrenotazione;

/**
 * Classe addetta alla realizzazione dello strato di dominio.
 *  
 * @author Eugenio
 */
public class UStartup {
	/**
	 * Metodo per inizializzare il catalogo delle camere.
	 * 
	 * @return Catalogo delle camere.
	 */
	private static CatalogoCamere inizializzaCatalogoCamere() {
		// Recupero il catalogo delle camere attraverso pattern Singleton
		CatalogoCamere catalogoCamere = CatalogoCamere.getInstance();
		// Setto gli attributi del catalogoCamere
		catalogoCamere.set_descrizioniCamere(PDescrizioneCamera.getInstance().caricaMappaCodiceDescrittoreCamera());
		
		return catalogoCamere;
	}
	/**
	 * Metodo per inizializzare il catalogo dei servizi interni.
	 * 
	 * @return Catalogo dei servizi interni.
	 */
	private static CatalogoServiziInterni inizializzaCatalogoServiziInterni() {
		// Recupero il catalogo dei servizi attraverso pattern Singleton
		CatalogoServiziInterni catalogoServiziInterni = CatalogoServiziInterni.getInstance();
		// Setto gli attributi del CatalogoServiziInterni
		catalogoServiziInterni.set_descrizioneServizi(PDescrizioneServiziInterni.getInstance().caricaMappaCodiceDescrittoreServizi());
		
		return catalogoServiziInterni;
	}
	/**
	 * Metodo per ottenere lo storico delle prenotazioni dell'albergo.
	 * 
	 * @return Storico delle prenotazioni dell'albergo.
	 */
	private static Storico inizializzaStorico() {
		// Recupero lo storico attraverso pattern Singleton
		Storico storico = Storico.getInstance();
		// Setto gli attributi dello storico.
		storico.set_soggiorni(PPrenotazione.getInstance().caricaMappaCodicePrenotazione());
		
		return storico;
	}
	/**
	 * Metodo per inizializzare lo strato di dominio.
	 */
	public static void inizializza() {
		try {
			// Mediante pattern singleton carico Albergo.
			Albergo albergo = Albergo.getInstance();
			// Setto gli attributi dell'albergo
			albergo.set_camere(PCamera.getInstance().caricaCamere());
			inizializzaCatalogoServiziInterni();
			inizializzaCatalogoCamere();	
			inizializzaStorico();
		} catch (Exception e) {
			// Mediante pattern singleton carico Albergo.
			Albergo albergo = Albergo.getInstance();
			// Setto tutti gli attributi a null.
			albergo.set_camere(null);
		}
	}
}
