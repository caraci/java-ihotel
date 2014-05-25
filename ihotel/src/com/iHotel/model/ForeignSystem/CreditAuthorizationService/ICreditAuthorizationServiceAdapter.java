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
public interface ICreditAuthorizationServiceAdapter {
	public boolean richiestaDiApprovazione(SoggiornoContextSubject prenotazione, CartaDiCredito carta);

}
