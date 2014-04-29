package com.iHotel.model.ForeignSystem;

import java.util.ArrayList;

import com.iHotel.model.ForeignSystem.PayTv.*;
import com.iHotel.model.ForeignSystem.Telephone.*;
import com.iHotel.utility.UDefaultLoader;

/**
 * Questa classe ha il compito di fornire le maniglie ai sistemi esterni reali cui l'albergo è collegato. 
 * E' stata realizzata seguendo il design pattern "Abstract Factory" secondo cui si delega ad un oggetto terzo 
 * la responsabilità di creare istanze di classi che verranno determinate solo a runtime.
 * In questo modo è possibile cambiare il tipo di oggetto da creare senza intervenire sul codice.
 * 
 * @author Alessandro
 *
 */
public class ServiceFactory {

	/* ------------------------------- Attributi e costruttore -------------------- */
	/**
	 * Maniglia all'adattatore del sistema relativo alla payTv.
	 */
	private IPayTvAdapter _payTvAdapter;
	/**
	 * Maniglia all'adattatore del sistema relativo alla telefonia.
	 */
	private ITelephoneAdapter _telephoneAdapter;
	/**
	 *  Attributo privato - Pattern Singleton
	 */
	private static ServiceFactory instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private ServiceFactory() {
		// Ricavo da file di configurazione i sistemi esterni dei servizi da utilizzare.
		ArrayList<String> sistemiServiziEsterni = UDefaultLoader.getInstance().getSistemiServiziEsterni();
		// Sistema payTv
		switch (sistemiServiziEsterni.get(0)) {
		case "Sky":
			_payTvAdapter = new SkyTvAdapter();
			break;
		default:
			break;
		}
		// Sistema Telefono
		switch (sistemiServiziEsterni.get(1)) {
		case "Telecom":
			_telephoneAdapter = new TelecomAdapter();
			break;
		default:
			break;
		}
	}
	
	/* ----------------------------- Metodi di classe -----------------------*/
	
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton
	 */
	public static ServiceFactory getInstance() {
    	if(instance == null) {
            instance = new ServiceFactory();
         }
         return instance;
    }
	/* ----------------------------- Metodi di instanza -------------------- */
	/**
	 * Metodo per ottenere la lista dei sistemi per la gestione dei servizi esterni.
	 * @return Lista di sistemi per la gestione dei servizi esterni.
	 */
	public ArrayList<IServiceSystem> getSistemiServiziEsterni() {
		ArrayList<IServiceSystem> sistemiServiziEsterni = new ArrayList<IServiceSystem>();
		// Aggiungo i sistemi esterni alla lista
		sistemiServiziEsterni.add(_payTvAdapter);
		sistemiServiziEsterni.add(_telephoneAdapter);
		return sistemiServiziEsterni;
	}
	/* ------------------------- Getter, Setter ---------------------------- */
	/**
	 * @return the _payTvAdapter
	 */
	public IPayTvAdapter get_payTvAdapter() {
		return _payTvAdapter;
	}
	/**
	 * @return the _telephoneAdapter
	 */
	public ITelephoneAdapter get_telephoneAdapter() {
		return _telephoneAdapter;
	}

}