package com.iHotel.model.Observer;

/**
 * Pattern Observer. Una classe che implementa questa classe deve implementare un metodo che gli consenta
 * di "attaccargli" un osservatore, di "rimuovergli" un osservatore, e di notificare a tutti i suoi osservatori
 * un suo cambiamento di stato. E' stato introdotto questo design pattern, perchè alcuni oggetti software devono 
 * aggiornarsi quando cambia lo stato interno di altri oggetti software.
 * @author Alessandro
 *
 */
public interface ISubject {
	/**
	 * Metodo per aggiungere un osservatore al subject - Pattern Observer.
	 * @param observer Osservatore da aggiungere.
	 */
	void Attach(IObserver observer);
	/**
	 * Metodo per levare un osservatore dal subject - Pattern Observer.
	 * @param observer Osservatore da togliere..
	 */
	void Detach(IObserver observer);
	/**
	 * Metodo per inviare la notifica del cambiamento di stato agli osservatori - Pattern Observer.
	 */
	void Notify();

}