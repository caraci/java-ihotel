package com.iHotel.model;

import java.util.*;

public class MPrenotazione {

	// Atrributi
	private ArrayList<MElementoPrenotazione> _elementiPrenotazione = new ArrayList<MElementoPrenotazione>();
	private MOspite _ospite;
	private MPeriodo _periodo;
	private String _codice;
	private boolean _completata;
	
	/* ----------------------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per ottenere il totale di una prenotazione
	 * @return double Totale della prenotazione.
	 */
	public double getTotal(){
		// Variabile nella quale andiamo a salvare il totale.
		double total=0;
		// Cicliamo su tutti gli elementi della prenotazione.
		for (Iterator<MElementoPrenotazione> iterator = _elementiPrenotazione.iterator(); iterator.hasNext();) {
			MElementoPrenotazione elementoPrenotazione = (MElementoPrenotazione) iterator.next();
			// Su ogni elemento prenotazione andiamo a chiedere il subTotale e lo sommiamo al totale.
			total += elementoPrenotazione.getSubTotal(_periodo);
			System.out.println(total);
		}
		return total;				
	}
	
	/**
	 * Metodo per aggiungere un elemento alla prenotazione.
	 * @param MCamera Camera da aggiungere alla prenotazione
	 */
	public void addElementoPrenotazione(MCamera camera) {
		MElementoPrenotazione elementoPrenotazione= new MElementoPrenotazione();
		elementoPrenotazione.set_camera(camera);
		_elementiPrenotazione.add(elementoPrenotazione);
	}
	/**
	 * Metodo per concludere una prenotazione e memorizzare l'ospite prenotante.
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
	
	/* -------------------------------- Getter, Setter ------------------------------------------ */
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
	 * @throws CloneNotSupportedException 
	 */
	public void set_completata(boolean _completata) {
		for (Iterator<MElementoPrenotazione> iterator = this._elementiPrenotazione.iterator(); iterator.hasNext();) {
			MElementoPrenotazione elementoPrenotazione = (MElementoPrenotazione) iterator.next();
			elementoPrenotazione.get_camera().occupaInPeriodo(_periodo);
		}
		this._completata = _completata;
	}

}