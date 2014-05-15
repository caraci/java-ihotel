/**
 * 
 */
package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe che realizza un generico stato della camera, questo potrà poi essere uno stato "libero" o "occupato". Si
 * è applicato il pattern State.
 * 
 * @author Eugenio
 */
public abstract class CameraState {
	/* -------------------------- Attributi ---------------------------------- */
	/**
	 * Periodo dello stato camera.
	 */
	protected Periodo _periodo;
	/**
	 * Ospiti della camera in questo stato.
	 */
	protected ArrayList<Ospite> _ospiti;
	/**
	 * Lista dei servizi interni in questo stato.
	 */
	protected ArrayList<ServizioInterno> _serviziInterni;
	/**
	 * Prezzo totale dei servizi interni richiesti in questo stato.
	 */
	protected Prezzo _prezzoServizi;
	/**
	 * Costruttore
	 */
	protected CameraState() {
		_serviziInterni=new ArrayList<ServizioInterno>();
		_ospiti=new ArrayList<Ospite>();
		_prezzoServizi=new Prezzo();
	}
	/* ------------------------ Metodi di instanza --------------------------- */
	/**
	 * Metodo per occupare la camera in un periodo.
	 * 
	 * @param periodo Periodo in cui occupare la camera.
	 * @return Lista di stati della camera in seguito all'occupazione.
	 */
	public abstract LinkedList<CameraState> occupaInPeriodo(Periodo periodo);
	/**
	 * Metodo per controllare se la camera è libera in un periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return True se libera. False altrimenti.
	 */
	public abstract boolean isLiberaInPeriodo(Periodo periodo);
	/**
	 * Metodo per ottenere il prezzo totale dei servizi interni della camera nel periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Prezzo totale dei servizi.
	 */
	public abstract Prezzo getPrezzoTotaleServizi(Periodo periodo);
	/**
	 * Metodo per aggiungere un servizio interno in un periodo alla camera.
	 * 
	 * @param servizio Servizio da aggiungere.
	 * @param periodo Periodo in cui aggiungere il servizio.
	 */
	public abstract void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo);
	/**
	 * Metodo per ottenere la lista dei servizi interni della camera.
	 * 
	 * @param periodo Periodo in cui aggiungere il servizio.
	 * @return Lista dei servizi interni della camera.
	 */
	public abstract ArrayList<ServizioInterno> getServiziInterniInPeriodo(Periodo periodo);
	/**
	 * Metodo per ottenere la lista degli ospiti della camera.
	 * 
	 * @param periodo Periodo in analisi.
	 * @return Lista degli ospiti della camera.
	 */
	public abstract ArrayList<Ospite> getOspitiInPeriodo(Periodo periodo);
	
	/* -------------------------- Getter, Setter ----------------------------- */
	/**
	 * @return the _periodo
	 */
	public Periodo get_periodo() {
		return _periodo;
	}
	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * @return the _prezzoServizi
	 */
	public Prezzo get_prezzoServizi() {
		return _prezzoServizi;
	}
	/**
	 * @param _prezzoServizi the _prezzoServizi to set
	 */
	public void set_prezzoServizi(Prezzo _prezzoServizi) {
		this._prezzoServizi = _prezzoServizi;
	}
}

