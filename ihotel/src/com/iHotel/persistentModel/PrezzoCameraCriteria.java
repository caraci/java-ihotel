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

public class PrezzoCameraCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _prezzo;
	
	public PrezzoCameraCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_prezzo = new IntegerExpression("_prezzo", this);
	}
	
	public PrezzoCameraCriteria(PersistentSession session) {
		this(session.createCriteria(PrezzoCamera.class));
	}
	
	public PrezzoCameraCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public PeriodoCriteria create_periodoCriteria() {
		return new PeriodoCriteria(createCriteria("_periodo"));
	}
	
	public DescrizioneCameraCriteria create_descrizioneCameraCriteria() {
		return new DescrizioneCameraCriteria(createCriteria("_descrizioneCamera"));
	}
	
	public PrezzoCamera uniquePrezzoCamera() {
		return (PrezzoCamera) super.uniqueResult();
	}
	
	public PrezzoCamera[] listPrezzoCamera() {
		java.util.List list = super.list();
		return (PrezzoCamera[]) list.toArray(new PrezzoCamera[list.size()]);
	}
}

