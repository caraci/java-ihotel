/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione.CreaPrenotazione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.iHotel.controller.CCreaRichiestaSoggiorno;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestioneSoggiorno.CreaRichiestaSoggiorno.VPCP_SelezionePeriodoTipologie;

/**
 * Classe addetta alla gestione dell'evento per ricercare le camere libere per l'inserimento di una nuova prenotazione.
 * 
 * @author Eugenio
 */
public class RicercaCamereLibereListener extends MouseAdapter {
	/* -------------------- Attributi e Costruttore ----------------------- */
	private VPCP_SelezionePeriodoTipologie _selezionePeriodoTipologie;
	/**
	 * Costruttore.
	 */
	public RicercaCamereLibereListener() {
		super();
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Recupero il contentPane del frame.
		JPanel contentPane = (JPanel) viewFrame.getContentPane();
		// Recupero il panel corretto
		_selezionePeriodoTipologie= (VPCP_SelezionePeriodoTipologie) contentPane.getComponent(0);
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
		Giorno dataInizio = new Giorno(giornoInizio,meseInizio,annoInizio);
		// Data fine
		Giorno dataFine = new Giorno(giornoFine, meseFine, annoFine);
		// Controllo che la data di fine sia maggiore della data di inizio 
		if (dataFine.toMyDate().compareTo(dataInizio.toMyDate())==1) {
			// Recupero il controllore e invoco il metodo per cercare le camere libere.
			CCreaRichiestaSoggiorno gestisciPrenotazione = CCreaRichiestaSoggiorno.getInstance();
			gestisciPrenotazione.cercaCamereLibere(dataInizio, dataFine, tipologieSelezionate);
		} else {
			// TODO - Decidere come gestire un inserimento di data errato.
		}
		
	}
}
