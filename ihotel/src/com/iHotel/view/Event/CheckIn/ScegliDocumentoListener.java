/**
 * 
 */
package com.iHotel.view.Event.CheckIn;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import com.iHotel.view.Graphic.CheckIn.VFC_AggiungiOspiti_PanelCamera;

/**
 * @author Eugenio
 *
 */
public class ScegliDocumentoListener implements ItemListener {
	/**
	 * Pannello contenente la lista degli ospiti.
	 */
	private VFC_AggiungiOspiti_PanelCamera _panelCamera;
	/**
	 * Costruttore
	 * @param pnlTipoDocumento Pannello contenente i diversi documenti.
	 */
	public ScegliDocumentoListener(VFC_AggiungiOspiti_PanelCamera panelCamera) {
		_panelCamera=panelCamera;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Stringa contenente il nome del documento
		String tipoDocumento = (String) e.getItem();
		// Prendo l'elemento selezionato
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// Ricavo il pannello dove è presente il documento
			JPanel pnlTipoDocumento=_panelCamera.get_pnlTipoDocumento();
			// Recupero il gestore del layout
			CardLayout cardLayout = (CardLayout) pnlTipoDocumento.getLayout();
			// Mostro la scheda corretta.
			cardLayout.show(pnlTipoDocumento, tipoDocumento);
	      }
	}
}
