/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;


import java.util.ArrayList;


import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_InfoCamera extends View {

	/* ----------------------------- Attributi e costruttore -------------------------------- */
	//Singleton
	private static VFGP_InfoCamera instance=null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private VFGP_InfoCamera() {}
	
	/* ------------------------- Metodi di classe ---------------------------- */
	
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton
	 */
	public static VFGP_InfoCamera getInstance() {
    	if(instance == null) {
            instance = new VFGP_InfoCamera();
         }
         return instance;
    }
	/* -------------------------- Metodi di instanza -------------------------- */
	/**
	 * Metodo per mostrare l'interfaccia relativa alle informazioni della camera, in una prenotazione.
	 * @param camera Camera da visualizzare.
	 * @param serviziEsterni Servizi esterni della camera.
	 */
	public void creaFrame(CameraContext camera, ArrayList<ServizioEsterno> serviziEsterni) {
		
	}
}
