package com.iHotel.model;

import java.util.*;

public abstract class MCamera {

	/* --------------------------- Attributi ---------------------- */
	
	protected LinkedList<MStatoCamera> _statiCamera = new LinkedList<MStatoCamera>();
	protected String _numero;
	protected String _tipologia;
	protected MDescrizioneCamera _descrizioneCamera;

	/* -------------------------- Metodi di istanza ----------------------- */
	
	/**
	 * Metodo per controllare se una camera è libera in un periodo.
	 * 
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
	 * Metodo che occupa una stanza nel periodo passato come parametro. In base al periodo di occupazione, si vanno a modificare
	 * gli stati della camera su cui è invocato il metodo.
	 * 
	 * @param periodo Periodo in cui si deve occupare la camera 
	 */
	public void occupaInPeriodo(MPeriodo periodo) {
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
			// se il periodo della prenotazione nè comincia nè finisce gli stessi giorni del periodo che lo contiene
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
		else if(indiceLista ==0 && this.get_statiCamera().size()!=1)
		{			
			/*
			 * Definisco il periodo successivo, il periodo dello stato successivo allo statoContenente
			 */
			MPeriodo periodoSuccessivo = this.get_statiCamera().get(indiceLista +1).get_periodo();			
			
			//Se il periodo della prenotazione dura quanto tutto il periodo dello statoContenente
			 
			if (periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true && periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){				
				/*
				 * Creo un nuovo periodo in cui la camera sarà occupata, che va dal primo giorno della
				 * prenotazione fino all'ultimo giorno del periodo successivo (in cui la camera risulta occupata).
				 */
					MPeriodo periodoOccupato = new MPeriodo();
					periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
					periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
					/*
					 * Creo un nuovo stato camera con il periodo lungo, lo associo al periodo in cui la camera
					 *deve rsultare occupata, e setto l'occupazione
					 */
					MStatoCamera nuovoStatoOccupato= new MStatoCamera();
					nuovoStatoOccupato.set_periodo(periodoOccupato);
					nuovoStatoOccupato.set_libera(false);
					/*
					 * Rimuovo lo stato successivo allo statoContenente e successivamente, al posto dello 
					 * statoContenente, ci metto ilnuovo stato occupato.
					 */ 
					this.get_statiCamera().remove(indiceLista+1);
					this.get_statiCamera().set(indiceLista, nuovoStatoOccupato);
			}
			
			/*se il periodo della prenotazione richiesta termina lo stesso giorno del periodo
			 * dello statoContenente*/			
			else if(periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){		
					/*
					 * Creo il periodo antecedente, che andrà dal primo giorno del periodo dello statoContenente
					 * fino al primo giorno del periodo della prenotazione
					 */
					MPeriodo periodoAntecedente = new MPeriodo();
					periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
					periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
					//cambio periodo allo stato contenente, assegnandogli il periodo ricavato sopra
					this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
					this.get_statiCamera().get(indiceLista).set_libera(true);
					
					/*
					 * Creo il periodo occupato, in cui la camera sarà occupata. Questo andrà dal primo giorno del
					 * periodo dlla prenotazione, fino all'ultimo giorno del periodo dello stato successivo
					 * a quello contenente.
					 */
					MPeriodo periodoOccupato = new MPeriodo();
					periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
					periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
					//Creo lo stato occupato e gli assegno il periodo creato sopra
					MStatoCamera nuovoStatoOccupato = new MStatoCamera();
					nuovoStatoOccupato.set_periodo(periodoOccupato);
					nuovoStatoOccupato.set_libera(false);
					//aggiungo, in coda allo stato contenente, lo stato occupato
					this.get_statiCamera().add(indiceLista+1, nuovoStatoOccupato);
					
					/* Rimuovo lo stato successivo al nuovo stato occupato, perchè questo è stato "inglobato"
					 * nello stato appena inserito
					 */					
					this.get_statiCamera().remove(indiceLista+2);
					
				}
			/* 		se il periodo di richiesta della prenotazione comincia lo stesso giorno del periodo dello
			 * 		stato contenente		*/
			 else if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true){
				/*Creo il periodo occupato, che andrà dal primo giorno del periodo della prenotazone, fino 
				 * all'ultimo giorno del periodo della prenotazione
				 */				 
				 MPeriodo periodoOccupato = new MPeriodo();
				 periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				 periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				 //Creo lo statoCamera occupato, al quale assegno il periodo creato sopra
				 MStatoCamera nuovoStatoOccupato = new MStatoCamera();
				 nuovoStatoOccupato.set_periodo(periodoOccupato);
				 nuovoStatoOccupato.set_libera(false);
				 //aggiungo in testa alla lista lo stato occupato, poiché sarà il primo stato della camera
				 this.get_statiCamera().add(indiceLista, nuovoStatoOccupato);
				 
				 /*
				  * Creo il periodo residuo che va dal giorno di fine del periodo della prenotazione al giorno
				  * di fine del periodo dello stato contenente.
				  */
				 MPeriodo periodoResiduo = new MPeriodo();
				 periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				 periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				 //modifico lo stato contenente assegnandogli il periodo residuo.
				 this.get_statiCamera().get(indiceLista+1).set_periodo(periodoResiduo);
				 this.get_statiCamera().get(indiceLista+1).set_libera(true);
			 }
			// se il periodo della prenotazione nè comincia nè finisce gli stessi giorni del periodo che lo contiene

			 else{
				 	/*applico il metodo privato che mi calcola i nuovi periodi Antecedente,Occupato e Residuo, che si
					 * devono generare visto che il periodo di occupazione non combacia con nessuno degli estremi 
					 * del periodo dello statoContenente.
					 */
					this.calcolaNuoviPeriodi(statoContenente, periodo, indiceLista);

					
			 }
		}
		/*
		 * Questo viene eseguito se il periodo che contiene il periodo della richiesta, corrisponde all'ultimo stato
		 * associato con la camera
		 */
		else if((indiceLista == this.get_statiCamera().size()-1)&&indiceLista !=0){
			/*
			 * Definisco il periodo precedente, che è il periodo associato allo stato che precede lo stato contenente
			 */
			MPeriodo periodoPrecedente = this.get_statiCamera().get(indiceLista-1).get_periodo();
			//Se il periodo della prenotazione combacia con quello dello stato contenente
			if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true&& periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){
				/*
				 * Definisco il periodo occupato, che comincia lo stesso giorno del periodo occupato precedente e termina l'ultimo giorno del periodo della
				 * prenotazione
				 */
				MPeriodo nuovoPeriodoOccupato= new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				//Assegno allo stato precedente quello contenente il nuovo periodo di occupazione
				this.get_statiCamera().get(indiceLista-1).set_periodo(nuovoPeriodoOccupato);
				this.get_statiCamera().get(indiceLista-1).set_libera(false);
				//elimino lo statoContenente, poiché il suo periodo è stato inglobato in quello precedente
				this.get_statiCamera().remove(indiceLista);
			}
			//Se il periodo della prenotazione comincia lo stesso giorno del periodo dello stato contenente
			else if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true){
				/*
				 * Definisco il periodo di occupazione che andrà dal primo giorno del periodo dello stato precedente, all'ultimo giorno del 
				 * periodo della prenotazione				
				 */
				MPeriodo nuovoPeriodoOccupato = new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				//Assegno allo stato precedente il nuovo periodo di occupazione (più lungo)
				this.get_statiCamera().get(indiceLista-1).set_periodo(nuovoPeriodoOccupato);
				this.get_statiCamera().get(indiceLista -1).set_libera(false);
				/*
				 * Creo il periodo residuo che andrà dall'ultimo giorno del periodo della prenotazione fino all'ultimo giorno dello
				 * stato contenente
				 */
				MPeriodo periodoResiduo = new MPeriodo();
				periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				//Assegno allo stato contenente il periodo residuo
				this.get_statiCamera().get(indiceLista).set_periodo(periodoResiduo);
				this.get_statiCamera().get(indiceLista).set_libera(true);
				
			}
			//Se il periodo della prenotazione termina lo stesso giorno del periodo che lo contiene
			else if(periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){
				/*
				 * Creo il periodo antecedente a quello dello stato contenente, che andrà dal primo giorno del periodo che contiene il periodo della prenotazione
				 * fino al primo giorno della prenotazione.
				 */
				MPeriodo periodoAntecedente =new MPeriodo();
				periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
				periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
				//assegno il periodo antecedente allo statoContenente
				this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
				this.get_statiCamera().get(indiceLista).set_libera(true);
				/*
				 * Creo il period in cui la stanza sarà occupata. Va dal primo giorno del periodo della prenotazione, fino all'ultimo giorno
				 * del periodo della prenotazione
				 */
				MPeriodo nuovoPeriodoOccupato = new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				//creo lo stato occupato e gli assegno il periodo occupato
				MStatoCamera nuovoStatoOccupato = new MStatoCamera();
				nuovoStatoOccupato.set_periodo(nuovoPeriodoOccupato);
				nuovoStatoOccupato.set_libera(false);
				//aggiungo lo stato occupato in fondo alla lista degli stati della camera
				this.get_statiCamera().add(nuovoStatoOccupato);
				
			}
			// se il periodo della prenotazione nè comincia nè finisce gli stessi giorni del periodo che lo contiene
			else{
				/*
				 * applico il metodo privato che mi calcola i nuovi periodi Antecedente,Occupato e Residuo, che si
				 * devono generare visto che il periodo di occupazione non combacia con nessuno degli estremi 
				 * del periodo dello statoContenente.
				 */		
				this.calcolaNuoviPeriodi(statoContenente, periodo, indiceLista);
					
			}
		}
		/*
		 * Questo viene eseguito solo se la camera ha associato un solo stato e quindi un solo periodo. 
		 */
		else {
			//Se il periodo per cui si fa la prenotazione è pari all'intero periodo libero
			if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true &&
				periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){
				//cambio banalmente lo stato della camera
				statoContenente.set_libera(false);
			}
			//Se il periodo comincia lo stesso giorno del periodo che lo contiene
			else if(periodo.IniziaStessoGiornoInizioDi(statoContenente.get_periodo())==true){
				/*Creo un nuovo periodo occupato, che comincia il primo giorno della prenotazione e finisce l'ultimo giorno della stessa */
				MPeriodo nuovoPeriodoOccupato = new MPeriodo();
				nuovoPeriodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				nuovoPeriodoOccupato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				/* Creo il periodo residuo che va dal giorno della fne del periodo della prenotazione fino all'ultimo giorno del periodo residuo*/
				MPeriodo periodoResiduo = new MPeriodo();				
				periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);				
				periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				
				//creo lo stato residuo e gli assegno il periodo residuo
				MStatoCamera nuovoStatoResiduo = new MStatoCamera();
				nuovoStatoResiduo.set_periodo(periodoResiduo);
				nuovoStatoResiduo.set_libera(true);
				//Cambio lo stato contenente e gli assegno il periodo in cui è occupato. poi aggiungo lo stato residuo
				this.get_statiCamera().get(indiceLista).set_periodo(nuovoPeriodoOccupato);
				this.get_statiCamera().get(indiceLista).set_libera(false);
				this.get_statiCamera().add(indiceLista+1,nuovoStatoResiduo);				
				
			}
			// se il periodo della prenotazione finisce lo stesso giorno del periodo che lo contiene
			else if (periodo.FinisceStessoGiornoFineDi(statoContenente.get_periodo())==true){
				/*
				 * Creo il periodo antecedente che va dal giorno di inizio del periodo dello stato contenente all'ultimo giorno del
				 * periodo della prenotazione
				 */
				MPeriodo periodoAntecedente = new MPeriodo();
				periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
				periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
				/*
				 * Creo il periood occupato che va dal primo giorno del periodo della prenotazione fino all'ultimo giorno del periodo 
				 * dello stato contenente
				 */
				MPeriodo periodoOccupato =new MPeriodo();
				periodoOccupato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				periodoOccupato.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				//definisco lo stato occupato della camera assegnandogli il periodo dello occupato
				MStatoCamera nuovoStatoOccupato = new MStatoCamera();
				nuovoStatoOccupato.set_periodo(periodoOccupato);
				nuovoStatoOccupato.set_libera(false);
				/*
				 * Modifico lo statoContenente assegnandogli il periodo antecedente e aggiungo in coda alla lista 
				 * lo stato occupato
				 */
				this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
				this.get_statiCamera().get(indiceLista).set_libera(true);
				this.get_statiCamera().add(indiceLista+1, nuovoStatoOccupato);
			}
			else{
				/*
				 * applico il metodo privato che mi calcola i nuovi periodi Antecedente,Occupato e Residuo, che si
				 * devono generare visto che il periodo di occupazione non combacia con nessuno degli estremi 
				 * del periodo dello statoContenente.
				 */
				this.calcolaNuoviPeriodi(statoContenente, periodo, indiceLista);
			}
			
		}
	}
	
	
	/**
	 * Metodo che a partire dallo stato contenente, dal periodo della prenotazione e dall'indice della lista
	 * in cui si trova lo stato contenente, va a calcolare due nuovi periodi, uno precedente alla prenotazione 
	 * ed uno successivo, in cui la camera è libera. Questi periodi vengono poi associati a 2 rispettivi stati, 
	 * i quali vengono aggiunti alla camera su cui si era invocato il metodo occupaCamera.
	 * 
	 * @param statoContenente Stato il cui periodo, contiene quello per cui è effettuata la prenotazione.
	 * @param periodo Periodo per cui si è effettuata la prenotazione.
	 * @param indiceLista Posizione dello statoContenente all'interno della lista degli stati della camera.
	 */
	private void calcolaNuoviPeriodi(MStatoCamera statoContenente,MPeriodo periodo,int indiceLista){	
		/*
		 * Creo il periodo residuo che va dal giorno di fine della prenotazione fino al giorno di fine del periodo dello stato contenente
		 */
		MPeriodo periodoResiduo = new MPeriodo();
		periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
		periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
		/*
		 * Creo il periodo antecedente che va dal giorno di inizio del periodo dello stato contenente fino al primo giorno della prenotazione
		 */
		MPeriodo periodoAntecedente = new MPeriodo();
		periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
		periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
		//assegno allo stato contenente il periodo antecedente
		this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
		this.get_statiCamera().get(indiceLista).set_libera(true);
		//creo lo stato occupato, e gli assegno il periodo della prenotazione
		MStatoCamera nuovoStatoOccupato= new MStatoCamera();
		nuovoStatoOccupato.set_periodo(periodo);
		nuovoStatoOccupato.set_libera(false);
		//aggiungo lo stato occupato subito dopo lo stato antecente
		this._statiCamera.add(indiceLista+1, nuovoStatoOccupato);
		//creo lo stato residuo e gli assegno il periodo residuo
		MStatoCamera statoResiduo = new MStatoCamera();
		statoResiduo.set_periodo(periodoResiduo);
		statoResiduo.set_libera(true);
		//aggiungo lo stato residuo dopo lo stato occupato
		this._statiCamera.add(indiceLista+2,statoResiduo);
	}
	
	
	/*------------------ Getter e Setter --------------*/
	/**
	 * @return _statiCamera 
	 */
	public LinkedList<MStatoCamera> get_statiCamera() {
		return _statiCamera;
	}

	/**
	 * @param _statiCamera
	 */
	public void set_statiCamera(LinkedList<MStatoCamera> _statiCamera) {
		this._statiCamera = _statiCamera;
	}
	/**
	 * @return _numero
	 */
	public String get_numero() {
		return this._numero;
	}

	/**
	 * @param _numero
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
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
	/**
	 * @return _descrizioneCamera 
	 */
	public MDescrizioneCamera get_descrizioneCamera() {
		return this._descrizioneCamera;
	}
	/**
	 * @param _descrizioneCamera
	 */
	public void set_descrizioneCamera(MDescrizioneCamera _descrizioneCamera) {
		this._descrizioneCamera = _descrizioneCamera;
	}

}
