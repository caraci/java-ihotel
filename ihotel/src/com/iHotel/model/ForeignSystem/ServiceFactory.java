package com.iHotel.model.ForeignSystem;

import java.util.ArrayList;

import com.iHotel.model.ForeignSystem.PayTv.*;
import com.iHotel.model.ForeignSystem.Telephone.*;
import com.iHotel.utility.UDefaultLoader;

public class ServiceFactory {

	/* ------------------------------- Attributi e costruttore -------------------- */
	private IPayTvAdapter _payTvAdapter;
	private ITelephoneAdapter _telephoneAdapter;
	// Singleton 
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