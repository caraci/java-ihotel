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
	 * Metodo per ottenere la lista dei vincoli che servono per ottenere il giorno di scadenza di invio della garanzia di una
	 * richiesta di soggiorno, considerando il prenotante.
	 * 
	 * @return Lista di vincoli.
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
}
