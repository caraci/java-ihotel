/**
 * 
 */
package com.iHotel.model.ForeignSystem.PagamentoCarta;

import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe concreta di adattatore al sistema di pagamento con carta di credito visa
 * 
 * @author Gabriele
 *
 */
public class PagamentoVisaCartaAdapter implements IPagamentoCartaAdapter {

	@Override
	/**
	 * Metodo che effettua il pagamento con carta. Il pagamento è fittizio, in quanto non si è 
	 * realmente collegati con l'esterno
	 */
	public PagamentoConCarta eseguiPagamento(Prezzo prezzo, CartaDiCredito carta) {
		/*Creo un giorno*/
		int giorno, mese, anno;
		giorno=1;
		mese=1;
		anno=2014;		
		Giorno dataPagamento= new Giorno(giorno, mese, anno);
		/*Creo un pagamento*/
		PagamentoConCarta pagamento = new PagamentoConCarta(prezzo,dataPagamento,carta);
		/*Restituisco il pagamento*/
		return pagamento;
	}

}
