/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public class SoggiornoCancellato extends SoggiornoState {

	public SoggiornoCancellato(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Prezzo getPrezzoServiziInterni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void calcolaImportoTotaleCamere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcolaTotaleDaPagare() {
		// TODO Auto-generated method stub
		
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
	public void addPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void concludiPrenotazione(String nome, String cognome, String eMail,
			String telefono) {
		// TODO Auto-generated method stub
		
	}

}
