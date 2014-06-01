/**
 * 
 */
package com.iHotel.view.Utility;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Pagamento.PagamentoConBonifico;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Pagamento.PagamentoInContanti;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.ForeignSystem.PayTv.ServizioPayTv;
import com.iHotel.model.ForeignSystem.Telephone.ServizioTelefono;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Ora;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.view.Access.ViewFactory;

/**
 * Classe addetta alla creazione dei pannelli contenenti informazioni relative agli oggetti dello strato di dominio,
 * che devono essere visualizzate in diverse schermate del sistema.
 * @author Eugenio
 */
public class UtoPanel {
	
	/* --------------------------------- Metodi statici -------------------------------------- */ 
	
	
	/**
	 * Metodo per ottenere la stringa relativa alle informazioni di un ospite.
	 * 
	 * @param ospite Ospite in analisi.
	 * @return Pannello contenente le informazioni dell'ospite.
	 */
	public static JPanel ospiteToPanel(Ospite ospite) {
		JPanel pnlLista = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblNome = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblNome.setText(ospite.get_nome());
		
		JLabel lblCognome = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblCognome.setText(ospite.get_cognome());
		// Aggiungo elementi al pnlLista
		pnlLista.add(lblNome);
		pnlLista.add(lblCognome);
		
		return pnlLista;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un periodo.
	 * 
	 * @param periodo Periodo in analisi.
	 * @return Pannello contenente le informazioni del periodo.
	 */
	public static JPanel periodoToPanel(Periodo periodo) {
		JPanel pnlLista = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblPeriodo = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblPeriodo.setText("Periodo:");
		// Aggiungo elementi al pnlLista
		pnlLista.add(lblPeriodo);
		pnlLista.add(giornoToPanel(periodo.get_dataInizio()));
		pnlLista.add(giornoToPanel(periodo.get_dataFine()));
		
		return pnlLista;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad una data.
	 * 
	 * @param giorno Giorno in analisi.
	 * @return Stringa contenente le informazioni della data.
	 */
	public static JPanel giornoToPanel(Giorno giorno) {
		// Aggiungo un 1 al valore del mese perchè viene salvato contanto da 0 a 11.
		int mese = giorno.get_mese() + 1;
		// Creo pannello
		JPanel pnlLista = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblGiorno = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblGiorno.setText(giorno.get_giorno() + "/" + mese + "/" + giorno.get_anno());
		// Aggiungo elementi al pnlLista
		pnlLista.add(lblGiorno);
		return pnlLista;
	}
	/**
	 * Metodo che restituisce un pannello contenente l'orario
	 * 
	 * @param 	orario 	E' l'orario che si vuole visualizzare in un pannello
	 * @return			Pannello contenente l'orario che si voleva mostrare
	 */
	public static JPanel oraToPanel(Ora orario){
		/*Creo un pannello con l'ora*/
		JPanel panelOra = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		/*Setto il layout*/
		panelOra.setLayout(new BoxLayout(panelOra, BoxLayout.PAGE_AXIS));
		/*Elementi del pannello*/
		JLabel lblOrario = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblOrario.setText(orario.getOre() + " : "+ orario.getMinuti());
		panelOra.add(lblOrario);
		return panelOra;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un servizio interno.
	 * 
	 * @param servizioInterno 	Servizio in analisi.
	 * @return 					Pannello contenente tutte le informazioni del servizio.
	 */
	public static JPanel servizioInternoInPrenotazioneToPanel(ServizioInterno servizioInterno) {
		// Chiedo al catalogo il descrittore del servizio
		DescrizioneServizioInterno descrizioneServizio=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(servizioInterno.get_codice());
		/*Creo un pannello*/
		JPanel panelServizioInterno =ViewFactory.getInstance().getStyleFactory().getPanel(false);
		/*Setto il layout*/
		panelServizioInterno.setLayout(new BoxLayout(panelServizioInterno, BoxLayout.PAGE_AXIS));
		
		/*Elementi del pannello*/
		//lbl con il codice
		JLabel lblCodiceServizio = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblCodiceServizio.setText(descrizioneServizio.get_codice());
		//lbl con nome del servizio
		JLabel lblNomeServizio = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblNomeServizio.setText(descrizioneServizio.get_nome());
		//lbl con note
		JLabel lblNote = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblNote.setText("Note al servizio: " + servizioInterno.get_note());
		//lbl data
		JLabel lblData = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblData.setText("Data del servizio: ");
		//lbl orario
		JLabel lblOrario = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblOrario.setText("Orario del servizio: ");
		//pannello con data
		JPanel panelData =giornoToPanel(servizioInterno.get_giorno());
		//pannello con orario
		JPanel panelOrario = oraToPanel(servizioInterno.get_ora());	
		
		/*Aggiungo gli elementi al pannello*/
		panelServizioInterno.add(lblCodiceServizio);
		panelServizioInterno.add(lblNomeServizio);
		panelServizioInterno.add(lblData);
		panelServizioInterno.add(panelData);
		panelServizioInterno.add(lblOrario);
		panelServizioInterno.add(panelOrario);
		panelServizioInterno.add(lblNote);
		
		/*Restituisco il pannello*/
		return panelServizioInterno;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un servizio della payTv.
	 * 
	 * @param servizioPayTv Servizio in analisi.
	 * @return Pannello contenente le informazioni del servizio.
	 */
	public static JPanel servizioPayTvToPanel(ServizioPayTv servizioPayTv) {
		JPanel pnlLista = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblCodice = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblCodice.setText(servizioPayTv.get_codice());
		
		JLabel lblEvento = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblEvento.setText(servizioPayTv.get_evento());
		// Aggiungo elementi al pnlLista
		pnlLista.add(lblCodice);
		pnlLista.add(lblEvento);
		
		return pnlLista;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un servizio del Telefono.
	 * 
	 * @param servizioTelefono Servizio in analisi.
	 * @return Pannello contenente le informazioni del servizio.
	 */
	public static JPanel servizioTelefono(ServizioTelefono servizioTelefono) {
		JPanel pnlLista = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblCodice = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblCodice.setText(servizioTelefono.get_codice());
		
		JLabel lblEvento = ViewFactory.getInstance().getStyleFactory().getLabel();
		lblEvento.setText(servizioTelefono.get_telefonoMittente());
		// Aggiungo elementi al pnlLista
		pnlLista.add(lblCodice);
		pnlLista.add(lblEvento);
		
		return pnlLista;
	}
	
	/**
	 * Metodo che restituisce un pannello contenente un pagamento in contanti
	 * 
	 * @param pagamentoInContanti che si vuole visualizzare
	 * @return Pannello con le informazioni sul pagamento in contanti
	 */
	public static JPanel getPanelPagamentoInContanti(PagamentoInContanti pagamentoInContanti){
		/*Creo un pannello*/
		JPanel panelContanti = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		/*Assegno il layout*/
		panelContanti.setLayout(new BoxLayout(panelContanti, BoxLayout.Y_AXIS));
		//Creo una label per l'importo
		JLabel labelImporto = ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo della label
		labelImporto.setText("Importo: "+String.valueOf(pagamentoInContanti.get_importo().get_quantita())+ " "+ pagamentoInContanti.get_importo().get_valuta());
		//Aggiungo la label al pannello insieme ad un separatore
		panelContanti.add(labelImporto);
		
		//Creo una label per la data
		JLabel labelData =ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo
		labelData.setText("Data pagamento in contanti: "+ pagamentoInContanti.get_data().get_giorno() + " - "+pagamentoInContanti.get_data().get_mese()+ " - "+pagamentoInContanti.get_data().get_anno());
		//Aggiungo la label
		panelContanti.add(labelData);
		
		/*Restituisco il pannello*/
		return panelContanti;
	}
	
	/**
	 * Metodo che restituisce un pannello contenente un pagamento con bonifico
	 * 
	 * @param pagmentoConBonifico che si vuole visualizzare
	 * @return Pannello con le informazioni sul pagamento in contanti
	 */
	public static JPanel getPAnelPagamentoConBonfico (PagamentoConBonifico pagmentoConBonifico){
		//Creo un pannello
		JPanel panelBonifico = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		//Assegno il layout
		panelBonifico.setLayout(new BoxLayout(panelBonifico, BoxLayout.Y_AXIS));
		
		//Creo una label per l'importo
		JLabel labelImporto = ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo della label
		labelImporto.setText("Importo: "+String.valueOf(pagmentoConBonifico.get_importo().get_quantita())+ " "+ pagmentoConBonifico.get_importo().get_valuta());		
		//aggiungo la label al pannello
		panelBonifico.add(labelImporto);
		
		//Creo una label per il mittente del bonifico
		JLabel labelMittente = ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo della label
		labelMittente.setText("Mittente: "+ pagmentoConBonifico.get_mittente().get_cognome()+ " "+ pagmentoConBonifico.get_mittente().get_nome());
		//aggiungo la label al pannello
		panelBonifico.add(labelMittente);
		
		//Creo una label per la data
		JLabel labelData =ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo
		labelData.setText("Data pagamento con bonifico: "+ pagmentoConBonifico.get_data().get_giorno() + " - "+pagmentoConBonifico.get_data().get_mese()+ " - "+pagmentoConBonifico.get_data().get_anno());
		//Aggiungo la label
		panelBonifico.add(labelData);
		
		//restituisco il pannello
		return panelBonifico;
	}
	
	/**
	 * Metodo che restituisce un pannello contenente un pagamento in contanti
	 * 
	 * @param pagamentoInContanti che si vuole visualizzare
	 * @return Pannello con le informazioni sul pagamento in contanti
	 */
	public static JPanel getPanelPagamentoConCarta(PagamentoConCarta pagamentoConCarta){
		/*Creo un pannello*/
		JPanel panelCarta = ViewFactory.getInstance().getStyleFactory().getPanel(false);
		/*Assegno il layout*/
		panelCarta.setLayout(new BoxLayout(panelCarta, BoxLayout.Y_AXIS));
		//Creo una label per l'importo
		JLabel labelImporto = ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo della label
		labelImporto.setText("Importo: "+String.valueOf(pagamentoConCarta.get_importo().get_quantita())+ " "+ pagamentoConCarta.get_importo().get_valuta());
		//Aggiungo la label al pannello 
		panelCarta.add(labelImporto);
		
		//Creo una label per il titolare della carta
		JLabel labelTitolare = ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo della label
		labelTitolare.setText("Mittente: "+ pagamentoConCarta.get_cartaDiCredito().get_titolare().get_cognome()+ " "+ pagamentoConCarta.get_cartaDiCredito().get_titolare().get_nome());
		//aggiungo la label al pannello
		panelCarta.add(labelTitolare);
		
		//Creo una label per la data
		JLabel labelData =ViewFactory.getInstance().getStyleFactory().getLabel();
		//Setto il testo
		labelData.setText("Data pagamento con carta: "+ pagamentoConCarta.get_data().get_giorno() + " - "+pagamentoConCarta.get_data().get_mese()+ " - "+pagamentoConCarta.get_data().get_anno());
		//Aggiungo la label
		panelCarta.add(labelData);
		
		/*Restituisco il pannello*/
		return panelCarta;
	}
}