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

/**
 * @author Alessandro
 *
 */
public class VFPG_InfoPrenotazione extends View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VFPG_InfoPrenotazione instance;
	
	/*Panel*/
	private JPanel _panelInfoPrenotante,_panelInfoPrenotazione,_panelCamerePrenotate;
	
	/*Label*/
	private JLabel _lblTitoloPrenotante, _lblCognomePrenotante,_lblNomePrenotante, _lblTitoloPrenotazione,_lblPeriodo,_lblPrezzoCamere,_lblPrezzoServizi, _lblRiepilogoPrenotazione, _lblScegliCamera;

	/*Button*/
	private JButton _btnTerminaModifichePrenotazione;
	private ArrayList<JButton> _btnCamere;
	/*insets*/
	
	
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
	
	/**
	 * Metodo privato che aggiunge il pannello superiore
	 * @param prenotazione La prenotazione di cui si vogliono visualizzare i dettagli
	 */
	private void creaPanelTop(PrenotazioneSubject prenotazione){				
		//setto la label con il codice della prenotazione
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+ prenotazione.get_codice());
		//aggiungo la label al panelTop
		_panelTop.add(_lblTitoloPrenotazione);		
	}
	
	/**
	 * Metodo privato che crea il pannello di metà pagina
	 * @param prenotazione La prenotazione di cui si vogliono visualizzare i dettagli
	 * @param prezzoServiziEsterni Il prezzo dei servizi esterni che sono stati richiesti dalle camere della prenotazione
	 *        corrente
	 */	
	private void creaPanelMiddle(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){		
		/*invoco i 3 metodi privati che mi consentono di creare i pannelli con le informazioni sul prenotante*/
		/*della prenotazione, sulla prenotazione e sulle camere*/
		_panelMiddle.add(creaPanelLeft(prenotazione),BorderLayout.LINE_START);
		_panelMiddle.add(creaPanelCenter(prenotazione,prezzoServiziEsterni),BorderLayout.CENTER);
		_panelMiddle.add(creaPanelRight(prenotazione),BorderLayout.LINE_END);	
		
	}
	/**
	 * Metodo privato che crea il pannello di fondo pagina
	 */
	private void creaPanelBottom(){
		/*Setto il testo del bottone*/
		_btnTerminaModifichePrenotazione.setText("Termina modifiche alla prenotazione");
		
		/*Aggiungo il pulsante al panelBottom*/
		_panelBottom.setLayout(new BorderLayout());		
		_panelBottom.add(_btnTerminaModifichePrenotazione,BorderLayout.EAST);
	}
	
	/**
	 * Metodo privato che crea il pannello con le informazioni sul prenotante
	 * @param prenotazione La prenotazione dalla quale bisogna prelevare le informazioni
	 * @return JPanel il pannello che contiene le informazioni sul cliente prenotante
	 */
	private JPanel creaPanelLeft(PrenotazioneSubject prenotazione){
				
		/*Setto il layout*/
		_panelInfoPrenotante.setLayout(new BoxLayout(_panelInfoPrenotante, BoxLayout.PAGE_AXIS));
		
		/*Setto la dimensione che ha come altezza il 100% del _panelMiddle e larghezza pari al 32% del _panelMiddle*/
		_panelInfoPrenotante.setPreferredSize(new Dimension((int)(0.32*_panelMiddle.getPreferredSize().getWidth()) ,(int)(0.95*_panelMiddle.getPreferredSize().getHeight())));
				
		/*Recupero il prenotante della prenotazione */
		Ospite prenotante = prenotazione.getPrenotante();
		
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
	 * Metodo privato che crea il pannello con le informazioni sulla prenotazione	
	 * @param prenotazione La prenotazione della quale si stanno visualizzando le informazioni
	 * @param prezzoServiziEsterni Il prezzo dei servizi esterni utilizzati dalle camere prenotate dalla prenotazione 
 * 			  passata come parametro
	 * @return JPanel Il pannello contenente le informazioni di riepilogo sulla prenotazione
	 */
	private JPanel creaPanelCenter(PrenotazioneSubject prenotazione,Prezzo prezzoServiziEsterni){
		
		/*Setto il layout*/
		_panelInfoPrenotazione.setLayout(new BoxLayout(_panelInfoPrenotazione, BoxLayout.PAGE_AXIS));
		
		/*Setto la dimensione che ha come altezza il 100% del _panelMiddle e larghezza pari al 32% del _panelMiddle*/
		_panelInfoPrenotazione.setPreferredSize(new Dimension((int)(0.32*_panelMiddle.getPreferredSize().getWidth()) ,(int)(0.95*_panelMiddle.getPreferredSize().getHeight())));
		
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
	 * @param prenotazione La prenotazione di cui si stanno visualizzando le informazioni
	 * @return JPanel il pannello che contiene le camere prenotate
	 */
	private JPanel creaPanelRight(PrenotazioneSubject prenotazione){
		
		
		/*Setto il layout*/
		_panelCamerePrenotate.setLayout(new BoxLayout(_panelCamerePrenotate, BoxLayout.PAGE_AXIS));
		
		/*Setto la dimensione che ha come altezza il 100% del _panelMiddle e larghezza pari al 32% del _panelMiddle*/
		_panelCamerePrenotate.setPreferredSize(new Dimension((int)(0.32*_panelMiddle.getPreferredSize().getWidth()) ,(int)(0.95*_panelMiddle.getPreferredSize().getHeight())));
				
		/*Setto il testo alla label che indica il titolo della sezione*/
		_lblScegliCamera.setText("Lista di camere prenotate. Clicca su una per visualizzarne i dettagli");
		_panelCamerePrenotate.add(_lblScegliCamera);
		_panelCamerePrenotate.add(Box.createRigidArea(new Dimension(0,15)));
		
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
		creaPanelTop(prenotazione);
		creaPanelMiddle(prenotazione, prezzoServiziEsterni);
		creaPanelBottom();
		
		
	}
}
