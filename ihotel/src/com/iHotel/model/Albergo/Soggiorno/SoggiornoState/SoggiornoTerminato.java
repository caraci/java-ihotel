/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoStateObserver;

/**
 * Questa classe rappresenta lo stato del soggiorno in seguito al checkOut.
 * 
 * @author Gabriele
 */
public class SoggiornoTerminato extends SoggiornoState {

	public SoggiornoTerminato(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
	}
	
	public SoggiornoTerminato(SoggiornoContextSubject soggiornoSubject, PagamentoStateObserver pagamentoState) {
		super(soggiornoSubject, pagamentoState);
	}

	@Override
	public void addCamera(Camera camera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPrenotante(String nome, String cognome, String eMail,
			String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void occupaCamere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void concludiPrenotazione(String nome, String cognome, String eMail,
			String telefono) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void effettuaCheckIn() {
		// TODO Auto-generated method stub
	}


	@Override
	public void effettuaCheckOut() {
		// TODO Auto-generated method stub
	}

}
