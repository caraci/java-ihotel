package com.iHotel.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Camera.StatoCamera;
import com.iHotel.model.Albergo.Camera.StatoCameraOccupata;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoState;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoStateObserver;

public class PersistentManager {
	/* --------------- Attributi e costruttore ------------------- */
	/**
	 * Attributo rappresentante la connessione alla base dati. Per le sue tecnologie, � necessario
	 * che la connessione resti sempre attiva.
	 */
	protected static ObjectContainer _db = null;
	/**
	 * Costruttore che serve ad ottenere la connessione al db.
	 */
	protected PersistentManager(){		
		getConnection();
	}
	/* --------------------------- Metodi di classe ------------------------------ */
	protected static void getConnection() {
		// Se la connessione non è aperta, la si va ad aprire.
		if (_db==null) {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			// Configurazioni per l'aggiornamento in cascata degli oggetti delle seguenti classi.
			config.common().objectClass(SoggiornoContextSubject.class).cascadeOnUpdate(true);
			config.common().objectClass(SoggiornoState.class).cascadeOnUpdate(true);
			config.common().objectClass(PagamentoStateObserver.class).cascadeOnUpdate(true);
			config.common().objectClass(Camera.class).cascadeOnUpdate(true);
			config.common().objectClass(StatoCamera.class).cascadeOnUpdate(true);
			config.common().objectClass(StatoCameraOccupata.class).cascadeOnUpdate(true);
			config.common().objectClass(ServizioInterno.class).cascadeOnUpdate(true);
			// Configurazione per tirare su l'oggetto completo
			config.common().objectClass(Camera.class).minimumActivationDepth(50);
			config.common().objectClass(SoggiornoContextSubject.class).minimumActivationDepth(50);
			// Posizione del file contenente la base dati.
			_db=Db4oEmbedded.openFile(config, "./configs/dbihotel");
		}
	}
	/* ------------------------- Metodi di instanza ------------------------------ */
	/**
	* Store di un oggetto.
	* 
	* @param arg0
	*/
	public void store(Object arg0) {
		_db.store(arg0);
	}
	/** 
	* Metodo per caricare oggetti dal DB.
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
