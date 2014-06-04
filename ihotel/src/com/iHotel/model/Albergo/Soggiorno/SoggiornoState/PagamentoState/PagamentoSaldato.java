/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoState;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.ISubject;

/**
 * @author Eugenio
 *
 */
public class PagamentoSaldato extends PagamentoStateObserver {

	public PagamentoSaldato(SoggiornoState soggiornoState) {
		super(soggiornoState);
	}

	@Override
	public void addPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Update() {
		// Creo il pagamento state sospeso.
		PagamentoSospeso pagamentoSospeso = new PagamentoSospeso(_soggiornoState);
		// Ciclo sulla lista dei subject per assegnare il nuovo osservatore.
		for (Iterator<ISubject> iterator = _elencoSubject.iterator(); iterator.hasNext();) {
			ISubject subject = (ISubject) iterator.next();
			// Assegno il nuovo observer al generico subject.
			subject.Attach(pagamentoSospeso);
		}
		// Assegno la lista dei subject del pagamentoSaldato, aggiornati al nuovo osservatore, al pagamentoSospeso.
		pagamentoSospeso.set_elencoSubject(this.get_elencoSubject());
		// Essendo stato aggiunto un servizio interno ad una camera del soggiorno, allora il pagamento diventa sospeso.
		_soggiornoState.set_pagamentoState(pagamentoSospeso);	
	}

}
