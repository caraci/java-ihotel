/**
 * 
 */
package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Classe con la responsabilità di andare a vedere quali strategie utilizzare, per il calcolo del giorno di 
 * scadenza massimo entro il quale il cliente deve fornire una garanzia per la richiesta di soggiorno effettuata,
 * per il calcolo della caparra che il cliente deve effettuare, per il calcolo della penale che il cliente deve 
 * pagare.
 * 
 * @author Eugenio
 */
public class ULeggiDaFileStrategie extends ULeggiDaFile {
	/**
	 * Percorso per la cartella contenente il file con all'interno le strategie da utilizzare.
	 */
	public static String _pathToConfigsStrategie = _pathToConfigs + "strategie/";
	
	/**
	 * Metodo per ottenere la mappa contenente l'insieme delle strategie utilizzate per il calcolo del giorno di scadenza di invio della garanzia da parte
	 * del prenotante a seguito di una richiesta di soggiorno. In particolare nella mappa il valore di ogni elemento è un booleano che sarà True solo per 
	 * le strategie che l'albergo deciderà di utilizzare.
	 * 
	 * @return Mappa contenente l'insieme delle strategie per il calcolo del giorno di scadenza di invio della garanzia per la richiesta di soggiorno.
	 */
	public static HashMap<String,Boolean> getStrategieDaUtilizzareGiornoScadenza(){
		// Struttura dati dove inserisco le strategie da utilizzare
		HashMap<String,Boolean> strategieDaUtilizzare = new HashMap<String,Boolean>();
		// Aggiungo le strategie per il giorno scadenza note.
		strategieDaUtilizzare.put("GiornoScadenzaOspite", false);
		strategieDaUtilizzare.put("GiornoScadenzaOccupazioneCamere", false);
		strategieDaUtilizzare.put("GiornoScadenzaDurataSoggiorno", false);
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategie + "StrategieDaUtilizzare.txt"))) {  
			// Linea di lettura da file
			String line;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Rimuovo dalla mappa il valore letto
					strategieDaUtilizzare.remove(line.trim());
					// Re-inserisco nella mappa il valore letto ma con valore true
					strategieDaUtilizzare.put(line.trim(), true);
				}
			}		
		} catch (IOException e) {}
		
		return strategieDaUtilizzare;	
	}
	/**
	 * Metodo per ottenere la strategia di risoluzione scelta dall'albergo.
	 * 
	 * @return Stringa contenente la strategia di risoluzione scelta.
	 */
	public static String getPoliticaSceltaStrategie(){
		// Stringa dove memorizzo la politica da utilizzare.
		String strategiaDaUsare=null;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategie + "PoliticaSceltaStrategie.txt"))) {  
			// Linea di lettura da file
			String line;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Rimuovo dalla mappa il valore letto
					strategiaDaUsare=line.trim();
				}
			}		
		} catch (IOException e) {}
		
		return strategiaDaUsare;	
	}
}
