package com.iHotel.model.Albergo.Cataloghi;

import java.util.*;

import com.iHotel.model.Utility.Periodo;
/**
 * Questa classe rispecchia un vero e proprio catalogo di camere del dominio applicativo. Ha quindi il compito di 
 * mantere e fornire gli oggetti software che descrivono le camere dell'albergo.
 * 
 * @author Alessandro
 */
public class CatalogoCamere {

	/* ----------------------------------- Attributi e costruttore ---------------------------------- */
	/** 
	 *  Questa mappa contiene le maniglie agli oggetti descrittori delle camere. La chiave rappresenta le tipologie
	 *	di camere presenti nell'albergo (e.g.: singola, doppia, tripla)
	 */
	private HashMap<String,DescrizioneCamera> _descrizioniCamere;
	
	/**
	 * Istanza unica di questa classe - Pattern Singleton
	 */
	private static CatalogoCamere instance = null;
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private CatalogoCamere() {
		_descrizioniCamere=new HashMap<String,DescrizioneCamera>();
	}
	/* ---------------------------- Metodi di classe ----------------------------- */	
	
	/**
	 * Metodo per ottenere l'istanza di questa classe - Pattern Singleton.
	 */
	public static CatalogoCamere getInstance() {
    	if(instance == null) {
            instance = new CatalogoCamere();
         }
         return instance;
    }
	
	/* --------------------------- Metodi di instanza --------------------------------- */
	/**
	 * Metodo per ottenere le tipologie di camere presenti nel catalogo.
	 * 
	 * @return Tipologie di camere presenti nel catalogo.
	 */
	public Set<String> getTipologieCamere() {
		return _descrizioniCamere.keySet();
	}
	/**
	 * Metodo che restituisce tutti i prezzi di una tipologia, in un determinato periodo.
	 * 
	 * @param periodo Periodo in cui si prendono i prezzi di una tipologia.
	 * @param tipologia Tipologia di camera di cui si vuole il prezzo in un periodo.
	 * @return Collezione contenente l'insieme dei prezzi relativi ad una tipologia di camera.
	 */
	public ArrayList<PrezzoCamera> getPrezziInPeriodoDaTipologia(Periodo periodo, String tipologia){
		// Ricavo la descrizione della camera a partire dalla tipologia.
		DescrizioneCamera descrizioneCamera = getDescrizioneDaTipologia(tipologia);	
		return descrizioneCamera.getPrezziInPeriodo(periodo);
	}
	/**
	 * Metodo che restituisce la descrizione della camera di una specifica tipologia.
	 * 
	 * @param tipologia	Tipologia di camera di cui si vuole avere la descrizione.
	 */
	public DescrizioneCamera getDescrizioneDaTipologia(String tipologia){
		return this._descrizioniCamere.get(tipologia);
	}
	/* ------------------------- Getter, Setter ---------------------------------- */
	public void set_descrizioniCamere(HashMap<String, DescrizioneCamera> descrizioniCamere) {
		this._descrizioniCamere = descrizioniCamere;
		
	}

	public HashMap<String, DescrizioneCamera> get_descrizioniCamere() {
		return this._descrizioniCamere;
	}
}