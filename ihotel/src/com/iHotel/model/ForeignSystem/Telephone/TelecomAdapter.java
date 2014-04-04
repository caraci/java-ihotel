package com.iHotel.model.ForeignSystem.Telephone;

import java.util.*;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
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
	public ArrayList<ServizioEsterno> getElencoServiziCameraInPeriodo(
			CameraContext camera, Periodo periodo) {
		// TODO Auto-generated method stub
		return null;
	}


}