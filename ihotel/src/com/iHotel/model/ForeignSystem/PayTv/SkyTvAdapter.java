package com.iHotel.model.ForeignSystem.PayTv;

import java.util.ArrayList;
import java.util.LinkedList;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;
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
	public Prezzo getPrezzoTotaleServiziPrenotazione(SoggiornoContextSubject prenotazione) {
		// TODO - Chiaramente ora si sta utilizzando un prezzo di default.
		Prezzo prezzoTotale = new Prezzo();
		prezzoTotale.set_quantita(10);
		return prezzoTotale;
	}
	@Override
	public ArrayList<ServizioPayTv> getElencoServiziPayTvCameraInPeriodo(Camera camera, Periodo periodo) {
		// TODO - Chiaramente ora si stanno fornendo dei servizi di default.
		ServizioPayTv servizioPayTv = new ServizioPayTv();
		servizioPayTv.set_codice("SKY001");
		// Creo il giorno del servizio
    	Giorno giornoServizio = new Giorno(13,2,2014);
		// Setto la data al servizio
    	servizioPayTv.set_giorno(giornoServizio);
		// Descrizione
    	servizioPayTv.set_evento("C'era una volta in America - S. Leone");
		// Prezzo
		Prezzo prezzo = new Prezzo();
		prezzo.set_quantita(8);
		servizioPayTv.set_prezzo(prezzo);
		// Lista di servizi
		ArrayList<ServizioPayTv> listaServiziEsterni = new ArrayList<ServizioPayTv>();
		listaServiziEsterni.add(servizioPayTv);
		
		return listaServiziEsterni;
	}

}