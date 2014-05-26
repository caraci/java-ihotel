/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.AmmontareCaparra;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.utility.ULeggiDaFileStrategieSoggiornoAmmontareCaparra;

/**
 * @author Eugenio
 *
 */
public class StrategiaSoggiornoAmmontareCaparraFactory {
	/**
	 * Istanza unica della classe - Pattern Singleton
	 */
	public static StrategiaSoggiornoAmmontareCaparraFactory _instance = null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private StrategiaSoggiornoAmmontareCaparraFactory() {}
	/* ---------------------- Metodi di classe --------------------- */
	/**
	 * Metodo per fornire l'istanza unica di questa classe - Pattern Singleton
	 * @return
	 */
	public static StrategiaSoggiornoAmmontareCaparraFactory getInstance() {
		if (_instance == null) {
			_instance = new StrategiaSoggiornoAmmontareCaparraFactory();
		}
		return _instance;
	}
	/* -------------------- Metodi di istanza ---------------------- */
	/**
	 * Metodo per ottenere la strategia, per il calcolo del giorno di scadenza per l'invio della garanzia
	 * alla richiesta di soggiorno, da parte del prenotante.
	 * 
	 * @return Strategia per calcolare il giorno.
	 */
	public ComponentOttieniAmmontareCaparraStrategy getStrategyCalcoloGiornoScadenza() {
		// Scelgo la strategia di risoluzione indicata dall'albergo in una sorgente esterna.
		ComponentOttieniAmmontareCaparraStrategy componentStrategy = getPoliticaRisoluzioneTraStrategie(ULeggiDaFileStrategieSoggiornoAmmontareCaparra.getPoliticaSceltaStrategieAmmontareCaparra());
		// Carico le strategie da utilizzare.
		ArrayList<String> strategieDaUtilizzare = ULeggiDaFileStrategieSoggiornoAmmontareCaparra.getStrategieDaUtilizzareAmmontareCaparra();
		// Ciclo sulle strategie per decidere quali utilizzare
		for (Iterator<String> iterator = strategieDaUtilizzare.iterator(); iterator.hasNext();) {
			String nomeStrategia = (String) iterator.next();
			// Ricavo la strategia corretta in base al nome fornito e l'aggiungo alla composizione.
			componentStrategy.addStrategy(getLeafStrategyFromName(nomeStrategia));
		}
		
		return componentStrategy;
	}
	/**
	 * Metodo per ottenere la strategia per il calcolo dell'ammontare della caparra, tenendo conto della durata del soggiorno.
	 * 
	 * @return Strategia relativa alla durata del soggiorno per il calcolo dell'ammontare della caparra.
	 */
	private ComponentOttieniAmmontareCaparraStrategy getStrategyCalcoloAmmontareCaparraDurataSoggiorno() {
		// Ricavo i vincoli per la strategia di calcolo dell'ammontare della caparra per la durata del soggiorno.
		ArrayList<VincoloStrategiaDurataSoggiornoAmmontareCaparra> vincoliStrategiaDurataSoggiorno = ULeggiDaFileStrategieSoggiornoAmmontareCaparra.getVincoliStrategiaDurataSoggiorno();
		// Creo la strategia con i vinoli letti dalla sorgente esterna.
		LeafOttieniAmmontareCaparraDurataSoggiornoStrategy leafStrategyDurataSoggiorno = new LeafOttieniAmmontareCaparraDurataSoggiornoStrategy(vincoliStrategiaDurataSoggiorno);
		
		return leafStrategyDurataSoggiorno;
	}
	/**
	 * Metodo per ottenere la strategia per il calcolo dell'ammontare della caparra, tenendo conto del prenotante.
	 * 
	 * @return Strategia relativa al prenotante per il calcolo dell'ammontare della caparra.
	 */
	private ComponentOttieniAmmontareCaparraStrategy getStrategyCalcoloAmmontareCaparraPrenotante() {
		// Ricavo i vincoli per la strategia di calcolo del giorno di scadenza per il cliente prenotante.
		ArrayList<VincoloStrategiaPrenotanteAmmontareCaparra> vincoliStrategiaPrenotante = ULeggiDaFileStrategieSoggiornoAmmontareCaparra.getVincoliStrategiaPrenotante();
		// Creo la strategia con i vincoli letti dalla sorgente esterna.
		LeafOttieniAmmontareCaparraPrenotanteStrategy leafStrategyPrenotante = new LeafOttieniAmmontareCaparraPrenotanteStrategy(vincoliStrategiaPrenotante);
		
		return leafStrategyPrenotante;
	}
	/**
	 * Metodo per ottenere la strategia corretta a partire dal nome fornito.
	 * 
	 * @param nomeStrategia Nome della strategia che si vuole istanziare.
	 * @return Strategia ricercata.
	 */
	private ComponentOttieniAmmontareCaparraStrategy getLeafStrategyFromName(String nomeStrategia) {
		ComponentOttieniAmmontareCaparraStrategy strategy = null;
		
		// Vedo quale strategia fornire in base al nome fornito.
		switch (nomeStrategia) {
		case "AmmontareCaparraOspite":
			strategy = getStrategyCalcoloAmmontareCaparraPrenotante();
			break;
		case "AmmontareCaparraDurataSoggiorno" :
			strategy = getStrategyCalcoloAmmontareCaparraDurataSoggiorno();
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
	private CompositeOttieniAmmontareCaparraStrategy getPoliticaRisoluzioneTraStrategie(String nomeStrategiaRisoluzione) {
		CompositeOttieniAmmontareCaparraStrategy strategyResolution = null;	
		
		// Vedo quale strategia fornire in base al nome fornito.
		switch (nomeStrategiaRisoluzione) {
		case "Prenotante":
			strategyResolution = new CompositeOttieniAmmontareCaparraMigliorePerPrenotanteStrategy();
			break;
		case "Hotel" :
			strategyResolution = new CompositeOttieniAmmontareCaparraMigliorePerHotelStrategy();
			break;
		default:
			break;
		}
		
		return strategyResolution;	
	}

}
