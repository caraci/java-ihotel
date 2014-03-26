package com.iHotel.model.Albergo.Cataloghi;

import java.util.*;

public class CatalogoServiziInterni {
	
	/*--------------------------- Attributi e costruttore ---------------------------*/
	
	private HashMap<String,DescrizioneServizioInterno> _descrizioneServizi;
	// Singleton
	private static CatalogoServiziInterni instance = null;
	
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private CatalogoServiziInterni() {}
	/* ------------------------- Metodi di classe ---------------------------- */
	
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * @return Instanza unica di questa classe
	 */
	public static CatalogoServiziInterni getInstance() {
    	if(instance == null) {
            instance = new CatalogoServiziInterni();
         }
         return instance;
    }
	
	/*--------------------------- Metodi di istanza ---------------------------*/
	
	/**
	 * Metodo per fornire il descrittore del servizio dal suo codice.
	 * @param codiceDescrittore Codice del servizio.
	 * @return Descrizione del servizio richiesto.
	 */
	public DescrizioneServizioInterno getDescrizioneServizioDaCodice(String codiceDescrittore) {
		return _descrizioneServizi.get(codiceDescrittore);
	}
	
	/*--------------------------- Getter, Setter ---------------------------*/
	/**
	 * @return the _descrizioneServizi
	 */
	public HashMap<String,DescrizioneServizioInterno> get_descrizioneServizi() {
		return _descrizioneServizi;
	}

	/**
	 * @param _descrizioneServizi the _descrizioneServizi to set
	 */
	public void set_descrizioneServizi(HashMap<String,DescrizioneServizioInterno> _descrizioneServizi) {
		this._descrizioneServizi = _descrizioneServizi;
	}
	
	


}