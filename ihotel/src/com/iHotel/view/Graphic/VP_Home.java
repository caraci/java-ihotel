package com.iHotel.view.Graphic;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.view.ViewPanelContentPane;
import com.iHotel.view.Event.CaricaCreaNuovaPrenotazioneListener;
import com.iHotel.view.Event.CaricaGestionePrenotazioneFromDialogListener;
import com.iHotel.view.Event.CaricaGestionePrenotazioneFromList;

/**
 * Classe addetta alla realizzazione della finestra iniziale dell'applicazione.
 * 
 * @author Eugenio
 */
@SuppressWarnings("serial")
public class VP_Home extends ViewPanelContentPane {
	
	/* ---------------------- Attributi, Costruttore --------------------- */
	/**
	 * Storico contenente i soggiorni dell'albergo
	 */
	private Storico _storico;
	/*JButton*/
	private JButton _btnCreaPrenotazione,_btnModificaPrenotazione;
	/*JLabel*/
	private JLabel _lblInstructions;
	/*JPanel*/
	private JPanel _pnlMiddleTop, _pnlMiddleBottom;
	/*JTabbedPane*/
	private JTabbedPane _panelTabbedSoggiorni;
	
	/**
     * Costruttore privato - pattern Singleton
     */
	public VP_Home() {
		super();
		/*Storico*/
		_storico = Storico.getInstance();
		/*Button*/
		_btnCreaPrenotazione = _viewFactory.getButton();
		_btnModificaPrenotazione = _viewFactory.getButton();
		/*Label*/
		_lblInstructions= _viewFactory.getLabelIntestazione_1();
		/*JPanel*/
		_pnlMiddleTop=_viewFactory.getPanel(false);
		_pnlMiddleBottom=_viewFactory.getPanel(false);
		/*JTabbedPane*/
		_panelTabbedSoggiorni=_viewFactory.getTabbedPane();
	}
	
	/* --------------------- Metodi di istanza ---------------------- */
	/**
	 * Metodo per creare il pannello superiore della finestra
	 */
    @Override
    protected void creaPanelTop(){
    	_lblInstructions.setText("Scegli l'operazione che vuoi fare.");
    	_panelTop.add(_lblInstructions);
    }
    /**
     * Metodo per creare il pannello centrale della finestra
     */
    @Override
    protected void creaPanelMiddle(){
    	/*Setto il layout*/
    	_panelMiddle.setLayout(new GridLayout(2, 1, 0, 10));
		/*Aggiungo PanelMiddleTop */
    	_panelMiddle.add(creaPanelMiddleTop());
    	/* Aggiungo PanelMiddleBottom */
    	_panelMiddle.add(creaPanelMiddleBottom());

    }
    /**
     * Metodo per creare il pannello relativo alla parte centrale superiore della finestra.
     * 
     * @return
     */
    public JPanel creaPanelMiddleTop() {
    	// Setto layout
    	_pnlMiddleTop.setLayout(new GridLayout(2,1,0,5));
    	/*Setto il testo dei pulsanti*/
    	_btnCreaPrenotazione.setText("Crea nuova prenotazione");   	   	
		_btnModificaPrenotazione.setText("Gestisci prenotazione");	
		// Assegniamo l'eventListener al JButton btnCreaPrenotazione
		_btnCreaPrenotazione.addMouseListener(new CaricaCreaNuovaPrenotazioneListener()); 
		// Assegniamo l'eventListener al JButton btnModificaPrenotazione
		_btnModificaPrenotazione.addMouseListener(new CaricaGestionePrenotazioneFromDialogListener());
		/*Aggiungo i pulsanti al pannello*/
		_pnlMiddleTop.add(_btnCreaPrenotazione);
		_pnlMiddleTop.add(_btnModificaPrenotazione);
		
    	return _pnlMiddleTop;
    }
    /**
     * Metodo per creare il pannello relativo alla parte centrale inferiore della finestra.
     * 
     * @return
     */
    public JPanel creaPanelMiddleBottom() {
    	// Setto layout al _pnlMiddleBottom
    	_pnlMiddleBottom.setLayout(new BoxLayout(_pnlMiddleBottom, BoxLayout.PAGE_AXIS));
    	// Aggiungo le tab al panelTabbed
    	_panelTabbedSoggiorni.addTab("Soggiorni Futuri", getScrollPaneListaProssimi());
    	
    	// Aggiungo panelTabbedSoggioni a pnlMiddleBottom
    	_pnlMiddleBottom.add(_panelTabbedSoggiorni);
    	return _pnlMiddleBottom;
    }
    /**
     * Metodo per ottenere lo scrollPane contenente la lista dei soggiorni futuri.
     * 
     * @return ScrollPane contenente i soggiorni futuri.
     */
    public JScrollPane getScrollPaneListaProssimi() {
    	// ScrollPane nel quale inserisco il pannello contenente la lista
    	JScrollPane scrollPaneListaSoggiorni = _viewFactory.getScrollPane();
    	// Chiedo allo storico la lista dei soggiorni futuri
    	List<SoggiornoContextSubject> soggiorniFuturi = _storico.recuperaSoggiorniFuturi();
    	// Aggiungo il pannello contenente la lista dei soggiorni allo scrollPane
    	scrollPaneListaSoggiorni.setViewportView(creaPanelListaSoggiorni(soggiorniFuturi));
    	
    	return scrollPaneListaSoggiorni;
    }
    @Override
	public void creaPanelBottom() {
		// TODO Auto-generated method stub	
	}
    /**
     * Metodo per creare un pannello contenente la lista dei soggiorni forniti come parametro.
     * 
     * @param soggiorni Lista di soggiorni da visualizzare
     * @return Pannello contenente la lista dei soggiorni richiesti.
     */
    private JPanel creaPanelListaSoggiorni(List<SoggiornoContextSubject> soggiorni) {
    	// Pannello contenente la lista
    	JPanel panelLista = _viewFactory.getPanel(false);
    	// Setto layou lista
    	panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.PAGE_AXIS));
    	// Ciclo sui soggiorni forniti
    	for (Iterator<SoggiornoContextSubject> iterator = soggiorni.iterator(); iterator.hasNext();) {
			SoggiornoContextSubject soggiorno = (SoggiornoContextSubject) iterator.next();
			// Periodo soggiorno
			Periodo periodoSoggiorno = soggiorno.get_periodo();
			// panelSoggiorno
			JPanel pnlSoggiorno = _viewFactory.getPanel(false);
			// Setto layout
			pnlSoggiorno.setLayout(new GridLayout(1, 3, 0, 0));
			// Label codice
	    	JLabel lblCodice = _viewFactory.getLabel();
	    	lblCodice.setText(soggiorno.get_codice());
	    	// Panel periodo
	    	JLabel lblPeriodo = _viewFactory.getLabel();
	    	lblPeriodo.setText("Da: " + periodoSoggiorno.get_dataInizio().toString() + " A: " + periodoSoggiorno.get_dataFine().toString());
	    	// Button carica
	    	JButton btnCaricaPrenotazione = _viewFactory.getButtonAvanti();
	    	btnCaricaPrenotazione.setText("Vedi");
	    	// Assegno il gestore dell'evento al bottone, passando il codice del soggiorno.
	    	btnCaricaPrenotazione.addMouseListener(new CaricaGestionePrenotazioneFromList(soggiorno.get_codice()));
	    	// Aggiungo elementi al pnlSoggiorno
	    	pnlSoggiorno.add(lblCodice);
	    	pnlSoggiorno.add(lblPeriodo);
	    	pnlSoggiorno.add(btnCaricaPrenotazione);
	    	// Aggiungo pnlSoggiorno a panelLista
	    	panelLista.add(pnlSoggiorno);
		}
    	
    	return panelLista;
    }
	/**
	 * Create the Panel.
	 */
	public void creaPanel() {	
		// Setto lo storico come attributo del pannello.
		_storico=Storico.getInstance();
		// Creo il pannello.
		creaPanelTop();
		creaPanelMiddle();
		creaPanelBottom();
	}
	/* ------------------------ Getter, Setter -------------------------------- */
	/**
	 * @return the _btnCreaPrenotazione
	 */
	public JButton get_btnCreaPrenotazione() {
		return _btnCreaPrenotazione;
	}
	/**
	 * @param _btnCreaPrenotazione the _btnCreaPrenotazione to set
	 */
	public void set_btnCreaPrenotazione(JButton _btnCreaPrenotazione) {
		this._btnCreaPrenotazione = _btnCreaPrenotazione;
	}
	/**
	 * @return the _btnModificaPrenotazione
	 */
	public JButton get_btnModificaPrenotazione() {
		return _btnModificaPrenotazione;
	}
	/**
	 * @param _btnModificaPrenotazione the _btnModificaPrenotazione to set
	 */
	public void set_btnModificaPrenotazione(JButton _btnModificaPrenotazione) {
		this._btnModificaPrenotazione = _btnModificaPrenotazione;
	}
}
