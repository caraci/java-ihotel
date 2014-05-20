/**
 * 
 */
package com.iHotel.view.Utility;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.ForeignSystem.PayTv.ServizioPayTv;
import com.iHotel.model.ForeignSystem.Telephone.ServizioTelefono;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;

/**
 * Classe addetta alla creazione delle stringhe relative a gli oggetti dello strato di dominio.
 * @author Eugenio
 */
public class UtoString {
	/* ------------------------------ Attributi e costruttore ----------------------------------- */
	// Singleton
	private static UtoString instance=null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private UtoString() {}
	/* --------------------------------- Metodi statici -------------------------------------- */ 
	/**
	 * Metodo per ottenere l'unica instanza di questa classe.
	 */
	public static UtoString getInstance() {
		if(instance == null) {
            instance = new UtoString();
         }
         return instance;
	}
	/* --------------------------------- Metodi di instanza -------------------------------------- */
	/**
	 * Metodo per ottenere la stringa relativa alle informazioni di un ospite.
	 * @param ospite Ospite in analisi.
	 * @return Stringa contenente le informazioni dell'ospite.
	 */
	public String ospiteToString(Ospite ospite) {
		// Stringa
		String string = ospite.get_nome() + ospite.get_cognome();
		return string;
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
	 * @return Stringa contenente le informazioni del servizio.
	 */
	public String servizioPayTv(ServizioPayTv servizioPayTv) {
		// String
		String string = servizioPayTv.get_codice() + " " + servizioPayTv.get_evento() + " " + giornoToString(servizioPayTv.get_giorno());
		return string;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un servizio del Telefono.
	 * 
	 * @param servizioTelefono Servizio in analisi.
	 * @return Stringa contenente le informazioni del servizio.
	 */
	public String servizioTelefono(ServizioTelefono servizioTelefono) {
		// String
		String string = servizioTelefono.get_codice() + " " + servizioTelefono.get_telefonoMittente() + " " + giornoToString(servizioTelefono.get_giorno());
		return string;
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
