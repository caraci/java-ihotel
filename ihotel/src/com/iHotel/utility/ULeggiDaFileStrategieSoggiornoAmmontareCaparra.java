/**
 * 
 */
package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.iHotel.model.StrategieSoggiorno.AmmontareCaparra.VincoloStrategiaDurataSoggiornoAmmontareCaparra;
import com.iHotel.model.StrategieSoggiorno.AmmontareCaparra.VincoloStrategiaPrenotanteAmmontareCaparra;

/**
 * @author Eugenio
 *
 */
public class ULeggiDaFileStrategieSoggiornoAmmontareCaparra extends
		ULeggiDaFileStrategie {

	/**
	 * Percorso per la cartella contenente i file che descrivono la strategia.
	 */
	public static String _pathToConfigsStrategieAmmontareCaparra = _pathToConfigsStrategie + "AmmontareCaparra/";
	
	/**
	 * Metodo per ottenere la lista dei vincoli che servono per ottenere l'ammontare della caparra per una
	 * richiesta di soggiorno, considerando il prenotante.
	 * 
	 * @return Lista di vincoli.
	 */
	public static ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> getVincoliStrategiaPrenotante(){
		// Lista nella quale si introdurrano i vincoli per l'albergo.
		ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> vincoliStrategiaOspite = new ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra>();	
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieAmmontareCaparra + "StrategiaOspite.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			int numeroPrenotazioniMax;
			int numeroPrenotazioniMin;
			int percentualeDaRichiedere;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroPrenotazioniMin=Integer.parseInt(vincoliLinea[0]);
					numeroPrenotazioniMax=Integer.parseInt(vincoliLinea[1]);
					percentualeDaRichiedere=Integer.parseInt(vincoliLinea[2]);
					// Creo il vincolo.
					VincoloStrategiaPrenotanteAmmontareCaparra vincolo = new VincoloStrategiaPrenotanteAmmontareCaparra(numeroPrenotazioniMin, 
																											numeroPrenotazioniMax, 
																											percentualeDaRichiedere);
					// Aggiungo il vincolo alla lista
					vincoliStrategiaOspite.add(vincolo);
				}
			}
				
		} catch (IOException e) {
			
        }
		return vincoliStrategiaOspite;	
	}
	
	/**
	 * Metodo per ottenere la lista dei vincoli che servono per ottenere l'ammontare della caparra per una
	 * richiesta di soggiorno, considerando la durata del soggiorno.
	 * 
	 * @return Lista di vincoli.
	 */
	public static ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> getVincoliStrategiaDurataSoggiorno(){
		// Lista nella quale si introdurrano i vincoli per l'albergo.
		ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> vincoliStrategiaDurataSoggiorno = new ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra>();	
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath + _pathToConfigsStrategieAmmontareCaparra + "StrategiaDurataSoggiorno.txt"))) {  
			// Linea di lettura da file
			String line;
			// Elementi vincolo
			int numeroNottiMin;
			int numeroNottiMax;
			int percentualeDaRichiedere;
			// Scorro il file.
			while(!(line=fileReader.readLine()).contains("End")) {
				// Controllo se la linea non contiene il simbolo '#'
				if(!line.contains("#")) {
					// Divido la linea in stringhe.
					String[] vincoliLinea = line.split("-");
					// Assegno i valori
					numeroNottiMin=Integer.parseInt(vincoliLinea[0]);
					numeroNottiMax=Integer.parseInt(vincoliLinea[1]);
					percentualeDaRichiedere=Integer.parseInt(vincoliLinea[2]);
					// Creo il vincolo.
					VincoloStrategiaDurataSoggiornoAmmontareCaparra vincolo = new VincoloStrategiaDurataSoggiornoAmmontareCaparra(numeroNottiMin, 
																												  numeroNottiMax, 
																												  percentualeDaRichiedere);
					// Aggiungo il vincolo alla lista
					vincoliStrategiaDurataSoggiorno.add(vincolo);
				}
			}
				
		} catch (IOException e) {
			
        }
		return vincoliStrategiaDurataSoggiorno;	
	}
}
