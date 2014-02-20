package com.iHotel.persistence;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;
import com.iHotel.model.MCamera;

public class PServer {
	/* ------------------------- Attributi e costruttore -----------------------------------*/
	private static PServer instance = null;
	private ServerConfiguration _config;
	private ObjectServer _db;
	private String _nomeDB;
	/**
	 * Costruttore privato - pattern singleton
	 */
	private PServer() {
		_config = Db4oClientServer.newServerConfiguration();
		_config.common().objectClass(MCamera.class).cascadeOnUpdate(true);
		_nomeDB = "dbihotel";
		_db = Db4oClientServer.openServer(_config, _nomeDB, 0);
	}
	/* ------------------------------- Metodi di classe --------------------------------------- */
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return CGestisciPrenotazione Instanza unica di questa classe
	 */
    public static PServer getInstance() {
    	if(instance == null) {
            instance = new PServer();
         }
         return instance;
    }
    /* --------------------------------- Metodi di instanza -------------------------------------- */
	/**
	 * Metodo per ottenere il server della base dati.
	 * @return
	 */
    public ObjectServer get_db() {
    	return _db;
    }	
	/**
	 * Metodo per chiudere la connessione con il DB.
	 */
	public void close() {
		_db.close();
	}
}
