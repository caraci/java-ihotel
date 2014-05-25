/**
 * 
 */
package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaDurataSoggiornoGiornoScadenza;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaOccupazioneCamereGiornoScadenza;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaPrenotanteGiornoScadenza;

/**
 * Classe per andare a leggere i vincoli legati alle differenti strategie, per decidere
 * il giorno di scadenza, entro il quale il prenotante deve fornire o la sua carta di credito,
 * o deve effettuare un bonifico a garanzia della richiesta di soggiorno effettuata.
 * 
 * @author Eugenio
 */
public class ULeggiDaFileStrategieSoggiornoGiornoScadenza extends ULeggiDaFileStrategie {
	/**
	 * Percorso per la cartella contenente i file che descrivono la strategia.
	 */
	public static String _pathToConfigsStrategieGiornoScadenza = _pathToConfigsStrategie + "GiornoScadenza/";

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
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieGiornoScadenza + "StrategiaOspite.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			int numeroPrenotazioniMax;
			int quantiGiorniPrimaRichiedere;
			int numeroPrenotazioniMin;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroPrenotazioniMin=Integer.parseInt(vincoliLinea[0]);
					numeroPrenotazioniMax=Integer.parseInt(vincoliLinea[1]);
					quantiGiorniPrimaRichiedere=Integer.parseInt(vincoliLinea[2]);
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
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieGiornoScadenza + "StrategiaOccupazioneCamere.txt"))) {  
			// Linea di lettura da file
			String line;	
			// Elementi vincolo
			int numeroCamereLibereMax;
			int quantiGiorniPrimaRichiedere;
			int numeroCamereLibereMin;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroCamereLibereMin=Integer.parseInt(vincoliLinea[0]);
					numeroCamereLibereMax=Integer.parseInt(vincoliLinea[1]);
					quantiGiorniPrimaRichiedere=Integer.parseInt(vincoliLinea[2]);
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
	public static ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> getVincoliStrategiaDurataSoggiorno(){
		// Lista nella quale si introdurrano i vincoli per l'albergo.
		ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> vincoliStrategiaDurataSoggiorno = new ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza>();	
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieGiornoScadenza + "StrategiaDurataSoggiorno.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			int numeroNottiMax;
			int quantiGiorniPrimaRichiedere;
			int numeroNottiMin;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroNottiMin=Integer.parseInt(vincoliLinea[0]);
					numeroNottiMax=Integer.parseInt(vincoliLinea[1]);
					quantiGiorniPrimaRichiedere=Integer.parseInt(vincoliLinea[2]);
					// Creo il vincolo.
					VincoloStrategiaDurataSoggiornoGiornoScadenza vincolo = new VincoloStrategiaDurataSoggiornoGiornoScadenza(numeroNottiMin, 
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
