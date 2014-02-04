/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package com.iHotel.persistentModel;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ElementoPrenotazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ElementoPrenotazioneDetachedCriteria() {
		super(com.iHotel.persistentModel.ElementoPrenotazione.class, com.iHotel.persistentModel.ElementoPrenotazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ElementoPrenotazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.ElementoPrenotazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.PrenotazioneDetachedCriteria create_prenotazioneCriteria() {
		return new com.iHotel.persistentModel.PrenotazioneDetachedCriteria(createCriteria("_prenotazione"));
	}
	
	public com.iHotel.persistentModel.CameraDetachedCriteria create_cameraCriteria() {
		return new com.iHotel.persistentModel.CameraDetachedCriteria(createCriteria("_camera"));
	}
	
	public ElementoPrenotazione uniqueElementoPrenotazione(PersistentSession session) {
		return (ElementoPrenotazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ElementoPrenotazione[] listElementoPrenotazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ElementoPrenotazione[]) list.toArray(new ElementoPrenotazione[list.size()]);
	}
}

