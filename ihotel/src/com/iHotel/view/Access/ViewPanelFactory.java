/**
 * 
 */
package com.iHotel.view.Access;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno_Cancellato;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno_InCorso;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno_Prenotato;
import com.iHotel.view.Graphic.GestioneSoggiorno.VPGP_InfoSoggiorno_Terminato;

/**
 * @author Eugenio
 *
 */
public class ViewPanelFactory {
	/**
	 * Metodo per fornire il pannello relativo alle informazioni del soggiorno, in base allo stato 
	 * attuale del soggiorno.
	 * 
	 * @param soggiorno Soggiorno che si vuole visualizzare.
	 * @return Pannello contenente le informazioni del soggiorno.
	 */
	public static VPGP_InfoSoggiorno getPanelInfoSoggiorno(SoggiornoContextSubject soggiorno) {
		// Prendo il nome dello stato attuale del soggiorno
		String nomeStato = soggiorno.get_soggiornoState().getClass().getSimpleName();
		// Pannello da restituire
		VPGP_InfoSoggiorno panelInfoSoggiorno = null;
		
		System.out.println(nomeStato);
		
		// Scelgo il pannello da fornire in base allo stato della prenotazione
		switch (nomeStato) {
		case "SoggiornoPrenotato" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Prenotato();
			break;
		case "Soggiorno" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_InCorso();
			break;
		case "SoggiornoTerminato" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Terminato();
			break;
		case "SoggiornoCancellato" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Cancellato();
			break;
		default:
			break;
		}
		return panelInfoSoggiorno;
	}
}
