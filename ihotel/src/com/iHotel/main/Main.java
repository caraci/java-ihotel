package com.iHotel.main;

import com.iHotel.view.*;

public class Main {
	public static void main(String[] args) {					
		VFrameHome frameHome = VFrameHome.getInstance();
		frameHome.creaFrame();
		frameHome.setVisible(true);			
	}
}
