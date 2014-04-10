/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.ForeignSystem.ServizioEsterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.CaricaAggiungiServiziListener;
import com.iHotel.view.Event.GestionePrenotazione.TerminaModifichePrenotazione;
import com.iHotel.view.Event.GestionePrenotazione.TornaAllaPrenotazioneListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_InfoCamera extends View {

	/* ----------------------------- Attributi e costruttore -------------------------------- */
	/*Panel*/
	private JPanel _panelTop, _panelBottom, _panelOspitiCamera, _panelServiziInterniRichiesti,_panelServiziEsterniRichiesti;
	/*Label*/
	private JLabel _lblCamera, _lblOspitiCamera, _lblServiziInterniRichiesti, _lblServiziEsterniRichiesti; 
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
		_panelTop = _viewFactory.getPanel();
		_panelBottom =_viewFactory.getPanel();
		_panelOspitiCamera=_viewFactory.getPanel();
		_panelServiziInterniRichiesti=_viewFactory.getPanel();
		_panelServiziEsterniRichiesti=_viewFactory.getPanel();
		
		/*Label*/
		_lblCamera=_viewFactory.getLabel();
		_lblOspitiCamera= _viewFactory.getLabel();
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
	 * Metodo privato che recupera le informazioni sui servizi interni richiesti e le inserisce nel pannello di competenza
	 * @param camera, prenotazione
	 */
	private JPanel creaServiziInterniRichiesti(CameraContext camera, PrenotazioneSubject prenotazione){
		ArrayList<ServizioInterno> serviziInterni = camera.getServiziInterniInPeriodo(prenotazione.get_periodo());
		
		/*Setto il testo dell'intestazione del pannello*/		
		_lblServiziInterniRichiesti.setText("Servizi interni richiesti");
		
		/*Scorre l'array dei servizi interni collegati alla camera e li inserisce in un array di label*/
		for (Iterator<ServizioInterno> iterator = serviziInterni.iterator(); iterator.hasNext();) {
			ServizioInterno servizioInterno = (ServizioInterno) iterator.next();
			JLabel lblServizioInterno=_viewFactory.getLabel();
			lblServizioInterno.setText(servizioInterno.get_codice()+servizioInterno.get_data());
			_lblServizioInternoRichiesto.add(lblServizioInterno);	
		}
		
		/*Aggiungo il layuot al pannello*/	
		_panelServiziInterniRichiesti.setLayout(new GridBagLayout());
		
		/*Definisco i vincoli*/
		GridBagConstraints constraints_lbl_serviziInterniRichiesti = new GridBagConstraints();
		
		/*setto i vincoli*/
		//prima riga, prima colonna		
		constraints_lbl_serviziInterniRichiesti.fill = GridBagConstraints.HORIZONTAL;
		constraints_lbl_serviziInterniRichiesti.gridx=0;
		constraints_lbl_serviziInterniRichiesti.gridy=0;
		//padding
		constraints_lbl_serviziInterniRichiesti.insets = _insets_lbl;
		
		/*Aggiungo la label al pannello*/
		_panelServiziInterniRichiesti.add(_lblServiziInterniRichiesti,constraints_lbl_serviziInterniRichiesti);
		
		return _panelServiziInterniRichiesti;
	}
	
	/**
	 * Metodo privato che recupera gli ospiti di una camera e li inserisce nel pannello di competenza
	 * @param camera, prenotazione
	 */
	private JPanel creaOspitiCamera(CameraContext camera, PrenotazioneSubject prenotazione){
		
		/*Setto il testo dell'intestazione del pannello*/		
		_lblOspitiCamera.setText("Ospiti della camera: ");
		
		/*Aggiungo il layuot al pannello*/	
		_panelOspitiCamera.setLayout(new GridBagLayout());
		
		/*Definisco i vincoli*/
		GridBagConstraints constraints_lbl_ospitiCamera = new GridBagConstraints();
		
		/*setto i vincoli*/
		//prima riga, prima colonna		
		constraints_lbl_ospitiCamera.fill = GridBagConstraints.HORIZONTAL;
		constraints_lbl_ospitiCamera.gridx=0;
		constraints_lbl_ospitiCamera.gridy=0;
		//padding
		constraints_lbl_ospitiCamera.insets = _insets_lbl;
		
		/*Aggiungo la label al pannello*/
		_panelOspitiCamera.add(_lblOspitiCamera,constraints_lbl_ospitiCamera);
		
		return null;
	}
	 /** Metodo che inserisce il pannello superiore della schermata
	 * @param prenotazione
	 */
	private void creaPanelTop(CameraContext camera){	
		
		/*Setto il layout al pannello*/
		_panelTop.setLayout(new GridLayout(1, 1, 10,10));
		
		/*Aggiungo il testo all'etichetta e l'etichetta al pannello*/		
		_lblCamera.setText("Camera numero: "+camera.get_numero());
		_panelTop.add(_lblCamera);
	}
	/**
	 * Metodo che inserisce il pannello inferiore della schermata
	 * @param prenotazione
	 */
	private void creaPanelBottom(PrenotazioneSubject prenotazione){
		/*Creo il pannello*/
		_panelBottom.setLayout(new GridBagLayout());
		/*creo i vincoli*/
		GridBagConstraints constraints_aggiungiServizi_btn = new GridBagConstraints();
		GridBagConstraints constraints_tornaPrenotazione_btn = new GridBagConstraints();
		/*setto i vincoli*/
		constraints_aggiungiServizi_btn.fill = GridBagConstraints.HORIZONTAL;
		constraints_aggiungiServizi_btn.gridx=2;
		constraints_aggiungiServizi_btn.gridy=0;
		
		constraints_tornaPrenotazione_btn.fill = GridBagConstraints.HORIZONTAL;
		constraints_tornaPrenotazione_btn.gridx=1;
		constraints_tornaPrenotazione_btn.gridy=0;
		_btnAggiungiServizi.setText("Aggiungi servizi");
		_btnTornaPrenotazione.setText("Torna alla prenotazione");
		_panelBottom.add(_btnAggiungiServizi,constraints_aggiungiServizi_btn);
		_panelBottom.add(_btnTornaPrenotazione,constraints_tornaPrenotazione_btn);


	}
	
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
