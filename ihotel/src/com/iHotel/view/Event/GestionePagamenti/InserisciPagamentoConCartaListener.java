/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iHotel.controller.CGestionePagamenti;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamenti;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe che ha il compito di gestire il click sul pulsante "Aggiungi pagamento con carta"
 * 
 * @author Alessandro
 *
 */
public class InserisciPagamentoConCartaListener extends MouseAdapter {
	private SoggiornoContextSubject _prenotazione;

	
	//Costruttore
	public InserisciPagamentoConCartaListener(SoggiornoContextSubject prenotazione){
		_prenotazione=prenotazione;
	}
	
	/**
	 * Metodo che va ad assegnare una form di inseriemnto alla dialog. Con questa form verranno 
	 * presi in input i dati riguardanti il pagamneto, come la data e l'importo
	 * 
	 * NB va completata la parte di logica
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		Prezzo importoRimanenteDaPagare = _prenotazione.calcolaTotaleDaPagare();
    	Prezzo importoDaPagareConCarta = UDialogManager.getInstance().getDialogInserimentoImportoPagamentoConCarta(importoRimanenteDaPagare);
    	CGestionePagamenti.getInstance().pagaConCarta(importoDaPagareConCarta);
	}

}
