/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import com.iHotel.model.Albergo.Camera.Camera;

/**
 * Questa classe rappresenta lo stato del soggiorno in seguito al checkOut.
 * 
 * @author Gabriele
 */
public class SoggiornoTerminato extends SoggiornoState {

	public SoggiornoTerminato(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
		// TODO Auto-generated constructor stub
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
	public SoggiornoState effettuaCheckIn() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SoggiornoState effettuaCheckOut() {
		// TODO Auto-generated method stub
		return null;
	}

}
