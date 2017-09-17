package com.iHotel.model.Albergo.Camera;

import java.util.*;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Strategie.StrategieOccupazioneCamera.CreaStatiCameraStrategy;
import com.iHotel.model.Strategie.StrategieOccupazioneCamera.CreaStatiCameraStrategyFactory;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Utility.IObserver;

/**
 * Classe che realizza uno stato camera "libero".
 * 
 * @author Eugenio
 */
public class StatoCameraLibera extends StatoCamera {

	@Override
	public LinkedList<StatoCamera> occupaInPeriodo(Periodo periodoRichiesta) {
		// Lista degli stati da restituire alla camera.
		LinkedList<StatoCamera> nuoviStatiCamera=null;
		// Controllo che il periodo della richiesta � contenuto nel periodo dell'instanza.
		if (_periodo.contiene(periodoRichiesta)) {
			CreaStatiCameraStrategy creaStatiCameraStrategy = CreaStatiCameraStrategyFactory.getInstance().getStrategy(_periodo, periodoRichiesta);
			nuoviStatiCamera=creaStatiCameraStrategy.creaNuoviStati(this, periodoRichiesta);
		}
				
		return nuoviStatiCamera;
	}
	@Override
	public boolean isLiberaInPeriodo(Periodo periodo) {
		return get_periodo().contiene(periodo) ? true : false;
	}
	@Override
	public Prezzo getPrezzoTotaleServizi(Periodo periodo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void aggiungiServizio(ServizioInterno servizio) {
		// TODO Auto-generated method stub
	}
	@Override
	public ArrayList<ServizioInterno> getServiziInterniInPeriodo(Periodo periodo) {
		return null;
	}
	@Override
	public ArrayList<Ospite> getOspitiInPeriodo(Periodo periodo) {
		return null;
	}
	@Override
	public void aggiungiOspite(Ospite ospite) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}	
}
