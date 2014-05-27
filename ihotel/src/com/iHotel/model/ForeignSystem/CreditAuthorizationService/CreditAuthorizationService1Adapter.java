/**
 * 
 */
package com.iHotel.model.ForeignSystem.CreditAuthorizationService;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;

/**
 * @author Gabriele
 *
 */
public class CreditAuthorizationService1Adapter implements
		ICreditAuthorizationServiceAdapter {

	@Override
	public boolean richiestaDiApprovazione(
			SoggiornoContextSubject soggiorno, CartaDiCredito carta) {
		
		return false;
	}

}
