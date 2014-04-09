package com.iHotel.view.Graphic.CreaPrenotazione;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

	/* Panel */
    private JPanel _panelFinale;
    /* JButton */
    private JButton _btnCompletaPrenotazione;
    /* JLabel */
    private JLabel _lblNome, _lblCognome, _lbleMail, _lblTelefono, _lblPrezzoTotale, _lblPrezzoScritto;
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
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameCreaPrenotazioneStep_2 Instanza unica di questa classe.
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
    /**
     * Metodo per aggiungere una colonna contenente tipologie di camere dello stesso tipo.
     * 
     * @param arrayListCamere Struttura dati contenente tipologia della camera e numeri di camera.
     */
    private void addColonnaTipologiaCamere(String tipologia, ArrayList<CameraContext> arrayListCamere) {
	// Creo una colonna per mostrare i risultati della tipologia di camere
		JPanel panelColonna = new JPanel();
		panelColonna.setLayout(new  BoxLayout(panelColonna, BoxLayout.PAGE_AXIS));
		_contentPane.add(panelColonna);  		
	// Aggiungo la label relativo alla tipologia alla colonna
		JLabel lblTipologia = new JLabel();
		lblTipologia.setText(tipologia + ":");
		panelColonna.add(lblTipologia);
	// Aggiungo spaziatura statica
		panelColonna.add(Box.createRigidArea(new Dimension(0,20)));
	// Ciclo sull'arrayList di String contenenti i numeri di camere ed aggiungo i numeri all'array di String creato sopra.
		for (Iterator<CameraContext> iterator = arrayListCamere.iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			JLabel lblNumeroCamera = new JLabel(cameraContext.get_numero());
			JButton btnNumeroCamera = new JButton("Aggiungi camera");
			// Aggiungo l'eventListener al JButton.
			btnNumeroCamera.addMouseListener(new AggiungiCameraPrenotazioneListener(cameraContext.get_numero()));
			// Aggiungo label e button al panelColonna
			panelColonna.add(lblNumeroCamera);
			// Aggiungo uno spaziatore statica
			panelColonna.add(Box.createRigidArea(new Dimension(0,4)));
			panelColonna.add(btnNumeroCamera);
			// Aggiungo uno spaziatore statica
			panelColonna.add(Box.createRigidArea(new Dimension(0,10)));
		}
    }
    /**
     * Metodo per aggiungere il pannello dove si visualizza il prezzo della prenotazione.
     */
    private void addPanelPrezzo() {
    	// Creo un panel per far inserire all'utente i dati sul cliente
			JPanel panelPrezzo = new JPanel();
			panelPrezzo.setLayout(new  BoxLayout(panelPrezzo, BoxLayout.PAGE_AXIS));
		// Nome
			_lblPrezzoScritto = new JLabel("Prezzo Totale:");
			_lblPrezzoTotale = new JLabel("0€");
		// Aggiungo gli elementi al panelOspite
			panelPrezzo.add(_lblPrezzoScritto);
			panelPrezzo.add(Box.createRigidArea(new Dimension(0,20)));
			panelPrezzo.add(_lblPrezzoTotale);
		// Aggiungo il panelOspite a panelFinale
			_panelFinale.add(panelPrezzo);
    }
    /**
     * Metodo per aggiungere il pannello dove si inseriscono le informazioni sul cliente e dove si mostra
     * il bottone per concludere la prenotazione.
     */
    private void addPanelOspite() {
    	// Creo un panel per far inserire all'utente i dati sul cliente
			JPanel panelOspite = new JPanel();
			panelOspite.setLayout(new  BoxLayout(panelOspite, BoxLayout.PAGE_AXIS));
		// Nome
			_lblNome = new JLabel("Nome:");
			_txtNome = new JTextField();
		// Cognome
			_lblCognome = new JLabel("Cognome:");
			_txtCognome = new JTextField();
		// eMail
			_lbleMail = new JLabel("e-Mail:");
			_txteMail = new JTextField();
		// telefono
			_lblTelefono = new JLabel("Telefono:");
			_txtTelefono = new JTextField();
		// Button completa prenotazione
			_btnCompletaPrenotazione = new JButton("Completa Prenotazione");
		// Assegniamo l'eventListener al JButton btnCompletaPrenotazione
			_btnCompletaPrenotazione.addMouseListener(new EffettuaNuovaPrenotazioneListener());
		// Aggiungo gli elementi al panelOspite
			panelOspite.add(_lblNome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_txtNome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_lblCognome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_txtCognome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_lbleMail);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_txteMail);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_lblTelefono);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(_txtTelefono);
			panelOspite.add(Box.createRigidArea(new Dimension(0,20)));
			panelOspite.add(_btnCompletaPrenotazione);
		// Aggiungo il panelOspite a panelFinale
			_panelFinale.add(panelOspite);
    }
    /**
     * Metodo per creare il frame.
     */
    public void creaFrame(HashMap<String, ArrayList<CameraContext>> camereDisponibili) {
    	// Imposto il titolo.
    		setTitle("iHotel - Crea nuova prenotazione - Step 2 di 2");
		// Tipologie di camere
			int numeroTipologie = camereDisponibili.size();
    	// Numero di colonne. Il +1 è dovuta alla colonna di gestione.
			int numeroColonne = numeroTipologie + 1;
    	// Setto Layout con il numero di colonne ricavato sulla base del risultato e con una riga.
			_contentPane.setLayout(new GridLayout(1, numeroColonne, 0, 0));
    	// Ciclo sulle camere ottenute.
		for (Iterator<String> iterator = camereDisponibili.keySet().iterator(); iterator.hasNext();) {
			String tipologia = (String) iterator.next();
			// Aggiungo la colonna relativa a camere della stessa tipologia.
			addColonnaTipologiaCamere(tipologia, camereDisponibili.get(tipologia));
		}
			
    	// Aggiungo il pannello finale
	    	_panelFinale = new JPanel();
	    	_panelFinale.setLayout(new GridLayout(2, 1, 20, 20));
    	// Aggiungi i pezzi del panelFinale
	    	addPanelPrezzo();
	    	addPanelOspite();
	    	_contentPane.add(_panelFinale);	    			
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
