/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;







import javax.swing.border.Border;

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
public class VFGP_InfoPrenotazione extends View {
	
	
	/*Panel*/
	private JPanel _panelTop,_panelMiddle, _panelBottom, _panelInfoPrenotazione, _panelInfoPrenotante,_panelCamerePrenotate;
	/*Label*/
	private JLabel _lblTitoloPrenotante, _lblCognomePrenotante,_lblNomePrenotante, _lblTitoloPrenotazione,_lblPeriodo,_lblPrezzoCamere,_lblPrezzoServizi, _lblScegliCamera;
	
	/*Button*/
	private JButton _btnTerminaModifichePrenotazione;
	private ArrayList<JButton> _btnCamere;
	/*insets*/
	private Insets _insets_lbl;
	private Insets _insets_panel;
	
private static VFGP_InfoPrenotazione instance = null;
	
	/**
	 * Costruttore privato
	 */
	private VFGP_InfoPrenotazione() {
		/*Istanzio gli oggetti da mostrare nell'interfaccia*/
		
		/*Panel*/
		_contentPane = _viewFactory.getPanel();
		_panelTop = _viewFactory.getPanel();
		_panelMiddle = _viewFactory.getPanel();
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
		
		/*insets*/
		_insets_lbl = new Insets(7, 2, 7, 2);
		_insets_panel= new Insets(20,20,20,20);
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
	private JPanel creaInfoPrenotante(PrenotazioneSubject prenotazione){
		
		/*Recupero il prenotante della prenotazione */
		Ospite prenotante = prenotazione.getPrenotante();
		
		/*Setto il testo dell'intestazione*/
		_lblTitoloPrenotante.setText("Titolare della prenotazione: ");
		
		
		/*Setto il corpo della label con i dati del prenotante*/

		_lblCognomePrenotante.setText("Cognome: "+prenotante.get_cognome());
		_lblNomePrenotante.setText("Nome: "+prenotante.get_nome());
		
		
		/*Aggiungo il layuot al pannello*/	
		_panelInfoPrenotante.setLayout(new GridBagLayout());
		
		/*Definisco i vincoli*/
		GridBagConstraints constraints_lbl_titolare = new GridBagConstraints();
		GridBagConstraints constraints_lbl_nome = new GridBagConstraints();
		GridBagConstraints constraints_lbl_cognome = new GridBagConstraints();
		
		/*setto i vincoli*/
		//prima riga, prima colonna		
		constraints_lbl_titolare.fill = GridBagConstraints.HORIZONTAL;
		constraints_lbl_titolare.gridx=0;
		constraints_lbl_titolare.gridy=0;
		//padding
		constraints_lbl_titolare.insets = _insets_lbl;		
		
		//seconda riga, prima colonna
		constraints_lbl_nome.fill = GridBagConstraints.HORIZONTAL;
		constraints_lbl_nome.gridx=0;
		//posiziono dopo il titolare
		constraints_lbl_nome.gridy=constraints_lbl_titolare.RELATIVE;		
		constraints_lbl_nome.insets = _insets_lbl;
		
		//terza riga, prima colonna
		constraints_lbl_cognome.fill = GridBagConstraints.HORIZONTAL;
		constraints_lbl_cognome.gridx=0;
		//posiziono dopo il nome
		constraints_lbl_cognome.gridy=constraints_lbl_nome.RELATIVE;
		constraints_lbl_cognome.insets = _insets_lbl;
		
		
		
		/*Aggiungo le label al pannello*/
		_panelInfoPrenotante.add(_lblTitoloPrenotante,constraints_lbl_titolare);
		_panelInfoPrenotante.add(_lblCognomePrenotante,constraints_lbl_cognome);
		_panelInfoPrenotante.add(_lblNomePrenotante,constraints_lbl_nome);
		/*_lblTitoloPrenotante.setOpaque(true);
		_lblCognomePrenotante.setOpaque(true);
		_lblNomePrenotante.setOpaque(true);
		_lblTitoloPrenotante.setBackground(new Color(30, 14,14));
		_lblCognomePrenotante.setBackground(new Color( 14,30,14));
		_lblNomePrenotante.setBackground(new Color( 14,14,30));*/
		//_panelInfoPrenotante.setBackground(new Color(33, 33, 33));
		
		
		/*Restituisco il pannello con le informazioni sul prenotante*/
		return _panelInfoPrenotante;
		
	}
	
	/**
	 * Metodo privato che recupera le informazioni della prenotazione
	 * @param prenotazione
	 */
	private JPanel creaInfoPrenotazione(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){
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
		
		/*Definisco i vincoli*/
		GridBagConstraints constraints_periodo = new GridBagConstraints();
		GridBagConstraints constraints_prezzo_camere = new GridBagConstraints();
		GridBagConstraints constraints_prezzo_servizi = new GridBagConstraints();
		
		/*Setto i vincoli*/
		constraints_periodo.fill = GridBagConstraints.HORIZONTAL;
		constraints_periodo.gridx=0;
		constraints_periodo.gridy=0;
		constraints_periodo.insets = _insets_lbl;	
		
		constraints_prezzo_camere.fill = GridBagConstraints.HORIZONTAL;
		constraints_prezzo_camere.gridx=0;
		constraints_prezzo_camere.gridy=constraints_periodo.RELATIVE;		
		constraints_periodo.insets = _insets_lbl;
		
		constraints_prezzo_servizi.fill = GridBagConstraints.HORIZONTAL;
		constraints_prezzo_servizi.gridx=0;
		constraints_prezzo_servizi.gridy=constraints_prezzo_camere.RELATIVE;
		constraints_prezzo_servizi.insets = _insets_lbl;
	
		
		/*Aggiugo le etichette di periodo e prezzo al _panelInfoPrenotazione*/
		_panelInfoPrenotazione.setLayout(new GridBagLayout());
		
		_panelInfoPrenotazione.add(_lblPeriodo,constraints_periodo);		
		_panelInfoPrenotazione.add(_lblPrezzoCamere,constraints_prezzo_camere);
		_panelInfoPrenotazione.add(_lblPrezzoServizi,constraints_prezzo_servizi);		
		
		return _panelInfoPrenotazione;
			
		
	}
	
	/**
	 * Metodo privato che aggiunge le camere prenotate ad un pannello
	 * @param prenotazione
	 */
	private void creaCamerePrenotate (PrenotazioneSubject prenotazione){	
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
			
		}
		
		
		
	}
	
	 /** Metodo che inserisce il pannello superiore della schermata
	 * @param prenotazione
	 */
	private void creaPanelTop(PrenotazioneSubject prenotazione){	
		
		/*Setto il layout al pannello*/
		_panelTop.setLayout(new GridLayout(1, 1, 1,1));
		
		/*Aggiungo il testo all'etichetta e l'etichetta al pannello*/		
		_lblTitoloPrenotazione.setText("Prenotazione numero: "+prenotazione.get_codice());
		_panelTop.add(_lblTitoloPrenotazione);
		
		
	}
	/**
	 * Metodo che crea il pannello centrale
	 * @param prenotazione
	 * @return
	 */
	private JPanel creaPanelMiddle(PrenotazioneSubject prenotazione){
		creaInfoPrenotante(prenotazione);
		return _panelMiddle;
		
	}
	/**
	 * Metodo che inserisce il pannello inferiore della schermata
	 * @param prenotazione
	 */
	private void creaPanelBottom(PrenotazioneSubject prenotazione){
		/*Creo il pannello*/
		_panelBottom.setLayout(new GridBagLayout());
		
		/*creo i vincoli*/
		
		GridBagConstraints constraints_termina_btn = new GridBagConstraints();
		
		/*setto i vincoli*/
		constraints_termina_btn.fill = GridBagConstraints.HORIZONTAL;
		constraints_termina_btn.gridx=2;
		constraints_termina_btn.gridy=0;
		
		/*Aggiungo quello che mi serve al pannello*/
		
		// Aggiungo l'eventListener al bottone per concludere le modifiche
		_btnTerminaModifichePrenotazione.addMouseListener(new TerminaModifichePrenotazione());
		_btnTerminaModifichePrenotazione.setText("Termina Modifiche");		
		_panelBottom.add(_btnTerminaModifichePrenotazione,constraints_termina_btn);
		
		// 
		
		
		
	}
	
	/**
	 * Metodo che permette di creare la schermata di visualizzazione delle informazioni della prenotazione
	 * @param prenotazione
	 */
	public void creaFrame(PrenotazioneSubject prenotazione, Prezzo prezzoServiziEsterni){
		
		setTitle("iHotel - Gestione Prenotazione - Informazioni prenotazione");
		
		/*ContentPane 3 righe 1 colonna*/
		_contentPane.setLayout(new GridBagLayout());
		
		/*Vincoli*/
		GridBagConstraints constraints_panel_prenotante = new GridBagConstraints();
		GridBagConstraints constraints_panel_prenotazione = new GridBagConstraints();
		GridBagConstraints constraints_panel_camere_prenotate = new GridBagConstraints();
		GridBagConstraints constraints_panel_top = new GridBagConstraints();
		GridBagConstraints constraints_panel_bottom = new GridBagConstraints();
		
		/*Setto i vincoli*/
		
		constraints_panel_top.gridx=0;
		constraints_panel_top.gridy=0;
		constraints_panel_top.weightx=1;
		constraints_panel_top.weighty=0.1;
		constraints_panel_top.gridwidth=4;
		constraints_panel_top.fill=GridBagConstraints.HORIZONTAL;
		constraints_panel_top.anchor=GridBagConstraints.PAGE_START;
		constraints_panel_top.anchor=GridBagConstraints.LINE_START;
		constraints_panel_top.insets=_insets_panel;
		
		constraints_panel_prenotante.gridx=0;
		constraints_panel_prenotante.weighty=0.3;
		constraints_panel_prenotante.weighty=0.5;
		constraints_panel_prenotante.gridy=constraints_panel_top.RELATIVE;
		constraints_panel_prenotante.gridheight=2;
		constraints_panel_prenotante.gridwidth=2;
		constraints_panel_prenotante.fill = GridBagConstraints.HORIZONTAL;
		
		constraints_panel_prenotazione.gridx=constraints_panel_prenotante.RELATIVE;
		constraints_panel_prenotazione.gridy=1;
		constraints_panel_prenotazione.weighty=0.4;
		constraints_panel_prenotazione.weighty=0.5;
		constraints_panel_prenotazione.gridheight=2;
		constraints_panel_prenotazione.gridwidth=1;
		constraints_panel_prenotazione.fill = GridBagConstraints.HORIZONTAL;
		
		constraints_panel_camere_prenotate.gridx=constraints_panel_prenotazione.RELATIVE;
		constraints_panel_camere_prenotate.gridy=1;
		constraints_panel_camere_prenotate.weighty=0.3;
		constraints_panel_camere_prenotate.weighty=0.5;
		constraints_panel_camere_prenotate.gridheight=2;
		constraints_panel_camere_prenotate.gridwidth=2;
		constraints_panel_camere_prenotate.fill = GridBagConstraints.HORIZONTAL;
		
		
		constraints_panel_bottom.gridx=3;
		constraints_panel_bottom.weighty=0.4;
		constraints_panel_bottom.gridy=constraints_panel_camere_prenotate.RELATIVE;
		constraints_panel_bottom.anchor=GridBagConstraints.PAGE_END;
		
		
		/*Aggiungo i pannelli al contentPane*/
		creaPanelTop(prenotazione);
		creaInfoPrenotante(prenotazione);
		creaInfoPrenotazione(prenotazione,prezzoServiziEsterni);
		creaCamerePrenotate(prenotazione);
		creaPanelBottom(prenotazione);
		
		_panelInfoPrenotante.setBackground(new Color(44,44,44));
		_panelInfoPrenotazione.setBackground(new Color(44,44,44));
		_panelCamerePrenotate.setBackground(new Color(44,44,44));
		
		_contentPane.add(_panelTop,constraints_panel_top);
		/*Aggiungo il panelPrenotante al*/
		_contentPane.add(_panelInfoPrenotante, constraints_panel_prenotante);
		/*Aggiungo al contentPanel*/		
		_contentPane.add(_panelInfoPrenotazione,constraints_panel_prenotazione);
		/*Aggiungo il pannello con le camere*/
		_contentPane.add(_panelCamerePrenotate,constraints_panel_camere_prenotate);		
		/*Aggiungo il panelTop al contentPane*/
		
		
		/*Aggiungo il pannello al contentPanel*/
		_contentPane.add(_panelBottom,constraints_panel_bottom);
		_contentPane.setBackground(new Color(150,0,0));
		_panelTop.setBackground(new Color(0,150,0));
		setContentPane(_contentPane);
		
	}

}
