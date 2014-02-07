import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.iHotel.model.*;
import java.util.*;

public class MainPopolamentoDB{
	
	
	//metodi per inserire
	public static void aggiungiPeriodo(ObjectContainer db,MPeriodo periodo){
		db.store(periodo);		
	}
	
	public static void aggiungiDescrizione(ObjectContainer db,MDescrizioneCamera descrizione){
		db.store(descrizione);
	}
	
	public static void aggiungiPrezzo(ObjectContainer db,MPrezzoCamera prezzo){
		db.store(prezzo);
	}
	
	public static void aggiungiCamera(ObjectContainer db, MCamera camera){
		db.store(camera);
	}
	
	public static void aggiungiAlbergo(ObjectContainer db, MAlbergo albergo){
		db.store(albergo);
	}
	
	public static void aggiungiCatalogo(ObjectContainer db, MCatalogoCamere catalogo){
		db.store(catalogo);
	}
	
	public static void main(String[] args) {
		//Inizializzazioni 
		
		//periodi
		
		// periodo_1 - 1 Gennaio 2014 - 00:00.00 - 31 Gennaio 2014 - 23.59.59

				MPeriodo periodo_1 = new MPeriodo();
				int di_1 = 1;
				periodo_1.set_dataInizio(di_1);
				periodo_1.set_dataFine(df_1);
			
			// periodo_2 - 1 Febbraio 2014 - 00:00.00 - 28 Febbraio 2014 - 23:59.59
					long di_2 = 1391209200000L;
					long df_2 = 1393628399000L;
				MPeriodo periodo_2 = new MPeriodo();
				periodo_2.set_dataInizio(di_2);
				periodo_2.set_dataFine(df_2);
				
			// periodo_3 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
					long di_3 = 1393628400000L;
					long df_3 = 1396306799000L;
				MPeriodo periodo_3 = new MPeriodo();
				periodo_3.set_dataInizio(di_3);
				periodo_3.set_dataFine(df_3);
		
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
		statoCamera_201_Periodo1.set_libera(false);
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
		statoCamera_301_Periodo1.set_libera(false);
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
		statoCamera_101_Periodo2.set_libera(false);
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
		statoCamera_101_Periodo3.set_libera(true);
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
		// StatoCamera_102_Periodo_3
		MStatoCamera statoCamera_202_Periodo3 = new MStatoCamera();
		statoCamera_202_Periodo3.set_periodo(periodo_3);
		statoCamera_202_Periodo3.set_libera(false);
		// StatoCamera_103_Periodo_3
		MStatoCamera statoCamera_203_Periodo3 = new MStatoCamera();
		statoCamera_203_Periodo3.set_periodo(periodo_3);
		statoCamera_203_Periodo3.set_libera(true);
		
		//Stati camere triple
		// StatoCamera_101_Periodo_3
		MStatoCamera statoCamera_301_Periodo3 = new MStatoCamera();
		statoCamera_301_Periodo3.set_periodo(periodo_3);
		statoCamera_301_Periodo3.set_libera(true);
		// StatoCamera_102_Periodo_3
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
		statiCamera_301.add(statoCamera_302_Periodo1);
		statiCamera_301.add(statoCamera_302_Periodo2);
		statiCamera_301.add(statoCamera_302_Periodo3);
		
		// Stati occupazione Camera 201
		LinkedList<MStatoCamera> statiCamera_303 = new LinkedList<MStatoCamera>();
		statiCamera_301.add(statoCamera_303_Periodo1);
		statiCamera_301.add(statoCamera_303_Periodo2);
		statiCamera_301.add(statoCamera_303_Periodo3);
		
		// Aggiungo stati alle rispettive camere
		
		camera_101.set_statiCamera(statiCamera_101);
		camera_102.set_statiCamera(statiCamera_102);
		camera_103.set_statiCamera(statiCamera_103);
		
		// Mappa delle camere
		
		ArrayList<MCamera> camere = new ArrayList<MCamera>();
		camere.add(camera_101);
		camere.add(camera_102);
		camere.add(camera_103);
		camere.add(camera_201);
		camere.add(camera_202);
		camere.add(camera_203);
		camere.add(camera_301);
		camere.add(camera_302);
		camere.add(camera_303);
		
		
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
		p_doppia_1.set_prezzo(70);
		p_doppia_1.set_periodo(periodo_1);
		
		MPrezzoCamera p_doppia_2 = new MPrezzoCamera();
		p_doppia_2.set_prezzo(90);
		p_doppia_2.set_periodo(periodo_2);
		
		MPrezzoCamera p_doppia_3 = new MPrezzoCamera();
		p_doppia_3.set_prezzo(90);
		p_doppia_3.set_periodo(periodo_3);
		
		MPrezzoCamera p_tripla_1 = new MPrezzoCamera();
		p_tripla_1.set_prezzo(110);
		p_tripla_1.set_periodo(periodo_1);
		
		MPrezzoCamera p_tripla_2 = new MPrezzoCamera();
		p_tripla_2.set_prezzo(130);
		p_tripla_2.set_periodo(periodo_2);
		
		MPrezzoCamera p_tripla_3 = new MPrezzoCamera();
		p_tripla_3.set_prezzo(150);
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
		
		// Creo CatalogoCamere
		MCatalogoCamere catalogoCamere = new MCatalogoCamere();	
		catalogoCamere.set_descrizioniCamere(descrizioniCamere);
		// Creo Albergo e gli associo tutte le informazioni.
		
		MAlbergo albergo = new MAlbergo();
		albergo.set_eMail("info@hotelmAraviglioso.com");
		albergo.set_nome("Hotel mAraviglioso");
		albergo.set_PIVA("123456789ABCDEF");
		albergo.set_telefono("0746123456");
		albergo.set_camere(camere);
		albergo.set_catalogoCamere(catalogoCamere);
		
		// assegno l'albergo alle camere
		camera_101.set_albergo(albergo);
		camera_102.set_albergo(albergo);
		camera_103.set_albergo(albergo);
		camera_201.set_albergo(albergo);
		camera_202.set_albergo(albergo);
		camera_203.set_albergo(albergo);
		camera_301.set_albergo(albergo);
		camera_302.set_albergo(albergo);
		camera_303.set_albergo(albergo);
		
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbihotel");
		try {
			//aggiunta dei periodi
			aggiungiPeriodo(db,periodo_1);
			aggiungiPeriodo(db,periodo_2);
			aggiungiPeriodo(db,periodo_3);
			//aggiunta descrizioni
			aggiungiDescrizione(db,d1);
			aggiungiDescrizione(db,d2);
			aggiungiDescrizione(db,d3);
			//aggiunta prezzi
			aggiungiPrezzo(db,p_singola_1);
			aggiungiPrezzo(db,p_singola_2);
			aggiungiPrezzo(db,p_singola_3);
			aggiungiPrezzo(db,p_doppia_1);
			aggiungiPrezzo(db,p_doppia_2);
			aggiungiPrezzo(db,p_doppia_3);
			aggiungiPrezzo(db,p_tripla_1);
			aggiungiPrezzo(db,p_tripla_2);
			aggiungiPrezzo(db,p_tripla_3);
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
			//aggiunta albergo
			aggiungiAlbergo(db,albergo);
			//aggiunta catalogo
			aggiungiCatalogo(db,catalogoCamere);
			
		}
		
		finally {
		db.close();
			}
		

	}

}
