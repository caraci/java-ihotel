package com.iHotel.model.Observer;


public interface ISubject {

	void Attach(IObserver observer);

	void Detach(IObserver observer);

	void Notify();

}