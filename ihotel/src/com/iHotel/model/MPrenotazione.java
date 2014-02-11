package com.iHotel.model;

import java.util.*;

public class MPrenotazione {

	private ArrayList<MElementoPrenotazione> _elementiPrenotazione;
	private MOspite _ospite;
	private MPeriodo _periodo;
	private String _codice;
	private boolean _completata;

	
	public double getTotal(){
		double total =0;
		for (Iterator<MElementoPrenotazione> iterator = _elementiPrenotazione.iterator(); iterator.hasNext();) {
			MElementoPrenotazione elementoPrenotazione = (MElementoPrenotazione) iterator.next();
			total = total + elementoPrenotazione.getSubTotal(_periodo);
		}
		return total;				
	}
	
	/**
	 * 
	 * @param ep
	 */
	public void addElementoPrenotazione(MCamera camera) {
		MElementoPrenotazione elementoPrenotazione= new MElementoPrenotazione();
		elementoPrenotazione.set_camera(camera);
		_elementiPrenotazione.add(elementoPrenotazione);
	}
	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param eMail
	 * @param telefono
	 * @return
	 */
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono){
		MOspite ospite = new MOspite();
		ospite.set_nome(nome);
		ospite.set_cognome(cognome);
		ospite.set_eMail(eMail);
		ospite.set_telefono(telefono);
	}
	

	/**
	 * @return the _elementiPrenotazione
	 */
	public ArrayList<MElementoPrenotazione> get_elementiPrenotazione() {
		return _elementiPrenotazione;
	}

	/**
	 * @param _elementiPrenotazione the _elementiPrenotazione to set
	 */
	public void set_elementiPrenotazione(ArrayList<MElementoPrenotazione> _elementiPrenotazione) {
		this._elementiPrenotazione = _elementiPrenotazione;
	}

	/**
	 * @return the _ospite
	 */
	public MOspite get_ospite() {
		return _ospite;
	}

	/**
	 * @param _ospite the _ospite to set
	 */
	public void set_ospite(MOspite _ospite) {
		this._ospite = _ospite;
	}

	/**
	 * @return the _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}

	/**
	 * @return the _codice
	 */
	public String get_codice() {
		return _codice;
	}

	/**
	 * @param _codice the _codice to set
	 */
	public void set_codice(String _codice) {
		this._codice = _codice;
	}

	public boolean get_completata() {
		return this._completata;
	}

	/**
	 * 
	 * @param _completata
	 */
	public void set_completata(boolean _completata) {
		this._completata = _completata;
	}

}