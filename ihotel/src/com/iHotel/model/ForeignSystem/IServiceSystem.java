/**
 * 
 */
package com.iHotel.model.ForeignSystem;

import java.util.ArrayList;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public interface IServiceSystem {	
	/**
	 * Metodo per ottenere il prezzo totale dei servizi per una prenotazione.
	 * @param prenotazione Prenotazione da analizzare.
	 * @return Prezzo totale dei servizi richiesti da una prenotazione.
	 */
	public Prezzo getPrezzoTotaleServiziPrenotazione(PrenotazioneSubject prenotazione);
	/**
	 * Metodo per ottenere la lista dei servizi richiesti da una camera in un certo periodo.
	 * @param camera Camera da analizzare.
	 * @param periodo Periodo da analizzare.
	 * @return Lista di servizi.
	 */
	public ArrayList<ServizioEsterno> getElencoServiziCameraInPeriodo(CameraContext camera, Periodo periodo);
}
