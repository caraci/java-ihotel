package com.iHotel.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import com.iHotel.model.MCamera;

public class PersistentManager {
	/* ------------ Attributi e costruttore */
	private static PersistentManager instance = null;
	private EmbeddedConfiguration _config;
	private ObjectContainer _db;
	/**
	 * Costruttore privato - pattern singleton
	 */
	private PersistentManager() {
		_config = Db4oEmbedded.newConfiguration();
		_config.common().objectClass(MCamera.class).cascadeOnUpdate(true);
		_db = Db4oEmbedded.openFile(_config, "dbihotel");
	}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return CGestisciPrenotazione Instanza unica di questa classe
	 */
    public static PersistentManager getInstance() {
    	if(instance == null) {
            instance = new PersistentManager();
         }
         return instance;
    }
    /* --------------------------------- Metodi di instanza -------------------------------------- */
	/**
	 * @return _db
	 */
	public ObjectContainer get_db() {
		return _db;
	}
}
