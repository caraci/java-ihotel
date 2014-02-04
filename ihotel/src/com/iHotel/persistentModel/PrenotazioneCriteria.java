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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PrenotazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression _completa;
	
	public PrenotazioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_completa = new BooleanExpression("_completa", this);
	}
	
	public PrenotazioneCriteria(PersistentSession session) {
		this(session.createCriteria(Prenotazione.class));
	}
	
	public PrenotazioneCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public PeriodoCriteria create_periodoCriteria() {
		return new PeriodoCriteria(createCriteria("_periodo"));
	}
	
	public OspiteCriteria create_ospiteCriteria() {
		return new OspiteCriteria(createCriteria("_ospite"));
	}
	
	public AlbergoCriteria create_albergoCriteria() {
		return new AlbergoCriteria(createCriteria("_albergo"));
	}
	
	public com.iHotel.persistentModel.ElementoPrenotazioneCriteria create_elementiPrenotazioneCriteria() {
		return new com.iHotel.persistentModel.ElementoPrenotazioneCriteria(createCriteria("_elementiPrenotazione"));
	}
	
	public Prenotazione uniquePrenotazione() {
		return (Prenotazione) super.uniqueResult();
	}
	
	public Prenotazione[] listPrenotazione() {
		java.util.List list = super.list();
		return (Prenotazione[]) list.toArray(new Prenotazione[list.size()]);
	}
}

