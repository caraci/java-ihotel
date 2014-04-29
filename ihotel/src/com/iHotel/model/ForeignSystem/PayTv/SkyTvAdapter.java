package com.iHotel.model.ForeignSystem.PayTv;

import java.util.ArrayList;
import java.util.LinkedList;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.MyDate;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe ha il compito di modellare un adattatore concreto al sistema esterno di "Sky" per il servizio di "Pay TV".
 * Si è reso necessario l'uso del design pattern "Adapter" in modo che questi presentassero la stessa interfaccia al
 * sistema "iHotel". 
 * 
 * @author Alessandro
 */
public class SkyTvAdapter implements IPayTvAdapter {

	@Override
	public LinkedList<ServizioPayTv> getElencoEventi() {
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
		servizioEsterno.set_codice("SKY001");
		// Data
		MyDate data = new MyDate();
		data.set(2014, 2, 13, 21, 0);
		// Periodo
		Periodo periodoServizio = new Periodo();
		periodoServizio.setDataInizioDaData(data);
		periodoServizio.setDataFineDaData(data);
		// Setto la data al servizio
		servizioEsterno.set_periodo(periodoServizio);
		// Descrizione
		servizioEsterno.set_descrizione("C'era una volta in America - S. Leone");
		// Prezzo
		Prezzo prezzo = new Prezzo();
		prezzo.set_importo(8);
		servizioEsterno.set_prezzo(prezzo);
		// Lista di servizi
		ArrayList<ServizioEsterno> listaServiziEsterni = new ArrayList<ServizioEsterno>();
		listaServiziEsterni.add(servizioEsterno);
		
		return listaServiziEsterni;
	}

}