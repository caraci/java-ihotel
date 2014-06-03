/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState;

import java.util.ArrayList;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.SoggiornoStatePagamentoContext;
import com.iHotel.model.Utility.ISubject;
import com.iHotel.view.Utility.IObserver;

/**
 * @author Eugenio
 *
 */
public class PagamentoStateObserver implements IObserver {
	/**
	 * Lista dei subject di questo osservatore. Sono gli stati delle camere riservate
	 * per il soggiorno associato.
	 */
	protected ArrayList<ISubject> _subject;
	/**
	 * Stato in cui si trova il soggiorno.
	 */
	protected SoggiornoStatePagamentoContext _soggiornoStateContext;
	/**
	 * Costruttore.
	 * 
	 * @param soggiornoStateContext Stato in cui si trova il soggiorno.
	 */
	protected PagamentoStateObserver(SoggiornoStatePagamentoContext soggiornoStateContext) {
		_soggiornoStateContext = soggiornoStateContext;
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

}
