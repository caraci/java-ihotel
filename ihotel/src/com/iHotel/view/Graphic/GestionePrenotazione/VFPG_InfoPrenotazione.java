/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import com.iHotel.view.Event.GestionePrenotazione.TerminaModifichePrenotazione;

/**
 * @author Alessandro
 *
 */
@SuppressWarnings("serial")
public class VFPG_InfoPrenotazione extends View {

	/* ----------------------------------- Attributi e Costruttore ------------------------------------ */
	private PrenotazioneSubject _prenotazione;
	private Prezzo _prezzoServiziEsterni;
	//Singleton
	private static VFPG_InfoPrenotazione instance;
	
	/*Panel*/
	private JPanel _panelInfoPrenotante,_panelInfoPrenotazione,_panelCamerePrenotate;
	
	/*Label*/
	private JLabel _lblTitoloPrenotante, _lblCognomePrenotante,_lblNomePrenotante, _lblTitoloPrenotazione,_lblPeriodo,_lblPrezzoCamere,_lblPrezzoServizi, _lblRiepilogoPrenotazione, _lblScegliCamera;

	/*Button*/
	private JButton _btnTerminaModifichePrenotazione;
	private ArrayList<JButton> _btnCamere;
	/**
	 * Costruttore
	 */
	private VFPG_InfoPrenotazione(){
		// JPanel		
		_panelInfoPrenotante = _viewFactory.getPanel();
		_panelInfoPrenotazione = _viewFactory.getPanel();
		_panelCamerePrenotate = _viewFactory.getPanel();
		
		/*Label*/
		_lblTitoloPrenotante= _viewFactory.getLabel();
		_lblRiepilogoPrenotazione = _viewFactory.getLabel();
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
	/* -------------------------- Metodi di classe ----------------------------- */
	/**
	 * Metodo che consente di avere una sola istanza della schermata
	 * @return VFPG_InfoPrenotazione istanza unica della classe
	 */
	public static VFPG_InfoPrenotazione getInstance(){
		if (instance == null){
			instance = new VFPG_InfoPrenotazione();
		}
		return instance;
	}
	/* --------------------- Metodi di instanza ------------------------- */
	@Override
	protected void creaPanelTop(){				
		//setto la label con il codice della prenotazione
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+ _prenotazione.get_codice());
		//aggiungo la label al panelTop
		_panelTop.add(_lblTitoloPrenotazione);		
	}
	@Override
	protected void creaPanelMiddle(){		
		/*invoco i 3 metodi privati che mi consentono di creare i pannelli con le informazioni sul prenotante*/
		/*della prenotazione, sulla prenotazione e sulle camere*/
		_panelMiddle.add(creaPanelMiddleLeft(),BorderLayout.LINE_START);
		_panelMiddle.add(creaPanelMiddleCenter(),BorderLayout.CENTER);
		_panelMiddle.add(creaPanelMiddleRight(),BorderLayout.LINE_END);	
	}
	@Override
	protected void creaPanelBottom(){
		/*Setto il testo del bottone*/
		_btnTerminaModifichePrenotazione.setText("Termina modifiche alla prenotazione");
		
		/*Aggiungo il pulsante al panelBottom*/
		_panelBottom.setLayout(new BorderLayout());		
		_panelBottom.add(_btnTerminaModifichePrenotazione,BorderLayout.EAST);
		
		/*Aggiungo il listener al click sul pulsante*/
		
		_btnTerminaModifichePrenotazione.addMouseListener(new TerminaModifichePrenotazione());
	}
	/**
	 * Metodo privato che crea il pannello con le informazioni sul prenotante
	 * @return JPanel il pannello che contiene le informazioni sul cliente prenotante
	 */
	private JPanel creaPanelMiddleLeft(){
				
		/*Setto il layout*/
		_panelInfoPrenotante.setLayout(new BoxLayout(_panelInfoPrenotante, BoxLayout.PAGE_AXIS));
		
		/*Setto la dimensione che ha come altezza il 100% del _panelMiddle e larghezza pari al 32% del _panelMiddle*/
		_panelInfoPrenotante.setPreferredSize(new Dimension((int)(0.32*_panelMiddle.getPreferredSize().getWidth()) ,(int)(0.95*_panelMiddle.getPreferredSize().getHeight())));
				
		/*Recupero il prenotante della prenotazione */
		Ospite prenotante = _prenotazione.getPrenotante();
		
		/*Setto il testo dell'intestazione*/
		_lblTitoloPrenotante.setText("Titolare della prenotazione: ");
		
		/*Setto il corpo delle label con i dati del prenotante*/
		_lblCognomePrenotante.setText("Cognome: "+prenotante.get_cognome());
		_lblNomePrenotante.setText("Nome: "+prenotante.get_nome());
		
		/*Aggiungo il titolo*/
		_panelInfoPrenotante.add(_lblTitoloPrenotante);		
		/*Inserisco lo spazio vuoto*/
		_panelInfoPrenotante.add(Box.createRigidArea(new Dimension(0,15)));
		/*Aggiungo il cognome*/
		_panelInfoPrenotante.add(_lblCognomePrenotante);
		/*aggiungo lo spazio vuoto*/
		_panelInfoPrenotante.add(Box.createRigidArea(new Dimension(0,15)));
		/*Aggiungo il nome*/
		_panelInfoPrenotante.add(_lblNomePrenotante);
		
		return _panelInfoPrenotante;
	}
	/**
	 * Metodo privato che crea il pannello con le informazioni sulla prenotazione.
	 * @return JPanel Il pannello contenente le informazioni di riepilogo sulla prenotazione
	 */
	private JPanel creaPanelMiddleCenter(){
		
		/*Setto il layout*/
		_panelInfoPrenotazione.setLayout(new BoxLayout(_panelInfoPrenotazione, BoxLayout.PAGE_AXIS));
		
		/*Setto la dimensione che ha come altezza il 100% del _panelMiddle e larghezza pari al 32% del _panelMiddle*/
		_panelInfoPrenotazione.setPreferredSize(new Dimension((int)(0.32*_panelMiddle.getPreferredSize().getWidth()) ,(int)(0.95*_panelMiddle.getPreferredSize().getHeight())));
		
		/*Recupero il periodo*/
		Periodo periodo = _prenotazione.get_periodo();
		
		/*Recupero il prezzo delle camere*/
		Prezzo prezzoCamere = _prenotazione.get_total();
		
		/*Recupero il prezzo dei servizi interni*/
		Prezzo prezzoServiziInterni = _prenotazione.getPrezzoServiziInterni();
		
		/*Sommo il prezzo dei servizi interni con quelli esterni*/
		Prezzo totaleServizi = new Prezzo();
		totaleServizi.set_importo(prezzoServiziInterni.get_importo()+_prezzoServiziEsterni.get_importo());
		
		totaleServizi.set_valuta(prezzoServiziInterni.get_valuta());
		
		/*Setto il testo da riportare nell'intestazione del blocco del riepilogo informazioni sulla prenotazione*/
		_lblRiepilogoPrenotazione.setText("Riepilogo prenotazione:");
		
		/*Setto il periodo della prenotazione nell'etichetta*/		
		_lblPeriodo.setText("Periodo del soggiorno: "+ periodo.toString());
		
		/*Setto il prezzo delle camere*/
		_lblPrezzoCamere.setText("Il totale delle camere è di: "+prezzoCamere.get_importo()+" "+prezzoCamere.get_valuta());
		
		/*Setto il prezzo dei servizi*/
		_lblPrezzoServizi.setText("Il totale per i servizi di cui si è usufruito è: "+totaleServizi.get_importo()+ " "+totaleServizi.get_valuta());
		
		/*Aggiugo le label e gli spazi vuoti al blocco centrale*/
		_panelInfoPrenotazione.add(_lblRiepilogoPrenotazione);
		_panelInfoPrenotazione.add(Box.createRigidArea(new Dimension(0,15)));
		_panelInfoPrenotazione.add(_lblPeriodo);
		_panelInfoPrenotazione.add(Box.createRigidArea(new Dimension(0,15)));
		_panelInfoPrenotazione.add(_lblPrezzoCamere);
		_panelInfoPrenotazione.add(Box.createRigidArea(new Dimension(0,15)));
		_panelInfoPrenotazione.add(_lblPrezzoServizi);
		
		return _panelInfoPrenotazione;
	}
	/**
	 * Metodo privato che crea il pannello con le camere prenotate
	 * @return JPanel il pannello che contiene le camere prenotate
	 */
	private JPanel creaPanelMiddleRight(){		
		
		/*Setto il layout*/
		_panelCamerePrenotate.setLayout(new BoxLayout(_panelCamerePrenotate, BoxLayout.PAGE_AXIS));
		
		/*Setto la dimensione che ha come altezza il 100% del _panelMiddle e larghezza pari al 32% del _panelMiddle*/
		_panelCamerePrenotate.setPreferredSize(new Dimension((int)(0.32*_panelMiddle.getPreferredSize().getWidth()) ,(int)(0.95*_panelMiddle.getPreferredSize().getHeight())));
				
		/*Setto il testo alla label che indica il titolo della sezione*/
		_lblScegliCamera.setText("Lista di camere prenotate. Clicca su una per visualizzarne i dettagli");
		_panelCamerePrenotate.add(_lblScegliCamera);
		_panelCamerePrenotate.add(Box.createRigidArea(new Dimension(0,15)));
		
		/* Ciclo per prendere i numeri di camera della prenotazione*/
		for (Iterator<CameraContext> iterator = _prenotazione.get_camerePrenotate().iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			/*Istanzio un button, gli assegno il numero della camera prenotata come testo e lo aggiungo al pannello delle camere
			  prenotate*/
			JButton button=_viewFactory.getButton();
			button.setText("Gestisci Camera" + cameraContext.get_numero());
			// Assegno l'eventListener al JButton.
			button.addMouseListener(new GestisciCameraPrenotazioneListener(cameraContext.get_numero()));
			_btnCamere.add(button);
			_panelCamerePrenotate.add(button);
			/*Aggiungo lo spazio*/
			_panelCamerePrenotate.add(Box.createRigidArea(new Dimension(0,15)));			
		}
		return _panelCamerePrenotate;
	}
	/**
	 * Metodo pubblico che permette di creare il frame che contiene le informazioni sul prenotante, sulla prenotazione
	 * e sulle camere prenotate.
	 * @param prenotazione La prenotazione di cui si vogliono visualizzare i dettagli
	 * @param prezzoServiziEsterni Il prezzo dei servizi esterni richiesti dalle camere appartenenti alla prenotazione
	 * 	 	  passata come parametro
	 */
	public void creaFrame(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){	
		/*Setto il titolo della finestra*/
		setTitle("iHotel - Gestione Prenotazione - Informazioni sulla prenotazione");
		// Setto gli attributi dell'interfaccia
		_prenotazione=prenotazione;
		_prezzoServiziEsterni=prezzoServiziEsterni;
		// Creo i pannelli
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
	}
}
