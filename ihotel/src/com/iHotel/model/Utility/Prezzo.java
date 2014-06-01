
package com.iHotel.model.Utility;

/**
 * Classe addetta alla gestione dei prezzi.
 * 
 * @author Eugenio
 */
public class Prezzo {

	/* ----------------- Attributi --------------------- */
	/**
	 * Quantità del prezzo. Es. 10€, allora _quantita=10.
	 */
	private double _quantita;
	/**
	 * Valuta della quantità. Es. 10€, allora _valuta=€.
	 */
	private String _valuta;
	
	/**
	 * Costruttore.
	 */
	public Prezzo() {
		// Valori di default.
		_quantita = 0;
		_valuta = "Euro";
	}
	
	/**
	 * Costruttore.
	 * 
	 * @param quantita E' la quantità del pagamento.
	 */
	public Prezzo(double quantita){
		this.set_quantita(quantita);
		_valuta = "Euro";
	}
	
	/* ----------------- Metodi di instanza --------------------- */
	/**
	 * Metodo per sommare due prezzi.
	 * 
	 * @param prezzo Prezzo da sommare.
	 * @return Prezzo in seguito alla somma.
	 */
	public Prezzo somma(Prezzo prezzo){
		double importo = this.get_quantita() + prezzo.get_quantita();
		this.set_quantita(importo);
		return this;
	}
	/**
	 * Metodo per sottrarre due prezzi.
	 * 
	 * @param prezzo Prezzo da sottrarre.
	 * @return Prezzo in seguito alla sottrazione.
	 */
	public Prezzo sottrai(Prezzo prezzo){
		double importo = this.get_quantita() - prezzo.get_quantita();
		this.set_quantita(importo);
		return this;
	}
	/**
	 * Metodo per ottenere un nuovo oggetto di tipo prezzo contenente una quantità pari
	 * a quello dell'oggetto su cui si invoca il metodo, scontato della quantità fornita
	 * come parametro.
	 * 
	 * @param percentualeSconto Percentuale di sconto da applicare
	 * @return Oggetto prezzo con importo scontato.
	 */
	public Prezzo getImportoPercentuale(int percentualeSconto) {
		Prezzo prezzoScontato = new Prezzo();
		// Percentuale da scontare
		double percentuale = (double) percentualeSconto*0.01;
		// Calcolo l'importo scontato
		double importoScontato = this.get_quantita()*percentuale;		
		// Setto l'importo al prezzo scontato
		prezzoScontato.set_quantita(importoScontato);
		
		return prezzoScontato;
	}
	/**
	 * Metodo per vedere se l'importo di un prezzo è superiore rispetto a quello di un altro.
	 * 
	 * @param prezzoDaConfrontare Prezzo da confrontare.
	 * @return True se l'importo dell'istanza è superiore rispetto a quello fornito per parametro. False altrimenti.
	 */
	public boolean isMaggioreDi(Prezzo prezzoDaConfrontare) {
		boolean esito = false;
		// Controllo se l'importo dell'istanza è maggiore di quello fornito.
		if (this.get_quantita()>prezzoDaConfrontare.get_quantita()) {
			esito=true;
		}
		
		return esito;
	}
	
	/* ----------------- Getter, Setter --------------------- */
	/**
	 * @return the _importo
	 */
	public double get_quantita() {
		return _quantita;
	}
	/**
	 * @param _importo the _importo to set
	 */
	public void set_quantita(double _importo) {
		this._quantita = _importo;
	}
	/**
	 * @return the _valuta
	 */
	public String get_valuta() {
		return _valuta;
	}
	/**
	 * @param _valuta the _valuta to set
	 */
	public void set_valuta(String _valuta) {
		this._valuta = _valuta;
	}

}