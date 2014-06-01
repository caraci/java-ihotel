/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno.CheckIn;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import net.sourceforge.jdatepicker.DateModel;

import com.iHotel.controller.CModificaSoggiorno;
import com.iHotel.model.Persona.Indirizzo;
import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Persona.Residenza;
import com.iHotel.model.Persona.Documenti.CartaIdentita;
import com.iHotel.model.Persona.Documenti.Documento;
import com.iHotel.model.Persona.Documenti.Passaporto;
import com.iHotel.model.Persona.Documenti.Patente;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.view.Graphic.GestioneSoggiorno.CheckIn.VPC_AggiungiOspiti_PanelCamera;

/**
 * Classe addetta alla gestione dell'evento per aggiungere un ospite alla prenotazione.
 * @author Eugenio
 *
 */
public class AggiungiOspiteAllaPrenotazioneListener implements ActionListener {
	
	/* ------------------------- Attributi e costruttore ---------------------- */
	/**
	 * Pannello contenente la lista degli ospiti.
	 */
	private VPC_AggiungiOspiti_PanelCamera _panelCamera;
	/**
	 * Costruttore.
	 * 
	 * @param pnlMiddleRight Pannello contenente la lista degli ospiti.
	 */
	public AggiungiOspiteAllaPrenotazioneListener(VPC_AggiungiOspiti_PanelCamera panelCamera) {
		_panelCamera=panelCamera;
	}
	
	/* -------------------------- Metodi di instanza ---------------------------- */

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Carico il gestore per la modifica della prenotazione..
		CModificaSoggiorno modificaPrenotazione = CModificaSoggiorno.getInstance();
		// Aggiungo l'ospite alla prenotazione.
		modificaPrenotazione.aggiungiOspite(_panelCamera.get_camera(), getOspiteInserito());
		// Prendo il pannello dove si va a mostrare la lista degli ospiti
		JPanel pnlMiddleRight = _panelCamera.get_pnlMiddleRight();
		// Prendo il layout del pannello
		CardLayout cardLayout = (CardLayout) pnlMiddleRight.getLayout();
		// Aggiungo una nuova scheda al pannello.
		pnlMiddleRight.add(_panelCamera.creaPanelListaOspiti());
		// Mostro la prossima scheda
		cardLayout.next(pnlMiddleRight);
		// Rimuovo il pannello precedente.
		pnlMiddleRight.remove(pnlMiddleRight.getComponent(0));
	}
	/**
	 * Metodo per ottenere l'ospite inserito.
	 * 
	 * @return Ospite da inserire.
	 */
	public Ospite getOspiteInserito() {
		// Inizializzazione oggetto
		Ospite ospite = new Ospite();
		// Assegno valori all'ospite.
		ospite.set_nome(_panelCamera.get_txtNome().getText());
		ospite.set_cognome(_panelCamera.get_txtCognome().getText());
		// Ricavo il documento  che si è scelto di inserire.
		String tipoDocumento=(String) _panelCamera.get_comboBoxTipologieDocumenti().getSelectedItem();
		// Ricavo il giusto documento
		Documento documentoOspite=null;
		// Scelgo in base al tipoDocumento quale documento creare.
		switch (tipoDocumento) {
		
		case "CartaIdentita":
			documentoOspite=getCartaIdentita();
			break;
		case "Patente":
			documentoOspite=getPatente();
			break;
		case "Passaporto":
			documentoOspite=getPassaporto();
			break;
		default:
			break;
		}
		// Aggiungo il documento all'ospite
		ospite.set_documento(documentoOspite);
		
		return ospite;
	}
	/**
	 * Metodo per ottenere la carta di identità.
	 * 
	 * @return Carta di identità dell'ospite.
	 */
	public CartaIdentita getCartaIdentita() {
		CartaIdentita cartaIdentita = new CartaIdentita();
		
		// Ricavo il calendario per il giorno di nascita
		DateModel<?> dataNascita=_panelCamera.get_dataNascita().getModel();
		// Creo il giorno per la data di nascita
		Giorno giornoNascita = new Giorno(dataNascita.getDay(),dataNascita.getMonth(),dataNascita.getYear());
		
		// Ricavo il calendario per il giorno di rilascio
		DateModel<?> dataRilascio=_panelCamera.get_dataRilascioCartaIdentita().getModel();
		// Creo il giorno per la data di rilascio
		Giorno giornoRilascio = new Giorno(dataRilascio.getDay(),dataRilascio.getMonth(),dataRilascio.getYear());
		
		// Ricavo il calendario per il giorno di scadenza
		DateModel<?> dataScadenza=_panelCamera.get_dataScadenzaCartaIdentita().getModel();
		// Creo il giorno per la data di scadenza
		Giorno giornoScadenza = new Giorno(dataScadenza.getDay(),dataScadenza.getMonth(),dataScadenza.getYear());
		
		// Codice
		String codice = _panelCamera.get_txtCartaIdentitaCodice().getText();
		// Ente
		String ente = _panelCamera.get_txtCartaIdentitaEnte().getText();
		
		// TODO - Creo residenza fittizzia
		Indirizzo indirizzo = new Indirizzo("Via Roma", 1);
		Residenza residenza = new Residenza("Rieti", indirizzo);
		
		// Setto gli attributi della carta di identità.
		cartaIdentita.set_numeroDocumento(codice);
		cartaIdentita.set_enteRilasciatario(ente);
		cartaIdentita.set_dataDiNascita(giornoNascita);
		cartaIdentita.set_dataDiRilascio(giornoRilascio);
		cartaIdentita.set_dataDiScadenza(giornoScadenza);
		cartaIdentita.set_residenza(residenza);
		
		return cartaIdentita;
	}
	/**
	 * Metodo per ottenere le informazioni della patente.
	 * 
	 * @return Patente dell'ospite.
	 */
	public Patente getPatente() {
		Patente patente = new Patente();
		
		// Ricavo il calendario per il giorno di nascita
		DateModel<?> dataNascita=_panelCamera.get_dataNascita().getModel();
		// Creo il giorno per la data di nascita
		Giorno giornoNascita = new Giorno(dataNascita.getDay(),dataNascita.getMonth(),dataNascita.getYear());
		
		// Ricavo il calendario per il giorno di rilascio
		DateModel<?> dataRilascio=_panelCamera.get_dataRilascioPatente().getModel();
		// Creo il giorno per la data di rilascio
		Giorno giornoRilascio = new Giorno(dataRilascio.getDay(),dataRilascio.getMonth(),dataRilascio.getYear());
		
		// Ricavo il calendario per il giorno di scadenza
		DateModel<?> dataScadenza=_panelCamera.get_dataScadenzaPatente().getModel();
		// Creo il giorno per la data di scadenza
		Giorno giornoScadenza = new Giorno(dataScadenza.getDay(),dataScadenza.getMonth(),dataScadenza.getYear());
		
		// Codice
		String codice = _panelCamera.get_txtPatenteCodice().getText();
		// Ente
		String ente = _panelCamera.get_txtPatenteEnte().getText();
		
		// TODO - Creo residenza fittizzia
		Indirizzo indirizzo = new Indirizzo("Via Roma", 1);
		Residenza residenza = new Residenza("Rieti", indirizzo);
		
		// Setto gli attributi della patente.
		patente.set_numeroDocumento(codice);
		patente.set_enteRilasciatario(ente);
		patente.set_dataDiNascita(giornoNascita);
		patente.set_dataDiRilascio(giornoRilascio);
		patente.set_dataDiScadenza(giornoScadenza);
		patente.set_residenza(residenza);
				
		return patente;
	}
	/**
	 * Metodo per ottenere le informazioni del passaporto.
	 * 
	 * @return Passaporto dell'ospite.
	 */
	public Passaporto getPassaporto() {
		Passaporto passaporto = new Passaporto();
		
		// Ricavo il calendario per il giorno di nascita
		DateModel<?> dataNascita=_panelCamera.get_dataNascita().getModel();
		// Creo il giorno per la data di nascita
		Giorno giornoNascita = new Giorno(dataNascita.getDay(),dataNascita.getMonth(),dataNascita.getYear());
		
		// Ricavo il calendario per il giorno di rilascio
		DateModel<?> dataRilascio=_panelCamera.get_dataRilascioPassaporto().getModel();
		// Creo il giorno per la data di rilascio
		Giorno giornoRilascio = new Giorno(dataRilascio.getDay(),dataRilascio.getMonth(),dataRilascio.getYear());
		
		// Ricavo il calendario per il giorno di scadenza
		DateModel<?> dataScadenza=_panelCamera.get_dataScadenzaPassaporto().getModel();
		// Creo il giorno per la data di scadenza
		Giorno giornoScadenza = new Giorno(dataScadenza.getDay(),dataScadenza.getMonth(),dataScadenza.getYear());
		
		// Codice
		String codice = _panelCamera.get_txtPassaportoCodice().getText();
		// Ente
		String ente = _panelCamera.get_txtPassaportoEnte().getText();
		
		// TODO - Creo residenza fittizzia
		Indirizzo indirizzo = new Indirizzo("Via Roma", 1);
		Residenza residenza = new Residenza("Rieti", indirizzo);
		
		// Setto gli attributi della patente.
		passaporto.set_numeroDocumento(codice);
		passaporto.set_enteRilasciatario(ente);
		passaporto.set_dataDiNascita(giornoNascita);
		passaporto.set_dataDiRilascio(giornoRilascio);
		passaporto.set_dataDiScadenza(giornoScadenza);
		passaporto.set_residenza(residenza);
		
		return passaporto;
	}
	
	

}
