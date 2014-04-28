package com.iHotel.model.Albergo.Cataloghi;

import java.util.*;

import com.iHotel.model.Utility.MyDate;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe rappresenta il descrittore di una camera. Ha quindi il compito di mantere le informazioni generali
 * della camera(e.g.: prezzo). L'uso di questo descrittore si basa non sulla singola camera, ma sul fatto che l'albergo
 * ha più camere della stessa tipologia, quindi che condividono le stesse informazioni, ed aiuta a ridurre la ridondanza.
 * @author Alessandro
 *
 */
public class DescrizioneCamera {

	/* -------------------------- Attributi -------------------------------------- */
	
	private ArrayList<PrezzoCamera> _prezziCamera;
	private String _tipologia;
	/**
	 * Costruttore.
	 */
	public DescrizioneCamera() {
		_prezziCamera=new ArrayList<PrezzoCamera>();
	}

	/* ----------------------- Metodi di instanza ----------------------------------------- */
	
	/**
	 * Metodo per ottenere tutti i prezzi per una tipologia di camera, in un certo periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Lista dei prezzi per una tipologia di camera in un periodo
	 */
	public ArrayList<PrezzoCamera> getPrezziInPeriodo(Periodo periodo) {
		ArrayList<PrezzoCamera> prezziCamera = new ArrayList<PrezzoCamera>();
		PrezzoCamera prezzoCameraPeriodo = new PrezzoCamera();
		// Ciclo sui PrezzoCamera 
		for (Iterator<PrezzoCamera> iterator = _prezziCamera.iterator(); iterator.hasNext();) {
			PrezzoCamera prezzoCamera = iterator.next();
			// Se otteniamo un PrezzoCamera valido lo aggiungo alla lista.
			if(prezzoCamera.getPrezzoInPeriodo(periodo) != null) {
				prezzoCameraPeriodo = prezzoCamera.getPrezzoInPeriodo(periodo);
				prezziCamera.add(prezzoCameraPeriodo);
			}
		}		
		return prezziCamera;
	}
	/**
	 * Metodo che calcola il prezzo per la tipologia di camera descritta dal descrittore,
	 * nel periodo passato come parametro.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Prezzo totale della camera nel periodo.
	 */
	public Prezzo calcolaPrezzoInPeriodo(Periodo periodo) {
		// Data di inizio della richiesta.
		MyDate dataInizio = new MyDate();
		dataInizio.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		MyDate dataFine= new MyDate();
		dataFine.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
					
		// Variabili nelle quali si andranno a memorizzare i totali.
		double totaleCameraGiorno=0;
		double totaleCameraPeriodo=0;
		
		// Ciclo a partire dal giorno di inizio fino al giorno finale.
		while (dataInizio.compareTo(dataFine) < 0) {
		
			// Calcolo il prezzo della camera in un giorno attraverso il metodo privato di MElementoPrenotazione
			totaleCameraGiorno=calcolaPrezzoGiorno(_prezziCamera,dataInizio);
			// Sommo il totale della camera nel giorno, al totale della camera per il periodo.
			totaleCameraPeriodo+=totaleCameraGiorno;
			// Incremento il giorno di uno.
			dataInizio.add(Calendar.DAY_OF_MONTH,1);
		}
		// Prezzo da ritornare
		Prezzo prezzo= new Prezzo();
		// Setto l'importo del prezzo
		prezzo.set_importo(totaleCameraPeriodo);
		return prezzo;
		
	}
	
	/**
	 * Metodo per calcolare il prezzo in un giorno relativo ad una camera.
	 * 
	 * @param prezziCamera Insieme dei prezzi della camera.	
	 * @param data Giorno in cui bisogna calcolare il prezzo della camera
	 * @return Prezzo della camera in un giorno.
	 */
	private double calcolaPrezzoGiorno(ArrayList<PrezzoCamera> prezziCamera, MyDate data){	
		// Creo un periodo con data inizio uguale a data fine
		Periodo periodo= new Periodo();
		periodo.setDataInizioDaData(data);	
		periodo.setDataFineDaData(data);
		// Variabile nella quale andremo a memorizzare il totale per il giorno.
		double prezzoGiorno=0;
		
		PrezzoCamera prezzoCameraPeriodo = new PrezzoCamera();
		// Ciclo su tutti gli MPrezzoCamera che ho a disposizione
		for (Iterator<PrezzoCamera> iterator = prezziCamera.iterator(); iterator.hasNext();) {
			PrezzoCamera prezzoCamera = (PrezzoCamera) iterator.next();
			if (prezzoCamera.getPrezzoInPeriodo(periodo)!=null) {
				prezzoCameraPeriodo=prezzoCamera.getPrezzoInPeriodo(periodo);
				prezzoGiorno=prezzoCameraPeriodo.get_prezzo().get_importo();
			}
		}
		return prezzoGiorno;
	}
	
	/* ------------------------------- Getter e Setter -------------------- */
	/**
	 * @return _prezziCamera  
	 */
	public ArrayList<PrezzoCamera> get_prezziCamera() {
		return _prezziCamera;
	}

	/**
	 * @param _prezziCamera 
	 */
	public void set_prezziCamera(ArrayList<PrezzoCamera> _prezziCamera) {
		this._prezziCamera = _prezziCamera;
	}

	/**
	 * @return _tipologia
	 */
	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}
}