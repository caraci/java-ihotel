/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CGestionePagamenti;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;


/**
 * Classe che ha il compito di gestire l'evento di click sul pulsante per la gestione del pagamento
 * 
 * @author Alessandro
 *
 */
public class GestisciPagamentoListener extends MouseAdapter {
	
	/**
	 * Il listener ha la maniglia alla prenotazione
	 */
	private SoggiornoContextSubject _prenotazione;
	
	/**
	 * Costruttore
	 * @param prenotazione Prenotazione della quale si stanno gestendo i pagamenti
	 */
	public GestisciPagamentoListener(SoggiornoContextSubject prenotazione){
		_prenotazione = prenotazione;
	}
	
	/**
	 * Metodo che ha il compito di gestire l'evento click sul pulsante "Gestione Pagamenti"
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		/*Recuper il controllore che si occupa di gestire i pagamenti*/
		CGestionePagamenti gestorePagamenti = CGestionePagamenti.getInstance();
		/*Invoco il metodo per la gestione dei pagamenti al controllore*/
		gestorePagamenti.gestisciPagamentiPrenotazione(_prenotazione);
	}
	
}
