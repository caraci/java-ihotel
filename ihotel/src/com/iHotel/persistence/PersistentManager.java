package com.iHotel.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import com.iHotel.model.MCamera;

public abstract class PersistentManager {
	
	/* ---------------- Attributi e costruttore ---------------------*/
	// Attributo nel quale si memorizza la connessione verso la base dati
	protected static ObjectContainer _db;
	/**
	 * ------------------------- Attributi e costruttore -----------------------------------
	 */
	private static PersistentManager instance = null;
	private EmbeddedConfiguration _config;
	private String _nomeDB;
	/**
	 * Costruttore protetto in modo che possa essere ereditato dalle sottoclassi.
	 */
	protected PersistentManager() {
		getConnection();
	}
	/* ------------------------ Metodi di classe ---------------------- */
	/**
	 * Metodo di classe che viene richiamato dal costruttore dell'instanza per connettersi alla base dati.
	 * Se è già attiva una connessione utilizza quella, altrimenti ne crea una nuova.
	 */
	public static void getConnection(){
		if (_db==null){
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			config.common().objectClass(MCamera.class).cascadeOnUpdate(true);
			_db=Db4oEmbedded.openFile(config, "dbihotel");
		}
	} 
	
	/* ------------------------- Metodi di instanza ------------------------------ */
	/**
	* Store di un oggetto.
	* @param arg0
	*/
	public void store(Object arg0) {
		_db.store(arg0);
	}
	/** Metodo per caricare oggetti dal DB.
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

	public PersistentManager getInstance() {
		return this.instance;
	}
}
