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
			System.out.println("Tipologia uguale");
			for (Iterator<MStatoCamera> iterator = _statiCamera.iterator(); iterator.hasNext();) {
				MStatoCamera tmp = iterator.next();
				System.out.println(tmp.get_periodo().get_giornoInizio() + " " + tmp.get_periodo().get_meseInizio());
				System.out.println(tmp.get_periodo().get_giornoFine() + " " + tmp.get_periodo().get_meseFine());

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
	 * restituisce i prezzi
	 * 
	 */
	public void getPrezzi(MPeriodo periodo){
		
	}

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

	/**
	 * @return the _descrizioneCamera
	 */
	public MDescrizioneCamera get_descrizioneCamera() {
		return _descrizioneCamera;
	}

	/**
	 * @param _descrizioneCamera the _descrizioneCamera to set
	 */
	public void set_descrizioneCamera(MDescrizioneCamera _descrizioneCamera) {
		this._descrizioneCamera = _descrizioneCamera;
	}

}
