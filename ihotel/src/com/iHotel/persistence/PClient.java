package com.iHotel.persistence;

import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class PClient {
	/* ---------------- Attributi e costruttore ---------------------*/

	protected static ObjectContainer _db;
	
	public static void getConnection(){
		ObjectServer serverDB=PServer.getInstance().get_db();
		if (_db==null){
			_db=serverDB.openClient();
		}
		
	}
	
	public PClient() {
		// Recupero l'oggetto server mediante il persistentManager.
		getConnection();
		// Apro una nuova connessione mediante un client al server.
		
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
