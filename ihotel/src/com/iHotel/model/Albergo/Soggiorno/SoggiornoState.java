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
public abstract class SoggiornoState {
	/**
	 * Soggiorno a cui è associato lo stato - Pattern State
	 */
	protected SoggiornoContextSubject _soggiornoSubject;
	/**
	 * Costruttore.
	 * 
	 * @param soggiornoSubject Soggiorno a cui è associato lo stato.
	 */
	public SoggiornoState(SoggiornoContextSubject soggiornoSubject) {
		_soggiornoSubject=soggiornoSubject;
	}
	
	public abstract Prezzo getPrezzoServiziInterni();
	public abstract void calcolaImportoTotaleCamere();
	public abstract void calcolaTotaleDaPagare();
	public abstract void addCamera(Camera camera);
	public abstract void addPrenotante(String nome, String cognome, String eMail, String telefono);
	public abstract void occupaCamere();
	public abstract void addPagamento(Pagamento pagamento);
	public abstract void concludiPrenotazione(String nome, String cognome, String eMail, String telefono);
	
	
	/* ----------------- Getter, Setter ------------------- */
	/**
	 * @return the _soggiornoSubject
	 */
	public SoggiornoContextSubject get_soggiornoSubject() {
		return _soggiornoSubject;
	}
	/**
	 * @param _soggiornoSubject the _soggiornoSubject to set
	 */
	public void set_soggiornoSubject(SoggiornoContextSubject _soggiornoSubject) {
		this._soggiornoSubject = _soggiornoSubject;
	}
	
}
