/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoStateObserver;

/**
 * Questa classe rappresenta lo stato del soggiorno successivo al check in.
 * @author Gabriele
 */
public class SoggiornoInCorso extends SoggiornoState {

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
	public void concludiPrenotazione(String nome, String cognome, String eMail,	String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effettuaCheckIn() {
		// TODO Auto-generated method stub
	}


	@Override
	public void effettuaCheckOut() {
		// Creo lo stato successivo soggiornoTerminato.
		SoggiornoTerminato soggiornoTerminato = new SoggiornoTerminato(_soggiornoContext, _pagamentoState);
		// Comunico al pagamento state il nuovo stato del soggiorno
		_pagamentoState.set_soggiornoStatePagamentoContext(soggiornoTerminato);
		// Setto lo stato successivo al subject.
		_soggiornoContext.set_soggiornoState(soggiornoTerminato);
	}

}
