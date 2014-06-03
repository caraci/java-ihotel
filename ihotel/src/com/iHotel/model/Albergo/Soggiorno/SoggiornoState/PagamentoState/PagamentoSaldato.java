/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoStatePagamentoContext;
import com.iHotel.model.Pagamento.Pagamento;

/**
 * @author Eugenio
 *
 */
public class PagamentoSaldato extends PagamentoStateObserver {

	public PagamentoSaldato(SoggiornoStatePagamentoContext soggiornoStateContext, SoggiornoContextSubject soggiornoContext) {
		super(soggiornoStateContext, soggiornoContext);
	}

	@Override
	public void addPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Update() {
		// Essendo stato aggiunto un servizio interno ad una camera del soggiorno, allora il pagamento diventa sospeso.
		_soggiornoStatePagamentoContext.set_pagamentoState(new PagamentoSospeso(_soggiornoStatePagamentoContext, _soggiornoContext));	
	}

}
