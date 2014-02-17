package com.iHotel.utility;

import java.io.*;
import java.net.*;
import java.util.*;

public class DefaultLoader {
	
	private static DefaultLoader instance = null;
	
	private void DefaultLoader(){
		
	}
	
	public static DefaultLoader getInstance(){
		if (instance == null){
			instance = new DefaultLoader();
		}
		return instance;
	}
	
	public ArrayList<String> getInformazioniAlbergo(){
		
		return null;	
	}
	
	public ArrayList<int[]> getMinutoOraInizioMinutoOraFine(){
		return null;
	}	
	

}
