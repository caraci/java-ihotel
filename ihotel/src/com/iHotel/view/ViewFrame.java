/**
 * 
 */
package com.iHotel.view;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;
import com.iHotel.view.Graphic.VP_Home;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class ViewFrame extends JFrame {

	/**
	 * ContentPane della finestra.
	 */
	private JPanel _contentPane;
	/**
	 * Gestore del layout del contentPane.
	 */
	private CardLayout _layoutContentPane;
	/**
	 * Istanza unica della classe - Pattern singleton
	 */
	private static ViewFrame _instance = null;
	/**
	 * Costruttore
	 */
	private ViewFrame() {
		super();
		// Richiedo la factory corretta.
		StyleAbstractFactory viewFactory=ViewFactory.getInstance().getStyleFactory();
		// Creo il contentPane
		_contentPane=viewFactory.getContentPane();
		// Setto il bordo al contentPane
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Setto il layout al contentPane
		_layoutContentPane = new CardLayout();
		_contentPane.setLayout(_layoutContentPane);
		// Aggiungo il contentPane al Frame
		setContentPane(_contentPane);
		// Non permetto il resize della finestra
		setResizable(false);
		// Operazione di default in chiusura.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ricavo le dimensioni dello schermo.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Prendo l'80% della larghezza dello schermo.
		int widthDesktop = (int) screenSize.getWidth();
		int widthFrame = (int) ((int) widthDesktop*0.8);
		// Prendo l'80% dell'altezza dello schermo.
		int heightDesktop = (int) screenSize.getHeight();
		int heightFrame = (int) ((int) heightDesktop*0.8);
		// Posizione iniziale
		int x_position = (int) ((int) widthDesktop*0.1);
		int y_position = (int) ((int) heightDesktop*0.1);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
		setBounds(x_position, y_position, widthFrame, heightFrame);		
		// Mostro la prima finestra dell'applicazione
		VP_Home panelHome = new VP_Home();
		panelHome.creaPanel();
		_contentPane.add(panelHome);
	}
	/**
	 * Metodo per ottenere l'unica istanza di questa classe - Pattern Singleton
	 */
	public static ViewFrame getInstance() {
		if(_instance == null) {
            _instance = new ViewFrame();
         }
         return _instance;
	}
	
	/**
	 * Metodo per passare ad una nuova schermata per la finestra.
	 */
	public void cambiaSchermata(ViewPanel panel) {
		// Aggiungo panel al contentPane.
		_contentPane.add(panel);
		// Cambio schermata.
		_layoutContentPane.next(_contentPane);
		// Elimino la schermata precedente.
		_contentPane.remove(0);
	}

}
