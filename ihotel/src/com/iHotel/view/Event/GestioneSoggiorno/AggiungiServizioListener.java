/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




import net.sourceforge.jdatepicker.JDatePanel;

import com.iHotel.controller.CModificaSoggiorno;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe addetta alla gestione dell'evento per aggiungere un servizio alla prenotazione.
 * 
 * @author Eugenio
 */
public class AggiungiServizioListener extends MouseAdapter {

	/**
	 * Pannello relativo alla data del servizio.
	 */
	private JDatePanel _datePanelServizio;
	
	/**
	 * Costruttore.
	 * @param datePanelServizio Panel relativo al servizio da aggiungere.
	 * @param codiceServizio Codice del servizio da aggiungere.
	 */
	public AggiungiServizioListener(JDatePanel datePanelServizio, String codiceServizio) {
		_datePanelServizio=datePanelServizio;
	}
	/* --------------------- Metodi di instanza ------------------ */
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click, per aggiungere un servizio alla prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore.
		CModificaSoggiorno modificaSoggiorno = CModificaSoggiorno.getInstance();
		// Recupero la data del servizio
		int anno 	 = _datePanelServizio.getModel().getYear();
		int mese 	 = _datePanelServizio.getModel().getMonth();
		int giorno   = _datePanelServizio.getModel().getDay();
		// Data Servizio
		Giorno dataServizio = new Giorno(giorno, mese, anno);
		// Controllo che la data sia inclusa nel periodo della prenotazione
		if (modificaSoggiorno.get_soggiorno().get_periodo().contieneData(dataServizio)) {
			// Invoco il metodo al controllore
			//modificaPrenotazione.aggiungiServizio(dataServizio, _codiceServizio);
			// Mostro la dialog per confermare l'inserimento del servizio nella prenotazione.		
			UDialogManager.showDialogConfermaInserimentoServizio();
		} else {
			// TODO - Decidere come gestire un inserimento di data errato.
		}
		
	}

}
