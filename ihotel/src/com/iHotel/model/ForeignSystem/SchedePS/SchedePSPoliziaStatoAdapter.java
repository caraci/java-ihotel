/**
 * 
 */
package com.iHotel.model.ForeignSystem.SchedePS;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Persona.Ospite;

/**
 * Classe concreta adattatore al sistema di generazione di schedine di pubblica sicurezza della polizia di stato.
 * 
 * @author Alessandro
 */
public class SchedePSPoliziaStatoAdapter implements ISchedePSAdapter {

	@Override
	public void generaSchedePubblicaSicurezza(SoggiornoContextSubject soggiorno) {
		/*Recupero le camere prenotate*/
		ArrayList<Camera> camerePrenotate = soggiorno.get_camerePrenotate();
		/*Ciclo sulle camere della prenotazione*/
		for (Camera camera : camerePrenotate) {
			/*Per ogni ospite presente nella camera genero la scheda di PS*/
			for (Iterator<Ospite> iterator = camera.getOspitiInPeriodo(soggiorno.get_periodo()).iterator(); iterator.hasNext();) {
				//TODO generare schede di pubblica sicurezza
			}
		}
	}

}
