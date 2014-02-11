import java.util.*;

import com.iHotel.model.*;
public class MainTestCatalogo {

	public static void main(String[] args) {
		MDescrizioneCamera d1 = new MDescrizioneCamera();
		d1.set_tipologia("Singola");
		
				
		MDescrizioneCamera d2 = new MDescrizioneCamera();
		d2.set_tipologia("Doppia");
		
		
		MDescrizioneCamera d3 = new MDescrizioneCamera();
		d3.set_tipologia("Tripla");
		
		HashMap<String,MDescrizioneCamera> descrizioniCamere = new HashMap<String, MDescrizioneCamera>();
		
		descrizioniCamere.put("Singola", d1);
		descrizioniCamere.put("Doppia", d2);
		descrizioniCamere.put("Tripla", d3);
		
		MCatalogoCamere catalogo = MCatalogoCamere.getInstance();
		catalogo.set_descrizioniCamere(descrizioniCamere);
		System.out.print(catalogo.getDescrizioneDaTipologia("Doppia").get_tipologia());

	}

}
