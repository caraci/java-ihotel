/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Access.ViewPanelFactory;
import com.iHotel.view.Graphic.GestionePrenotazione.VPGP_InfoPrenotazione;

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
		// Recupero il prezzo dei servizi esterni della prenotazione, attraverso serviceFactory.
		Prezzo prezzo=ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(_prenotazione);
		
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPGP_InfoPrenotazione infoPrenotazione = ViewPanelFactory.getPanelInfoSoggiorno(_prenotazione);
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(infoPrenotazione);
		// Creo il frame
		infoPrenotazione.creaPanel(_prenotazione, prezzo);
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
