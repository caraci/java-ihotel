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
	
	/* ------------------- Attributi e Costruttore --------------------------- */
	private View _currentInterface = null;
	// Singleton
	private static ViewHandler instance = null;
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private ViewHandler(){}
	
	/* ---------------------- Metodi di classe -------------------------------------- */
	
	/**
	 * Metodo per ottenere l'unica instanza della classe - Pattern singleton
	 */
	public static ViewHandler getInstance(){
		if(instance ==null){
			instance = new ViewHandler();
		}
		return instance;		
	}
	/* ---------------------- Metodi di instanza --------------------------------------- */
	/**
	 * Metodo che mostra la nuova interfaccia grafica ed elimina quella vecchia.
	 * @param view Finestra da visualizzare.
	 */
	public void showFrame(View view){
		if (_currentInterface!=null){
			_currentInterface.setVisible(false);
			_currentInterface.removeInstance();
		}
		_currentInterface=view;
		_currentInterface.setVisible(true);
	}

}
