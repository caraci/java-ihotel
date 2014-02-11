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
		
		// Data di inizio dello MStatoCamera
		GregorianCalendar dataInizio = new GregorianCalendar();
		// Data di fine dello MStatoCamera
		GregorianCalendar dataFine= new GregorianCalendar();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		HashMap<String,ArrayList<MPrezzoCamera>> prezziTipologia= new HashMap<String,ArrayList<MPrezzoCamera>>();
		
		
		String tipologia=_camera.get_tipologia();
		MCatalogoCamere catalogo = MCatalogoCamere.getInstance();
		
		prezziTipologia=catalogo.getPrezziInPeriodoDaTipologia(periodo, tipologia);
		
		double totaleGiorno=0;
		double totalePeriodo=0;
		
		while (dataInizio.compareTo(dataFine)!=0) {
		
		totaleGiorno=calcolaPrezzoGiorno(prezziTipologia.get(tipologia),dataInizio);
		totalePeriodo=totalePeriodo+totaleGiorno;
		
		dataInizio.add(Calendar.DAY_OF_MONTH,1);
		}
		return totaleGiorno;
		
	}
	/*
	 *metodo privato 
	 */
	private double calcolaPrezzoGiorno(ArrayList<MPrezzoCamera> prezziCamera, GregorianCalendar data){
		
		MPeriodo periodo= new MPeriodo();
		periodo.set_giornoInizio(data.get(Calendar.DATE));
		periodo.set_meseInizio(data.get(Calendar.MONTH));
		periodo.set_annoInizio(data.get(Calendar.YEAR));
		periodo.set_giornoFine(data.get(Calendar.DATE));
		periodo.set_meseFine(data.get(Calendar.MONTH));
		periodo.set_annoFine(data.get(Calendar.DATE));
		
		double prezzoGiorno=0;
		for (Iterator<MPrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera prezzoCamera = (MPrezzoCamera) iterator.next();
			prezzoCamera=prezzoCamera.getPrezzoInPeriodo(periodo);
			prezzoGiorno=prezzoCamera.get_prezzo();
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