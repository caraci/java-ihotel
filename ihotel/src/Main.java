import java.util.ArrayList;
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
			List<MAlbergo> result = db.query(new Predicate<MAlbergo>() {
				public boolean match(MAlbergo candidate) {
					return true;
				}
			});
			MAlbergo albergo = new MAlbergo();
			albergo = result.get(0);
			// Carico il gestore della prenotazione mediante singleton
			CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
			// Associo l'albergo al gestore
			gestisciPrenotazione.set_albergo(albergo);
			// Creo l'array contenente le tipologie da ricercare
			ArrayList<String> tipologie = new ArrayList<String>();
			tipologie.add("Singola");
			//tipologie.add("Doppia");
			//tipologie.add("Tripla");
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
