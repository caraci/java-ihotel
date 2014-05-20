/**
 * 
 */
package com.iHotel.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.Camera.Camera;

/**
 * Classe addetta alla persistenza per la classe CameraContext.
 * 
 * @author Eugenio
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
	 * 
	 * @return L'insieme delle camere dell'albergo.
	 */
	public ArrayList<Camera> caricaCamere() {
		@SuppressWarnings("serial")
		List<Camera> camere = query(new Predicate<Camera>() {
			public boolean match(Camera candidate) {
				return true;
			}
		});
		// Creo la lista di camere
		ArrayList<Camera> _camere = new ArrayList<Camera>();
		for (Iterator<Camera> iterator = camere.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
			_camere.add(camera);
		}
		return _camere;
	}
}
