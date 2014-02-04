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

public class ElementoPrenotazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public ElementoPrenotazioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public ElementoPrenotazioneCriteria(PersistentSession session) {
		this(session.createCriteria(ElementoPrenotazione.class));
	}
	
	public ElementoPrenotazioneCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public PrenotazioneCriteria create_prenotazioneCriteria() {
		return new PrenotazioneCriteria(createCriteria("_prenotazione"));
	}
	
	public CameraCriteria create_cameraCriteria() {
		return new CameraCriteria(createCriteria("_camera"));
	}
	
	public ElementoPrenotazione uniqueElementoPrenotazione() {
		return (ElementoPrenotazione) super.uniqueResult();
	}
	
	public ElementoPrenotazione[] listElementoPrenotazione() {
		java.util.List list = super.list();
		return (ElementoPrenotazione[]) list.toArray(new ElementoPrenotazione[list.size()]);
	}
}

