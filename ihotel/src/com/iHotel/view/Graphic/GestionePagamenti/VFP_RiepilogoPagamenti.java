/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Pagamento.PagamentoInContanti;
import com.iHotel.view.ViewFrame;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConBonificoListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoConCartaListener;
import com.iHotel.view.Event.GestionePagamenti.InserisciPagamentoInContantiListener;
import com.iHotel.view.Utility.UtoString;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VFP_RiepilogoPagamenti extends ViewFrame{
	/**
	 * Prenotazione di cui si mostrano le informazioni.
	 */
	private PrenotazioneSubject _prenotazione;
	
	/**
	 * HashMap contenente i pagamenti della prenotazione
	 */
	private HashMap<String, ArrayList<Pagamento>> _pagamentiDellaPrenotazione = new HashMap<String, ArrayList<Pagamento>>();
	
	
	/**
	 * Singleton
	 */
	private static VFP_RiepilogoPagamenti instance= null;
	
	/*JPanel*/
	private JPanel _panelMiddleTop, _panelMiddleBottom,_panelContanti, _panelBonifico, _panelCartaDiCredito;
	
	/*JLabel*/
	private JLabel _lblTitoloContanti, _lblTitoloBonifico, _lblTitoloCarta, _lblTotaleEImportoVersatoPrenotazione;
	
	/*JButton*/
	private JButton _btnAggiungiPagamentoInContanti,_btnAggiungiPagamentoConBonifico,_btnAggiungiPagamentoConCarta;
 
	public VFP_RiepilogoPagamenti(){
		/*JPanel*/
		_panelContanti = _viewFactory.getPanel();
		_panelBonifico = _viewFactory.getPanel();
		_panelCartaDiCredito = _viewFactory.getPanel();
		_panelMiddleTop = _viewFactory.getPanel();
		_panelMiddleBottom = _viewFactory.getPanel();
		
		/*JLabel*/
		_lblTitoloContanti = _viewFactory.getLabel();
		_lblTitoloBonifico = _viewFactory.getLabel();
		_lblTitoloCarta = _viewFactory.getLabel();
		_lblTotaleEImportoVersatoPrenotazione = _viewFactory.getLabel();
		
		/*JButton*/
		_btnAggiungiPagamentoInContanti = _viewFactory.getButton();
		_btnAggiungiPagamentoConBonifico = _viewFactory.getButton();
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
		_panelMiddleBottom.add(creaPanelMiddleLeft());
		_panelMiddleBottom.add(creaPanelMiddleCenter());
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
	private JPanel creaPanelMiddleLeft(){
		//Assegno il layout
		_panelContanti.setLayout(new BoxLayout(_panelContanti, BoxLayout.PAGE_AXIS));
		//Assegno il titolo
		_lblTitoloContanti.setText("Contanti:");
		//Assegno il titolo al pannello
		_panelContanti.add(_lblTitoloContanti);
		
		//Ora recupero i pagamenti in contanti
		ArrayList<Pagamento> pagamentiInContanti =_pagamentiDellaPrenotazione.get("contanti");
		if (pagamentiInContanti!=null){
			for (Iterator<Pagamento> iterator = pagamentiInContanti.iterator(); iterator
					.hasNext();) {
				PagamentoInContanti pagamentoInContanti = (PagamentoInContanti) iterator.next();
				JLabel label = _viewFactory.getLabel();
				//Setto il testo della label
				label.setText("Importo: "+pagamentoInContanti.get_importo().toString());
				//Aggiungo la label al pannello insieme al separatore
				_panelContanti.add(label);
				_panelContanti.add(_viewFactory.getSeparator());
			}
		}

		/*Esempio di più pagamenti attribuiti alla prenotazione*/
		//WARN ASSOLUTAMENTE DA LEVARE DOPO
					JLabel label1 = _viewFactory.getLabel();
					label1.setText("Pagamento 1");
					JLabel label2 = _viewFactory.getLabel();
					label2.setText("Pagamento 2");
					JLabel label3 = _viewFactory.getLabel();
					label3.setText("Pagamento 3");
					
					_panelContanti.add(label1);
					_panelContanti.add(_viewFactory.getSeparator());
					_panelContanti.add(label2);
					_panelContanti.add(_viewFactory.getSeparator());
					_panelContanti.add(label3);
		
		/*Setto il testo del pulsante*/
		_btnAggiungiPagamentoInContanti.setText("Aggiungi un pagamento in contanti");
		/*Aggiungo il listener all'evento click sul pulsante aggiungi pagamento in contanti*/
		_btnAggiungiPagamentoInContanti.addMouseListener(new InserisciPagamentoInContantiListener());
		/*Aggiungo il pulsante per aggiungere un pagamento*/
		_panelContanti.add(_btnAggiungiPagamentoInContanti);
		
		//Restituisco il pannello
		return _panelContanti;
		
	}
	/**
	 * Metodo che crea il pannello centrale con tutti i bonifici effettuati
	 * @return 	_panelBonifico E' il pannello centrale con tutti bonifici effettuati
	 */
	private JPanel creaPanelMiddleCenter(){
		//Aggiungo il layout
		_panelBonifico.setLayout(new BoxLayout(_panelBonifico,BoxLayout.PAGE_AXIS));
		//Aggiungo il titolo
		_lblTitoloBonifico.setText("Bonifici:");
		//Aggiongo la label con il titolo al pannello
		_panelBonifico.add(_lblTitoloBonifico);
		
		//Ora recupero i pagamenti tramite bonifico bancario
		ArrayList<Pagamento> pagamentiConBonifico =_pagamentiDellaPrenotazione.get("bonifico");
		if (pagamentiConBonifico!=null){
			for (Iterator<Pagamento> iterator = pagamentiConBonifico.iterator(); iterator
					.hasNext();) {
				PagamentoConBonifico pagamentoConBonifico = (PagamentoConBonifico) iterator.next();
				JLabel label = _viewFactory.getLabel();
				//Setto il testo della label
				label.setText("Importo: "+pagamentoConBonifico.get_importo().toString());
				//Aggiungo la label al pannello insieme ad un separatore
				_panelContanti.add(label);
				_panelContanti.add(_viewFactory.getSeparator());
			}
		}
		
		/*Setto il testo del pulsante*/
		_btnAggiungiPagamentoConBonifico.setText("Aggiungi un pagamento Con Bonifico");
		/*Aggiungo il listener all'evento click sul pulsante aggiungi pagamento in contanti*/
		_btnAggiungiPagamentoConBonifico.addMouseListener(new InserisciPagamentoConBonificoListener());
		/*Aggiungo il pulsante per aggiungere un pagamento*/
		_panelBonifico.add(_btnAggiungiPagamentoConBonifico);
		
		
		//restitiuisco il pannello con il bonifici
		return _panelBonifico;
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
		ArrayList<Pagamento> pagamentiConCarta =_pagamentiDellaPrenotazione.get("carta");
		if (pagamentiConCarta!=null){
			for (Iterator<Pagamento> iterator = pagamentiConCarta.iterator(); iterator
					.hasNext();) {
				PagamentoConCarta pagamentoConCarta = (PagamentoConCarta) iterator.next();
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
		/*Se la mappa della classe è vuota vado a chiedere alla prenotazione la mappa dei pagamenti e setto la mappa
		della schermata attuale con quella recuperata. Se non è vuota vuol dire che l'avevo già caricata*/
		if(this._pagamentiDellaPrenotazione==null){
				this._pagamentiDellaPrenotazione=_prenotazione.get_pagamenti();
		}
	}
	public void creaFrame(PrenotazioneSubject prenotazione){
		//Titolo della finestra
		setTitle("iHotel - Gestione Prenotazione - Informazioni sul pagamento");
		//Setto l'attributo prenotazione con il riferimento passato come parametro
		_prenotazione = prenotazione;
		//Recupero i pagamenti della prenotazione
		this.recuperaPagamenti();
		
		//Creo il pannello centrale
		
		/* ATTENZIONE MANCANO I METODI PER CREARE PANNELLO SUPERIORE ED INFERIORE*********************************************/
		creaPanelMiddle();
	}

}
