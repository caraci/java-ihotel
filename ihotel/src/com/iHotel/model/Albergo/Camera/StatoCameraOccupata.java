package com.iHotel.model.Albergo.Camera;

import java.util.*;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Utility.IObserver;

/**
 * Classe che realizza uno stato camera "occupato".
 * 
 * @author Eugenio
 */
public class StatoCameraOccupata extends StatoCamera {

	@Override
	public LinkedList<StatoCamera> occupaInPeriodo(Periodo periodo) {
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
			_prezzoServizi.somma(descrizioneServizioInterno.getPrezzoInData(servizio.get_giorno()));
			// Comunico all'osservatore il cambio dello stato.
			this.Notify();
		}
	}
	@Override
	public ArrayList<ServizioInterno> getServiziInterniInPeriodo(Periodo periodo) {
		ArrayList<ServizioInterno> serviziInterniInPeriodo=null;
		// Controllo che il periodo di richiesta coincida con il periodo dello stato.
		if(_periodo.coincideCon(periodo)) {
			serviziInterniInPeriodo=this._serviziInterni;
		}
		return serviziInterniInPeriodo;
	}
	@Override
	public ArrayList<Ospite> getOspitiInPeriodo(Periodo periodo) {
		ArrayList<Ospite> ospitiInPeriodo=null;
		// Controllo che il periodo di richiesta coincida con il periodo dello stato.
		if(_periodo.coincideCon(periodo)) {
			ospitiInPeriodo=this._ospiti;
		}
		return ospitiInPeriodo;
	}
	@Override
	public void aggiungiOspite(Ospite ospite) {
		_ospiti.add(ospite);
	}
	@Override
	public void Attach(IObserver observer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Detach(IObserver observer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Notify() {
		// Comunichiamo all'osservatore che c'è stato un cambio nel suo stato.
		_observer.Update();
	}
}
