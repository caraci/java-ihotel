/**
 * 
 */
package com.iHotel.model.Strategy;

import com.iHotel.model.Utility.Periodo;


/**
 * Classe addetta all'ottenimento della corretta strategia per la creazione di nuovi stati camera in seguito
 * alla creazione di una nuova prenotazione.
 * 
 * @author Eugenio
 */
public class CreaStatiCameraStrategyFactory {

	/*--------------- Attributi e Costruttore ----------------------------*/
	private static CreaStatiCameraStrategyFactory instance = null;
	/**
	 * Costruttore privato - Pattern singletone.
	 */
	private CreaStatiCameraStrategyFactory() {}
	/*---------------- Metodi di classe ------------------------------ */
	/**
	 * Metodo per ottenere l'instanza unica della classe - Pattern Singleton
	 */
	public static CreaStatiCameraStrategyFactory getInstance() {
		if(instance == null) {
            instance = new CreaStatiCameraStrategyFactory();
         }
         return instance;
	}
	/*--------------------- Metodi di instanza --------------------- */
	/**
	 * Metodo per ottenere la giusta strategia per la creazione di nuovi stati camera in seguito all'occupazione.
	 * 
	 * @param periodoStato Periodo dello stato camera nel quale si farà l'occupazione.
	 * @param periodoRichiesta Periodo in cui si vuole occupare.
	 * @return Strategia corretta per l'occupazione della camera.
	 */
	public CreaStatiCameraStrategy getStrategy(Periodo periodoStato, Periodo periodoRichiesta) {
		// Strategia da restituire
		CreaStatiCameraStrategy creaStatiCameraStrategy;
		// Controllo quale strategia fornire allo stato sulla base dei periodi ricevuti.
		if (periodoStato.coincideCon(periodoRichiesta)) {
			creaStatiCameraStrategy = new AllCreaStatiCameraStrategy();
		} 
		else if (periodoStato.IniziaStessoGiornoInizioDi(periodoRichiesta)) {
			creaStatiCameraStrategy = new LeftCreaStatiCameraStrategy();
		}
		else if (periodoStato.FinisceStessoGiornoFineDi(periodoRichiesta)) {
			creaStatiCameraStrategy = new RightCreaStatiCameraStrategy();
		} else {
			creaStatiCameraStrategy = new MiddleCreaStatiCameraStrategy();
		}		
		return creaStatiCameraStrategy;
	}
}
