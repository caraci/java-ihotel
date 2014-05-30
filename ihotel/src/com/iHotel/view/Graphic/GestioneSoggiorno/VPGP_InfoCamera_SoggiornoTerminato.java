/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno;

import java.util.HashMap;

import javax.swing.JButton;

import com.iHotel.view.Event.GestionePrenotazione.CaricaAggiungiServiziListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;

/**
 * Classe che crea la schermata di un soggiorno terminato
 * 
 * @author Alessandro
 *
 */
public class VPGP_InfoCamera_SoggiornoTerminato extends VPGP_InfoCamera {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void creaPanelBottom() {
		/*Setto il testo dei bottoni*/
		_btnAggiungiServizi.setText("Aggiungi servizi");
		_btnTornaPrenotazione.setText("Torna alla prenotazione");
		/*Aggiungo il listener al click sul bottone*/
		_btnAggiungiServizi.addMouseListener(new CaricaAggiungiServiziListener());
		_btnTornaPrenotazione.addMouseListener(new TornaAllaPrenotazioneListener());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo i bottoni alla struttura.
		Bottoni.put(0,_btnTornaPrenotazione);
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
	}

}
