/**
 * 
 */
package com.iHotel.main;

import java.io.IOException;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.utility.UStartup;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_AggiungiServiziInterni;

/**
 * @author Eugenio
 *
 */
public class MainTestaInterfacce {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Inizializzo lo strato di dominio.
		UStartup startup = new UStartup();
		startup.inizializza();
		// Creo Frame Aggiungi servizi
		VFGP_AggiungiServiziInterni.getInstance().creaFrame(CatalogoServiziInterni.getInstance().get_descrizioneServizi(), Albergo.getInstance().getCameraDaNumero("102"));
		VFGP_AggiungiServiziInterni.getInstance().setVisible(true);

	}

}
