/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoStateObserver;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public abstract class SoggiornoState {
	/**
	 * Soggiorno a cui è associato lo stato - Pattern State
	 */
	protected SoggiornoContextSubject _soggiornoContext;
	/**
	 * Stato del pagamento relativo al soggiorno, context per questo state - Pattern State.
	 */
	protected PagamentoStateObserver _pagamentoState;
	/**
	 * Costruttore.
	 * 
	 * @param soggiornoSubject Soggiorno a cui è associato lo stato.
	 */
	public SoggiornoState(SoggiornoContextSubject soggiornoSubject) {
		_soggiornoContext=soggiornoSubject;
	}
	/**
	 * Costruttore.
	 * 
	 * @param soggiornoSubject Soggiorno a cui è associato lo stato.
	 * @param pagamentoState Stato del pagamento associato allo stato corrente del soggiorno.
	 */
	public SoggiornoState(SoggiornoContextSubject soggiornoSubject, PagamentoStateObserver pagamentoState) {
		_soggiornoContext = soggiornoSubject;
		_pagamentoState = pagamentoState;
	}
	/* ------------------------- Metodi di istanza ----------------------------- */
	/**
	 * Metodo per ottenere il prezzo dei servizi interni di un soggiorno.
	 * 
	 * @return Prezzo dei servizi interni di un soggiorno.
	 */
	public Prezzo getPrezzoServiziInterni() {		
		// Passo la richiesta allo stato del pagamento attuale
		return _pagamentoState.getPrezzoServiziInterni();
	}
	/**
	 * Metodo per calcolare il totale delle camere di un soggiorno.
	 */
	public void calcolaImportoTotaleCamere() {
		// Passo la richiesta allo stato del pagamento attuale
		_pagamentoState.calcolaImportoTotaleCamere();
	}
	/**
	 * Metodo per aggiungere un pagamento al soggiorno.
	 * 
	 * @param pagamento Pagamento effettuato a favore del soggiorno.
	 */
	public void addPagamento(Pagamento pagamento) {
		// Passo la richiesta allo stato del pagamento attuale
		_pagamentoState.addPagamento(pagamento);
	}
	/**
	 * Metodo che restituisce l'importo che rimane da pagare per il soggiorno passato come parametro.
	 * L'importo è calcolato come la somma dell'importo delle camere, dei servizi interni, dei servizi esterni
	 * al netto dei versamenti giò effettuati.
	 * 
	 * @return Importo rimanente da pagare per il soggiorno.
	 */
	public Prezzo calcolaImportoRimanenteDaPagare(){
		// Passo la richiesta allo stato del pagamento attuale
		return _pagamentoState.calcolaImportoRimanenteDaPagare();
	}
	
	/**
	 * Metodo che calcola il costo totale del soggiorno comprensivo di totale camere, totale servizi
	 * interni e totale servizi esterni
	 * 
	 * @return Il costo totale della prenotazione
	 */
	public Prezzo calcolaCostoTotaleSoggiorno(){
		// Passo la richiesta allo stato del pagamento attuale
		return _pagamentoState.calcolaCostoTotaleSoggiorno();
	}
	/**
	 * Metodo per aggiungere una camera al soggiorno.
	 * 
	 * @param camera Camera da aggiungere.
	 */
	public abstract void addCamera(Camera camera);
	/**
	 * Metodo per aggiungere il cliente prenotante al soggiorno.
	 * 
	 * @param nome Nome del cliente prenotante.
	 * @param cognome Cognome del cliente prenotante.
	 * @param eMail eMail del cliente prenotante.
	 * @param telefono Telefono del cliente prenotante.
	 */
	public abstract void addPrenotante(String nome, String cognome, String eMail, String telefono);
	/**
	 * Metodo per occupare le camere riservate dal soggiorno.
	 */
	public abstract void occupaCamere();
	/**
	 * Metodo per completare la richiesta di soggiorno.
	 * 
	 * @param nome Nome del cliente prenotante.
	 * @param cognome Cognome del cliente prenotante.
	 * @param eMail eMail del cliente prenotante.
	 * @param telefono Telefono del cliente prenotante.
	 */
	public abstract void concludiPrenotazione(String nome, String cognome, String eMail, String telefono);
	/**
	 * Metodo per effettuare il check in dei clienti del soggiorno.
	 * @return Stato successivo del soggiorno.
	 */
	public abstract void effettuaCheckIn();
	/**
	 * Metodo per effettuare il check out dei clienti del soggiorno.
	 * @return Stato successivo del soggiorno.
	 */
	public abstract void effettuaCheckOut();
	
	
	/* ----------------- Getter, Setter ------------------- */
	/**
	 * @return the _soggiornoSubject
	 */
	public SoggiornoContextSubject get_soggiornoContext() {
		return _soggiornoContext;
	}
	/**
	 * @param _soggiornoSubject the _soggiornoSubject to set
	 */
	public void set_soggiornoContext(SoggiornoContextSubject _soggiornoSubject) {
		this._soggiornoContext = _soggiornoSubject;
	}
	/**
	 * @return the _pagamentoState
	 */
	public PagamentoStateObserver get_pagamentoState() {
		return _pagamentoState;
	}
	/**
	 * @param _pagamentoState the _pagamentoState to set
	 */
	public void set_pagamentoState(PagamentoStateObserver _pagamentoState) {
		this._pagamentoState = _pagamentoState;
	}
	
}
