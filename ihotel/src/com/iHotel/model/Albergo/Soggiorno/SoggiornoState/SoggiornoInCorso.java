/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoStateObserver;
import com.iHotel.model.Pagamento.Pagamento;

/**
 * Questa classe rappresenta lo stato del soggiorno successivo al check in.
 * @author Gabriele
 */
public class SoggiornoInCorso extends SoggiornoStatePagamentoContext {

	public SoggiornoInCorso(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
	}

	public SoggiornoInCorso(SoggiornoContextSubject soggiornoSubject, PagamentoStateObserver pagamentoState) {
		super(soggiornoSubject, pagamentoState);
	}
	
	@Override
	public void addCamera(Camera camera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPrenotante(String nome, String cognome, String eMail, String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void occupaCamere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void concludiPrenotazione(String nome, String cognome, String eMail,	String telefono) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void effettuaCheckIn() {
		// TODO Auto-generated method stub
	}


	@Override
	public void effettuaCheckOut() {
		// Importo rimanente da pagare per il soggiorno.
		_soggiornoSubject.set_soggiornoState(new SoggiornoTerminato(_soggiornoSubject, _pagamentoState));
	}

}
