/**
 * 
 */
package com.iHotel.view.Access;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamentiSoggiornoNonSaldato;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamentiSoggiornoSaldato;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamenti_Observer;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniCamera.VPGP_InfoCamera;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniCamera.VPGP_InfoCamera_SoggiornoCancellato;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniCamera.VPGP_InfoCamera_SoggiornoInCorso;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniCamera.VPGP_InfoCamera_SoggiornoPrenotato;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniCamera.VPGP_InfoCamera_SoggiornoTerminato;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno.VPGP_InfoSoggiorno;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno.VPGP_InfoSoggiorno_Cancellato;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno.VPGP_InfoSoggiorno_InCorso;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno.VPGP_InfoSoggiorno_Prenotato;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno.VPGP_InfoSoggiorno_Terminato_Saldato;
import com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno.VPGP_InfoSoggiorno_Terminato_Sospeso;

/**
 * Classe che ha il compito di restituire i pannelli che visualizzano informazioni dipendenti dallo stato
 * del soggiorno 
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
		
		// Scelgo il pannello da fornire in base allo stato della prenotazione
		switch (nomeStato) {
		case "SoggiornoPrenotato" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Prenotato();
			break;
		case "SoggiornoInCorso" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_InCorso();
			break;
		case "SoggiornoTerminatoSaldato" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Terminato_Saldato();
			break;
		case "SoggiornoTerminatoSospeso":
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Terminato_Sospeso();
		break;
		case "SoggiornoCancellato" :
			panelInfoSoggiorno = new VPGP_InfoSoggiorno_Cancellato();
			break;
		default:
			break;
		}
		return panelInfoSoggiorno;
	}
	
	/**
	 * Metodo che restituisce la schermata della infoCamera in base allo stato del soggiorno
	 * 
	 * @param soggiorno cui appartiene la camera
	 * @return Pannello contenente le informazioni sulla camera
	 */
	public static VPGP_InfoCamera getPanelInfoCamera(SoggiornoContextSubject soggiorno){
		// Prendo il nome dello stato attuale del soggiorno
		String nomeStato = soggiorno.get_soggiornoState().getClass().getSimpleName();
		// Pannello da restituire
		VPGP_InfoCamera panelInfoCamera = null;
		
		// Scelgo il pannello da fornire in base allo stato della prenotazione
		switch (nomeStato) {
		case "SoggiornoTerminato" :
			panelInfoCamera = new VPGP_InfoCamera_SoggiornoTerminato();
			break;
		case "SoggiornoCancellato" :
			panelInfoCamera = new VPGP_InfoCamera_SoggiornoCancellato();
			break;
		case "SoggiornoPrenotato":
			panelInfoCamera = new VPGP_InfoCamera_SoggiornoPrenotato();
			break;
		case "SoggiornoInCorso":
			panelInfoCamera = new VPGP_InfoCamera_SoggiornoInCorso();
			break;
		default:
			break;
		}
		return panelInfoCamera;
	}
	/**
	 * Metodo che restituisce la schermata del riepilogo dei pagamenti in base allo stato del soggiorno
	 * 
	 * @param soggiorno cui appartiene la camera
	 * @return Pannello contenente il riepilogo sui pagamenti
	 */
	public static VPP_RiepilogoPagamenti_Observer getPanelRiepilogoPagamenti(SoggiornoContextSubject soggiorno){
		// Prendo il nome dello stato attuale del soggiorno
		String nomeStato = soggiorno.get_soggiornoState().getClass().getSimpleName();
		
		//Istanzio il pannello
		VPP_RiepilogoPagamenti_Observer panelRiepilogoPagamenti= null;
		
		//Scelgo il pannello corretto in base allo stato del soggiorno
		switch (nomeStato) {
		case "SoggiornoTerminatoSaldato":
			panelRiepilogoPagamenti = new VPP_RiepilogoPagamentiSoggiornoSaldato();
			break;
		default:
			panelRiepilogoPagamenti = new VPP_RiepilogoPagamentiSoggiornoNonSaldato();
			break;
		}
		return panelRiepilogoPagamenti;
		
	}
}
