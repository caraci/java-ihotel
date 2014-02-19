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
	private String _nomeDB;
	/**
	 * Costruttore privato - pattern singleton
	 */
	private PersistentManager() {
		_config = Db4oEmbedded.newConfiguration();
		_config.common().objectClass(MCamera.class).cascadeOnUpdate(true);
		_nomeDB = "dbihotel";
		_db = Db4oEmbedded.openFile(_config, _nomeDB);
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
	 * Store di un oggetto.
	 * @param arg0
	 */
	public void store(Object arg0) {
		_db.store(arg0);
	}
	/**
	 * Metodo per caricare oggetti dal DB.
	 * @param <T>
	 * @param arg0
	 * @return
	 */
	public <T> ObjectSet<T> query(Predicate<T> arg0) {
		return _db.query(arg0);
	}
	/**
	 * Metodo per chiudere la connessione con il DB.
	 */
	public void close() {
		_db.close();
	}
}
