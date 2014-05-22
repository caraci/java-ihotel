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
import com.iHotel.model.Utility.Periodo;
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
	 * @param periodo Periodo in analisi.
	 * @return Stringa contenente le informazioni del periodo.
	 */
	public String periodoToString(Periodo periodo) {
		Giorno dataInizio = periodo.get_dataInizio();
		Giorno dataFine = periodo.get_dataFine();
		// Mesi
		int meseInizio = dataInizio.get_mese() + 1;
		int meseFine = dataFine.get_mese() + 1;
		// Stringa 
		String toString="Periodo: "+ "Inizio: " + dataInizio.get_giorno() + "-" + meseInizio + "-" + dataInizio.get_anno() +" "+
				   					 "Fine: " + dataFine.get_giorno() + "-" + meseFine + "-" + dataFine.get_anno();
		return toString;
		
	}
	/**
	 * Metodo per ottenere la stringa relativa ad una data.
	 * @param giorno Giorno in analisi.
	 * @return Stringa contenente le informazioni della data.
	 */
	public String giornoToString(Giorno giorno) {
		// Mese
		int mese = giorno.get_mese() + 1;
		// Stringa
		String toString="Data: " + giorno.get_giorno() + "-" + mese + "-" + giorno.get_anno();
		return toString;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un servizio interno.
	 * @param servizioInterno Servizio in analisi.
	 * @return Stringa contenente le informazioni di un servizio.
	 */
	public String servizioInternoInPrenotazioneToString(ServizioInterno servizioInterno) {
		// Chiedo al catalogo il descrittore del servizio
		DescrizioneServizioInterno descrizioneServizio=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(servizioInterno.get_codice());
		// Stringa
		String toString = descrizioneServizio.get_codice() + " " + descrizioneServizio.get_nome() + " " + giornoToString(servizioInterno.get_giorno());
		
		return toString;
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
	public String totalePrenotazioneToString(SoggiornoContextSubject prenotazione){
		//chiedo alla prenotazione quanto è il suo totale e la sua valuta
		String totale = "L'ammontare complessivo della prenotazione è: " + prenotazione.get_total().get_importo() + prenotazione.get_total().get_valuta();
		return totale;
	}

}
