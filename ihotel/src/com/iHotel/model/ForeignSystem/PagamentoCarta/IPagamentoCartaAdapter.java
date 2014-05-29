/**
 * 
 */
package com.iHotel.model.ForeignSystem.PagamentoCarta;

import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe Interfaccia a capo della gerarchia degli adattatori al sistema esterno 
 * per il pagamento con carta
 * 
 * @author Gabriele
 *
 */
public interface IPagamentoCartaAdapter {
	public PagamentoConCarta eseguiPagamento(Prezzo prezzo, CartaDiCredito carta);
}
