package com.iHotel.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.iHotel.model.MCamera;

public class PDb {

	/* ---------------- Attributi e costruttore ---------------------*/
	// Attributo nel quale si memorizza la connessione verso la base dati
	private static ObjectContainer _db = null;
	//classe singleton
	private static PDb instance = null ;
	/**
	 * Costruttore protetto in modo che possa essere ereditato dalle sottoclassi.
	 */
	private PDb() {			
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			config.common().objectClass(MCamera.class).cascadeOnUpdate(true);
			_db=Db4oEmbedded.openFile(config, "dbihotel");	
	}

	/* ------------------------ Metodi di classe ---------------------- */
	/**
	 * Metodo di classe che viene richiamato dal costruttore dell'instanza per connettersi alla base dati.
	 * Se è già attiva una connessione utilizza quella, altrimenti ne crea una nuova.
	 */
	public static ObjectContainer getDB(){
		return _db;
	} 
	/**
	 * Classe singleton
	 */
	public static PDb getInstance(){
		if(instance==null){
			instance = new PDb();
		}
		return instance;
	}
	
	
}
