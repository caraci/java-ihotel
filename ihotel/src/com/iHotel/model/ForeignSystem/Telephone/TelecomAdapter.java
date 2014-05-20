package com.iHotel.model.ForeignSystem.Telephone;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * Questa classe ha il compito di modellare un adattatore concreto al sistema esterno di "Telecom Italia" per il servizio di "Telefono in camera".
 * Si è reso necessario l'uso del design pattern "Adapter" in modo che questi presentassero la stessa interfaccia al
 * sistema "iHotel". 
 * 
 * @author Alessandro
 */
public class TelecomAdapter implements ITelephoneAdapter {

	@Override
	public LinkedList<ServizioTelefono> getElencoTelefonate() {
		return null;
	}
	@Override
	public Prezzo getPrezzoTotaleServiziPrenotazione(SoggiornoContextSubject prenotazione) {
		// TODO - Chiaramente ora si sta utilizzando un prezzo di default.
		Prezzo prezzoTotale = new Prezzo();
		prezzoTotale.set_importo(10);
		return prezzoTotale;
	}
	@Override
	public ArrayList<ServizioEsterno> getElencoServiziCameraInPeriodo(Camera camera, Periodo periodo) {
		// TODO - Chiaramente ora si stanno fornendo dei servizi di default.
		ServizioEsterno servizioEsterno = new ServizioEsterno();
		servizioEsterno.set_codice("TELECOM001");
		// Creo il giorno del servizio
    	Giorno giornoServizio = new Giorno(13,2,2014);
		// Setto la data al servizio
		servizioEsterno.set_giorno(giornoServizio);
		// Descrizione
		servizioEsterno.set_descrizione("Urbana verso 06******23");
		// Prezzo
		Prezzo prezzo = new Prezzo();
		prezzo.set_importo(3.5);
		servizioEsterno.set_prezzo(prezzo);
		// Lista di servizi
		ArrayList<ServizioEsterno> listaServiziEsterni = new ArrayList<ServizioEsterno>();
		listaServiziEsterni.add(servizioEsterno);
		
		return listaServiziEsterni;
	}


}