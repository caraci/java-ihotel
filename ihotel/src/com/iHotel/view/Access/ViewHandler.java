/**
 * 
 */
package com.iHotel.view.Access;

import com.iHotel.view.View;

/**
 * @author Alessandro
 *
 */
public class ViewHandler {
	
	private static ViewHandler instance = null;
	private View _currentInterface = null;
	
	private ViewHandler(){
		
	}
	
	/* Singleton */
	public static ViewHandler getInstance(){
		
		if(instance ==null){
			instance = new ViewHandler();
		}
		return instance;		
	}
	
	/**
	 * Metodo che mostra la nuova interfaccia grafica ed elimina quella vecchia
	 * @param view
	 */
	public void showFrame(View view){
		if (_currentInterface!=null){
			_currentInterface.removeAll();
		}
		_currentInterface=view;
		_currentInterface.setVisible(true);
	}

}
