/**
 * 
 */
package com.iHotel.view.Event.GestionePrenotazione;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;

import com.iHotel.controller.CModificaPrenotazione;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;
import com.iHotel.view.Graphic.GestionePrenotazione.VFGP_AggiungiServiziInterni;

/**
 * @author Eugenio
 *
 */
public class MostraDettagliServizioListener implements ItemListener {

	/* ---------------------- Attributi e Costruttore --------------------- */
	private VFGP_AggiungiServiziInterni _aggiungiServiziInterni;
	private StyleAbstractFactory _viewFactory;
	
	public MostraDettagliServizioListener() {
		_aggiungiServiziInterni=VFGP_AggiungiServiziInterni.getInstance();
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
	}
	
	@Override
	/**
	 * Con questo metodo si va a gestire l'evento scaturito a seguito della selezione di un elemento della 
	 * lista dei servizi interni.
	 */
	public void itemStateChanged(ItemEvent e) {
		// Stringa contenente il nome del servizio interno
		String nomeServizioInterno = (String) e.getSource();
		System.out.println(nomeServizioInterno);
		// Recupero il codice del servizio
		String codiceServizio=CatalogoServiziInterni.getInstance().getCodiceServizioDaNome(nomeServizioInterno);
		// Recupero il controllore e invoco il metodo per avere ulteriori informazioni sul servizio.
		CModificaPrenotazione modificaPrenotazione = CModificaPrenotazione.getInstance();
		DescrizioneServizioInterno descrizioneServizioInterno = modificaPrenotazione.scegliServizioDaCodice(codiceServizio);
		// Setto il pannello relativo al servizio.
		_aggiungiServiziInterni.set_pnlMiddleRight(creaPanelServizioInterno(descrizioneServizioInterno));
	}
	
	/**
	 * Metodo per creare il panel relativo alle informazioni di un servizio.
	 * @param descrizioneServizioInterno 
	 * @return
	 */
	private JPanel creaPanelServizioInterno(DescrizioneServizioInterno descrizioneServizioInterno) {
		// Pannello per il servizio
		JPanel pnlDescrittoreServizio=_viewFactory.getPanel();
		// Setto il gestore del Layout al panel
		pnlDescrittoreServizio.setLayout(new BoxLayout(pnlDescrittoreServizio, BoxLayout.PAGE_AXIS));
		// Codice servizio
		JLabel lblCodice=_viewFactory.getLabel();
		lblCodice.setText("Codice del servizio: " + descrizioneServizioInterno.get_codice());
		pnlDescrittoreServizio.add(lblCodice);
		// Nome servizio
		JLabel lblNome=_viewFactory.getLabel();
		lblNome.setText("Nome del servizio: " + descrizioneServizioInterno.get_nome());
		pnlDescrittoreServizio.add(lblNome);
		// JDatePanel data servizio
		JDatePanel datePanelServizio = JDateComponentFactory.createJDatePanel();
		pnlDescrittoreServizio.add((Component) datePanelServizio);
		
		return pnlDescrittoreServizio;
	}

}
