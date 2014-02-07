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
		}
		finally{
			db.close();
		}
		
		
		CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
		gestisciPrenotazione.creaNuovaPrenotazione();
		// 1 Gennaio 2014 - 00:00.00
		long dataInizio = 1388530800000L;
		// 7 Gennaio 2014 - 23:59.59
		long dataFine = 1389135599000L;
		// Tipologie
		ArrayList<String> tipologie = new ArrayList<String>();
		tipologie.add("Singola");
		gestisciPrenotazione.cercaCamereLibere(dataInizio, dataFine, tipologie);
		
	}

}
