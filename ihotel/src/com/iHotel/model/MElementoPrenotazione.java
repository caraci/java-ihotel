package com.iHotel.model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Eugenio
 */
public class MElementoPrenotazione {

	/* -------------------------------------- Attributi ------------------------------- */
	private MCamera _camera;
	
	/* ----------------------------------- Metodi di instanza -------------------------- */
	/**
	 * Metodo per ottere il subTotale di una prenotazione dovuto ad un unico elemento.
	 * @param 	periodo	Periodo della prenotazione
	 * @return 	double 	Subtotale della prenotazione per quella camera in tutto il periodo.
	 */
	public double getSubTotal(MPeriodo periodo){
		
		// Data di inizio della richiesta.
		GregorianCalendar dataInizio = new GregorianCalendar();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio(),periodo.get_oraInizio(),periodo.get_minutoInizio());
		// Data di fine della richiesta.
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine(),periodo.get_oraFine(),periodo.get_minutoFine());
		
		// Tipologia della camera.
		String tipologia=_camera.get_tipologia();
	
		// Ricavo l'instanza della classe MCatalogoCamere attraverso il pattern Singleton.
		MCatalogoCamere catalogo = MCatalogoCamere.getInstance();
		// Ricavo l'insieme dei prezzi della tipologia della camera in un certo periodo.
		HashMap<String,ArrayList<MPrezzoCamera>> prezziTipologia= new HashMap<String,ArrayList<MPrezzoCamera>>();
		prezziTipologia=catalogo.getPrezziInPeriodoDaTipologia(periodo, tipologia);
		
		// Variabili nelle quali si andranno a memorizzare i totali.
		double totaleCameraGiorno=0;
		double totaleCameraPeriodo=0;
		
		// Ciclo a partire dal giorno di inizio fino al giorno finale.
		while (dataInizio.compareTo(dataFine) < 0) {
		
			// Calcolo il prezzo della camera in un giorno attraverso il metodo privato di MElementoPrenotazione
			totaleCameraGiorno=calcolaPrezzoGiorno(prezziTipologia.get(tipologia),dataInizio);
			// Sommo il totale della camera nel giorno al totale della camera per il periodo.
			totaleCameraPeriodo+=totaleCameraGiorno;
			// Incremento il giorno di uno.
			dataInizio.add(Calendar.DAY_OF_MONTH,1);
		}
		//System.out.println(totaleCameraPeriodo);
		return totaleCameraPeriodo;
		
	}
	/**
	 * Metodo per calcolare il prezzo in un giorno relativo ad una camera.
	 * @param prezziCamera Insieme dei prezzi della camera.	
	 * @param data Giorno in cui bisogna calcolare il prezzo della camera
	 * @return Prezzo della camera in un giorno.
	 */
	private double calcolaPrezzoGiorno(ArrayList<MPrezzoCamera> prezziCamera, GregorianCalendar data){
		
		// Creo un periodo con data inizio uguale a data fine
		MPeriodo periodo= new MPeriodo();
		periodo.set_giornoInizio(data.get(Calendar.DATE));
		periodo.set_meseInizio(data.get(Calendar.MONTH));
		periodo.set_annoInizio(data.get(Calendar.YEAR));
		periodo.set_oraInizio(data.get(Calendar.HOUR));
		periodo.set_minutoInizio(data.get(Calendar.MINUTE));		
		
		periodo.set_giornoFine(data.get(Calendar.DATE));
		periodo.set_meseFine(data.get(Calendar.MONTH));
		periodo.set_annoFine(data.get(Calendar.DATE));
		periodo.set_oraFine(data.get(Calendar.HOUR));
		periodo.set_oraFine(data.get(Calendar.MINUTE));
		// Variabile nella quale andremo a memorizzare il totale per il giorno.
		double prezzoGiorno=0;
		
		MPrezzoCamera prezzoCameraPeriodo = new MPrezzoCamera();
		// Ciclo su tutti gli MPrezzoCamera che ho a disposizione
		for (Iterator<MPrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera prezzoCamera = (MPrezzoCamera) iterator.next();
			if (prezzoCamera.getPrezzoInPeriodo(periodo)!=null) {
				prezzoCameraPeriodo=prezzoCamera.getPrezzoInPeriodo(periodo);
				prezzoGiorno=prezzoCameraPeriodo.get_prezzo();
			}
		}
		return prezzoGiorno;
	}
	/**
	 * @param periodo
	 * @return boolean
	 * Metodo che setta occupata una carema in un determinato periodo 
	 * 
	 */
	public boolean occupaCameraInPeriodo(MPeriodo periodo) throws CloneNotSupportedException{
		
		if(_camera.occupaInPeriodo(periodo)==true){
			return true;
		}else return false;
	}
	/* ---------------------------------- Getter, Setter -------------------------------- */
	/**
	 * @return  _camera
	 * Metodo che restituisce la camera di un  ElementoPrenotazione
	 */
	public MCamera get_camera() {
		return _camera;
	}

	/**
	 * @param _camera 
	 * Metodo che setta la camera di un ElementoPrenotazione
	 */
	public void set_camera(MCamera camera) {
		this._camera = camera;
	}

	

}