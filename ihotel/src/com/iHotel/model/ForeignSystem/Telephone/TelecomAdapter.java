package com.iHotel.model.ForeignSystem.Telephone;

import java.util.*;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.MyDate;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class TelecomAdapter implements ITelephoneAdapter {

	@Override
	public LinkedList<ServizioTelefono> getElencoTelefonate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prezzo getPrezzoTotaleServiziPrenotazione(PrenotazioneSubject prenotazione) {
		// TODO - Chiaramente ora si sta utilizzando un prezzo di default.
		Prezzo prezzoTotale = new Prezzo();
		prezzoTotale.set_importo(10);
		return prezzoTotale;
	}

	@Override
	public ArrayList<ServizioEsterno> getElencoServiziCameraInPeriodo(CameraContext camera, Periodo periodo) {
		// TODO - Chiaramente ora si stanno fornendo dei servizi di default.
		ServizioEsterno servizioEsterno = new ServizioEsterno();
		servizioEsterno.set_codice("TELECOM001");
		// Data
		MyDate data = new MyDate();
		data.set(2014, 2, 13, 21, 0);
		servizioEsterno.set_data(data);
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