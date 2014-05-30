/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno;

/**
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
	protected void setLblStatoSoggiorno(){
		_lblStatoSoggiorno.setText("Soggiorno Cancellato");
	}

}
