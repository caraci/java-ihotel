/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.iHotel.controller.CGestionePagamenti;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamenti;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe che ha il compito di gestire l'evento click sul bottone "Aggiungi pagamento con bonifico"
 * nella classe VPP_gestionePagamento.
 * 
 * @author Alessandro
 *
 */
public class InserisciPagamentoConBonificoListener extends MouseAdapter {
	/**
	 * Pannello contenente i pagamenti.
	 */
	private VPP_RiepilogoPagamenti _riepilogoPagamenti;
	private SoggiornoContextSubject _prenotazione;

	
	//Costruttore
	public InserisciPagamentoConBonificoListener(SoggiornoContextSubject prenotazione) {
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Recupero il contentPane del frame.
		JPanel contentPane = (JPanel) viewFrame.getContentPane();
		// Recupero il panel corretto
		_riepilogoPagamenti= (VPP_RiepilogoPagamenti) contentPane.getComponent(0);
		//Assegno la prenotazione
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
		
		Prezzo importoRimanenteDaPagare = _prenotazione.calcolaImportoRimanenteDaPagare();

		/*Visualizzo la dialog per l'inserimento delle informazioni. Mi viene restituito l'oggetto Pagamento
		costruito con le informazioni inserite dall'utente*/
		PagamentoConBonifico pagamento= UDialogManager.getDialogDatiBonificoBancario(importoRimanenteDaPagare);
		/*Recupero il controllore corretto*/
		CGestionePagamenti gestorePagamenti = CGestionePagamenti.getInstance();
		/*Invoco il metodo per l'inserimento della prenotazione al controllore*/
		gestorePagamenti.inserisciPagamentoInPrenotazione(pagamento);		
		
		// Prendo il pannello dove si va a mostrare la lista dei bonifici
		JPanel panelBonifico = _riepilogoPagamenti.getPanelBonifico();
		// Prendo il layout del pannello
		CardLayout cardLayout = (CardLayout) panelBonifico.getLayout();
		// Aggiungo una nuova scheda al pannello.
		panelBonifico.add(_riepilogoPagamenti.creaPanelEsternoBonifici());
		// Mostro la prossima scheda
		cardLayout.next(panelBonifico);
	}

}
