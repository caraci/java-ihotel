package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class CameraStateOccupata extends CameraState {

	@Override
	/**
	 * 
	 */
	public LinkedList<CameraState> occupaInPeriodo(Periodo periodo) {
		return null;
	}

	@Override
	public boolean isLiberaInPeriodo(Periodo periodo) {
		return false;
	}

	@Override
	public Prezzo getPrezzoTotaleServizi(Periodo periodo) {
		// Variabili
		DescrizioneServizioInterno descrizioneServizioInterno;
		Prezzo prezzoTotaleServizio = null;
		//Controllo che il periodo dello stato coincida con quello della richiesta.
		if (_periodo.coincideCon(periodo)) {
			// Inizializzo il prezzo.
			prezzoTotaleServizio=new Prezzo();
			prezzoTotaleServizio.set_importo(0);
			// Ciclo su tutti i serviziInterni dello stato.
			for (Iterator<ServizioInterno> iterator = _serviziInterni.iterator(); iterator.hasNext();) {
				// Servizio in analisi
				ServizioInterno servizioInterno = (ServizioInterno) iterator.next();
				// Ricavo il descrittore relativo al servizio in analisi.
				descrizioneServizioInterno=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(servizioInterno.get_codice());
				// Sommo al prezzo totale, il prezzo dovuto al servizio in analisi.
				prezzoTotaleServizio.somma(descrizioneServizioInterno.getPrezzoInData(servizioInterno.get_data()));
			}
		}
		return prezzoTotaleServizio;
	}

	@Override
	public void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo) {
		// Controllo se il periodo di richiesta, ovvero quello della prenotazione è effettivamente
		// il periodo dello stato.
		if (_periodo.coincideCon(periodo)) {
			// Aggiungo il servizio alla lista dei servizi per questo stato della camera.
			_serviziInterni.add(servizio);
		}
	}

}
