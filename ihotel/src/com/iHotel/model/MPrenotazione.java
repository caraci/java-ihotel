package com.iHotel.model;

import java.util.*;

public class MPrenotazione {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	private ArrayList<MCamera> _camerePrenotate = new ArrayList<MCamera>();
	private MPeriodo _periodo;
	private boolean _completata;
	private IMPrenotante _prenotante;
	
	public MPrenotazione() {}
	/* ----------------------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per ottenere il totale di una prenotazione.
	 * 
	 * @return Totale della prenotazione.
	 */
	public double getTotal(){
		// Variabile nella quale andiamo a salvare il totale.
		double total=0;
		// Cicliamo su tutti gli elementi della prenotazione.
		for (Iterator<MElementoPrenotazione> iterator = _elementiPrenotazione.iterator(); iterator.hasNext();) {
			MElementoPrenotazione elementoPrenotazione = (MElementoPrenotazione) iterator.next();
			// Su ogni elemento prenotazione andiamo a chiedere il subTotale e lo sommiamo al totale.
			total+=elementoPrenotazione.getSubTotal(_periodo);
		}
		return total;				
	}
	
	/**
	 * Metodo per aggiungere un elemento alla prenotazione.
	 * @param camera Camera da aggiungere alla prenotazione
	 */
	public void addCamera(MCamera camera) {
		MElementoPrenotazione elementoPrenotazione= new MElementoPrenotazione();
		elementoPrenotazione.set_camera(camera);
		_elementiPrenotazione.add(elementoPrenotazione);
	}
	/**
	 * Metodo per aggiungere l'ospite prenotante.
	 * @param nome Nome dell'ospite.
	 * @param cognome Cognome dell'ospite.
	 * @param eMail eMail dell'ospite.
	 * @param telefono Telefono dell'ospite.
	 */
	public void addPrenotante(String nome, String cognome, String eMail, String telefono){
		_ospite = new MOspite();
		_ospite.set_nome(nome);
		_ospite.set_cognome(cognome);
		_ospite.set_eMail(eMail);
		_ospite.set_telefono(telefono);
	}
	/**
	 * Metodo per occupare le camere della prenotazione.
	 */
	public void occupaCamere() {
		for (Iterator<MElementoPrenotazione> iterator = this._elementiPrenotazione.iterator(); iterator.hasNext();) {
			MElementoPrenotazione elementoPrenotazione = (MElementoPrenotazione) iterator.next();
			elementoPrenotazione.occupaCameraInPeriodo(_periodo);
		}
	}
		
	/* -------------------------------- Getter, Setter ------------------------------------------ */
	/**
	 * @return _elementiPrenotazione
	 */
	public ArrayList<MCamera> get_camerePrenotate() {
		return _camerePrenotate;
	}

	/**
	 * @param _elementiPrenotazione
	 */
	public void set_camerePrenotate(ArrayList<MCamera> _elementiPrenotazione) {
		this._camerePrenotate = _elementiPrenotazione;
	}

	/**
	 * @return  _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo 
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * @param _completata 
	 */
	public boolean get_completata() {
		return this._completata;
	}
	/**
	 * @param _completata 
	 */
	public void set_completata(boolean _completata) {
		this._completata = _completata;
	}

}