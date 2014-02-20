/**
 * 
 */
package com.iHotel.persistence;
import com.iHotel.model.MAlbergo;
import com.iHotel.persistence.*;



/**
 * @author Eugenio
 *
 */
public class PCamera extends PClient {
	
	private static PCamera instance=null;
	
	private PCamera(){}
	
	public static PCamera getInstance(){
		if(instance == null) {
            instance = new PCamera();
         }
         return instance;
	}
	/*
	/* ------------------------- Attributi e costruttore ----------------------- 
	ObjectContainer _db;
	
	public PCamera() {
		// Recupero l'oggetto server mediante il persistentManager.
		ObjectServer serverDB=PersistentManager.getInstance().get_db();
		// Apro una nuova connessione mediante un client al server.
		_db=serverDB.openClient();
	}
	/* ------------------------- Metodi di instanza ------------------------------ 
	/**
	* Store di un oggetto.
	* @param arg0
	
	public void store(Object arg0) {
		_db.store(arg0);
	}
	/** Metodo per caricare oggetti dal DB.
	* @param <T>
	* @param arg0
	* @return
	
	public <T> ObjectSet<T> query(Predicate<T> arg0) {
		return _db.query(arg0);
	}
	/**
	 * Metodo per chiudere la connessione con il DB.
	 
	public void close() {
		_db.close();
	}*/

}
