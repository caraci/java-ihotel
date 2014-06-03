/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoStatePagamentoContext;

/**
 * @author Eugenio
 *
 */
public class PagamentoSaldato extends PagamentoStateObserver {

	
	public PagamentoSaldato(SoggiornoStatePagamentoContext soggiornoStateContext) {
		super(soggiornoStateContext);
	}

}
