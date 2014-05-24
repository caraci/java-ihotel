/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno;

import java.util.HashMap;
import java.util.Iterator;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.ComponentOttieniGiornoScadenzaStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.CompositeGiornoScadenzaMigliorePerPrenotanteStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.LeafOttieniGiornoScadenzaDurataSoggiornoStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.LeafOttieniGiornoScadenzaOccupazioneCamereStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.LeafOttieniGiornoScadenzaPrenotanteStrategy;
import com.iHotel.utility.ULeggiDaFileStrategie;

/**
 * @author Eugenio
 *
 */
public class StrategieSoggiornoFactory {
	/**
	 * Istanza unica della classe - Pattern Singleton
	 */
	public static StrategieSoggiornoFactory _instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private StrategieSoggiornoFactory() {}
	/* ---------------------- Metodi di classe --------------------- */
	/**
	 * Metodo per fornire l'istanza unica di questa classe - Pattern Singleton
	 * @return
	 */
	public static StrategieSoggiornoFactory getInstance() {
		if (_instance == null) {
			_instance = new StrategieSoggiornoFactory();
		}
		return _instance;
	}
	/* -------------------- Metodi di istanza ---------------------- */
	/**
	 * Metodo per ottenere la strategia, per il calcolo del giorno di scadenza per l'invio della garanzia
	 * alla richiesta di soggiorno, da parte del prenotante.
	 * 
	 * @param soggiorno Soggiorno in analisi.
	 * @return Strategia per calcolare il giorno.
	 */
	public ComponentOttieniGiornoScadenzaStrategy getStrategyCalcoloGiornoScadenza(SoggiornoContextSubject soggiorno) {
		// Strategia da fornire
		// TODO - Per il momento scelgo la strategia composita migliore per prenotante.
		ComponentOttieniGiornoScadenzaStrategy componentStrategy = new CompositeGiornoScadenzaMigliorePerPrenotanteStrategy();
		// Carico le strategie da utilizzare.
		HashMap<String,Boolean> strategieDaUtilizzare = ULeggiDaFileStrategie.getStrategieDaUtilizzareGiornoScadenza();
		// Ciclo sulle strategie per decidere quali utilizzare
		for (Iterator<String> iterator = strategieDaUtilizzare.keySet().iterator(); iterator.hasNext();) {
			String nomeStrategia = (String) iterator.next();
			// TODO - In base a quello che si legge bisogna istanziare la giusta strategia.
			
		}
		
		return componentStrategy;
	}
	/**
	 * Metodo per ottenere la strategia per il calcolo del giorno di scadenza di invio della garanzia, tenendo conto del prenotante.
	 * 
	 * @param soggiorno
	 * @return
	 */
	private LeafOttieniGiornoScadenzaPrenotanteStrategy getStrategyCalcoloGiornoScadenzaPrenotante(SoggiornoContextSubject soggiorno) {
	
		return null;
	}
	
	/**
	 * Metodo per ottenere la strategia per il calcolo del giorno di scadenza di invio della garanzia, tenendo conto della durata del soggiorno.
	 * 
	 * @param soggiorno
	 * @return
	 */
	private LeafOttieniGiornoScadenzaDurataSoggiornoStrategy getStrategyCalcoloGiornoScadenzaDurataSoggiorno(SoggiornoContextSubject soggiorno) {
	
		return null;
	}
	
	/**
	 * Metodo per ottenere la strategia per il calcolo del giorno di scadenza di invio della garanzia, tenendo conto dell'occupazione delle camere.
	 * 
	 * @param soggiorno
	 * @return
	 */
	private LeafOttieniGiornoScadenzaOccupazioneCamereStrategy getStrategyCalcoloGiornoScadenzaOccupazioneCamere(SoggiornoContextSubject soggiorno) {
	
		return null;
	}
	
	
	
	
	
}

