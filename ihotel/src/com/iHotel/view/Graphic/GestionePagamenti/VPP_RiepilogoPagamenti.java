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
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Pagamento.PagamentoInContanti;
import com.iHotel.view.ViewPanelContentPane;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConBonificoListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConCartaListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoInContantiListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;

/**
 * Classe che ha il compito di visualizzare tutti i pagamenti effettuati per un soggiorno
 * 
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VPP_RiepilogoPagamenti extends ViewPanelContentPane implements IObserver {
	
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
		/**
	 * Pannelli contenenti le liste dei pagamenti
	 */
	private JPanel _panelListaPagamentiInContanti,_panelListaPagamentiConBonifico, _panelListaPagamentiConCarta;
	
	/**
	 * Altri pannelli
	 */
	private JPanel _panelMiddleTop, _panelMiddleBottom;
	/*JLabel*/
	public JLabel  _lblTotaleImportoVersato, _lblTotaleImportoSoggiorno, _lblTotaleImportoRimanente, _lblTitoloPrenotazione;
	
	/*JButton*/
	private JButton _btnTornaPrenotazione;
 

	public VPP_RiepilogoPagamenti() {
		/*JPanel*/
		
		//Pannelli con liste pagamenti
		_panelListaPagamentiInContanti = _viewFactory.getPanel();
		_panelListaPagamentiConBonifico= _viewFactory.getPanel();
		_panelListaPagamentiConCarta= _viewFactory.getPanel();
		//Altri pannelli
		_panelMiddleTop = _viewFactory.getPanel();
		_panelMiddleBottom = _viewFactory.getPanel();
			
		/*JLabel*/
		_lblTotaleImportoVersato = _viewFactory.getLabel();
		_lblTotaleImportoSoggiorno = _viewFactory.getLabel();
		_lblTotaleImportoRimanente = _viewFactory.getLabel();
		_lblTitoloPrenotazione = _viewFactory.getLabel();
		
		/*JButton*/
		_btnTornaPrenotazione = _viewFactory.getButton();

	}
	
	/* -------------------------- Metodi di istanza ----------------------------- */

	@Override
	protected void creaPanelTop() {
		//setto la label con il codice della prenotazione
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+ _prenotazione.get_codice());
		//aggiungo la label al panelTop
		_panelTop.add(_lblTitoloPrenotazione);
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
		/*Setto il layout*/
		_panelMiddleTop.setLayout(new GridLayout(1,3,5,5));
		
		/*Setto il testo delle label*/
		_lblTotaleImportoSoggiorno.setText("L'importo totale della prenotazione è: " + String.valueOf(_prenotazione.calcolaCostoTotaleSoggiorno().get_importo()));
		_lblTotaleImportoVersato.setText("L'importo totale dei versamenti effettuati è: "+ String.valueOf(_prenotazione.get_importoTotalePagamenti().get_importo()));
		_lblTotaleImportoRimanente.setText("Importo rimanente da pagare è: "+ String.valueOf(_prenotazione.calcolaImportoRimanenteDaPagare().get_importo()));
		/*Aggiungo le label al pannello*/
		_panelMiddleTop.add(_lblTotaleImportoSoggiorno);
		_panelMiddleTop.add(_lblTotaleImportoVersato);
		_panelMiddleTop.add(_lblTotaleImportoRimanente);
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
		
		/*aggiungo i pannelli al pannello centrale*/
		_panelMiddleBottom.add(creaPanelEsternoContanti());
		_panelMiddleBottom.add(creaPanelEsternoBonifici());
		_panelMiddleBottom.add(creaPanelEsternoCarta());		
		

		return _panelMiddleBottom;
	}
	@Override
	protected void creaPanelBottom() {		
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		//Setto il testo del bottone
		_btnTornaPrenotazione.setText("Torna alla prenotazione");
		/*Aggiungo il listener al click sul pulsante*/
		_btnTornaPrenotazione.addMouseListener(new TornaAllaPrenotazioneListener());
		// Aggiungo il bottone alla struttura.
		Bottoni.put(0, _btnTornaPrenotazione);
				
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
		
	}
	/**
	 * Metodo che crea il pannello laterale a sinistra
	 * 
	 * @return Lo scroll pane contenente i pagamenti in contanti
	 */
	public JScrollPane creaJScrollPanePagamentiContanti(){
		_pagamentiInContanti.clear();
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
				labelData.setText("Data pagamento in contanti: "+ pagamentoInContanti.get_data().get_giorno() + " - "+pagamentoInContanti.get_data().get_mese()+ " - "+pagamentoInContanti.get_data().get_anno());
				//Aggiungo la label
				panelContanti.add(labelData);
				
			}
		}	
		
		/*Setto la viewport dello scrollpane*/
		scrollPaneContanti.setViewportView(panelContanti);
		
		/**/
		return scrollPaneContanti;
	
		
	}
	/**
	 * Metodo che crea il pannello centrale con tutti i bonifici effettuati
	 * @return 	_panelBonifico E' il pannello centrale con tutti bonifici effettuati
	 */
	public JScrollPane creaJScrollPanePagamentiConBonifici(){
		_pagamentiConBonifico.clear();
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
		_pagamentiConCarta.clear();
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
					break;
				default:
					break;
				}		
			}
		}
	}
	
	/**
	 * Metodo che crea il pannello contenente tutti i pagamenti effettuati per il soggiorno passato come parametro
	 * 
	 * @param prenotazione E' il soggiorno per cui sono stati effettuati/si vogliono effettuare pagamenti
	 */
	public void creaPanel(SoggiornoContextSubject prenotazione){
		//Setto l'attributo prenotazione con il riferimento passato come parametro
		_prenotazione = prenotazione;
		//Creo il pannello centrale
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
		/* ATTENZIONE MANCANO I METODI PER CREARE PANNELLO SUPERIORE ED INFERIORE*********************************************/
		
	}	
	
	/**
	 * Metodo che restituisce il pulsante per l'aggiunta di un pagamento in contanti
	 * 
	 * @return	 pulsante per aggiungere un pagamento in contanti
	 */
	private JButton creaPulsanteAggiungiPagamentoInContanti(){
		/*Creo un pulsante gli setto le dimensioni ed il testo*/
		JButton btnAggiungiPagamentoInContanti = _viewFactory.getButton();
		btnAggiungiPagamentoInContanti.setPreferredSize(new Dimension(30,30));
		btnAggiungiPagamentoInContanti.setText("Aggiungi Pagamento in contanti");
		/*Aggiungo il listener all'evento*/
		btnAggiungiPagamentoInContanti.addMouseListener(new InserisciPagamentoInContantiListener(_prenotazione));
				
		/*Restituisco il pulsante*/
		return btnAggiungiPagamentoInContanti;
	}
	
	/**
	 * Metodo che restituisce il pannello contenente lo scrollpane con i pagamenti con bonifici
	 * ed il bottone per aggiungere un pagamento con bonifico
	 * 
	 * @return Pulsante per aggiungere pagamenti con bonifico
	 */
	private JButton creaPulsanteAggiungiPagamentoConBonifico(){
		/*Creo il pulsante e gli setto le dimensioni ed il testo*/
		JButton btnAggiungiPagamentoConBonifico = _viewFactory.getButton();
		btnAggiungiPagamentoConBonifico.setPreferredSize(new Dimension(30,30));
		btnAggiungiPagamentoConBonifico.setText("Aggiungi pagamento con bonifico");
		/*Aggiungo il listener all'evento*/
		btnAggiungiPagamentoConBonifico.addMouseListener(new InserisciPagamentoConBonificoListener(_prenotazione));
		
		/*Restituisco il pulsante*/
		return btnAggiungiPagamentoConBonifico;
	}
	
	/**
	 * Metodo che restiutuisce il pulsante per aggiungere pagamenti con carta
	 * 
	 * @return Pulsante per aggiungere pagamenti con carta
	 */
	private JButton creaPulsanteAggiungiPagamentoConCarta(){
		/*creo il pulsante e gli setto la dimensione ed il testo */
		JButton btnAggiungiPagamentoConCarta = _viewFactory.getButton();		
		btnAggiungiPagamentoConCarta.setPreferredSize(new Dimension(30,30));
		btnAggiungiPagamentoConCarta.setText("Aggiungi pagamento con carta");
		/*Setto il listener al click sul pulsante*/
		btnAggiungiPagamentoConCarta.addMouseListener(new InserisciPagamentoConCartaListener(_prenotazione));
		
		/*Restituisco il pulsante*/
		return btnAggiungiPagamentoConCarta;
	}
	/**
	 * Metodo che restituisce il pannello con i pagamenti in contanti
	 * 
	 * @return Pannello con pagamenti in contanti
	 */
	public JPanel getPanelListaPagamentiInContanti(){
		return _panelListaPagamentiInContanti;
	}
	
	/**
	 * Metodo che restituisce il pannello con i pagamenti tramite bonifici
	 * 
	 * @return Pannello con pagmaenti in bonifici
	 */
	public JPanel getPanelListaPagamentiConBonifico(){
		return _panelListaPagamentiConBonifico;
	}
	/**
	 * Metodo che restituisce il pannello con i pagamenti tramite carta di credito
	 * 
	 * @return Pannello con pagamenti con carta di creditp
	 */
	public JPanel getPanelListaPagamentiConCarta(){
		return _panelListaPagamentiConCarta;
	}

	@Override
	public void Update() {
		_lblTotaleImportoSoggiorno.setText("L'importo totale della prenotazione è:"+ String.valueOf(_prenotazione.calcolaCostoTotaleSoggiorno().get_importo()));
		_lblTotaleImportoVersato.setText("L'importo totale dei versamenti effettuati è: "+ String.valueOf(_prenotazione.get_importoTotalePagamenti().get_importo()));
		_lblTotaleImportoRimanente.setText("Importo rimanente da pagare è: "+ String.valueOf(_prenotazione.calcolaImportoRimanenteDaPagare().get_importo()));
				
	}
	
	/**
	 * Metodo che costruisce il pannello esterno dei pagamenti in contanti
	 * 
	 * @return Pannello contenente sia la lista dei pagamenti in contanti che il pulsante per aggiungerne altri
	 */
	private JPanel creaPanelEsternoContanti(){
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
		/*Aggiungo al pannello esterno il pulsante per l'aggiuta di un altro pagamento*/
		panelEsternoContanti.add(creaPulsanteAggiungiPagamentoInContanti());
		/*Restituisco il panello esterno*/
		return panelEsternoContanti;
	}
	
	/**
	 * Metodo che costruisce il pannello esterno dei pagamenti con bonifici
	 * 
	 * @return Pannello contenente sia la lista dei pagamenti in con bonifici che il pulsante per aggiungerne altri
	 */
	private JPanel creaPanelEsternoBonifici(){
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
		/*Aggiungo al pannello esterno il pulsante per l'aggiuta di un altro pagamento*/
		panelEsternoBonifico.add(creaPulsanteAggiungiPagamentoConBonifico());
		/*Restituisco il panello esterno*/
		return panelEsternoBonifico;
	}
	
	/**
	 * Metodo per creare il pannello esterno dei pagamenti con carta di credito.
	 * 
	 * @return Pannello contenente la lista dei pagamenti con carta di credit ed il pulsante per aggiungerne altri
	 */
	private JPanel creaPanelEsternoCarta(){
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
		/*Aggiungo al pannello esterno il pulsante per l'aggiuta di un altro pagamento*/
		panelEsternoCarta.add(creaPulsanteAggiungiPagamentoConCarta());
		/*Restituisco il panello esterno*/
		return panelEsternoCarta;
		
	}
	
}
