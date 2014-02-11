
import com.iHotel.model.*;

import java.util.*;
public class MainTestPrezzo {

	public static void main(String[] args) {
		
		MPrezzoCamera prezzo= new MPrezzoCamera();
		MPrezzoCamera prezzo2= new MPrezzoCamera();
		
		MPeriodo p1 = new MPeriodo();
		p1.set_giornoInizio(1);
		p1.set_meseInizio(0);
		p1.set_annoInizio(2014);
		p1.set_giornoFine(6);
		p1.set_meseFine(0);
		p1.set_annoFine(2014);
		
		MPeriodo p2 = new MPeriodo();
		p2.set_giornoInizio(1);
		p2.set_meseInizio(1);
		p2.set_annoInizio(2014);
		p2.set_giornoFine(28);
		p2.set_meseFine(1);
		p2.set_annoFine(2014);
		
		MPeriodo p3 = new MPeriodo();
		p3.set_giornoInizio(6);
		p3.set_meseInizio(0);
		p3.set_annoInizio(2014);
		p3.set_giornoFine(7);
		p3.set_meseFine(0);
		p3.set_annoFine(2014);
		
		
		prezzo.set_prezzo(50);
		prezzo.set_periodo(p1);
		
		prezzo2.set_prezzo(60);
		prezzo2.set_periodo(p2);
		
		ArrayList<MPrezzoCamera> prezziCamera = new ArrayList<MPrezzoCamera>();
		prezziCamera.add(prezzo);
		prezziCamera.add(prezzo2);
		
		MDescrizioneCamera descrizioneCamera = new MDescrizioneCamera();
		descrizioneCamera.set_prezziCamera(prezziCamera);
			
		
		System.out.print(descrizioneCamera.getPrezziInPeriodo(p3).get(0).get_prezzo());
	}

}
