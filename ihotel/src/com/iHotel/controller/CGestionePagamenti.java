/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamenti;

/**
 * @author Alessandro
 *
 */
public class CGestionePagamenti {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private SoggiornoContextSubject _prenotazione;
	/**
	 * Attributo privato - Pattern Singleton
	 */
	private static CGestionePagamenti instance = null;
	
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 */
    public static CGestionePagamenti getInstance() {
    	if(instance == null) {
            instance = new CGestionePagamenti();
         }
         return instance;
    }
    
    /**
     * Metodo che ha il compito di mostrare la schermata per la gestione dei pagamenti
     * @param prenotazione Prenotazione di cui si stanno gestendo i pagamenti
     */
    public void gestisciPagamentiPrenotazione(SoggiornoContextSubject prenotazione){
    	//Setto l'attributo della prenotazione
    	this._prenotazione =prenotazione;
    	
    	// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPP_RiepilogoPagamenti riepilogoPagamenti = new VPP_RiepilogoPagamenti();
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(riepilogoPagamenti);
		// Creo il frame
		riepilogoPagamenti.creaPanel(_prenotazione);
    }
    
    /**
     * Metodo che consente di aggiungere un pagamento alla prenotazione
     * @param pagamento E' il pagamento effettuato dal cliente
     */
    public void inserisciPagamentoInPrenotazione(Pagamento pagamento){
    	/*Aggiungo il pagamento alla prenotazione*/
    	_prenotazione.add_pagamento(pagamento);
    	/*Salvo il pagamento nel db*/
    	PPrenotazione.getInstance().store(_prenotazione.get_pagamenti());
    }

}
