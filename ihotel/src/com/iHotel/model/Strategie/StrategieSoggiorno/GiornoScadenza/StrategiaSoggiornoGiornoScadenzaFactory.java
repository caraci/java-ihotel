/**
 * 
 */
package com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.utility.ULeggiDaFileStrategieSoggiornoGiornoScadenza;

/**
 * Classe che ha la responsabilità di istanziare un oggetto strategia per il calcolo del giorno entro cui versare la caparra,
 * sulla base delle politiche aziendali.
 * @author Eugenio
 *
 */
public class StrategiaSoggiornoGiornoScadenzaFactory {
	/**
	 * Istanza unica della classe - Pattern Singleton
	 */
	private static StrategiaSoggiornoGiornoScadenzaFactory _instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private StrategiaSoggiornoGiornoScadenzaFactory() {}
	/* ---------------------- Metodi di classe --------------------- */
	/**
	 * Metodo per fornire l'istanza unica di questa classe - Pattern Singleton
	 * @return
	 */
	public static StrategiaSoggiornoGiornoScadenzaFactory getInstance() {
		if (_instance == null) {
			_instance = new StrategiaSoggiornoGiornoScadenzaFactory();
		}
		return _instance;
	}
	/* -------------------- Metodi di istanza ---------------------- */
	/**
	 * Metodo pubblico per ottenere la strategia, per il calcolo del giorno di scadenza per l'invio della garanzia
	 * alla richiesta di soggiorno, da parte del prenotante.
	 * 
	 * @return Strategia per calcolare il giorno.
	 */
	public ComponentOttieniGiornoScadenzaStrategy getStrategyCalcoloGiornoScadenza() {
		// Scelgo la strategia di risoluzione indicata dall'albergo in una sorgente esterna.
		ComponentOttieniGiornoScadenzaStrategy componentStrategy = getPoliticaRisoluzioneTraStrategie(ULeggiDaFileStrategieSoggiornoGiornoScadenza.getPoliticaSceltaStrategieGiornoScadenza());
		// Carico le strategie da utilizzare.
		ArrayList<String> strategieDaUtilizzare = ULeggiDaFileStrategieSoggiornoGiornoScadenza.getStrategieDaUtilizzareGiornoScadenza();
		// Ciclo sulle strategie per decidere quali utilizzare
		for (Iterator<String> iterator = strategieDaUtilizzare.iterator(); iterator.hasNext();) {
			String nomeStrategia = (String) iterator.next();
			// Ricavo la strategia corretta in base al nome fornito e l'aggiungo alla composizione.
			componentStrategy.addStrategy(getLeafStrategyFromName(nomeStrategia));
		}
		
		return componentStrategy;
	}
	/**
	 * Metodo per ottenere la strategia per il calcolo del giorno di scadenza di invio della garanzia, tenendo conto del prenotante.
	 * 
	 * @return Strategia relativa al prenotante per il calcolo del giorno di scadenza di invio della garanzia.
	 */
	private LeafOttieniGiornoScadenzaPrenotanteStrategy getStrategyCalcoloGiornoScadenzaPrenotante() {
		// Ricavo i vincoli per la strategia di calcolo del giorno di scadenza per il cliente prenotante.
		ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> vincoliStrategiaPrenotante = ULeggiDaFileStrategieSoggiornoGiornoScadenza.getVincoliStrategiaPrenotante();
		// Creo la strategia con i vinoli letti dalla sorgente esterna.
		LeafOttieniGiornoScadenzaPrenotanteStrategy leafStrategyPrenotante = new LeafOttieniGiornoScadenzaPrenotanteStrategy(vincoliStrategiaPrenotante);
		
		return leafStrategyPrenotante;
	}
	
	/**
	 * Metodo per ottenere la strategia per il calcolo del giorno di scadenza di invio della garanzia, tenendo conto della durata del soggiorno.
	 * 
	 * @return Strategia relativa alla durata del soggiorno per il calcolo del giorno di scadenza di invio della garanzia.
	 */
	private LeafOttieniGiornoScadenzaDurataSoggiornoStrategy getStrategyCalcoloGiornoScadenzaDurataSoggiorno() {
		// Ricavo i vincoli per la strategia di calcolo del giorno di scadenza per la durata del soggiorno.
		ArrayList<VincoloStrategiaDurataSoggiornoGiornoScadenza> vincoliStrategiaDurataSoggiorno = ULeggiDaFileStrategieSoggiornoGiornoScadenza.getVincoliStrategiaDurataSoggiorno();
		// Creo la strategia con i vinoli letti dalla sorgente esterna.
		LeafOttieniGiornoScadenzaDurataSoggiornoStrategy leafStrategyDurataSoggiorno = new LeafOttieniGiornoScadenzaDurataSoggiornoStrategy(vincoliStrategiaDurataSoggiorno);
		
		return leafStrategyDurataSoggiorno;
	}
	
	/**
	 * Metodo per ottenere la strategia per il calcolo del giorno di scadenza di invio della garanzia, tenendo conto dell'occupazione delle camere.
	 * 
	 * @return Strategia relativa all'occupazione delle camere per il calcolo del giorno di scadenza di invio della garanzia.
	 */
	private LeafOttieniGiornoScadenzaOccupazioneCamereStrategy getStrategyCalcoloGiornoScadenzaOccupazioneCamere() {
		// Ricavo i vincoli per la strategia di calcolo del giorno di scadenza per la durata del soggiorno.
		ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza> vincoliStrategiaOccupazioneCamere = ULeggiDaFileStrategieSoggiornoGiornoScadenza.getVincoliStrategiaOccupazioneCamere();
		// Creo la strategia con i vincoli letti dalla sorgente esterna.
		LeafOttieniGiornoScadenzaOccupazioneCamereStrategy leafStrategyOccupazioneCamere = new LeafOttieniGiornoScadenzaOccupazioneCamereStrategy(vincoliStrategiaOccupazioneCamere);
		
		return leafStrategyOccupazioneCamere;
	}
	/**
	 * Metodo per ottenere la strategia corretta a partire dal nome fornito.
	 * 
	 * @param nomeStrategia Nome della strategia che si vuole istanziare.
	 * @return Strategia ricercata.
	 */
	private ComponentOttieniGiornoScadenzaStrategy getLeafStrategyFromName(String nomeStrategia) {
		ComponentOttieniGiornoScadenzaStrategy strategy = null;
				
		// Vedo quale strategia fornire in base al nome fornito.
		switch (nomeStrategia) {
		case "GiornoScadenzaOspite":
			strategy = getStrategyCalcoloGiornoScadenzaPrenotante();
			break;
		case "GiornoScadenzaOccupazioneCamere" :
			strategy = getStrategyCalcoloGiornoScadenzaOccupazioneCamere();
			break;
		case "GiornoScadenzaDurataSoggiorno" :
			strategy = getStrategyCalcoloGiornoScadenzaDurataSoggiorno();
			break;
		default:
			break;
		}
		
		return strategy;	
	}
	
	/**
	 * Metodo per ottenere la strategia di risoluzione corretta a partire dal nome fornito.
	 * 
	 * @param nomeStrategiaRisoluzione Nome della strategia di risoluzione che si vuole utilizzare.
	 * @return Strategia di risoluzione ricercata.
	 */
	private CompositeOttieniGiornoScadenzaStrategy getPoliticaRisoluzioneTraStrategie(String nomeStrategiaRisoluzione) {
		CompositeOttieniGiornoScadenzaStrategy strategyResolution = null;	
		
		// Vedo quale strategia fornire in base al nome fornito.
		switch (nomeStrategiaRisoluzione) {
		case "Prenotante":
			strategyResolution = new CompositeGiornoScadenzaMigliorePerPrenotanteStrategy();
			break;
		case "Hotel" :
			strategyResolution = new CompositeGiornoScadenzaMigliorePerHotelStrategy();
			break;
		default:
			break;
		}
		
		return strategyResolution;	
	}
	
}

