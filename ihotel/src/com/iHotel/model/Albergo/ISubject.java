package com.iHotel.model.Albergo;

import com.iHotel.view.IObserver;

public interface ISubject {

	void Attach(IObserver observer);

	void Detach(IObserver observer);

	void Notify();

}