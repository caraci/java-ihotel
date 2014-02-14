import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.iHotel.model.*;


public class MainTestDivisionePeriodiFrog {

	public static void main(String[] args) {
				int oraInizio = 16;
				int oraFine = 10;
				int minutoInizio = 0;
				int minutoFine = 0;
		// periodo_1 - 1 Gennaio 2014 - 00:00.00 - 31 Gennaio 2014 - 23.59.59
				MPeriodo periodo_1 = new MPeriodo();
				int giornoInizio_1 = 1;
				int meseInizio_1 = 0;
				int annoInizio_1 = 2014;
				int giornoFine_1 = 31;
				int meseFine_1 = 0;
				int annoFine_1 = 2014;
				periodo_1.set_minutoInizio(minutoInizio);
				periodo_1.set_oraInizio(oraInizio);
				periodo_1.set_giornoInizio(giornoInizio_1);
				periodo_1.set_meseInizio(meseInizio_1);
				periodo_1.set_annoInizio(annoInizio_1);
				periodo_1.set_minutoFine(minutoFine);
				periodo_1.set_oraFine(oraFine);
				periodo_1.set_giornoFine(giornoFine_1);
				periodo_1.set_meseFine(meseFine_1);
				periodo_1.set_annoFine(annoFine_1);
				
				
			// periodo_2 - 1 Febbraio 2014 - 00:00.00 - 28 Febbraio 2014 - 23:59.59				
				MPeriodo periodo_2 = new MPeriodo();
				int giornoInizio_2 = 31;
				int meseInizio_2 = 0;
				int annoInizio_2 = 2014;
				int giornoFine_2 = 28;
				int meseFine_2 = 1;
				int annoFine_2 = 2014;
				periodo_2.set_minutoInizio(minutoInizio);
				periodo_2.set_oraInizio(oraInizio);
				periodo_2.set_giornoInizio(giornoInizio_2);
				periodo_2.set_meseInizio(meseInizio_2);
				periodo_2.set_annoInizio(annoInizio_2);
				periodo_2.set_minutoFine(minutoFine);
				periodo_2.set_oraFine(oraFine);
				periodo_2.set_giornoFine(giornoFine_2);
				periodo_2.set_meseFine(meseFine_2);
				periodo_2.set_annoFine(annoFine_2);
				
				
			// periodo_3 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
				MPeriodo periodo_3 = new MPeriodo();
				int giornoInizio_3 = 28;
				int meseInizio_3 = 1;
				int annoInizio_3 = 2014;
				int giornoFine_3 = 31;
				int meseFine_3 = 2;
				int annoFine_3 = 2014;
				periodo_3.set_minutoInizio(minutoInizio);
				periodo_3.set_oraInizio(oraInizio);
				periodo_3.set_giornoInizio(giornoInizio_3);
				periodo_3.set_meseInizio(meseInizio_3);
				periodo_3.set_annoInizio(annoInizio_3);
				periodo_3.set_minutoInizio(minutoFine);
				periodo_3.set_oraInizio(oraFine);
				periodo_3.set_giornoFine(giornoFine_3);
				periodo_3.set_meseFine(meseFine_3);
				periodo_3.set_annoFine(annoFine_3);
				
				// periodo_4 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
				MPeriodo periodo_4 = new MPeriodo();
				int giornoInizio_4 = 15;
				int meseInizio_4 = 1;
				int annoInizio_4 = 2014;
				int giornoFine_4 = 28;
				int meseFine_4 = 1;
				int annoFine_4 = 2014;
				periodo_4.set_minutoInizio(minutoInizio);
				periodo_4.set_oraInizio(oraInizio);
				periodo_4.set_giornoInizio(giornoInizio_4);
				periodo_4.set_meseInizio(meseInizio_4);
				periodo_4.set_annoInizio(annoInizio_4);
				periodo_4.set_minutoFine(minutoFine);
				periodo_4.set_oraFine(oraFine);
				periodo_4.set_giornoFine(giornoFine_4);
				periodo_4.set_meseFine(meseFine_4);
				periodo_4.set_annoFine(annoFine_4);
				
				
				// periodo_4 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
				MPeriodo periodo_5 = new MPeriodo();
				int giornoInizio_5 = 2;
				int meseInizio_5 = 1;
				int annoInizio_5 = 2014;
				int giornoFine_5 = 9;
				int meseFine_5 = 1;
				int annoFine_5 = 2014;
				periodo_5.set_giornoInizio(giornoInizio_5);
				periodo_5.set_meseInizio(meseInizio_5);
				periodo_5.set_annoInizio(annoInizio_5);
				periodo_5.set_giornoFine(giornoFine_5);
				periodo_5.set_meseFine(meseFine_5);
				periodo_5.set_annoFine(annoFine_5);
		//fine periodi
				
				
				//Creo le camere
				//Camere singole
						
				// Camera 101
				MCamera camera_101 = new MCamera();
				camera_101.set_numero("101");
				camera_101.set_tipologia("Singola");
				
				// Camera 102
				MCamera camera_102 = new MCamera();
				camera_102.set_numero("102");
				camera_102.set_tipologia("Singola");
				
				// Camera 103
				MCamera camera_103 = new MCamera();
				camera_103.set_numero("103");
				camera_103.set_tipologia("Singola");
				
				//Camere doppie
				// Camera 201
				MCamera camera_201 = new MCamera();
				camera_201.set_numero("201");
				camera_201.set_tipologia("Doppia");
				
				// Camera 202
				MCamera camera_202 = new MCamera();
				camera_202.set_numero("202");
				camera_202.set_tipologia("Doppia");
				
				// Camera 203
				MCamera camera_203 = new MCamera();
				camera_203.set_numero("203");
				camera_203.set_tipologia("Doppia");
				
				// Camere triple
				// Camera 301
				MCamera camera_301 = new MCamera();
				camera_301.set_numero("301");
				camera_301.set_tipologia("Tripla");
				
				// Camera 302
				MCamera camera_302 = new MCamera();
				camera_302.set_numero("302");
				camera_302.set_tipologia("Tripla");
				
				// Camera 303
				MCamera camera_303 = new MCamera();
				camera_303.set_numero("303");
				camera_303.set_tipologia("Tripla");
				
				//Creo gli stati per le camere
				
				ArrayList<MCamera> elencoCamere = new ArrayList<MCamera>();
				
				//stati camere singole periodo 1
				// StatoCamera_101_Periodo_1
				MStatoCamera statoCamera_101_Periodo1 = new MStatoCamera();
				statoCamera_101_Periodo1.set_periodo(periodo_1);
				statoCamera_101_Periodo1.set_libera(false);
				// StatoCamera_102_Periodo_1
				MStatoCamera statoCamera_102_Periodo1 = new MStatoCamera();
				statoCamera_102_Periodo1.set_periodo(periodo_1);
				statoCamera_102_Periodo1.set_libera(true);
				// StatoCamera_103_Periodo_1
				MStatoCamera statoCamera_103_Periodo1 = new MStatoCamera();
				statoCamera_103_Periodo1.set_periodo(periodo_1);
				statoCamera_103_Periodo1.set_libera(false);
				 
				//Stati camere doppie periodo 1
				// StatoCamera_201_Periodo_1
				MStatoCamera statoCamera_201_Periodo1 = new MStatoCamera();
				statoCamera_201_Periodo1.set_periodo(periodo_1);
				statoCamera_201_Periodo1.set_libera(true);
				// StatoCamera_202_Periodo_1
				MStatoCamera statoCamera_202_Periodo1 = new MStatoCamera();
				statoCamera_202_Periodo1.set_periodo(periodo_1);
				statoCamera_202_Periodo1.set_libera(true);
				// StatoCamera_203_Periodo_1
				MStatoCamera statoCamera_203_Periodo1 = new MStatoCamera();
				statoCamera_203_Periodo1.set_periodo(periodo_1);
				statoCamera_203_Periodo1.set_libera(false);
				
				//Stati camere triple periodo 1
				// StatoCamera_301_Periodo_1
				MStatoCamera statoCamera_301_Periodo1 = new MStatoCamera();
				statoCamera_301_Periodo1.set_periodo(periodo_1);
				statoCamera_301_Periodo1.set_libera(true);
				// StatoCamera_302_Periodo_1
				MStatoCamera statoCamera_302_Periodo1 = new MStatoCamera();
				statoCamera_302_Periodo1.set_periodo(periodo_1);
				statoCamera_302_Periodo1.set_libera(true);
				// StatoCamera_303_Periodo_1
				MStatoCamera statoCamera_303_Periodo1 = new MStatoCamera();
				statoCamera_303_Periodo1.set_periodo(periodo_1);
				statoCamera_303_Periodo1.set_libera(false);
				
				//Stati camere periodo 2
				//stati camere singole
				
				// StatoCamera_101_Periodo_2
				MStatoCamera statoCamera_101_Periodo2 = new MStatoCamera();
				statoCamera_101_Periodo2.set_periodo(periodo_2);
				statoCamera_101_Periodo2.set_libera(true);
				// StatoCamera_102_Periodo_2
				MStatoCamera statoCamera_102_Periodo2 = new MStatoCamera();
				statoCamera_102_Periodo2.set_periodo(periodo_2);
				statoCamera_102_Periodo2.set_libera(true);
				// StatoCamera_103_Periodo_2
				MStatoCamera statoCamera_103_Periodo2 = new MStatoCamera();
				statoCamera_103_Periodo2.set_periodo(periodo_2);
				statoCamera_103_Periodo2.set_libera(true);
				
				//Stati camere doppie
				// StatoCamera_201_Periodo_2
				MStatoCamera statoCamera_201_Periodo2 = new MStatoCamera();
				statoCamera_201_Periodo2.set_periodo(periodo_2);
				statoCamera_201_Periodo2.set_libera(false);
				// StatoCamera_202_Periodo_2
				MStatoCamera statoCamera_202_Periodo2 = new MStatoCamera();
				statoCamera_202_Periodo2.set_periodo(periodo_2);
				statoCamera_202_Periodo2.set_libera(true);
				// StatoCamera_203_Periodo_2
				MStatoCamera statoCamera_203_Periodo2 = new MStatoCamera();
				statoCamera_203_Periodo2.set_periodo(periodo_2);
				statoCamera_203_Periodo2.set_libera(true);
				
				//STati camere triple
				// StatoCamera_301_Periodo_2
				MStatoCamera statoCamera_301_Periodo2 = new MStatoCamera();
				statoCamera_301_Periodo2.set_periodo(periodo_2);
				statoCamera_301_Periodo2.set_libera(false);
				// StatoCamera_302_Periodo_2
				MStatoCamera statoCamera_302_Periodo2 = new MStatoCamera();
				statoCamera_302_Periodo2.set_periodo(periodo_2);
				statoCamera_302_Periodo2.set_libera(true);
				// StatoCamera_303_Periodo_2
				MStatoCamera statoCamera_303_Periodo2 = new MStatoCamera();
				statoCamera_303_Periodo2.set_periodo(periodo_2);
				statoCamera_303_Periodo2.set_libera(true);
				
				//stati camere periodo 3
				//Stati camere singole		
				// StatoCamera_101_Periodo_3
				MStatoCamera statoCamera_101_Periodo3 = new MStatoCamera();
				statoCamera_101_Periodo3.set_periodo(periodo_3);
				statoCamera_101_Periodo3.set_libera(false);
				// StatoCamera_102_Periodo_3
				MStatoCamera statoCamera_102_Periodo3 = new MStatoCamera();
				statoCamera_102_Periodo3.set_periodo(periodo_3);
				statoCamera_102_Periodo3.set_libera(false);
				// StatoCamera_103_Periodo_3
				MStatoCamera statoCamera_103_Periodo3 = new MStatoCamera();
				statoCamera_103_Periodo3.set_periodo(periodo_3);
				statoCamera_103_Periodo3.set_libera(true);
				
				//stati camere doppie
				// StatoCamera_201_Periodo_3
				MStatoCamera statoCamera_201_Periodo3 = new MStatoCamera();
				statoCamera_201_Periodo3.set_periodo(periodo_3);
				statoCamera_201_Periodo3.set_libera(true);
				// StatoCamera_202_Periodo_3
				MStatoCamera statoCamera_202_Periodo3 = new MStatoCamera();
				statoCamera_202_Periodo3.set_periodo(periodo_3);
				statoCamera_202_Periodo3.set_libera(false);
				// StatoCamera_203_Periodo_3
				MStatoCamera statoCamera_203_Periodo3 = new MStatoCamera();
				statoCamera_203_Periodo3.set_periodo(periodo_3);
				statoCamera_203_Periodo3.set_libera(true);
				
				//Stati camere triple
				// StatoCamera_301_Periodo_3
				MStatoCamera statoCamera_301_Periodo3 = new MStatoCamera();
				statoCamera_301_Periodo3.set_periodo(periodo_3);
				statoCamera_301_Periodo3.set_libera(true);
				// StatoCamera_302_Periodo_3
				MStatoCamera statoCamera_302_Periodo3 = new MStatoCamera();
				statoCamera_302_Periodo3.set_periodo(periodo_3);
				statoCamera_302_Periodo3.set_libera(false);
				// StatoCamera_103_Periodo_3
				MStatoCamera statoCamera_303_Periodo3 = new MStatoCamera();
				statoCamera_303_Periodo3.set_periodo(periodo_3);
				statoCamera_303_Periodo3.set_libera(true);

				//Creo le map di stati di camere
				//map di stati camere singole
				// Stati occupazione Camera 101
				LinkedList<MStatoCamera> statiCamera_101 = new LinkedList<MStatoCamera>();
				statiCamera_101.add(statoCamera_101_Periodo1);
				statiCamera_101.add(statoCamera_101_Periodo2);
				statiCamera_101.add(statoCamera_101_Periodo3);
				
				// Stati occupazione Camera 102
				LinkedList<MStatoCamera> statiCamera_102 = new LinkedList<MStatoCamera>();
				statiCamera_102.add(statoCamera_102_Periodo1);
				statiCamera_102.add(statoCamera_102_Periodo2);
				statiCamera_102.add(statoCamera_102_Periodo3);
				
				// Stati occupazione Camera 103
				LinkedList<MStatoCamera> statiCamera_103 = new LinkedList<MStatoCamera>();
				statiCamera_103.add(statoCamera_103_Periodo1);
				statiCamera_103.add(statoCamera_103_Periodo2);
				statiCamera_103.add(statoCamera_103_Periodo3);
				
				//map di stati camere doppie
				// Stati occupazione Camera 201
				LinkedList<MStatoCamera> statiCamera_201 = new LinkedList<MStatoCamera>();
				statiCamera_201.add(statoCamera_201_Periodo1);
				statiCamera_201.add(statoCamera_201_Periodo2);
				statiCamera_201.add(statoCamera_201_Periodo3);
				
				// Stati occupazione Camera 202
				LinkedList<MStatoCamera> statiCamera_202 = new LinkedList<MStatoCamera>();
				statiCamera_202.add(statoCamera_202_Periodo1);
				statiCamera_202.add(statoCamera_202_Periodo2);
				statiCamera_202.add(statoCamera_202_Periodo3);
				
				// Stati occupazione Camera 203
				LinkedList<MStatoCamera> statiCamera_203 = new LinkedList<MStatoCamera>();
				statiCamera_203.add(statoCamera_203_Periodo1);
				statiCamera_203.add(statoCamera_203_Periodo2);
				statiCamera_203.add(statoCamera_203_Periodo3);
				
				//map di stati camere triple
				// Stati occupazione Camera 201
				LinkedList<MStatoCamera> statiCamera_301 = new LinkedList<MStatoCamera>();
				statiCamera_301.add(statoCamera_301_Periodo1);
				statiCamera_301.add(statoCamera_301_Periodo2);
				statiCamera_301.add(statoCamera_301_Periodo3);
				
				// Stati occupazione Camera 201
				LinkedList<MStatoCamera> statiCamera_302 = new LinkedList<MStatoCamera>();
				statiCamera_302.add(statoCamera_302_Periodo1);
				statiCamera_302.add(statoCamera_302_Periodo2);
				statiCamera_302.add(statoCamera_302_Periodo3);
				
				// Stati occupazione Camera 201
				LinkedList<MStatoCamera> statiCamera_303 = new LinkedList<MStatoCamera>();
				statiCamera_303.add(statoCamera_303_Periodo1);
				statiCamera_303.add(statoCamera_303_Periodo2);
				statiCamera_303.add(statoCamera_303_Periodo3);
				
				// Aggiungo stati alle rispettive camere
				
				camera_101.set_statiCamera(statiCamera_101);
				camera_102.set_statiCamera(statiCamera_102);
				camera_103.set_statiCamera(statiCamera_103);
				camera_201.set_statiCamera(statiCamera_201);
				camera_202.set_statiCamera(statiCamera_202);
				camera_203.set_statiCamera(statiCamera_203);
				camera_301.set_statiCamera(statiCamera_301);
				camera_302.set_statiCamera(statiCamera_302);
				camera_303.set_statiCamera(statiCamera_303);	
				
				//prezzi camere
				
				
				MPrezzoCamera p_singola_1 = new MPrezzoCamera();
				p_singola_1.set_prezzo(50);
				p_singola_1.set_periodo(periodo_1);
				
				MPrezzoCamera p_singola_2 = new MPrezzoCamera();
				p_singola_2.set_prezzo(60);
				p_singola_2.set_periodo(periodo_2);
				
				MPrezzoCamera p_singola_3 = new MPrezzoCamera();
				p_singola_3.set_prezzo(70);
				p_singola_3.set_periodo(periodo_3);
				
				MPrezzoCamera p_doppia_1 = new MPrezzoCamera();
				p_doppia_1.set_prezzo(80);
				p_doppia_1.set_periodo(periodo_1);
				
				MPrezzoCamera p_doppia_2 = new MPrezzoCamera();
				p_doppia_2.set_prezzo(90);
				p_doppia_2.set_periodo(periodo_2);
				
				MPrezzoCamera p_doppia_3 = new MPrezzoCamera();
				p_doppia_3.set_prezzo(100);
				p_doppia_3.set_periodo(periodo_3);
				
				MPrezzoCamera p_tripla_1 = new MPrezzoCamera();
				p_tripla_1.set_prezzo(110);
				p_tripla_1.set_periodo(periodo_1);
				
				MPrezzoCamera p_tripla_2 = new MPrezzoCamera();
				p_tripla_2.set_prezzo(120);
				p_tripla_2.set_periodo(periodo_2);
				
				MPrezzoCamera p_tripla_3 = new MPrezzoCamera();
				p_tripla_3.set_prezzo(130);
				p_tripla_3.set_periodo(periodo_3);
				
				//fine prezzi camere
				
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
				
				//inizializzazione descrizioni camere
				MDescrizioneCamera d1 = new MDescrizioneCamera();
				d1.set_tipologia("Singola");
				d1.set_prezziCamera(prezzi_singola);
						
				MDescrizioneCamera d2 = new MDescrizioneCamera();
				d2.set_tipologia("Doppia");
				d2.set_prezziCamera(prezzi_doppia);
				
				MDescrizioneCamera d3 = new MDescrizioneCamera();
				d3.set_tipologia("Tripla");
				d3.set_prezziCamera(prezzi_tripla);
				
				
				//creo map descrizione camere
				HashMap<String,MDescrizioneCamera> descrizioniCamere = new HashMap<String,MDescrizioneCamera>();
				descrizioniCamere.put("Singola",d1);
				descrizioniCamere.put("Doppia", d2);
				descrizioniCamere.put("Tripla", d3);
				
				
				
				
				
				
				// assegno le descrizioni alle camere
				camera_101.set_descrizioneCamera(d1);
				camera_102.set_descrizioneCamera(d1);
				camera_103.set_descrizioneCamera(d1);
				camera_201.set_descrizioneCamera(d2);
				camera_202.set_descrizioneCamera(d2);
				camera_203.set_descrizioneCamera(d2);
				camera_301.set_descrizioneCamera(d3);
				camera_302.set_descrizioneCamera(d3);
				camera_303.set_descrizioneCamera(d3);
				
				// Creo CatalogoCamere
				MCatalogoCamere catalogoCamere = MCatalogoCamere.getInstance();	
				catalogoCamere.set_descrizioniCamere(descrizioniCamere);
				MAlbergo albergo = MAlbergo.getInstance();
				albergo.set_catalogoCamere(catalogoCamere);
				albergo.set_camere(elencoCamere);
				
				//creo una prenotazione 
				
				MPrenotazione prenotazione_camera = new MPrenotazione();
				prenotazione_camera.set_periodo(periodo_4);				
				prenotazione_camera.addElementoPrenotazione(camera_101);
				prenotazione_camera.addElementoPrenotazione(camera_202);
				prenotazione_camera.addElementoPrenotazione(camera_302);
				prenotazione_camera.set_completata(true); //da implementare, non è stato fatto
				/*for (Iterator<MStatoCamera> iterator = camera_101.get_statiCamera().iterator(); iterator.hasNext();) {	
					MStatoCamera stato = (MStatoCamera) iterator.next();
					System.out.print(stato.get_periodo().get_giornoInizio()+ " " +stato.get_periodo().get_giornoFine()+"\n");
				}*/
				//camera_101.occupaInPeriodo(periodo_4);
				//camera_101.get_statiCamera().get(0).get_periodo().set_giornoFine(3);
				//camera_202.occupaInPeriodo(periodo_5);
				
				
				
				
				//camera_202.occupaInPeriodo(periodo_4);
				//System.out.print(camera_101.get_statiCamera().get(0).get_periodo().get_meseInizio());
				System.out.print("\n \n stati camera 101 \n \n");
				for (Iterator<MStatoCamera> iterator = camera_101.get_statiCamera().iterator(); iterator.hasNext();) {	
					MStatoCamera stato = (MStatoCamera) iterator.next();
					System.out.print(stato.get_periodo().get_giornoInizio()+ " " +stato.get_periodo().get_meseInizio()+ " "+stato.get_periodo().get_annoInizio()+" " +stato.get_periodo().get_giornoFine()+ " "+stato.get_periodo().get_meseFine()+ " " + stato.get_periodo().get_annoFine() +" "+  stato.get_libera()+"\n");
				}
				
				System.out.print("\n \n stati camera 202 \n");
					for (Iterator<MStatoCamera> iterator = camera_202.get_statiCamera().iterator(); iterator.hasNext();) {	
					MStatoCamera stato = (MStatoCamera) iterator.next();
					System.out.print(stato.get_periodo().get_giornoInizio()+ " " +stato.get_periodo().get_meseInizio()+ " "+stato.get_periodo().get_annoInizio()+" " +stato.get_periodo().get_giornoFine()+ " "+stato.get_periodo().get_meseFine()+ " " + stato.get_periodo().get_annoFine() +" "+  stato.get_libera()+"\n");
				}
				
					System.out.print("\n \n stati camera 302 \n \n");
					for (Iterator<MStatoCamera> iterator = camera_302.get_statiCamera().iterator(); iterator.hasNext();) {	
					MStatoCamera stato = (MStatoCamera) iterator.next();
					System.out.print(stato.get_periodo().get_giornoInizio()+ " " +stato.get_periodo().get_meseInizio()+ " "+stato.get_periodo().get_annoInizio()+" " +stato.get_periodo().get_giornoFine()+ " "+stato.get_periodo().get_meseFine()+ " " + stato.get_periodo().get_annoFine() +" "+  stato.get_libera()+"\n");
				}
				System.out.print("\n \n stati camera 303 \n \n");
					for (Iterator<MStatoCamera> iterator = camera_303.get_statiCamera().iterator(); iterator.hasNext();) {	
					MStatoCamera stato = (MStatoCamera) iterator.next();
					System.out.print(stato.get_periodo().get_giornoInizio()+ " " +stato.get_periodo().get_meseInizio()+ " "+stato.get_periodo().get_annoInizio()+" " +stato.get_periodo().get_giornoFine()+ " "+stato.get_periodo().get_meseFine()+ " " + stato.get_periodo().get_annoFine() +" "+  stato.get_libera()+"\n");
				}

	}

}
