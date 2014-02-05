package com.iHotel.model;

import java.util.*;

public class MPrenotazione {

	private Collection<MElementoPrenotazione> _elementiPrenotazione;
	private MOspite _ospite;
	private MPeriodo _periodo;
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