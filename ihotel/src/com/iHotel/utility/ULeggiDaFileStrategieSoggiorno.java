/**
 * 
 */
package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaDurataSoggiornoStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaOccupazioneCamereGiornoScadenza;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaPrenotanteGiornoScadenza;

/**
 * @author Eugenio
 *
 */
public class ULeggiDaFileStrategieSoggiorno extends ULeggiDaFile {
	/**
	 * Percorso per la cartella contenente i file che descrivono la strategia.
	 */
	public static String _pathToConfigsStrategieSoggiorno = _pathToConfigs + "strategie/GiornoScadenza/";

	/**
	 * Metodo per ottenere la lista dei vincoli che servono per ottenere il giorno di scadenza di invio della garanzia di una
	 * richiesta di soggiorno, considerando il prenotante.
	 * 
	 * @return Lista di vincoli.
	 */
	public static ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> getVincoliStrategiaPrenotante(){
		// Lista nella quale si introdurrano i vincoli per l'albergo.
		ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> vincoliStrategiaOspite = new ArrayList<VincoloStrategiaPrenotanteGiornoScadenza>();	
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieSoggiorno + "StrategiaOspite.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			String numeroPrenotazioniMax, numeroPrenotazioniMin, quantiGiorniPrimaRichiedere;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroPrenotazioniMin=vincoliLinea[0];
					numeroPrenotazioniMax=vincoliLinea[1];
					quantiGiorniPrimaRichiedere=vincoliLinea[2];
					// Creo il vincolo.
					VincoloStrategiaPrenotanteGiornoScadenza vincolo = new VincoloStrategiaPrenotanteGiornoScadenza(numeroPrenotazioniMin, 
																											numeroPrenotazioniMax, 
																											quantiGiorniPrimaRichiedere);
					// Aggiungo il vincolo alla lista
					vincoliStrategiaOspite.add(vincolo);
				}
			}
				
		} catch (IOException e) {
			
        }
		return vincoliStrategiaOspite;	
	}
	/**
	 * Metodo per ottenere la lista dei vincoli che servono per ottenere il giorno di scadenza di invio della garanzia di una
	 * richiesta di soggiorno, considerando l'occupazione delle camere.
	 * 
	 * @return Lista di vincoli.
	 */
	public static ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza> getVincoliStrategiaOccupazioneCamere(){
		// Lista nella quale si introdurrano i vincoli per l'albergo.
		ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza> vincoliStrategiaOccupazioneCamere = new ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza>();	
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieSoggiorno + "StrategiaOccupazioneCamere.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			String numeroCamereLibereMax, numeroCamereLibereMin, quantiGiorniPrimaRichiedere;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroCamereLibereMin=vincoliLinea[0];
					numeroCamereLibereMax=vincoliLinea[1];
					quantiGiorniPrimaRichiedere=vincoliLinea[2];
					// Creo il vincolo.
					VincoloStrategiaOccupazioneCamereGiornoScadenza vincolo = new VincoloStrategiaOccupazioneCamereGiornoScadenza(numeroCamereLibereMin, 
																																  numeroCamereLibereMax, 
																																  quantiGiorniPrimaRichiedere);
					// Aggiungo il vincolo alla lista
					vincoliStrategiaOccupazioneCamere.add(vincolo);
				}
			}
				
		} catch (IOException e) {
			
        }
		return vincoliStrategiaOccupazioneCamere;	
	}
	
	/**
	 * Metodo per ottenere la lista dei vincoli che servono per ottenere il giorno di scadenza di invio della garanzia di una
	 * richiesta di soggiorno, considerando la durata del soggiorno.
	 * 
	 * @return Lista di vincoli.
	 */
	public static ArrayList<VincoloStrategiaDurataSoggiornoStrategy> getVincoliStrategiaDurataSoggiorno(){
		// Lista nella quale si introdurrano i vincoli per l'albergo.
		ArrayList<VincoloStrategiaDurataSoggiornoStrategy> vincoliStrategiaDurataSoggiorno = new ArrayList<VincoloStrategiaDurataSoggiornoStrategy>();	
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieSoggiorno + "StrategiaDurataSoggiorno.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			String numeroNottiMax, numeroNottiMin, quantiGiorniPrimaRichiedere;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroNottiMin=vincoliLinea[0];
					numeroNottiMax=vincoliLinea[1];
					quantiGiorniPrimaRichiedere=vincoliLinea[2];
					// Creo il vincolo.
					VincoloStrategiaDurataSoggiornoStrategy vincolo = new VincoloStrategiaDurataSoggiornoStrategy(numeroNottiMin, 
																												  numeroNottiMax, 
																												  quantiGiorniPrimaRichiedere);
					// Aggiungo il vincolo alla lista
					vincoliStrategiaDurataSoggiorno.add(vincolo);
				}
			}
				
		} catch (IOException e) {
			
        }
		return vincoliStrategiaDurataSoggiorno;	
	}

}
