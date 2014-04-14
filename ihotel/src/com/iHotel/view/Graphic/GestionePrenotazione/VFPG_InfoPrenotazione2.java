/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.Ospite;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.GestisciCameraPrenotazioneListener;

/**
 * @author Alessandro
 *
 */
public class VFPG_InfoPrenotazione2 extends View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VFPG_InfoPrenotazione2 instance;
	
	/*Panel*/
	private JPanel _panelTop, _panelMiddle, _panelBottom, _panelInfoPrenotante,_panelInfoPrenotazione,_panelCamerePrenotate;
	
	/*Label*/
	private JLabel _lblTitoloPrenotante, _lblCognomePrenotante,_lblNomePrenotante, _lblTitoloPrenotazione,_lblPeriodo,_lblPrezzoCamere,_lblPrezzoServizi, _lblScegliCamera;

	/*Button*/
	private JButton _btnTerminaModifichePrenotazione;
	private ArrayList<JButton> _btnCamere;
	/*insets*/
	private Insets _insets_lbl;
	private Insets _insets_panel;
	
	private VFPG_InfoPrenotazione2(){
		// JPanel
		_panelTop=_viewFactory.getPanel();
		_panelMiddle=_viewFactory.getPanel();
		_panelBottom=_viewFactory.getPanel();
		_panelInfoPrenotante = _viewFactory.getPanel();
		_panelInfoPrenotazione = _viewFactory.getPanel();
		_panelCamerePrenotate = _viewFactory.getPanel();
		
		/*Label*/
		_lblTitoloPrenotante= _viewFactory.getLabel();
		_lblCognomePrenotante= _viewFactory.getLabel();
		_lblNomePrenotante= _viewFactory.getLabel();
		_lblTitoloPrenotazione= _viewFactory.getLabel();
		_lblPeriodo= _viewFactory.getLabel();
		_lblPrezzoCamere= _viewFactory.getLabel();
		_lblPrezzoServizi= _viewFactory.getLabel();
		_lblScegliCamera= _viewFactory.getLabel();
		
		/*Button*/
		_btnTerminaModifichePrenotazione = _viewFactory.getButton();
		_btnCamere = new ArrayList<JButton>();
	}
	/**
	 * Metodo che consente di avere una sola istanza della schermata
	 * @return
	 */
	public static VFPG_InfoPrenotazione2 getInstance(){
		if (instance == null){
			instance = new VFPG_InfoPrenotazione2();
		}
		return instance;
	}
	
	/**
	 * Metodo privato che aggiunge il pannello superiore
	 * @param prenotazione
	 * @return
	 */
	private JPanel creaPanelTop(PrenotazioneSubject prenotazione){
		
		//setto la dimensione di default del pannello superiore
		_panelTop.setPreferredSize(new Dimension(1024,50));
		
		//aggiungo la label con il codice della prenotazione
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+ prenotazione.get_codice());
		_panelTop.add(_lblTitoloPrenotazione);
		
		//restituisco il pannello
		return _panelTop;
	}
	/**
	 * Metodo privato che crea il pannello di metà pagina
	 * @param prenotazione
	 * @param prezzoServiziEsterni
	 * @return
	 */
	
	private JPanel creaPanelMiddle(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){
		
		/*invoco i 3 metodi privati che mi consentono di creare i pannelli con le informazioni sul prenotante*/
		/*della prenotazione, sulla prenotazione e sulle camere*/
		_panelMiddle.add(creaPanelLeft(prenotazione),BorderLayout.LINE_START);
		_panelMiddle.add(creaPanelCenter(prenotazione,prezzoServiziEsterni),BorderLayout.CENTER);
		_panelMiddle.add(creaPanelRight(prenotazione),BorderLayout.LINE_END);	
		
		/*restituisco il pannello*/
		return _panelMiddle;
	}
	/**
	 * Metodo privato che crea il pannello di fondo pagina
	 * @return
	 */
	private JPanel creaPanelBottom(){
		//da implementare
		return _panelBottom;
	}
	/**
	 * Metodo privato che crea il pannello con le informazioni sul prenotante
	 * @param prenotazione
	 * @return
	 */
	private JPanel creaPanelLeft(PrenotazioneSubject prenotazione){
		
		_panelInfoPrenotante.setBackground(new Color(150,00,00));
		
		/*Setto la dimensione*/
		_panelInfoPrenotante.setPreferredSize(new Dimension(300,150));
		_panelInfoPrenotante.setLayout(new GridLayout(3,1,10,10));
		
		/*Recupero il prenotante della prenotazione */
		Ospite prenotante = prenotazione.getPrenotante();
		
		/*Setto il testo dell'intestazione*/
		_lblTitoloPrenotante.setText("Titolare della prenotazione: ");
		
		
		/*Setto il corpo della label con i dati del prenotante*/

		_lblCognomePrenotante.setText("Cognome: "+prenotante.get_cognome());
		_lblNomePrenotante.setText("Nome: "+prenotante.get_nome());
		_panelInfoPrenotante.add(_lblTitoloPrenotante);
		/*Inserisco lo spazio vuoto*/
		_panelInfoPrenotante.add(Box.createRigidArea(new Dimension(0,10)));
		_panelInfoPrenotante.add(_lblCognomePrenotante);
		_panelInfoPrenotante.add(Box.createRigidArea(new Dimension(0,10)));
		_panelInfoPrenotante.add(_lblNomePrenotante);
		_panelInfoPrenotante.add(Box.createRigidArea(new Dimension(0,10)));
		
		return _panelInfoPrenotante;
	}
	/**
	 * Metodo privato che crea il pannello con le informazioni sulla prenotazione	
	 * @param prenotazione
	 * @param prezzoServiziEsterni
	 * @return
	 */
	private JPanel creaPanelCenter(PrenotazioneSubject prenotazione,Prezzo prezzoServiziEsterni){
		_panelInfoPrenotazione.setBackground(new Color(00,150,00));
		
		_panelInfoPrenotazione.setPreferredSize(new Dimension(410,150));
		
		/*Recupero il periodo*/
		Periodo periodo = prenotazione.get_periodo();
		
		/*Recupero il prezzo delle camere*/
		Prezzo prezzoCamere = prenotazione.get_total();
		/*Recupero il prezzo dei servizi interni*/
		Prezzo prezzoServiziInterni = prenotazione.getPrezzoServiziInterni();
		
		/*Sommo il prezzo dei servizi interni con quelli esterni*/
		Prezzo totaleServizi = new Prezzo();
		totaleServizi.set_importo(prezzoServiziInterni.get_importo()+prezzoServiziEsterni.get_importo());
		
		totaleServizi.set_valuta(prezzoServiziInterni.get_valuta());
		
		/*Setto il periodo della prenotazione nell'etichetta*/		
		_lblPeriodo.setText("Periodo del soggiorno: "+ periodo.toString());
		
		/*Setto il prezzo delle camere*/
		_lblPrezzoCamere.setText("Il totale delle camere è di: "+prezzoCamere.get_importo()+" "+prezzoCamere.get_valuta());
		
		/*Setto il prezzo dei servizi*/
		_lblPrezzoServizi.setText("Il totale per i servizi di cui si è usufruito è: "+totaleServizi.get_importo()+ " "+totaleServizi.get_valuta());
		
		_panelInfoPrenotazione.add(_lblPeriodo);
		_panelInfoPrenotazione.add(_lblPrezzoCamere);
		_panelInfoPrenotazione.add(_lblPrezzoServizi);
		return _panelInfoPrenotazione;
	}
	/**
	 * Metodo privato che crea il pannello con le camere prenotate
	 * @param prenotazione
	 * @return
	 */
	private JPanel creaPanelRight(PrenotazioneSubject prenotazione){
		_panelCamerePrenotate.setBackground(new Color(00,00,150));
		
		_panelCamerePrenotate.setPreferredSize(new Dimension(300,150));
		
		_panelCamerePrenotate.setLayout(new BoxLayout(_panelCamerePrenotate, BoxLayout.PAGE_AXIS));
		/* Ciclo per prendere i numeri di camera della prenotazione*/
		for (Iterator<CameraContext> iterator = prenotazione.get_camerePrenotate().iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			/*Istanzio un button, gli assegno il numero della camera prenotata come testo e lo aggiungo al pannello delle camere
			  prenotate*/
			JButton button=_viewFactory.getButton();
			button.setText("Gestisci Camera" + cameraContext.get_numero());
			// Assegno l'eventListener al JButton.
			button.addMouseListener(new GestisciCameraPrenotazioneListener(cameraContext.get_numero()));
			_btnCamere.add(button);
			_panelCamerePrenotate.add(button);
			_panelCamerePrenotate.add(Box.createRigidArea(new Dimension(0,10)));
			
		}
		return _panelCamerePrenotate;
	}
	/**
	 * Metodo pubblico che permette di creare il frame che contiene le informazioni sul prenotante, sulla prenotazione
	 * e sulle camere prenotate.
	 * @param prenotazione
	 * @param prezzoServiziEsterni
	 */
	public void creaFrame(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){	
		_contentPane.add(creaPanelTop(prenotazione),BorderLayout.PAGE_START);
		_contentPane.add(creaPanelMiddle(prenotazione, prezzoServiziEsterni),BorderLayout.CENTER);
		_contentPane.add(creaPanelBottom(),BorderLayout.PAGE_END);
		
		
	}
}
