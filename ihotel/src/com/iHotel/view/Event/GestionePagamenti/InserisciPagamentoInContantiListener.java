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
import com.iHotel.model.Pagamento.PagamentoInContanti;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Graphic.GestionePagamenti.VPP_RiepilogoPagamenti_Observer;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe che ha il compito di gestire l'evento click sul bottone "Aggiungi pagamento in contanti"
 * nella classe VPP_gestionePagamento
 * @author Alessandro
 *
 */
public class InserisciPagamentoInContantiListener extends MouseAdapter {
	
	/**
	 * Pannello contenente i pagamenti.
	 */
	private VPP_RiepilogoPagamenti_Observer _riepilogoPagamenti;
	private SoggiornoContextSubject _prenotazione;

	/**
	 * Costruttore con parametri
	 * @param prenotazione E' il soggiorno da mettere come attributo
	 */
	public InserisciPagamentoInContantiListener(SoggiornoContextSubject prenotazione){
		// Recupero il frame dell'applicazione
		ViewFrameApplication viewFrame = ViewFrameApplication.getInstance();
		// Recupero il contentPane del frame.
		JPanel contentPane = (JPanel) viewFrame.getContentPane();
		// Recupero il panel corretto
		_riepilogoPagamenti= (VPP_RiepilogoPagamenti_Observer) contentPane.getComponent(0);
		//Aggiungo la prenotazione come attributo
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
		/*Visualizzo la dialog per l'inserimento delle informazioni sul pagamento. Viene restituito
		 * un oggetto PagamentoInContanti*/
		PagamentoInContanti pagamentoInContanti = UDialogManager.getDialogDatiPagamentoInContanti(importoRimanenteDaPagare);
		//Controllo se il pagamento restituito non è vuoto
		if(pagamentoInContanti!=null){
			/*Recupero il controllore corretto*/
			CGestionePagamenti gestorePagamenti = CGestionePagamenti.getInstance();
			/*Invoco il metodo per l'inserimento della prenotazione al controllore*/
			gestorePagamenti.inserisciPagamentoInSoggiorno(pagamentoInContanti);
			
			// Prendo il pannello dove si va a mostrare la lista dei bonifici
			JPanel panelContanti = _riepilogoPagamenti.getPanelListaPagamentiInContanti();
			// Prendo il layout del pannello
			CardLayout cardLayout = (CardLayout) panelContanti.getLayout();
			// Aggiungo una nuova scheda al pannello.
			panelContanti.add(_riepilogoPagamenti.creaJScrollPanePagamentiContanti());
			// Mostro la prossima scheda
			cardLayout.next(panelContanti);
		}
	}
	

}
