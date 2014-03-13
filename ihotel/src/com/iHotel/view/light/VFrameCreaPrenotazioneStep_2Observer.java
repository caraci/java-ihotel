package com.iHotel.view.light;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.model.PrenotazioneSubject;
import com.iHotel.model.ISubject;
import com.iHotel.view.IObserver;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class VFrameCreaPrenotazioneStep_2Observer extends JFrame implements IObserver {

	/* ContentPane */
	private JPanel contentPane;
	/* Panel */
    private JPanel panelFinale;
    /* JList */
    private ArrayList<JLabel> lblNumeriCamereDisponibili = new ArrayList<JLabel>();
    /* JButton */
    private ArrayList<JButton> btnNumeriCamereDisponibili = new ArrayList<JButton>();
    private JButton btnCompletaPrenotazione;
    /* JLabel */
    private JLabel lblNome, lblCognome, lbleMail, lblTelefono, lblPrezzoTotale, lblPrezzoScritto;
    /* JTextField */
    private JTextField txtNome, txtCognome, txteMail, txtTelefono;
    // Pattern Observer
    private PrenotazioneSubject _prenotazioneSubject;
    /* ----------------- Pattern Singleton  ---------------- */
	private static VFrameCreaPrenotazioneStep_2Observer instance = null;
   
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private VFrameCreaPrenotazioneStep_2Observer() {
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameCreaPrenotazioneStep_2 Instanza unica di questa classe.
	 */
    public static VFrameCreaPrenotazioneStep_2Observer getInstance() {
    	if(instance == null) {
            instance = new VFrameCreaPrenotazioneStep_2Observer();
         }
         return instance;
    }
    /* ----------------- /Pattern Singleton  ---------------- */
    /* ------------- Pattern Observer ----------- */
    @Override
	public void Update() {
		String total=String.valueOf(_prenotazioneSubject.get_total());	
		// Setto il prezzo della Label con il totale della prenotazione
		lblPrezzoTotale.setText(total + "€");
	}
    /* ------------- /Pattern Observer --------- */
    /**
     * Metodo per aggiungere una colonna contenente tipologie di camere dello stesso tipo.
     * 
     * @param arrayListCamere Struttura dati contenente tipologia della camera e numeri di camera.
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
		JLabel lblTipologia = new JLabel();
		lblTipologia.setText(tipologia + ":");
		panelColonna.add(lblTipologia);
	// Aggiungo spaziatura statica
		panelColonna.add(Box.createRigidArea(new Dimension(0,20)));
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
			lblPrezzoScritto = new JLabel("Prezzo Totale:");
			lblPrezzoTotale = new JLabel("0€");
		// Aggiungo gli elementi al panelOspite
			panelPrezzo.add(lblPrezzoScritto);
			panelPrezzo.add(Box.createRigidArea(new Dimension(0,20)));
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
			lblNome = new JLabel("Nome:");
			txtNome = new JTextField();
		// Cognome
			lblCognome = new JLabel("Cognome:");
			txtCognome = new JTextField();
		// eMail
			lbleMail = new JLabel("e-Mail:");
			txteMail = new JTextField();
		// telefono
			lblTelefono = new JLabel("Telefono:");
			txtTelefono = new JTextField();
		// Button completa prenotazione
			btnCompletaPrenotazione = new JButton("Completa Prenotazione");
		// Aggiungo gli elementi al panelOspite
			panelOspite.add(lblNome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txtNome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(lblCognome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txtCognome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(lbleMail);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txteMail);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(lblTelefono);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txtTelefono);
			panelOspite.add(Box.createRigidArea(new Dimension(0,20)));
			panelOspite.add(btnCompletaPrenotazione);
		// Aggiungo il panelOspite a panelFinale
			panelFinale.add(panelOspite);
    }
    /**
     * Metodo per creare il frame.
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

	    	for (Iterator<JButton> iterator = btnNumeriCamereDisponibili.iterator(); iterator.hasNext();) {
				JButton btnCameraDisponibile = (JButton) iterator.next();				
				// Assegniamo l'eventListener al JButton btnCameraDisponibile
				btnCameraDisponibile.addMouseListener(new MouseAdapter() {
					// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
					@Override
					public void mouseClicked(MouseEvent e) {
						JButton btn = new JButton();
						// Ricavo il JButton che ha generato l'evento
						btn=(JButton) e.getComponent();
						// Ricavo la sua posizione nell'ArrayList di JButton
						int numeroLista=btnNumeriCamereDisponibili.indexOf(btn);
						// Recupero il controllore e invoco il metodo.
						CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
						// Aggiungo la camera alla prenotazione e carico il totale.
						gestisciPrenotazione.aggiungiCameraAllaPrenotazione(lblNumeriCamereDisponibili.get(numeroLista).getText());
						// Cambio testo al bottone
						btn.setText("Rimuovi camera");
					}
				});
    		}
			// Assegniamo l'eventListener al JButton btnCompletaPrenotazione
			btnCompletaPrenotazione.addMouseListener(new MouseAdapter() {
				// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
				@Override
				public void mouseClicked(MouseEvent e) {
					// Recupero il controllore e invoco il metodo.
					CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
					// Invoco il metodo passando come parametro la stringa contenente il numero di camera.
					gestisciPrenotazione.concludiPrenotazione(txtNome.getText(), txtCognome.getText(), txteMail.getText(), txtTelefono.getText());
				}
			});		
    }
    /* ------------- Getter, Setter */
    public void set_prenotazioneSubject(ISubject subject) {
    	this._prenotazioneSubject=(PrenotazioneSubject) subject;
    }
}
