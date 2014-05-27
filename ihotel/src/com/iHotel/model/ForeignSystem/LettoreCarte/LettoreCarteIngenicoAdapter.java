/**
 * 
 */
package com.iHotel.model.ForeignSystem.LettoreCarte;

import com.iHotel.model.Persona.Persona;
import com.iHotel.model.Persona.Documenti.CartaDiCredito;

/**
 * @author Gabriele
 *
 */
public class LettoreCarteIngenicoAdapter implements ILettoreCarteAdapter {

	@Override
	public CartaDiCredito leggiCarta() {
				
		Persona titolareCarta = new Persona("Giovanni", "Verdi");
		CartaDiCredito carta = new CartaDiCredito(titolareCarta, "123456789abc");
		
		return carta;
	}

}
