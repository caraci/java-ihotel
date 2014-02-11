package com.iHotel.model;

import java.util.*;


public class MAlbergo {
    
	// Attributi
	private MCatalogoCamere _catalogoCamere;
	private ArrayList<MCamera> _camere;
	private ArrayList<MPrenotazione> _prenotazioni;
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
	 * @return
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
			MCamera tmp = iterator.next();			
			if(tmp.isLiberaInPeriodoDaTipologia(periodo, tipologia)==true){
				lista_camere.add(tmp);
			}
		}
		return lista_camere;
	}
	/**
	 * 
	 * @param  periodo
	 * @param tipologia
	 */
	public HashMap<String,ArrayList<MPrezzoCamera>> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		MCatalogoCamere catalogoCamere =MCatalogoCamere.getInstance();
		return catalogoCamere.getPrezziInPeriodoDaTipologia(periodo, tipologia);
	}

	// Getter, Setter
	/**
	 * @return the _catalogoCamere
	 */
	public MCatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}

	/**
	 * @param _catalogoCamere the _catalogoCamere to set
	 */
	public void set_catalogoCamere(MCatalogoCamere _catalogoCamere) {
		this._catalogoCamere = _catalogoCamere;
	}


	/**
	 * @return the _camere
	 */
	public ArrayList<MCamera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere the _camere to set
	 */
	public void set_camere(ArrayList<MCamera> _camere) {
		this._camere = _camere;
	}

	/**
	 * @return the _prenotazioni
	 */
	public ArrayList<MPrenotazione> get_prenotazioni() {
		return _prenotazioni;
	}

	/**
	 * @param _prenotazioni the _prenotazioni to set
	 */
	public void set_prenotazioni(ArrayList<MPrenotazione> _prenotazioni) {
		this._prenotazioni = _prenotazioni;
	}

	/**
	 * 
	 * @param prenotazione
	 */
	public void addPrenotazione(MPrenotazione prenotazione) {
		this._prenotazioni.add(prenotazione);
	}

	public String get_nome() {
		return this._nome;
	}

	/**
	 * 
	 * @param _nome
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_telefono() {
		return this._telefono;
	}

	/**
	 * 
	 * @param _telefono
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}

	public String get_PIVA() {
		return this._PIVA;
	}

	/**
	 * 
	 * @param _PIVA
	 */
	public void set_PIVA(String _PIVA) {
		this._PIVA = _PIVA;
	}

	public String get_eMail() {
		return this._eMail;
	}

	/**
	 * 
	 * @param _eMail
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}

	
	
	
	 

}