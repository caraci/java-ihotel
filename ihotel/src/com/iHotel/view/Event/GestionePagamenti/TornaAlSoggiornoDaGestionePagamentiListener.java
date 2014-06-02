/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Utility.IObserver;

/**
 * Classe che ha il compito di gestire il click sul pulsante per tornare indietro nella schermata VPP_RiepilogoPagamenti
 * @author Alessandro
 *
 */
public class TornaAlSoggiornoDaGestionePagamentiListener extends MouseAdapter{
	
	/**
	 * Maniglia al soggiorno corrente
	 */
	private SoggiornoContextSubject _soggiorno;
	
	/**
	 * Costruttore con parametri 
	 * @param soggiorno Passato come parametro
	 */
	public TornaAlSoggiornoDaGestionePagamentiListener(SoggiornoContextSubject soggiorno){
		_soggiorno = soggiorno;
	}
	/**
	 * Metodo che ha il compito di gestire il click sul pulsante "Indietro"
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		//Rimuovo l'osservatore dal soggiorno
		_soggiorno.Detach((IObserver) ViewFrameApplication.getInstance().get_pnlAttuale());
		//Invoco il metodo per visualizzare le informazioni relative al soggiorno nel controllore
		CModificaSoggiorno.getInstance().recuperaSoggiornoDaCodice(_soggiorno.get_codice());
	
	}

}
