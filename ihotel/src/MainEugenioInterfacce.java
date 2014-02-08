import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.iHotel.controller.CGestisciPrenotazione;
import com.iHotel.model.MAlbergo;
import com.iHotel.view.VFrameCreaPrenotazioneStep_1;


public class MainEugenioInterfacce {

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
			// Prento il controllore per la gestione della prenotazione.
			CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
			// Associo l'albergo alla prenotazione
			gestisciPrenotazione.set_albergo(albergo);
			// Creo l'arrayList nel quale si vanno ad inserire le tipologie di camere note.
			ArrayList<String> tipologieCamere = new ArrayList<String>();
			tipologieCamere.addAll(albergo.get_catalogoCamere().get_descrizioniCamere().keySet());
			VFrameCreaPrenotazioneStep_1 frameCreaPrenotazioneStep_1 = VFrameCreaPrenotazioneStep_1.getInstance();
			frameCreaPrenotazioneStep_1.creaFrame(tipologieCamere);
			frameCreaPrenotazioneStep_1.setVisible(true);
		}
		finally{
			db.close();
		}
		
		
	}

}
