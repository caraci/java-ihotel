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
		CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
		try {			
			List<MAlbergo> result = db.query(new Predicate<MAlbergo>() {
				public boolean match(MAlbergo candidate) {
					return true;
				}
			});
			MAlbergo albergo = new MAlbergo();
			albergo = result.get(0);
			gestisciPrenotazione.set_albergo(albergo);
			System.out.print(albergo.get_camere().get(0).get_statiCamera().get(0).get_periodo().get_giornoInizio());
		}
		finally{
			db.close();
		}
		
		
		
		
		
	}

}
