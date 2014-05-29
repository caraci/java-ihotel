/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public abstract class SoggiornoState {
	/**
	 * Soggiorno a cui è associato lo stato - Pattern State
	 */
	protected SoggiornoContextSubject _soggiornoSubject;
	/**
	 * Costruttore.
	 * 
	 * @param soggiornoSubject Soggiorno a cui è associato lo stato.
	 */
	public SoggiornoState(SoggiornoContextSubject soggiornoSubject) {
		_soggiornoSubject=soggiornoSubject;
	}
	/* ------------------------- Metodi di istanza ----------------------------- */
	/**
	 * Metodo per ottenere il prezzo dei servizi interni di una prenotazione.
	 * 
	 * @return Prezzo dei servizi interni di una prenotazione.
	 */
	public Prezzo getPrezzoServiziInterni() {
		// Lista delle camere prenotate
		ArrayList<Camera> camerePrenotante = _soggiornoSubject.get_camerePrenotate();
		// Periodo del soggiorno
		Periodo periodoSoggiorno = _soggiornoSubject.get_periodo();
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
	 * Metodo per calcolare il totale delle camere una prenotazione
	 */
	public void calcolaImportoTotaleCamere() {
		DescrizioneCamera descrizione;
		// Prendo l'ultima camera aggiunta.
		Camera cameraPrenotata;
		// Lista delle camere prenotate.
		ArrayList<Camera> camerePrenotate = _soggiornoSubject.get_camerePrenotate();
		// Prendo l'ultima camera aggiunta al soggiorno.
		cameraPrenotata=camerePrenotate.get(camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia=cameraPrenotata.get_tipologia();
		descrizione=CatalogoCamere.getInstance().getDescrizioneDaTipologia(tipologia);
		// Periodo del soggiorno.
		Periodo periodoSoggiorno = _soggiornoSubject.get_periodo();
		// Importo totale per le camere del soggiorno
		Prezzo importoTotaleCamere = _soggiornoSubject.get_importoTotaleCamere();
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		importoTotaleCamere.somma(descrizione.calcolaPrezzoInPeriodo(periodoSoggiorno));
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato della prenotazione.
		_soggiornoSubject.Notify();
	}
	/**
	 * Metodo per aggiungere un pagamento alla prenotazione.
	 * 
	 * @param pagamento Pagamento effettuato a favore del soggiorno.
	 */
	public void addPagamento(Pagamento pagamento) {
		//Aggiungo il pagamento alla lista di pagamenti.
		_soggiornoSubject.get_pagamenti().add(pagamento);
		//Sommo l'importo del pagamento al totale dei pagamenti
		_soggiornoSubject.set_importoTotalePagamenti(_soggiornoSubject.get_importoTotalePagamenti().somma(pagamento.get_importo()));
		//Notifico il cambiamento all'interfaccia
		_soggiornoSubject.Notify();
		//ricalcolo il rimanente da pagare
		_soggiornoSubject.calcolaImportoRimanenteDaPagare();
		
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
		Prezzo importoRimanenteDaPagare = new Prezzo();
		/*Importo dovuto per i servizi esterni*/
		Prezzo totaleServiziEsterni = new Prezzo();
		/*Chiedo alla factory di calcolare il prezzo dei servizi esterni per la prenotazione corrente*/
		totaleServiziEsterni = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(_soggiornoSubject);
		/* Aggiungo il totale delle camere, il totale dei servizi interni, e il totale dei servizi
		  esterni all'importo totale  */
		importoRimanenteDaPagare.somma(_soggiornoSubject.get_importoTotaleCamere());
		importoRimanenteDaPagare.somma(_soggiornoSubject.getPrezzoServiziInterni());
		importoRimanenteDaPagare.somma(totaleServiziEsterni);
		
		/* Sottraggo i pagamenti effettuati*/
		importoRimanenteDaPagare.sottrai(_soggiornoSubject.get_importoTotalePagamenti());	
		
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
		Prezzo costoServiziEsterni = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(_soggiornoSubject);
		/*Sommo il costo delle camere*/
		costoSoggiorno.somma(_soggiornoSubject.get_importoTotaleCamere());
		/*Sommo il costo dei servizi interni*/
		costoSoggiorno.somma(_soggiornoSubject.getPrezzoServiziInterni());
		/*Sommo il costo dei servizi esterni*/
		costoSoggiorno.somma(costoServiziEsterni);
		
		/*Restituisco il prezzo totale della prenotazione*/
		return costoSoggiorno;
	}
	public abstract void addCamera(Camera camera);
	public abstract void addPrenotante(String nome, String cognome, String eMail, String telefono);
	public abstract void occupaCamere();
	public abstract void concludiPrenotazione(String nome, String cognome, String eMail, String telefono);
	public abstract SoggiornoState effettuaCheckIn();
	public abstract SoggiornoState effettuaCheckOut();
	
	
	/* ----------------- Getter, Setter ------------------- */
	/**
	 * @return the _soggiornoSubject
	 */
	public SoggiornoContextSubject get_soggiornoSubject() {
		return _soggiornoSubject;
	}
	/**
	 * @param _soggiornoSubject the _soggiornoSubject to set
	 */
	public void set_soggiornoSubject(SoggiornoContextSubject _soggiornoSubject) {
		this._soggiornoSubject = _soggiornoSubject;
	}
	
}
