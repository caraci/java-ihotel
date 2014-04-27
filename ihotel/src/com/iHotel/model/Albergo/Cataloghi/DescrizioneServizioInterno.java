package com.iHotel.model.Albergo.Cataloghi;


import java.util.Iterator;
import java.util.LinkedList;

import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class DescrizioneServizioInterno {
	
	/*-------------------------- Attributi --------------------------*/
	private String _codice;
	private String _nome;
	private String _descrizione;
	private LinkedList<PrezzoServizioInterno> _prezziServizio;
	
	public DescrizioneServizioInterno() {
		_prezziServizio=new LinkedList<PrezzoServizioInterno>();
	}
	/* ---------------------------- Metodi di instanza ------------------- */
	/**
	 * Metodo per ottenere il prezzo del servizio in un determinato periodo.
	 * 
	 * @param periodoRichiesta Periodo da analizzare.
	 * @return Prezzo del servizio nel periodo.
	 */
	public Prezzo getPrezzoInData(Periodo dataServizio) {
		Prezzo prezzo = null;
		// Ciclo su tutti i prezzi del servizio.
		for (Iterator<PrezzoServizioInterno> iterator = _prezziServizio.iterator(); iterator.hasNext();) {
			PrezzoServizioInterno prezzoServizioInterno = (PrezzoServizioInterno) iterator.next();
			// Controllo se viene restituito il prezzo o un null.
			if(prezzoServizioInterno.getPrezzoInData(dataServizio)!=null) {
				prezzo=prezzoServizioInterno.getPrezzoInData(dataServizio);
			}
		}
		return prezzo;
	}
	/*-------------------------- Getter e setter --------------------------*/

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
	/**
	 * @return the _nome
	 */
	public String get_nome() {
		return _nome;
	}

	/**
	 * @param _nome the _nome to set
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	/**
	 * @return the _descrizione
	 */
	public String get_descrizione() {
		return _descrizione;
	}
	/**
	 * @param _descrizione the _descrizione to set
	 */
	public void set_descrizione(String _descrizione) {
		this._descrizione = _descrizione;
	}
	/**
	 * @return the _prezziServizio
	 */
	public LinkedList<PrezzoServizioInterno> get_prezziServizio() {
		return _prezziServizio;
	}
	/**
	 * @param _prezziServizio the _prezziServizio to set
	 */
	public void set_prezziServizio(LinkedList<PrezzoServizioInterno> _prezziServizio) {
		this._prezziServizio = _prezziServizio;
	}
	
	/* --- UTILITY --- */
	public String toString() {
		String out;
		out = "Codice: " + get_codice() + "\n" +
			  "Nome : "  + get_nome();
		return out;	
	}

}