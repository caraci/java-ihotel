package com.iHotel.model.Albergo;

import java.util.*;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;
/**
 * Questa classe rappresenta lo storico delle prenotazioni dell'albergo.
 * 
 * @author Alessandro
 */
public class Storico {

	/* ------------------------------- Attributi e Costruttore ----------------------------- */
	/**
	 *  Attributo privato - Pattern Singleton
	 */
	private static Storico instance = null;
	/**
	 * Questa mappa ha come chiave i codici dei soggiorni, perchè in questo modo, l'accesso alla soggiorno 
	 * viene eseguito in maniera efficiente ricercandola per codice.
	 */
	private HashMap<String,SoggiornoContextSubject> _soggiorni;
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private Storico() {}
	/* -------------------------------- Metodi di classe ----------------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern singleton
	 * @return instance 
	 */
	public static Storico getInstance() {
    	if(instance == null) {
            instance = new Storico();
         }
         return instance;
    }
	/* ------------------------------ Metodi di instanza ----------------------------------- */
	/**
	 * Metodo per ottenere un soggiorno a partire dal suo codice.
	 * 
	 * @param codice Codice della soggiorno
	 * @return Soggiorno ricercata
	 */
	public SoggiornoContextSubject recuperaSoggiornoDaCodice(String codice) {
		return _soggiorni.get(codice);
	}

	/**
	 * Metodo per aggiungere una prenotazione allo storico.
	 * 
	 * @param prenotazione Prenotazione da aggiungere.
	 */
	public void addPrenotazione(SoggiornoContextSubject prenotazione) {
		_soggiorni.put(prenotazione.get_codice(), prenotazione);
	}
	/**
	 * Metodo per recuperare tutti i soggiorni futuri ad oggi.
	 * 
	 * @return Lista dei soggiorni futuri a partire da oggi.
	 */
	public ArrayList<SoggiornoContextSubject> recuperaSoggiorniFuturi() {
		// Lista nella quale inseriamo i soggiorni validi
		ArrayList<SoggiornoContextSubject> soggiorniFuturi = new ArrayList<SoggiornoContextSubject>();
		// Recupero il giorno attuale
		Giorno giornoOdierno = Giorno.getGiornoOdierno();
		// Ciclo sulle prenotazioni e prendo quelle che iniziano da oggi in poi.
		for (Iterator<String> iterator = _soggiorni.keySet().iterator(); iterator.hasNext();) {
			String codiceSoggiorno = (String) iterator.next();
			// Recupero il soggiorno dal suo codice
			SoggiornoContextSubject soggiorno = _soggiorni.get(codiceSoggiorno);
			// Recupero il giorno di inizio del soggiorno
			Giorno giornoInizioSoggiorno = soggiorno.get_periodo().get_dataInizio();
			// Controllo che la data di inizio del soggiorno sia superiore a quella di oggi.
			if (giornoInizioSoggiorno.compara(giornoOdierno) > 0) {
				soggiorniFuturi.add(soggiorno);
			}
		}
		
		return soggiorniFuturi;
	}
	/* --------------------------------- Getter, Setter ---------------------------------- */
	
	/**
	 * @return _prenotazioni
	 */
	public HashMap<String,SoggiornoContextSubject> get_soggiorni() {
		return _soggiorni;
	}

	/**
	 * @param _prenotazioni
	 */
	public void set_soggiorni(HashMap<String,SoggiornoContextSubject> _prenotazioni) {
		this._soggiorni = _prenotazioni;
	}

}