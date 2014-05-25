/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;


import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;

/**
 * @author Eugenio
 *
 */
public class CompositeGiornoScadenzaMigliorePerHotelStrategy extends
		CompositeOttieniGiornoScadenzaStrategy {

	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		// Giorno di scadenza relativo alla prima strategia.
		Giorno giornoScadenzaPiuLontanoDaInizioSoggiorno = _strategie.get(0).getGiornoScadenza(soggiorno);
		// Ciclo sulle restanti strategie.
		for (int i = 1; i < _strategie.size()-1; i++) {
			ComponentOttieniGiornoScadenzaStrategy strategia = _strategie.get(i);
			// Prendo il giorno relativo a questa strategia
			Giorno giornoScadenzaStrategia = strategia.getGiornoScadenza(soggiorno);
			/*
			 *  Controllo se il giornoScadenzaStrategia è più vicino all'inizio del soggiorno rispetto
			 *  al giorno attualmente scelto.
			 */
			if (giornoScadenzaStrategia.compara(giornoScadenzaPiuLontanoDaInizioSoggiorno) > 0) {
				// Assegno il nuovo valore per il giorno di scadenza
				giornoScadenzaPiuLontanoDaInizioSoggiorno=giornoScadenzaStrategia;
			}
		}
		return giornoScadenzaPiuLontanoDaInizioSoggiorno;
	}


}
