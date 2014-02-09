import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.iHotel.controller.*;
import com.iHotel.model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbihotel");
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
			for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
				MCamera camera = (MCamera) iterator.next();
				_camere.add(camera);
			}
			albergo.set_camere(_camere);
			albergo.set_catalogoCamere(catalogoCamere);
			
			/* FINE CARICAMENTO DEGLI OGGETTI DELLO STRATO DI DOMINIO */
			
			// Carico il gestore della prenotazione mediante singleton
			CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
			// Associo l'albergo al gestore
			gestisciPrenotazione.set_albergo(albergo);
			// Creo l'array contenente le tipologie da ricercare
			ArrayList<String> tipologie = new ArrayList<String>();
			tipologie.add("Singola");
			// Data di inizio e fine ricerca
			int gi=1;
			int mi=0;
			int ai=2014;
			int gf=1;
			int mf=1;
			int af=2014;
			// Cerco le camere libere nel periodo e nelle tipologie
			gestisciPrenotazione.cercaCamereLibere(gi, mi, ai, gf, mf, af, tipologie);
			//System.out.print(albergo.get_camere().get(0).get_statiCamera().get(0).get_periodo().get_giornoInizio());
		}
		finally{
			db.close();
		}
	}

}
