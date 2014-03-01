/**
 * 
 */
package com.iHotel.persistence;

import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.MCamera;
import com.iHotel.model.MPrenotazioneSubject;

/**
 * @author Eugenio
 *
 */
public class PPrenotazione extends PersistentManager {
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PPrenotazione instance=null;
	/**
	 * Costruttore privato - Pattern Singleton.
	 */
	private PPrenotazione(){}
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton.
	 * @return
	 */
	public static PPrenotazione getInstance(){
		if(instance == null) {
            instance = new PPrenotazione();
         }
         return instance;
	}
	/* ----------------------- Metodi di instanza ----------------------- */
	/**
	 * Metodo per caricare tutte le prenotazioni presenti nella base dati.
	 * @return L'insieme delle prenotazioni dell'albergo.
	 */
	public List<MPrenotazioneSubject> caricaPrenotazioni() {
		@SuppressWarnings("serial")
		List<MPrenotazioneSubject> prenotazioni = query(new Predicate<MPrenotazioneSubject>() {
			public boolean match(MPrenotazioneSubject candidate) {
				return true;
			}
		});
		return prenotazioni;
	}
}
