/**
 * 
 */
package com.iHotel.model.Utility;

import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.ForeignSystem.CreditAuthorizationService.ICreditAuthorizationServiceAdapter;
import com.iHotel.model.ForeignSystem.LettoreCarte.ILettoreCarteAdapter;
import com.iHotel.model.ForeignSystem.PagamentoCarta.IPagamentoCartaAdapter;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;

/**
 * Classe che ha la responsabilità di gestire i pagamenti elettronici, relazionandosi anche con i sistemi esterni
 * 
 * @author Alessandro
 *
 */
public class GestorePagamentiElettronici {
	
	/**
     * Metodo per effettuare un pagamento mediante carta di credito o bancomat.
     * 
     * @param importoDaPagareConCarta Importo che si vuole pagare con la carta.
     * @return Il pagamento effettuato
     */
    public static Pagamento pagaConCarta(Prezzo importoDaPagareConCarta) {  
    	// Inizializzo il pagamento
    	PagamentoConCarta pagamentoEffettuato = null;
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
    		pagamentoEffettuato=pagaConCarta.eseguiPagamento(importoDaPagareConCarta, cartaDiCredito);
    	}
    	return pagamentoEffettuato;
    }

}
