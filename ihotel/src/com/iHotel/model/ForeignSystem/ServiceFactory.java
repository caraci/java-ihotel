package com.iHotel.model.ForeignSystem;

import java.util.ArrayList;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.ForeignSystem.CreditAuthorizationService.CreditAuthorizationService1Adapter;
import com.iHotel.model.ForeignSystem.CreditAuthorizationService.ICreditAuthorizationServiceAdapter;
import com.iHotel.model.ForeignSystem.LettoreCarte.ILettoreCarteAdapter;
import com.iHotel.model.ForeignSystem.LettoreCarte.LettoreCarteIngenicoAdapter;
import com.iHotel.model.ForeignSystem.PagamentoCarta.IPagamentoCartaAdapter;
import com.iHotel.model.ForeignSystem.PagamentoCarta.PagamentoVisaCartaAdapter;
import com.iHotel.model.ForeignSystem.PayTv.*;
import com.iHotel.model.ForeignSystem.Telephone.*;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.utility.ULeggiDaFile;

/**
 * Questa classe ha il compito di fornire le maniglie ai sistemi esterni reali cui l'albergo è collegato. 
 * E' stata realizzata seguendo il design pattern "Abstract Factory" secondo cui si delega ad un oggetto terzo 
 * la responsabilità di creare istanze di classi che verranno determinate solo a runtime.
 * In questo modo è possibile cambiare il tipo di oggetto da creare senza intervenire sul codice.
 * 
 * @author Alessandro
 *
 */
public class ServiceFactory {

	/* ------------------------------- Attributi e costruttore -------------------- */
	/**
	 * Maniglia all'adattatore del sistema relativo alla payTv.
	 */
	private IPayTvAdapter _payTvAdapter;
	/**
	 * Maniglia all'adattatore del sistema relativo alla telefonia.
	 */
	private ITelephoneAdapter _telephoneAdapter;
	/**
	 * Maniglia all'adattatore del sistema relativo al lettore di carte.
	 */
	private ILettoreCarteAdapter _lettoreAdapter;
	/**
	 * Maniglia all'adattatore del sistema relativo all'autorizzazione al pagamento con carta.
	 */
	private ICreditAuthorizationServiceAdapter _creditAuthAdapter;
	/**
	 * Maniglia all'adattatore del sistema relativo al pagamento con carta.
	 */
	private IPagamentoCartaAdapter _pagamentoCartaAdapter;
	/**
	 *  Attributo privato - Pattern Singleton
	 */
	private static ServiceFactory instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private ServiceFactory() {
		// Ricavo da file di configurazione i sistemi esterni dei servizi da utilizzare.
		ArrayList<String> sistemiServiziEsterni = ULeggiDaFile.getSistemiServiziEsterni();
		// Sistema payTv
		switch (sistemiServiziEsterni.get(0)) {
		case "Sky":
			_payTvAdapter = new SkyTvAdapter();
			break;
		default:
			break;
		}
		// Sistema Telefono
		switch (sistemiServiziEsterni.get(1)) {
		case "Telecom":
			_telephoneAdapter = new TelecomAdapter();
			break;
		default:
			break;
		}
		// Sistema Lettore Carta
		switch (sistemiServiziEsterni.get(2)) {
		case "Lettore1":
			_lettoreAdapter = new LettoreCarteIngenicoAdapter();
			break;
		default:
			break;
		}
		// Sistema Autorizzazione pagamento con carta
		switch (sistemiServiziEsterni.get(3)) {
		case "SistemaAutorizzazione1":
			_creditAuthAdapter = new CreditAuthorizationService1Adapter();
			break;
		default:
			break;
		}
		// Sistema di pagamento con carta
		switch (sistemiServiziEsterni.get(4)) {
		case "CartaVisa":
			_pagamentoCartaAdapter = new PagamentoVisaCartaAdapter();
			break;
		default:
			break;
		}
		
	}
	
	/* ----------------------------- Metodi di classe -----------------------*/
	
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton
	 */
	public static ServiceFactory getInstance() {
    	if(instance == null) {
            instance = new ServiceFactory();
         }
         return instance;
    }
	/* -------------------------- Metodi di instanza ----------------------- */
	/**
	 * Metodo per ottenere il prezzo dei servizi esterni correlati ad una prenotazione.
	 * 
	 * @param prenotazione Prenotazione da analizzare.
	 * @return Prezzo totale dei servizi esterni correlati ad una prenotazione.
	 */
	public Prezzo getPrezzoServiziEsterniPrenotazione(SoggiornoContextSubject prenotazione){
		Prezzo prezzo = new Prezzo();
		// Sommo il prezzo dei servizi della payTv.
		prezzo.somma(_payTvAdapter.getPrezzoTotaleServiziPrenotazione(prenotazione));
		// Sommo il prezzo dei servizi del Telefono.
		prezzo.somma(_telephoneAdapter.getPrezzoTotaleServiziPrenotazione(prenotazione));
		
		return prezzo;
	}
	/* ------------------------- Getter, Setter ---------------------------- */
	/**
	 * @return the _payTvAdapter
	 */
	public IPayTvAdapter get_payTvAdapter() {
		return _payTvAdapter;
	}
	/**
	 * @return the _telephoneAdapter
	 */
	public ITelephoneAdapter get_telephoneAdapter() {
		return _telephoneAdapter;
	}

	/**
	 * @return the _lettoreAdapter
	 */
	public ILettoreCarteAdapter get_lettoreAdapter() {
		return _lettoreAdapter;
	}

	/**
	 * @return the _creditAuthAdapter
	 */
	public ICreditAuthorizationServiceAdapter get_creditAuthAdapter() {
		return _creditAuthAdapter;
	}

	/**
	 * @return the _pagamentoCartaAdapter
	 */
	public IPagamentoCartaAdapter get_pagamentoCartaAdapter() {
		return _pagamentoCartaAdapter;
	}





}