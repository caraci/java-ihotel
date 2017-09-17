/**
 * 
 */
package com.iHotel.main;

import java.util.ArrayList;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Camera.StatoCamera;
import com.iHotel.model.Albergo.Camera.StatoCameraLibera;
import com.iHotel.model.Albergo.Camera.StatoCameraOccupata;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.PrezzoCamera;
import com.iHotel.model.Albergo.Cataloghi.PrezzoServizioInterno;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class MainPopolamentoDB {

	//metodi per inserire
	public static void aggiungiPeriodo(ObjectContainer db,Periodo periodo){
		db.store(periodo);		
	}
	
	public static void aggiungiDescrizioneCamera(ObjectContainer db,DescrizioneCamera descrizione){
		db.store(descrizione);
	}
	public static void aggiungiDescrizioneServizi(ObjectContainer db,DescrizioneServizioInterno descrizione){
		db.store(descrizione);
	}
	
	public static void aggiungiPrezzo(ObjectContainer db,PrezzoCamera prezzo){
		db.store(prezzo);
	}
	
	public static void aggiungiCamera(ObjectContainer db, Camera camera){
		db.store(camera);
	}
	
	public static void aggiungiAlbergo(ObjectContainer db, Albergo albergo){
		db.store(albergo);
	}
	
	public static void aggiungiCatalogo(ObjectContainer db, CatalogoCamere catalogo){
		db.store(catalogo);
	}
	
	public static void main(String[] args) {
		//Inizializzazioni 
		
		//periodi

		// periodo_1 - 1 Gennaio 2014 - 31 Gennaio 2014
				int giornoInizio_1 = 1;
				int meseInizio_1 = 0;
				int annoInizio_1 = 2014;
				int giornoFine_1 = 31;
				int meseFine_1 = 0;
				int annoFine_1 = 2014;
				
				Periodo periodo_1 = new Periodo(new Giorno(giornoInizio_1,meseInizio_1,annoInizio_1),new Giorno(giornoFine_1,meseFine_1,annoFine_1));
				
			// periodo_2 - 31 Gennaio 2014 - 28 Febbraio 2014	
				int giornoInizio_2 = 31;
				int meseInizio_2 = 0;
				int annoInizio_2 = 2014;
				int giornoFine_2 = 28;
				int meseFine_2 = 1;
				int annoFine_2 = 2014;
				
				Periodo periodo_2 = new Periodo(new Giorno(giornoInizio_2,meseInizio_2,annoInizio_2),new Giorno(giornoFine_2,meseFine_2,annoFine_2));
				
				
			// periodo_3 - 28 Febbraio 2014 - 31 Marzo 2014
				int giornoInizio_3 = 28;
				int meseInizio_3 = 1;
				int annoInizio_3 = 2014;
				int giornoFine_3 = 31;
				int meseFine_3 = 2;
				int annoFine_3 = 2014;

				Periodo periodo_3 = new Periodo(new Giorno(giornoInizio_3,meseInizio_3,annoInizio_3),new Giorno(giornoFine_3,meseFine_3,annoFine_3));
				
			// periodo_4 - 31 Gennaio 2014 - 31 Marzo 2014
				int giornoInizio_4 = 31;
				int meseInizio_4 = 0;
				int annoInizio_4 = 2014;
				int giornoFine_4 = 31;
				int meseFine_4 = 2;
				int annoFine_4 = 2014;

				Periodo periodo_4 = new Periodo(new Giorno(giornoInizio_4,meseInizio_4,annoInizio_4),new Giorno(giornoFine_4,meseFine_4,annoFine_4));
				
			// periodo_5 - 1 Gennaio 2014 - 31 Marzo 2014
				int giornoInizio_5 = 1;
				int meseInizio_5 = 0;
				int annoInizio_5 = 2014;
				int giornoFine_5 = 31;
				int meseFine_5 = 2;
				int annoFine_5 = 2014;

				Periodo periodo_5 = new Periodo(new Giorno(giornoInizio_5,meseInizio_5,annoInizio_5),new Giorno(giornoFine_5,meseFine_5,annoFine_5));
				
			// periodo_6 - 31 Marzo 2014 - 31 Maggio 2015
				int giornoInizio_6 = 31;
				int meseInizio_6 = 2;
				int annoInizio_6 = 2014;
				int giornoFine_6 = 31;
				int meseFine_6 = 5;
				int annoFine_6 = 2015;

				Periodo periodo_6 = new Periodo(new Giorno(giornoInizio_6,meseInizio_6,annoInizio_6),new Giorno(giornoFine_6,meseFine_6,annoFine_6));
				
			// periodo_6 - 31 Marzo 2014 - 31 Maggio 2015
				int giornoInizio_7 = 1;
				int meseInizio_7 = 6;
				int annoInizio_7 = 2015;
				int giornoFine_7 = 31;
				int meseFine_7 = 12;
				int annoFine_7 = 2040;

				Periodo periodo_7 = new Periodo(new Giorno(giornoInizio_7,meseInizio_7,annoInizio_7),new Giorno(giornoFine_7,meseFine_7,annoFine_7));
				
		//fine periodi
		
		//Creo le camere
		//Camere singole
				
		// Camera 101
		Camera camera_101 = new Camera();
		camera_101.set_numero("101");
		camera_101.set_tipologia("Singola");
		
		// Camera 102
		Camera camera_102 = new Camera();
		camera_102.set_numero("102");
		camera_102.set_tipologia("Singola");
		
		// Camera 103
		Camera camera_103 = new Camera();
		camera_103.set_numero("103");
		camera_103.set_tipologia("Singola");
		
		//Camere doppie
		// Camera 201
		Camera camera_201 = new Camera();
		camera_201.set_numero("201");
		camera_201.set_tipologia("Doppia");
		
		// Camera 202
		Camera camera_202 = new Camera();
		camera_202.set_numero("202");
		camera_202.set_tipologia("Doppia");
		
		// Camera 203
		Camera camera_203 = new Camera();
		camera_203.set_numero("203");
		camera_203.set_tipologia("Doppia");
		
		// Camere triple
		// Camera 301
		Camera camera_301 = new Camera();
		camera_301.set_numero("301");
		camera_301.set_tipologia("Tripla");
		
		// Camera 302
		Camera camera_302 = new Camera();
		camera_302.set_numero("302");
		camera_302.set_tipologia("Tripla");
		
		// Camera 303
		Camera camera_303 = new Camera();
		camera_303.set_numero("303");
		camera_303.set_tipologia("Tripla");
		
		
		/* --------------------------- stati camere SINGOLE ------------------------------- */
		
		// StatoCamera_101_Periodo_1
		StatoCamera statoCamera_101_Periodo1 = new StatoCameraLibera();
		statoCamera_101_Periodo1.set_periodo(periodo_1);
		// StatoCamera_102_Periodo_1
		StatoCamera statoCamera_102_Periodo1 = new StatoCameraLibera();
		statoCamera_102_Periodo1.set_periodo(periodo_1);
		// StatoCamera_103_Periodo_1
		StatoCamera statoCamera_103_Periodo1 = new StatoCameraLibera();
		statoCamera_103_Periodo1.set_periodo(periodo_1);
		
		// StatoCamera_101_Periodo_4
		StatoCamera statoCamera_101_Periodo4 = new StatoCameraOccupata();
		statoCamera_101_Periodo4.set_periodo(periodo_4);
		// StatoCamera_102_Periodo_4
		StatoCamera statoCamera_102_Periodo4 = new StatoCameraOccupata();
		statoCamera_102_Periodo4.set_periodo(periodo_4);
		// StatoCamera_103_Periodo_4
		StatoCamera statoCamera_103_Periodo4 = new StatoCameraOccupata();
		statoCamera_103_Periodo4.set_periodo(periodo_4);
		
		// StatoCamera_101_Periodo_6
		StatoCamera statoCamera_101_Periodo6 = new StatoCameraLibera();
		statoCamera_101_Periodo6.set_periodo(periodo_6);
		// StatoCamera_102_Periodo_6
		StatoCamera statoCamera_102_Periodo6 = new StatoCameraLibera();
		statoCamera_102_Periodo6.set_periodo(periodo_6);
		// StatoCamera_103_Periodo_6
		StatoCamera statoCamera_103_Periodo6 = new StatoCameraLibera();
		statoCamera_103_Periodo6.set_periodo(periodo_6);
		
		// StatoCamera_101_Periodo_7
		StatoCamera statoCamera_101_Periodo7 = new StatoCameraLibera();
		statoCamera_101_Periodo7.set_periodo(periodo_7);
		// StatoCamera_102_Periodo_7
		StatoCamera statoCamera_102_Periodo7 = new StatoCameraLibera();
		statoCamera_102_Periodo7.set_periodo(periodo_7);
		// StatoCamera_103_Periodo_7
		StatoCamera statoCamera_103_Periodo7 = new StatoCameraLibera();
		statoCamera_103_Periodo7.set_periodo(periodo_7);
		
		/* --------------------------- stati camere DOPPIE ------------------------------- */
		
		//Stati camere doppie periodo 5
		
		// StatoCamera_201_Periodo_5
		StatoCamera statoCamera_201_Periodo5 = new StatoCameraLibera();
		statoCamera_201_Periodo5.set_periodo(periodo_5);
		// StatoCamera_202_Periodo_5
		StatoCamera statoCamera_202_Periodo5 = new StatoCameraLibera();
		statoCamera_202_Periodo5.set_periodo(periodo_5);
		// StatoCamera_203_Periodo_5
		StatoCamera statoCamera_203_Periodo5 = new StatoCameraLibera();
		statoCamera_203_Periodo5.set_periodo(periodo_5);
		
		// StatoCamera_201_Periodo_6
		StatoCamera statoCamera_201_Periodo6 = new StatoCameraLibera();
		statoCamera_201_Periodo6.set_periodo(periodo_6);
		// StatoCamera_202_Periodo_6
		StatoCamera statoCamera_202_Periodo6 = new StatoCameraLibera();
		statoCamera_202_Periodo6.set_periodo(periodo_6);
		// StatoCamera_203_Periodo_6
		StatoCamera statoCamera_203_Periodo6 = new StatoCameraLibera();
		statoCamera_203_Periodo6.set_periodo(periodo_6);
		
		// StatoCamera_201_Periodo_7
		StatoCamera statoCamera_201_Periodo7 = new StatoCameraLibera();
		statoCamera_201_Periodo7.set_periodo(periodo_7);
		// StatoCamera_202_Periodo_7
		StatoCamera statoCamera_202_Periodo7 = new StatoCameraLibera();
		statoCamera_202_Periodo7.set_periodo(periodo_7);
		// StatoCamera_203_Periodo_7
		StatoCamera statoCamera_203_Periodo7 = new StatoCameraLibera();
		statoCamera_203_Periodo7.set_periodo(periodo_7);
		
		/* --------------------------- stati camere TRIPLE ------------------------------- */
		
		// StatoCamera_301_Periodo_1
		StatoCamera statoCamera_301_Periodo1 = new StatoCameraLibera();
		statoCamera_301_Periodo1.set_periodo(periodo_1);
		// StatoCamera_302_Periodo_1
		StatoCamera statoCamera_302_Periodo1 = new StatoCameraLibera();
		statoCamera_302_Periodo1.set_periodo(periodo_1);
		// StatoCamera_303_Periodo_1
		StatoCamera statoCamera_303_Periodo1 = new StatoCameraLibera();
		statoCamera_303_Periodo1.set_periodo(periodo_1);
		
		
		// StatoCamera_301_Periodo_2
		StatoCamera statoCamera_301_Periodo2 = new StatoCameraOccupata();
		statoCamera_301_Periodo2.set_periodo(periodo_2);
		// StatoCamera_302_Periodo_2
		StatoCamera statoCamera_302_Periodo2 = new StatoCameraOccupata();
		statoCamera_302_Periodo2.set_periodo(periodo_2);
		// StatoCamera_303_Periodo_2
		StatoCamera statoCamera_303_Periodo2 = new StatoCameraOccupata();
		statoCamera_303_Periodo2.set_periodo(periodo_2);
		
		// StatoCamera_301_Periodo_3
		StatoCamera statoCamera_301_Periodo3 = new StatoCameraLibera();
		statoCamera_301_Periodo3.set_periodo(periodo_3);
		// StatoCamera_302_Periodo_3
		StatoCamera statoCamera_302_Periodo3 = new StatoCameraLibera();
		statoCamera_302_Periodo3.set_periodo(periodo_3);
		// StatoCamera_303_Periodo_3
		StatoCamera statoCamera_303_Periodo3 = new StatoCameraLibera();
		statoCamera_303_Periodo3.set_periodo(periodo_3);
		
		// StatoCamera_301_Periodo_6
		StatoCamera statoCamera_301_Periodo6 = new StatoCameraLibera();
		statoCamera_301_Periodo6.set_periodo(periodo_6);
		// StatoCamera_302_Periodo_6
		StatoCamera statoCamera_302_Periodo6 = new StatoCameraLibera();
		statoCamera_302_Periodo6.set_periodo(periodo_6);
		// StatoCamera_303_Periodo_3
		StatoCamera statoCamera_303_Periodo6 = new StatoCameraLibera();
		statoCamera_303_Periodo6.set_periodo(periodo_6);
		
		// StatoCamera_301_Periodo_6
		StatoCamera statoCamera_301_Periodo7 = new StatoCameraLibera();
		statoCamera_301_Periodo7.set_periodo(periodo_7);
		// StatoCamera_302_Periodo_6
		StatoCamera statoCamera_302_Periodo7 = new StatoCameraLibera();
		statoCamera_302_Periodo7.set_periodo(periodo_7);
		// StatoCamera_303_Periodo_3
		StatoCamera statoCamera_303_Periodo7 = new StatoCameraLibera();
		statoCamera_303_Periodo7.set_periodo(periodo_7);

		//Creo le map di stati di camere
		//map di stati camere singole
		// Stati occupazione Camera 101
		LinkedList<StatoCamera> statiCamera_101 = new LinkedList<StatoCamera>();
		statiCamera_101.add(statoCamera_101_Periodo1);
		statiCamera_101.add(statoCamera_101_Periodo4);
		statiCamera_101.add(statoCamera_101_Periodo6);
		statiCamera_101.add(statoCamera_101_Periodo7);
		
		// Stati occupazione Camera 102
		LinkedList<StatoCamera> statiCamera_102 = new LinkedList<StatoCamera>();
		statiCamera_102.add(statoCamera_102_Periodo1);
		statiCamera_102.add(statoCamera_102_Periodo4);
		statiCamera_102.add(statoCamera_102_Periodo6);
		statiCamera_102.add(statoCamera_102_Periodo7);
		
		// Stati occupazione Camera 103
		LinkedList<StatoCamera> statiCamera_103 = new LinkedList<StatoCamera>();
		statiCamera_103.add(statoCamera_103_Periodo1);
		statiCamera_103.add(statoCamera_103_Periodo4);
		statiCamera_103.add(statoCamera_103_Periodo6);
		statiCamera_103.add(statoCamera_103_Periodo7);
		
		//map di stati camere doppie
		// Stati occupazione Camera 201
		LinkedList<StatoCamera> statiCamera_201 = new LinkedList<StatoCamera>();
		statiCamera_201.add(statoCamera_201_Periodo5);
		statiCamera_201.add(statoCamera_201_Periodo6);
		statiCamera_201.add(statoCamera_201_Periodo7);
		
		// Stati occupazione Camera 202
		LinkedList<StatoCamera> statiCamera_202 = new LinkedList<StatoCamera>();
		statiCamera_202.add(statoCamera_202_Periodo5);
		statiCamera_202.add(statoCamera_202_Periodo6);
		statiCamera_202.add(statoCamera_202_Periodo7);
		
		// Stati occupazione Camera 203
		LinkedList<StatoCamera> statiCamera_203 = new LinkedList<StatoCamera>();
		statiCamera_203.add(statoCamera_203_Periodo5);
		statiCamera_203.add(statoCamera_203_Periodo6);
		statiCamera_203.add(statoCamera_203_Periodo7);
		
		//map di stati camere triple
		// Stati occupazione Camera 201
		LinkedList<StatoCamera> statiCamera_301 = new LinkedList<StatoCamera>();
		statiCamera_301.add(statoCamera_301_Periodo1);
		statiCamera_301.add(statoCamera_301_Periodo2);
		statiCamera_301.add(statoCamera_301_Periodo3);
		statiCamera_301.add(statoCamera_301_Periodo6);
		statiCamera_301.add(statoCamera_301_Periodo7);
		
		// Stati occupazione Camera 201
		LinkedList<StatoCamera> statiCamera_302 = new LinkedList<StatoCamera>();
		statiCamera_302.add(statoCamera_302_Periodo1);
		statiCamera_302.add(statoCamera_302_Periodo2);
		statiCamera_302.add(statoCamera_302_Periodo3);
		statiCamera_302.add(statoCamera_302_Periodo6);
		statiCamera_302.add(statoCamera_302_Periodo7);
		
		// Stati occupazione Camera 201
		LinkedList<StatoCamera> statiCamera_303 = new LinkedList<StatoCamera>();
		statiCamera_303.add(statoCamera_303_Periodo1);
		statiCamera_303.add(statoCamera_303_Periodo2);
		statiCamera_303.add(statoCamera_303_Periodo3);
		statiCamera_303.add(statoCamera_303_Periodo6);
		statiCamera_303.add(statoCamera_303_Periodo7);
		
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
		String valuta = "Euro";
		
		Prezzo singola = new Prezzo();
		singola.set_quantita(10);
		singola.set_valuta(valuta);
		
		Prezzo doppia = new Prezzo();
		doppia.set_quantita(20);
		doppia.set_valuta(valuta);
		
		Prezzo tripla = new Prezzo();
		tripla.set_quantita(30);
		tripla.set_valuta(valuta);
		
		PrezzoCamera p_singola_1 = new PrezzoCamera();
		p_singola_1.set_prezzo(singola);
		p_singola_1.set_periodo(periodo_1);
		
		PrezzoCamera p_singola_2 = new PrezzoCamera();
		p_singola_2.set_prezzo(singola);
		p_singola_2.set_periodo(periodo_2);
		
		PrezzoCamera p_singola_3 = new PrezzoCamera();
		p_singola_3.set_prezzo(singola);
		p_singola_3.set_periodo(periodo_3);
		
		PrezzoCamera p_singola_6 = new PrezzoCamera();
		p_singola_6.set_prezzo(singola);
		p_singola_6.set_periodo(periodo_6);
		
		PrezzoCamera p_singola_7 = new PrezzoCamera();
		p_singola_7.set_prezzo(singola);
		p_singola_7.set_periodo(periodo_7);
		
		PrezzoCamera p_doppia_1 = new PrezzoCamera();
		p_doppia_1.set_prezzo(doppia);
		p_doppia_1.set_periodo(periodo_1);
		
		PrezzoCamera p_doppia_2 = new PrezzoCamera();
		p_doppia_2.set_prezzo(doppia);
		p_doppia_2.set_periodo(periodo_2);
		
		PrezzoCamera p_doppia_3 = new PrezzoCamera();
		p_doppia_3.set_prezzo(doppia);
		p_doppia_3.set_periodo(periodo_3);
		
		PrezzoCamera p_doppia_6 = new PrezzoCamera();
		p_doppia_6.set_prezzo(doppia);
		p_doppia_6.set_periodo(periodo_6);
		
		PrezzoCamera p_doppia_7 = new PrezzoCamera();
		p_doppia_7.set_prezzo(doppia);
		p_doppia_7.set_periodo(periodo_7);
		
		PrezzoCamera p_tripla_1 = new PrezzoCamera();
		p_tripla_1.set_prezzo(tripla);
		p_tripla_1.set_periodo(periodo_1);
		
		PrezzoCamera p_tripla_2 = new PrezzoCamera();
		p_tripla_2.set_prezzo(tripla);
		p_tripla_2.set_periodo(periodo_2);
		
		PrezzoCamera p_tripla_3 = new PrezzoCamera();
		p_tripla_3.set_prezzo(tripla);
		p_tripla_3.set_periodo(periodo_3);
		
		PrezzoCamera p_tripla_6 = new PrezzoCamera();
		p_tripla_6.set_prezzo(tripla);
		p_tripla_6.set_periodo(periodo_6);
		
		PrezzoCamera p_tripla_7 = new PrezzoCamera();
		p_tripla_7.set_prezzo(tripla);
		p_tripla_7.set_periodo(periodo_7);
		
		//fine prezzi camere
		
		//inizializzazione map prezzi camere
		
		//singola
		ArrayList<PrezzoCamera> prezzi_singola = new ArrayList<PrezzoCamera>();
		prezzi_singola.add(p_singola_1);
		prezzi_singola.add(p_singola_2);
		prezzi_singola.add(p_singola_3);
		prezzi_singola.add(p_singola_6);
		prezzi_singola.add(p_singola_7);
		//doppia
		ArrayList<PrezzoCamera> prezzi_doppia = new ArrayList<PrezzoCamera>();
		prezzi_doppia.add(p_doppia_1);
		prezzi_doppia.add(p_doppia_2);
		prezzi_doppia.add(p_doppia_3);
		prezzi_doppia.add(p_doppia_6);
		prezzi_doppia.add(p_doppia_7);
		//tripla
		ArrayList<PrezzoCamera> prezzi_tripla = new ArrayList<PrezzoCamera>();
		prezzi_tripla.add(p_tripla_1);
		prezzi_tripla.add(p_tripla_2);
		prezzi_tripla.add(p_tripla_3);
		prezzi_tripla.add(p_tripla_6);
		prezzi_tripla.add(p_tripla_7);
		
		//inizializzazione descrizioni camere
		DescrizioneCamera d1 = new DescrizioneCamera();
		d1.set_tipologia("Singola");
		d1.set_prezziCamera(prezzi_singola);
				
		DescrizioneCamera d2 = new DescrizioneCamera();
		d2.set_tipologia("Doppia");
		d2.set_prezziCamera(prezzi_doppia);
		
		DescrizioneCamera d3 = new DescrizioneCamera();
		d3.set_tipologia("Tripla");
		d3.set_prezziCamera(prezzi_tripla);
		
		// Catalogo Servizi Interni
		
		// CHAMPAGNE
		Prezzo pChampagne = new Prezzo();
		pChampagne.set_quantita(35);
		// Prezzi Champagne
		PrezzoServizioInterno psiChampagne_5 = new PrezzoServizioInterno();
		psiChampagne_5.set_periodo(periodo_5);
		psiChampagne_5.set_prezzo(pChampagne);
		
		PrezzoServizioInterno psiChampagne_6 = new PrezzoServizioInterno();
		psiChampagne_6.set_periodo(periodo_6);
		psiChampagne_6.set_prezzo(pChampagne);
		
		PrezzoServizioInterno psiChampagne_7 = new PrezzoServizioInterno();
		psiChampagne_7.set_periodo(periodo_7);
		psiChampagne_7.set_prezzo(pChampagne);
		// Lista Prezzi Champagne
		LinkedList<PrezzoServizioInterno> prezziChampagne = new LinkedList<PrezzoServizioInterno>();
		prezziChampagne.add(psiChampagne_5);
		prezziChampagne.add(psiChampagne_6);
		prezziChampagne.add(psiChampagne_7);
		
		// Descrizione Servizio Interno Champagne
		
		DescrizioneServizioInterno dsChampagne = new DescrizioneServizioInterno();
		dsChampagne.set_codice("A012");
		dsChampagne.set_descrizione("Un'ottimo champagne di annata, per una notte speciale.");
		dsChampagne.set_nome("Champagne in camera");
		dsChampagne.set_prezziServizio(prezziChampagne);
		
		// ROSE
		Prezzo pRose = new Prezzo();
		pRose.set_quantita(15);
		// Prezzi Rose
		PrezzoServizioInterno psiRose_5 = new PrezzoServizioInterno();
		psiRose_5.set_periodo(periodo_5);
		psiRose_5.set_prezzo(pRose);
		
		PrezzoServizioInterno psiRose_6 = new PrezzoServizioInterno();
		psiRose_6.set_periodo(periodo_6);
		psiRose_6.set_prezzo(pRose);
		
		PrezzoServizioInterno psiRose_7 = new PrezzoServizioInterno();
		psiRose_7.set_periodo(periodo_7);
		psiRose_7.set_prezzo(pRose);
		// Lista Prezzi Rose
		LinkedList<PrezzoServizioInterno> prezziRose = new LinkedList<PrezzoServizioInterno>();
		prezziRose.add(psiRose_5);
		prezziRose.add(psiRose_6);
		prezziRose.add(psiRose_7);
		
		// Descrizione Servizio Interno Rose
		
		DescrizioneServizioInterno dsRose = new DescrizioneServizioInterno();
		dsRose.set_codice("A013");
		dsRose.set_descrizione("Fiori maravigliosi.");
		dsRose.set_nome("Fiori in camera");
		dsRose.set_prezziServizio(prezziRose);
		
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "./configs/dbihotel");
		try {
		
			//aggiunta dei periodi
			aggiungiPeriodo(db,periodo_1);
			aggiungiPeriodo(db,periodo_2);
			aggiungiPeriodo(db,periodo_3);
			aggiungiPeriodo(db,periodo_4);
			aggiungiPeriodo(db,periodo_5);
			aggiungiPeriodo(db,periodo_6);
			aggiungiPeriodo(db,periodo_7);
			
			//aggiunta prezzi
			aggiungiPrezzo(db,p_singola_1);
			aggiungiPrezzo(db,p_singola_2);
			aggiungiPrezzo(db,p_singola_3);
			aggiungiPrezzo(db,p_singola_6);
			aggiungiPrezzo(db,p_singola_7);
			aggiungiPrezzo(db,p_doppia_1);
			aggiungiPrezzo(db,p_doppia_2);
			aggiungiPrezzo(db,p_doppia_3);
			aggiungiPrezzo(db,p_doppia_6);
			aggiungiPrezzo(db,p_doppia_7);
			aggiungiPrezzo(db,p_tripla_1);
			aggiungiPrezzo(db,p_tripla_2);
			aggiungiPrezzo(db,p_tripla_3);
			aggiungiPrezzo(db,p_tripla_6);
			aggiungiPrezzo(db,p_tripla_7);
			
			//aggiunta descrizioni camere
			aggiungiDescrizioneCamera(db,d1);
			aggiungiDescrizioneCamera(db,d2);
			aggiungiDescrizioneCamera(db,d3);
			
			//aggiunta servizi interni
			aggiungiDescrizioneServizi(db,dsChampagne);
			aggiungiDescrizioneServizi(db,dsRose);
			
			//aggiunta camere
			aggiungiCamera(db,camera_101);
			aggiungiCamera(db,camera_102);
			aggiungiCamera(db,camera_103);
			aggiungiCamera(db,camera_201);
			aggiungiCamera(db,camera_202);
			aggiungiCamera(db,camera_203);
			aggiungiCamera(db,camera_301);
			aggiungiCamera(db,camera_302);
			aggiungiCamera(db,camera_303);
			
		} finally {
		db.close();
		}
	}
}
