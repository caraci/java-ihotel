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
 * @author Eugenio
 *
 */
public class ULeggiDaFileStrategieSoggiorno extends ULeggiDaFile {

	/**
	 * Metodo per andare a leggere in un file di configurazione i valori relativi a nome, telefono, PIVA e eMail della
	 * classe Albergo.
	 * 
	 * @return Collezione contenente nome, telefono, PIVA e eMail dell'albergo.
	 */
	public static ArrayList<String> getInformazioniAlbergo(){
		// Variabili nelle quali andremo a memorizzare gli attributi dell'albergo.
		String nome, telefono, PIVA, eMail;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader albergoReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "albergo.txt"))) {  
			// Inizializzo gli attributi
			nome = albergoReader.readLine();
			telefono = albergoReader.readLine();
			PIVA = albergoReader.readLine();
			eMail = albergoReader.readLine();
		} catch (IOException e) {
			nome = "Hotel Meraviglioso";
			telefono = "06808182";
			PIVA = "123456789ABCDEF";
			eMail = "info@hotelmeraviglioso.com";
        } 
		ArrayList<String> attributiAlbergo = new ArrayList<String>();
		// Aggiungi gli attributi all'ArrayList di stringhe.
		attributiAlbergo.add(nome);
		attributiAlbergo.add(telefono);
		attributiAlbergo.add(PIVA);
		attributiAlbergo.add(eMail);
		
		return attributiAlbergo;	
	}

}
