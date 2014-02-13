import java.util.LinkedList;

import com.iHotel.model.*;


public class MainTestStatiLiberi {

	public static void main(String[] args) {
		
		MPeriodo periodo_1 = new MPeriodo();
		int giornoInizio_1 = 1;
		int meseInizio_1 = 0;
		int annoInizio_1 = 2014;
		int giornoFine_1 = 31;
		int meseFine_1 = 0;
		int annoFine_1 = 2014;
		periodo_1.set_giornoInizio(giornoInizio_1);
		periodo_1.set_meseInizio(meseInizio_1);
		periodo_1.set_annoInizio(annoInizio_1);
		periodo_1.set_giornoFine(giornoFine_1);
		periodo_1.set_meseFine(meseFine_1);
		periodo_1.set_annoFine(annoFine_1);
		
		
	// periodo_2 - 1 Febbraio 2014 - 00:00.00 - 28 Febbraio 2014 - 23:59.59				
		MPeriodo periodo_2 = new MPeriodo();
		int giornoInizio_2 = 1;
		int meseInizio_2 = 1;
		int annoInizio_2 = 2014;
		int giornoFine_2 = 28;
		int meseFine_2 = 1;
		int annoFine_2 = 2014;
		periodo_2.set_giornoInizio(giornoInizio_2);
		periodo_2.set_meseInizio(meseInizio_2);
		periodo_2.set_annoInizio(annoInizio_2);
		periodo_2.set_giornoFine(giornoFine_2);
		periodo_2.set_meseFine(meseFine_2);
		periodo_2.set_annoFine(annoFine_2);
		
		
	// periodo_3 - 1 Marzo 2014 - 00:00.00 - 31 Marzo 2014 - 23:59.59
		MPeriodo periodo_3 = new MPeriodo();
		int giornoInizio_3 = 1;
		int meseInizio_3 = 2;
		int annoInizio_3 = 2014;
		int giornoFine_3 = 31;
		int meseFine_3 = 2;
		int annoFine_3 = 2014;
		periodo_3.set_giornoInizio(giornoInizio_3);
		periodo_3.set_meseInizio(meseInizio_3);
		periodo_3.set_annoInizio(annoInizio_3);
		periodo_3.set_giornoFine(giornoFine_3);
		periodo_3.set_meseFine(meseFine_3);
		periodo_3.set_annoFine(annoFine_3);

		
		MPeriodo periodo_contenuto = new MPeriodo();
		int giornoInizio_contenuto = 20;
		int meseInizio_contenuto = 0;
		int annoInizio_contenuto = 2014;
		int giornoFine_contenuto = 5;
		int meseFine_contenuto = 1;
		int annoFine_contenuto = 2014;
		periodo_contenuto.set_giornoInizio(giornoInizio_contenuto);
		periodo_contenuto.set_meseInizio(meseInizio_contenuto);
		periodo_contenuto.set_annoInizio(annoInizio_contenuto);
		periodo_contenuto.set_giornoFine(giornoFine_contenuto);
		periodo_contenuto.set_meseFine(meseFine_contenuto);
		periodo_contenuto.set_annoFine(annoFine_contenuto);
				
		System.out.print(periodo_contenuto.sovrappone(periodo_1));
				
		
		
	}

}
