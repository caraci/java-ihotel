/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestionePrenotazione.VPGP_AggiungiServiziInterni;

/**
 * Classe addetta alla gestione dell'evento per mostrare le informazioni in merito ad un servizio interno dell'albergo.
 * 
 * @author Eugenio
 */
public class MostraDettagliServizioListener implements ItemListener {

	/* ---------------------- Attributi e Costruttore --------------------- */
	private VPGP_AggiungiServiziInterni _aggiungiServiziInterni;
	/**
	 * Costruttore.
	 */
	public MostraDettagliServizioListener() {
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Recupero il contentPane del frame.
		JPanel contentPane = (JPanel) viewFrame.getContentPane();
		// Recupero il panel corretto
		_aggiungiServiziInterni= (VPGP_AggiungiServiziInterni) contentPane.getComponent(0);
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
