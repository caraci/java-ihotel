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
 * @author Eugenio
 *
 */
public class UtoString {
	/* ------------------------------ Attributi e costruttore ----------------------------------- */
	private static UtoString instance=null;
	
	private UtoString() {}
	/* --------------------------------- Metodi statici -------------------------------------- */ 
	public static UtoString getInstance() {
		if(instance == null) {
            instance = new UtoString();
         }
         return instance;
	}
	/* --------------------------------- Metodi di instanza -------------------------------------- */
	/**
	 * 
	 * @param ospite
	 * @return
	 */
	public String ospiteToString(Ospite ospite) {
		// Stringa
		String string = ospite.get_nome() + ospite.get_cognome();
		return string;
	}
	/**
	 * 
	 * @param periodo
	 * @return
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
	 * 
	 * @param date
	 * @return
	 */
	public String myDateToString(MyDate date) {
		// Stringa
		String toString="Data: " + date.get(Calendar.DATE) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.YEAR);
		return toString;
	}
	/**
	 * 
	 * @param servizioInterno
	 * @return
	 */
	public String servizioInternoInPrenotazioneToString(ServizioInterno servizioInterno) {
		// Chiedo al catalogo il descrittore del servizio
		DescrizioneServizioInterno descrizioneServizio=CatalogoServiziInterni.getInstance().getDescrizioneServizioDaCodice(servizioInterno.get_codice());
		// Stringa
		String toString = descrizioneServizio.get_codice() + " " + descrizioneServizio.get_nome() + " " + myDateToString(servizioInterno.get_data());
		
		return toString;
	}
	/**
	 * 
	 * @param servizioEsterno
	 * @return
	 */
	public String servizioEsternoInPrenotazioneToString(ServizioEsterno servizioEsterno) {
		// String
		String string = servizioEsterno.get_codice() + " " + servizioEsterno.get_descrizione() + " " + myDateToString(servizioEsterno.get_data());
		return string;
	}

}
