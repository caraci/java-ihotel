/**
 * 
 */
package com.iHotel.view.Utility;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;

import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Pagamento.PagamentoInContanti;
import com.iHotel.model.Persona.Persona;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Ora;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.ViewFrameApplication;
import com.iHotel.view.Access.ViewFactory;

/**
 * Classe addetta alla gestione delle finestre di dialogo.
 * @author Alessandro
 */
@SuppressWarnings("serial")
public class UDialogManager extends JOptionPane {
	
	/**
	 * Metodo che restituisce la dialog per l'inserimento del codice.
	 *  
	 * @return Stringa inserita dall'utente, che è il codice della prenotazione.
	 */
	public static String getDialogInserimentoCodice(){	
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
		/*Si passa l'interfaccia corrente al JOptionPane, in questo modo questa viene "bloccata" finchè la dialog rimane visualizzata*/
		return JOptionPane.showInputDialog(ViewFrameApplication.getInstance(),"Inserisci il codice della prenotazione", "Inserimento codice per recuperare la prenotazione", JOptionPane.QUESTION_MESSAGE);	
	}
	
	/**
	 * Metodo che mostra la dialog che conferma l'inserimento della prenotazione.
	 * 
	 * @param codicePrenotazione è il codice della prenotazione inserita.
	 */
	public static void showDialogConfermaPrenotazione(String codicePrenotazione){
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), "La prenotazione è stata creata. Il suo codice è " + codicePrenotazione, "Conferma creazione prenotazione", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Metodo che mostra la dialog che conferma l'inserimento di un servizio.
	 */
	public static void showDialogConfermaInserimentoServizio(){
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), "Il servizio è stato aggiunto alla prenotazione.", "Conferma inserimento servizio", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Metodo che visualizza una JDialog per l'inserimento delle informazioni del bonifico
	 * @return Un oggetto PagamentoConBonifico con le informazion inserite dall'utente
	 */
	public static PagamentoConBonifico getDialogDatiBonificoBancario(Prezzo importoDaVisualizzare){
		/*Etichette*/
		
		//lable importo massimo da addebitare
		JLabel lblImportoMassimo = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblImportoMassimo.setText("L'importo massimo che si può registrare è: "+String.valueOf(importoDaVisualizzare.get_quantita()));
		//label importo
		JLabel lblImporto = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblImporto.setText("Importo: ");
		//Label data
		JLabel lblData = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblData.setText("Data: ");
		//Label nome mittente
		JLabel lblNomeMittente = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblNomeMittente.setText("Nome mittente: ");
		//Label cognome mittente
		JLabel lblCognomeMittente = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblCognomeMittente.setText("Cognome mittente: ");
		//Label codice bonifico
		JLabel lblCodiceBonifico= ViewFactory.getInstance().getStyleFactory().getLabel();
		lblCodiceBonifico.setText("Codice bonifico: ");
		
		//Creo il jdatepicker per la data
		JDatePicker data = JDateComponentFactory.createJDatePicker();
		/*Text fields*/
		//Importo da addebitare
		JTextField importo = ViewFactory.getInstance().getStyleFactory().getTextField();
		//Codice del bonifico
		JTextField codice =  ViewFactory.getInstance().getStyleFactory().getTextField();
		//Nome mittente bonifico
		JTextField nomeMittente =  ViewFactory.getInstance().getStyleFactory().getTextField();
		//Cognome mittente bonifico
		JTextField cognomeMittente =  ViewFactory.getInstance().getStyleFactory().getTextField();
		
		//Creo un array di componenti
		final JComponent[] inputs = new JComponent[] {
				//mittente
				lblImportoMassimo,
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
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
		
		//Creo un pagamento con bonifico
		PagamentoConBonifico pagamento = new PagamentoConBonifico();
		//Faccio il display della schermata
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), inputs, "Inserimento pagamento Con Bonifico", JOptionPane.PLAIN_MESSAGE);
		
		if(!importo.getText().equals("")){
			/*Creo un nuovo prezzo con l'importo ricevuto*/		
			Prezzo importoRicevuto = new Prezzo(Double.parseDouble(importo.getText()));
			
			/*Controllo se l'importo inserito è maggiore dell'importo massimo*/
			if(importoRicevuto.get_quantita()>importoDaVisualizzare.get_quantita()){
				/*Setto l'importo massimo al valore dell'importo massimo da pagare*/
				importoRicevuto.set_quantita(importoDaVisualizzare.get_quantita());
			}
			
			/*Creo un nuovo giorno con lla data in cui è stato ricevuto il bonifico*/		
			Giorno dataBonifico = new Giorno(data.getModel().getDay(),data.getModel().getMonth(),data.getModel().getYear());
			
			/*Creo una persona che è il mittente del bonifico*/
			Persona mittente = new Persona(nomeMittente.getText(), cognomeMittente.getText());
			
			/*Creo l'oggetto PagamentoConBonifico che restituisco*/
			pagamento.set_importo(importoRicevuto);
			pagamento.set_data(dataBonifico);
			pagamento.set_codiceBonifico(codice.getText());
			pagamento.set_mittente(mittente);
		}
		/*Restituisco il pagamento*/
		return pagamento;		
	}
	
	/**
	 * Metodo che visualizza una dialog per l'inserimento del pagamento in contanti e restituisce un pagamento in contati.
	 * 
	 * @return Il pagamento in contanti creato con le informazioni inserite dall'utente.
	 */
	public static PagamentoInContanti getDialogDatiPagamentoInContanti(Prezzo importoDaVisualizzare){
		/*Etichette*/
		/*Label che contiente l'importo massimo da pagare*/
		JLabel lblImportoMassimo = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblImportoMassimo.setText("L'importo massimo da addebitare per il soggiorno è: "+String.valueOf(importoDaVisualizzare.get_quantita()));
		//label importo
		JLabel lblImporto = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblImporto.setText("Importo: ");
		//Label data
		JLabel lblData = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblData.setText("Data: ");
		
		//Creo il jdatepicker per la data
		JDatePicker data = JDateComponentFactory.createJDatePicker();
		/*Text fields*/
		JTextField importo = ViewFactory.getInstance().getStyleFactory().getTextField();		
		
		//Creo un array di componenti
		final JComponent[] inputs = new JComponent[] {
				lblImportoMassimo,
				//importo
				lblImporto,
				importo,
				//data
				lblData,
				(JComponent) data
		};
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
		
		//
		PagamentoInContanti pagamento = new PagamentoInContanti();
		//Faccio il display della schermata
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), inputs,"Inserimento pagamento in contanti", JOptionPane.PLAIN_MESSAGE);
		
		if(!importo.getText().trim().equals("")){
			/*Creo un nuovo prezzo con l'importo ricevuto*/		
			Prezzo importoRicevuto = new Prezzo(Double.parseDouble(importo.getText()));
			
			/*Controllo se l'importo inserito è maggiore dell'importo massimo*/
			if(importoRicevuto.get_quantita()>importoDaVisualizzare.get_quantita()){
				/*Setto l'importo massimo al valore dell'importo massimo da pagare*/
				importoRicevuto.set_quantita(importoDaVisualizzare.get_quantita());
			}
			
			/*Creo un nuovo giorno con lla data in cui è stato ricevuto il bonifico*/		
			Giorno dataIncasso = new Giorno(data.getModel().getDay(),data.getModel().getMonth(),data.getModel().getYear());
			
			
			/*Creo l'oggetto PagamentoConBonifico che restituisco*/
			pagamento.set_importo(importoRicevuto);
			pagamento.set_data(dataIncasso);
		}
		
		/*Restituisco il pagamento*/
		return pagamento;
	}
	
	/**
	 * Metodo che visualizza la dialog con i campi per l'inserimento di un servizio interno e restituisce un oggetto Servizio interno.
	 *  
	 * @return Il servizio interno con le informazioni inserite dall'utente.
	 */
	public static ServizioInterno getDialogAggiungiServizioInterno(){
		
		/*Recupero i descrittori dei servizi offerti dall'albergo*/
		HashMap<String,DescrizioneServizioInterno> descrizioniServizi = Albergo.getInstance().get_catalogoServizi().get_descrizioneServizi();
		/*Combobox per mostrare la lista dei servizi*/
		JComboBox<String> comboBoxServizi= new JComboBox<>();
		/*TextArea per aggiungere note*/
		JTextArea note = ViewFactory.getInstance().getStyleFactory().getTextArea();
		/*Setto il numero di righe della textarea*/
		note.setRows(5);
		
		/*Ciclo suilla mappa dei servizi e li aggiungo alla combobox*/
		for (Iterator<String> iterator = descrizioniServizi.keySet().iterator(); iterator.hasNext();) {
			String codiceServizio = (String) iterator.next();
			// Aggiungo la stringa del nome del servizio alla comboBox
			comboBoxServizi.addItem(descrizioniServizi.get(codiceServizio).get_nome());
		}
		
		/*Label*/
		JLabel lblServizio = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblServizio.setText("Scegli il servizio: ");
		/*Data*/
		JLabel lblData = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblData.setText("Data: ");
		/*Note*/
		JLabel lblNote = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblNote.setText("Note al servizio: ");
		/*Orario del servizio*/
		JLabel lblOrario = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblOrario.setText("Orario: ");
		//Creo il jdatepicker per la data
		JDatePicker data = JDateComponentFactory.createJDatePicker();
		//Creo l'orario
		JPanel pnlOrario = UMostraOrario.getInstance().creaOrarioDefault();
		
		//Creo un array di componenti
			final JComponent[] inputs = new JComponent[] {
					//importo
					lblServizio,
					comboBoxServizi,
					//data
					lblData,
					(JComponent) data,
					//note
					lblNote,
					note,
					//Ora
					lblOrario,	
					//mi faccio restituire l'orario dalla
					pnlOrario
			};
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
			
		//Faccio il display della schermata
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), inputs, "Inserimento servizi nella prenotaziones", JOptionPane.PLAIN_MESSAGE);
		
		/*Costruisco tutto ciò che mi serve per istanziare un servizio*/
		DescrizioneServizioInterno descrizioneServizio=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaNome(comboBoxServizi.getSelectedItem().toString());
		/*Codice del servizio*/
		String codice = descrizioneServizio.get_codice();
		/*Data in cui eseguire il servizio*/
		Giorno dataRichiesta = new Giorno(data.getModel().getDay(),data.getModel().getMonth(),data.getModel().getYear());
		/*Ora per cui è stato richiesto il servizio*/
		Ora orario = new Ora(UMostraOrario.getInstance().getOraSelezionata(),UMostraOrario.getInstance().getMinutoSelezionato());
		/*Testo delle note*/
		String testoNote = note.getText();
		/*Costruisco il servizio interno con le informazioni inserite*/
		ServizioInterno servizioInterno = new ServizioInterno(codice,dataRichiesta,testoNote,orario);
		
		/*Restituisco il servizio interno costruito*/
		return servizioInterno;
	}
	/**
	 * Metodo che restituisce la dialog per l'inserimento del pagamento con carta di credito
	 * 
	 * @param importoDaVisualizzare E' l'importo che viene visualizzato nella dialog
	 * @return L'importo inserito dall'utente, che è quello che andrà addebitato effettivamente sulla carta
	 */
	public static Prezzo getDialogInserimentoImportoPagamentoConCarta(Prezzo importoDaVisualizzare){
		/*Label*/
		/*Label che contiente l'importo massimo da pagare*/
		JLabel lblImportoMassimo = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblImportoMassimo.setText("L'importo massimo da addebitare per il soggiorno è: "+String.valueOf(importoDaVisualizzare.get_quantita()));
		JLabel lblImporto = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblImporto.setText("Importo da pagare:");
		/*Campo di testo per l'inserimento del prezzo*/
		JTextField txtImporto = ViewFactory.getInstance().getStyleFactory().getTextField();		
		
		//Creo un array di componenti
		final JComponent[] inputs = new JComponent[] {
				lblImportoMassimo,
				lblImporto,
				txtImporto
		};
		/*Setto il colore della dialog*/
		setColor(ViewFactory.getInstance().getStyleFactory().getColorContentPane(), ViewFactory.getInstance().getStyleFactory().getColorContentPane());
		/*Creo la dialog*/
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), inputs, "Inserimento importo pagamento con carta", JOptionPane.PLAIN_MESSAGE);
		/*Controllo se il pagamento ha un importo maggiore di quello che è rimasto da pagare*/
		if(!txtImporto.getText().equals("")){
			if(Double.valueOf(txtImporto.getText())<importoDaVisualizzare.get_quantita()){
				/*Setto l'importo del pagamento da effettuare con quello inserito dall'utente*/
				importoDaVisualizzare.set_quantita(Double.valueOf(txtImporto.getText()));
			}
		}
		/*Restituisco l'importo da addebitare*/
		return importoDaVisualizzare;
	}
	/**
	 * Metodo che setta il colore della dialog
	 * 
	 * @param colorePannello E' il colore del pannello in cui sono mostrate le info della dialog
	 * @param coloreBackground E' il colore di sfondo della dialog
	 */
	private static void setColor(Color colorePannello, Color coloreBackground){
		//Setto il colore background
		UIManager.put("OptionPane.background",coloreBackground);
		//Setto il colore del pannello
		UIManager.put("Panel.background",colorePannello);
		
	}
	
	/**
	 * Metodo che restituisce la dialog che conferma l'avvenuto checkin
	 */
	public static void getDialogAvvenutoCheckIn(){
		JOptionPane.showMessageDialog(ViewFrameApplication.getInstance(), "CheckIn terminato correttamente. Sono state generate le schedine di pubblica sicurezza per gli ospiti!");
	}
}
