package com.iHotel.model;

import java.util.*;

public class MAlbergo {
    
	private MCatalogoCamere _catalogoCamere;
	private ArrayList<MCamera> _camere;
	private ArrayList<MPrenotazione> _prenotazioni;
	private String _nome;
	private String _telefono;
	private String _PIVA;
	private String _eMail;
	private Collection<MCamera> _camere2;
	  
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
		// TODO - implement MAlbergo.addPrenotazione
		throw new UnsupportedOperationException();
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
	/**
	 * Restituisce una lista di camere libere data una tipologia e un periodo
	 * @param periodo
	 * @param String
	 */
	public ArrayList<MCamera> cercaCamereLibereInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		ArrayList<MCamera> lista_camere = new ArrayList<MCamera>();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera tmp = iterator.next();
			System.out.println(tmp.get_numero());
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
		HashMap<String,ArrayList<MPrezzoCamera>> p  = new HashMap<String,ArrayList<MPrezzoCamera>>();
		return p;
	}

	public Collection<MCamera> get_camere2() {
		return this._camere2;
	}

	public void set_camere2(Collection<MCamera> _camere2) {
		this._camere2 = _camere2;
	}
	
	
	
	 

}