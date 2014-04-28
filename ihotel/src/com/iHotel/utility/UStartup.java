/**
 * 
 */
package com.iHotel.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
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
	public CatalogoCamere getCatalogoCamere() {
		// Carico tutte le descrizioni delle camere
		List<DescrizioneCamera> descrizioniCamere = PDescrizioneCamera.getInstance().caricaDescrizioniCamere();
		// Recupero il catalogo delle camere attraverso pattern Singleton
		CatalogoCamere catalogoCamere = CatalogoCamere.getInstance();
		// Setto gli attributi del catalogoCamere
		HashMap<String,DescrizioneCamera> _descrizioniCamere = new HashMap<String,DescrizioneCamera>();
		for (Iterator<DescrizioneCamera> iterator = descrizioniCamere.iterator(); iterator.hasNext();) {
			DescrizioneCamera descrizioneCamera = (DescrizioneCamera) iterator.next();
			_descrizioniCamere.put(descrizioneCamera.get_tipologia(), descrizioneCamera);
		}
		catalogoCamere.set_descrizioniCamere(_descrizioniCamere);
		
		return catalogoCamere;
	}
	/**
	 * Metodo per inizializzare il catalogo dei servizi interni.
	 * @return Catalogo dei servizi interni.
	 */
	public CatalogoServiziInterni getCatalogoServiziInterni() {
		// Carico tutte le descrizioni dei servizi
		List<DescrizioneServizioInterno> descrizioniServiziInterni = PDescrizioneServiziInterni.getInstance().caricaDescrizioniServizi();
		// Recupero il catalogo dei servizi attraverso pattern Singleton
		CatalogoServiziInterni catalogoServiziInterni = CatalogoServiziInterni.getInstance();
		// Setto gli attributi del CatalogoServiziInterni
		HashMap<String, DescrizioneServizioInterno> _descrizioniServizi = new HashMap<String,DescrizioneServizioInterno>();
		for (Iterator<DescrizioneServizioInterno> iterator = descrizioniServiziInterni.iterator(); iterator.hasNext();) {
			DescrizioneServizioInterno descrizioneServizio = (DescrizioneServizioInterno) iterator.next();
			_descrizioniServizi.put(descrizioneServizio.get_codice(), descrizioneServizio);
		}
		catalogoServiziInterni.set_descrizioneServizi(_descrizioniServizi);
		
		return catalogoServiziInterni;
	}
	/**
	 * Metodo per ottenere lo storico delle prenotazioni dell'albergo.
	 * 
	 * @return Storico delle prenotazioni dell'albergo.
	 */
	public Storico getStorico() {
		// Carico tutte le prenotazioni
		List<PrenotazioneSubject> prenotazioni = PPrenotazione.getInstance().caricaPrenotazioni();
		// Recupero lo storico attraverso pattern Singleton
		Storico storico = Storico.getInstance();
		// Setto gli attributi dello storico
		HashMap<String,PrenotazioneSubject> _prenotazioni = new HashMap<String,PrenotazioneSubject>();
		for (Iterator<PrenotazioneSubject> iterator = prenotazioni.iterator(); iterator.hasNext();) {
			PrenotazioneSubject prenotazioneSubject = (PrenotazioneSubject) iterator.next();
			_prenotazioni.put(prenotazioneSubject.get_codice(), prenotazioneSubject);				
		}
		storico.set_prenotazioni(_prenotazioni);
		
		return storico;
	}
	/**
	 * Metodo per inizializzare lo strato di dominio.
	 */
	public void inizializza() {
		try {
			// Mediante pattern singleton carico Albergo.
			Albergo albergo = Albergo.getInstance();
			// Setto gli attributi dell'albergo
			albergo.set_camere(PCamera.getInstance().caricaCamere());
			albergo.set_catalogoServizi(getCatalogoServiziInterni());
			albergo.set_catalogoCamere(getCatalogoCamere());	
			albergo.set_storico(getStorico());
		} catch (Exception e) {
			// Mediante pattern singleton carico Albergo.
			Albergo albergo = Albergo.getInstance();
			// Setto tutti gli attributi a null.
			albergo.set_camere(null);
			albergo.set_catalogoServizi(null);
			albergo.set_catalogoCamere(null);	
			albergo.set_storico(null);
		}
	}
}
