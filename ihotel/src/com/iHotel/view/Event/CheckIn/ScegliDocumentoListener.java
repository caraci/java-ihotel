/**
 * 
 */
package com.iHotel.view.Event.CheckIn;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

/**
 * @author Eugenio
 *
 */
public class ScegliDocumentoListener implements ItemListener {
	/**
	 * Pannello contente l'insieme delle schede, ognuna delle quali contiene un tipo di documento.
	 */
	private JPanel _pnlInserisciDocumento;
	/**
	 * Costruttore
	 * @param pnlTipoDocumento Pannello contenente i diversi documenti.
	 */
	public ScegliDocumentoListener(JPanel pnlTipoDocumento) {
		_pnlInserisciDocumento=pnlTipoDocumento;
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
			// Recupero il gestore del layout
			CardLayout cardLayout = (CardLayout) _pnlInserisciDocumento.getLayout();
			// Mostro la scheda corretta.
			cardLayout.show(_pnlInserisciDocumento, tipoDocumento);
	      }
	}
}
