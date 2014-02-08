package com.iHotel.model;
import java.util.Currency;

/**
 * @author Eugenio
 */
public class MElementoPrenotazione {

	private MCamera _camera;
	
	public Currency getSubTotal(MPeriodo periodo){
		return null;
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
	public void set_camera(MCamera _camera) {
		this._camera = _camera;
	}

	

}