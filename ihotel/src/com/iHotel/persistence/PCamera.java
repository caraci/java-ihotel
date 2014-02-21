/**
 * 
 */
package com.iHotel.persistence;

import java.util.List;
import com.db4o.query.Predicate;
import com.iHotel.model.MCamera;

/**
 * @author Eugenio
 *
 */
public class PCamera extends PersistentManager {
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PCamera instance=null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private PCamera(){}
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 * @return
	 */
	public static PCamera getInstance(){
		if(instance == null) {
            instance = new PCamera();
         }
         return instance;
	}
	/* ------------------- Metodi di instanza -------------------------- */
	/**
	 * Metodo per caricare tutte le camere presenti nella base dati.
	 * @return L'insieme delle camere dell'albergo.
	 */
	public List<MCamera> caricaCamere() {
		@SuppressWarnings("serial")
		List<MCamera> camere = query(new Predicate<MCamera>() {
			public boolean match(MCamera candidate) {
				return true;
			}
		});
		return camere;
	}
}
