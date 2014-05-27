/**
 * 
 */
package com.iHotel.model.ForeignSystem.PagamentoCarta;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public interface IPagamentoCartaAdapter {
	public PagamentoConCarta eseguiPagamento(Prezzo prezzo, CartaDiCredito carta);
}
