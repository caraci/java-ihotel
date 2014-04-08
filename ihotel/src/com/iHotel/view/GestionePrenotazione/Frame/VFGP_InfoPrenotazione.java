/**
 * 
 */
package com.iHotel.view.GestionePrenotazione.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





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
@SuppressWarnings("serial")
public class VFGP_InfoPrenotazione extends View {
	
	/*Content pane*/
	private JPanel _contentPane;
	/*Panel*/
	private JPanel _panelTop, _panelBottom, _panelInfoPrenotazione, _panelInfoPrenotante,_panelCamerePrenotate;
	/*Label*/
	private JLabel _lblTitoloPrenotante, _lblCognomePrenotante,_lblNomePrenotante, _lblTitoloPrenotazione,_lblPeriodo,_lblPrezzoCamere,_lblPrezzoServizi, _lblScegliCamera;
	
	/*Button*/
	private JButton _btnTerminaModifichePrenotazione;
	private ArrayList<JButton> _btnCamere;
	
	
private static VFGP_InfoPrenotazione instance = null;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_InfoPrenotazione() {
		/*Istanzio gli oggetti da mostrare nell'interfaccia*/
		
		/*Panel*/
		_contentPane = _viewFactory.getPanel();
		_panelTop = _viewFactory.getPanel();
		_panelBottom =_viewFactory.getPanel();
		_panelInfoPrenotante=_viewFactory.getPanel();
		_panelInfoPrenotazione=_viewFactory.getPanel();
		_panelCamerePrenotate=_viewFactory.getPanel();
		
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
		_lblTitoloPrenotante.setText("Titolare della prenotazione: ");
		_lblTitoloPrenotante.setPreferredSize(new Dimension(300,150));
		
		/*Setto il corpo della label con i dati del prenotante*/

		_lblCognomePrenotante.setText("Cognome: "+prenotante.get_cognome());
		_lblNomePrenotante.setText("Nome: "+prenotante.get_nome());
		_lblCognomePrenotante.setPreferredSize(new Dimension(400,200));
		
		/*Aggiungo il layuot al pannello*/	
		_panelInfoPrenotante.setLayout(new BoxLayout(_panelInfoPrenotante,BoxLayout.PAGE_AXIS));
		
		/*Aggiungo le label al pannello*/
		_panelInfoPrenotante.add(_lblTitoloPrenotante);
		_panelInfoPrenotante.add(_lblCognomePrenotante);
		_panelInfoPrenotante.add(_lblNomePrenotante);
		
		/*Aggiungo il panelPrenotante al panelTop*/
		_contentPane.add(_panelInfoPrenotante, BorderLayout.LINE_START);
	}
	
	/**
	 * Metodo privato che recupera le informazioni della prenotazione
	 * @param prenotazione
	 */
	private void addInfoPrenotazione(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){
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
		_lblPeriodo.setText("Fine soggiorno: "+ periodo.toString());
		
		/*Setto il prezzo delle camere*/
		_lblPrezzoCamere.setText("Il totale delle camere è di: "+prezzoCamere.get_importo()+" "+prezzoCamere.get_valuta());
		
		/*Setto il prezzo dei servizi*/
		_lblPrezzoServizi.setText("Il totale per i servizi di cui si è usufruito è: "+totaleServizi.get_importo()+ " "+totaleServizi.get_valuta());
		
		/*Aggiugo le etichette di periodo e prezzo al _panelInfoPrenotazione*/
		_panelInfoPrenotazione.setLayout(new BoxLayout(_panelInfoPrenotazione,BoxLayout.PAGE_AXIS) );
		_panelInfoPrenotazione.add(_lblPeriodo);		
		_panelInfoPrenotazione.add(_lblPrezzoCamere);
		_panelInfoPrenotazione.add(_lblPrezzoServizi);		
		
		/*Aggiungo al contentPanel*/		
		_contentPane.add(_panelInfoPrenotazione,BorderLayout.CENTER);		
		
	}
	
	/**
	 * Metodo privato che aggiunge le camere prenotate ad un pannello
	 * @param prenotazione
	 */
	private void addCamerePrenotate (PrenotazioneSubject prenotazione){	
		int i=0;
		/* Ciclo per prendere i numeri di camera della prenotazione*/
		for (Iterator<CameraContext> iterator = prenotazione.get_camerePrenotate().iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			/*Istanzio un button, gli assegno il numero della camera prenotata come testo e lo aggiungo al pannello delle camere
			  prenotate*/
			JButton button= _viewFactory.getButton();
			button.setText(cameraContext.get_numero());
			_btnCamere.add(button);
			_panelCamerePrenotate.add(button);
			System.out.println(i);
			i++;
		}
		
		/*Aggiungo il pannello con le camere al panelBottom*/
		_contentPane.add(_panelCamerePrenotate,BorderLayout.LINE_END);
		
	}
	
	 /** Metodo che inserisce il pannello superiore della schermata
	 * @param prenotazione
	 */
	private void addPanelTop(PrenotazioneSubject prenotazione){	
		
		/*Setto il layout al pannello*/
		_panelTop.setLayout(new GridLayout(1, 1, 10,10));
		
		/*Aggiungo il testo all'etichetta e l'etichetta al pannello*/		
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+prenotazione.get_codice());
		_panelTop.add(_lblTitoloPrenotazione);
		
		/*Aggiungo il panelTop al contentPane*/
		_contentPane.add(_panelTop,BorderLayout.PAGE_START);
	}
	
	/**
	 * Metodo che inserisce il pannello inferiore della schermata
	 * @param prenotazione
	 */
	private void addPanelBottom(PrenotazioneSubject prenotazione){
		/*Creo il pannello*/
		_panelBottom.setLayout(new GridLayout(10,7,10,10));
		
		/*Aggiungo quello che mi serve al pannello*/
		
		_btnTerminaModifichePrenotazione.setText("Termina Modifiche");		
		_panelBottom.add(_btnTerminaModifichePrenotazione);
		
		/*Aggiungo il pannello al contentPanel*/
		_contentPane.add(_panelBottom,BorderLayout.PAGE_END);
		
	}
	
	/**
	 * Metodo che permette di creare la schermata di visualizzazione delle informazioni della prenotazione
	 * @param prenotazione
	 */
	public void creaFrame(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){
		
		setTitle("iHotel - Gestione Prenotazione - Informazioni prenotazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*ContentPane 3 righe 1 colonna*/
		_contentPane = _viewFactory.getPanel();
		_contentPane.setLayout(new BorderLayout(3,3));
		setContentPane(_contentPane);
		
		/*Aggiungo i pannelli al contentPane*/
		addPanelTop(prenotazione);
		addInfoPrenotante(prenotazione);
		addInfoPrenotazione(prenotazione,prezzoServiziEsterni);
		addCamerePrenotate(prenotazione);
		addPanelBottom(prenotazione);
		
	}

}
