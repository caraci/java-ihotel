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

public class PrenotazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression _completa;
	
	public PrenotazioneDetachedCriteria() {
		super(com.iHotel.persistentModel.Prenotazione.class, com.iHotel.persistentModel.PrenotazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_completa = new BooleanExpression("_completa", this.getDetachedCriteria());
	}
	
	public PrenotazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.PrenotazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_completa = new BooleanExpression("_completa", this.getDetachedCriteria());
	}
	
	public com.iHotel.persistentModel.PeriodoDetachedCriteria create_periodoCriteria() {
		return new com.iHotel.persistentModel.PeriodoDetachedCriteria(createCriteria("_periodo"));
	}
	
	public com.iHotel.persistentModel.OspiteDetachedCriteria create_ospiteCriteria() {
		return new com.iHotel.persistentModel.OspiteDetachedCriteria(createCriteria("_ospite"));
	}
	
	public com.iHotel.persistentModel.AlbergoDetachedCriteria create_albergoCriteria() {
		return new com.iHotel.persistentModel.AlbergoDetachedCriteria(createCriteria("_albergo"));
	}
	
	public com.iHotel.persistentModel.ElementoPrenotazioneDetachedCriteria create_elementiPrenotazioneCriteria() {
		return new com.iHotel.persistentModel.ElementoPrenotazioneDetachedCriteria(createCriteria("_elementiPrenotazione"));
	}
	
	public Prenotazione uniquePrenotazione(PersistentSession session) {
		return (Prenotazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Prenotazione[] listPrenotazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Prenotazione[]) list.toArray(new Prenotazione[list.size()]);
	}
}

