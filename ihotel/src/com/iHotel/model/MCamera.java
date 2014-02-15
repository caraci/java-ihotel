package com.iHotel.model;

import java.util.*;

public class MCamera {

	private LinkedList<MStatoCamera> _statiCamera = new LinkedList<MStatoCamera>();
	private String _numero;
	private String _tipologia;
	private MDescrizioneCamera _descrizioneCamera;


	/**
	 * Metodo per controllare se una camera è libera in un periodo.
	 * @param periodoRichiesta Periodo nel quale si vuole prenotare la camera.
	 * @return True se la camera è libera nel periodo. False altrimenti.
	 */
	public boolean isLiberaInPeriodo(MPeriodo periodoRichiesta) {		
		for (Iterator<MStatoCamera> iterator = _statiCamera.iterator(); iterator.hasNext();) {
			MStatoCamera statoCamera = iterator.next();				
			if(statoCamera.isLiberaInPeriodo(periodoRichiesta)==true)					
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
		
		MStatoCamera statoOccupato = new MStatoCamera();
		statoOccupato.set_periodo(periodo);
		statoOccupato.set_libera(false);		
		
		//indiceLista serve perchè poi dovrò riposizionare i periodi
		int indiceLista=0;
	
		//devo prendere lo statoCamera il cui periodo contiene il periodo della prenotazione 
		
		MStatoCamera statoContenente = new MStatoCamera();
		for (Iterator<MStatoCamera> iterator = this._statiCamera.iterator(); iterator.hasNext();) {
			MStatoCamera statoCamera = (MStatoCamera) iterator.next();
			 if (statoCamera.getStatoContenente(periodo)!=null){
				 statoContenente=statoCamera.getStatoContenente(periodo);
				 indiceLista =_statiCamera.indexOf(statoContenente);
			 }
		}			
	
		/* questo lo eseguo se il periodo della prenotazione riguarda non il primo periodo in cui la stanza è libera
		* e non l'ultimo*/
		if (indiceLista != 0 && indiceLista<(this.get_statiCamera().size()-1)){
			System.out.print("indicelista != 0");
			MPeriodo periodoPrecedente = this.get_statiCamera().get(indiceLista -1).get_periodo();
			MPeriodo periodoSuccessivo = this.get_statiCamera().get(indiceLista +1).get_periodo();
			
			//quando il periodo è contenuto esattamente tra quello prima e quello dopo
			if(periodo.contenutoTraPeriodi(periodoPrecedente, periodoSuccessivo)){
				//creo nuovo periodo lungo dall'inizio del periodo precedente alla fine del periodo occupato
				
				MPeriodo periodoOccupazioneAllungato = new MPeriodo();
				periodoOccupazioneAllungato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				periodoOccupazioneAllungato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
				//vado a cambiare lo stato precedente, assegnandogli il periodo allungato e assegnandogli
				//l'occupazione della stanza
				this.get_statiCamera().get(indiceLista -1).set_periodo(periodoOccupazioneAllungato);
				this.get_statiCamera().get(indiceLista -1).set_libera(false);
				//rimuovo lo stato successivo a quello contenente, e lo stato contenente.
				this.get_statiCamera().remove(indiceLista+1);
				this.get_statiCamera().remove(indiceLista);
			}
			//se il periodo è immediatamente dopo un periodo in cui la stanza è occupata
			else if (periodo.segue(periodoPrecedente)){
				/*Creo un periodo di occupazione allungato che va dal giorno di inizio del periodo
				*precedente fino alla fine della prenotazione */
				MPeriodo periodoOccupazioneAllungato = new MPeriodo();
				periodoOccupazioneAllungato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				periodoOccupazioneAllungato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				//cambio lo stato precedente a quello contenente, assegnandogli il periodo di occupazoione allungato 
				this.get_statiCamera().get(indiceLista -1).set_periodo(periodoOccupazioneAllungato);
				this.get_statiCamera().get(indiceLista -1).set_libera(false);
				
				/*Definisco il periodo residuo, che va dal giorno del termine della prenotazione al giorno
				di fine del periodo dello stato contenente*/
				
				MPeriodo periodoResiduo = new MPeriodo();
				periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				//modifico lo statoContenente assegnandogli il periodo residuo libero
				this.get_statiCamera().get(indiceLista).set_periodo(periodoResiduo);
				this.get_statiCamera().get(indiceLista).set_libera(true);
			}
			//se il periodo è immediatamente precedente ad uno in cui la stanza è occupata
			else if (periodo.anticipa(periodoSuccessivo)){
				/*definisco un nuovo periodo di occupazione che va dal giorno del termine della prenotazione 
				 * fino al giorno del successivo periodo occupato
				 */
				MPeriodo periodoOccupazioneAllungato = new MPeriodo();
				periodoOccupazioneAllungato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				periodoOccupazioneAllungato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
				
				//assegno il periodo di occupazione allungato allo stato successivo allo statoContenente
				this.get_statiCamera().get(indiceLista +1 ).set_periodo(periodoOccupazioneAllungato);
				this.get_statiCamera().get(indiceLista +1 ).set_libera(false);
				/*
				 * Definisco il periodo antecedente a quello di occupazione, come quello che va dal primo giorno 
				 * del periodo contenente al primo giorno della prenotazione. in questo periodo la stanza è libera.
				 */
				MPeriodo periodoAntecedente = new MPeriodo();
				periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
				periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
				//assegno il periodo antecedente allo stato precedente a qeullo in cui la stanza sarà occupata
				this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
				this.get_statiCamera().get(indiceLista).set_libera(true);
			}
			else{
				/*applico il metodo privato che mi calcola i nuovi periodi Antecedente,Occupato e Residuo, che si
				 * devono generare visto che il periodo di occupazione non combacia con nessuno degli estremi 
				 * del periodo dello statoContenente.
				 */
				this.calcolaNuoviPeriodi(statoContenente,periodo,indiceLista);				
				
			}
		}
		/*
		 * questo viene eseguito se lo stato che contiene il periodo in cui sto occupando la stanza, è il primo
		 * nella lista degli stati
		 */
		else if(indiceLista ==0)
		{			
			/*
			 * Definisco il periodo successivo, il periodo dello stato successivo allo statoContenente
			 */
			MPeriodo periodoSuccessivo = this.get_statiCamera().get(indiceLista +1).get_periodo();			
			
			//Se il periodo della prenotazione dura quanto tutto il periodo dello statoContenente
			 
			if (periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true && periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){				
				System.out.println("indice lista"+ indiceLista + "sono in 1 caso");
					MPeriodo periodoOccupato = new MPeriodo();
					periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
					periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
					MStatoCamera nuovoStatoOccupato= new MStatoCamera();
					nuovoStatoOccupato.set_periodo(periodoOccupato);
					nuovoStatoOccupato.set_libera(false);
					this.get_statiCamera().remove(indiceLista+1);
					this.get_statiCamera().set(indiceLista, nuovoStatoOccupato);
			}
			 else if(periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){		
				 System.out.println("indice lista"+ indiceLista + "sono in 2 caso");
					MPeriodo periodoAntecedente = new MPeriodo();
					periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
					periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
					this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
					this.get_statiCamera().get(indiceLista).set_libera(true);
					
					
					MPeriodo periodoOccupato = new MPeriodo();
					periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
					periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
					MStatoCamera nuovoStatoOccupato = new MStatoCamera();
					nuovoStatoOccupato.set_periodo(periodoOccupato);
					nuovoStatoOccupato.set_libera(false);
					this.get_statiCamera().add(indiceLista+1, nuovoStatoOccupato);
					
					this.get_statiCamera().remove(indiceLista+2);
					
				}
			 else if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true){
				 System.out.println("indice lista"+ indiceLista + "sono in 3 caso");
				 
				 MPeriodo periodoOccupato = new MPeriodo();
				 periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				 periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				 
				 MStatoCamera nuovoStatoOccupato = new MStatoCamera();
				 nuovoStatoOccupato.set_periodo(periodoOccupato);
				 nuovoStatoOccupato.set_libera(false);
				 this.get_statiCamera().add(indiceLista, nuovoStatoOccupato);
				 
				 MPeriodo periodoResiduo = new MPeriodo();
				 periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				 periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				 this.get_statiCamera().get(indiceLista+1).set_periodo(periodoResiduo);
				 this.get_statiCamera().get(indiceLista+1).set_libera(true);
			 }
			 else{
				 System.out.println("indice lista"+ indiceLista + "sono in 4 caso");
					this.calcolaNuoviPeriodi(statoContenente, periodo, indiceLista);

					
			 }
		}
		else if(indiceLista == this.get_statiCamera().size()-1){
			MPeriodo periodoPrecedente = this.get_statiCamera().get(indiceLista-1).get_periodo();
			if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true&& periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){
				System.out.println("indice lista"+ indiceLista + "sono in 1 caso");
				MPeriodo nuovoPeriodoOccupato= new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				this.get_statiCamera().get(indiceLista-1).set_periodo(nuovoPeriodoOccupato);
				this.get_statiCamera().get(indiceLista-1).set_libera(false);
				this.get_statiCamera().remove(indiceLista);
			}
			else if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true){
				System.out.println("indice lista"+ indiceLista + "sono in 2 caso");
				
				MPeriodo nuovoPeriodoOccupato = new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				
				this.get_statiCamera().get(indiceLista-1).set_periodo(nuovoPeriodoOccupato);
				this.get_statiCamera().get(indiceLista -1).set_libera(false);
				
				MPeriodo periodoResiduo = new MPeriodo();
				periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				this.get_statiCamera().get(indiceLista).set_periodo(periodoResiduo);
				this.get_statiCamera().get(indiceLista).set_libera(true);
				
			}
			else if(periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){
				System.out.println("indice lista"+ indiceLista + "sono in 3 caso");
				MPeriodo periodoAntecedente =new MPeriodo();
				periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
				periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
				
				this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
				this.get_statiCamera().get(indiceLista).set_libera(true);
				
				MPeriodo nuovoPeriodoOccupato = new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				
				MStatoCamera nuovoStatoOccupato = new MStatoCamera();
				nuovoStatoOccupato.set_periodo(nuovoPeriodoOccupato);
				nuovoStatoOccupato.set_libera(false);
				this.get_statiCamera().add(nuovoStatoOccupato);
				
			}
			else{
				System.out.println("indice lista"+ indiceLista + "sono in 4 caso");				
				this.calcolaNuoviPeriodi(statoContenente, periodo, indiceLista);
					
			}
		}
		
		
		return true;
	}
	
	
	/**
	 * Metodo che a partire dallo stato contenente, dal periodo della prenotazione e dall'indice della lista
	 * in cui si trova lo stato contenente, va a calcolare due nuovi periodi, uno precedente alla prenotazione 
	 * ed uno successivo, in cui la camera è libera. Questi periodi vengono poi associati a 2 rispettivi stati, 
	 * i quali vengono aggiunti alla camera su cui si era invocato il metodo occupaCamera
	 * @param statoContenente
	 * @param periodo
	 * @param indiceLista
	 */
	private void calcolaNuoviPeriodi(MStatoCamera statoContenente,MPeriodo periodo,int indiceLista){		
		MPeriodo periodoResiduo = new MPeriodo();
		periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
		periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
		
		MPeriodo periodoAntecedente = new MPeriodo();
		periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
		periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
		
		this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
		this.get_statiCamera().get(indiceLista).set_libera(true);
		System.out.println(periodo.get_giornoInizio());
		MStatoCamera nuovoStatoOccupato= new MStatoCamera();
		nuovoStatoOccupato.set_periodo(periodo);
		nuovoStatoOccupato.set_libera(false);
		this._statiCamera.add(indiceLista+1, nuovoStatoOccupato);
		
		MStatoCamera statoResiduo = new MStatoCamera();
		statoResiduo.set_periodo(periodoResiduo);
		statoResiduo.set_libera(true);
		this._statiCamera.add(indiceLista+2,statoResiduo);
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
