/**
 * 
 */
package com.iHotel.view.Utility;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.ForeignSystem.PayTv.ServizioPayTv;
import com.iHotel.model.ForeignSystem.Telephone.ServizioTelefono;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Ora;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Access.ViewFactory;

/**
 * Classe addetta alla creazione delle stringhe relative a gli oggetti dello strato di dominio.
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
	 * 
	 * @param prenotazione
	 * @return
	 */
	public static JPanel totalePrenotazioneToString(SoggiornoContextSubject prenotazione){
		Prezzo importoTotalePrenotazione = prenotazione.get_importoTotaleCamere().somma(prenotazione.getPrezzoServiziInterni());
		Prezzo importoTotalePrenotazioneConServizi = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(prenotazione);
		importoTotalePrenotazioneConServizi.somma(importoTotalePrenotazione);
		//chiedo alla prenotazione quanto è il suo totale e la sua valuta
		String totalePrenotazione = String.valueOf(importoTotalePrenotazioneConServizi.get_importo());
		String totalePagato = String.valueOf(prenotazione.get_importoTotalePagamenti().get_importo());
		
		JPanel pnlPagamenti  = ViewFactory.getInstance().getStyleFactory().getPanel();
		JLabel lblImportoTotale = ViewFactory.getInstance().getStyleFactory().getLabel();
		JLabel lblImportoVersato = ViewFactory.getInstance().getStyleFactory().getLabel();
		
		lblImportoTotale.setText("Il totale della prenotazione è: " + totalePrenotazione);
		lblImportoVersato.setText("L'importo già versato è: "+totalePagato);
		
		pnlPagamenti.add(lblImportoTotale);
		pnlPagamenti.add(lblImportoVersato);
		
		return pnlPagamenti;
	}

}