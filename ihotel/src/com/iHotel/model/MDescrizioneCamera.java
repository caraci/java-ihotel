package com.iHotel.model;

import java.util.*;

public class MDescrizioneCamera {

	/* -------------------------- Attributi -------------------------------------- */
	
	private ArrayList<MPrezzoCamera> _prezziCamera=new ArrayList<MPrezzoCamera>();
	private String _tipologia;

	/* ----------------------- Metodi di instanza ----------------------------------------- */
	
	/**
	 * Metodo per ottenere tutti i prezzi per una tipologia di camera, in un certo periodo.
	 * 
	 * @param periodo	Periodo generico
	 * @return 			prezzi per una tipologia di camera in un periodo
	 */
	public ArrayList<MPrezzoCamera> getPrezziInPeriodo(MPeriodo periodo) {
		ArrayList<MPrezzoCamera> prezziCamera = new ArrayList<MPrezzoCamera>();
		MPrezzoCamera prezzoCameraPeriodo = new MPrezzoCamera();
		// Ciclo sugli MPrezzoCamera 
		for (Iterator<MPrezzoCamera> iterator = _prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera prezzoCamera = iterator.next();
			// Se otteniamo un MPrezzoCamera valido lo aggiungo alla lista.
			if(prezzoCamera.getPrezzoInPeriodo(periodo) != null) {
				prezzoCameraPeriodo = prezzoCamera.getPrezzoInPeriodo(periodo);
				//System.out.println(prezzoCameraPeriodo.get_prezzo());
				prezziCamera.add(prezzoCameraPeriodo);
			}
		}		
		return prezziCamera;
	}
	
	/* ------------------------------- Getter e Setter -------------------- */
	/**
	 * @return _prezziCamera  
	 */
	public ArrayList<MPrezzoCamera> get_prezziCamera() {
		return _prezziCamera;
	}

	/**
	 * @param _prezziCamera 
	 */
	public void set_prezziCamera(ArrayList<MPrezzoCamera> _prezziCamera) {
		this._prezziCamera = _prezziCamera;
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

	/**
	 * 
	 * @param periodo
	 */
	public double calcolaPrezzoInPeriodo(MPeriodo periodo) {
		// TODO - implement MDescrizioneCamera.calcolaPrezzoInPeriodo
		throw new UnsupportedOperationException();
	}
	


}