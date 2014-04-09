/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
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
		// Recupero il controllore e invoco il metodo per avere ulteriori informazioni sul servizio.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		DescrizioneServizioInterno descrizioneServizioInterno = modificaPrenotazione.scegliServizioDaCodice(_codiceServizio);
		// Creo il pannello relativo al servizio attraverso il metodo privato del gestore.
		JPanel panelServizioIntero = creaPanelServizioInterno(descrizioneServizioInterno);
		// Setto il pannello relativo al servizio.
		_aggiungiServiziInterni.set_pnlMiddleRight(panelServizioIntero);
	}
	private JPanel creaPanelServizioInterno(DescrizioneServizioInterno descrizioneServizioInterno) {
		
		return null;
	}
}
