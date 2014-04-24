package com.iHotel.model.ForeignSystem.Telephone;

import java.util.*;

import com.iHotel.model.ForeignSystem.IServiceSystem;

public interface ITelephoneAdapter extends IServiceSystem {
	/**
	 * Metodo per ottenere l'elenco di servizi del sistema esterno.
	 * @return Lista di servizi del sistema esterno.
	 */
	public LinkedList<ServizioTelefono> getElencoTelefonate();
}