/**
 * 
 */
package com.iHotel.persistence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.PrenotazioneSubject;

/**
 * Classe addetta alla persistenza per la classe PrenotazioneSubject.
 * 
 * @author Eugenio
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
	 * 
	 * @return L'insieme delle prenotazioni dell'albergo.
	 */
	public List<PrenotazioneSubject> caricaPrenotazioni() {
		@SuppressWarnings("serial")
		List<PrenotazioneSubject> prenotazioni = query(new Predicate<PrenotazioneSubject>() {
			public boolean match(PrenotazioneSubject candidate) {
				return true;
			}
		});
		return prenotazioni;
	}
	/**
	 * Metodo per caricare la mappa delle prenotazioni.
	 * 
	 * @return Mappa delle prenotazioni dove la chiave è il codice della prenotazione, e il valore è la prenotazione.
	 */
	public HashMap<String, PrenotazioneSubject> caricaMappaCodicePrenotazione() {
		@SuppressWarnings("serial")
		List<PrenotazioneSubject> listPrenotazioni = query(new Predicate<PrenotazioneSubject>() {
			public boolean match(PrenotazioneSubject candidate) {
				return true;
			}
		});
		// Creo la mappa.
		HashMap<String,PrenotazioneSubject> mappaPrenotazioni = new HashMap<String,PrenotazioneSubject>();
		// Ciclo sulle prenotazioni.
		for (Iterator<PrenotazioneSubject> iterator = listPrenotazioni.iterator(); iterator.hasNext();) {
			PrenotazioneSubject prenotazioneSubject = (PrenotazioneSubject) iterator.next();
			mappaPrenotazioni.put(prenotazioneSubject.get_codice(), prenotazioneSubject);				
		}
		
		return mappaPrenotazioni;
	}
}
