package com.iHotel.model;

import java.util.*;

public class MDescrizioneCamera {

	/* -------------------------- Attributi -------------------------------------- */
	
	private ArrayList<MPrezzoCamera> _prezziCamera=new ArrayList<MPrezzoCamera>();
	private String _tipologia;

	/* ----------------------- Metodi di instanza ----------------------------------------- */
	
	/**
	 * Metodo per ottenere tutti i prezzi per una tipologia di camera, in un certo periodo.
	 * 
	 * @param periodo	Periodo generico
	 * @return 			prezzi per una tipologia di camera in un periodo
	 */
	public ArrayList<MPrezzoCamera> getPrezziInPeriodo(MPeriodo periodo) {
		ArrayList<MPrezzoCamera> prezziCamera = new ArrayList<MPrezzoCamera>();
		MPrezzoCamera prezzoCameraPeriodo = new MPrezzoCamera();
		// Ciclo sugli MPrezzoCamera 
		for (Iterator<MPrezzoCamera> iterator = _prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera prezzoCamera = iterator.next();
			// Se otteniamo un MPrezzoCamera valido lo aggiungo alla lista.
			if(prezzoCamera.getPrezzoInPeriodo(periodo) != null) {
				prezzoCameraPeriodo = prezzoCamera.getPrezzoInPeriodo(periodo);
				//System.out.println(prezzoCameraPeriodo.get_prezzo());
				prezziCamera.add(prezzoCameraPeriodo);
			}
		}		
		return prezziCamera;
	}
	
	/* ------------------------------- Getter e Setter -------------------- */
	/**
	 * @return _prezziCamera  
	 */
	public ArrayList<MPrezzoCamera> get_prezziCamera() {
		return _prezziCamera;
	}

	/**
	 * @param _prezziCamera 
	 */
	public void set_prezziCamera(ArrayList<MPrezzoCamera> _prezziCamera) {
		this._prezziCamera = _prezziCamera;
	}

	/**
	 * @return _tipologia
	 */
	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}

	/**
	 * Metodo che calcola il prezzo per la tipologia di camera descritta dal descrittore,
	 * nel periodo passato come parametro.
	 * 
	 * @param periodo Periodo della prenotazione
	 * @return totaleCameraPeriodo Costo totale della camera durante il soggiorno
	 */
	public double calcolaPrezzoInPeriodo(MPeriodo periodo) {
		// Data di inizio della richiesta.
		GregorianCalendar dataInizio = new GregorianCalendar();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio(),periodo.get_oraInizio(),periodo.get_minutoInizio());
		// Data di fine della richiesta.
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine(),periodo.get_oraFine(),periodo.get_minutoFine());
	
					
		// Variabili nelle quali si andranno a memorizzare i totali.
		double totaleCameraGiorno=0;
		double totaleCameraPeriodo=0;
		
		// Ciclo a partire dal giorno di inizio fino al giorno finale.
		while (dataInizio.compareTo(dataFine) < 0) {
		
			// Calcolo il prezzo della camera in un giorno attraverso il metodo privato di MElementoPrenotazione
			totaleCameraGiorno=calcolaPrezzoGiorno(_prezziCamera,dataInizio);
			// Sommo il totale della camera nel giorno, al totale della camera per il periodo.
			totaleCameraPeriodo+=totaleCameraGiorno;
			// Incremento il giorno di uno.
			dataInizio.add(Calendar.DAY_OF_MONTH,1);
		}
		//System.out.println(totaleCameraPeriodo);
		return totaleCameraPeriodo;
		
	}
	
/**
 * Metodo per calcolare il prezzo in un giorno relativo ad una camera.
 * 
 * @param prezziCamera Insieme dei prezzi della camera.	
 * @param data Giorno in cui bisogna calcolare il prezzo della camera
 * @return Prezzo della camera in un giorno.
 */
private double calcolaPrezzoGiorno(ArrayList<MPrezzoCamera> prezziCamera, GregorianCalendar data){	
	// Creo un periodo con data inizio uguale a data fine
	MPeriodo periodo= new MPeriodo();
	periodo.setDataInizioDaData(data);	
	periodo.setDataFineDaData(data);
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
	


}