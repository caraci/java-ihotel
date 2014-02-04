/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateIhotelData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().beginTransaction();
		try {
			com.iHotel.persistentModel.Albergo lcomiHotelpersistentModelAlbergo= (com.iHotel.persistentModel.Albergo)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Albergo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelAlbergo);
			
			com.iHotel.persistentModel.Camera lcomiHotelpersistentModelCamera= (com.iHotel.persistentModel.Camera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Camera").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelCamera);
			
			com.iHotel.persistentModel.CatalogoCamere lcomiHotelpersistentModelCatalogoCamere= (com.iHotel.persistentModel.CatalogoCamere)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.CatalogoCamere").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelCatalogoCamere);
			
			com.iHotel.persistentModel.DescrizioneCamera lcomiHotelpersistentModelDescrizioneCamera= (com.iHotel.persistentModel.DescrizioneCamera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.DescrizioneCamera").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelDescrizioneCamera);
			
			com.iHotel.persistentModel.ElementoPrenotazione lcomiHotelpersistentModelElementoPrenotazione= (com.iHotel.persistentModel.ElementoPrenotazione)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.ElementoPrenotazione").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelElementoPrenotazione);
			
			com.iHotel.persistentModel.Ospite lcomiHotelpersistentModelOspite= (com.iHotel.persistentModel.Ospite)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Ospite").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelOspite);
			
			com.iHotel.persistentModel.Periodo lcomiHotelpersistentModelPeriodo= (com.iHotel.persistentModel.Periodo)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Periodo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelPeriodo);
			
			com.iHotel.persistentModel.Prenotazione lcomiHotelpersistentModelPrenotazione= (com.iHotel.persistentModel.Prenotazione)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Prenotazione").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelPrenotazione);
			
			com.iHotel.persistentModel.PrezzoCamera lcomiHotelpersistentModelPrezzoCamera= (com.iHotel.persistentModel.PrezzoCamera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.PrezzoCamera").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelPrezzoCamera);
			
			com.iHotel.persistentModel.StatoCamera lcomiHotelpersistentModelStatoCamera= (com.iHotel.persistentModel.StatoCamera)com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.StatoCamera").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().update(lcomiHotelpersistentModelStatoCamera);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Albergo by AlbergoCriteria");
		com.iHotel.persistentModel.AlbergoCriteria lcomiHotelpersistentModelAlbergoCriteria = new com.iHotel.persistentModel.AlbergoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelAlbergoCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelAlbergoCriteria.uniqueAlbergo());
		
		System.out.println("Retrieving Camera by CameraCriteria");
		com.iHotel.persistentModel.CameraCriteria lcomiHotelpersistentModelCameraCriteria = new com.iHotel.persistentModel.CameraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelCameraCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelCameraCriteria.uniqueCamera());
		
		System.out.println("Retrieving CatalogoCamere by CatalogoCamereCriteria");
		com.iHotel.persistentModel.CatalogoCamereCriteria lcomiHotelpersistentModelCatalogoCamereCriteria = new com.iHotel.persistentModel.CatalogoCamereCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelCatalogoCamereCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelCatalogoCamereCriteria.uniqueCatalogoCamere());
		
		System.out.println("Retrieving DescrizioneCamera by DescrizioneCameraCriteria");
		com.iHotel.persistentModel.DescrizioneCameraCriteria lcomiHotelpersistentModelDescrizioneCameraCriteria = new com.iHotel.persistentModel.DescrizioneCameraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelDescrizioneCameraCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelDescrizioneCameraCriteria.uniqueDescrizioneCamera());
		
		System.out.println("Retrieving ElementoPrenotazione by ElementoPrenotazioneCriteria");
		com.iHotel.persistentModel.ElementoPrenotazioneCriteria lcomiHotelpersistentModelElementoPrenotazioneCriteria = new com.iHotel.persistentModel.ElementoPrenotazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelElementoPrenotazioneCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelElementoPrenotazioneCriteria.uniqueElementoPrenotazione());
		
		System.out.println("Retrieving Ospite by OspiteCriteria");
		com.iHotel.persistentModel.OspiteCriteria lcomiHotelpersistentModelOspiteCriteria = new com.iHotel.persistentModel.OspiteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelOspiteCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelOspiteCriteria.uniqueOspite());
		
		System.out.println("Retrieving Periodo by PeriodoCriteria");
		com.iHotel.persistentModel.PeriodoCriteria lcomiHotelpersistentModelPeriodoCriteria = new com.iHotel.persistentModel.PeriodoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelPeriodoCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelPeriodoCriteria.uniquePeriodo());
		
		System.out.println("Retrieving Prenotazione by PrenotazioneCriteria");
		com.iHotel.persistentModel.PrenotazioneCriteria lcomiHotelpersistentModelPrenotazioneCriteria = new com.iHotel.persistentModel.PrenotazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelPrenotazioneCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelPrenotazioneCriteria.uniquePrenotazione());
		
		System.out.println("Retrieving PrezzoCamera by PrezzoCameraCriteria");
		com.iHotel.persistentModel.PrezzoCameraCriteria lcomiHotelpersistentModelPrezzoCameraCriteria = new com.iHotel.persistentModel.PrezzoCameraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelPrezzoCameraCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelPrezzoCameraCriteria.uniquePrezzoCamera());
		
		System.out.println("Retrieving StatoCamera by StatoCameraCriteria");
		com.iHotel.persistentModel.StatoCameraCriteria lcomiHotelpersistentModelStatoCameraCriteria = new com.iHotel.persistentModel.StatoCameraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcomiHotelpersistentModelStatoCameraCriteria.ID.eq();
		System.out.println(lcomiHotelpersistentModelStatoCameraCriteria.uniqueStatoCamera());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateIhotelData retrieveAndUpdateIhotelData = new RetrieveAndUpdateIhotelData();
			try {
				retrieveAndUpdateIhotelData.retrieveAndUpdateTestData();
				//retrieveAndUpdateIhotelData.retrieveByCriteria();
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
