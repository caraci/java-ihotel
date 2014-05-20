/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.Graphic.GestionePrenotazione.VFPG_InfoPrenotazione;

/**
 * @author Eugenio
 *
 */
public class CGestionePrenotazione {
	/**
	 * Prenotazione che si sta gestendo.
	 */
	protected SoggiornoContextSubject _prenotazione;
	/**
	 * Albergo che si sta analizzando.
	 */
	protected Albergo _albergo;

	/**
	 * Metodo per mostrare l'interfaccia per la gestione della prenotazione, relativa al codice fornito.
	 * @param codicePrenotazione Codice della prenotazione da caricare.
	 */
	public void recuperaPrenotazioneDaCodice(String codicePrenotazione) {
		// Recupero la prenotazione dallo storico.
		_prenotazione=Storico.getInstance().recuperaPrenotazioneDaCodice(codicePrenotazione);
		// Recupero il prezzo dei servizi esterni della prenotazione.
		Prezzo prezzo=_albergo.getPrezzoServiziEsterniPrenotazione(_prenotazione);
		// Prendo l'interfaccia correlata.
		VFPG_InfoPrenotazione infoPrenotazione = VFPG_InfoPrenotazione.getInstance();
		// Creo l'interfaccia relativa alla prenotazione
		infoPrenotazione.creaFrame(_prenotazione, prezzo);		
		// Mostro l'interfaccia relativa alla gestione della prenotazione
		ViewHandler.getInstance().showFrame(infoPrenotazione);
	}

	/**
	 * @return the _prenotazione
	 */
	protected SoggiornoContextSubject get_prenotazione() {
		return _prenotazione;
	}

	/**
	 * @param _prenotazione the _prenotazione to set
	 */
	protected void set_prenotazione(SoggiornoContextSubject _prenotazione) {
		this._prenotazione = _prenotazione;
	}

	/**
	 * @return the _albergo
	 */
	protected Albergo get_albergo() {
		return _albergo;
	}

	/**
	 * @param _albergo the _albergo to set
	 */
	protected void set_albergo(Albergo _albergo) {
		this._albergo = _albergo;
	}

}
