/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.Graphic.GestionePagamenti.VFP_RiepilogoPagamenti;

/**
 * @author Alessandro
 *
 */
public class CGestionePagamenti {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	private PrenotazioneSubject _prenotazione;
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
    public void gestisciPagamentiPrenotazione(PrenotazioneSubject prenotazione){
    	//Setto l'attributo con la prenotazione
    	this._prenotazione =prenotazione;
    	/*Recupero l'istanza della View per la gestione dei pagamenti*/
    	VFP_RiepilogoPagamenti riepilogoPagamenti = VFP_RiepilogoPagamenti.getInstance();
    	/*Invoco il metodo creaFrame per creare il frame*/
    	riepilogoPagamenti.creaFrame(prenotazione);
    	/*Recupero il gestore delle schermate e gli chiedo di mostrare la schermata giusta*/
    	ViewHandler.getInstance().showFrame(riepilogoPagamenti);
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
