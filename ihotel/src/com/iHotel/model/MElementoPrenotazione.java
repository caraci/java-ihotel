package com.iHotel.model;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;

/**
 * @author Eugenio
 */
public class MElementoPrenotazione {

	private MCamera _camera;
	
	public double getSubTotal(MPeriodo periodo){
		ArrayList<MPrezzoCamera> prezziCamera= new ArrayList<MPrezzoCamera>();
		prezziCamera=_camera.getPrezziInPeriodo(periodo);
		double subtot=0;
		for (Iterator<MPrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			MPrezzoCamera tmp = iterator.next();
			tmp.get_periodo();
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