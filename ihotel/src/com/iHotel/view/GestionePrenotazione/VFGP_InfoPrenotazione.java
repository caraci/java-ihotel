/**
 * 
 */
package com.iHotel.view.GestionePrenotazione;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;





import javax.swing.border.EmptyBorder;

import com.iHotel.model.Albergo.Ospite;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
import com.iHotel.view.View;


/**
 * @author Alessandro
 *
 */
public class VFGP_InfoPrenotazione extends View {
	
	/*Content pane*/
	private JPanel _contentPane;
	/*Panel*/
	private JPanel _panelTop, _panelBottom, _panelInfoPrenotazione, _panelInfoPrenotante, _panelPeriodo,_panelCamerePrenotate;
	/*Label*/
	private JLabel _lblTitoloPrenotante, _lblPrenotante, _lblTitoloPrenotazione,_lblDataInizio,_lblDataFine,_lblPrezzoCamere,_lblPrezzoServizi, _lblScegliCamera;
	
	/*Button*/
	private JButton _btnTerminaModifichePrenotazione;
	private ArrayList<JButton> _btnCamere;
	
	
private static VFGP_InfoPrenotazione instance = null;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_InfoPrenotazione() {
		_btnCamere = new ArrayList<JButton>();
	};	
	
	/**
	 * Metodo che consente di avere una sola istanza della schermata
	 * @return
	 */
	public static VFGP_InfoPrenotazione getInstance(){
		if (instance == null){
			instance = new VFGP_InfoPrenotazione();
		}
		return instance;
	}
	
	/**
	 * Metodo privato che recupera le informazioni sul prenotante e le inserisce nel pannello di competenza
	 * @param prenotazione
	 */
	private void addInfoPrenotante(PrenotazioneSubject prenotazione){
		/*Recupero il prenotante della prenotazione */
		Ospite prenotante = prenotazione.getPrenotante();
		
		/*Setto il testo dell'intestazione*/
		_lblTitoloPrenotante =_viewFactory.getLabel();
		_lblTitoloPrenotante.setText("Titolare della prenotazione: ");
		
		/*Setto il corpo della label con i dati del prenotante*/
		_lblPrenotante= _viewFactory.getLabel();
		_lblPrenotante.setText("Cognome: "+prenotante.get_cognome()+"\n"+
		"Nome: "+prenotante.get_nome()+"\n");
		
		/*Aggiungo le label al pannello giusto*/
		_panelInfoPrenotante= _viewFactory.getPanel();
		_panelInfoPrenotante.setLayout(new GridLayout(2, 1, 10, 10));
		_panelInfoPrenotante.add(_lblTitoloPrenotante);
		_panelInfoPrenotante.add(_lblPrenotante);
		
		/*Aggiungo il panelPrenotante al panelTop*/
		_panelTop.add(_panelInfoPrenotante);
	}
	
	/**
	 * Metodo privato che recupera le informazioni della prenotazione
	 * @param prenotazione
	 */
	private void addInfoPrenotazione(PrenotazioneSubject prenotazione){
		/*Recupero il periodo*/
		Periodo periodo = prenotazione.get_periodo();
		
		/*Recupero il prezzo delle camere*/
		Prezzo prezzoCamere = prenotazione.get_total();
		Prezzo prezzoServiziInterni = prenotazione.getPrezzoServiziInterni();
		
		/*Mostro il codice della prenotazione, il periodo e il prezzo per le camere*/
		_lblTitoloPrenotazione = _viewFactory.getLabel();
		_lblTitoloPrenotante.setText("Informazioni prenotazione numero: "+ prenotazione.get_codice()+"\n");
		
		_lblDataInizio = _viewFactory.getLabel();
		_lblDataInizio.setText("Inizio soggiorno: "+ periodo.toString());
		
		_lblDataFine = _viewFactory.getLabel();
		_lblDataFine.setText("Fine soggiorno: "+ periodo.toString());
		
		_panelPeriodo = _viewFactory.getPanel();
		_panelPeriodo.setLayout(new GridLayout(1,2,10,10));
		_panelPeriodo.add(_lblDataInizio);
		_panelPeriodo.add(_lblDataFine);
		
		_lblPrezzoCamere=_viewFactory.getLabel();
		_lblPrezzoCamere.setText("Il totale delle camere è di: "+prezzoCamere.get_importo()+" "+prezzoCamere.get_valuta());
		
		//da completare sto metodo inserendo il prezzo per i servizi esterni
		_lblPrezzoServizi = _viewFactory.getLabel();
		_lblPrezzoServizi.setText("Il totale per i servizi di cui si è usufruito è: ");
		
		/*Aggiugo al _panelInfoPrenotazione*/
		_panelInfoPrenotazione = _viewFactory.getPanel();
		_panelInfoPrenotazione.setLayout(new GridLayout(3,1,10,10));
		_panelInfoPrenotazione.add(_lblTitoloPrenotazione);
		_panelInfoPrenotazione.add(_panelPeriodo);
		_panelInfoPrenotazione.add(_lblPrezzoCamere);
		
		
		/*Aggiungo al _panelTop*/		
		_panelTop.add(_panelInfoPrenotazione);		
		
	}
	
	/**
	 * Metodo privato che aggiunge le camere prenotate ad un pannello
	 * @param prenotazione
	 */
	private void addCamerePrenotate (PrenotazioneSubject prenotazione){	
		_panelCamerePrenotate = _viewFactory.getPanel();
		/* Ciclo per prendere i numeri di camera della prenotazione*/
		for (Iterator<CameraContext> iterator = prenotazione.get_camerePrenotate().iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			JButton button= _viewFactory.getButton();
			button.setText(cameraContext.get_numero());
			_btnCamere.add(button);
			_panelCamerePrenotate.add(button);
		}
		
		/*Aggiungo il pannello con le camere al panelBottom*/
		_panelBottom.add(_panelCamerePrenotate);
		
	}
	
	 /** Metodo che inserisce il pannello superiore della schermata
	 * @param prenotazione
	 */
	private void addPanelTop(PrenotazioneSubject prenotazione){	
		/*Istanzio un pannello*/
		_panelTop = _viewFactory.getPanel();
		_panelTop.setLayout(new GridLayout(2, 2, 10,10));
		
		/*Aggiungo le due parti al  pannello*/
		addInfoPrenotante(prenotazione);
		addInfoPrenotazione(prenotazione);
		
		/*Aggiungo il panelTop al contentPane*/
		_contentPane.add(_panelTop);
	}
	
	/**
	 * Metodo che inserisce il pannello inferiore della schermata
	 * @param prenotazione
	 */
	private void addPanelBottom(PrenotazioneSubject prenotazione){
		/*Creo il pannello*/
		_panelBottom= _viewFactory.getPanel();
		_panelBottom.setLayout(new GridLayout(10,2,10,10));
		
		/*Aggiungo quello che mi serve al pannello*/
		
		addCamerePrenotate(prenotazione);
		
		_btnTerminaModifichePrenotazione = _viewFactory.getButton();
		_btnTerminaModifichePrenotazione.setText("Termina Modifiche");		
		_panelBottom.add(_btnTerminaModifichePrenotazione);
		
		/*Aggiungo il pannello al contentPanel*/
		_contentPane.add(_panelBottom);
		
	}
	
	/**
	 * Metodo che permette di creare la schermata di visualizzazione delle informazioni della prenotazione
	 * @param prenotazione
	 */
	public void creaFrame(PrenotazioneSubject prenotazione){
		/*ContentPane 2 righe 1 colonna*/
		_contentPane = _viewFactory.getPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(_contentPane);
		_contentPane.setLayout(new GridLayout(2,1,10,10));
		
		/*Aggiungo i pannelli al contentPane*/
		addPanelTop(prenotazione);
		addPanelBottom(prenotazione);
		
	}

}
