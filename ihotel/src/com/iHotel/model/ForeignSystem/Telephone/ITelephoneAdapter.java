package com.iHotel.model.ForeignSystem.Telephone;

import java.util.*;

import com.iHotel.model.ForeignSystem.IServiceSystem;

public interface ITelephoneAdapter extends IServiceSystem{
	LinkedList<ServizioTelefono> getElencoTelefonate();
}