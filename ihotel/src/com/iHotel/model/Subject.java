package com.iHotel.model;

import com.iHotel.view.Observer;

public interface Subject {

	void Attach(Observer observer);

	void Detach(Observer observer);

	void Notify();

}