/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_AggiungiServiziInterni;

/**
 * @author Eugenio
 *
 */
public class MostraInformazioniServizioListener extends MouseAdapter {

	/* ---------------------- Attributi e Costruttore --------------------- */
	private VFGP_AggiungiServiziInterni _aggiungiServiziInterni;
	private String _codiceServizio;
	
	public MostraInformazioniServizioListener(String codiceServizio) {
		_aggiungiServiziInterni=VFGP_AggiungiServiziInterni.getInstance();
		_codiceServizio=codiceServizio;
	}
	/* --------------------- Metodi di instanza ----------------------------- */
	@Override
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sulla label relativa ad un servizio.
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO - implementare
	}
}
