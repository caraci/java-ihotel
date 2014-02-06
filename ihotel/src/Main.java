import java.util.ArrayList;

import com.iHotel.controller.*;
import com.iHotel.model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
