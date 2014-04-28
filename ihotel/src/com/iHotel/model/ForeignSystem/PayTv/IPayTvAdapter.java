package com.iHotel.model.ForeignSystem.PayTv;

import java.util.*;

import com.iHotel.model.ForeignSystem.IServiceSystem;
/**
 * Questa classe è l'interfaccia all'adattatore del sistema esterno riguardante il servizio di "Pay Tv"
 * @author Alessandro
 *
 */
public interface IPayTvAdapter extends IServiceSystem {
	/**
	 * Metodo per ottenere l'elenco di servizi del sistema esterno.
	 * @return Lista di servizi del sistema esterno.
	 */
	public LinkedList<ServizioPayTv> getElencoEventi();

}