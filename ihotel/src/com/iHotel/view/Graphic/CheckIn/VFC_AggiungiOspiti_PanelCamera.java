/**
 * 
 */
package com.iHotel.view.Graphic.CheckIn;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.State.CameraContext;
import com.iHotel.view.Access.StyleAbstractFactory;
import com.iHotel.view.Access.ViewFactory;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFC_AggiungiOspiti_PanelCamera extends JPanel {

	private CameraContext _camera;
	private JLabel _lblNome, _lblCognome, _lblIntestazioneDati, _lblCittaNascita, _lblCittaResidenza;
	
	private StyleAbstractFactory _viewFactory;
	
	/**
	 * Costruttore.
	 * 
	 * @param camera Camera che si sta visualizzando.
	 */
	public VFC_AggiungiOspiti_PanelCamera(CameraContext camera) {
		_camera=camera;
		// Prendo la factory dei componenti dell'interfaccia
		_viewFactory=ViewFactory.getInstance().getStyleFactory();
		
	}
}
