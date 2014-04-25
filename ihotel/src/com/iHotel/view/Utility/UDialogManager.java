/**
 * 
 */
package com.iHotel.view.Utility;

import javax.swing.JOptionPane;

import com.iHotel.view.Access.ViewHandler;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class UDialogManager extends JOptionPane {
	
	//Singleton
	private static UDialogManager instance = null;

	/**
	 * Costruttore privato
	 */
	private UDialogManager(){}
	
	/**
	 * Metodo per ottenere l'unica istanza di questa classe - Pattern Singleton
	 */
	public static UDialogManager getInstance(){
		if (instance == null){
			instance = new UDialogManager();
		}		
		return instance;
	}
	
	/**
	 * Metodo che restituisce la dialog per l'inserimento del codice.
	 *  
	 * @return Stringa inserita dall'utente, che è il codice della prenotazione.
	 */
	public String getDialogInserimentoCodice(){
		/*Si passa l'interfaccia corrente al JOptionPane, in questo modo questa viene "bloccata" finchè la dialog rimane visualizzata*/
		return JOptionPane.showInputDialog(ViewHandler.getInstance().getCurrentInterface(),"Inserisci il codice della prenotazione", "Inserimento codice per recuperare la prenotazione", JOptionPane.QUESTION_MESSAGE);	
	}
	
	/**
	 * Metodo che mostra la dialog che conferma l'inserimento della prenotazione.
	 * 
	 * @param codicePrenotazione è il codice della prenotazione inserita.
	 */
	public void showDialogConfermaPrenotazione(String codicePrenotazione){
		JOptionPane.showMessageDialog(ViewHandler.getInstance().getCurrentInterface(), "La prenotazione è stata creata. Il suo codice è " + codicePrenotazione, "Conferma creazione prenotazione", JOptionPane.INFORMATION_MESSAGE);

	}
	
	/**
	 * Metodo che mostra la dialog che conferma l'inserimento di un servizio.
	 */
	public void showDialogConfermaInserimentoServizio(){
		JOptionPane.showMessageDialog(ViewHandler.getInstance().getCurrentInterface(), "Il servizio è stato aggiunto alla prenotazione.", "Conferma inserimento servizio", JOptionPane.INFORMATION_MESSAGE);
	}
}
