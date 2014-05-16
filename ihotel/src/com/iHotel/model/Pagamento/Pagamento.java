/**
 * 
 */
package com.iHotel.model.Pagamento;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe generica che descrive un pagamento
 * @author Alessandro
 *
 */
public class Pagamento {
	
	/*Attributi e costruttore*/
	private Prezzo _importo;
	private Giorno _data;
	
	//Costruttore di default
	public Pagamento(){
		
	}
	/**
	 * Costruttore con parametri
	 * @param importo Importo versato dal cliente
	 * @param data	Giorno in cui è stato effettuato il pagamento
	 */
	public Pagamento(Prezzo importo, Giorno data){
		this.set_importo(importo);
		this.set_data(data);	
	}

	/**
	 * @return the _data
	 */
	public Giorno get_data() {
		return _data;
	}

	/**
	 * @param _data the _data to set
	 */
	public void set_data(Giorno _data) {
		this._data = _data;
	}

	/**
	 * @return the _importo
	 */
	public Prezzo get_importo() {
		return _importo;
	}

	/**
	 * @param _importo the _importo to set
	 */
	public void set_importo(Prezzo _importo) {
		this._importo = _importo;
	}

}
