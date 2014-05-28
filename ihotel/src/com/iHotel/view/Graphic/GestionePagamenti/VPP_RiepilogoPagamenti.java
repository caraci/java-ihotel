/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Pagamento.PagamentoInContanti;
import com.iHotel.view.ViewPanelContentPane;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConBonificoListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConCartaListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoInContantiListener;
import com.iHotel.view.Utility.UtoListPanel;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VPP_RiepilogoPagamenti extends ViewPanelContentPane {
	
	/**
	 * Prenotazione di cui si mostrano le informazioni.
	 */
	private SoggiornoContextSubject _prenotazione;	
	/**
	* Lista contenente i pagamenti in contanti della prenotazione.
	*/
	private ArrayList<PagamentoInContanti> _pagamentiInContanti = new ArrayList<PagamentoInContanti>();
	/**
	* Lista contenente i pagamenti mediante bonifici della prenotazione.
	*/
	private ArrayList<PagamentoConBonifico> _pagamentiConBonifico = new ArrayList<PagamentoConBonifico>();
	/**
	* Lista contenente i pagamenti mediante carta della prenotazione.
	*/
	private ArrayList<PagamentoConCarta> _pagamentiConCarta = new ArrayList<PagamentoConCarta>();
	
	
	/*JPanel*/
	private JPanel _panelMiddleTop, _panelMiddleBottom,_panelContanti, _panelCartaDiCredito, _panelBonifico, _panelBottonePagaContanti;
	
	/*JLabel*/
	private JLabel _lblTitoloCarta, _lblTotaleEImportoVersatoPrenotazione;
	
	/*JButton*/
	private JButton _btnAggiungiPagamentoConCarta, _btnAggiungiPagamentoInContanti, _btnAggiungiPagamentoConBonifico;
 

	public VPP_RiepilogoPagamenti() {
		/*JPanel*/
		_panelContanti = _viewFactory.getPanel();
		_panelCartaDiCredito = _viewFactory.getPanel();
		_panelMiddleTop = _viewFactory.getPanel();
		_panelMiddleBottom = _viewFactory.getPanel();
		_panelBonifico = _viewFactory.getPanel();
		_panelBottonePagaContanti=_viewFactory.getPanel();
		
		
		
		/*JLabel*/
		_lblTitoloCarta = _viewFactory.getLabel();
		_lblTotaleEImportoVersatoPrenotazione = _viewFactory.getLabel();
		
		/*JButton*/
		_btnAggiungiPagamentoConCarta = _viewFactory.getButton();
		_btnAggiungiPagamentoConBonifico = _viewFactory.getButton();
		_btnAggiungiPagamentoInContanti = _viewFactory.getButton();

	}
	
	/* -------------------------- Metodi di istanza ----------------------------- */

	@Override
	protected void creaPanelTop() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void creaPanelMiddle() {
		
		//SEtto il layout. Borderlayout perchè la pagina è divisa in 2 righe orizzontali, ma di dimensioni diverse.
		_panelMiddle.setLayout(new BorderLayout());		
		
		//Creo i pannelli top e bottom
		_panelMiddle.add(creaPanelMiddleTop(), BorderLayout.PAGE_START);
		_panelMiddle.add(creaPanelMiddleBottom(), BorderLayout.CENTER);
		
		
	}
	/**
	 * Metodo privato che serve a costruire la riga superiore del pannello di metà pagina
	 * 
	 * @return Il pannello con le informazioni sulla prenotazione
	 */
	private JPanel creaPanelMiddleTop(){
		
		/*Setto il testo della label*/
		_lblTotaleEImportoVersatoPrenotazione.setText(UtoListPanel.getInstance().totalePrenotazioneToString(_prenotazione));
		/*Aggiungo la label al pannello*/
		_panelMiddleTop.add(_lblTotaleEImportoVersatoPrenotazione);
		/*Restituisco il pannello*/
		return _panelMiddleTop;
		
	}
	/**
	 * Metodo che prepara il pannello contenente le infomazioni sugli acconti
	 * 
	 * @return Il pannello contenente le informazioni sugli acconti
	 */
	private JPanel creaPanelMiddleBottom(){
		//Setto il layout del panel middleBottom
		_panelMiddleBottom.setLayout(new GridLayout(1, 3, 5, 0));
		
		/*invoco i 3 metodi privati che mi consentono di creare i pannelli con le informazioni sugli acconti*/
		
		_panelContanti.setLayout(new CardLayout());
		_panelBonifico.setLayout(new CardLayout());
		_panelCartaDiCredito.setLayout(new CardLayout());
		
		
		// Aggiungo le schede
		// Creo un pannello ausiliario per i pagamenti in contanti, in cui inserisco lo scrollpane ed 
		//il punsalte per aggiungere pagamenti
		_panelContanti.add(creaPanelEsternoContanti());
		
		
		// Creo un pannello ausiliario per i pagamenti in contanti, in cui inserisco lo scrollpane ed 
		//il punsalte per aggiungere pagamenti
		
		/*Aggiungo il pannello ausiliario al pannello dei pagamenti in contanti*/
		_panelBonifico.add(creaPanelEsternoBonifici());
				
		
		// Creo un pannello ausiliario per i pagamenti con carta, in cui inserisco lo scrollpane ed 
		//il punsalte per aggiungere pagamenti
		JPanel auxCarta = _viewFactory.getPanel();
		auxCarta.setLayout(new BoxLayout(auxCarta,BoxLayout.Y_AXIS));
		auxCarta.add(creaJScrollPanePagamentiCarta());
		auxCarta.add(_btnAggiungiPagamentoConCarta);
		/*Aggiungo il pannello ausiliario al pannello dei pagamenti in contanti*/
		_panelCartaDiCredito.add(auxCarta);
		
		
		
		/*aggiungo i pannelli al pannello centrale*/
		_panelMiddleBottom.add(_panelContanti);
		_panelMiddleBottom.add(_panelBonifico);
		_panelMiddleBottom.add(_panelCartaDiCredito);
		
		/*Setto la dimensione dei bottoni*/
		_btnAggiungiPagamentoInContanti.setPreferredSize(new Dimension(30,30));
		_btnAggiungiPagamentoConBonifico.setPreferredSize(new Dimension(30,30));
		_btnAggiungiPagamentoConCarta.setPreferredSize(new Dimension(30,30));
		
		_btnAggiungiPagamentoInContanti.addMouseListener(new InserisciPagamentoInContantiListener());
		_btnAggiungiPagamentoConCarta.addMouseListener(new InserisciPagamentoConBonificoListener());
		_btnAggiungiPagamentoConCarta.addMouseListener(new InserisciPagamentoConCartaListener(_prenotazione));
		/*Setto il testo dei bottoni*/
		_btnAggiungiPagamentoInContanti.setText("Aggiungi Pagamento in contanti");
		_btnAggiungiPagamentoConBonifico.setText("Aggiungi pagamento con bonifico");
		_btnAggiungiPagamentoConCarta.setText("Aggiungi pagamento con carta");
		
		//_panelMiddleBottom.add(_panelBottonePagaContanti);
		return _panelMiddleBottom;
	}
	@Override
	protected void creaPanelBottom() {
				
		/*
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(0, _btnTornaPrenotazione);
		Bottoni.put(5,_btnTerminaCheckin);
		Bottoni.put(,_btnTerminaCheckin);
		*/
		
		// Creo la pulsantiera.
		Integer numeroColonne = 7;
		//creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
		
	}
	/**
	 * Metodo che crea il pannello laterale a sinistra
	 * 
	 * @return Lo scroll pane contenente i pagamenti in contanti
	 */
	public JScrollPane creaJScrollPanePagamentiContanti(){
		
		//Recupero i pagamenti
		recuperaPagamenti();
		//Creo un JScrollPane
		JScrollPane scrollPaneContanti = _viewFactory.getScrollPane();
		//Creo un pannello
		JPanel panelContanti = _viewFactory.getPanel();
		//Assegno il layout
		panelContanti.setLayout(new BoxLayout(panelContanti, BoxLayout.Y_AXIS));
		//Assegno il titolo
		JLabel lblTitoloContanti = _viewFactory.getLabel();
		lblTitoloContanti.setText("Contanti:");
		//Assegno il titolo al pannello
		panelContanti.add(lblTitoloContanti);
		
		//Ora recupero i pagamenti in contanti		
		if (_pagamentiInContanti!=null){
			for (Iterator<PagamentoInContanti> iterator = _pagamentiInContanti.iterator(); iterator
					.hasNext();) {
				PagamentoInContanti pagamentoInContanti = iterator.next();
				//Creo una label per l'importo
				JLabel labelImporto = _viewFactory.getLabel();
				//Setto il testo della label
				labelImporto.setText("Importo: "+String.valueOf(pagamentoInContanti.get_importo().get_importo())+ " "+ pagamentoInContanti.get_importo().get_valuta());
				//Aggiungo la label al pannello insieme ad un separatore
				panelContanti.add(labelImporto);
				
				//Creo una label per la data
				JLabel labelData = _viewFactory.getLabel();
				//Setto il testo
				labelData.setText("Data bonifico: "+ pagamentoInContanti.get_data().get_giorno() + " - "+pagamentoInContanti.get_data().get_mese()+ " - "+pagamentoInContanti.get_data().get_anno());
				//Aggiungo la label
				panelContanti.add(labelData);
				
			}
		}	
		
		/*Setto la viewport dello scrollpane*/
		scrollPaneContanti.setViewportView(panelContanti);
		
		//Restituisco il pannello
		return scrollPaneContanti;
		
	}
	/**
	 * Metodo che crea il pannello centrale con tutti i bonifici effettuati
	 * @return 	_panelBonifico E' il pannello centrale con tutti bonifici effettuati
	 */
	public JScrollPane creaJScrollPanePagamentiConBonifici(){
		
		//Invoco il metodo per recuperare i pagamenti
		recuperaPagamenti();
		//Creo un JScrollPane
		JScrollPane scrollPaneBonifico = _viewFactory.getScrollPane();
		//Creo un pannello
		JPanel panelBonifico = _viewFactory.getPanel();
		//Aggiungo il layout al pannello
		panelBonifico.setLayout(new BoxLayout(panelBonifico,BoxLayout.PAGE_AXIS));
		//Aggiongo la label con il titolo al pannello
		JLabel lblTitoloBonifico = _viewFactory.getLabel();
		lblTitoloBonifico.setText("Bonifici:");		
		panelBonifico.add(lblTitoloBonifico);
		panelBonifico.add(_viewFactory.getSeparator());
		
		//Ora recupero i pagamenti tramite bonifico bancario		
		if (_pagamentiConBonifico!=null){
			for (Iterator<PagamentoConBonifico> iterator = _pagamentiConBonifico.iterator(); iterator
					.hasNext();) {
				PagamentoConBonifico pagamentoConBonifico =  iterator.next();
				//Creo una label per l'importo
				JLabel labelImporto = _viewFactory.getLabel();
				//Setto il testo della label
				labelImporto.setText("Importo: "+String.valueOf(pagamentoConBonifico.get_importo().get_importo())+ " "+ pagamentoConBonifico.get_importo().get_valuta());
				//Aggiungo la label al pannello insieme ad un separatore
				panelBonifico.add(labelImporto);
				
				//Creo una label per il mittente
				JLabel labelMittente = _viewFactory.getLabel();
				//Setto il testo
				labelMittente.setText("Mittente: "+ pagamentoConBonifico.get_mittente().get_nome()+ " "+ pagamentoConBonifico.get_mittente().get_cognome());
				//Aggiungo la label
				panelBonifico.add(labelMittente);
				
				//Creo una label per la data
				JLabel labelData = _viewFactory.getLabel();
				//Setto il testo
				labelData.setText("Data bonifico: "+ pagamentoConBonifico.get_data().get_giorno() + " - "+pagamentoConBonifico.get_data().get_mese()+ " - "+pagamentoConBonifico.get_data().get_anno());
				//Aggiungo la label
				panelBonifico.add(labelData);
				panelBonifico.add(_viewFactory.getSeparator());
			}
		}
		
		/*Setto la viewport dello scrollpane*/
		
		scrollPaneBonifico.setViewportView(panelBonifico);
		//restitiuisco il pannello con il bonifici
		return scrollPaneBonifico;
	}
	/**
	 * Metodo che crea il pannello destro con le informazioni sui versamenti effettuati da carta di credito
	 * @return 	_panelCartaDiCredito E' il pannello contenente le informazioni  con i versamenti effettuati 
	 * 			da carta di credito
	 */
	public JScrollPane creaJScrollPanePagamentiCarta(){
		//Invoco il metodo per recuperare i pagamenti
		recuperaPagamenti();
		//Creo un JScrollPane
		JScrollPane scrollPaneCarta = _viewFactory.getScrollPane();
		//Creo un pannello
		JPanel panelCarta = _viewFactory.getPanel();
		//Aggiungo il layout al pannello
		panelCarta.setLayout(new BoxLayout(panelCarta,BoxLayout.PAGE_AXIS));
		//Aggiongo la label con il titolo al pannello
		JLabel lblTitoloCarta= _viewFactory.getLabel();
		lblTitoloCarta.setText("Prelevamenti con carta:");		
		panelCarta.add(lblTitoloCarta);
		panelCarta.add(_viewFactory.getSeparator());
		
		//Ora recupero i pagamenti tramite bonifico bancario		
		if (_pagamentiConCarta!=null){
			for (Iterator<PagamentoConCarta> iterator = _pagamentiConCarta.iterator(); iterator
					.hasNext();) {
				PagamentoConCarta pagamentoConCarta =  iterator.next();
				//Creo una label per l'importo
				JLabel labelImporto = _viewFactory.getLabel();
				//Setto il testo della label
				labelImporto.setText("Importo: "+String.valueOf(pagamentoConCarta.get_importo().get_importo())+ " "+ pagamentoConCarta.get_importo().get_valuta());
				//Aggiungo la label al pannello insieme ad un separatore
				panelCarta.add(labelImporto);
								
			}
		}
		
		/*Setto la viewport dello scrollpane*/
		
		scrollPaneCarta.setViewportView(panelCarta);
		//restitiuisco il pannello con il bonifici
		return scrollPaneCarta;
	}
	/**
	 * Metodo privato che restituisce la mappa dei pagamenti della prenotazione
	 */
	private void recuperaPagamenti(){
		
		//Svuoto l'array dei pagamenti
		this._pagamentiInContanti.clear();
		this._pagamentiConBonifico.clear();
		/*Se la mappa della classe è vuota vado a chiedere alla prenotazione la mappa dei pagamenti e setto la mappa
		della schermata attuale con quella recuperata. Se non è vuota vuol dire che l'avevo già caricata*/
			
		ArrayList<Pagamento> pagamenti =_prenotazione.get_pagamenti();
		if (pagamenti !=null){
			for (Iterator<Pagamento> iterator = pagamenti.iterator(); iterator.hasNext();) {
				Pagamento pagamento = (Pagamento) iterator.next();
				String nomeClasse= pagamento.getClass().getSimpleName();
				switch (nomeClasse) {
				case "PagamentoInContanti":
					this._pagamentiInContanti.add((PagamentoInContanti)pagamento);
					break;
				case "PagamentoConBonifico":
					this._pagamentiConBonifico.add((PagamentoConBonifico)pagamento);
					break;
				case"PagamentoConCarta":
					this._pagamentiConCarta.add((PagamentoConCarta)pagamento);
				default:
					break;
				}		
			}
		}
	}
	public void creaPanel(SoggiornoContextSubject prenotazione){
		//Setto l'attributo prenotazione con il riferimento passato come parametro
		_prenotazione = prenotazione;
		//Recupero i pagamenti della prenotazione
		//this.recuperaPagamenti();
		
		//Creo il pannello centrale
		
		/* ATTENZIONE MANCANO I METODI PER CREARE PANNELLO SUPERIORE ED INFERIORE*********************************************/
		creaPanelMiddle();
	}
	
	public JPanel getPanelBonifico(){
		return this._panelBonifico;
	}
	
	public JPanel getPanelContanti(){
		return this._panelContanti;
	}	
	
	/**
	 * 
	 * @return
	 */
	public JPanel creaPanelEsternoContanti(){
		JPanel auxContanti = _viewFactory.getPanel();
		auxContanti.setLayout(new BoxLayout(auxContanti,BoxLayout.Y_AXIS));
		auxContanti.add(creaJScrollPanePagamentiContanti());
		auxContanti.add(_btnAggiungiPagamentoInContanti);
		/*Aggiungo il pannello ausiliario al pannello dei pagamenti in contanti*/
		return auxContanti;
	}
	
	public JPanel creaPanelEsternoBonifici(){
		JPanel auxBonifici = _viewFactory.getPanel();
		auxBonifici.setLayout(new BoxLayout(auxBonifici,BoxLayout.Y_AXIS));
		auxBonifici.add(creaJScrollPanePagamentiConBonifici());
		auxBonifici.add(_btnAggiungiPagamentoConBonifico);
		return auxBonifici;
	}
}
