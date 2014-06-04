/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CGestionePagamenti;

/**
 * Classe che ha il compito di gestire il click sul pulsante per tornare indietro nella schermata VPP_RiepilogoPagamenti
 * @author Alessandro
 *
 */
public class TornaAlSoggiornoDaGestionePagamentiListener extends MouseAdapter{
	
	/**
	 * Metodo che ha il compito di gestire il click sul pulsante "Indietro"
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Invoco il metodo per visualizzare le informazioni relative al soggiorno nel controllore
		CGestionePagamenti.getInstance().tornaAlSoggiorno();
	
	}

}
