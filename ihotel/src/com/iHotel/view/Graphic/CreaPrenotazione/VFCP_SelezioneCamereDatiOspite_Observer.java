package com.iHotel.view.Graphic.CreaPrenotazione;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Observer.ISubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;
import com.iHotel.view.Event.CreaPrenotazione.AggiungiCameraPrenotazioneListener;
import com.iHotel.view.Event.CreaPrenotazione.EffettuaNuovaPrenotazioneListener;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class VFCP_SelezioneCamereDatiOspite_Observer extends View implements IObserver {

	private HashMap<String, ArrayList<CameraContext>> _camereDisponibili;
	/* Panel */
    private JPanel _panelFinale, _panelPrezzo, _panelOspite;
    /* JButton */
    private JButton _btnCompletaPrenotazione;
    /* JLabel */
    private JLabel _lblNome, _lblCognome, _lbleMail, _lblTelefono, _lblPrezzoTotale, _lblPrezzoScritto, _lblTitolo;
    /* JTextField */
    private JTextField _txtNome, _txtCognome, _txteMail, _txtTelefono;
    // Pattern Observer
    private PrenotazioneSubject _prenotazioneSubject;
    /* ----------------- Pattern Singleton  ---------------- */
	private static VFCP_SelezioneCamereDatiOspite_Observer instance = null;
   
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private VFCP_SelezioneCamereDatiOspite_Observer() {
		super();
		// JLabel
		_lblNome=_viewFactory.getLabel();
		_lblCognome=_viewFactory.getLabel();
		_lbleMail=_viewFactory.getLabel();
		_lblTelefono=_viewFactory.getLabel();
		_lblPrezzoTotale=_viewFactory.getLabel();
		_lblPrezzoScritto=_viewFactory.getLabel();
		_lblTitolo=_viewFactory.getLabelIntestazione_1();
		// JTextField
		_txtNome=_viewFactory.getTextField();
		_txtCognome=_viewFactory.getTextField();
		_txteMail=_viewFactory.getTextField();
		_txtTelefono=_viewFactory.getTextField();
		// JPanel
		_panelPrezzo=_viewFactory.getPanel();
		_panelOspite=_viewFactory.getPanel();
		_panelFinale=_viewFactory.getPanel();
		// JButton
		_btnCompletaPrenotazione=_viewFactory.getButtonAvanti();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFCP_SelezioneCamereDatiOspite_Observer Instanza unica di questa classe.
	 */
    public static VFCP_SelezioneCamereDatiOspite_Observer getInstance() {
    	if(instance == null) {
            instance = new VFCP_SelezioneCamereDatiOspite_Observer();
         }
         return instance;
    }
    /* ----------------- /Pattern Singleton  ---------------- */
    /* ------------- Pattern Observer ----------- */
    @Override
	public void Update() {
		String total=String.valueOf(_prenotazioneSubject.get_total().get_importo());	
		// Setto il prezzo della Label con il totale della prenotazione
		_lblPrezzoTotale.setText(total + _prenotazioneSubject.get_total().get_valuta());
	}
    /* ------------- /Pattern Observer --------- */
    @Override
    public void removeInstance() {
    	instance = null;
	}
    @Override
    protected void creaPanelTop() {
    	// Layout PanelTop
    	_panelTop.setLayout(new BorderLayout(0, 0));
		/*Testo della label*/
		_lblTitolo.setText("Scegli le camere e inserisci le informazioni sul prenotante.");
		/*Aggiungo la label al centro*/
		_panelTop.add(_lblTitolo, BorderLayout.CENTER);
    }
    @Override
    protected void creaPanelMiddle() {
    	// Numero di tipologie di camere
		int numeroTipologie = _camereDisponibili.size();
    	// Numero di colonne. Il +1 è dovuta alla colonna di gestione.
		int numeroColonne = numeroTipologie + 1;
    	// Setto Layout con il numero di colonne ricavato sulla base del risultato e con una riga.
		_panelMiddle.setLayout(new GridLayout(1, numeroColonne, 5, 0));
    	// Ciclo sulle camere ottenute.
		for (Iterator<String> iterator = _camereDisponibili.keySet().iterator(); iterator.hasNext();) {
			String tipologia = (String) iterator.next();
			// Aggiungo la colonna relativa a camere della stessa tipologia.
			_panelMiddle.add(creaColonnaTipologiaCamere(tipologia, _camereDisponibili.get(tipologia)));
		}
		// Aggiungo il pannello finale
		_panelMiddle.add(creaPanelFinale());
    }
    /**
     * Metodo per aggiungere una colonna contenente tipologie di camere dello stesso tipo.
     * @param tipologia Tipologia di camere della colonna.
     * @param arrayListCamere Lista di camere disponibili.
     * @return Pannello con le camere disponibili.
     */
    private JScrollPane creaColonnaTipologiaCamere(String tipologia, ArrayList<CameraContext> arrayListCamere) {
    	// Creo uno scollPane, all'interno del quale andrò ad inserire il JPanel contenente le camere
    	JScrollPane scrollPaneColonna = _viewFactory.getScrollPane();
    	// Creo una colonna per mostrare i risultati della tipologia di camere
		JPanel panelColonna = _viewFactory.getPanel();
		panelColonna.setLayout(new BoxLayout(panelColonna, BoxLayout.PAGE_AXIS));	
		// Aggiungo la label relativo alla tipologia alla colonna
		JLabel lblTipologia = _viewFactory.getLabelIntestazione_2();
		lblTipologia.setText(tipologia + ":");
		panelColonna.add(lblTipologia);
		// Aggiungo spaziatura statica
		panelColonna.add(Box.createRigidArea(new Dimension(0,20)));
		// Ciclo sull'arrayList di String contenenti i numeri di camere ed aggiungo i numeri all'array di String creato sopra.
		for (Iterator<CameraContext> iterator = arrayListCamere.iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			// Creo il bottone per aggiungere la camera
			JButton btnNumeroCamera = _viewFactory.getButton();
			btnNumeroCamera.setText("Aggiungi camera" + cameraContext.get_numero());
			// Aggiungo l'eventListener al JButton.
			btnNumeroCamera.addMouseListener(new AggiungiCameraPrenotazioneListener(cameraContext.get_numero()));
			// Aggiungo il bottone al JPanel
			panelColonna.add(btnNumeroCamera);
			// Aggiungo uno spaziatore statica
			panelColonna.add(Box.createRigidArea(new Dimension(0,10)));
		}
		// Aggiungo il JPanel con le camere allo JScrollPane
		scrollPaneColonna.setViewportView(panelColonna);
		
		return scrollPaneColonna;
    }
    /**
     * Metodo per creare il pannello sulla parte destra contenente le informazioni su prezzo e sul prenotante.
     * @return Pannello a destra del frame.
     */
    private JPanel creaPanelFinale() {
    	// Setto il layout al panel
    	_panelFinale.setLayout(new GridLayout(2, 1, 5, 10));
    	// Aggiungo il pannello relativo al prezzo
    	_panelFinale.add(creaPanelPrezzo());
    	// Aggiungo il pannelo relativo alle informazioni sul prenotante.
    	_panelFinale.add(creaPanelPrenotante());
    	
    	return _panelFinale;
    }
    /**
     * Metodo per creare il pannello dove si visualizza il prezzo della prenotazione.
     * @return Pannello relativo al prezzo.
     */
    private JPanel creaPanelPrezzo() {
    	// Setto il Layout al panel
		_panelPrezzo.setLayout(new BoxLayout(_panelPrezzo, BoxLayout.PAGE_AXIS));
		// Nome
		_lblPrezzoScritto.setText("Prezzo Totale:");
		_lblPrezzoTotale.setText("0€");
		// Aggiungo gli elementi al panelOspite
		_panelPrezzo.add(_lblPrezzoScritto);
		_panelPrezzo.add(Box.createRigidArea(new Dimension(0,20)));
		_panelPrezzo.add(_lblPrezzoTotale);

		return _panelPrezzo;
    }
    /**
     * Metodo per creare il pannello dove si inseriscono le informazioni sul cliente prenotante.
     * @return Pannello relativo alle informazioni sull'ospite prenotante.
     */
    private JPanel creaPanelPrenotante() {
    	// Setto il layout al JPanel
		_panelOspite.setLayout(new BoxLayout(_panelOspite, BoxLayout.PAGE_AXIS));
		// Nome
		_lblNome.setText("Nome:");
		// Cognome
		_lblCognome.setText("Cognome:");
		// eMail
		_lbleMail.setText("e-Mail:");
		// telefono
		_lblTelefono.setText("Telefono:");	
		// Aggiungo gli elementi al panelOspite
		_panelOspite.add(_lblNome);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_txtNome);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_lblCognome);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_txtCognome);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_lbleMail);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_txteMail);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_lblTelefono);
		_panelOspite.add(Box.createVerticalGlue());
		_panelOspite.add(_txtTelefono);

		return _panelOspite;
    }
    @Override
    protected void creaPanelBottom() {
		// Button completa prenotazione.
		_btnCompletaPrenotazione.setText("Completa Prenotazione");
		// Assegniamo l'eventListener al JButton btnCompletaPrenotazione.
		_btnCompletaPrenotazione.addMouseListener(new EffettuaNuovaPrenotazioneListener());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();
		// Aggiungo il bottone alla struttura.
		Bottoni.put(5,_btnCompletaPrenotazione);
		// Creo la pulsantiera.
		Integer numeroColonne = 6;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);
    }
    /**
     * Metodo per creare il frame.
     */
    public void creaFrame(HashMap<String, ArrayList<CameraContext>> camereDisponibili) {
    	// Imposto il titolo.
    	setTitle("iHotel - Crea nuova prenotazione - Step 2 di 2");
    	// Setto l'attributo relativo alle camere libere
    	_camereDisponibili=camereDisponibili;
    	// Creo il pannello in alto
		creaPanelTop();
		// Creo il pannello centrale
		creaPanelMiddle();
		// Creo il pannello in basso
		creaPanelBottom();    			
    }
    /* ------------- Getter, Setter ---------------------------- */
    public void set_prenotazioneSubject(ISubject subject) {
    	this._prenotazioneSubject=(PrenotazioneSubject) subject;
    }
	/**
	 * @return the _txtNome
	 */
	public JTextField get_txtNome() {
		return _txtNome;
	}
	/**
	 * @param _txtNome the _txtNome to set
	 */
	public void set_txtNome(JTextField _txtNome) {
		this._txtNome = _txtNome;
	}
	/**
	 * @return the _txtCognome
	 */
	public JTextField get_txtCognome() {
		return _txtCognome;
	}
	/**
	 * @param _txtCognome the _txtCognome to set
	 */
	public void set_txtCognome(JTextField _txtCognome) {
		this._txtCognome = _txtCognome;
	}
	/**
	 * @return the _txteMail
	 */
	public JTextField get_txteMail() {
		return _txteMail;
	}
	/**
	 * @param _txteMail the _txteMail to set
	 */
	public void set_txteMail(JTextField _txteMail) {
		this._txteMail = _txteMail;
	}
	/**
	 * @return the _txtTelefono
	 */
	public JTextField get_txtTelefono() {
		return _txtTelefono;
	}
	/**
	 * @param _txtTelefono the _txtTelefono to set
	 */
	public void set_txtTelefono(JTextField _txtTelefono) {
		this._txtTelefono = _txtTelefono;
	}
}
