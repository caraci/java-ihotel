package com.iHotel.model.Albergo;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.utility.ULeggiDaFile;

/**
 * Questa classe rappresenta il concetto di "Albergo" del mondo reale.
 * 
 * @author Alessandro
 */
public class Albergo {
    
	/* -------------------- Attributi e costruttore --------------------------*/
	/**
	 * Lista delle camere dell'albergo.
	 */
	private ArrayList<Camera> _camere;
	/**
	 * Nome dell'albergo.
	 */
	private String _nome;
	/**
	 * Telefono dell'albergo.
	 */
	private String _telefono;
	/**
	 * Partita IVA dell'albergo.
	 */
	private String _PIVA;
	/**
	 * eMail dell'albergo.
	 */
	private String _eMail;
	/**
	 * Istanza unica di questa classe - Pattern Singleton.
	 */
	private static Albergo instance = null;
	
	
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private Albergo() {
		/*
		 * Si prendono nome, telefono, partita IVA e email dal defaultLoader, togliendo dalla classe  
		 * MAlbergo la responsabilit� di recuperare i dati di default.
		 */
        ArrayList<String> informazioniAlbergo;
        informazioniAlbergo=ULeggiDaFile.getInformazioniAlbergo();
        _nome = informazioniAlbergo.get(0);
        _telefono = informazioniAlbergo.get(1);
        _PIVA = informazioniAlbergo.get(2);
        _eMail=informazioniAlbergo.get(3);
	}
	
	/* ----------------------------- Metodi di classe -----------------------*/
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton.
	 */
	public static Albergo getInstance() {
    	if(instance == null) {
            instance = new Albergo();
         }
         return instance;
    }
	/* -------------------- Metodi di instanza ----------------------*/
	/**
	 * Metodo per ricavare la camera a partire dalla stringa contenente il suo numero.
	 * 
	 * @param numeroCamera Stringa contenente il numero della camera da ricavare.
	 * @return cameraRicercata Camera che ha il numero passato come parametro.
	 */
	public Camera getCameraDaNumero(String numeroCamera) {
		Camera cameraRicercata = null;
		for (Iterator<Camera> iterator = _camere.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
			if (camera.get_numero().equals(numeroCamera)) {
				cameraRicercata = camera;
			}
		}
		return cameraRicercata;
	}
	/**
	 * Restituisce una lista di camere libere di una tipologia e in un periodo.
	 * 
	 * @param periodo Periodo in analisi.
	 * @param tipologia Tipologia delle camere da ricercare.
	 * @return Lista contenente le camere libere della tipologia indicata, nel periodo indicato.
	 */
	public ArrayList<Camera> cercaCamereLibereInPeriodoDaTipologia(Periodo periodo, String tipologia){
		ArrayList<Camera> lista_camere = new ArrayList<Camera>();
		for (Iterator<Camera> iterator = _camere.iterator(); iterator.hasNext();) {
			Camera camera = iterator.next();
			// Controllo se la tipologia della camera � uguale a quella per cui stiamo cercando informazioni
			if (camera.get_tipologia().equals(tipologia)){
				// Controllo se la camera � libera nel periodo richiesto.
				if(camera.isLiberaInPeriodo(periodo)==true){
					lista_camere.add(camera);
				}
			}
		}
		return lista_camere;
	}
	/**
	 * Restituisce una mappa contenente l'insieme di tutte le camere di diverse tipologie, libere in
	 * un certo periodo.
	 * 
	 * @param periodo Periodo in analisi.
	 * @param tipologie Lista delle tipologie di camere che si vogliono ricercare.
	 * @return Mappa contenente come chiave la tipologia, e come valore la lista di camere libere di quella tipologia.
	 */
	public HashMap<String, ArrayList<Camera>> cercaCamereLibereInPeriodoDaTipologie(Periodo periodo, ArrayList<String> tipologie) {
		// Struttura dati nella quale andremo a salvare le camera libere suddivise per tipologia.
		HashMap<String, ArrayList<Camera>> camereLibere = new HashMap<String, ArrayList<Camera>>();
		// Ciclo sulle tipologie
		for (Iterator<String> iterator = tipologie.iterator(); iterator.hasNext();) {
			String tipologia = iterator.next();
			// Struttura dati nella quale si inseriranno le camere disponibili.
			ArrayList<Camera> camereLibereTipologia = new ArrayList<Camera>();	
			// Inserisco nella lista le camere disponibili.
			camereLibereTipologia = this.cercaCamereLibereInPeriodoDaTipologia(periodo, tipologia);		
			// Aggiungo le camere appartenenti ad una tipologia
			camereLibere.put(tipologia, camereLibereTipologia);
		}
		return camereLibere;
	}

	/*---------------------- Getter e Setter --------------------*/

	/**
	 * @return _camere
	 */
	public ArrayList<Camera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere
	 */
	public void set_camere(ArrayList<Camera> _camere) {
		this._camere = _camere;
	}
	/**
	 * @return _nome
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * @param _nome 
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * @return _telefono 
	 */
	public String get_telefono() {
		return this._telefono;
	}

	/**
	 * @param _telefono 
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}
	/**
	 * @return _PIVA 
	 */
	public String get_PIVA() {
		return this._PIVA;
	}

	/**
	 * @param _PIVA 
	 */
	public void set_PIVA(String _PIVA) {
		this._PIVA = _PIVA;
	}
	/**
	 * @return _email 
	 */
	public String get_eMail() {
		return this._eMail;
	}

	/**
	 * @param _eMail 
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}	 

}