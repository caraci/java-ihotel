/**
 * 
 */
package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	 * Metodo per ottenere la lista contenente l'insieme delle strategie utilizzate per il calcolo del giorno di scadenza di invio della garanzia da parte
	 * del prenotante a seguito di una richiesta di soggiorno.
	 * 
	 * @return Lista contenente l'insieme delle strategie per il calcolo del giorno di scadenza di invio della garanzia per la richiesta di soggiorno.
	 */
	public static ArrayList<String> getStrategieDaUtilizzareGiornoScadenza(){
		// Struttura dati dove inserisco le strategie da utilizzare
		ArrayList<String> strategieDaUtilizzare = new ArrayList<String>();
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategie + "StrategieDaUtilizzareGiornoScadenza.txt"))) {  
			// Linea di lettura da file
			String line;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Re-inserisco nella mappa il valore letto ma con valore true
					strategieDaUtilizzare.add(line.trim());
				}
			}		
		} catch (IOException e) {}
		
		return strategieDaUtilizzare;	
	}
	/**
	 * Metodo per ottenere la strategia di risoluzione scelta dall'albergo per decidere il giorno di scadenza di invio della garanzia.
	 * 
	 * @return Stringa contenente la strategia di risoluzione scelta.
	 */
	public static String getPoliticaSceltaStrategieGiornoScadenza(){
		// Stringa dove memorizzo la politica da utilizzare.
		String strategiaDaUsare=null;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategie + "PoliticaSceltaStrategieGiornoScadenza.txt"))) {  
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
	/**
	 * Metodo per ottenere la strategia di risoluzione scelta dall'albergo per decidere l'ammontare della caparra
	 * 
	 * @return
	 */
	public static String getPoliticaSceltaStrategieAmmontareCaparra() {
		// Stringa dove memorizzo la politica da utilizzare.
		String strategiaDaUsare=null;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategie + "PoliticaSceltaStrategieAmmontareCaparra.txt"))) {  
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
	/**
	 * Metodo per ottenere la lista delle strategie da utilizzare per il calcolo dell'ammontare della caparra per la richiesta di soggiorno.
	 * 
	 * @return Lista contenente l'insieme delle strategie per il calcolo dell'ammontare della caparra per la richiesta di soggiorno.
	 */
	public static ArrayList<String> getStrategieDaUtilizzareAmmontareCaparra() {
		// Struttura dati dove inserisco le strategie da utilizzare
		ArrayList<String> strategieDaUtilizzare = new ArrayList<String>();
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategie + "StrategieDaUtilizzareAmmontareCaparra.txt"))) {  
			// Linea di lettura da file
			String line;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Re-inserisco nella mappa il valore letto ma con valore true
					strategieDaUtilizzare.add(line.trim());
				}
			}		
		} catch (IOException e) {}
		
		return strategieDaUtilizzare;
	}
}
