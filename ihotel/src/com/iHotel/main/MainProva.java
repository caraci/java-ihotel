package com.iHotel.main;


import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.StrategieSoggiorno.StrategieSoggiornoFactory;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.CompositeOttieniGiornoScadenzaStrategy;
import com.iHotel.utility.UStartup;

public class MainProva {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException {	
		UStartup.inizializza();
		StrategieSoggiornoFactory factory = StrategieSoggiornoFactory.getInstance();	
		CompositeOttieniGiornoScadenzaStrategy strategy = (CompositeOttieniGiornoScadenzaStrategy) factory.getStrategyCalcoloGiornoScadenza(Storico.getInstance().get_prenotazioni().get(0));
			
		System.out.println(strategy.get_strategie().size());
	}

}
