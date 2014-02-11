package com.iHotel.model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Eugenio
 */
public class MElementoPrenotazione {

	private MCamera _camera;
	
	public double getSubTotal(MPeriodo periodo){
		
		// Data di inizio della richiesta
		GregorianCalendar dataInizio = new GregorianCalendar();
		// Data di fine della richiesta
		GregorianCalendar dataFine= new GregorianCalendar();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		HashMap<String,ArrayList<MPrezzoCamera>> prezziTipologia= new HashMap<String,ArrayList<MPrezzoCamera>>();
		// Tipologia della camera
		String tipologia=_camera.get_tipologia();
		MCatalogoCamere catalogo = MCatalogoCamere.getInstance();
		
		prezziTipologia=catalogo.getPrezziInPeriodoDaTipologia(periodo, tipologia);
		
		double totaleGiorno=0;
		double totalePeriodo=0;
		
		while (dataInizio.compareTo(dataFine) < 0) {
		
			totaleGiorno=calcolaPrezzoGiorno(prezziTipologia.get(tipologia),dataInizio);
			totalePeriodo=totalePeriodo+totaleGiorno;
			dataInizio.add(Calendar.DAY_OF_MONTH,1);
		}
		return totalePeriodo;
		
	}
	/**
	 * Metodo per calcolare il prezzo in un giorno relativo ad una camera. 
	 */
	private double calcolaPrezzoGiorno(ArrayList<MPrezzoCamera> prezziCamera, GregorianCalendar data){
		
		// Creo un periodo con data inizio uguale a data fine
		MPeriodo periodo= new MPeriodo();
		periodo.set_giornoInizio(data.get(Calendar.DATE));
		periodo.set_meseInizio(data.get(Calendar.MONTH));
		periodo.set_annoInizio(data.get(Calendar.YEAR));
		periodo.set_giornoFine(data.get(Calendar.DATE));
		periodo.set_meseFine(data.get(Calendar.MONTH));
		periodo.set_annoFine(data.get(Calendar.DATE));
		
		double prezzoGiorno=0;
		MPrezzoCamera prezzoCameraPeriodo = new MPrezzoCamera();
		for (Iterator<MPrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera prezzoCamera = (MPrezzoCamera) iterator.next();
			prezzoCameraPeriodo=prezzoCamera.getPrezzoInPeriodo(periodo);
			prezzoGiorno=prezzoCameraPeriodo.get_prezzo();
		}
		return prezzoGiorno;
	}
	/*
	 * RICONTROLLARE 
	 * 
	 */
	public boolean occupaCameraInPeriodo(MPeriodo periodo){
		
		if(_camera.occupaInPeriodo(periodo)==true){
			return true;
		}else return false;
	}

	/**
	 * @return the _camera
	 */
	public MCamera get_camera() {
		return _camera;
	}

	/**
	 * @param _camera the _camera to set
	 */
	public void set_camera(MCamera camera) {
		this._camera = camera;
	}

	

}