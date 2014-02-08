package com.iHotel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.MCamera;

public class VFrameCreaPrenotazioneStep_2 extends JFrame {

	/* Singleton */
	private static VFrameCreaPrenotazioneStep_2 instance = null;
	/* ContentPane */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VFrameCreaPrenotazioneStep_2 frame = new VFrameCreaPrenotazioneStep_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Costruttore privato per il pattern Singleton
	 */
	private VFrameCreaPrenotazioneStep_2() {}
	/**
	 * 
	 * @return CGestisciPrenotazione
	 */
    public static VFrameCreaPrenotazioneStep_2 getInstance() {
    	if(instance == null) {
            instance = new VFrameCreaPrenotazioneStep_2();
         }
         return instance;
    }
    /**
     * 
     */
    public void creaFrame(ArrayList<ArrayList<MCamera>> camereDisponibili) {
    	// Ciclo sull'array di array di camere
    	for (Iterator<ArrayList<MCamera>> iteratorArrayCamere = camereDisponibili.iterator(); iteratorArrayCamere.hasNext();) {
			ArrayList<MCamera> arrayListCamere = (ArrayList<MCamera>) iteratorArrayCamere.next();
			// Creo una colonna per mostrare i risultati
			
			// Ciclo sull'array di MCamera
			for (Iterator<MCamera> iteratorCamere = arrayListCamere.iterator(); iteratorCamere.hasNext();) {
				MCamera camera = (MCamera) iteratorCamere.next();
			}
			
		}
    }

}
