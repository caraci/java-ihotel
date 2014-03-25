package com.iHotel.model.ForeignSystem;

import com.iHotel.model.ForeignSystem.PayTv.*;
import com.iHotel.model.ForeignSystem.Telephone.*;

public class ServiceFactory {

	private IPayTvAdapter _payTvAdapter;
	private ITelephoneAdapter _telephoneAdapter;
	/**
	 * @return the _payTvAdapter
	 */
	public IPayTvAdapter get_payTvAdapter() {
		return _payTvAdapter;
	}
	/**
	 * @return the _telephoneAdapter
	 */
	public ITelephoneAdapter get_telephoneAdapter() {
		return _telephoneAdapter;
	}

}