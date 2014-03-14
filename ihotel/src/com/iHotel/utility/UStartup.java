/**
 * 
 */
package com.iHotel.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.iHotel.model.Albergo;
import com.iHotel.model.CatalogoCamere;
import com.iHotel.model.DescrizioneCamera;
import com.iHotel.model.PrenotazioneSubject;
import com.iHotel.model.Storico;
import com.iHotel.model.State.CameraContext;
import com.iHotel.persistence.PCamera;
import com.iHotel.persistence.PDescrizioneCamera;
import com.iHotel.persistence.PPrenotazione;

/**
 * @author Eugenio
 *
 */
public class UStartup {
	public void inizializza() {
		try {
			// Carico tutte le camere
			List<CameraContext> camere = PCamera.getInstance().caricaCamere();
			// Carico tutte le descrizioni
			List<DescrizioneCamera> descrizioniCamere = PDescrizioneCamera.getInstance().caricaDescrizioniCamere();
			// Carico tutte le prenotazioni
			List<PrenotazioneSubject> prenotazioni = PPrenotazione.getInstance().caricaPrenotazioni();
			// Mediante pattern singleton, carico Albergo e Catalogo camere.
			Albergo albergo = Albergo.getInstance();
			CatalogoCamere catalogoCamere = CatalogoCamere.getInstance();
			Storico storico = Storico.getInstance();
			// Setto gli attributi dello storico
			ArrayList<PrenotazioneSubject> _prenotazioni = new ArrayList<PrenotazioneSubject>();
			for (Iterator<PrenotazioneSubject> iterator = prenotazioni.iterator(); iterator.hasNext();) {
				PrenotazioneSubject prenotazioneSubject = (PrenotazioneSubject) iterator.next();
				System.out.println(prenotazioneSubject.get_completata());
				_prenotazioni.add(prenotazioneSubject);				
			}
			storico.set_prenotazioni(_prenotazioni);
			// Setto gli attributi del catalogoCamere
			HashMap<String,DescrizioneCamera> _descrizioniCamere = new HashMap<String,DescrizioneCamera>();
			for (Iterator<DescrizioneCamera> iterator = descrizioniCamere.iterator(); iterator.hasNext();) {
				DescrizioneCamera descrizioneCamera = (DescrizioneCamera) iterator.next();
				_descrizioniCamere.put(descrizioneCamera.get_tipologia(), descrizioneCamera);
			}
			catalogoCamere.set_descrizioniCamere(_descrizioniCamere);
			// Setto gli attributi dell'albergo
			ArrayList<CameraContext> _camere = new ArrayList<CameraContext>();
			for (Iterator<CameraContext> iterator = camere.iterator(); iterator.hasNext();) {
				CameraContext camera = (CameraContext) iterator.next();
				_camere.add(camera);
			}
			albergo.set_camere(_camere);
			albergo.set_catalogoCamere(catalogoCamere);	
			albergo.set_storico(storico);
		} catch (Exception e) {
			// TODO
		}
	}
}
