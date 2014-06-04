/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;

/**
 * Questa classe rappresenta lo stato di un soggiorno che viene cancellato.
 * 
 * @author Gabriele
 */
public class SoggiornoCancellato extends SoggiornoState {

	public SoggiornoCancellato(SoggiornoContextSubject soggiornoSubject) {
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
	public void effettuaCheckIn() {
		// TODO Auto-generated method stub
	}

	@Override
	public void effettuaCheckOut() {
		// TODO Auto-generated method stub
	}

}
