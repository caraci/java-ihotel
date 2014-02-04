/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteIhotelData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().beginTransaction();
		try {
			com.iHotel.persistentModel.Albergo lcomiHotelpersistentModelAlbergo= (com.iHotel.persistentModel.Albergo)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Albergo").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelAlbergo);
			
			com.iHotel.persistentModel.Camera lcomiHotelpersistentModelCamera= (com.iHotel.persistentModel.Camera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Camera").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelCamera);
			
			com.iHotel.persistentModel.CatalogoCamere lcomiHotelpersistentModelCatalogoCamere= (com.iHotel.persistentModel.CatalogoCamere)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.CatalogoCamere").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelCatalogoCamere);
			
			com.iHotel.persistentModel.DescrizioneCamera lcomiHotelpersistentModelDescrizioneCamera= (com.iHotel.persistentModel.DescrizioneCamera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.DescrizioneCamera").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelDescrizioneCamera);
			
			com.iHotel.persistentModel.ElementoPrenotazione lcomiHotelpersistentModelElementoPrenotazione= (com.iHotel.persistentModel.ElementoPrenotazione)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.ElementoPrenotazione").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelElementoPrenotazione);
			
			com.iHotel.persistentModel.Ospite lcomiHotelpersistentModelOspite= (com.iHotel.persistentModel.Ospite)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Ospite").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelOspite);
			
			com.iHotel.persistentModel.Periodo lcomiHotelpersistentModelPeriodo= (com.iHotel.persistentModel.Periodo)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Periodo").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelPeriodo);
			
			com.iHotel.persistentModel.Prenotazione lcomiHotelpersistentModelPrenotazione= (com.iHotel.persistentModel.Prenotazione)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Prenotazione").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelPrenotazione);
			
			com.iHotel.persistentModel.PrezzoCamera lcomiHotelpersistentModelPrezzoCamera= (com.iHotel.persistentModel.PrezzoCamera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.PrezzoCamera").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelPrezzoCamera);
			
			com.iHotel.persistentModel.StatoCamera lcomiHotelpersistentModelStatoCamera= (com.iHotel.persistentModel.StatoCamera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.StatoCamera").setMaxResults(1).uniqueResult();
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().delete(lcomiHotelpersistentModelStatoCamera);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			DeleteIhotelData deleteIhotelData = new DeleteIhotelData();
			try {
				deleteIhotelData.deleteTestData();
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
