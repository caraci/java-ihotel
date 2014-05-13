/**
 * 
 */
package com.iHotel.view.Utility;

import java.util.Calendar;

import com.iHotel.model.Albergo.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.CatalogoServiziInterni;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.Utility.MyDate;
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
		// Per problemi legati al salvataggio delle date da parte della classe MyDate dobbiamo incrementare il valore del mese.
		int meseInizio = periodo.get_meseFine()+1;
		int meseFine = periodo.get_meseFine()+1;
		// Stringa 
		String toString="Periodo: "+ "Inizio: " + periodo.get_giornoInizio() + "-" + meseInizio + "-" + periodo.get_annoInizio() +" "+
				   					 "Fine: " + periodo.get_giornoFine() + "-" + meseFine + "-" + periodo.get_annoFine();
		return toString;
		
	}
	/**
	 * Metodo per ottenere la stringa relativa ad una data.
	 * @param date Data in analisi.
	 * @return Stringa contenente le informazioni della data.
	 */
	public String myDateToString(MyDate date) {
		int mese = date.get(Calendar.MONTH) + 1;
		// Stringa
		String toString="Data: " + date.get(Calendar.DATE) + "-" + mese + "-" + date.get(Calendar.YEAR);
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
		String toString = descrizioneServizio.get_codice() + " " + descrizioneServizio.get_nome() + " " + myDateToString(servizioInterno.get_giorno().toMyDate());
		
		return toString;
	}
	/**
	 * Metodo per ottenere la stringa relativa ad un servizio esterno.
	 * @param servizioEsterno Servizio in analisi.
	 * @return Stringa contenente le informazioni di un servizio.
	 */
	public String servizioEsternoInPrenotazioneToString(ServizioEsterno servizioEsterno) {
		// String
		String string = servizioEsterno.get_codice() + " " + servizioEsterno.get_descrizione() + " " + myDateToString(servizioEsterno.get_giorno().toMyDate());
		return string;
	}

}
