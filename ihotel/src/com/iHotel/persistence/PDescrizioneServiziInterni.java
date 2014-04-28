/**
 * 
 */
package com.iHotel.persistence;

import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;

/**
 * Classe addetta alla persistenza per la classe DescrizioneServizioInterno.
 * 
 * @author Eugenio
 */
public class PDescrizioneServiziInterni extends PersistentManager {

	/* -------------------- Attributi e costruttore ---------------------- */
	private static PDescrizioneServiziInterni instance=null;
	/**
	 * Costruttore privato - Pattern Singleton.
	 */
	private PDescrizioneServiziInterni(){}
	
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 */
	public static PDescrizioneServiziInterni getInstance(){
		if(instance == null) {
            instance = new PDescrizioneServiziInterni();
         }
         return instance;
	}
	/*--------------------- Metodi di instanza ------------------------- */
	/**
	 * Metodo per caricare tutte le descrizioni dei servizi presenti nella base dati.
	 * 
	 * @return L'insieme delle descrizioni dei servizi interni
	 */
	public List<DescrizioneServizioInterno> caricaDescrizioniServizi() {
		@SuppressWarnings("serial")
		List<DescrizioneServizioInterno> descrizioniServiziInterni = query(new Predicate<DescrizioneServizioInterno>() {
			public boolean match(DescrizioneServizioInterno candidate) {
				return true;
			}
		});
		return descrizioniServiziInterni;
	}
}
