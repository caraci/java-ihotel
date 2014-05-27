/**
 * 
 */
package com.iHotel.model.ForeignSystem.PagamentoCarta;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public class PagamentoVisaCartaAdapter implements IPagamentoCartaAdapter {

	@Override
	/**
	 * metodo che effettua il pagamento con carta
	 */
	public PagamentoConCarta eseguiPagamento(Prezzo prezzo, CartaDiCredito carta) {
		
		int giorno, mese, anno;
		giorno=1;
		mese=1;
		anno=2014;
		Giorno dataPagamento= new Giorno(giorno, mese, anno);
		PagamentoConCarta pagamento = new PagamentoConCarta(prezzo,dataPagamento,carta);
		return pagamento;
	}

}
