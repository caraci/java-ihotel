/**
 * 
 */
package com.iHotel.model.Albergo.Soggiorno;

import java.util.ArrayList;
import java.util.Iterator;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.StrategieSoggiorno.AmmontareCaparra.ComponentOttieniAmmontareCaparraStrategy;
import com.iHotel.model.StrategieSoggiorno.AmmontareCaparra.StrategiaSoggiornoAmmontareCaparraFactory;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.ComponentOttieniGiornoScadenzaStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.StrategiaSoggiornoGiornoScadenzaFactory;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public class SoggiornoPrenotato extends SoggiornoState {

	public SoggiornoPrenotato(SoggiornoContextSubject soggiornoSubject) {
		super(soggiornoSubject);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Prezzo getPrezzoServiziInterni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void calcolaImportoTotaleCamere() {
		DescrizioneCamera descrizione;
		// Prendo l'ultima camera aggiunta.
		Camera cameraPrenotata;
		// Lista delle camere prenotate.
		ArrayList<Camera> camerePrenotate = _soggiornoSubject.get_camerePrenotate();
		// Prendo l'ultima camera aggiunta al soggiorno.
		cameraPrenotata=camerePrenotate.get(camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia=cameraPrenotata.get_tipologia();
		descrizione=CatalogoCamere.getInstance().getDescrizioneDaTipologia(tipologia);
		// Periodo del soggiorno.
		Periodo periodoSoggiorno = _soggiornoSubject.get_periodo();
		// Importo totale per le camere del soggiorno
		Prezzo importoTotaleCamere = _soggiornoSubject.get_importoTotaleCamere();
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		importoTotaleCamere.somma(descrizione.calcolaPrezzoInPeriodo(periodoSoggiorno));
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato della prenotazione.
		_soggiornoSubject.Notify();
		
	}

	@Override
	public void calcolaTotaleDaPagare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCamera(Camera camera) {
		_soggiornoSubject.get_camerePrenotate().add(camera);
		// Calcolo il nuovo totale della prenotazione
		_soggiornoSubject.calcolaImportoTotaleCamere();
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
		_soggiornoSubject.set_prenotante(prenotante);
	}

	@Override
	public void occupaCamere() {
		// Camere riservate per il soggiorno
		ArrayList<Camera> camerePrenotante = _soggiornoSubject.get_camerePrenotate();
		// Periodo della prenotazione
		Periodo periodoSoggiorno = _soggiornoSubject.get_periodo();
		// Ciclo sulle camere del soggiorno
		for (Iterator<Camera> iterator = camerePrenotante.iterator(); iterator.hasNext();) {
			Camera cameraPrenotata = (Camera) iterator.next();
			// Occupo la camera nel periodo
			cameraPrenotata.occupaInPeriodoState(periodoSoggiorno);
		}
	}

	@Override
	public void addPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono) {		
		// Factory delle strategie.
		StrategiaSoggiornoGiornoScadenzaFactory strategiaGiornoScadenzaFactory = StrategiaSoggiornoGiornoScadenzaFactory.getInstance();
		StrategiaSoggiornoAmmontareCaparraFactory strategiaAmmontareCaparraFactory = StrategiaSoggiornoAmmontareCaparraFactory.getInstance();
		// Aggiungo l'ospite alla prenotazione
		_soggiornoSubject.addPrenotante(nome, cognome, eMail, telefono);
		// Occupo le camere scelte dall'utente
		_soggiornoSubject.occupaCamere();
		// Setto il codice alla prenotazione
		_soggiornoSubject.set_codice(SoggiornoContextSubject.generaCodice());
		// Strategia per il calcolo del giorno di scadenza
		ComponentOttieniGiornoScadenzaStrategy strategiaGiornoScadenza = strategiaGiornoScadenzaFactory.getStrategyCalcoloGiornoScadenza();
		// Setto il giorno di scadenza per l'invio della garanzia.
		_soggiornoSubject.set_giornoScadenzaInvioGaranzia(strategiaGiornoScadenza.getGiornoScadenza(_soggiornoSubject));
		// Strategia per il calcolo dell'ammontare della caparra
		ComponentOttieniAmmontareCaparraStrategy strategiaAmmontareCaparra = strategiaAmmontareCaparraFactory.getStrategyAmmontareCaparra();
		// Setto l'ammontare della caparra
		_soggiornoSubject.set_ammontareCaparra(strategiaAmmontareCaparra.getAmmontareCaparra(_soggiornoSubject));
		
	}

}
