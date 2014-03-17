/**
 * 
 */
package com.iHotel.model.Strategy;

import com.iHotel.model.Utility.Periodo;


/**
 * @author Eugenio
 *
 */
public class CreaStatiCameraStrategyFactory {

	/*--------------- Attributi e Costruttore ----------------------------*/
	private static CreaStatiCameraStrategyFactory instance = null;
	
	private CreaStatiCameraStrategyFactory() {}
	/*---------------- Metodi di classe ------------------------------ */
	public static CreaStatiCameraStrategyFactory getInstance() {
		if(instance == null) {
            instance = new CreaStatiCameraStrategyFactory();
         }
         return instance;
	}
	/*--------------------- Metodi di instanza --------------------- */
	public CreaStatiCameraStrategy getStrategy(Periodo periodoStato, Periodo periodoRichiesta) {
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
