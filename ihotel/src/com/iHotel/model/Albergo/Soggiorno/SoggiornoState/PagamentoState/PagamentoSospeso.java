/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoStatePagamentoContext;

/**
 * @author Eugenio
 *
 */
public class PagamentoSospeso extends PagamentoStateObserver {

	public PagamentoSospeso(SoggiornoStatePagamentoContext soggiornoStateContext) {
		super(soggiornoStateContext);
	}

}
