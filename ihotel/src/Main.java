import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.iHotel.model.*;
import java.util.*;

public class Main{
	
	
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
					Calendar dataInizio_1 = Calendar.getInstance();
					dataInizio_1.setTimeInMillis(1388534400);
					Calendar dataFine_1 = Calendar.getInstance();
					dataFine_1.setTimeInMillis(139121279);
				MPeriodo periodo_1 = new MPeriodo();
				periodo_1.set_dataInizio(dataInizio_1);
				periodo_1.set_dataFine(dataFine_1);
			
			// periodo_2 - 1 Febbraio 2014 - 00:00.00 - 28 Febbraio 2014 - 23:59.59
					Calendar dataInizio_2 = Calendar.getInstance();
					dataInizio_2.setTimeInMillis(1391212800);
					Calendar dataFine_2 = Calendar.getInstance();
					dataFine_2.setTimeInMillis(1393631999);
				MPeriodo periodo_2 = new MPeriodo();
				periodo_2.set_dataInizio(dataInizio_2);
				periodo_2.set_dataFine(dataFine_2);
				
			// periodo_3 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
				Calendar dataInizio_3 = Calendar.getInstance();
				dataInizio_3.setTimeInMillis(1393632000);
				Calendar dataFine_3 = Calendar.getInstance();
				dataFine_3.setTimeInMillis(1396310399);
				MPeriodo periodo_3 = new MPeriodo();
				periodo_3.set_dataInizio(dataInizio_3);
				periodo_3.set_dataFine(dataFine_3);
		
		//fine periodi
		
		//Creo le camere
		
		// Camera 101
		MCamera camera_101 = new MCamera();
		camera_101.set_numero("101");
		camera_101.set_tipologia("Singola");
		
		// Camera 102
		MCamera camera_102 = new MCamera();
		camera_102.set_numero("102");
		camera_102.set_tipologia("Doppia");
		
		// Camera 103
		MCamera camera_103 = new MCamera();
		camera_103.set_numero("103");
		camera_103.set_tipologia("Tripla");
		
		//Creo gli stati per le camere
		
		// StatoCamera_101_Periodo_1
		MStatoCamera statoCamera_101_Periodo1 = new MStatoCamera();
		statoCamera_101_Periodo1.set_periodo(periodo_1);
		statoCamera_101_Periodo1.set_libera(true);
		// StatoCamera_102_Periodo_1
		MStatoCamera statoCamera_102_Periodo1 = new MStatoCamera();
		statoCamera_102_Periodo1.set_periodo(periodo_1);
		statoCamera_102_Periodo1.set_libera(true);
		// StatoCamera_103_Periodo_1
		MStatoCamera statoCamera_103_Periodo1 = new MStatoCamera();
		statoCamera_103_Periodo1.set_periodo(periodo_1);
		statoCamera_103_Periodo1.set_libera(false);
		
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
		
		//Creo le map di stati di camere
		
		// Stati occupazione Camera 101
		HashMap<MPeriodo,MStatoCamera> statiCamera_101 = new HashMap<MPeriodo,MStatoCamera>();
		statiCamera_101.put(periodo_1, statoCamera_101_Periodo1);
		statiCamera_101.put(periodo_2, statoCamera_101_Periodo2);
		statiCamera_101.put(periodo_3, statoCamera_101_Periodo3);
		
		// Stati occupazione Camera 102
		HashMap<MPeriodo,MStatoCamera> statiCamera_102 = new HashMap<MPeriodo,MStatoCamera>();
		statiCamera_102.put(periodo_1, statoCamera_102_Periodo1);
		statiCamera_102.put(periodo_2, statoCamera_102_Periodo2);
		statiCamera_102.put(periodo_3, statoCamera_102_Periodo3);
		
		// Stati occupazione Camera 103
		HashMap<MPeriodo,MStatoCamera> statiCamera_103 = new HashMap<MPeriodo,MStatoCamera>();
		statiCamera_103.put(periodo_1, statoCamera_103_Periodo1);
		statiCamera_103.put(periodo_2, statoCamera_103_Periodo2);
		statiCamera_103.put(periodo_3, statoCamera_103_Periodo3);
		
		// Aggiungo stati alle rispettive camere
		
		camera_101.set_statiCamera(statiCamera_101);
		camera_102.set_statiCamera(statiCamera_102);
		camera_103.set_statiCamera(statiCamera_103);
		
		// Mappa delle camere
		
		HashMap<String, MCamera> camere = new HashMap<String, MCamera>();
		camere.put(camera_101.get_numero(), camera_101);
		camere.put(camera_102.get_numero(), camera_102);
		camere.put(camera_103.get_numero(), camera_103);
		
		

		
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
		HashMap<MPeriodo, MPrezzoCamera> prezzi_singola = new HashMap<>();
		prezzi_singola.put(periodo_1, p_singola_1);
		prezzi_singola.put(periodo_2, p_singola_2);
		prezzi_singola.put(periodo_3, p_singola_3);
		//doppia
		HashMap<MPeriodo, MPrezzoCamera> prezzi_doppia = new HashMap<>();
		prezzi_doppia.put(periodo_1, p_doppia_1);
		prezzi_doppia.put(periodo_2, p_doppia_2);
		prezzi_doppia.put(periodo_3, p_doppia_3);
		//tripla
		HashMap<MPeriodo, MPrezzoCamera> prezzi_tripla = new HashMap<>();
		prezzi_tripla.put(periodo_1, p_tripla_1);
		prezzi_tripla.put(periodo_2, p_tripla_2);
		prezzi_tripla.put(periodo_3, p_tripla_3);
		
		
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
