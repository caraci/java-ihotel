package com.iHotel.model;

import java.util.*;

public class MCamera {

	private LinkedList<MStatoCamera> _statiCamera;
	private String _numero;
	private String _tipologia;
	private MDescrizioneCamera _descrizioneCamera;


	/**
	 * 
	 * @param periodo
	 * @param tipologia
	 */
	public boolean isLiberaInPeriodoDaTipologia(MPeriodo periodo, String tipologia) {
		if (tipologia.equals(_tipologia)){
			for (Iterator<MStatoCamera> iterator = _statiCamera.iterator(); iterator.hasNext();) {
				MStatoCamera tmp = iterator.next();
				if(tmp.isLiberaInPeriodo(periodo)==true){
					
					return true;
				} else {
					
					return false;
				}
			}
		}	
	 return false;
	}
	/**
	 * 
	 * @param periodo
	 * @return boolean
	 * scorredo l'array _statiCamera controllo se nel periodo che gli passo è libera o meno. Nel caso sia  libera 
	 * metto false _libera
	 * 
	 * RICONTROLLARE I RETURN
	 */
	public boolean occupaInPeriodo(MPeriodo periodo){
		for (Iterator<MStatoCamera> iterator = _statiCamera.iterator(); iterator.hasNext();){
			if(iterator.next().isLiberaInPeriodo(periodo)==true){
				iterator.next().set_libera(false);
				return true;
			}
		}
		return false;
	}

	

	// Getter, Setter
	/**
	 * @return the _statiCamera
	 */
	public LinkedList<MStatoCamera> get_statiCamera() {
		return _statiCamera;
	}

	/**
	 * @param _statiCamera the _statiCamera to set
	 */
	public void set_statiCamera(LinkedList<MStatoCamera> _statiCamera) {
		this._statiCamera = _statiCamera;
	}

	public String get_numero() {
		return this._numero;
	}

	/**
	 * 
	 * @param _numero
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
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

	public MDescrizioneCamera get_descrizioneCamera() {
		return this._descrizioneCamera;
	}

	public void set_descrizioneCamera(MDescrizioneCamera _descrizioneCamera) {
		this._descrizioneCamera = _descrizioneCamera;
	}

}
