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
public interface ICreditAuthorizationServiceAdapter {
	public boolean richiestaDiApprovazione(Prezzo importoPagamento, CartaDiCredito carta);

}
