package com.iHotel.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainTestPersona {

	public static void main(String[] args) {
		String _pathToConfigs = "/configs/";
		
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		
		System.out.println(filePath);
		
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader sistemiEsterniReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "sistemiEsterni.txt"))) {  
			// Inizializzo gli attributi
			System.out.println(sistemiEsterniReader.readLine());
			System.out.println(sistemiEsterniReader.readLine());
			System.out.println(sistemiEsterniReader.readLine());
			System.out.println(sistemiEsterniReader.readLine());
			System.out.println(sistemiEsterniReader.readLine());
		} catch (IOException e) {
			System.out.println("dio");
        } 
		
	}

}
