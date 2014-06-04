/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoState;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.ForeignSystem.CreditAuthorizationService.ICreditAuthorizationServiceAdapter;
import com.iHotel.model.ForeignSystem.LettoreCarte.ILettoreCarteAdapter;
import com.iHotel.model.ForeignSystem.PagamentoCarta.IPagamentoCartaAdapter;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.ISubject;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Utility.IObserver;

/**
 * Questo classe rappresenta lo stato dei pagamenti per un soggiorno.
 * 
 * @author Eugenio
 */
public abstract class PagamentoStateObserver implements IObserver {
	/**
	 * Lista dei subject di questo osservatore. Sono gli stati delle camere riservate
	 * per il soggiorno associato.
	 */
	protected ArrayList<ISubject> _elencoSubject;
	/**
	 * Stato in cui si trova il soggiorno.
	 */
	protected SoggiornoState _soggiornoState;
	/**
	 * Soggiorno di cui si gestiscono i pagamenti - Pattern State
	 */
	protected SoggiornoContextSubject _soggiornoContext;
	
	/**
	 * Costruttore.
	 * 
	 * @param soggiornoState Stato in cui si trova il soggiorno.
	 */
	protected PagamentoStateObserver(SoggiornoState soggiornoState) {
		_soggiornoState = soggiornoState;
		_soggiornoContext = soggiornoState.get_soggiornoContext();
		_elencoSubject = new ArrayList<ISubject>();
	}
	/* ----------------------------------------------------- Metodi di istanza ----------------------------------------------------- */
	@Override
	public abstract void Update();
	/**
	 * Metodo per aggiungere un subject, all'observer.
	 * 
	 * @param subject Subject da aggiungere all'observer.
	 */
	public void addSubject(ISubject subject) {
		this._elencoSubject.add(subject);
	}
	/**
	 * Metodo per aggiungere un pagamento al soggiorno.
	 * 
	 * @param pagamento Pagamento effettuato a favore del soggiorno.
	 */
	public abstract void addPagamento(Pagamento pagamento);
	/**
     * Metodo per effettuare un pagamento mediante carta di credito o bancomat.
     * 
     * @param importoDaPagareConCarta Importo che si vuole pagare con la carta.
     */
    public Pagamento pagaConCarta(Prezzo importoDaPagareConCarta) {  
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
	/**
	 * Metodo per ottenere il prezzo dei servizi interni di un soggiorno.
	 * 
	 * @return Prezzo dei servizi interni di un soggiorno.
	 */
	public Prezzo getPrezzoServiziInterni() {		
		// Lista delle camere prenotate
		ArrayList<Camera> camerePrenotante = _soggiornoContext.get_camerePrenotate();
		// Periodo del soggiorno
		Periodo periodoSoggiorno = _soggiornoContext.get_periodo();
		// Prezzo dei servizi interni
		Prezzo prezzoServiziInterni = new Prezzo();
		// Ciclo su tutte le camere
		for (Iterator<Camera> iterator = camerePrenotante.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
			prezzoServiziInterni.somma(camera.getPrezzoServiziInPeriodo(periodoSoggiorno));
		}
		return prezzoServiziInterni;
	}
	/**
	 * Metodo per calcolare il totale delle camere di un soggiorno.
	 */
	public void calcolaImportoTotaleCamere() {
		// Lista delle camere prenotate.
		ArrayList<Camera> camerePrenotate = _soggiornoContext.get_camerePrenotate();
		// Prendo l'ultima camera aggiunta al soggiorno.
		Camera cameraPrenotata=camerePrenotate.get(camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia=cameraPrenotata.get_tipologia();
		DescrizioneCamera descrizione=CatalogoCamere.getInstance().getDescrizioneDaTipologia(tipologia);
		// Periodo del soggiorno.
		Periodo periodoSoggiorno = _soggiornoContext.get_periodo();
		// Importo totale per le camere del soggiorno prima dell'aggiunta.
		Prezzo importoTotaleCamere = _soggiornoContext.get_importoTotaleCamere();
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		importoTotaleCamere.somma(descrizione.calcolaPrezzoInPeriodo(periodoSoggiorno));
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato del soggiorno.
		_soggiornoContext.Notify();
	}
	/**
	 * Metodo che restituisce l'importo che rimane da pagare per il soggiorno passato come parametro.
	 * L'importo è calcolato come la somma dell'importo delle camere, dei servizi interni, dei servizi esterni
	 * al netto dei versamenti giò effettuati.
	 * 
	 * @return Importo rimanente da pagare per il soggiorno.
	 */
	public Prezzo calcolaImportoRimanenteDaPagare(){
		/*Importo che rimane da pagare*/
		Prezzo importoRimanenteDaPagare = calcolaCostoTotaleSoggiorno();			
		/* Sottraggo i pagamenti effettuati*/
		importoRimanenteDaPagare.sottrai(_soggiornoContext.get_importoTotalePagamenti());	
		/*Restituisco l'importo che rimane da pagare*/
		return importoRimanenteDaPagare;
	}
	
	/**
	 * Metodo che calcola il costo totale del soggiorno comprensivo di totale camere, totale servizi
	 * interni e totale servizi esterni
	 * 
	 * @return Il costo totale della prenotazione
	 */
	public Prezzo calcolaCostoTotaleSoggiorno(){
		/*Creo un prezzo che sarà l'importo totale del soggiorno*/
		Prezzo costoSoggiorno = new Prezzo();		
		/*Importo dei servizi esterni*/
		Prezzo costoServiziEsterni = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(_soggiornoContext);
		/*Sommo il costo delle camere*/
		costoSoggiorno.somma(_soggiornoContext.get_importoTotaleCamere());
		/*Sommo il costo dei servizi interni*/
		costoSoggiorno.somma(_soggiornoContext.getPrezzoServiziInterni());
		/*Sommo il costo dei servizi esterni*/
		costoSoggiorno.somma(costoServiziEsterni);
		
		/*Restituisco il prezzo totale della prenotazione*/
		return costoSoggiorno;
	}
	/**
	 * @return the _elencoSubject
	 */
	public ArrayList<ISubject> get_elencoSubject() {
		return _elencoSubject;
	}
	/**
	 * @param _elencoSubject the _elencoSubject to set
	 */
	public void set_elencoSubject(ArrayList<ISubject> _elencoSubject) {
		this._elencoSubject = _elencoSubject;
	}
	/**
	 * @return the _soggiornoStatePagamentoContext
	 */
	public SoggiornoState get_soggiornoState() {
		return _soggiornoState;
	}
	/**
	 * @param _soggiornoStatePagamentoContext the _soggiornoStatePagamentoContext to set
	 */
	public void set_soggiornoState(
			SoggiornoState _soggiornoStatePagamentoContext) {
		this._soggiornoState = _soggiornoStatePagamentoContext;
	}
}
