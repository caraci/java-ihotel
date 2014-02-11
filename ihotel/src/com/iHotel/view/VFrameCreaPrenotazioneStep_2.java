package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.controller.CGestisciPrenotazione;
import com.iHotel.model.MCamera;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VFrameCreaPrenotazioneStep_2 extends JFrame {

	/* Singleton */
	private static VFrameCreaPrenotazioneStep_2 instance = null;
	/* ContentPane */
	private JPanel contentPane;
	/* Panel */
    private JPanel[] panelColonne;
    private JPanel panelFinale;
    /* JList */
    private ArrayList<JLabel> lblNumeriCamereDisponibili = new ArrayList<JLabel>();
    /* JButton */
    private ArrayList<JButton> btnNumeriCamereDisponibili = new ArrayList<JButton>();
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VFrameCreaPrenotazioneStep_2 frame = VFrameCreaPrenotazioneStep_2.getInstance();
					ArrayList<String> cameraTipologiaSingola = new ArrayList<String>();
					cameraTipologiaSingola.add("Singola");
					cameraTipologiaSingola.add("101");
					cameraTipologiaSingola.add("102");
					ArrayList<String> cameraTipologiaDoppia = new ArrayList<String>();
					cameraTipologiaDoppia.add("Doppia");
					cameraTipologiaDoppia.add("201");
					cameraTipologiaDoppia.add("202");
					cameraTipologiaDoppia.add("203");
					ArrayList<String> cameraTipologiaTripla = new ArrayList<String>();
					cameraTipologiaTripla.add("Tripla");
					cameraTipologiaTripla.add("301");
					cameraTipologiaTripla.add("302");
					cameraTipologiaTripla.add("303");
					ArrayList<ArrayList<String>> camereDisponibili = new ArrayList<ArrayList<String>>();
					camereDisponibili.add(cameraTipologiaSingola);
					//camereDisponibili.add(cameraTipologiaDoppia);
					camereDisponibili.add(cameraTipologiaTripla);
					frame.creaFrame(camereDisponibili);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Costruttore privato - pattern Singleton
	 */
	private VFrameCreaPrenotazioneStep_2() {
	}
	/**
	 * Metodo per ottenre l'instanza della classe - pattern Singleton
	 * @return CGestisciPrenotazione
	 */
    public static VFrameCreaPrenotazioneStep_2 getInstance() {
    	if(instance == null) {
            instance = new VFrameCreaPrenotazioneStep_2();
         }
         return instance;
    }
    /**
     * Metodo per aggiungere una colonna contenente tipologie di camere dello stesso tipo.
     * @param arrayListCamere
     */
    private void addColonnaTipologiaCamere(ArrayList<String> arrayListCamere) {
    	String tipologia;
	// Creo una colonna per mostrare i risultati della tipologia di camere
		JPanel panelColonna = new JPanel();
		panelColonna.setLayout(new  BoxLayout(panelColonna, BoxLayout.PAGE_AXIS));
		contentPane.add(panelColonna);  		
	// Ricavo la tipologia dell'ArrayList relativo alle camere di una certa tipologia.
		tipologia = arrayListCamere.get(0);
	// Aggiungo la label relativo alla tipologia alla colonna
		JLabel lbltipologia = new JLabel();
		lbltipologia.setText(tipologia);
		panelColonna.add(lbltipologia);
	//Rimuovo la tipologia dall'ArrayList.
		arrayListCamere.remove(0);
	// Ciclo sull'arrayList di String contenenti i numeri di camere ed aggiungo i numeri all'array di String creato sopra.
		for (Iterator<String> iterator = arrayListCamere.iterator(); iterator.hasNext();) {
			String numeroCamera = (String) iterator.next();
			JLabel lblNumeroCamera = new JLabel(numeroCamera);
			JButton btnNumeroCamera = new JButton("Aggiungi camera");
			lblNumeriCamereDisponibili.add(lblNumeroCamera);
			btnNumeriCamereDisponibili.add(btnNumeroCamera);
			// Aggiungo label e button al panelColonna
			panelColonna.add(lblNumeroCamera);
			panelColonna.add(btnNumeroCamera);
		}
    }
    /**
     * Metodo per aggiungere il pannello dove si visualizza il prezzo della prenotazione
     */
    private void addPanelPrezzo() {
    	// Creo un panel per far inserire all'utente i dati sul cliente
			JPanel panelPrezzo = new JPanel();
			panelPrezzo.setLayout(new  BoxLayout(panelPrezzo, BoxLayout.PAGE_AXIS));
		// Nome
			JLabel lblPrezzoScritto = new JLabel("Prezzo Totale:");
			JLabel lblPrezzoTotale = new JLabel("0€");
		// Aggiungo gli elementi al panelOspite
			panelPrezzo.add(lblPrezzoScritto);
			panelPrezzo.add(lblPrezzoTotale);
		// Aggiungo il panelOspite a panelFinale
			panelFinale.add(panelPrezzo);
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
			JLabel lblNome = new JLabel("Nome:");
			JTextField txtNome = new JTextField();
		// Cognome
			JLabel lblCognome = new JLabel("Cognome:");
			JTextField txtCognome = new JTextField();
		// eMail
			JLabel lbleMail = new JLabel("e-Mail:");
			JTextField txteMail = new JTextField();
		// telefono
			JLabel lblTelefono = new JLabel("Telefono:");
			JTextField txtTelefono = new JTextField();
		// Aggiungo gli elementi al panelOspite
			panelOspite.add(lblNome);
			panelOspite.add(txtNome);
			panelOspite.add(lblCognome);
			panelOspite.add(txtCognome);
			panelOspite.add(lbleMail);
			panelOspite.add(txteMail);
			panelOspite.add(lblTelefono);
			panelOspite.add(txtTelefono);
		// Aggiungo il panelOspite a panelFinale
			panelFinale.add(panelOspite);
    }
    /**
     * Metodo per creare il frame
     */
    public void creaFrame(ArrayList<ArrayList<String>> camereDisponibili) {
    	// Imposto il titolo e l'operazione in chiusura alla finestra
    		setTitle("iHotel - Crea nuova prenotazione - Step 2 di 2");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
			setBounds(50, 50, 1024, 500);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
		// Tipologie di camere
			int numeroTipologie = camereDisponibili.size();
    	// Numero di colonne
			int numeroColonne = numeroTipologie + 1;
    	// Setto Layout con il numero di colonne ricavato sulla base del risultato e con una riga.
			contentPane.setLayout(new GridLayout(1, numeroColonne, 0, 0));
    	// Ciclo sull'array di array di camere
	    	for (Iterator<ArrayList<String>> iteratorArrayCamere = camereDisponibili.iterator(); iteratorArrayCamere.hasNext();) {
	    		// In ogni arrayList abbiamo in prima posizione la stringa relativa alla tipologia, e successivamente i numeri di stanza.
	    		ArrayList<String> arrayListCamere = (ArrayList<String>) iteratorArrayCamere.next();
	    		addColonnaTipologiaCamere(arrayListCamere);		
			}
    	// Aggiungo il pannello finale
	    	panelFinale = new JPanel();
	    	panelFinale.setLayout(new GridLayout(2, 1, 20, 20));
    	// Aggiungi i pezzi del panelFinale
	    	addPanelPrezzo();
	    	addPanelOspite();
	    	contentPane.add(panelFinale);
	    	
	    /* ---------- EVENTI --------- */
	    	// Assegniamo l'eventListener ai bottoni
	    	for (Iterator<JButton> iterator = btnNumeriCamereDisponibili.iterator(); iterator.hasNext();) {
				JButton btnCameraDisponibile = (JButton) iterator.next();
				btnCameraDisponibile.addMouseListener(new MouseAdapter() {
					// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
					@Override
					public void mouseClicked(MouseEvent e) {
						JButton btn = new JButton();
						boolean esito;
						// Ricavo il JButton che ha generato l'evento
						btn=(JButton) e.getComponent();
						// Ricavo la sua posizione nell'ArrayList di JButton
						int numeroLista=btnNumeriCamereDisponibili.indexOf(btn);
						// Recupero il controllore e invoco il metodo.
						CGestisciPrenotazione gestisciPrenotazione = CGestisciPrenotazione.getInstance();
						// Invoco il metodo passando come parametro la stringa contenente il numero di camera.
						esito=gestisciPrenotazione.aggiungiElementoPrenotazione(lblNumeriCamereDisponibili.get(numeroLista).getText());
						if (esito==true) {
							btn.setText("Rimuovi camera");
						}
					}
				});	
			}
    }
}
