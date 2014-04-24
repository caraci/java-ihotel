package com.iHotel.model.ForeignSystem.PayTv;

import java.util.*;

import com.iHotel.model.ForeignSystem.IServiceSystem;

public interface IPayTvAdapter extends IServiceSystem {
	/**
	 * Metodo per ottenere l'elenco di servizi del sistema esterno.
	 * @return Lista di servizi del sistema esterno.
	 */
	public LinkedList<ServizioPayTv> getElencoEventi();

}