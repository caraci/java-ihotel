/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoState;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.ISubject;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class PagamentoSospeso extends PagamentoStateObserver {

	public PagamentoSospeso(SoggiornoState soggiornoState) {
		super(soggiornoState);
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
			// Creo il pagamento state saldato.
			PagamentoSaldato pagamentoSaldato = new PagamentoSaldato(_soggiornoState);
			// Ciclo sulla lista dei subject per assegnare il nuovo osservatore.
			for (Iterator<ISubject> iterator = _elencoSubject.iterator(); iterator.hasNext();) {
				ISubject subject = (ISubject) iterator.next();
				// Assegno il nuovo observer al generico subject.
				subject.Attach(pagamentoSaldato);
			}
			// Assegno la lista dei subject del pagamentoSospeso, aggiornati al nuovo osservatore, al pagamentoSaldato.
			pagamentoSaldato.set_elencoSubject(this.get_elencoSubject());
			// Essendo stato saldato il soggiorno, allora il pagamento diventa saldato.
			_soggiornoState.set_pagamentoState(pagamentoSaldato);
		}
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

}
