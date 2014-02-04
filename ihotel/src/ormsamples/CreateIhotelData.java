/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;

import com.iHotel.persistentModel.*;

import java.util.*;

public class CreateIhotelData {
	@SuppressWarnings("deprecation")
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().beginTransaction();
		try {
			
			//  Inizializzazioni	
			com.iHotel.persistentModel.Albergo albergo = new com.iHotel.persistentModel.Albergo();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.PrezzoCamera prezzoCamera_1_singola = new com.iHotel.persistentModel.PrezzoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _prezzo
			com.iHotel.persistentModel.PrezzoCamera prezzoCamera_2_singola = new com.iHotel.persistentModel.PrezzoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _prezzo
			com.iHotel.persistentModel.PrezzoCamera prezzoCamera_1_doppia = new com.iHotel.persistentModel.PrezzoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _prezzo
			com.iHotel.persistentModel.PrezzoCamera prezzoCamera_2_doppia = new com.iHotel.persistentModel.PrezzoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _prezzo
			com.iHotel.persistentModel.StatoCamera statoCamera_1_101 = new com.iHotel.persistentModel.StatoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _libera
			com.iHotel.persistentModel.StatoCamera statoCamera_2_101 = new com.iHotel.persistentModel.StatoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _libera
			com.iHotel.persistentModel.StatoCamera statoCamera_1_102 = new com.iHotel.persistentModel.StatoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _libera
			com.iHotel.persistentModel.StatoCamera statoCamera_2_102 = new com.iHotel.persistentModel.StatoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _libera
			com.iHotel.persistentModel.Camera camera_101 = new com.iHotel.persistentModel.Camera();			// TODO Initialize the properties of the persistent object here
			com.iHotel.persistentModel.Camera camera_102 = new com.iHotel.persistentModel.Camera();			// TODO Initialize the properties of the persistent object here
			com.iHotel.persistentModel.CatalogoCamere catalogoCamere = new com.iHotel.persistentModel.CatalogoCamere();			// TODO Initialize the properties of the persistent object here			
			com.iHotel.persistentModel.DescrizioneCamera descrizioneCamera_singola = new com.iHotel.persistentModel.DescrizioneCamera();			// TODO Initialize the properties of the persistent object here
			com.iHotel.persistentModel.DescrizioneCamera descrizioneCamera_doppia = new com.iHotel.persistentModel.DescrizioneCamera();			// TODO Initialize the properties of the persistent object here
			// Fine inizializzazioni
			
			// Periodo //
			
			// Periodo 1
			Periodo p_1 = new Periodo();
				// Data inizio
				// 1/1/2014 - 00.00.00
				Date di_1 = new Date();
				di_1.setTime(1388534400);
				
				// Data fine
				// 31/1/2014 - 23.59.59
				Date df_1 = new Date();
				df_1.setTime(1391212799);
			
				p_1.set_dataInizio(di_1);
				p_1.set_dataFine(df_1);
				
			// Periodo 2
			Periodo p_2 = new Periodo();
				// Data inizio
				Date di_2 = new Date();
				// 1/2/2014 - 00.00.00
				di_2.setTime(1391212800);
				// Data fine
				Date df_2 = new Date();
				// 28/2/2014 - 23.59.59
				df_2.setTime(1393631999);
			
				p_2.set_dataInizio(di_2);
				p_2.set_dataFine(df_2);
				
			// Fine Periodo //
							
			albergo.setNome("Albergo mAraviglioso");	
					
			/*
			com.iHotel.persistentModel.ElementoPrenotazione lcomiHotelpersistentModelElementoPrenotazione = new com.iHotel.persistentModel.ElementoPrenotazione();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelElementoPrenotazione);
			
			com.iHotel.persistentModel.Ospite lcomiHotelpersistentModelOspite = new com.iHotel.persistentModel.Ospite();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelOspite);
			
			com.iHotel.persistentModel.Periodo lcomiHotelpersistentModelPeriodo = new com.iHotel.persistentModel.Periodo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _dataFine, _dataInizio
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelPeriodo);
			
			com.iHotel.persistentModel.Prenotazione lcomiHotelpersistentModelPrenotazione = new com.iHotel.persistentModel.Prenotazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _completa
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelPrenotazione);
			*/
			
			// Prezzi camera singola - Periodo 1
			prezzoCamera_1_singola.set_periodo(p_1);
			prezzoCamera_1_singola.set_prezzo(50);
			
			// Prezzi Camera singola - Periodo 2
			prezzoCamera_2_singola.set_periodo(p_2);
			prezzoCamera_2_singola.set_prezzo(65);	
			
			// Set dei prezzi camera singola
			HashSet<PrezzoCamera> prezziCamera_singola = new HashSet<PrezzoCamera>();
			prezziCamera_singola.add(prezzoCamera_1_singola);
			prezziCamera_singola.add(prezzoCamera_2_singola);
			
			// Prezzi camera doppia - Periodo 1
			prezzoCamera_1_doppia.set_periodo(p_1);
			prezzoCamera_1_doppia.set_prezzo(80);
			
			// Prezzi Camera doppia - Periodo 2
			prezzoCamera_2_doppia.set_periodo(p_2);
			prezzoCamera_2_doppia.set_prezzo(100);	
			
			// Set dei prezzi camera doppia
			HashSet<PrezzoCamera> prezziCamera_doppia = new HashSet<PrezzoCamera>();
			prezziCamera_doppia.add(prezzoCamera_1_doppia);
			prezziCamera_doppia.add(prezzoCamera_2_doppia);
			
			// Stato camera 101 - Periodo 1		
			statoCamera_1_101.set_camera(camera_101);
			statoCamera_1_101.set_libera(false);
			statoCamera_1_101.set_periodo(p_1);
		
			// Stato camera 101 - Periodo 2
			statoCamera_2_101.set_camera(camera_101);
			statoCamera_2_101.set_libera(true);
			statoCamera_2_101.set_periodo(p_2);
			
			// Set degli stati camera 101
			HashSet<StatoCamera> statiCamera_101 = new HashSet<StatoCamera>();
			statiCamera_101.add(statoCamera_1_101);
			statiCamera_101.add(statoCamera_2_101);
			
			// Stato camera 102 - Periodo 1
			statoCamera_1_102.set_camera(camera_102);
			statoCamera_1_102.set_libera(false);
			statoCamera_1_102.set_periodo(p_1);
			
			// Stato camera 102 - Periodo 2
			statoCamera_2_102.set_camera(camera_102);
			statoCamera_2_102.set_libera(true);
			statoCamera_2_102.set_periodo(p_2);
			
			// Set degli stati camera 102
			HashSet<StatoCamera> statiCamera_102 = new HashSet<StatoCamera>();
			statiCamera_102.add(statoCamera_1_102);
			statiCamera_102.add(statoCamera_2_102);
				
			// Camera 101
			camera_101.set_albergo(albergo);
			camera_101.set_numero("101");
			camera_101.set_tipologia("Singola");
			camera_101.set_statiCamera(statiCamera_101);
						
			// Camera 102
			camera_102.set_albergo(albergo);
			camera_102.set_numero("102");
			camera_102.set_tipologia("Doppia");
			camera_102.set_statiCamera(statiCamera_102);
	
			// Descrizione Singola
			descrizioneCamera_singola.set_tipologia("Singola");
			descrizioneCamera_singola.set_prezziCamera(prezziCamera_singola);
			descrizioneCamera_singola.set_catalogoCamere(catalogoCamere);
			
			// Descrizione Doppia
			descrizioneCamera_doppia.set_tipologia("Doppia");
			descrizioneCamera_doppia.set_prezziCamera(prezziCamera_doppia);
			descrizioneCamera_doppia.set_catalogoCamere(catalogoCamere);
			
			// Set dei descrittori delle camere
			HashSet<DescrizioneCamera> descrizioniCamere = new HashSet<DescrizioneCamera>();
			descrizioniCamere.add(descrizioneCamera_singola);
			descrizioniCamere.add(descrizioneCamera_doppia);
			
			// Salvataggio
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(albergo);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(prezzoCamera_1_singola);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(prezzoCamera_2_singola);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(prezzoCamera_1_doppia);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(prezzoCamera_2_doppia);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(statoCamera_1_101);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(statoCamera_2_101);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(statoCamera_1_102);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(statoCamera_2_102);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(camera_101);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(camera_102);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(catalogoCamere);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(descrizioneCamera_singola);
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(descrizioneCamera_doppia);
			// Fine Salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateIhotelData createIhotelData = new CreateIhotelData();
			try {
				createIhotelData.createTestData();
			}
			finally {
				com.iHotel.persistentModel.IhotelPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
