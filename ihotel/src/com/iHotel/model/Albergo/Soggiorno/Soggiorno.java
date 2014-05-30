/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Pagamento.Pagamento;

/**
 * @author Gabriele
 *
 */
public class Soggiorno extends SoggiornoState {

	public Soggiorno(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
		// TODO Auto-generated constructor stub
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
	public void concludiPrenotazione(String nome, String cognome, String eMail,
			String telefono) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public SoggiornoState effettuaCheckIn() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SoggiornoState effettuaCheckOut() {
		// Creo lo stato successivo
		SoggiornoState statoSuccessivo = new SoggiornoTerminato(_soggiornoSubject);
		return statoSuccessivo;		
	}

}
