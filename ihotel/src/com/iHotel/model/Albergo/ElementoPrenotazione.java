package com.iHotel.model.Albergo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Periodo;

/**
 * @author Eugenio
 */
public class ElementoPrenotazione {

	/* -------------------------------------- Attributi ------------------------------- */
	
	private CameraContext attribute;
	/**
	 * -------------------------------------- Attributi -------------------------------
	 */
	private CameraContext _camera;
	
	/* ----------------------------------- Metodi di instanza -------------------------- */
	
	/**
	 * Metodo per ottere il subTotale di una prenotazione dovuto ad un unico elemento.
	 * 
	 * @param 	periodo	Periodo della prenotazione
	 * @return 	double 	Subtotale della prenotazione per quella camera in tutto il periodo.
	 */
	public double getSubTotal(Periodo periodo){
		
		// Data di inizio della richiesta.
		GregorianCalendar dataInizio = new GregorianCalendar();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio(),periodo.get_oraInizio(),periodo.get_minutoInizio());
		// Data di fine della richiesta.
		GregorianCalendar dataFine= new GregorianCalendar();
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine(),periodo.get_oraFine(),periodo.get_minutoFine());
	
		// Ricavo l'instanza della classe MCatalogoCamere attraverso il pattern Singleton.
		CatalogoCamere catalogo = CatalogoCamere.getInstance();
		// Ricavo l'insieme dei prezzi della tipologia della camera in un certo periodo.
		ArrayList<PrezzoCamera> prezziTipologia = new ArrayList<PrezzoCamera>();
		prezziTipologia=catalogo.getPrezziInPeriodoDaTipologia(periodo, _camera.get_tipologia());
		
		// Variabili nelle quali si andranno a memorizzare i totali.
		double totaleCameraGiorno=0;
		double totaleCameraPeriodo=0;
		
		// Ciclo a partire dal giorno di inizio fino al giorno finale.
		while (dataInizio.compareTo(dataFine) < 0) {
		
			// Calcolo il prezzo della camera in un giorno attraverso il metodo privato di MElementoPrenotazione
			totaleCameraGiorno=calcolaPrezzoGiorno(prezziTipologia,dataInizio);
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
	private double calcolaPrezzoGiorno(ArrayList<PrezzoCamera> prezziCamera, GregorianCalendar data){	
		// Creo un periodo con data inizio uguale a data fine
		Periodo periodo= new Periodo();
		periodo.setDataInizioDaData(data);	
		periodo.setDataFineDaData(data);
		// Variabile nella quale andremo a memorizzare il totale per il giorno.
		double prezzoGiorno=0;
		
		PrezzoCamera prezzoCameraPeriodo = new PrezzoCamera();
		// Ciclo su tutti gli MPrezzoCamera che ho a disposizione
		for (Iterator<PrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			PrezzoCamera prezzoCamera = (PrezzoCamera) iterator.next();
			if (prezzoCamera.getPrezzoInPeriodo(periodo)!=null) {
				prezzoCameraPeriodo=prezzoCamera.getPrezzoInPeriodo(periodo);
				prezzoGiorno=prezzoCameraPeriodo.get_prezzo();
			}
		}
		return prezzoGiorno;
	}
	/**
	 * Metodo per occupare una camera in un determinato periodo.
	 * 
	 * @param periodo Periodo nel quale si vuole occupare una camera.
	 */
	public void occupaCameraInPeriodo(Periodo periodo) {
		_camera.occupaInPeriodo(periodo);
	}
	
	/* ---------------------------------- Getter e Setter -------------------------------- */
	/**
	 * @return  _camera
	 */
	public CameraContext getAttribute() {
		return attribute;
	}

	/**
	 * @param _camera 
	 */
	public void setAttribute(CameraContext camera) {
		this.attribute = camera;
	}

	public CameraContext get_camera() {
		return this._camera;
	}

	public void set_camera(CameraContext _camera) {
		this._camera = _camera;
	}

	

}