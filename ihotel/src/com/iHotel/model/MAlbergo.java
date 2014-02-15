package com.iHotel.model;

import java.util.*;


public class MAlbergo {
    
	// Attributi
	private MCatalogoCamere _catalogoCamere;
	private ArrayList<MCamera> _camere;
	private ArrayList<MPrenotazione> _prenotazioni = new ArrayList<MPrenotazione>();
	private String _nome = "Hotel MAraviglioso";
	private String _telefono = "123123123";
	private String _PIVA = "123456789ABCDEF";
	private String _eMail = "info@hotelmAraviglioso.com";
	// Singleton 
	private static MAlbergo instance = null;
	
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private MAlbergo() {}
	
	// Metodi di classe
	/**
	 * 
	 * @return instance
	 */
	public static MAlbergo getInstance() {
    	if(instance == null) {
            instance = new MAlbergo();
         }
         return instance;
    }
	
	// Metodi dell'instanza
	/**
	 * Metodo per ricavare l'oggetto MCamera a partire dalla stringa contenente il suo numero.
	 * @param numeroCamera Stringa contenente il numero della camera da ricavare.
	 * @return MCamera MCamera relativa al numero richiesto.
	 */
	public MCamera getCameraDaNumero(String numeroCamera) {
		MCamera cameraRicercata = new MCamera();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera camera = (MCamera) iterator.next();
			if (camera.get_numero().equals(numeroCamera)) {
				cameraRicercata = camera;
			}
		}
		return cameraRicercata;
	}
	/**
	 * Restituisce una lista di camere libere data una tipologia e un periodo
	 * @param periodo
	 * @param tipologia
	 */
	public ArrayList<MCamera> cercaCamereLibereInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		ArrayList<MCamera> lista_camere = new ArrayList<MCamera>();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera camera = iterator.next();
			if (camera.get_tipologia().equals(tipologia)){
				if(camera.isLiberaInPeriodo(periodo)==true){
					lista_camere.add(camera);
				}
			}
		}
		return lista_camere;
	}
	/**
	 * 
	 * @param periodo
	 * @param tipologia
	 * @return catalogoCamere.getPrezziInPeriodoDaTipologia(MPeriodo,String)
	 * Metodo che restituisce una HashMap in cui la chiave è la tipolgia della camera e il valore
	 * è un arraylist di MPrezzoCamera
	 */
	public HashMap<String,ArrayList<MPrezzoCamera>> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		MCatalogoCamere catalogoCamere =MCatalogoCamere.getInstance();
		return catalogoCamere.getPrezziInPeriodoDaTipologia(periodo, tipologia);
	}

	// Getter, Setter
	/**
	 * @return the _catalogoCamere
	 * Metodo che restituisce l'oggetto MCatalogoCamere associato all'MAlbergo
	 */
	public MCatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}

	/**
	 * @param _catalogoCamere the _catalogoCamere to set
	 * Metodo che associa l' MCatalogoCamere passato come parametro all'MAlbergo corrente
	 */
	public void set_catalogoCamere(MCatalogoCamere _catalogoCamere) {
		this._catalogoCamere = _catalogoCamere;
	}


	/**
	 * @return the _camere
	 * Meotodo che restituisce l'arraylist contenente tutte le camere dell'albergo
	 */
	public ArrayList<MCamera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere the _camere to set
	 * Metodo che associa l'arraylist di MCamera passata come parametro all'MAlbergo attuale
	 */
	public void set_camere(ArrayList<MCamera> _camere) {
		this._camere = _camere;
	}

	/**
	 * @return the _prenotazioni
	 * Metodo che restituisce l'arraylist contenente le MPrenotazioni associate all'MAlbergo
	 */
	public ArrayList<MPrenotazione> get_prenotazioni() {
		return _prenotazioni;
	}

	/**
	 * @param _prenotazioni the _prenotazioni to set
	 * Metodo che associa un'arraylist di MPrenotazione all'MAlbergo corrente
	 */
	public void set_prenotazioni(ArrayList<MPrenotazione> _prenotazioni) {
		this._prenotazioni = _prenotazioni;
	}

	/**
	 * 
	 * @param prenotazione
	 * Metodo che aggiunge una MPrenotazione alla lista di MPrenotazioni
	 */
	public void addPrenotazione(MPrenotazione prenotazione) {
		this._prenotazioni.add(prenotazione);
	}
	/**
	 * 
	 * @return _nome
	 * Metodo che restituisce il nome dell'MAlbergo corrente
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * 
	 * @param _nome
	 * Metodo che serve a settare il nome dell'MAlbergo corrente
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * 
	 * @return _telefono
	 * Metodo che restituisce il numero di telefono dell'MAlbergo corrente
	 */
	public String get_telefono() {
		return this._telefono;
	}

	/**
	 * 
	 * @param _telefono
	 * Metood che serve a settare il numero di telefono dell'MAlbergo corrente
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}
	/**
	 * 
	 * @return _PIVA
	 * Metodo che restituisce la partita iva dell'MAlbergo corrente
	 */
	public String get_PIVA() {
		return this._PIVA;
	}

	/**
	 * 
	 * @param _PIVA
	 * Metodo che serve a settare la partita iva dell'MAlbergo corrente
	 */
	public void set_PIVA(String _PIVA) {
		this._PIVA = _PIVA;
	}
	/**
	 * 
	 * @return _email
	 * Metodo che restituisce l'indirizzo email dell'MAlbergo corrente
	 */
	public String get_eMail() {
		return this._eMail;
	}

	/**
	 * 
	 * @param _eMail
	 * Metodo che serve a settare l'indirizzo email dell'MAlbergo corrente
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}	 

}