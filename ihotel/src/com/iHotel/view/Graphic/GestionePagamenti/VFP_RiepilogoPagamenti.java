/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.view.View;

/**
 * @author Alessandro
 *
 */
public class VFP_RiepilogoPagamenti extends View{
	/**
	 * Prenotazione di cui si mostrano le informazioni.
	 */
	private PrenotazioneSubject _prenotazione;
	
	/*JPanel*/
	private JPanel _panelContanti, _panelBonifico, _panelCartaDiCredito;
	
	/*JLabel*/
	private JLabel _lblTitoloContanti, _lblTitoloBonifico, _lblTitoloCarta;
 
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
	 * @return _panelBonifico E' il pannello centrale con tutti bonifici effettuati
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

}
