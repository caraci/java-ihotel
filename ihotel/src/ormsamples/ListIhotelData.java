/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListIhotelData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Albergo...");
		java.util.List lAlbergoList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Albergo").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.Albergo[] lcomiHotelpersistentModelAlbergos = (com.iHotel.persistentModel.Albergo[]) lAlbergoList.toArray(new com.iHotel.persistentModel.Albergo[lAlbergoList.size()]);
		int length = Math.min(lcomiHotelpersistentModelAlbergos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelAlbergos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Camera...");
		java.util.List lCameraList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Camera").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.Camera[] lcomiHotelpersistentModelCameras = (com.iHotel.persistentModel.Camera[]) lCameraList.toArray(new com.iHotel.persistentModel.Camera[lCameraList.size()]);
		length = Math.min(lcomiHotelpersistentModelCameras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelCameras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing CatalogoCamere...");
		java.util.List lCatalogoCamereList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.CatalogoCamere").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.CatalogoCamere[] lcomiHotelpersistentModelCatalogoCameres = (com.iHotel.persistentModel.CatalogoCamere[]) lCatalogoCamereList.toArray(new com.iHotel.persistentModel.CatalogoCamere[lCatalogoCamereList.size()]);
		length = Math.min(lcomiHotelpersistentModelCatalogoCameres.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelCatalogoCameres[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing DescrizioneCamera...");
		java.util.List lDescrizioneCameraList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.DescrizioneCamera").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.DescrizioneCamera[] lcomiHotelpersistentModelDescrizioneCameras = (com.iHotel.persistentModel.DescrizioneCamera[]) lDescrizioneCameraList.toArray(new com.iHotel.persistentModel.DescrizioneCamera[lDescrizioneCameraList.size()]);
		length = Math.min(lcomiHotelpersistentModelDescrizioneCameras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelDescrizioneCameras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ElementoPrenotazione...");
		java.util.List lElementoPrenotazioneList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.ElementoPrenotazione").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.ElementoPrenotazione[] lcomiHotelpersistentModelElementoPrenotaziones = (com.iHotel.persistentModel.ElementoPrenotazione[]) lElementoPrenotazioneList.toArray(new com.iHotel.persistentModel.ElementoPrenotazione[lElementoPrenotazioneList.size()]);
		length = Math.min(lcomiHotelpersistentModelElementoPrenotaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelElementoPrenotaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ospite...");
		java.util.List lOspiteList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Ospite").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.Ospite[] lcomiHotelpersistentModelOspites = (com.iHotel.persistentModel.Ospite[]) lOspiteList.toArray(new com.iHotel.persistentModel.Ospite[lOspiteList.size()]);
		length = Math.min(lcomiHotelpersistentModelOspites.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelOspites[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Periodo...");
		java.util.List lPeriodoList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Periodo").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.Periodo[] lcomiHotelpersistentModelPeriodos = (com.iHotel.persistentModel.Periodo[]) lPeriodoList.toArray(new com.iHotel.persistentModel.Periodo[lPeriodoList.size()]);
		length = Math.min(lcomiHotelpersistentModelPeriodos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelPeriodos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Prenotazione...");
		java.util.List lPrenotazioneList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.Prenotazione").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.Prenotazione[] lcomiHotelpersistentModelPrenotaziones = (com.iHotel.persistentModel.Prenotazione[]) lPrenotazioneList.toArray(new com.iHotel.persistentModel.Prenotazione[lPrenotazioneList.size()]);
		length = Math.min(lcomiHotelpersistentModelPrenotaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelPrenotaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PrezzoCamera...");
		java.util.List lPrezzoCameraList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.PrezzoCamera").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.PrezzoCamera[] lcomiHotelpersistentModelPrezzoCameras = (com.iHotel.persistentModel.PrezzoCamera[]) lPrezzoCameraList.toArray(new com.iHotel.persistentModel.PrezzoCamera[lPrezzoCameraList.size()]);
		length = Math.min(lcomiHotelpersistentModelPrezzoCameras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelPrezzoCameras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing StatoCamera...");
		java.util.List lStatoCameraList = com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession().createQuery("From com.iHotel.persistentModel.StatoCamera").setMaxResults(ROW_COUNT).list();
		com.iHotel.persistentModel.StatoCamera[] lcomiHotelpersistentModelStatoCameras = (com.iHotel.persistentModel.StatoCamera[]) lStatoCameraList.toArray(new com.iHotel.persistentModel.StatoCamera[lStatoCameraList.size()]);
		length = Math.min(lcomiHotelpersistentModelStatoCameras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lcomiHotelpersistentModelStatoCameras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException  {
		System.out.println("Listing Albergo by Criteria...");
		com.iHotel.persistentModel.AlbergoCriteria lcomiHotelpersistentModelAlbergoCriteria = new com.iHotel.persistentModel.AlbergoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelAlbergoCriteria.ID.eq();
		lcomiHotelpersistentModelAlbergoCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.Albergo[] comiHotelpersistentModelAlbergos = lcomiHotelpersistentModelAlbergoCriteria.listAlbergo();
		int length =comiHotelpersistentModelAlbergos== null ? 0 : Math.min(comiHotelpersistentModelAlbergos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelAlbergos[i]);
		}
		System.out.println(length + " Albergo record(s) retrieved."); 
		
		System.out.println("Listing Camera by Criteria...");
		com.iHotel.persistentModel.CameraCriteria lcomiHotelpersistentModelCameraCriteria = new com.iHotel.persistentModel.CameraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelCameraCriteria.ID.eq();
		lcomiHotelpersistentModelCameraCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.Camera[] comiHotelpersistentModelCameras = lcomiHotelpersistentModelCameraCriteria.listCamera();
		length =comiHotelpersistentModelCameras== null ? 0 : Math.min(comiHotelpersistentModelCameras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelCameras[i]);
		}
		System.out.println(length + " Camera record(s) retrieved."); 
		
		System.out.println("Listing CatalogoCamere by Criteria...");
		com.iHotel.persistentModel.CatalogoCamereCriteria lcomiHotelpersistentModelCatalogoCamereCriteria = new com.iHotel.persistentModel.CatalogoCamereCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelCatalogoCamereCriteria.ID.eq();
		lcomiHotelpersistentModelCatalogoCamereCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.CatalogoCamere[] comiHotelpersistentModelCatalogoCameres = lcomiHotelpersistentModelCatalogoCamereCriteria.listCatalogoCamere();
		length =comiHotelpersistentModelCatalogoCameres== null ? 0 : Math.min(comiHotelpersistentModelCatalogoCameres.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelCatalogoCameres[i]);
		}
		System.out.println(length + " CatalogoCamere record(s) retrieved."); 
		
		System.out.println("Listing DescrizioneCamera by Criteria...");
		com.iHotel.persistentModel.DescrizioneCameraCriteria lcomiHotelpersistentModelDescrizioneCameraCriteria = new com.iHotel.persistentModel.DescrizioneCameraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelDescrizioneCameraCriteria.ID.eq();
		lcomiHotelpersistentModelDescrizioneCameraCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.DescrizioneCamera[] comiHotelpersistentModelDescrizioneCameras = lcomiHotelpersistentModelDescrizioneCameraCriteria.listDescrizioneCamera();
		length =comiHotelpersistentModelDescrizioneCameras== null ? 0 : Math.min(comiHotelpersistentModelDescrizioneCameras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelDescrizioneCameras[i]);
		}
		System.out.println(length + " DescrizioneCamera record(s) retrieved."); 
		
		System.out.println("Listing ElementoPrenotazione by Criteria...");
		com.iHotel.persistentModel.ElementoPrenotazioneCriteria lcomiHotelpersistentModelElementoPrenotazioneCriteria = new com.iHotel.persistentModel.ElementoPrenotazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelElementoPrenotazioneCriteria.ID.eq();
		lcomiHotelpersistentModelElementoPrenotazioneCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.ElementoPrenotazione[] comiHotelpersistentModelElementoPrenotaziones = lcomiHotelpersistentModelElementoPrenotazioneCriteria.listElementoPrenotazione();
		length =comiHotelpersistentModelElementoPrenotaziones== null ? 0 : Math.min(comiHotelpersistentModelElementoPrenotaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelElementoPrenotaziones[i]);
		}
		System.out.println(length + " ElementoPrenotazione record(s) retrieved."); 
		
		System.out.println("Listing Ospite by Criteria...");
		com.iHotel.persistentModel.OspiteCriteria lcomiHotelpersistentModelOspiteCriteria = new com.iHotel.persistentModel.OspiteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelOspiteCriteria.ID.eq();
		lcomiHotelpersistentModelOspiteCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.Ospite[] comiHotelpersistentModelOspites = lcomiHotelpersistentModelOspiteCriteria.listOspite();
		length =comiHotelpersistentModelOspites== null ? 0 : Math.min(comiHotelpersistentModelOspites.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelOspites[i]);
		}
		System.out.println(length + " Ospite record(s) retrieved."); 
		
		System.out.println("Listing Periodo by Criteria...");
		com.iHotel.persistentModel.PeriodoCriteria lcomiHotelpersistentModelPeriodoCriteria = new com.iHotel.persistentModel.PeriodoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelPeriodoCriteria.ID.eq();
		lcomiHotelpersistentModelPeriodoCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.Periodo[] comiHotelpersistentModelPeriodos = lcomiHotelpersistentModelPeriodoCriteria.listPeriodo();
		length =comiHotelpersistentModelPeriodos== null ? 0 : Math.min(comiHotelpersistentModelPeriodos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelPeriodos[i]);
		}
		System.out.println(length + " Periodo record(s) retrieved."); 
		
		System.out.println("Listing Prenotazione by Criteria...");
		com.iHotel.persistentModel.PrenotazioneCriteria lcomiHotelpersistentModelPrenotazioneCriteria = new com.iHotel.persistentModel.PrenotazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelPrenotazioneCriteria.ID.eq();
		lcomiHotelpersistentModelPrenotazioneCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.Prenotazione[] comiHotelpersistentModelPrenotaziones = lcomiHotelpersistentModelPrenotazioneCriteria.listPrenotazione();
		length =comiHotelpersistentModelPrenotaziones== null ? 0 : Math.min(comiHotelpersistentModelPrenotaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelPrenotaziones[i]);
		}
		System.out.println(length + " Prenotazione record(s) retrieved."); 
		
		System.out.println("Listing PrezzoCamera by Criteria...");
		com.iHotel.persistentModel.PrezzoCameraCriteria lcomiHotelpersistentModelPrezzoCameraCriteria = new com.iHotel.persistentModel.PrezzoCameraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelPrezzoCameraCriteria.ID.eq();
		lcomiHotelpersistentModelPrezzoCameraCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.PrezzoCamera[] comiHotelpersistentModelPrezzoCameras = lcomiHotelpersistentModelPrezzoCameraCriteria.listPrezzoCamera();
		length =comiHotelpersistentModelPrezzoCameras== null ? 0 : Math.min(comiHotelpersistentModelPrezzoCameras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelPrezzoCameras[i]);
		}
		System.out.println(length + " PrezzoCamera record(s) retrieved."); 
		
		System.out.println("Listing StatoCamera by Criteria...");
		com.iHotel.persistentModel.StatoCameraCriteria lcomiHotelpersistentModelStatoCameraCriteria = new com.iHotel.persistentModel.StatoCameraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcomiHotelpersistentModelStatoCameraCriteria.ID.eq();
		lcomiHotelpersistentModelStatoCameraCriteria.setMaxResults(ROW_COUNT);
		com.iHotel.persistentModel.StatoCamera[] comiHotelpersistentModelStatoCameras = lcomiHotelpersistentModelStatoCameraCriteria.listStatoCamera();
		length =comiHotelpersistentModelStatoCameras== null ? 0 : Math.min(comiHotelpersistentModelStatoCameras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comiHotelpersistentModelStatoCameras[i]);
		}
		System.out.println(length + " StatoCamera record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListIhotelData listIhotelData = new ListIhotelData();
			try {
				listIhotelData.listTestData();
				//listIhotelData.listByCriteria();
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
