/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno;

/**
 * 
 * Classe addetta alla realizzazione della finestra per mostrare le informazioni di una prenotazione cancellata
 * 
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VPGP_InfoSoggiorno_Cancellato extends VPGP_InfoSoggiorno {

	/**
	 * Costruttore
	 */	
	public VPGP_InfoSoggiorno_Cancellato() {
		super();
	}
	
	@Override
	/**
	 * Metodo che setta la label contenente lo stato del soggiorno
	 */
	protected void setLblStatoSoggiorno(){
		_lblStatoSoggiorno.setText("Soggiorno Cancellato");
	}

}
