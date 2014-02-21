package com.iHotel.main;

import com.iHotel.view.*;

public class Main {
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings({"serial"})
	public static void main(String[] args) throws java.io.IOException {					
		VFrameHome frameHome = VFrameHome.getInstance();
		frameHome.creaFrame();
		frameHome.setVisible(true);			
	}
}
