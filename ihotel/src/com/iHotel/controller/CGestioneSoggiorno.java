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
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno;

/**
 * @author Eugenio
 *
 */
public class CGestioneSoggiorno {
	/**
	 * Prenotazione che si sta gestendo.
	 */
	protected SoggiornoContextSubject _soggiorno;
	/**
	 * Albergo che si sta analizzando.
	 */
	protected Albergo _albergo;

	/**
	 * Metodo per mostrare l'interfaccia per la gestione del soggiorno, relativo al codice fornito.
	 * 
	 * @param codiceSoggiorno Codice della soggiorno da caricare.
	 */
	public void recuperaPrenotazioneDaCodice(String codiceSoggiorno) {
		// Recupero la prenotazione dallo storico.
		_soggiorno=Storico.getInstance().recuperaSoggiornoDaCodice(codiceSoggiorno);
		// Recupero il prezzo dei servizi esterni della prenotazione, attraverso serviceFactory.
		Prezzo prezzo=ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(_soggiorno);
		
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPGP_InfoSoggiorno infoPrenotazione = ViewPanelFactory.getPanelInfoSoggiorno(_soggiorno);
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(infoPrenotazione);
		// Creo il frame
		infoPrenotazione.creaPanel(_soggiorno, prezzo);
	}

	/**
	 * @return the _soggiorno
	 */
	protected SoggiornoContextSubject get_soggiorno() {
		return _soggiorno;
	}

	/**
	 * @param _soggiorno the _soggiorno to set
	 */
	protected void set_soggiorno(SoggiornoContextSubject _soggiorno) {
		this._soggiorno = _soggiorno;
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
