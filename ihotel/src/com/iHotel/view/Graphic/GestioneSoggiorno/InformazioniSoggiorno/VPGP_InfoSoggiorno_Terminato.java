/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno;

import java.util.HashMap;

import javax.swing.JButton;

import com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno.GestisciPagamentoListener;
import com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno.TerminaModifichePrenotazione;

/**
 * Classe addetta alla realizzazione della finestra per mostrare le informazioni di un soggiorno terminato
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VPGP_InfoSoggiorno_Terminato extends VPGP_InfoSoggiorno {

	/**
	 * Costruttore
	 */
	public VPGP_InfoSoggiorno_Terminato() {
		super();
	}
	
	@Override
	/**
	 * Metodo che setta la label contenente lo stato del soggiorno
	 */
	protected void setLblStatoSoggiorno(){
		_lblStatoSoggiorno.setText("Soggiorno Terminato");
	}
	
	@Override
	/**
	 * Metodo che crea il panelBottom
	 */
	protected void creaPanelBottom(){		
		/*Setto il testo del bottone Gestione pagamenti*/
		_btnGestionePagamenti.setText("Gestisci pagamenti");
		/*Aggiungo il listener all'evento*/
		_btnGestionePagamenti.addMouseListener(new GestisciPagamentoListener(_prenotazione));
		/*Setto il testo del bottone*/
		_btnTerminaModifichePrenotazione.setText("Termina modifiche");
		/*Aggiungo il listener al click sul pulsante*/
		_btnTerminaModifichePrenotazione.addMouseListener(new TerminaModifichePrenotazione());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();		
		// Aggiungo i bottoni alla struttura.
		//Colonna 3, sarebbe la 4
		Bottoni.put(3, _btnGestionePagamenti);
		//Colonna 6, sarebbe la 7
		Bottoni.put(6,_btnTerminaModifichePrenotazione);
		// Creo la pulsantiera.
		Integer numeroColonne = 7;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);		
	}

}
