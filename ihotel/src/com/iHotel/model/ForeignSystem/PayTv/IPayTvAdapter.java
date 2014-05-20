package com.iHotel.model.ForeignSystem.PayTv;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * Questa classe è l'interfaccia all'adattatore del sistema esterno riguardante il servizio di "Pay Tv".
 * 
 * @author Alessandro
 */
public interface IPayTvAdapter {
	/**
	 * Metodo per ottenere l'elenco di servizi del sistema esterno.
	 * 
	 * @return Lista di servizi del sistema esterno.
	 */
	public LinkedList<ServizioPayTv> getElencoEventi();
	/**
	 * Metodo per ottenere il prezzo totale dei servizi richiesti da una prenotazione.
	 * 
	 * @param prenotazione Prenotazione in analisi.
	 * @return Prezzo totale dei servizi di payTv di cui si è usufruito nella prenotazione.
	 */
	public Prezzo getPrezzoTotaleServiziPrenotazione(SoggiornoContextSubject prenotazione);
	/**
	 * Metodo per ottenere la lista dei serviziPayTv richiesti da una camera in un periodo.
	 * 
	 * @param camera Camera in analisi.
	 * @param periodo Periodo in analisi.
	 * @return Lista dei serviziPayTv richiesti da una camera in un periodo.
	 */
	public ArrayList<ServizioPayTv> getElencoServiziPayTvCameraInPeriodo(Camera camera, Periodo periodo);

}