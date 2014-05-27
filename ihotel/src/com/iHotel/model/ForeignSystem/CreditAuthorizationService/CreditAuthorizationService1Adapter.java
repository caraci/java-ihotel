/**
 * 
 */
package com.iHotel.model.ForeignSystem.CreditAuthorizationService;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public class CreditAuthorizationService1Adapter implements
		ICreditAuthorizationServiceAdapter {

	@Override
	public boolean richiestaDiApprovazione(Prezzo importoPagamento, CartaDiCredito carta) {
		
		return true;
	}

}
