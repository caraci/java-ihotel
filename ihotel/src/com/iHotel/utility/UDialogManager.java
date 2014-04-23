/**
 * 
 */
package com.iHotel.utility;

import javax.swing.JOptionPane;

import com.iHotel.view.Access.ViewHandler;

/**
 * @author Alessandro
 *
 */
public class UDialogManager extends JOptionPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Singleton
	private static UDialogManager instance = null;

	/**
	 * Costruttore privato
	 */
	private UDialogManager(){}
	
	/**
	 * Metodo per ottenere l'unica istanza di UDialogManager - Pattern Singleton
	 * @return
	 */
	public static UDialogManager getInstance(){
		if (instance == null){
			instance = new UDialogManager();
		}		
		return instance;
	}
	
	/**
	 * Metodo che restituisce la dialog per l'inserimento del codice. 
	 * @return String La stringa inserita dall'utente, che è il codice della prenotazione.
	 */
	public String getDialogInserimentoCodice(){
		/*Si passa l'interfaccia corrente al JOptionPane, in questo modo questa viene "bloccata" finchè la dialog rimane visualizzata*/
		return JOptionPane.showInputDialog(ViewHandler.getInstance().getCurrentInterface(),"Inserisci il codice della prenotazione");	
	}
	
	/**
	 * Metodo che restituisce la dialog che conferma l'inserimento della prenotazione
	 * @param codicePrenotazione è il codice della prenotazione inserita.
	 */
	public void showDialogConfermaPrenotazione(String codicePrenotazione){
		JOptionPane.showMessageDialog(ViewHandler.getInstance().getCurrentInterface(), "La prenotazione è stata creata, codice: " + codicePrenotazione);

	}
}
