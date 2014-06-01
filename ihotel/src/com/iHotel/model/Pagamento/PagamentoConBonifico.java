/**
 * 
 */
package com.iHotel.model.Pagamento;

import com.iHotel.model.Persona.Persona;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe che modella un pagamento effettuato mediante bonifico.
 * 
 * @author Alessandro
 */
public class PagamentoConBonifico extends Pagamento {

	/**
	 * Codice del bonifico.
	 */
	private String _codiceBonifico;
	/**
	 * Mittente del bonifico.
	 */
	private Persona _mittente;
	
	/**
	 * Costruttore di default.
	 */
	public PagamentoConBonifico() {}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param importo Importo versato.
	 * @param data Giorno in cui è stato fatto il bonifico.
	 * @param codice Codice del bonifico.
	 * @param mittente Persona che ha emesso il bonifico.
	 */
	public PagamentoConBonifico(Prezzo importo,Giorno data, String codice,Persona mittente){
		this.set_importo(importo);
		this.set_data(data);
		this.set_codiceBonifico(codice);
		this.set_mittente(mittente);
	}
	/* --------------------------------- Getter, Setter --------------------------------- */
	/**
	 * @return the _mittente
	 */
	public Persona get_mittente() {
		return _mittente;
	}
	/**
	 * @param _mittente the _mittente to set
	 */
	public void set_mittente(Persona _mittente) {
		this._mittente = _mittente;
	}

	/**
	 * @return the _codiceBonifico
	 */
	public String get_codiceBonifico() {
		return _codiceBonifico;
	}

	/**
	 * @param _codiceBonifico the _codiceBonifico to set
	 */
	public void set_codiceBonifico(String _codiceBonifico) {
		this._codiceBonifico = _codiceBonifico;
	}
}
