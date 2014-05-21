/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
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
import com.iHotel.view.ViewFrameOLD;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConBonificoListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConCartaListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoInContantiListener;
import com.iHotel.view.Utility.UtoString;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VFP_RiepilogoPagamenti extends ViewFrameOLD{
	/**
	 * Prenotazione di cui si mostrano le informazioni.
	 */
	private SoggiornoContextSubject _prenotazione;
	
	/**
	 * HashMap contenente i pagamenti della prenotazione
	 */
	private ArrayList<PagamentoInContanti> _pagamentiInContanti = new ArrayList<PagamentoInContanti>();
	private ArrayList<PagamentoConBonifico> _pagamentiConBonifico = new ArrayList<PagamentoConBonifico>();
	private ArrayList<PagamentoConCarta> _pagamentiConCarta = new ArrayList<PagamentoConCarta>();
	
	
	/**
	 * Singleton
	 */
	private static VFP_RiepilogoPagamenti instance= null;
	
	/*JPanel*/
	private JPanel _panelMiddleTop, _panelMiddleBottom,_panelContanti, _panelCartaDiCredito, _panelBonifico;
	
	/*JLabel*/
	private JLabel _lblTitoloCarta, _lblTotaleEImportoVersatoPrenotazione;
	
	/*JButton*/
	private JButton _btnAggiungiPagamentoConCarta;
 
	public VFP_RiepilogoPagamenti(){
		/*JPanel*/
		_panelContanti = _viewFactory.getPanel();
		_panelCartaDiCredito = _viewFactory.getPanel();
		_panelMiddleTop = _viewFactory.getPanel();
		_panelMiddleBottom = _viewFactory.getPanel();
		_panelBonifico = _viewFactory.getPanel();
		
		/*JLabel*/
		_lblTitoloCarta = _viewFactory.getLabel();
		_lblTotaleEImportoVersatoPrenotazione = _viewFactory.getLabel();
		
		/*JButton*/
		_btnAggiungiPagamentoConCarta = _viewFactory.getButton();
	}
	
	/* -------------------------- Metodi di classe ----------------------------- */
	/**
	 * Metodo che consente di avere l'unica instanza di questa classe - Pattern Singleton.
	 */
	public static VFP_RiepilogoPagamenti getInstance(){
		if (instance == null){
			instance = new VFP_RiepilogoPagamenti();
		}
		return instance;
	}
	@Override
	public void removeInstance() {
		// TODO Auto-generated method stub
		
	}

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
		_lblTotaleEImportoVersatoPrenotazione.setText(UtoString.getInstance().totalePrenotazioneToString(_prenotazione));
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
		
		_panelContanti.add(creaPanelMiddleLeft());
		// Aggiungo le schede
		_panelBonifico.add(creaPanelMiddleCenter());
		
		// Mostro la scheda relativa alla carta d'identita
		//cardLayout.show(_panelEsternoBonifico);
		_panelMiddleBottom.add(_panelContanti);
		_panelMiddleBottom.add(_panelBonifico);
		_panelMiddleBottom.add(creaPanelMiddleRight());
		return _panelMiddleBottom;
	}
	@Override
	protected void creaPanelBottom() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Metodo che crea il pannello laterale a sinistra
	 * @return _panelContanti E' il pannello laterale dei pagamenti in contanti
	 */
	public JScrollPane creaPanelMiddleLeft(){
		//Recupero i pagamenti
		recuperaPagamenti();
		//Creo un JScrollPane
		JScrollPane scrollPaneContanti = _viewFactory.getScrollPane();
		//Creo un pannello
		JPanel panelContanti = _viewFactory.getPanel();
		//Assegno il layout
		panelContanti.setLayout(new BoxLayout(panelContanti, BoxLayout.PAGE_AXIS));
		//Assegno il titolo
		JLabel lblTitoloContanti = _viewFactory.getLabel();
		lblTitoloContanti.setText("Contanti:");
		//Assegno il titolo al pannello
		panelContanti.add(lblTitoloContanti);
		panelContanti.add(_viewFactory.getSeparator());
		
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
				panelContanti.add(_viewFactory.getSeparator());
			}
		}

		
		
		/*Setto il testo del pulsante*/
		JButton btnAggiungiPagamentoInContanti = _viewFactory.getButton();
		btnAggiungiPagamentoInContanti.setText("Aggiungi un pagamento in contanti");
		/*Aggiungo il listener all'evento click sul pulsante aggiungi pagamento in contanti*/
		btnAggiungiPagamentoInContanti.addMouseListener(new InserisciPagamentoInContantiListener());
		/*Aggiungo il pulsante per aggiungere un pagamento*/
		panelContanti.add(btnAggiungiPagamentoInContanti);	
		
		scrollPaneContanti.setViewportView(panelContanti);
		
		//Restituisco il pannello
		return scrollPaneContanti;
		
	}
	/**
	 * Metodo che crea il pannello centrale con tutti i bonifici effettuati
	 * @return 	_panelBonifico E' il pannello centrale con tutti bonifici effettuati
	 */
	public JScrollPane creaPanelMiddleCenter(){
		
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
		
		/*Setto il testo del pulsante*/
		JButton btnAggiungiPagamentoConBonifico = _viewFactory.getButton();
		btnAggiungiPagamentoConBonifico.setText("Aggiungi un pagamento Con Bonifico");
		/*Aggiungo il listener all'evento click sul pulsante aggiungi pagamento in contanti*/
		btnAggiungiPagamentoConBonifico.addMouseListener(new InserisciPagamentoConBonificoListener());
		/*Aggiungo il pulsante per aggiungere un pagamento*/
		panelBonifico.add(btnAggiungiPagamentoConBonifico);
		
		scrollPaneBonifico.setViewportView(panelBonifico);
		//restitiuisco il pannello con il bonifici
		return scrollPaneBonifico;
	}
	/**
	 * Metodo che crea il pannello destro con le informazioni sui versamenti effettuati da carta di credito
	 * @return 	_panelCartaDiCredito E' il pannello contenente le informazioni  con i versamenti effettuati 
	 * 			da carta di credito
	 */
	private JPanel creaPanelMiddleRight(){
		//Aggiungo il layout
		_panelCartaDiCredito.setLayout(new BoxLayout(_panelCartaDiCredito,BoxLayout.PAGE_AXIS));
		//Aggiungo il titolo
		_lblTitoloCarta.setText("Prelevamenti carte di credito:");
		//Aggiongo la label con il titolo al pannello
		_panelCartaDiCredito.add(_lblTitoloCarta);
		
		//Ora recupero i pagamenti tramite Carta di credito
	
		if (_pagamentiConCarta!=null){
			for (Iterator<PagamentoConCarta> iterator = _pagamentiConCarta.iterator(); iterator
					.hasNext();) {
				PagamentoConCarta pagamentoConCarta = iterator.next();
				JLabel label = _viewFactory.getLabel();
				//Setto il testo della label
				label.setText("Importo: "+pagamentoConCarta.get_importo().toString());
				//Aggiungo la label al pannello insieme ad un separatore
				_panelContanti.add(label);
				_panelContanti.add(_viewFactory.getSeparator());
			}
		}
		
		/*Setto il testo del pulsante*/
		_btnAggiungiPagamentoConCarta.setText("Aggiungi un pagamento con carta");
		/*Aggiungo il listener all'evento click sul pulsante aggiungi pagamento in contanti*/
		_btnAggiungiPagamentoConCarta.addMouseListener(new InserisciPagamentoConCartaListener());
		/*Aggiungo il pulsante per aggiungere un pagamento*/
		_panelCartaDiCredito.add(_btnAggiungiPagamentoConCarta);
		
		//restitiuisco il pannello con il bonifici
		return _panelCartaDiCredito;
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
	public void creaFrame(SoggiornoContextSubject prenotazione){
		//Titolo della finestra
		setTitle("iHotel - Gestione Prenotazione - Informazioni sul pagamento");
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

}
