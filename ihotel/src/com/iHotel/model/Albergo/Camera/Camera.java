package com.iHotel.model.Albergo.Camera;

import java.util.*;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe che realizza una camera all'interno dell'albergo.
 * 
 * @author Eugenio
 */
public class Camera {

	/* --------------------------- Attributi e Costruttore ---------------------- */
	/**
	 * Stati della camera.
	 */
	private LinkedList<StatoCamera> _statiCameraState;
	private String _numero;
	private String _tipologia;
	/**
	 * Costruttore.
	 */
	public Camera() {
		_statiCameraState = new LinkedList<StatoCamera>();
	}
	/* -------------------------- Metodi di istanza ----------------------- */
	/**
	 * Metodo per aggiungere un ospite alla camera in un determinato periodo.
	 * 
	 * @param ospite Ospite da aggiungere.
	 * @param periodo Periodo in cui aggiungere il servizio.
	 */
	public void aggiungiOspiteInPeriodo(Ospite ospite, Periodo periodo) {
		// Prendo il giusto statoCamera in base al periodo.
		StatoCamera statoCamera = this.getStatoCameraInPeriodo(periodo);
		// Aggiungo l'ospite allo stato camera.
		statoCamera.aggiungiOspite(ospite);
	}
	/**
	 * Metodo per aggiungere un servizio alla camera in un determinato periodo.
	 * 
	 * @param servizio Servizio da aggiungere.
	 * @param periodo Periodo in cui aggiungere il servizio.
	 */
	public void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo){
		// Prendo il giusto statoCamera in base al periodo.
		StatoCamera statoCamera = this.getStatoCameraInPeriodo(periodo);
		statoCamera.aggiungiServizioInPeriodo(servizio, periodo);
	}
	/**
	 * Metodo per ottenere il prezzo dei servizi interni della camera in un certo periodo.
	 * 
	 * @param periodo Periodo per il quale si vuole ricercare il totale.
	 * @return Prezzo dei servizi della camera nel periodo.
	 */
	public Prezzo getPrezzoServiziInPeriodo(Periodo periodo){
		Prezzo prezzo = new Prezzo();
		// Ciclo sugli stati della camera
		for (Iterator<StatoCamera> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			StatoCamera cameraState = (StatoCamera) iterator.next();
			// Controllo che non mi venga fornito un null
			if(cameraState.getPrezzoTotaleServizi(periodo)!=null) {
				prezzo=cameraState.getPrezzoTotaleServizi(periodo);
			}
		}
		return prezzo;
	}
	/**
	 * Metodo per controllare se una camera è libera in un periodo.
	 * 
	 * @param periodoRichiesta Periodo nel quale si vuole prenotare la camera.
	 * @return True se la camera è libera nel periodo. False altrimenti.
	 */
	public boolean isLiberaInPeriodo(Periodo periodoRichiesta) {	
		boolean esito=false;
		for (Iterator<StatoCamera> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			StatoCamera statoCamera = iterator.next();				
			if(statoCamera.isLiberaInPeriodo(periodoRichiesta)==true) {					
				esito=true;	
			}
		}
		return esito; 
	}
	/**
	 * Metodo per occupare una camera in un periodo.
	 *  
	 * @param periodo Periodo in cui si vuole occupare la camera.
	 */
	public void occupaInPeriodoState(Periodo periodo) {
		// Lista degli stati camera che vengono restituiti dallo stato della camera
		List<StatoCamera> statiCameraDopoOccupazione;
		// Ciclo su tutti gli stati della camera
		for (int i = 0; i < _statiCameraState.size(); i++) {
			StatoCamera cameraState = _statiCameraState.get(i);
			// Controllo se mi viene restituita una lista di stati.
			// Solo uno stato può restituire la lista.
			// Assegno il risultato alla variabile statiCameraDopoOccupazione		
			statiCameraDopoOccupazione=cameraState.occupaInPeriodo(periodo);
			if(statiCameraDopoOccupazione!=null) {	
				// Rimuovo il vecchio stato camera.
				_statiCameraState.remove(i);
				// Aggiungo la lista ricavata dallo stato partendo dalla sua vecchia posizione.
				_statiCameraState.addAll(i, statiCameraDopoOccupazione);
			}
		}
	}	
	/**
	 * Metodo per ottenere la lista dei servizi interni relativi ad un periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Lista dei servizi interni della camera nel periodo.
	 */
	public ArrayList<ServizioInterno> getServiziInterniInPeriodo(Periodo periodo){
		ArrayList<ServizioInterno> serviziInterni=new ArrayList<ServizioInterno>();
		// Ricavo il giusto stato camera.
		StatoCamera statoCamera = this.getStatoCameraInPeriodo(periodo);
		// Ricavo la lista di servizi
		serviziInterni=statoCamera.getServiziInterniInPeriodo(periodo);
		
		return serviziInterni;
	}
	/**
	 * Metodo per ottenere la lista degli ospiti in un periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Lista degli ospiti della camera nel periodo.
	 */
	public ArrayList<Ospite> getOspitiInPeriodo(Periodo periodo){
		ArrayList<Ospite> ospiti=new ArrayList<Ospite>() ;
		// Ricavo il giusto stato camera.
		StatoCamera statoCamera = this.getStatoCameraInPeriodo(periodo);
		// Ricavo la lista di ospiti.
		ospiti=statoCamera.getOspitiInPeriodo(periodo);
		
		return ospiti;
	}
	/**
	 * Metodo per ottenere il corretto stato camera in relazione ad un periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Stato camera relativo al periodo.
	 */
	public StatoCamera getStatoCameraInPeriodo(Periodo periodo) {
		StatoCamera statoCameraPeriodo = null;
		// Ciclo sugli stati interni della camera.
		for (Iterator<StatoCamera> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			StatoCamera statoCamera = iterator.next();
			// Controllo se il periodo dello stato coincide con quello passato come parametro.
			if(statoCamera.get_periodo().coincideCon(periodo)){
				statoCameraPeriodo=statoCamera;
			}
		}
		return statoCameraPeriodo;
	}

	
	/*------------------ Getter e Setter --------------*/
	/**
	 * @return _statiCameraState 
	 */
	public LinkedList<StatoCamera> get_statiCamera() {
		return _statiCameraState;
	}
	/**
	 * @param _statiCameraState
	 */
	public void set_statiCamera(LinkedList<StatoCamera> _statiCameraState) {
		this._statiCameraState = _statiCameraState;
	}
	/**
	 * @return _numero
	 */
	public String get_numero() {
		return this._numero;
	}

	/**
	 * @param _numero
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
	}
	/**
	 * @return _tipologia
	 */
	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}
}
