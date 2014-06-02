package com.iHotel.view.Utility;

/**
 * Pattern Observer. Una classe che implementa questa classe deve implementare un metodo che gli consenta
 * di essere avvisato quando l'oggetto che sta osservando cambia stato. E' stato introdotto questo design
 * pattern, perchè alcuni oggetti software devono aggiornarsi quando cambia lo stato interno di altri oggetti
 * software.
 * 
 * @author Alessandro
 */
public interface IObserver {
	/**
	 * Metodo per informare l'osservatore che il subject ha cambiato stato - Pattern Observer
	 */
	void Update();
}