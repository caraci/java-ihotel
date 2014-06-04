/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VPP_RiepilogoPagamentiSoggiornoSaldato extends VPP_RiepilogoPagamenti_Observer{

	@Override
	protected void creaPanelTop() {
		// Setto layout
		_panelTop.setLayout(new GridLayout(1,2,0,5));
		//setto la label con il codice della prenotazione
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+ _prenotazione.get_codice());
		_lblStatoPagamento.setText("Stato pagamento: Saldato");
		//aggiungo la label al panelTop
		_panelTop.add(_lblTitoloPrenotazione);
		_panelTop.add(_lblStatoPagamento);
	}
	
	@Override
	protected JPanel creaPanelEsternoContanti(){
		/*Creo un pannello che contiene sia la lista dei pagamenti sia il pulsante per aggiungerne*/
		JPanel panelEsternoContanti = _viewFactory.getPanel(false);
		/*Setto il layout*/
		panelEsternoContanti.setLayout(new BoxLayout(panelEsternoContanti, BoxLayout.Y_AXIS));
		/*Setto il layout al pannello contenente la lista dei pagamenti in contanti*/
		_panelListaPagamentiInContanti.setLayout(new CardLayout());
		/*Aggiungo al pannello contenente la lista dei pagamenti, la lista contenente i pagamenti*/
		_panelListaPagamentiInContanti.add(creaJScrollPanePagamentiContanti());
		/*Aggiungo al pannello esterno il pannello che contiene la lista dei pagamenti*/
		panelEsternoContanti.add(_panelListaPagamentiInContanti);
		/*Restituisco il panello esterno*/
		return panelEsternoContanti;
	}
	
	@Override
	protected JPanel creaPanelEsternoBonifici(){
		/*Creo un pannello che contiene sia la lista dei pagamenti sia il pulsante per aggiungerne*/
		JPanel panelEsternoBonifico = _viewFactory.getPanel(false);
		/*Setto il layout*/
		panelEsternoBonifico.setLayout(new BoxLayout(panelEsternoBonifico, BoxLayout.Y_AXIS));
		/*Setto il layout al pannello contenente la lista dei pagamenti in con bonifico*/
		_panelListaPagamentiConBonifico.setLayout(new CardLayout());
		/*Aggiungo al pannello cntenente la lista dei pagamenti, la lista dei pagamenti*/
		_panelListaPagamentiConBonifico.add(creaJScrollPanePagamentiConBonifici());
		/*Aggiungo al pannello esterno il pannello che contiene la lista dei pagamenti*/
		panelEsternoBonifico.add(_panelListaPagamentiConBonifico);
		/*Restituisco il panello esterno*/
		return panelEsternoBonifico;
	}
	
	@Override
	protected JPanel creaPanelEsternoCarta(){
		/*Creo un pannello che contiene sia la lista dei pagamenti sia il pulsante per aggiungerne*/
		JPanel panelEsternoCarta = _viewFactory.getPanel(false);
		/*Setto il layout*/
		panelEsternoCarta.setLayout(new BoxLayout(panelEsternoCarta, BoxLayout.Y_AXIS));
		/*Setto il layout al pannello contenente la lista dei pagamenti in con bonifico*/
		_panelListaPagamentiConCarta.setLayout(new CardLayout());
		/*Aggiungo al pannello cntenente la lista dei pagamenti, la lista dei pagamenti*/
		_panelListaPagamentiConCarta.add(creaJScrollPanePagamentiCarta());
		/*Aggiungo al pannello esterno il pannello che contiene la lista dei pagamenti*/
		panelEsternoCarta.add(_panelListaPagamentiConCarta);
		/*Restituisco il panello esterno*/
		return panelEsternoCarta;		
	}
	
}
