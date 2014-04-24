package com.iHotel.model.Observer;


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