package com.iHotel.model;

import java.util.*;

public class MDescrizioneCamera {

	private ArrayList<MPrezzoCamera> _prezziCamera=new ArrayList<MPrezzoCamera>();
	private String _tipologia;

	
	/**
	 * Metodo per ottenere tutti i prezzi per una tipologia di camera, in un certo periodo
	 * @param periodo	Periodo generico
	 * @return 			prezzi per una tipologia di camera in un periodo
	 */
	public ArrayList<MPrezzoCamera> getPrezziInPeriodo(MPeriodo periodo) {
		ArrayList<MPrezzoCamera> prezziCamera = new ArrayList<MPrezzoCamera>();
		// Ciclo sugli MPrezzoCamera 
		for (Iterator<MPrezzoCamera> iterator = _prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera prezzoCamera = iterator.next();
			prezzoCamera.getPrezzoInPeriodo(periodo);
			// Se otteniamo un MPrezzoCamera valido lo aggiungo alla lista.
			if(prezzoCamera.getPrezzoInPeriodo(periodo) != null) {
				MPrezzoCamera prezzoCameraPeriodo = new MPrezzoCamera();
				prezzoCameraPeriodo = prezzoCamera.getPrezzoInPeriodo(periodo);
				//System.out.println(prezzoCameraPeriodo.get_prezzo());
				prezziCamera.add(prezzoCameraPeriodo);
			}
		}		
		return prezziCamera;
	}
	
	/**
	 * @return _prezziCamera
	 * Metodo che restituisce tutti prezzi per una tipologia di camere 
	 */
	public ArrayList<MPrezzoCamera> get_prezziCamera() {
		return _prezziCamera;
	}

	/**
	 * @param _prezziCamera 
	 * Metodo che setta tutti prezzi per una tipologia di camere 
	 */
	public void set_prezziCamera(ArrayList<MPrezzoCamera> _prezziCamera) {
		this._prezziCamera = _prezziCamera;
	}

	/**
	 * @return _tipologia
	 * Metodo che restituisce la tipologia  
	 */
	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * 
	 * @param _tipologia
	 * Metodo che setta la topologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}
	


}