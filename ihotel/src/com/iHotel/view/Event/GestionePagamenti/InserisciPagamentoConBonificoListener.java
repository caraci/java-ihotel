/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iHotel.controller.CGestionePagamenti;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.view.Graphic.GestionePagamenti.VFP_RiepilogoPagamenti;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe che ha il compito di gestire l'evento click sul bottone "Aggiungi pagamento con bonifico"
 * nella classe VFG_gestionePagamento
 * @author Alessandro
 *
 */
public class InserisciPagamentoConBonificoListener extends MouseAdapter {
	
	private PrenotazioneSubject _prenotazione;
	//Costruttore
	public InserisciPagamentoConBonificoListener(PrenotazioneSubject prenotazione){
		this._prenotazione = prenotazione;
		
	}
	
	/**
	 * Metodo che va ad assegnare una form di inseriemnto alla dialog. Con questa form verranno 
	 * presi in input i dati riguardanti il pagamneto, come la data e l'importo
	 * 
	 * NB va completata la parte di logica
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		//Richiedo la dialog giusta
		PagamentoConBonifico pagamento= UDialogManager.getInstance().getDialogDatiBonificoBancario();
		
		CGestionePagamenti gestorePagamenti = CGestionePagamenti.getInstance();
		gestorePagamenti.inserisciPagamentoInPrenotazione(pagamento, "bonifico");		
		
		VFP_RiepilogoPagamenti view = VFP_RiepilogoPagamenti.getInstance();
		// Prendo il pannello dove si va a mostrare la lista dei bonifici
		JPanel panelBonifico = view.getPanelBonifico();
		// Prendo il layout del pannello
		CardLayout cardLayout = (CardLayout) panelBonifico.getLayout();
		// Aggiungo una nuova scheda al pannello.
		panelBonifico.add(view.creaPanelMiddleCenter());
		// Mostro la prossima scheda
		cardLayout.next(panelBonifico);
	}

}
