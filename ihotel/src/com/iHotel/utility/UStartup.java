/**
 * 
 */
package com.iHotel.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.MAlbergo;
import com.iHotel.model.MCamera;
import com.iHotel.model.MCatalogoCamere;
import com.iHotel.model.MDescrizioneCamera;
import com.iHotel.persistence.PersistentManager;

/**
 * @author Eugenio
 *
 */
public class UStartup {
	
	public void inizializza() {
		
		PersistentManager db = PersistentManager.getInstance();
		try {
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
			MAlbergo _albergo = MAlbergo.getInstance();
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
			_albergo.set_camere(_camere);
			_albergo.set_catalogoCamere(catalogoCamere);		
		} catch (Exception e) {
			// TODO
		}
	}
}
