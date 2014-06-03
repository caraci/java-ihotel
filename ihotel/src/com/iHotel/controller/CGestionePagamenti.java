/**
 * 
 */
package com.iHotel.controller;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.ForeignSystem.CreditAuthorizationService.ICreditAuthorizationServiceAdapter;
import com.iHotel.model.ForeignSystem.LettoreCarte.ILettoreCarteAdapter;
import com.iHotel.model.ForeignSystem.PagamentoCarta.IPagamentoCartaAdapter;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.persistence.PPrenotazione;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Access.ViewPanelFactory;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamenti_Observer;
import com.iHotel.view.Utility.IObserver;

/**
 * Questa classe rappresenta il controllore con la responsabilità di gestire i pagamenti relativi ai soggiorni.
 * 
 * @author Alessandro
 */
public class CGestionePagamenti {
	
	/* ------------------------- Attributi e costruttore ---------------------------- */
	/**
	 * Soggiorno in analisi.
	 */
	private SoggiornoContextSubject _soggiorno;
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
     * Metodo che ha il compito di mostrare la schermata per la gestione dei pagamenti.
     * 
     * @param soggiorno Soggiorno di cui si stanno gestendo i pagamenti
     */
    public void gestisciPagamentiSoggiorno(SoggiornoContextSubject soggiorno){
    	//Setto l'attributo della prenotazione
    	this._soggiorno = soggiorno;	
    	// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Creo il pannello successivo
		VPP_RiepilogoPagamenti_Observer riepilogoPagamenti = ViewPanelFactory.getPanelRiepilogoPagamenti(soggiorno);
		// Per il pattern Observer aggiungo l'observer alla prenotazione.
		_soggiorno.Attach((IObserver) riepilogoPagamenti);
		// Assegno la prossima schermata al frame.
		viewFrame.cambiaSchermata(riepilogoPagamenti);
		// Creo il frame
		riepilogoPagamenti.creaPanel(_soggiorno);
    }
    
    /**
     * Metodo che consente di aggiungere un pagamento al soggiorno.
     * 
     * @param pagamento E' il pagamento effettuato dal cliente.
     */
    public void inserisciPagamentoInSoggiorno(Pagamento pagamento) {    	
    	/*Aggiungo il pagamento alla prenotazione*/
    	_soggiorno.addPagamento(pagamento);
    	//Rimuovo l'osservatore dal soggiorno, altrimenti verrebbe salvato nel db.
		_soggiorno.Detach((IObserver) ViewFrameApplication.getInstance().get_pnlAttuale());
    	/*Salvo il pagamento nel db*/
    	PPrenotazione.getInstance().store(_soggiorno);
    	//Aggiungo di nuovo l'osservatore al soggiorno
    	_soggiorno.Attach((IObserver)ViewFrameApplication.getInstance().get_pnlAttuale());
    }
    /**
     * Metodo per effettuare un pagamento mediante carta di credito o bancomat.
     * 
     * @param importoDaPagareConCarta Importo che si vuole pagare con la carta.
     */
    public void pagaConCarta(Prezzo importoDaPagareConCarta) {
    	//recupero la ServiceFactory
    	ServiceFactory serviceFactory= ServiceFactory.getInstance();
    	//tramite la serviceFactory recupero il lettore di carte 
    	ILettoreCarteAdapter lettoreCarta= serviceFactory.get_lettoreAdapter();
    	//leggo la carta
    	CartaDiCredito cartaDiCredito = lettoreCarta.leggiCarta();
    	//recupero il sistema di autorizzazione al pagamento
    	ICreditAuthorizationServiceAdapter creditAuth = serviceFactory.get_creditAuthAdapter();
    	//se il sistema autorizza il pagamento
    	if(creditAuth.richiestaDiAutorizzazione(importoDaPagareConCarta, cartaDiCredito)){
    		//recupero il sistema per effettuare il pagamento
    		IPagamentoCartaAdapter pagaConCarta = serviceFactory.get_pagamentoCartaAdapter();
    		//effetuo il pagamento
    		PagamentoConCarta pagamentoEffettuato=pagaConCarta.eseguiPagamento(importoDaPagareConCarta, cartaDiCredito);
    		// Salvo il pagamento
    		this.inserisciPagamentoInSoggiorno(pagamentoEffettuato);
    	}
    }

}
