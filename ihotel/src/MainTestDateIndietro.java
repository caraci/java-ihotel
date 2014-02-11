import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.iHotel.model.MPeriodo;


public class MainTestDateIndietro {

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
		
		GregorianCalendar data = new GregorianCalendar();
		data.set(annoInizio_1, meseInizio_1, giornoInizio_1);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		

		data.add(data.DAY_OF_MONTH,-1);  // number of days to add
		System.out.print(sdf.format(data.getTime()));

	}

}
