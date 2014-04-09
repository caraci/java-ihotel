/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;










import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.State.CameraState;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.CaricaAggiungiServiziListener;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_InfoCamera extends View {

	/* ----------------------------- Attributi e costruttore -------------------------------- */
	/*Content pane*/
	private JPanel _contentPane;
	/*Panel*/
	private JPanel _panelTop, _panelBottom, _panelOspiti, _panelServiziInterniRichiesti,_panelServiziEsterniRichiesti;
	/*Label*/
	private JLabel _lblCamera, _lblServiziInterniRichiesti, _lblServiziEsterniRichiesti; 
	private ArrayList<JLabel> _lblServizioInternoRichiesto;
	/*Button*/
	private JButton _btnAggiungiServizi, _btnTornaPrenotazione;
	/*insets*/
	private Insets _insets_lbl;
	
	//Singleton
	private static VFGP_InfoCamera instance=null;
	

	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private VFGP_InfoCamera() {
		/*Istanzio gli oggetti da mostrare nell'interfaccia*/
		
		/*Panel*/
		_contentPane = _viewFactory.getPanel();
		_panelTop = _viewFactory.getPanel();
		_panelBottom =_viewFactory.getPanel();
		_panelOspiti=_viewFactory.getPanel();
		_panelServiziInterniRichiesti=_viewFactory.getPanel();
		_panelServiziEsterniRichiesti=_viewFactory.getPanel();
		
		/*Label*/
		_lblCamera=_viewFactory.getLabel();
		_lblServiziInterniRichiesti=_viewFactory.getLabel();
		_lblServiziEsterniRichiesti=_viewFactory.getLabel();
		
		/*Button*/
		_btnAggiungiServizi=_viewFactory.getButton();
		_btnTornaPrenotazione=_viewFactory.getButton();
		
		/*insets*/
		_insets_lbl = new Insets(7, 2, 7, 2);
		
	}
	
	/* ------------------------- Metodi di classe ---------------------------- */
	
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern Singleton
	 */
	public static VFGP_InfoCamera getInstance() {
    	if(instance == null) {
            instance = new VFGP_InfoCamera();
         }
         return instance;
    }
	/* -------------------------- Metodi di instanza -------------------------- */
	/**
	 * Metodo per mostrare l'interfaccia relativa alle informazioni della camera, in una prenotazione.
	 * @param camera Camera da visualizzare.
	 * @param serviziEsterni Servizi esterni della camera.
	 */
	public void creaFrame(CameraContext camera, PrenotazioneSubject prenotazione, ArrayList<ServizioEsterno> serviziEsterni) {
		
		// Assegno l'eventListener al bottone per tornare alla gestione della prenotazione.
		get_btnTornaPrenotazione().addMouseListener(new TornaAllaPrenotazioneListener());
		// Assegno l'eventListener al bottone per mostrare l'interfaccia relativa all'inserimento di nuovi
		// servizi alla prenotazione.
		get_btnTornaPrenotazione().addMouseListener(new CaricaAggiungiServiziListener());
	}
	
	/**
	 * Metodo privato che recupera le informazioni sui servizi interni richiesti e le inserisce nel pannello di competenza
	 * @param prenotazione
	 */
	private JPanel creaServiziInterniRichiesti(CameraContext camera, PrenotazioneSubject prenotazione){
		ArrayList<ServizioInterno> serviziInterni = camera.getServiziInterniInPeriodo(prenotazione.get_periodo());
		
		/*Setto il testo dell'intestazione*/
		_lblCamera.setText("Camera"+camera.get_numero());
		
		_lblServiziInterniRichiesti.setText("Servizi interni richiesti");
		
		for (Iterator iterator = serviziInterni.iterator(); iterator.hasNext();) {
			ServizioInterno servizioInterno = (ServizioInterno) iterator.next();
			JLabel lblServizioInterno=_viewFactory.getLabel();
			lblServizioInterno.setText(servizioInterno.get_codice()+servizioInterno.get_data());
			_lblServizioInternoRichiesto.add(lblServizioInterno);	
		}
		
		/*Aggiungo il layuot al pannello*/	
		_panelServiziInterniRichiesti.setLayout(new GridBagLayout());
		
		/*Definisco i vincoli*/
		GridBagConstraints constraints_lbl_camera = new GridBagConstraints();
		
		/*setto i vincoli*/
		//prima riga, prima colonna		
		constraints_lbl_camera.fill = GridBagConstraints.HORIZONTAL;
		constraints_lbl_camera.gridx=0;
		constraints_lbl_camera.gridy=0;
		//padding
		constraints_lbl_camera.insets = _insets_lbl;
		
		/*Aggiungo le label al pannello*/
		_panelServiziInterniRichiesti.add(_lblCamera,constraints_lbl_camera);
		
		return _panelServiziInterniRichiesti;
	}
	
	/* ----------------------------- Getter, Setter ---------------------------------- */
	
	/**
	 * @return the _btnAggiungiServizi
	 */
	public JButton get_btnAggiungiServizi() {
		return _btnAggiungiServizi;
	}

	/**
	 * @param _btnAggiungiServizi the _btnAggiungiServizi to set
	 */
	public void set_btnAggiungiServizi(JButton _btnAggiungiServizi) {
		this._btnAggiungiServizi = _btnAggiungiServizi;
	}

	/**
	 * @return the _btnTornaPrenotazione
	 */
	public JButton get_btnTornaPrenotazione() {
		return _btnTornaPrenotazione;
	}

	/**
	 * @param _btnTornaPrenotazione the _btnTornaPrenotazione to set
	 */
	public void set_btnTornaPrenotazione(JButton _btnTornaPrenotazione) {
		this._btnTornaPrenotazione = _btnTornaPrenotazione;
	}
}
