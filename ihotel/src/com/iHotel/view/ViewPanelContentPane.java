/**
 * 
 */
package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public abstract class ViewPanelContentPane extends View {
	
	/**
	 * Pannello superiore della pagina.
	 */
	protected JPanel _panelTop;
	/**
	 * Pannello centrale della pagina.
	 */
	protected JPanel _panelMiddle;
	/**
	 * Pannello inferiore della pagina.
	 */
	protected JPanel _panelBottom;
	/**
	 * Costruttore
	 */
	protected ViewPanelContentPane() {
		super();
		// Setto layout al panel
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Creo i pannelli
		_panelTop=_viewFactory.getPanel(true);
		_panelMiddle=_viewFactory.getPanelMiddle();
		_panelBottom=_viewFactory.getPanel(true);
		
		// Setto le dimensioni dei pannelli in base alla dimensione della schermata.
		
		/*	il panelTop è alto il 10% della pagina,
		 * 	il panelMiddle è alto l'70%, 
		 * 	il panelBottom è alto il 10%
		 */
		// Ricavo le dimensioni dello schermo.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Prendo l'80% della larghezza dello schermo.
		int widthDesktop = (int) screenSize.getWidth();
		int widthFrame = (int) ((int) widthDesktop*0.8);
		// Prendo l'80% dell'altezza dello schermo.
		int heightDesktop = (int) screenSize.getHeight();
		int heightFrame = (int) ((int) heightDesktop*0.8);
		// Setto la grandezza al pannello
		setBounds(0, 0, widthFrame, heightFrame);
		// Altezza, Larghezza - Pannello
		int pnlWidth = getWidth();
		int pnlHeight = getHeight();
		
		// Larghezza pannelli
		int pnlWidth_component = (int)(0.95*pnlWidth);
		
		// Altezze a 10% e 70%
		int pnlHeight_component_10 = (int)(0.09*pnlHeight);
		int pnlHeight_component_70 = (int)(0.7*pnlHeight);
	
		// Dimensioni pannelli top, middle, bottom.
		Dimension dimTop = new Dimension(pnlWidth_component,pnlHeight_component_10);
		Dimension dimMiddle = new Dimension(pnlWidth_component,pnlHeight_component_70);
		Dimension dimBottom = new Dimension(pnlWidth_component,pnlHeight_component_10);
		
		
		// Setto le dimensioni preferite dei pannelli
		_panelTop.setPreferredSize(dimTop);
		_panelMiddle.setPreferredSize(dimMiddle);
		_panelBottom.setPreferredSize(dimBottom);
		
		// Aggiungo i pannelli al contentPane
		this.add(_panelTop,BorderLayout.PAGE_START);
		this.add(_panelMiddle,BorderLayout.CENTER);
		this.add(_panelBottom,BorderLayout.PAGE_END);	
			
	}
	
	/* -------------------------------- Metodi di istanza ----------------------------------- */

	/**
	 * Metodo per creare il panelTop.
	 */
	protected abstract void creaPanelTop();
	/**
	 * Metodo per creare il panelMiddle.
	 */
	protected abstract void creaPanelMiddle();
	/**
	 * Metodo per creare il panelBottom.
	 */
	protected abstract void creaPanelBottom();

	/* -------------------------------- Getter, Setter ------------------------------------- */

	/**
	 * @return the _panelTop
	 */
	protected JPanel get_panelTop() {
		return _panelTop;
	}
	/**
	 * @param _panelTop the _panelTop to set
	 */
	protected void set_panelTop(JPanel _panelTop) {
		this._panelTop = _panelTop;
	}
	/**
	 * @return the _panelMiddle
	 */
	protected JPanel get_panelMiddle() {
		return _panelMiddle;
	}
	/**
	 * @param _panelMiddle the _panelMiddle to set
	 */
	protected void set_panelMiddle(JPanel _panelMiddle) {
		this._panelMiddle = _panelMiddle;
	}
	/**
	 * @return the _panelBottom
	 */
	protected JPanel get_panelBottom() {
		return _panelBottom;
	}
	/**
	 * @param _panelBottom the _panelBottom to set
	 */
	protected void set_panelBottom(JPanel _panelBottom) {
		this._panelBottom = _panelBottom;
	}
}
