/**
 * 
 */
package com.iHotel.model.Utility;

import java.util.GregorianCalendar;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class MyDate extends GregorianCalendar {
	/**
	 * Costruttore.
	 */
	public MyDate() {
		super();
		// Azzero i campi relativi ad ora, minuto e secondo.
		this.clear();
	}
}
