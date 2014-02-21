package com.iHotel.persistence;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class PersistentManager {
	/* --------------- Attributi e costruttore ------------------- */
	protected ObjectContainer _db;
	/**
	 * Costruttore che serve ad ottenre l'instanza della connessione al db.
	 */
	public PersistentManager(){		
		_db = PDb.getInstance().getDB();
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
}
