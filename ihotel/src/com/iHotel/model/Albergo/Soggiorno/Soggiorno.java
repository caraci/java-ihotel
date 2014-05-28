/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.Prezzo;

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
		// Creo lo stato successivo
		SoggiornoState statoSuccessivo = new SoggiornoTerminato(_soggiornoSubject);
		return statoSuccessivo;
	}


	@Override
	public SoggiornoState effettuaCheckOut() {
		// TODO Auto-generated method stub
		return null;
	}

}
