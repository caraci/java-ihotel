package com.iHotel.model;

import java.util.*;

public class MCamera {

	private LinkedList<MStatoCamera> _statiCamera = new LinkedList<MStatoCamera>();
	private String _numero;
	private String _tipologia;
	private MDescrizioneCamera _descrizioneCamera;


	/**
	 * 
	 * @param periodo
	 * @param tipologia
	 */
	public boolean isLiberaInPeriodoDaTipologia(MPeriodo periodo, String tipologia) {
		if (tipologia.equals(_tipologia)){
			for (Iterator<MStatoCamera> iterator = _statiCamera.iterator(); iterator.hasNext();) {
				MStatoCamera tmp = iterator.next();
				if(tmp.isLiberaInPeriodo(periodo)==true){
					
					return true;
				} else {
					
					return false;
				}
			}
		}	
	 return false;
	}
	/**
	 * 
	 * @param periodo
	 * @return boolean
	 * scorredo l'array _statiCamera controllo se nel periodo che gli passo è libera o meno. Nel caso sia  libera 
	 * metto false _libera
	 * 
	 * RICONTROLLARE I RETURN
	 */
	public boolean occupaInPeriodo(MPeriodo periodo){
		//definisco lo stato occupato, lo stato contenente e lo stato residuo
		MStatoCamera statoOccupato = new MStatoCamera();
		MStatoCamera statoContenente = new MStatoCamera();
		MStatoCamera statoResiduo = new MStatoCamera();
		//setto subito i parametri dello stato occupato perchè li ho
		statoOccupato.set_periodo(periodo);
		statoOccupato.set_libera(false);
		int indiceLista=0;
		int i= 1;
		//devo andare a prendere lo statoCamera il cui periodo contiene il periodo della prenotazione 
		
		for (Iterator<MStatoCamera> iterator = this._statiCamera.iterator(); iterator.hasNext();) {
			MStatoCamera statoCamera = (MStatoCamera) iterator.next();
			 if (statoCamera.getStatoContenente(periodo)!=null)
				 statoContenente=statoCamera.getStatoContenente(periodo);
			 else {
				 System.out.print("a maggico, guarda che manca il periodo contenente. periodo esaminato è il numero : "+ i + "\n");}
			 ++i;
		}
		
		
		indiceLista =_statiCamera.indexOf(statoContenente);
		
		//periodo dello stato contenente
		MPeriodo periodoStatoContenente = statoContenente.get_periodo();
		
		//qua si incasina un pò aniddoc
		
		//ricavo le date dal periodo stato contenete
		
		GregorianCalendar dataInizioPeriodoStatoContenente = new GregorianCalendar();
		dataInizioPeriodoStatoContenente.set(periodoStatoContenente.get_annoInizio(), periodoStatoContenente.get_meseInizio(), periodoStatoContenente.get_giornoInizio());
				
		GregorianCalendar dataFinePeriodoStatoContenente = new GregorianCalendar();
		dataFinePeriodoStatoContenente.set(periodoStatoContenente.get_annoFine(), periodoStatoContenente.get_meseFine(), periodoStatoContenente.get_giornoFine());
		
		//date del periodo stato contenente ricavate.
		
		//ricavo le date del periodo della prenotazione
		GregorianCalendar dataInizioPeriodoPrenotazione = new GregorianCalendar();
		dataInizioPeriodoPrenotazione.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		
		GregorianCalendar dataFinePeriodoPrenotazione = new GregorianCalendar();
		dataFinePeriodoPrenotazione.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		//date del periodo della prenotazione ricavate
		
		//ricavo i periodi
		

		//Periodo residuo, data inizio = data fine prenotazione +1, data fine = data fine periodo contenente
		MPeriodo periodoResiduo = new MPeriodo();
		
		//calcolo data inizio del periodo residuo
		dataFinePeriodoPrenotazione.add(Calendar.DAY_OF_MONTH,1);
		int giornoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.DATE);
		//System.out.print(giornoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.DATE));
		int meseDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.MONTH);
		int annoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.YEAR);
		//setto gli attributi del periodo residuo
		periodoResiduo.set_giornoInizio(giornoDopoFinePrenotazione);
		periodoResiduo.set_meseInizio(meseDopoFinePrenotazione);
		periodoResiduo.set_annoInizio(annoDopoFinePrenotazione);		
		periodoResiduo.set_giornoFine(periodoStatoContenente.get_giornoFine());
		periodoResiduo.set_meseFine(periodoStatoContenente.get_meseFine());
		periodoResiduo.set_annoFine(periodoStatoContenente.get_annoFine());
			
		
		// non serve pd
		//periodo occupazione
		// data fine = data fine rpenotazione, data inizio = data inizio prenotazione
		/*MPeriodo periodoStatoOccupato = new MPeriodo();
		periodoStatoOccupato.set_annoInizio(periodo.get_annoInizio());
		periodoStatoOccupato.set_meseInizio(periodo.get_meseInizio());
		periodoStatoOccupato.set_giornoInizio(periodo.get_giornoInizio());
		
		periodoStatoOccupato.set_annoFine(periodo.get_annoFine());
		periodoStatoOccupato.set_meseFine(periodo.get_meseFine());
		periodoStatoOccupato.set_giornoFine(periodo.get_giornoFine());*/
		
		// periodo prima della prenotazione
		//data inizio = data inizio periodo contenente, data fine = data inizio prenotazione -1
		//ricavo il giorno prima di quello dell'inizio della prenotazione e il giorno dopo la fine della prenotazione
		dataInizioPeriodoPrenotazione.add(Calendar.DAY_OF_MONTH, -1);		
		int giornoPrimaDellaPrenotazione=dataInizioPeriodoPrenotazione.get(Calendar.DATE);
		int mesePrimaDellaPrenotazione= dataInizioPeriodoPrenotazione.get(Calendar.MONTH);
		int annoPrimaDellaPrenotazione= dataInizioPeriodoPrenotazione.get(Calendar.YEAR);
		
		periodoStatoContenente.set_annoFine(annoPrimaDellaPrenotazione);
		periodoStatoContenente.set_meseFine(mesePrimaDellaPrenotazione);
		periodoStatoContenente.set_giornoFine(giornoPrimaDellaPrenotazione);
		//Confronto che il periodo contenente residuo abbia almeno un giorno.
		//System.out.print("bella "+periodoStatoContenente.get_giornoFine());
		GregorianCalendar nuovaDataFinePeriodoStatoContenente = new GregorianCalendar();
		nuovaDataFinePeriodoStatoContenente.set(periodoStatoContenente.get_annoFine(), periodoStatoContenente.get_meseFine(), periodoStatoContenente.get_giornoFine());
		if(dataInizioPeriodoStatoContenente.compareTo(nuovaDataFinePeriodoStatoContenente)==1){
			
			this.get_statiCamera().remove(indiceLista);
			indiceLista = indiceLista -1;
		}
		else{
		statoContenente.set_periodo(periodoStatoContenente);
		statoContenente.set_libera(true);
		}
		statoResiduo.set_periodo(periodoResiduo);
		statoResiduo.set_libera(true);
		//System.out.print("indice lista "+ indiceLista+ "\n");
		this.get_statiCamera().add(indiceLista + 1, statoOccupato);
		this.get_statiCamera().add(indiceLista +2 , statoResiduo);
		return true;
	}

	

	// Getter, Setter
	/**
	 * @return the _statiCamera
	 */
	public LinkedList<MStatoCamera> get_statiCamera() {
		return _statiCamera;
	}

	/**
	 * @param _statiCamera the _statiCamera to set
	 */
	public void set_statiCamera(LinkedList<MStatoCamera> _statiCamera) {
		this._statiCamera = _statiCamera;
	}

	public String get_numero() {
		return this._numero;
	}

	/**
	 * 
	 * @param _numero
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
	}

	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * 
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}

	public MDescrizioneCamera get_descrizioneCamera() {
		return this._descrizioneCamera;
	}

	public void set_descrizioneCamera(MDescrizioneCamera _descrizioneCamera) {
		this._descrizioneCamera = _descrizioneCamera;
	}

}
