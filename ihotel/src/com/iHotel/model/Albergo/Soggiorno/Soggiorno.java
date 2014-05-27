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
	public void calcolaTotaleDaPagare() {
		Prezzo importoDaPagare = new Prezzo();
		Prezzo totaleServiziEsterni = new Prezzo();
		
		totaleServiziEsterni = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(_soggiornoSubject);
		// Aggiungo tutti i costi della prenotazione
		importoDaPagare.somma(_soggiornoSubject.get_importoTotaleCamere());
		importoDaPagare.somma(_soggiornoSubject.getPrezzoServiziInterni());
		importoDaPagare.somma(totaleServiziEsterni);
		// Sottraggo i pagamenti pervenuti
		importoDaPagare.sottrai(_soggiornoSubject.get_importoTotalePagamenti());
		// Setto il nuovo totale da pagare.
		_soggiornoSubject.set_importoRimanenteDaPagare(importoDaPagare);		
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

}
