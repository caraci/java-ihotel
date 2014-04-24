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
	 * 
	 * @param codiceDescrittore Codice del servizio.
	 * @return Descrizione del servizio richiesto.
	 */
	public DescrizioneServizioInterno getDescrizioneServizioDaCodice(String codiceDescrittore) {
		return _descrizioneServizi.get(codiceDescrittore);
	}
	
	/**
	 * Metodo per fornire il descrittore del servizio dal suo nome.
	 * 
	 * @param codiceDescrittore Codice del servizio.
	 * @return Descrizione del servizio richiesto.
	 */
	public DescrizioneServizioInterno getDescrizioneServizioDaNome(String nomeDescrittore) {
		DescrizioneServizioInterno descrizioneServizioInterno=null;
		// Ciclo sui servizi
		for (Iterator<String> iterator = _descrizioneServizi.keySet().iterator(); iterator.hasNext();) {
			String codiceServizio = (String) iterator.next();
			// Controllo che il nome sia quello del servizio.
			if(_descrizioneServizi.get(codiceServizio).get_nome().equals(nomeDescrittore)) {
				descrizioneServizioInterno=_descrizioneServizi.get(codiceServizio);
			}
		}
		return descrizioneServizioInterno;
	}
	
	/**
	 * Metodo per fornire il codice del servizio dal suo nome.
	 * 
	 * @param nomeServizio Nome del servizio.
	 * @return Codice del servizio richiesto.
	 */
	public String getCodiceServizioDaNome(String nomeServizio) {
		String codiceServizioRicercato = null;
		// Ciclo sui descrittori
		for (Iterator<String> iterator = _descrizioneServizi.keySet().iterator(); iterator.hasNext();) {
			String codiceServizio = (String) iterator.next();
			// Controllo se la stringa ricevuta come parametro è uguale al nome del descrittore.
			if(_descrizioneServizi.get(codiceServizio).get_nome().equals(nomeServizio)) {
				codiceServizioRicercato=codiceServizio;
			}
		}
		return codiceServizioRicercato;
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