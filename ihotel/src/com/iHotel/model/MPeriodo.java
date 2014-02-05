package com.iHotel.model;

import java.util.*;

public class MPeriodo {

	private Date _dataInizio;
	private Date _dataFine;

	public Date get_dataInizio() {
		return this._dataInizio;
	}

	/**
	 * 
	 * @param _dataInizio
	 */
	public void set_dataInizio(Date _dataInizio) {
		this._dataInizio = _dataInizio;
	}

	public Date get_dataFine() {
		return this._dataFine;
	}

	/**
	 * 
	 * @param _dataFine
	 */
	public void set_dataFine(Date _dataFine) {
		this._dataFine = _dataFine;
	}

}