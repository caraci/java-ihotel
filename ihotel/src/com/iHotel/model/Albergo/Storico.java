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
	public List<SoggiornoContextSubject> recuperaSoggiorniFuturi() {
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
		// Ordino la lista
		//List<SoggiornoContextSubject> soggiorniFuturiOrdinati = this.ordinaInOrdineCronologico(soggiorniFuturi);
		
		return soggiorniFuturi;
	}
	/**
	 * Metodo per ordinare i soggiorni di una lista in ordine cronologico da quello con giorno di inizio più vicino al giorno attuale, fino
	 * a quello più lontano.
	 * 
	 * @param listaSoggiorniDaOrdinare Lista di soggiorni da ordinare.
	 * @return Lista di soggiorni ordinati.
	 */
	private List<SoggiornoContextSubject> ordinaInOrdineCronologico(ArrayList<SoggiornoContextSubject> listaSoggiorniDaOrdinare) {
		// Lista nella quale inserisco i soggiorni ordinati
		LinkedList<SoggiornoContextSubject> listaSoggiorniOrdinata = new LinkedList<SoggiornoContextSubject>();
		// Ciclo sulla lista dei soggiorni da ordinare.
		for (Iterator<SoggiornoContextSubject> iterator = listaSoggiorniDaOrdinare.iterator(); iterator.hasNext();) {
			// Generico elemento della lista da ordinare
			SoggiornoContextSubject soggiornoDaOrdinare = (SoggiornoContextSubject) iterator.next();
			// Controllo se la lista ordinata ha almeno un elemento
			if (listaSoggiorniOrdinata.size()!=0) {
				// Ciclo sulla lista ordinata.
				for (int i = 0; i < listaSoggiorniOrdinata.size(); i++) {
					// Generico elemento della lista ordinata
					SoggiornoContextSubject soggiornoOrdinato = listaSoggiorniOrdinata.get(i);
					// Giorno del soggiorno della lista ordinata in posizione i-esima.
					Giorno giornoInizioSoggiornoOrdinato = soggiornoOrdinato.get_periodo().get_dataInizio();
					// Recupero il giorno iniziale del soggiorno da inserire nella lista ordinata.
					Giorno giornoInizioSoggiornoDaOrdinare = soggiornoDaOrdinare.get_periodo().get_dataInizio();
					// Controllo se il giorno di inizio del soggiorno da ordinare è precedente a quello ordinato.
					if (giornoInizioSoggiornoOrdinato.compara(giornoInizioSoggiornoDaOrdinare) > 0) {
						// Recupero l'indice dell'elemento del soggiorno nella lista ordinata in analisi
						listaSoggiorniOrdinata.add(i, soggiornoDaOrdinare);
					}
				}
			} else {
				// Primo elemento aggiunto alla lista.
				listaSoggiorniOrdinata.add(soggiornoDaOrdinare);
			}
			
		}
		
		return listaSoggiorniOrdinata;
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