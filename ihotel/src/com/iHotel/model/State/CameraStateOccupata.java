package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class CameraStateOccupata extends CameraState {

	@Override
	public LinkedList<CameraState> occupaInPeriodo(Periodo periodo) {
		return null;
	}

	@Override
	public boolean isLiberaInPeriodo(Periodo periodo) {
		return false;
	}

	@Override
	public Prezzo getPrezzoTotaleServizi(Periodo periodo) {
		Prezzo prezzo = null;
		// Controllo se il periodo dello stato corrisponde con quello della prenotazione
		if (get_periodo().coincideCon(periodo)) {
			prezzo=get_prezzoServizi();
		}
		return prezzo;
	}

	@Override
	public void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo) {
		// Controllo se il periodo di richiesta, ovvero quello della prenotazione è effettivamente
		// il periodo dello stato.
		if (_periodo.coincideCon(periodo)) {
			// Aggiungo il servizio alla lista dei servizi per questo stato della camera.
			_serviziInterni.add(servizio);
			// Ricavo il prezzo del servizio e lo aggiungo al prezzo dei servizi per lo stato della camera.
			DescrizioneServizioInterno descrizioneServizioInterno = CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(servizio.get_codice());
			_prezzoServizi.somma(descrizioneServizioInterno.getPrezzoInData(servizio.get_data()));
		}
	}

}
