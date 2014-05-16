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

}
