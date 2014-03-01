/**
 * 
 */
package com.iHotel.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.iHotel.model.MAlbergo;
import com.iHotel.model.MCamera;
import com.iHotel.model.MCatalogoCamere;
import com.iHotel.model.MDescrizioneCamera;
import com.iHotel.model.MPrenotazioneSubject;
import com.iHotel.model.MStorico;
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
			List<MCamera> camere = PCamera.getInstance().caricaCamere();
			// Carico tutte le descrizioni
			List<MDescrizioneCamera> descrizioniCamere = PDescrizioneCamera.getInstance().caricaDescrizioniCamere();
			// Carico tutte le prenotazioni
			List<MPrenotazioneSubject> prenotazioni = PPrenotazione.getInstance().caricaPrenotazioni();
			// Mediante pattern singleton, carico Albergo e Catalogo camere.
			MAlbergo albergo = MAlbergo.getInstance();
			MCatalogoCamere catalogoCamere = MCatalogoCamere.getInstance();
			MStorico storico = MStorico.getInstance();
			// Setto gli attributi dello storico
			ArrayList<MPrenotazioneSubject> _prenotazioni = new ArrayList<MPrenotazioneSubject>();
			for (Iterator<MPrenotazioneSubject> iterator = prenotazioni.iterator(); iterator.hasNext();) {
				MPrenotazioneSubject prenotazioneSubject = (MPrenotazioneSubject) iterator.next();
				System.out.println(prenotazioneSubject.get_completata());
				_prenotazioni.add(prenotazioneSubject);				
			}
			storico.set_prenotazioni(_prenotazioni);
			// Setto gli attributi del catalogoCamere
			HashMap<String,MDescrizioneCamera> _descrizioniCamere = new HashMap<String,MDescrizioneCamera>();
			for (Iterator<MDescrizioneCamera> iterator = descrizioniCamere.iterator(); iterator.hasNext();) {
				MDescrizioneCamera descrizioneCamera = (MDescrizioneCamera) iterator.next();
				_descrizioniCamere.put(descrizioneCamera.get_tipologia(), descrizioneCamera);
			}
			catalogoCamere.set_descrizioniCamere(_descrizioniCamere);
			// Setto gli attributi dell'albergo
			ArrayList<MCamera> _camere = new ArrayList<MCamera>();
			for (Iterator<MCamera> iterator = camere.iterator(); iterator.hasNext();) {
				MCamera camera = (MCamera) iterator.next();
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
