/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_AggiungiServiziInterni;

/**
 * Classe addetta alla gestione dell'evento per mostrare le informazioni in merito ad un servizio interno dell'albergo.
 * 
 * @author Eugenio
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
		/*if (e.getStateChange() == ItemEvent.SELECTED) {
			// Pannello a cui è associato il card Layout
			JPanel panelServizi = _aggiungiServiziInterni.get_pnlMiddleRight();
			*/// Recupero il descrittore del servizio.
			//DescrizioneServizioInterno descrizioneServizioInterno=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaNome(nomeServizioInterno);
			//return descrizioneServizioInterno;
			/*// Aggiungo una scheda al pannello.
			panelServizi.add(_aggiungiServiziInterni.creaPanelDescrittore(descrizioneServizioInterno));
			// Ricavo il gestore del layout.
			CardLayout cardLayout = (CardLayout) panelServizi.getLayout();
			// Mostro la prossima scheda, ovvero quella riferita al nuovo servizio
			cardLayout.next(panelServizi);
			// Rimuovo il pannello precedente.
			panelServizi.remove(panelServizi.getComponent(0));
			
	      }*/
	}
}
