import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.iHotel.controller.CGestisciPrenotazione;
import com.iHotel.model.MAlbergo;


public class MainDio {

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
			ArrayList<MCamera> camere = new ArrayList<MCamera>();
			camere = albergo.get_camere();
			for (Iterator iterator = camere.iterator(); iterator.hasNext();) {
				MCamera camera = (MCamera) iterator.next();
				MPeriodo p = 
				
			}
			System.out.println(albergo.get_camere().get(0).get_statiCamera().get(0).get_periodo());
		}
		finally{
			db.close();
		}
	}

}
