/**
 * 
 */
package com.iHotel.view.Utility;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
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
	 * Metodo per ottenere la stringa relativa ad un servizio esterno.
	 * @param servizioEsterno Servizio in analisi.
	 * @return Stringa contenente le informazioni di un servizio.
	 */
	public String servizioEsternoInPrenotazioneToString(ServizioEsterno servizioEsterno) {
		// String
		String string = servizioEsterno.get_codice() + " " + servizioEsterno.get_descrizione() + " " + giornoToString(servizioEsterno.get_giorno());
		return string;
	}

}
