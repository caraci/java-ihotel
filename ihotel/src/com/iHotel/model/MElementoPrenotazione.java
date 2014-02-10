package com.iHotel.model;
import java.util.ArrayList;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * @author Eugenio
 */
public class MElementoPrenotazione {

	private MCamera _camera;
	
	public double getSubTotal(MPeriodo periodo){
		ArrayList<MPrezzoCamera> prezziCamera= new ArrayList<MPrezzoCamera>();
		double subtot=0;
		
		// Data di inizio dello MStatoCamera
		GregorianCalendar dataInizio = new GregorianCalendar();
		// Data di fine dello MStatoCamera
		GregorianCalendar dataFine= new GregorianCalendar();		
		
		for (Iterator<MPrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera tmp = iterator.next();
			tmp.get_periodo();
			dataInizio.set(tmp.get_periodo().get_annoInizio(), tmp.get_periodo().get_meseInizio(), tmp.get_periodo().get_giornoInizio());
			dataFine.set(tmp.get_periodo().get_annoFine(), tmp.get_periodo().get_meseFine(), tmp.get_periodo().get_giornoFine());
			dataInizio.compareTo(dataFine);
			
		
			subtot=subtot+tmp.get_prezzo();
		}
		return subtot;
	}
	

	
	public boolean occupaCameraInPeriodo(MPeriodo periodo){
		return false;
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