/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.view.Utility.UDialogManager;

/**
 * Classe che ha il compito di gestire l'evento click sul bottone "Aggiungi pagamento con bonifico"
 * nella classe VFG_gestionePagamento
 * @author Alessandro
 *
 */
public class InserisciPagamentoConBonificoListener extends MouseAdapter {
	
	//Costruttore
	public InserisciPagamentoConBonificoListener(){
		
	}
	
	/**
	 * Metodo che va ad assegnare una form di inseriemnto alla dialog. Con questa form verranno 
	 * presi in input i dati riguardanti il pagamneto, come la data e l'importo
	 * 
	 * NB va completata la parte di logica
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		//Richiedo la dialog giusta
		PagamentoConBonifico pagamento= UDialogManager.getInstance().getDialogDatiBonificoBancario();
	}

}
