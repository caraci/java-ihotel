package com.iHotel.model;

import java.util.*;

public class MCamera {

	private LinkedList<MStatoCamera> _statiCamera = new LinkedList<MStatoCamera>();
	private String _numero;
	private String _tipologia;
	private MDescrizioneCamera _descrizioneCamera;


	/**
	 * Metodo per controllare se una camera � libera in un periodo.
	 * @param periodoRichiesta Periodo nel quale si vuole prenotare la camera.
	 * @return True se la camera � libera nel periodo. False altrimenti.
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
	 * c'� la necessit� di creare un periodo prima ed uno dopo a quello della prenotazione, in cui la camera risulti
	 * essere libera.
	 */
	public boolean occupaInPeriodo(MPeriodo periodo) {
		//definisco lo stato contenente, lo stato occupato e lo stato residuo. Setto i parametri dello stato occupato
		//perch� li ho gi� tutti per farlo.		
		
		MStatoCamera statoOccupato = new MStatoCamera();
		statoOccupato.set_periodo(periodo);
		statoOccupato.set_libera(false);		
		
		//indiceLista serve perch� poi dovr� riposizionare i periodi
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
		//qua si incasina un p� aniddoc
		
		System.out.print(indiceLista);
		if (indiceLista != 0){
			System.out.print("indicelista != 0");
			MPeriodo periodoPrecedente = this.get_statiCamera().get(indiceLista -1).get_periodo();
			MPeriodo periodoSuccessivo = this.get_statiCamera().get(indiceLista +1).get_periodo();
			
			//quando il periodo � contenuto esattamente tra quello prima e quello dopo
			if(periodo.contenutoTraPeriodi(periodoPrecedente, periodoSuccessivo)){
				//creo nuovo periodo lungo
				System.out.print("magico");
				MPeriodo periodoOccupazioneAllungato = new MPeriodo();
				periodoOccupazioneAllungato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				periodoOccupazioneAllungato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
				this.get_statiCamera().get(indiceLista -1).set_periodo(periodoOccupazioneAllungato);
				this.get_statiCamera().get(indiceLista -1).set_libera(false);
				this.get_statiCamera().remove(indiceLista+1);
				this.get_statiCamera().remove(indiceLista);
			}
			
			else if (periodo.segue(periodoPrecedente)){
				//allungo il periodo di occupazione
				MPeriodo periodoOccupazioneAllungato = new MPeriodo();
				periodoOccupazioneAllungato.setDataInizioPeriodoDaDataInizioPeriodo(periodoPrecedente);
				periodoOccupazioneAllungato.setDataFinePeriodoDaDataFinePeriodo(periodo);
				
				this.get_statiCamera().get(indiceLista -1).set_periodo(periodoOccupazioneAllungato);
				this.get_statiCamera().get(indiceLista -1).set_libera(false);
				//riduco il periodo libero residuo
				
				MPeriodo periodoResiduo = new MPeriodo();
				periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				this.get_statiCamera().get(indiceLista).set_periodo(periodoResiduo);
				this.get_statiCamera().get(indiceLista).set_libera(true);
			}
			else if (periodo.anticipa(periodoSuccessivo)){
				//allungo il periodo di occupazione
				MPeriodo periodoOccupazioneAllungato = new MPeriodo();
				periodoOccupazioneAllungato.setDataInizioPeriodoDaDataInizioPeriodo(periodo);
				periodoOccupazioneAllungato.setDataFinePeriodoDaDataFinePeriodo(periodoSuccessivo);
				this.get_statiCamera().get(indiceLista +1 ).set_periodo(periodoOccupazioneAllungato);
				this.get_statiCamera().get(indiceLista +1 ).set_libera(false);
				
				MPeriodo periodoAntecedente = new MPeriodo();
				periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
				periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
				this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
				this.get_statiCamera().get(indiceLista).set_libera(true);
			}
			else{
				
				MPeriodo periodoResiduo = new MPeriodo();
				periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
				periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
				
				MPeriodo periodoAntecedente = new MPeriodo();
				periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
				periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
				
				this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
				this.get_statiCamera().get(indiceLista).set_libera(true);
				
				MStatoCamera nuovoStatoOccupato= new MStatoCamera();
				nuovoStatoOccupato.set_periodo(periodo);
				nuovoStatoOccupato.set_libera(false);
				this._statiCamera.add(indiceLista+1, nuovoStatoOccupato);
				
				MStatoCamera statoResiduo = new MStatoCamera();
				statoResiduo.set_periodo(periodoResiduo);
				statoResiduo.set_libera(true);
				this._statiCamera.add(indiceLista+2,statoResiduo);
				
			}
		}
		
		else if(indiceLista ==0)
		{
			
			MPeriodo periodoSuccessivo = this.get_statiCamera().get(indiceLista +1).get_periodo();
			
			
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
				 MPeriodo periodoResiduo = new MPeriodo();
					periodoResiduo.setDataFinePeriodoDaDataFinePeriodo(statoContenente.get_periodo());
					periodoResiduo.setDataInizioPeriodoDaDataFinePeriodo(periodo);
					
					MPeriodo periodoAntecedente = new MPeriodo();
					periodoAntecedente.setDataInizioPeriodoDaDataInizioPeriodo(statoContenente.get_periodo());
					periodoAntecedente.setDataFinePeriodoDaDataInizioPeriodo(periodo);
					
					this.get_statiCamera().get(indiceLista).set_periodo(periodoAntecedente);
					this.get_statiCamera().get(indiceLista).set_libera(true);
					
					MStatoCamera nuovoStatoOccupato= new MStatoCamera();
					nuovoStatoOccupato.set_periodo(periodo);
					nuovoStatoOccupato.set_libera(false);
					this._statiCamera.add(indiceLista+1, nuovoStatoOccupato);
					
					MStatoCamera statoResiduo = new MStatoCamera();
					statoResiduo.set_periodo(periodoResiduo);
					statoResiduo.set_libera(true);
					this._statiCamera.add(indiceLista+2,statoResiduo);
					
			 }
		}
		
		
		return true;
	}
	
	
	
	
	
	/**
	 * 
	 * @param periodoStatoContenente
	 * @param periodoPrenotazione
	 * @return
	 */
	private MPeriodo calcolaPeriodoResiduo(MPeriodo periodoStatoContenente, MPeriodo periodoPrenotazione){
		/* ********* Periodo residuo: dal giorno dopo  data di fine della prenotazione al giorno della fine periodoStatoContenente************/
		MPeriodo periodoResiduo = new MPeriodo();
		
		//calcolo data inizio del periodo residuo
		GregorianCalendar dataFinePeriodoPrenotazione = new GregorianCalendar();
		dataFinePeriodoPrenotazione.set(periodoPrenotazione.get_annoFine(), periodoPrenotazione.get_meseFine(), periodoPrenotazione.get_giornoFine());
		
		dataFinePeriodoPrenotazione.add(Calendar.DAY_OF_MONTH,1);
		int giornoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.DATE);
		System.out.print("giorno fine periodo residuo"+ periodoStatoContenente.get_giornoFine());
		int meseDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.MONTH);
		int annoDopoFinePrenotazione = dataFinePeriodoPrenotazione.get(Calendar.YEAR);
		
		//Setting degli attributi
		periodoResiduo.set_giornoInizio(giornoDopoFinePrenotazione);
		periodoResiduo.set_meseInizio(meseDopoFinePrenotazione);
		periodoResiduo.set_annoInizio(annoDopoFinePrenotazione);		
		
		periodoResiduo.set_giornoFine(periodoStatoContenente.get_giornoFine());
		periodoResiduo.set_meseFine(periodoStatoContenente.get_meseFine());
		periodoResiduo.set_annoFine(periodoStatoContenente.get_annoFine());
		
		return periodoResiduo;
		
	}
	
	private MPeriodo calcolaPeriodoAntecedente(MPeriodo nuovoPeriodoStatoContenente,MPeriodo periodoPrenotazione){
		
		//ricavo le date del periodo della prenotazione
		GregorianCalendar dataInizioPeriodoPrenotazione = new GregorianCalendar();
		dataInizioPeriodoPrenotazione.set(periodoPrenotazione.get_annoInizio(), periodoPrenotazione.get_meseInizio(), periodoPrenotazione.get_giornoInizio());
		
		
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
		
		//dopo aver determinato la nuova data di fine del periodo antecedente la prenotazione, vado a vedere se � valido
		
		/*GregorianCalendar nuovaDataFinePeriodoStatoContenente = new GregorianCalendar();
		nuovaDataFinePeriodoStatoContenente.set(nuovoPeriodoStatoContenente.get_annoFine(), nuovoPeriodoStatoContenente.get_meseFine(), nuovoPeriodoStatoContenente.get_giornoFine());*/
		GregorianCalendar dataInizioPeriodoStatoContenente = new GregorianCalendar();
		dataInizioPeriodoStatoContenente.set(nuovoPeriodoStatoContenente.get_annoInizio(), nuovoPeriodoStatoContenente.get_meseInizio(), nuovoPeriodoStatoContenente.get_giornoInizio());
		
		if (dataInizioPeriodoStatoContenente.compareTo(dataInizioPeriodoPrenotazione)==1){
			return null;
		}
		return nuovoPeriodoStatoContenente;
	}
	
	private MPeriodo calcolaNuovoPeriodoStatoContenente(MPeriodo vecchioPeriodo){
		//estraggo le date dal vecchio periodo
		
		int gi = vecchioPeriodo.get_giornoInizio();
		int mi = vecchioPeriodo.get_meseInizio();
		int ai = vecchioPeriodo.get_annoInizio();
		
		int gf = vecchioPeriodo.get_giornoFine();
		int mf = vecchioPeriodo.get_meseFine();
		int af = vecchioPeriodo.get_annoFine();		
		//setto le date del nuovo periodo
		MPeriodo nuovoPeriodo = new MPeriodo();
		nuovoPeriodo.set_giornoInizio(gi);
		nuovoPeriodo.set_meseInizio(mi);
		nuovoPeriodo.set_annoInizio(ai);
		nuovoPeriodo.set_giornoFine(gf);
		nuovoPeriodo.set_meseFine(mf);
		nuovoPeriodo.set_annoFine(af);
		return nuovoPeriodo;
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
