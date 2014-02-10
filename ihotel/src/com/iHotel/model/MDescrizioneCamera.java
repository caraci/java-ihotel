package com.iHotel.model;

import java.util.*;

public class MDescrizioneCamera {

	private ArrayList<MPrezzoCamera> _prezziCamera;
	private String _tipologia;

	
	/**
	 * 
	 * @param periodo
	 */
	public ArrayList<MPrezzoCamera> getPrezziInPeriodo(MPeriodo periodo) {
		ArrayList<MPrezzoCamera> pc = new ArrayList<MPrezzoCamera>();
		
		for (Iterator<MPrezzoCamera> iterator = _prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera tmp = iterator.next().getPrezzoInPeriodo(periodo);
			pc.add(tmp);
		}
		
		return pc;
	}
	

	/**
	 * @return the _prezziCamera
	 */
	public ArrayList<MPrezzoCamera> get_prezziCamera() {
		return _prezziCamera;
	}

	/**
	 * @param _prezziCamera the _prezziCamera to set
	 */
	public void set_prezziCamera(ArrayList<MPrezzoCamera> _prezziCamera) {
		this._prezziCamera = _prezziCamera;
	}

	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * 
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}
	


}