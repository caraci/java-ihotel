/**
 * 
 */
package com.iHotel.persistence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;

/**
 * Classe addetta alla persistenza per la classe DescrizioneCamera.
 * 
 * @author Eugenio
 */
public class PDescrizioneCamera extends PersistentManager{
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PDescrizioneCamera instance=null;
	/**
	 * Costruttore privato - Pattern Singleton.
	 */
	private PDescrizioneCamera(){}
	
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 */
	public static PDescrizioneCamera getInstance(){
		if(instance == null) {
            instance = new PDescrizioneCamera();
         }
         return instance;
	}
	/*--------------------- Metodi di instanza ------------------------- */
	/**
	 * Metodo per caricare tutte le descrizioni delle camere presenti nella base dati.
	 * 
	 * @return L'insieme delle descrizioni delle camere.
	 */
	public List<DescrizioneCamera> caricaDescrizioniCamere() {
		@SuppressWarnings("serial")
		List<DescrizioneCamera> descrizioniCamere = query(new Predicate<DescrizioneCamera>() {
			public boolean match(DescrizioneCamera candidate) {
				return true;
			}
		});
		return descrizioniCamere;
	}
	/**
	 * Metodo per caricare la mappa dei descrittori.
	 * 
	 * @return Mappa dove la chiave è il codice del descrittore, e il valore è il descrittore.
	 */
	public HashMap<String, DescrizioneCamera> caricaMappaCodiceDescrittoreCamera() {
		@SuppressWarnings("serial")
		List<DescrizioneCamera> listDescrizioniCamere = query(new Predicate<DescrizioneCamera>() {
			public boolean match(DescrizioneCamera candidate) {
				return true;
			}
		});
		// Creo la mappa
		HashMap<String,DescrizioneCamera> descrizioniCamere = new HashMap<String,DescrizioneCamera>();
		// Ciclo sui descrittori
		for (Iterator<DescrizioneCamera> iterator = listDescrizioniCamere.iterator(); iterator.hasNext();) {
			DescrizioneCamera descrizioneCamera = (DescrizioneCamera) iterator.next();
			descrizioniCamere.put(descrizioneCamera.get_tipologia(), descrizioneCamera);
		}
		return descrizioniCamere;
	}
	
}
