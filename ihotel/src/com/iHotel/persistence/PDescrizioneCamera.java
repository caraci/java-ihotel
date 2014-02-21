/**
 * 
 */
package com.iHotel.persistence;

import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.MDescrizioneCamera;

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
	 * @return
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
	public List<MDescrizioneCamera> caricaDescrizioniCamere() {
		@SuppressWarnings("serial")
		List<MDescrizioneCamera> descrizioniCamere = query(new Predicate<MDescrizioneCamera>() {
			public boolean match(MDescrizioneCamera candidate) {
				return true;
			}
		});
		return descrizioniCamere;
	}
	
}
