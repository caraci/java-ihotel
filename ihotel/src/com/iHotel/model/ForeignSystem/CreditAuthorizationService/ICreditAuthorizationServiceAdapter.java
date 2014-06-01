/**
 * 
 */
package com.iHotel.model.ForeignSystem.CreditAuthorizationService;

import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe interfaccia a capo della gerarchia degli adattatori dei sistemi di autorizzazione dei pagamenti
 * 
 * @author Gabriele
 */
public interface ICreditAuthorizationServiceAdapter {
	/**
	 * Metodo per richiedere l'autorizzazione al pagamento.
	 */
	public boolean richiestaDiAutorizzazione(Prezzo importoPagamento, CartaDiCredito carta);
}
