/**
 * 
 */
package com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;

/**
 * Classe astratta a capo della gerarchia delle strategie per il calcolo del giorno entro cui inviare la caparra
 * @author Eugenio
 *
 */
public abstract class ComponentOttieniGiornoScadenzaStrategy {
	/**
	 * Metodo che restituisce la data di scadenza entro cui inviare la caparra
	 * @param soggiorno Soggiorno per cui si vuole calcolare l'ultima data utile per versare la caparra
	 * @return Giorno ultimo entro cui bisogna versare la caparra
	 */
	public abstract Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno);
	/**
	 * Metodo per aggiungere una strategia, semplice o composta, ad una strategia composta
	 * @param strategy Strategia da aggiungere
	 */
	public void addStrategy(ComponentOttieniGiornoScadenzaStrategy strategy) {
		// Do nothing
	}

}
