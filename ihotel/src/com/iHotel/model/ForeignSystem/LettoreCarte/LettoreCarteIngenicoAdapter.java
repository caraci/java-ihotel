/**
 * 
 */
package com.iHotel.model.ForeignSystem.LettoreCarte;

import com.iHotel.model.Persona.Persona;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;

/**
 * Classe concreta adattatore verso il sistema di lettore carte "Ingenico"
 * @author Gabriele
 *
 */
public class LettoreCarteIngenicoAdapter implements ILettoreCarteAdapter {

	@Override
	/**
	 * Metodo fittizio per leggere la carta. Nella realtà ci si collegherà con un sistema esterno.
	 */
	public CartaDiCredito leggiCarta() {
		/*Si settano le informazioni sul titolare della carta*/
		Persona titolareCarta = new Persona("Giovanni", "Verdi");
		/*Si crea la carta di credito*/
		CartaDiCredito carta = new CartaDiCredito(titolareCarta, "123456789abc");
		/*Restituisco la carta di credito*/
		return carta;
	}

}
