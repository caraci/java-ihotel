package com.iHotel.model;

import java.util.*;

public class MPeriodo {

	private Calendar _dataInizio;
	private Calendar _dataFine;

	public Calendar get_dataInizio() {
		return this._dataInizio;
	}

	/**
	 * 
	 * @param dataInizio_1
	 */
	public void set_dataInizio(Calendar dataInizio_1) {
		this._dataInizio = dataInizio_1;
	}

	public Calendar get_dataFine() {
		return this._dataFine;
	}

	/**
	 * 
	 * @param dataFine_1
	 */
	public void set_dataFine(Calendar dataFine_1) {
		this._dataFine = dataFine_1;
	}

}