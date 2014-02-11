import java.util.*;

import com.iHotel.model.*;
public class MainTestCatalogo {

	public static void main(String[] args) {
		//periodi
		
				// periodo_1 - 1 Gennaio 2014 - 00:00.00 - 31 Gennaio 2014 - 23.59.59
						MPeriodo periodo_1 = new MPeriodo();
						int giornoInizio_1 = 1;
						int meseInizio_1 = 0;
						int annoInizio_1 = 2014;
						int giornoFine_1 = 31;
						int meseFine_1 = 0;
						int annoFine_1 = 2014;
						periodo_1.set_giornoInizio(giornoInizio_1);
						periodo_1.set_meseInizio(meseInizio_1);
						periodo_1.set_annoInizio(annoInizio_1);
						periodo_1.set_giornoFine(giornoFine_1);
						periodo_1.set_meseFine(meseFine_1);
						periodo_1.set_annoFine(annoFine_1);
						
						
					// periodo_2 - 1 Febbraio 2014 - 00:00.00 - 28 Febbraio 2014 - 23:59.59				
						MPeriodo periodo_2 = new MPeriodo();
						int giornoInizio_2 = 1;
						int meseInizio_2 = 1;
						int annoInizio_2 = 2014;
						int giornoFine_2 = 28;
						int meseFine_2 = 1;
						int annoFine_2 = 2014;
						periodo_2.set_giornoInizio(giornoInizio_2);
						periodo_2.set_meseInizio(meseInizio_2);
						periodo_2.set_annoInizio(annoInizio_2);
						periodo_2.set_giornoFine(giornoFine_2);
						periodo_2.set_meseFine(meseFine_2);
						periodo_2.set_annoFine(annoFine_2);
						
						
					// periodo_3 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
						MPeriodo periodo_3 = new MPeriodo();
						int giornoInizio_3 = 1;
						int meseInizio_3 = 2;
						int annoInizio_3 = 2014;
						int giornoFine_3 = 31;
						int meseFine_3 = 2;
						int annoFine_3 = 2014;
						periodo_3.set_giornoInizio(giornoInizio_3);
						periodo_3.set_meseInizio(meseInizio_3);
						periodo_3.set_annoInizio(annoInizio_3);
						periodo_3.set_giornoFine(giornoFine_3);
						periodo_3.set_meseFine(meseFine_3);
						periodo_3.set_annoFine(annoFine_3);
						
						// periodo_4 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
						MPeriodo periodo_4 = new MPeriodo();
						int giornoInizio_4 = 1;
						int meseInizio_4 = 0;
						int annoInizio_4 = 2014;
						int giornoFine_4 = 31;
						int meseFine_4 = 2;
						int annoFine_4 = 2014;
						periodo_4.set_giornoInizio(giornoInizio_4);
						periodo_4.set_meseInizio(meseInizio_4);
						periodo_4.set_annoInizio(annoInizio_4);
						periodo_4.set_giornoFine(giornoFine_4);
						periodo_4.set_meseFine(meseFine_4);
						periodo_4.set_annoFine(annoFine_4);
				//fine periodi
		
		
		///test delle descrizioni
		
		//prezzi camere
				double x = 50.44;
				
				MPrezzoCamera p_singola_1 = new MPrezzoCamera();
				p_singola_1.set_prezzo(x);
				p_singola_1.set_periodo(periodo_1);
				
				MPrezzoCamera p_singola_2 = new MPrezzoCamera();
				p_singola_2.set_prezzo(x);
				p_singola_2.set_periodo(periodo_2);
				
				MPrezzoCamera p_singola_3 = new MPrezzoCamera();
				p_singola_3.set_prezzo(x);
				p_singola_3.set_periodo(periodo_3);
				
				MPrezzoCamera p_doppia_1 = new MPrezzoCamera();
				p_doppia_1.set_prezzo(60);
				p_doppia_1.set_periodo(periodo_1);
				
				MPrezzoCamera p_doppia_2 = new MPrezzoCamera();
				p_doppia_2.set_prezzo(70);
				p_doppia_2.set_periodo(periodo_2);
				
				MPrezzoCamera p_doppia_3 = new MPrezzoCamera();
				p_doppia_3.set_prezzo(80);
				p_doppia_3.set_periodo(periodo_3);
				
				MPrezzoCamera p_tripla_1 = new MPrezzoCamera();
				p_tripla_1.set_prezzo(90);
				p_tripla_1.set_periodo(periodo_1);
				
				MPrezzoCamera p_tripla_2 = new MPrezzoCamera();
				p_tripla_2.set_prezzo(500);
				p_tripla_2.set_periodo(periodo_2);
				
				MPrezzoCamera p_tripla_3 = new MPrezzoCamera();
				p_tripla_3.set_prezzo(1000);
				p_tripla_3.set_periodo(periodo_3);

				//inizializzazione map prezzi camere
				
				//singola
				ArrayList<MPrezzoCamera> prezzi_singola = new ArrayList<MPrezzoCamera>();
				prezzi_singola.add(p_singola_1);
				prezzi_singola.add(p_singola_2);
				prezzi_singola.add(p_singola_3);
				//doppia
				ArrayList<MPrezzoCamera> prezzi_doppia = new ArrayList<MPrezzoCamera>();
				prezzi_doppia.add(p_doppia_1);
				prezzi_doppia.add(p_doppia_2);
				prezzi_doppia.add(p_doppia_3);
				//tripla
				ArrayList<MPrezzoCamera> prezzi_tripla = new ArrayList<MPrezzoCamera>();
				prezzi_tripla.add(p_tripla_1);
				prezzi_tripla.add(p_tripla_2);
				prezzi_tripla.add(p_tripla_3);
				
				MDescrizioneCamera d1 = new MDescrizioneCamera();
				d1.set_tipologia("Singola");
				d1.set_prezziCamera(prezzi_singola);
						
				MDescrizioneCamera d2 = new MDescrizioneCamera();
				d2.set_tipologia("Doppia");
				d2.set_prezziCamera(prezzi_doppia);
				
				MDescrizioneCamera d3 = new MDescrizioneCamera();
				d3.set_tipologia("Tripla");
				d3.set_prezziCamera(prezzi_tripla);
				
				HashMap<String,MDescrizioneCamera> descrizioniCamere = new HashMap<String, MDescrizioneCamera>();
				
				descrizioniCamere.put("Singola", d1);
				descrizioniCamere.put("Doppia", d2);
				descrizioniCamere.put("Tripla", d3);
				
				MCatalogoCamere catalogo = MCatalogoCamere.getInstance();
				catalogo.set_descrizioniCamere(descrizioniCamere);
				HashMap<String, ArrayList<MPrezzoCamera>> appoggio = catalogo.getPrezziInPeriodoDaTipologia(periodo_4, "Tripla");
				for (Map.Entry<String, ArrayList<MPrezzoCamera>> entry : appoggio.entrySet()) {
				    if(entry.getKey()=="Tripla"){
				    	System.out.print(entry.getValue().get(2).get_prezzo());
				    }
				   
				}
			
	}

}
