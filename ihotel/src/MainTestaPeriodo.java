import com.iHotel.model.MPeriodo;


public class MainTestaPeriodo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//periodi
		
		int oraInizio = 16;
		int oraFine = 10;
		int minutoInizio = 0;
		int minutoFine = 0;
// periodo_1 - 1 Gennaio 2014 - 16:00.00 - 31 Gennaio 2014 - 10.00.00
		MPeriodo periodo_1 = new MPeriodo();
		int giornoInizio_1 = 1;
		int meseInizio_1 = 0;
		int annoInizio_1 = 2014;
		int giornoFine_1 = 31;
		int meseFine_1 = 0;
		int annoFine_1 = 2014;
		// Inizio 
		periodo_1.set_oraInizio(oraInizio);
		periodo_1.set_minutoInizio(minutoInizio);
		periodo_1.set_giornoInizio(giornoInizio_1);
		periodo_1.set_meseInizio(meseInizio_1);
		periodo_1.set_annoInizio(annoInizio_1);
		// Fine
		periodo_1.set_oraFine(oraFine);
		periodo_1.set_minutoFine(minutoFine);
		periodo_1.set_giornoFine(giornoFine_1);
		periodo_1.set_meseFine(meseFine_1);
		periodo_1.set_annoFine(annoFine_1);
		
		
	// periodo_2 - 31 Gennaio 2014 - 16:00.00 - 28 Febbraio 2014 - 10:00.00				
		MPeriodo periodo_2 = new MPeriodo();
		int giornoInizio_2 = 31;
		int meseInizio_2 = 0;
		int annoInizio_2 = 2014;
		int giornoFine_2 = 28;
		int meseFine_2 = 1;
		int annoFine_2 = 2014;
		// Inizio
		periodo_2.set_oraInizio(oraInizio);
		periodo_2.set_minutoInizio(minutoInizio);
		periodo_2.set_giornoInizio(giornoInizio_2);
		periodo_2.set_meseInizio(meseInizio_2);
		periodo_2.set_annoInizio(annoInizio_2);
		// Fine
		periodo_2.set_oraFine(oraFine);
		periodo_2.set_minutoFine(minutoFine);
		periodo_2.set_giornoFine(giornoFine_2);
		periodo_2.set_meseFine(meseFine_2);
		periodo_2.set_annoFine(annoFine_2);
		
		
	// periodo_3 - 28 Febbraio 2014 - 16:00.00 - 31 Marzo 2014 - 10:00.00
		MPeriodo periodo_3 = new MPeriodo();
		int giornoInizio_3 = 28;
		int meseInizio_3 = 1;
		int annoInizio_3 = 2014;
		int giornoFine_3 = 31;
		int meseFine_3 = 2;
		int annoFine_3 = 2014;
		// Inizio
		periodo_3.set_oraInizio(oraInizio);
		periodo_3.set_minutoInizio(minutoInizio);
		periodo_3.set_giornoInizio(giornoInizio_3);
		periodo_3.set_meseInizio(meseInizio_3);
		periodo_3.set_annoInizio(annoInizio_3);
		// Fine
		periodo_3.set_oraFine(oraFine);
		periodo_3.set_minutoFine(minutoFine);
		periodo_3.set_giornoFine(giornoFine_3);
		periodo_3.set_meseFine(meseFine_3);
		periodo_3.set_annoFine(annoFine_3);
		
	// periodo_4 - 31 Gennaio 2014 - 16:00.00 - 31 Marzo 2014 - 10:00.00
		MPeriodo periodo_4 = new MPeriodo();
		int giornoInizio_4 = 31;
		int meseInizio_4 = 0;
		int annoInizio_4 = 2014;
		int giornoFine_4 = 31;
		int meseFine_4 = 2;
		int annoFine_4 = 2014;
		// Inizio
		periodo_4.set_oraInizio(oraInizio);
		periodo_4.set_minutoInizio(minutoInizio);
		periodo_4.set_giornoInizio(giornoInizio_4);
		periodo_4.set_meseInizio(meseInizio_4);
		periodo_4.set_annoInizio(annoInizio_4);
		// Fine
		periodo_4.set_oraFine(oraFine);
		periodo_4.set_minutoFine(minutoFine);
		periodo_4.set_giornoFine(giornoFine_4);
		periodo_4.set_meseFine(meseFine_4);
		periodo_4.set_annoFine(annoFine_4);
		
	// periodo_5 - 1 Gennaio 2014 - 16:00.00 - 31 Marzo 2014 - 10:00.00
		MPeriodo periodo_5 = new MPeriodo();
		int giornoInizio_5 = 1;
		int meseInizio_5 = 0;
		int annoInizio_5 = 2014;
		int giornoFine_5 = 31;
		int meseFine_5 = 2;
		int annoFine_5 = 2014;
		// Inizio
		periodo_5.set_oraInizio(oraInizio);
		periodo_5.set_minutoInizio(minutoInizio);
		periodo_5.set_giornoInizio(giornoInizio_5);
		periodo_5.set_meseInizio(meseInizio_5);
		periodo_5.set_annoInizio(annoInizio_5);
		// Fine
		periodo_5.set_oraFine(oraFine);
		periodo_5.set_minutoFine(minutoFine);
		periodo_5.set_giornoFine(giornoFine_5);
		periodo_5.set_meseFine(meseFine_5);
		periodo_5.set_annoFine(annoFine_5);
		
//fine periodi
		System.out.println(periodo_2.contenutoTraPeriodi(periodo_1, periodo_5));
	}

}
