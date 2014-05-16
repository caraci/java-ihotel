package com.iHotel.main;

import com.iHotel.model.Persona.Indirizzo;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Persona.Residenza;
import com.iHotel.model.Persona.Documenti.CartaIdentita;
import com.iHotel.model.Utility.Giorno;

public class MainTestPersona {

	public static void main(String[] args) {
		//Creo un indirizzo
		Indirizzo indirizzo = new Indirizzo("Piazza la bomba e scappa",25);
		//Creo una residenza
		Residenza residenza = new Residenza("Rieti",indirizzo);
		Giorno dataNascita = new Giorno(24,7,1989);
		Giorno dataRilascio = new Giorno(10,10,2010);
		Giorno dataScadenza =new Giorno(10,10,2020);
		float altezza = (float) 1.74;
		String telefono = "1980";
		CartaIdentita cartaIdentita = new CartaIdentita("alessandro","Ranalli",dataNascita, "Rieti", dataRilascio, dataScadenza, "Comune", "XXX",residenza,"nubile","Studente",altezza,"castani","castani","");
		
		Ospite ospite = new Ospite("alessandro", "Ranalli","la@ga",telefono,cartaIdentita);
		
		System.out.println(ospite.get_documento().get_residenza().get_cittaResidenza());
	}

}
