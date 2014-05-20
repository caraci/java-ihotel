package com.iHotel.model.ForeignSystem.Telephone;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe è l'interfaccia all'adattatore del sistema esterno riguardante il servizio di "Telefono in camera"
 * 
 * @author Alessandro
 */
public interface ITelephoneAdapter {
	/**
	 * Metodo per ottenere l'elenco di servizi del sistema esterno.
	 * @return Lista di servizi del sistema esterno.
	 */
	public LinkedList<ServizioTelefono> getElencoTelefonate();
	/**
	 * Metodo per ottenere il prezzo totale dei servizi richiesti da una prenotazione.
	 * 
	 * @param prenotazione Prenotazione in analisi.
	 * @return Prezzo totale dei servizi di telefonia di cui si è usufruito nella prenotazione.
	 */
	public Prezzo getPrezzoTotaleServiziPrenotazione(SoggiornoContextSubject prenotazione);
	/**
	 * Metodo per ottenere la lista dei serviziTelefono richiesti da una camera in un periodo.
	 * 
	 * @param camera Camera in analisi.
	 * @param periodo Periodo in analisi.
	 * @return Lista dei serviziTelefono richiesti da una camera in un periodo.
	 */
	public ArrayList<ServizioTelefono> getElencoServiziTelefonoCameraInPeriodo(Camera camera, Periodo periodo);
}