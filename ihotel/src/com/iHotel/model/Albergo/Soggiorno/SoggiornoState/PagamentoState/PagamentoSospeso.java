/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoStatePagamentoContext;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class PagamentoSospeso extends PagamentoStateObserver {

	public PagamentoSospeso(SoggiornoStatePagamentoContext soggiornoStateContext, SoggiornoContextSubject soggiornoContext) {
		super(soggiornoStateContext, soggiornoContext);
	}

	@Override
	public void addPagamento(Pagamento pagamento) {
		// Aggiungo il pagamento alla lista di pagamenti.
		_soggiornoContext.get_pagamenti().add(pagamento);
		// Sommo l'importo del pagamento al totale dei pagamenti
		_soggiornoContext.set_importoTotalePagamenti(_soggiornoContext.get_importoTotalePagamenti().somma(pagamento.get_importo()));
		// Notifico il cambiamento all'interfaccia
		_soggiornoContext.Notify();
		// Ricalcolo il rimanente da pagare
		Prezzo importoRimanenteDaPagare = _soggiornoContext.calcolaImportoRimanenteDaPagare();	
		// Controllo se l'importo rimanente da pagare 
		if (importoRimanenteDaPagare.get_quantita()==0) {
			// Passiamo allo stato del pagamento saldato.
			_soggiornoStatePagamentoContext.set_pagamentoState(new PagamentoSaldato(_soggiornoStatePagamentoContext, _soggiornoContext));
		}
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

}
