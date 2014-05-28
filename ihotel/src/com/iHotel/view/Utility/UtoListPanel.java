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
import com.iHotel.model.ForeignSystem.PayTv.ServizioPayTv;
import com.iHotel.model.ForeignSystem.Telephone.ServizioTelefono;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Ora;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

/**
 * Classe addetta alla creazione delle stringhe relative a gli oggetti dello strato di dominio.
 * @author Eugenio
 */
public class UtoListPanel {
	/* ------------------------------ Attributi e costruttore ----------------------------------- */
	/**
	 * Istanza unica di questa classe - Pattern Singleton
	 */
	private static UtoListPanel instance=null;
	/**
	 * Fornitore degli elementi grafici.
	 */
	private StyleAbstractFactory _viewFactory;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private UtoListPanel() {
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
	}
	/* --------------------------------- Metodi statici -------------------------------------- */ 
	/**
	 * Metodo per ottenere l'unica instanza di questa classe.
	 */
	public static UtoListPanel getInstance() {
		if(instance == null) {
            instance = new UtoListPanel();
         }
         return instance;
	}
	/* --------------------------------- Metodi di instanza -------------------------------------- */
	/**
	 * Metodo per ottenere la stringa relativa alle informazioni di un ospite.
	 * 
	 * @param ospite Ospite in analisi.
	 * @return Pannello contenente le informazioni dell'ospite.
	 */
	public JPanel ospiteToPanel(Ospite ospite) {
		JPanel pnlLista = _viewFactory.getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblNome = _viewFactory.getLabel();
		lblNome.setText(ospite.get_nome());
		
		JLabel lblCognome = _viewFactory.getLabel();
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
	public JPanel periodoToPanel(Periodo periodo) {
		JPanel pnlLista = _viewFactory.getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblPeriodo = _viewFactory.getLabel();
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
	public JPanel giornoToPanel(Giorno giorno) {
		// Aggiungo un 1 al valore del mese perchè viene salvato contanto da 0 a 11.
		int mese = giorno.get_mese() + 1;
		// Creo pannello
		JPanel pnlLista = _viewFactory.getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblGiorno = _viewFactory.getLabel();
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
	public JPanel oraToPanel(Ora orario){
		/*Creo un pannello con l'ora*/
		JPanel panelOra = _viewFactory.getPanel(false);
		/*Setto il layout*/
		panelOra.setLayout(new BoxLayout(panelOra, BoxLayout.PAGE_AXIS));
		/*Elementi del pannello*/
		JLabel lblOrario = _viewFactory.getLabel();
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
	public JPanel servizioInternoInPrenotazioneToPanel(ServizioInterno servizioInterno) {
		// Chiedo al catalogo il descrittore del servizio
		DescrizioneServizioInterno descrizioneServizio=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(servizioInterno.get_codice());
		/*Creo un pannello*/
		JPanel panelServizioInterno =_viewFactory.getPanel(false);
		/*Setto il layout*/
		panelServizioInterno.setLayout(new BoxLayout(panelServizioInterno, BoxLayout.PAGE_AXIS));
		
		/*Elementi del pannello*/
		//lbl con il codice
		JLabel lblCodiceServizio = _viewFactory.getLabel();
		lblCodiceServizio.setText(descrizioneServizio.get_codice());
		//lbl con nome del servizio
		JLabel lblNomeServizio = _viewFactory.getLabel();
		lblNomeServizio.setText(descrizioneServizio.get_nome());
		//lbl con note
		JLabel lblNote = _viewFactory.getLabel();
		lblNote.setText("Note al servizio: " + servizioInterno.get_note());
		//lbl data
		JLabel lblData = _viewFactory.getLabel();
		lblData.setText("Data del servizio: ");
		//lbl orario
		JLabel lblOrario = _viewFactory.getLabel();
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
	public JPanel servizioPayTvToPanel(ServizioPayTv servizioPayTv) {
		JPanel pnlLista = _viewFactory.getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblCodice = _viewFactory.getLabel();
		lblCodice.setText(servizioPayTv.get_codice());
		
		JLabel lblEvento = _viewFactory.getLabel();
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
	public JPanel servizioTelefono(ServizioTelefono servizioTelefono) {
		JPanel pnlLista = _viewFactory.getPanel(false);
		// Setto layou pnlLista
		pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.PAGE_AXIS));
		// Elementi pnl
		JLabel lblCodice = _viewFactory.getLabel();
		lblCodice.setText(servizioTelefono.get_codice());
		
		JLabel lblEvento = _viewFactory.getLabel();
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
	public JPanel totalePrenotazioneToString(SoggiornoContextSubject prenotazione){
		Prezzo importoTotalePrenotazione = prenotazione.get_importoTotaleCamere().somma(prenotazione.getPrezzoServiziInterni());
		//chiedo alla prenotazione quanto è il suo totale e la sua valuta
		String totalePrenotazione = String.valueOf(importoTotalePrenotazione.get_importo());
		String totalePagato = String.valueOf(prenotazione.get_importoTotalePagamenti().get_importo());
		
		JPanel pnlPagamenti  = _viewFactory.getPanel();
		JLabel lblImportoTotale = _viewFactory.getLabel();
		JLabel lblImportoVersato = _viewFactory.getLabel();
		
		lblImportoTotale.setText("Il totale della prenotazione è: " + totalePrenotazione);
		lblImportoVersato.setText("L'importo già versato è: "+totalePagato);
		
		pnlPagamenti.add(lblImportoTotale);
		pnlPagamenti.add(lblImportoVersato);
		
		return pnlPagamenti;
	}

}