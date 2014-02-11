package com.iHotel.model;
import java.util.ArrayList;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Eugenio
 */
public class MElementoPrenotazione {

	private MCamera _camera;
	
	public double getSubTotal(MPeriodo periodo){
		
		double subtot=0;
		// Data di inizio dello MStatoCamera
		GregorianCalendar dataInizio = new GregorianCalendar();
		// Data di fine dello MStatoCamera
		GregorianCalendar dataFine= new GregorianCalendar();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
		HashMap<String,ArrayList<MPrezzoCamera>> prezziTipologia= new HashMap<String,ArrayList<MPrezzoCamera>>();
		if(dataInizio.compareTo(dataFine)<0){
			String tipologia=_camera.get_tipologia();
			MCatalogoCamere catalogo = MCatalogoCamere.getInstance();
			prezziTipologia=catalogo.getPrezziInPeriodoDaTipologia(periodo, tipologia);
			
			MPeriodo periodoGiorno= new MPeriodo();
			periodoGiorno=this.calcolagiorno();
		};
		return subtot;

	}
	/*
	 *metodo privato 
	 */
	private MPeriodo calcolagiorno(){
		MPeriodo periodo=new MPeriodo();
		return periodo;
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