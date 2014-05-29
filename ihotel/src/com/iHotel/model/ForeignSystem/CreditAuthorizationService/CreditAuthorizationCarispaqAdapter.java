/**
 * 
 */
package com.iHotel.model.ForeignSystem.CreditAuthorizationService;

import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe concreta adattatore che si interfaccia con il sistema esterno per l'autorizazione al pagamento
 * 
 * @author Gabriele
 *
 */
public class CreditAuthorizationCarispaqAdapter implements
		ICreditAuthorizationServiceAdapter {

	@Override
	/**
	 * Metodo per richiedere l'autorizzazione al pagamento. Al momento è fittizio e restituisce true
	 */
	public boolean richiestaDiAutorizzazione(Prezzo importoPagamento, CartaDiCredito carta) {		
		return true;
	}

}
