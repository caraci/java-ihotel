/**
 * 
 */
package com.iHotel.view.Event.CreaPrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.model.Utility.MyDate;
import com.iHotel.view.Graphic.CreaPrenotazione.VFCP_SelezionePeriodoTipologie;

/**
 * @author Eugenio
 *
 */
public class RicercaCamereLibereListener extends MouseAdapter {
	/* -------------------- Attributi e Costruttore ----------------------- */
	private VFCP_SelezionePeriodoTipologie _selezionePeriodoTipologie;
	/**
	 * Costruttore.
	 */
	public RicercaCamereLibereListener() {
		super();
		_selezionePeriodoTipologie=VFCP_SelezionePeriodoTipologie.getInstance();
	}
	/* ------------------------ Metodi di instanza ------------------------ */
	
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per avviare la 
	 * ricerca delle camere libere.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		ArrayList<String> tipologieSelezionate = new ArrayList<String>();
		boolean tipologiaStato;
		// Controllo lo stato di tutte le CheckBox per verificare le tipologie inserite dall'utente
		for (int i = 0; i < _selezionePeriodoTipologie.get_checkBoxesTipologie().size(); i++) {
			tipologiaStato=_selezionePeriodoTipologie.get_checkBoxesTipologie().get(i).isSelected();
			if (tipologiaStato) {
				// Aggiungo le tipologie scelte dall'utente
				tipologieSelezionate.add(_selezionePeriodoTipologie.get_checkBoxesTipologie().get(i).getText());
			}	
		}
		// Data inizio
		int annoInizio 	 = _selezionePeriodoTipologie.get_datePanelInizio().getModel().getYear();
		int meseInizio 	 = _selezionePeriodoTipologie.get_datePanelInizio().getModel().getMonth();
		int giornoInizio = _selezionePeriodoTipologie.get_datePanelInizio().getModel().getDay();
		// Data fine
		int annoFine 	 = _selezionePeriodoTipologie.get_datePanelFine().getModel().getYear();
		int meseFine 	 = _selezionePeriodoTipologie.get_datePanelFine().getModel().getMonth();
		int giornoFine 	 = _selezionePeriodoTipologie.get_datePanelFine().getModel().getDay();
		
		// Data inizio
		MyDate dataInizio = new MyDate();
		dataInizio.set(annoInizio, meseInizio, giornoInizio);
		// Data fine
		MyDate dataFine = new MyDate();
		dataFine.set(annoFine, meseFine, giornoFine);		
		// Recupero il controllore e invoco il metodo per cercare le camere libere.
		CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
		gestisciPrenotazione.cercaCamereLibere(dataInizio, dataFine, tipologieSelezionate);
	}
}
