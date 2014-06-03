/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Pagamento.Pagamento;

/**
 * Questa classe rappresenta lo stato del soggiorno successivo al check in.
 * @author Gabriele
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
		//creo uno stato
		SoggiornoState statoSuccessivo;
		//controllo se la prenotazione è stata saldata
		if (_soggiornoSubject.calcolaImportoRimanenteDaPagare().get_quantita()==0) {
			//Creo lo stato successivo
			statoSuccessivo = new SoggiornoTerminatoSaldato(_soggiornoSubject);
		} else {
			//l'importo non è stato saldato o saldato in parte 
			statoSuccessivo = new SoggiornoTerminatoSospeso(_soggiornoSubject);
		}
		return statoSuccessivo;
	}

}
