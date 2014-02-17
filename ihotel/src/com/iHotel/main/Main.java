package com.iHotel.main;
import java.io.IOException;
import java.util.*;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.iHotel.controller.CGestisciPrenotazione;
import com.iHotel.model.*;
import com.iHotel.persistence.PersistentManager;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PersistentManager persistentManager = PersistentManager.getInstance();
		ObjectContainer db = persistentManager.get_db();
		try {			
			/* CARICAMENTO DEGLI OGETTI DELLO STRATO DI DOMINIO  */		
			// Carico tutte le camere
			List<MCamera> camere = db.query(new Predicate<MCamera>() {
				public boolean match(MCamera candidate) {
					return true;
				}
			});
			// Carico tutte le descrizioni
			List<MDescrizioneCamera> descrizioniCamere = db.query(new Predicate<MDescrizioneCamera>() {
				public boolean match(MDescrizioneCamera candidate) {
					return true;
				}
			});
			// Mediante pattern singleton, carico Albergo e Catalogo camere.
			MAlbergo albergo = MAlbergo.getInstance();
			MCatalogoCamere catalogoCamere = MCatalogoCamere.getInstance();
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
			/* FINE CARICAMENTO DEGLI OGGETTI DELLO STRATO DI DOMINIO */
			
			// Prendo il controllore per la gestione della prenotazione.
			CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
			// Creo una nuova prenotazione
			gestisciPrenotazione.creaNuovaPrenotazione();
			// Associo l'albergo alla controllore della prenotazione
			gestisciPrenotazione.set_albergo(albergo);
			// Creo l'arrayList nel quale si vanno ad inserire le tipologie di camere note.
			ArrayList<String> tipologieCamere = new ArrayList<String>();
			tipologieCamere.addAll(albergo.get_catalogoCamere().get_descrizioniCamere().keySet());
			// Ricavo l'interfaccia relativa al primo step della creazione della prenotazione mediante pattern singleton.
			VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = VFrameCreaPrenotazioneStep_1.getInstance();
			frameCreaPrenotazioneStep_1.creaFrame(tipologieCamere);
			frameCreaPrenotazioneStep_1.setVisible(true);
		}
		finally {
			//db.close();
		}	
	}

}
