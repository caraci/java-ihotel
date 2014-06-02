package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe addetta all'accesso ai file di configurazione, per il recupero delle informazioni di diverso genere.
 * 
 * @author Eugenio
 */
public class ULeggiDaFile {	
	/* -------------------------- Attributi e costruttore ----------------------- */
	/**
	 * Stringa contenente il percorso verso la cartella configs.
	 */
	protected static String _pathToConfigs = "./ihotel/configs/";
	/* ------------------------- Metodi di instanza ------------------------------ */
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
	/**
	 * Metodo per andare a leggere in un file di configurazione che tipo di stile vogliamo assegnare all'interfaccia.
	 * 
	 * @return Stringa contenente lo stile da utilizzare.
	 */
	public static String getStileInterfaccia(){
		// Variabile nelle quali andremo a memorizzare lo stile dell'interfaccia.
		String stile;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader interfacciaReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "interfaccia.txt"))) {  
			// Inizializzo gli attributi
			stile = interfacciaReader.readLine();
		} catch (IOException e) {
			stile = "light";
        }
		return stile;	
	}
	/**
	 * Metodo per andare a leggere in un file di configurazione quali sistemi esterni utilizzare.
	 * 
	 * @return Lista contenente i sistemi esterni da utilizzare
	 */
	public static ArrayList<String> getSistemiServiziEsterni() {
		// Variabili nelle quali andremo a memorizzare gli attributi dell'albergo.
			String payTvSystem, telephoneSystem, lettoreCarteSystem, autorizzazionePagamentoSystem, pagamentoCartaSystem,sistemaSchedePS ;
			// Ricavo il path assoluto.
			String filePath = new File("").getAbsolutePath();
			// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
			try (BufferedReader sistemiEsterniReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "sistemiEsterni.txt"))) {  
				// Inizializzo gli attributi
				payTvSystem = sistemiEsterniReader.readLine();
				telephoneSystem = sistemiEsterniReader.readLine();
				lettoreCarteSystem = sistemiEsterniReader.readLine();
				autorizzazionePagamentoSystem = sistemiEsterniReader.readLine();
				pagamentoCartaSystem = sistemiEsterniReader.readLine();
				sistemaSchedePS = sistemiEsterniReader.readLine();
			} catch (IOException e) {
				payTvSystem = "Sky";
				telephoneSystem = "Telecom";
				lettoreCarteSystem = "Ingenico";
				autorizzazionePagamentoSystem = "Carispaq";
				pagamentoCartaSystem = "CartaVisa";
				sistemaSchedePS = "PoliziaDiStato";
	        } 
			ArrayList<String> sistemiEsterni = new ArrayList<String>();
			// Aggiungi gli attributi all'ArrayList di stringhe.
			sistemiEsterni.add(payTvSystem);
			sistemiEsterni.add(telephoneSystem);
			sistemiEsterni.add(lettoreCarteSystem);
			sistemiEsterni.add(autorizzazionePagamentoSystem);
			sistemiEsterni.add(pagamentoCartaSystem);
			sistemiEsterni.add(sistemaSchedePS);
			return sistemiEsterni;
	}
}
