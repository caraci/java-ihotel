/**
 * 
 */
package com.iHotel.main;

import java.util.Calendar;

import com.iHotel.model.Utility.MyDate;

/**
 * @author Eugenio
 *
 */
public class MainDate {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate gc1 = new MyDate();
		gc1.set(2014, 0, 11);
		
		MyDate gc2 = new MyDate();
		gc2.set(2014, 0, 10);
		
		System.out.println(gc2.compareTo(gc1));
		System.out.println(gc1.get(Calendar.DATE)+"-"+gc1.get(Calendar.MONTH)+"-"+gc1.get(Calendar.YEAR)+
							" "+gc1.get(Calendar.HOUR_OF_DAY)+":"+gc1.get(Calendar.MINUTE)+":"+gc1.get(Calendar.SECOND));
		System.out.println(gc2.get(Calendar.DATE)+"-"+gc2.get(Calendar.MONTH)+"-"+gc2.get(Calendar.YEAR)+
				" "+gc2.get(Calendar.HOUR_OF_DAY)+":"+gc2.get(Calendar.MINUTE)+":"+gc2.get(Calendar.SECOND));
	}

}
