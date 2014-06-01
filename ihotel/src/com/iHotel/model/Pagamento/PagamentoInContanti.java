/**
 * 
 */
package com.iHotel.model.Pagamento;

import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe che modella un pagamento in contanti.
 * 
 * @author Alessandro
 */
public class PagamentoInContanti extends Pagamento{
	
	/**
	 * Costruttore.
	 */
	public PagamentoInContanti() {}
	
	/**
	 * Costruttore con parametri
	 * 
	 * @param importo Importo versato
	 * @param data Giorno in cui è stato effettuato il versamento
	 */
	public PagamentoInContanti(Prezzo importo, Giorno data){
		super(importo,data);
	}

}
