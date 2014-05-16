/**
 * 
 */
package com.iHotel.view.Graphic.GestionePagamenti;

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
	private JPanel _contanti, _bonifico, _cartaDiCredito;
	
	/*JLabel*/
	private JLabel _titoloContanti,_titoloBonifico,_titoloCarta;
 
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void creaPanelBottom() {
		// TODO Auto-generated method stub
		
	}

}
