package com.iHotel.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.iHotel.model.MCamera;
import com.iHotel.model.MPrenotazione;

public class PDb {

	/* ---------------- Attributi e costruttore ---------------------*/
	// Attributo nel quale si memorizza la connessione verso la base dati
	private ObjectContainer _db = null;
	// Singleton
	private static PDb instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 * Mediante il costruttore, si instaura una connessione con la base dati.
	 */
	private PDb() {			
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().objectClass(MCamera.class).cascadeOnUpdate(true);
		config.common().objectClass(MPrenotazione.class).cascadeOnUpdate(true);
		_db=Db4oEmbedded.openFile(config, "dbihotel");	
	}

	/* ------------------------ Metodi di classe ---------------------- */
	/**
	 * Metodo di classe che viene richiamato dal costruttore dell'instanza per connettersi alla base dati.
	 * Se è già attiva una connessione utilizza quella, altrimenti ne crea una nuova.
	 */
	public ObjectContainer getDB(){
		return _db;
	} 
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 */
	public static PDb getInstance(){
		if(instance==null){
			instance = new PDb();
		}
		return instance;
	}
	
	
}
