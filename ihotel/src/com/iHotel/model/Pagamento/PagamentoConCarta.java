/**
 * 
 */
package com.iHotel.model.Pagamento;

import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe che modella un pagamento effettuato mediante carta di credito
 * 
 * @author Alessandro
 *
 */
public class PagamentoConCarta extends Pagamento{
	/*Attributi e costruttore*/
	private CartaDiCredito _cartaDiCredito;
	
	//Costruttore di default
	public PagamentoConCarta(){
	
	}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param importo			E' l'importo del versamento
	 * @param data				E' il giorno in cui è stato fatto il versamento
	 * @param cartaDiCredito	E' la carta di credito con cui è stato fatto il versamento
	 */
	public PagamentoConCarta(Prezzo importo, Giorno data, CartaDiCredito cartaDiCredito){
		
		super(importo, data);
		this.set_cartaDiCredito(cartaDiCredito);
	}

	/**
	 * @return the _cartaDiCredito
	 */
	public CartaDiCredito get_cartaDiCredito() {
		return _cartaDiCredito;
	}

	/**
	 * @param _cartaDiCredito the _cartaDiCredito to set
	 */
	public void set_cartaDiCredito(CartaDiCredito _cartaDiCredito) {
		this._cartaDiCredito = _cartaDiCredito;
	}
	
}
