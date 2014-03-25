/**
 * 
 */
package com.iHotel.model.ForeignSystem;

import java.util.ArrayList;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public interface IServiceSystem {
	
	public Prezzo getPrezzoTotaleServiziPrenotazione(PrenotazioneSubject prenotazione);
	public ArrayList<ServizioEsterno> getElencoServiziCamera(CameraContext camera);
	
	

}
