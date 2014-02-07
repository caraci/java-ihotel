package com.iHotel.model;

public class MStatoCamera {

	private MPeriodo _periodo;
	private boolean _libera;

	/**
	 * @return the _periodo
	 */
	public MPeriodo get_periodo() {
		return _periodo;
	}

	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(MPeriodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * 
	 * @return
	 */
	public boolean get_libera() {
		return this._libera;
	}

	/**
	 * 
	 * @param _libera
	 */
	public void set_libera(boolean _libera) {
		this._libera = _libera;
	}
	/*
	 * 
	 * @param periodo
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodo){
		//System.out.print(periodo.get_dataFine());
		System.out.print(_periodo.get_dataFine());
		if( _periodo.get_dataFine()<= periodo.get_dataFine() && _periodo.get_dataFine()>=periodo.get_dataInizio() || 
				_periodo.get_dataInizio()<=periodo.get_dataFine()&& _periodo.get_dataInizio()>=periodo.get_dataInizio()){
			System.out.print("periodo buono");
			if (this.get_libera()==false){
				System.out.print("falso");
				return false;
			}
		}
		System.out.print("vero");
		return true;
	}

}