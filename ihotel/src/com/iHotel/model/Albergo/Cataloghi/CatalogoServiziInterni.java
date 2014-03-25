package com.iHotel.model.Albergo.Cataloghi;

import java.util.*;

public class CatalogoServiziInterni {
	
	/*--------------------------- Attributi e costruttore ---------------------------*/
	
	private HashMap<String,DescrizioneServizioInterno> _descrizioneServizi;
	
	/*--------------------------- Metodi di istanza ---------------------------*/
	
	public DescrizioneServizioInterno getDescrizioneServizioDaCodice(String codiceDescrittore){
		return null;
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