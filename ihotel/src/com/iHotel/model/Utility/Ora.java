/**
 * 
 */
package com.iHotel.model.Utility;

/**
 * Classe che modella un'ora del giorno.
 * @author Alessandro
 *
 */
public class Ora {
	
	/*Attributi e costruttore*/
	/**
	 * Ore
	 */
	private int ore;
	/**
	 * Minuti
	 */
	private int minuti;
	
	/**
	 * Costruttore di default
	 */
	public Ora(){}
	
	/**
	 * Costruttore con parametri
	 * @param ore 
	 * @param minuti
	 */
	public Ora(int ore, int minuti){
		this.setOre(ore);
		this.setMinuti(minuti);
	}
	
	/*---------------------Getter, Setter---------------------*/
	/**
	 * @return the ore
	 */
	public int getOre() {
		return ore;
	}
	/**
	 * @param ore the ore to set
	 */
	public void setOre(int ore) {
		this.ore = ore;
	}
	/**
	 * @return the minuti
	 */
	public int getMinuti() {
		return minuti;
	}
	/**
	 * @param minuti the minuti to set
	 */
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

}
