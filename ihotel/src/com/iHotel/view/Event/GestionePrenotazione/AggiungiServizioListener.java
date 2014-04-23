/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import net.sourceforge.jdatepicker.JDatePanel;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.model.Utility.MyDate;
import com.iHotel.utility.UDialogManager;

/**
 * @author Eugenio
 *
 */
public class AggiungiServizioListener extends MouseAdapter {

	private JDatePanel _datePanelServizio;
	private String _codiceServizio;
	
	public AggiungiServizioListener(JDatePanel datePanelServizio, String codiceServizio) {
		_datePanelServizio=datePanelServizio;
		_codiceServizio=codiceServizio;
	}
	/* --------------------- Metodi di instanza ------------------ */
	@Override
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click, per aggiungere un servizio alla prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		// Recupero la data del servizio
		int anno 	 = _datePanelServizio.getModel().getYear();
		int mese 	 = _datePanelServizio.getModel().getMonth();
		int giorno   = _datePanelServizio.getModel().getDay();
		// Data Servizio
		MyDate dataServizio = new MyDate();
		dataServizio.set(anno, mese, giorno);		
		// Invoco il metodo al controllore
		modificaPrenotazione.aggiungiServizio(dataServizio, _codiceServizio);
		// Mostro la dialog per confermare l'inserimento del servizio nella prenotazione.		
		UDialogManager.getInstance().showDialogConfermaInserimentoServizio();
	}

}
