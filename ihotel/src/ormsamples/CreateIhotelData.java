/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateIhotelData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().beginTransaction();
		try {
			com.iHotel.persistentModel.Albergo lcomiHotelpersistentModelAlbergo = new com.iHotel.persistentModel.Albergo();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelAlbergo);
			
			com.iHotel.persistentModel.Camera lcomiHotelpersistentModelCamera = new com.iHotel.persistentModel.Camera();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelCamera);
			
			com.iHotel.persistentModel.CatalogoCamere lcomiHotelpersistentModelCatalogoCamere = new com.iHotel.persistentModel.CatalogoCamere();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelCatalogoCamere);
			
			com.iHotel.persistentModel.DescrizioneCamera lcomiHotelpersistentModelDescrizioneCamera = new com.iHotel.persistentModel.DescrizioneCamera();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelDescrizioneCamera);
			
			com.iHotel.persistentModel.ElementoPrenotazione lcomiHotelpersistentModelElementoPrenotazione = new com.iHotel.persistentModel.ElementoPrenotazione();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelElementoPrenotazione);
			
			com.iHotel.persistentModel.Ospite lcomiHotelpersistentModelOspite = new com.iHotel.persistentModel.Ospite();			// Initialize the properties of the persistent object here
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelOspite);
			
			com.iHotel.persistentModel.Periodo lcomiHotelpersistentModelPeriodo = new com.iHotel.persistentModel.Periodo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _dataFine, _dataInizio
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelPeriodo);
			
			com.iHotel.persistentModel.Prenotazione lcomiHotelpersistentModelPrenotazione = new com.iHotel.persistentModel.Prenotazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _completa
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelPrenotazione);
			
			com.iHotel.persistentModel.PrezzoCamera lcomiHotelpersistentModelPrezzoCamera = new com.iHotel.persistentModel.PrezzoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _prezzo
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelPrezzoCamera);
			
			com.iHotel.persistentModel.StatoCamera lcomiHotelpersistentModelStatoCamera = new com.iHotel.persistentModel.StatoCamera();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _libera
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().save(lcomiHotelpersistentModelStatoCamera);
			
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
