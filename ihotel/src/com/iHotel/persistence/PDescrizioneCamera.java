/**
 * 
 */
package com.iHotel.persistence;

import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;

/**
 * @author Eugenio
 *
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
	
}
