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

public class StatoCameraCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression _libera;
	
	public StatoCameraCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_libera = new BooleanExpression("_libera", this);
	}
	
	public StatoCameraCriteria(PersistentSession session) {
		this(session.createCriteria(StatoCamera.class));
	}
	
	public StatoCameraCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public PeriodoCriteria create_periodoCriteria() {
		return new PeriodoCriteria(createCriteria("_periodo"));
	}
	
	public CameraCriteria create_cameraCriteria() {
		return new CameraCriteria(createCriteria("_camera"));
	}
	
	public StatoCamera uniqueStatoCamera() {
		return (StatoCamera) super.uniqueResult();
	}
	
	public StatoCamera[] listStatoCamera() {
		java.util.List list = super.list();
		return (StatoCamera[]) list.toArray(new StatoCamera[list.size()]);
	}
}

