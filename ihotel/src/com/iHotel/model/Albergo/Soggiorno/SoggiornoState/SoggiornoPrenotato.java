/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno.SoggiornoState;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoSospeso;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoState.PagamentoState.PagamentoStateObserver;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.Strategie.StrategieSoggiorno.AmmontareCaparra.ComponentOttieniAmmontareCaparraStrategy;
import com.iHotel.model.Strategie.StrategieSoggiorno.AmmontareCaparra.StrategiaSoggiornoAmmontareCaparraFactory;
import com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza.ComponentOttieniGiornoScadenzaStrategy;
import com.iHotel.model.Strategie.StrategieSoggiorno.GiornoScadenza.StrategiaSoggiornoGiornoScadenzaFactory;
import com.iHotel.model.Utility.Periodo;

/**
 * Questa classe rappresenta lo stato del soggiorno in seguito alla sua prenotazione.
 * 
 * @author Gabriele
 */
public class SoggiornoPrenotato extends SoggiornoState {

	public SoggiornoPrenotato(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
		// Inizializziamo il pagamento state.
		_pagamentoState = new PagamentoSospeso(this);
	}
	
	public SoggiornoPrenotato(SoggiornoContextSubject soggiornoSubject, PagamentoStateObserver pagamentoState) {
		super(soggiornoSubject, pagamentoState);
	}

	@Override
	public void addCamera(Camera camera) {
		_soggiornoContext.get_camerePrenotate().add(camera);
		// Calcolo il nuovo totale delle camere della prenotazione
		this.calcolaImportoTotaleCamere();
	}

	@Override
	public void addPrenotante(String nome, String cognome, String eMail, String telefono) {
		ClientePrenotante prenotante = new ClientePrenotante();
		// Setto gli attributi del prenotante
		prenotante.set_nome(nome);		
		prenotante.set_cognome(cognome);
		prenotante.set_email(eMail);
		prenotante.set_telefono(telefono);
		// Setto il prenotante al soggiorno
		_soggiornoContext.set_prenotante(prenotante);
	}

	@Override
	public void occupaCamere() {
		// Camere riservate per il soggiorno
		ArrayList<Camera> camerePrenotante = _soggiornoContext.get_camerePrenotate();
		// Periodo della prenotazione
		Periodo periodoSoggiorno = _soggiornoContext.get_periodo();
		// Ciclo sulle camere del soggiorno
		for (Iterator<Camera> iterator = camerePrenotante.iterator(); iterator.hasNext();) {
			Camera cameraPrenotata = (Camera) iterator.next();
			// Occupo la camera nel periodo
			cameraPrenotata.occupaInPeriodo(periodoSoggiorno, _pagamentoState);
		}
	}

	@Override
	public void concludiPrenotazione(ClientePrenotante clientePrenotante) {		
		// Factory delle strategie.
		StrategiaSoggiornoGiornoScadenzaFactory strategiaGiornoScadenzaFactory = StrategiaSoggiornoGiornoScadenzaFactory.getInstance();
		StrategiaSoggiornoAmmontareCaparraFactory strategiaAmmontareCaparraFactory = StrategiaSoggiornoAmmontareCaparraFactory.getInstance();
		// Aggiungo l'ospite alla prenotazione
		_soggiornoContext.set_prenotante(clientePrenotante);
		// Occupo le camere scelte dall'utente
		_soggiornoContext.occupaCamere();
		// Setto il codice alla prenotazione
		_soggiornoContext.set_codice(SoggiornoContextSubject.generaCodice());
		// Strategia per il calcolo del giorno di scadenza
		ComponentOttieniGiornoScadenzaStrategy strategiaGiornoScadenza = strategiaGiornoScadenzaFactory.getStrategyCalcoloGiornoScadenza();
		// Setto il giorno di scadenza per l'invio della garanzia.
		_soggiornoContext.set_giornoScadenzaInvioGaranzia(strategiaGiornoScadenza.getGiornoScadenza(_soggiornoContext));
		// Strategia per il calcolo dell'ammontare della caparra
		ComponentOttieniAmmontareCaparraStrategy strategiaAmmontareCaparra = strategiaAmmontareCaparraFactory.getStrategyAmmontareCaparra();
		// Setto l'ammontare della caparra
		_soggiornoContext.set_ammontareCaparra(strategiaAmmontareCaparra.getAmmontareCaparra(_soggiornoContext));
		// Aggiungo il soggiorno allo storico
		Storico storico = Storico.getInstance();
		storico.addSoggiorno(_soggiornoContext);
	}

	@Override
	public void effettuaCheckIn() {
		// TODO - invio le informazioni degli ospiti al sistema esterno della polizia di stato
		ServiceFactory.getInstance().get_schedePSAdapter().generaSchedePubblicaSicurezza(_soggiornoContext);
		// Creo lo stato successivo soggiornoInCorso
		SoggiornoInCorso soggiornoInCorso = new SoggiornoInCorso(_soggiornoContext, _pagamentoState);
		// Comunico al pagamento state il nuovo stato del soggiorno
		_pagamentoState.set_soggiornoState(soggiornoInCorso);
		// Setto lo stato successivo al subject.
		_soggiornoContext.set_soggiornoState(soggiornoInCorso);
	}

	@Override
	public void effettuaCheckOut() {
		// TODO Auto-generated method stub
	}

}
