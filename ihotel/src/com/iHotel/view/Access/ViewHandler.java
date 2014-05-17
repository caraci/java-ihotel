/**
 * 
 */
package com.iHotel.view.Access;

import com.iHotel.view.ViewFrame;

/**
 * Classe addetta alla gestione delle diverse finestre dell'applicazione. In particolare ha la responsabilità di far sì
 * che sia sempre visibile una sola finestra.
 * 
 * @author Alessandro
 */
public class ViewHandler {
	
	/* ------------------- Attributi e Costruttore --------------------------- */
	/**
	 * Finestra attualmente visualizzata.
	 */
	private ViewFrame _currentInterface = null;
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
	 * 
	 * @param view Finestra da visualizzare.
	 */
	public void showFrame(ViewFrame view){
		if (_currentInterface!=null){
			_currentInterface.setVisible(false);
			// Rimuovo l'interfaccia dall'attributo statico della classe.
			_currentInterface.removeInstance();
		}
		_currentInterface=view;
		_currentInterface.setVisible(true);
	}
	
	public ViewFrame getCurrentInterface(){
		return _currentInterface;
	}

}
