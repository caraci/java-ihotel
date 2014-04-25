/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_AggiungiServiziInterni;

/**
 * @author Eugenio
 *
 */
public class MostraDettagliServizioListener implements ItemListener {

	/* ---------------------- Attributi e Costruttore --------------------- */
	private VFGP_AggiungiServiziInterni _aggiungiServiziInterni;
	/**
	 * Costruttore.
	 */
	public MostraDettagliServizioListener() {
		_aggiungiServiziInterni=VFGP_AggiungiServiziInterni.getInstance();
	}
	
	/**
	 * Con questo metodo si va a gestire l'evento scaturito a seguito della selezione di un elemento della 
	 * lista dei servizi interni.
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Stringa contenente il nome del servizio interno
		String nomeServizioInterno = (String) e.getItem();
		// Prendo l'elemento selezionato
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// Recupero il descrittore del servizio.
			DescrizioneServizioInterno descrizioneServizioInterno=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaNome(nomeServizioInterno);
			// Aggiungo una scheda al pannello.
			_aggiungiServiziInterni.get_pnlMiddleRight().add(_aggiungiServiziInterni.creaPanelDescrittore(descrizioneServizioInterno));
			// Ricavo il gestore del layout.
			CardLayout cardLayout= (CardLayout) _aggiungiServiziInterni.get_pnlMiddleRight().getLayout();
			// Mostro la prossima scheda, ovvero quella riferita al nuovo servizio
			cardLayout.next(_aggiungiServiziInterni.get_pnlMiddleRight());
	      }
	}
}
