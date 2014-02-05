package com.iHotel.model;

import java.util.*;

public class MPrenotazione {

	private Collection<MElementoPrenotazione> _elementiPrenotazione;
	private MOspite _ospite;
	private MPeriodo _periodo;
	private String _codice;
	private boolean _completata;

	/**
	 * 
	 * @param ospite
	 */
	public void addOspite(MOspite ospite) {
		// TODO - implement MPrenotazione.addOspite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ep
	 */
	public void addElementoPrenotazione(MElementoPrenotazione ep) {
		// TODO - implement MPrenotazione.addElementoPrenotazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodo
	 */
	public void addPeriodo(MPeriodo periodo) {
		// TODO - implement MPrenotazione.addPeriodo
		throw new UnsupportedOperationException();
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