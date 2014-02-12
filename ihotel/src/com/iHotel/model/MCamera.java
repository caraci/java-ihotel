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
	 * @return _boolean
	 * Metodo che restituisce un booleano: true se la stanza è libera nel periodo passato come parametro,
	 * altrimenti restituisce false
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodo) {		
		for (Iterator<MStatoCamera> iterator = _statiCamera.iterator(); iterator.hasNext();) {
			MStatoCamera tmp = iterator.next();				
			if(tmp.isLiberaInPeriodo(periodo)==true)					
				return true;							
		}
		return false; 
	}

	/**
	 * 
	 * @param periodo
	 * @return true
	 * Metodo che occupa una stanza nel periodo passato come parametro. Risulta evidente che dato il periodo di occupazione,
	 * c'è la necessità di creare un periodo prima ed uno dopo a quello della prenotazione, in cui la camera risulti
	 * essere libera.
	 */
	public boolean occupaInPeriodo(MPeriodo periodo) {
		//definisco lo stato contenente, lo stato occupato e lo stato residuo. Setto i parametri dello stato occupato
		//perchè li ho già tutti per farlo.
		
		
		MStatoCamera statoContenente = new MStatoCamera();
		MStatoCamera statoOccupato = new MStatoCamera();
		MStatoCamera statoResiduo = new MStatoCamera();
		statoOccupato.set_periodo(periodo);
		statoOccupato.set_libera(false);
		//indiceLista serve perchè poi dovrò riposizionare i periodi
		int indiceLista=0;
	
		//devo prendere lo statoCamera il cui periodo contiene il periodo della prenotazione 
		
		for (Iterator<MStatoCamera> iterator = this._statiCamera.iterator(); iterator.hasNext();) {
			MStatoCamera statoCamera = (MStatoCamera) iterator.next();
			 if (statoCamera.getStatoContenente(periodo)!=null){
				 statoContenente=statoCamera.getStatoContenente(periodo);
				 indiceLista =_statiCamera.indexOf(statoContenente);
			 }
		}	
				
		MPeriodo periodoStatoContenente = statoContenente.get_periodo();	
		
		//qua si incasina un pò aniddoc
		
		//faccio una copia dell'oggetto periodoStatoContenente, perché se lavorassi direttamente su periodoStatoContenente 
		//avrei problemi di sovrapposizione dei riferimenti
		
		/* magheggio per creare un nuovo periodo stato contenente*/
		
		int gi = periodoStatoContenente.get_giornoInizio();
		int mi = periodoStatoContenente.get_meseInizio();
		int ai = periodoStatoContenente.get_annoInizio();
		
		int gf = periodoStatoContenente.get_giornoFine();
		int mf = periodoStatoContenente.get_meseFine();
		int af = periodoStatoContenente.get_annoFine();
		
		MPeriodo nuovoPeriodoStatoContenente = new MPeriodo();
		nuovoPeriodoStatoContenente.set_giornoInizio(gi);
		nuovoPeriodoStatoContenente.set_meseInizio(mi);
		nuovoPeriodoStatoContenente.set_annoInizio(ai);
		nuovoPeriodoStatoContenente.set_giornoFine(gf);
		nuovoPeriodoStatoContenente.set_meseFine(mf);
		nuovoPeriodoStatoContenente.set_annoFine(af);
		
		//ricavo le date dal nuovoPeriodoStatoContenente (banalmente uguali a quelle di periodoStatoContenente
		
		GregorianCalendar dataInizioPeriodoStatoContenente = new GregorianCalendar();
		dataInizioPeriodoStatoContenente.set(nuovoPeriodoStatoContenente.get_annoInizio(), nuovoPeriodoStatoContenente.get_meseInizio(), nuovoPeriodoStatoContenente.get_giornoInizio());
				
		GregorianCalendar dataFinePeriodoStatoContenente = new GregorianCalendar();
		dataFinePeriodoStatoContenente.set(nuovoPeriodoStatoContenente.get_annoFine(), nuovoPeriodoStatoContenente.get_meseFine(), nuovoPeriodoStatoContenente.get_giornoFine());
		
				
		//ricavo le date del periodo della prenotazione
		GregorianCalendar dataInizioPeriodoPrenotazione = new GregorianCalendar();
		dataInizioPeriodoPrenotazione.set(periodo.get_annoInizio(), periodo.get_meseInizio(), periodo.get_giornoInizio());
		
		GregorianCalendar dataFinePeriodoPrenotazione = new GregorianCalendar();
		dataFinePeriodoPrenotazione.set(periodo.get_annoFine(), periodo.get_meseFine(), periodo.get_giornoFine());
		
	
		//Ricavo i periodi degli stati che si vengono a creare in seguito all'occupazione della camera in un
		//certo periodo
		
		
		/* ********* Periodo residuo: dal giorno dopo  data di fine della prenotazione al giorno della fine periodoStatoContenente************/
		MPeriodo periodoResiduo = new MPeriodo();
		
		//calcolo data inizio del periodo residuo
		dataFinePeriodoPrenotazione.add(Calendar.DAY_OF_MONTH,1);
		int giornoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.DATE);
		int meseDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.MONTH);
		int annoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.YEAR);
		
		//Setting degli attributi
		periodoResiduo.set_giornoInizio(giornoDopoFinePrenotazione);
		periodoResiduo.set_meseInizio(meseDopoFinePrenotazione);
		periodoResiduo.set_annoInizio(annoDopoFinePrenotazione);		
		periodoResiduo.set_giornoFine(periodoStatoContenente.get_giornoFine());
		periodoResiduo.set_meseFine(periodoStatoContenente.get_meseFine());
		periodoResiduo.set_annoFine(periodoStatoContenente.get_annoFine());
			
		
		/* ************ Periodo antecedente: dal giorno di inizio del nuovoPeriodoStatoContenente fino al giorno prima della data di inizio
		 * della prenotazione prenotazione ******************/
		
		//calcolo il giorno precedente alla data di inizio della prenotazione
		dataInizioPeriodoPrenotazione.add(Calendar.DAY_OF_MONTH, -1);		
		int giornoPrimaDellaPrenotazione=dataInizioPeriodoPrenotazione.get(Calendar.DATE);
		int mesePrimaDellaPrenotazione= dataInizioPeriodoPrenotazione.get(Calendar.MONTH);
		int annoPrimaDellaPrenotazione= dataInizioPeriodoPrenotazione.get(Calendar.YEAR);
		
		//setto la data di termine del nuovoPeriodoStatoContenente al giorno precedente all'inizio della prenotazione.
		nuovoPeriodoStatoContenente.set_annoFine(annoPrimaDellaPrenotazione);
		nuovoPeriodoStatoContenente.set_meseFine(mesePrimaDellaPrenotazione);
		nuovoPeriodoStatoContenente.set_giornoFine(giornoPrimaDellaPrenotazione);
		
		//Devo verificare che nuovoPeriodoStatoContenente abbia almeno un giorno. Se così non fosse devo eliminarlo dalla lista dei periodo		
		GregorianCalendar nuovaDataFinePeriodoStatoContenente = new GregorianCalendar();
		nuovaDataFinePeriodoStatoContenente.set(nuovoPeriodoStatoContenente.get_annoFine(), nuovoPeriodoStatoContenente.get_meseFine(), nuovoPeriodoStatoContenente.get_giornoFine());
		
		if(dataInizioPeriodoStatoContenente.compareTo(nuovaDataFinePeriodoStatoContenente)==1){			
			this.get_statiCamera().remove(indiceLista);
			//dopo aver cancellato un elemento dalla lista, diminuisco l'indice.
			indiceLista = indiceLista -1;
		}
		else{
			statoContenente.set_periodo(nuovoPeriodoStatoContenente);
			statoContenente.set_libera(true);
		}
		
		statoResiduo.set_periodo(periodoResiduo);
		statoResiduo.set_libera(true);
		
		this.get_statiCamera().add(indiceLista + 1, statoOccupato);
		this.get_statiCamera().add(indiceLista +2 , statoResiduo);
		
		return true;
	}

	

	// Getter, Setter
	/**
	 * @return the _statiCamera
	 * Metodo che restituisce gli stati della camera
	 */
	public LinkedList<MStatoCamera> get_statiCamera() {
		return _statiCamera;
	}

	/**
	 * @param _statiCamera the _statiCamera to set
	 * Metodo che setta gli stati della MCamera, data una LinkedList che li contiene 
	 */
	public void set_statiCamera(LinkedList<MStatoCamera> _statiCamera) {
		this._statiCamera = _statiCamera;
	}
	/**
	 * 
	 * @return _numero
	 * Metodo che serve a restituire il numero della MCamera
	 */
	public String get_numero() {
		return this._numero;
	}

	/**
	 * 
	 * @param _numero
	 * Metodo che serve a settare il numero della MCamera
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
	}
	/**
	 * 
	 * @return _tipologia
	 * Metodo che restituisce la tipologia della MCamera
	 */
	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * 
	 * @param _tipologia
	 * Metodo che serve a settare la tipologia della MCamera
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}
	/**
	 * 
	 * @return _descrizioneCamera
	 * Metodo che restituisce l'oggetto che contiene la MDescrizioneCamera della MCamera
	 */
	public MDescrizioneCamera get_descrizioneCamera() {
		return this._descrizioneCamera;
	}
	/**
	 * 
	 * @param _descrizioneCamera
	 * Metodo che associa alla MCamera corrente la MDescrizioneCamera passata come parametro
	 */
	public void set_descrizioneCamera(MDescrizioneCamera _descrizioneCamera) {
		this._descrizioneCamera = _descrizioneCamera;
	}

}
