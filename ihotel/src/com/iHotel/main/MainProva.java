package com.iHotel.main;

import java.util.ArrayList;

import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaDurataSoggiornoStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaOccupazioneCamereGiornoScadenza;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.VincoloStrategiaPrenotanteGiornoScadenza;
import com.iHotel.utility.ULeggiDaFileStrategieSoggiorno;

public class MainProva {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException {	
		ArrayList<VincoloStrategiaPrenotanteGiornoScadenza> vincoli=ULeggiDaFileStrategieSoggiorno.getVincoliStrategiaPrenotante();
		System.out.println(vincoli.size());
		System.out.println(vincoli.get(0).get_quantiGiorniPrimaRichiedere());
		
		ArrayList<VincoloStrategiaDurataSoggiornoStrategy> vincoli2=ULeggiDaFileStrategieSoggiorno.getVincoliStrategiaDurataSoggiorno();
		System.out.println(vincoli2.size());
		System.out.println(vincoli2.get(0).get_quantiGiorniPrimaRichiedere());
		
		ArrayList<VincoloStrategiaOccupazioneCamereGiornoScadenza> vincoli3=ULeggiDaFileStrategieSoggiorno.getVincoliStrategiaOccupazioneCamere();
		System.out.println(vincoli3.size());
		System.out.println(vincoli3.get(0).get_quantiGiorniPrimaRichiedere());
	}

}
