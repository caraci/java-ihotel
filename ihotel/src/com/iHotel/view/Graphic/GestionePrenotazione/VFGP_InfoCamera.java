/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;


import java.util.ArrayList;






import javax.swing.JButton;
import javax.swing.JPanel;

import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.CaricaAggiungiServiziListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_InfoCamera extends View {

	/* ----------------------------- Attributi e costruttore -------------------------------- */
	//Singleton
	private static VFGP_InfoCamera instance=null;
	
	private JButton _btnAggiungiServizi;
	private JButton _btnTornaPrenotazione;
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private VFGP_InfoCamera() {
		super();
	}
	
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
		
		// Assegno l'eventListener al bottone per tornare alla gestione della prenotazione.
		get_btnTornaPrenotazione().addMouseListener(new TornaAllaPrenotazioneListener());
		// Assegno l'eventListener al bottone per mostrare l'interfaccia relativa all'inserimento di nuovi
		// servizi alla prenotazione.
		get_btnTornaPrenotazione().addMouseListener(new CaricaAggiungiServiziListener());
	}
	/* ----------------------------- Getter, Setter ---------------------------------- */
	/**
	 * @return the _btnAggiungiServizi
	 */
	public JButton get_btnAggiungiServizi() {
		return _btnAggiungiServizi;
	}

	/**
	 * @param _btnAggiungiServizi the _btnAggiungiServizi to set
	 */
	public void set_btnAggiungiServizi(JButton _btnAggiungiServizi) {
		this._btnAggiungiServizi = _btnAggiungiServizi;
	}

	/**
	 * @return the _btnTornaPrenotazione
	 */
	public JButton get_btnTornaPrenotazione() {
		return _btnTornaPrenotazione;
	}

	/**
	 * @param _btnTornaPrenotazione the _btnTornaPrenotazione to set
	 */
	public void set_btnTornaPrenotazione(JButton _btnTornaPrenotazione) {
		this._btnTornaPrenotazione = _btnTornaPrenotazione;
	}
}
