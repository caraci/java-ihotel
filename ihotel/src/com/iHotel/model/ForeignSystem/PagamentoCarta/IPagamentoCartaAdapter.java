/**
 * 
 */
package com.iHotel.model.ForeignSystem.PagamentoCarta;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.PagamentoConCarta;

/**
 * @author Gabriele
 *
 */
public interface IPagamentoCartaAdapter {
	public PagamentoConCarta eseguiPagamento(SoggiornoContextSubject soggiorno);
}
