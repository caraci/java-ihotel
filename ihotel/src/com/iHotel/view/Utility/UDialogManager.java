/**
 * 
 */
package com.iHotel.view.Utility;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;

import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Persona.Persona;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;
import com.iHotel.view.Access.ViewHandler;

/**
 * Classe addetta alla gestione delle finestre di dialogo.
 * @author Alessandro
 */
@SuppressWarnings("serial")
public class UDialogManager extends JOptionPane {
	
	private StyleAbstractFactory _viewFactory = ViewFactory.getInstance().getStyleFactory();
	
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
	
	public PagamentoConBonifico getDialogDatiBonificoBancario(){
		/*Etichette*/
		
		//label importo
		JLabel lblImporto = _viewFactory.getLabel();
		lblImporto.setText("Importo: ");
		//Label data
		JLabel lblData = _viewFactory.getLabel();
		lblData.setText("Data: ");
		//Label nome mittente
		JLabel lblNomeMittente = _viewFactory.getLabel();
		lblNomeMittente.setText("Nome mittente: ");
		//Label cognome mittente
		JLabel lblCognomeMittente = _viewFactory.getLabel();
		lblCognomeMittente.setText("Cognome mittente: ");
		//Label codice bonifico
		JLabel lblCodiceBonifico= _viewFactory.getLabel();
		lblCodiceBonifico.setText("Codice bonifico: ");
		
		//Creo il jdatepicker per la data
		JDatePicker data = JDateComponentFactory.createJDatePicker();
		/*Text fields*/
		JTextField importo = _viewFactory.getTextField();
		JTextField codice =  _viewFactory.getTextField();
		JTextField nomeMittente =  _viewFactory.getTextField();
		JTextField cognomeMittente =  _viewFactory.getTextField();
		
		//Creo un array di componenti
		final JComponent[] inputs = new JComponent[] {
				//mittente
				lblNomeMittente,
				nomeMittente,
				lblCognomeMittente,
				cognomeMittente,
				
				//numero
				lblCodiceBonifico,
				codice,
				//importo
				lblImporto,
				importo,
				//data
				lblData,
				(JComponent) data
		};
		//Faccio il display della schermata
		JOptionPane.showMessageDialog(null, inputs, "Inserimento pagamento Con Bonifico", JOptionPane.PLAIN_MESSAGE);
		
		/*Creo un nuovo prezzo con l'importo ricevuto*/		
		Prezzo importoRicevuto = new Prezzo(Double.parseDouble(importo.getText()));
		
		/*Creo un nuovo giorno con lla data in cui è stato ricevuto il bonifico*/		
		Giorno dataBonifico = new Giorno(data.getModel().getDay(),data.getModel().getMonth(),data.getModel().getYear());
		
		/*Creo una persona che è il mittente del bonifico*/
		Persona mittente = new Persona(nomeMittente.getText(), cognomeMittente.getText());
		
		/*Creo l'oggetto PagamentoConBonifico che restituisco*/
		PagamentoConBonifico pagamento = new PagamentoConBonifico(importoRicevuto, dataBonifico, codice.getText(), mittente);
		
		/*Restituisco il pagamento*/
		return pagamento;		
	}
}
