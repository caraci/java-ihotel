/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.view.View;
import com.iHotel.view.Graphic.GestionePrenotazione.VFPG_InfoPrenotazione;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VFP_RiepilogoPagamenti extends View{
	/**
	 * Prenotazione di cui si mostrano le informazioni.
	 */
	private PrenotazioneSubject _prenotazione;
	
	/**
	 * Singleton
	 */
	private static VFP_RiepilogoPagamenti instance= null;
	
	/*JPanel*/
	private JPanel _panelContanti, _panelBonifico, _panelCartaDiCredito;
	
	/*JLabel*/
	private JLabel _lblTitoloContanti, _lblTitoloBonifico, _lblTitoloCarta;
 
	public VFP_RiepilogoPagamenti(){
		/*JPanel*/
		_panelContanti = _viewFactory.getPanel();
		_panelBonifico = _viewFactory.getPanel();
		_panelCartaDiCredito = _viewFactory.getPanel();
		
		/*JLabel*/
		_lblTitoloContanti = _viewFactory.getLabel();
		_lblTitoloBonifico = _viewFactory.getLabel();
		_lblTitoloCarta = _viewFactory.getLabel();
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
		
		
		_panelMiddle.setLayout(new GridLayout(1, 3, 5, 0));
		/*invoco i 3 metodi privati che mi consentono di creare i pannelli con le informazioni sul prenotante*/
		/*della prenotazione, sulla prenotazione e sulle camere*/
		_panelMiddle.add(creaPanelMiddleLeft());
		_panelMiddle.add(creaPanelMiddleCenter());
		_panelMiddle.add(creaPanelMiddleRight());
		
		
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
		//restitiuisco il pannello con il bonifici
		return _panelCartaDiCredito;
	}
	
	public void creaFrame(PrenotazioneSubject prenotazione){
		//Titolo della finestra
		setTitle("iHotel - Gestione Prenotazione - Informazioni sul pagamento");
		//Creo il pannello centrale
		
		/* ATTENZIONE MANCANO I METODI PER CREARE PANNELLO SUPERIORE ED INFERIORE*********************************************/
		creaPanelMiddle();
	}

}
