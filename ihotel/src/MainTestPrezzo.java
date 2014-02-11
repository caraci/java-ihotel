
import com.iHotel.model.*;
public class MainTestPrezzo {

	public static void main(String[] args) {
		MPrezzoCamera prezzo= new MPrezzoCamera();
		MPeriodo p1 = new MPeriodo();
		p1.set_giornoInizio(6);
		p1.set_meseInizio(0);
		p1.set_annoInizio(2014);
		p1.set_giornoFine(31);
		p1.set_meseFine(0);
		p1.set_annoFine(2014);
		
		MPeriodo p2 = new MPeriodo();
		p2.set_giornoInizio(1);
		p2.set_meseInizio(0);
		p2.set_annoInizio(2014);
		p2.set_giornoFine(6);
		p2.set_meseFine(0);
		p2.set_annoFine(2014);
		
		
		prezzo.set_prezzo(50);
		prezzo.set_periodo(p1);
		
		System.out.print(prezzo.getPrezzoInPeriodo(p2).get_prezzo());
	}

}
