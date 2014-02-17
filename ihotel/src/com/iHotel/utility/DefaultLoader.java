package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DefaultLoader {
	
	private static DefaultLoader instance = null;
	/**
	 * Costruttore privato - Pattern singleton
	 */
	private DefaultLoader(){}
	/**
	 * Metodo per ottenere l'instanza unica di questa classe - Pattern singleton
	 * @return
	 */
	public static DefaultLoader getInstance(){
		if (instance == null){
			instance = new DefaultLoader();
		}
		return instance;
	}
	/**
	 * Metodo per andare a leggere in un file di configurazione i valori relativi a nome, telefono, PIVA e eMail della
	 * classe MAlbergo.
	 * 
	 * @return Collezione contenente nome, telefono, PIVA e eMail.
	 */
	public ArrayList<String> getInformazioniAlbergo(){
		// Variabili nelle quali andremo a memorizzare gli attributi dell'albergo.
		String nome, telefono, PIVA, eMail;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader albergoReader = new BufferedReader(new FileReader(filePath + "/configs/Albergo.txt"))) {  
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
	 * Metodo per andare a leggere in un file di configurazione i valori relativi a minuto inizio, ora inizio, minuto fine
	 * e ora fine della classe MPeriodo.
	 * 
	 * @return Collezione contenente minuto inizio, ora inizio, minuto fine, ora fine.
	 */
	public ArrayList<Integer> getMinutoOraInizioMinutoOraFine(){
		// Variabili nelle quali andremo a memorizzare gli attributi del periodo.
		String minutoInizioStr, oraInizioStr, minutoFineStr, oraFineStr;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader albergoReader = new BufferedReader(new FileReader(filePath + "/configs/Periodo.txt"))) {  
			// Inizializzo gli attributi
			minutoInizioStr = albergoReader.readLine();
			oraInizioStr = albergoReader.readLine();
			minutoFineStr = albergoReader.readLine();
			oraFineStr = albergoReader.readLine();
		} catch (IOException e) {
			minutoInizioStr = "0";
			oraInizioStr = "16";
			minutoFineStr = "0";
			oraFineStr = "10";
        } 
		ArrayList<Integer> attributiPeriodo = new ArrayList<Integer>();
		// Aggiungi gli attributi all'ArrayList di interi.
		attributiPeriodo.add(Integer.parseInt(minutoInizioStr));
		attributiPeriodo.add(Integer.parseInt(oraInizioStr));
		attributiPeriodo.add(Integer.parseInt(minutoFineStr));
		attributiPeriodo.add(Integer.parseInt(oraFineStr));
		
		return attributiPeriodo;
	}	
	

}
