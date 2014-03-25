package com.iHotel.model.ForeignSystem.PayTv;

import java.util.*;

import com.iHotel.model.ForeignSystem.IServiceSystem;

public interface IPayTvAdapter extends IServiceSystem {

	LinkedList<ServizioPayTv> getElencoEventi();

}