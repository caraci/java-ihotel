/**
 * 
 */
package com.iHotel.model.ForeignSystem;

import java.util.ArrayList;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * Questa classe rappresenta l'interfaccia ai sistemi esterni che forniscono servizi esterni all'albergo. 
 * (e.g.:telefono e pay tv).
 * 
 * @author Alessandro
 */
public interface IServiceSystem {	
	/**
	 * Metodo per ottenere il prezzo totale dei servizi per una prenotazione.
	 * 
	 * @param prenotazione Prenotazione da analizzare.
	 * @return Prezzo totale dei servizi richiesti da una prenotazione.
	 */
	public Prezzo getPrezzoTotaleServiziPrenotazione(SoggiornoContextSubject prenotazione);
	/**
	 * Metodo per ottenere la lista dei servizi richiesti da una camera in un certo periodo.
	 * 
	 * @param camera Camera da analizzare.
	 * @param periodo Periodo da analizzare.
	 * @return Lista di servizi.
	 */
	public ArrayList<ServizioEsterno> getElencoServiziCameraInPeriodo(Camera camera, Periodo periodo);
}
