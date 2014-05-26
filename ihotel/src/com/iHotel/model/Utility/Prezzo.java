
package com.iHotel.model.Utility;

/**
 * Classe addetta alla gestione dei prezzi.
 * 
 * @author Eugenio
 */
public class Prezzo {

	/* ----------------- Attributi --------------------- */
	private double _importo;
	private String _valuta;
	
	//Costruttore di default
	public Prezzo() {
		// Valori di default.
		_importo = 0;
		_valuta = "Euro";
	}
	
	/**
	 * Costruttore con parametro
	 * @param importo E' l'importo del pagamento
	 */
	public Prezzo(double importo){
		this.set_importo(importo);
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
		double importo = this.get_importo() + prezzo.get_importo();
		this.set_importo(importo);
		return this;
	}
	/**
	 * Metodo per sottrarre due prezzi.
	 * 
	 * @param prezzo Prezzo da sottrarre.
	 * @return Prezzo in seguito alla sottrazione.
	 */
	public Prezzo sottrai(Prezzo prezzo){
		double importo = this.get_importo() - prezzo.get_importo();
		this.set_importo(importo);
		return this;
	}
	/**
	 * Metodo per ottenere un nuovo oggetto di tipo prezzo contenente un importo pari
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
		double importoScontato = this.get_importo()*percentuale;		
		// Setto l'importo al prezzo scontato
		prezzoScontato.set_importo(importoScontato);
		
		return prezzoScontato;
	}
	/**
	 * Metodo per vedere se l'importo di un prezzo è superiore rispetto a quello di un altro.
	 * 
	 * @param prezzoDaConfrontare Prezzo da confrontare
	 * @return True se l'importo dell'istanza è superiore rispetto a quello fornito per parametro. False altrimenti.
	 */
	public boolean isMaggioreDi(Prezzo prezzoDaConfrontare) {
		boolean esito = false;
		// Controllo se l'importo dell'istanza è maggiore di quello fornito.
		if (this.get_importo()>prezzoDaConfrontare.get_importo()) {
			esito=true;
		}
		
		return esito;
	}
	
	/* ----------------- Getter, Setter --------------------- */
	/**
	 * @return the _importo
	 */
	public double get_importo() {
		return _importo;
	}
	/**
	 * @param _importo the _importo to set
	 */
	public void set_importo(double _importo) {
		this._importo = _importo;
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