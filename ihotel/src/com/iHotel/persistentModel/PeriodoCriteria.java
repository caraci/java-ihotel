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

public class PeriodoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression _dataInizio;
	public final DateExpression _dataFine;
	
	public PeriodoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_dataInizio = new DateExpression("_dataInizio", this);
		_dataFine = new DateExpression("_dataFine", this);
	}
	
	public PeriodoCriteria(PersistentSession session) {
		this(session.createCriteria(Periodo.class));
	}
	
	public PeriodoCriteria() throws PersistentException {
		this(com.iHotel.persistentModel.IhotelPersistentManager.instance().getSession());
	}
	
	public Periodo uniquePeriodo() {
		return (Periodo) super.uniqueResult();
	}
	
	public Periodo[] listPeriodo() {
		java.util.List list = super.list();
		return (Periodo[]) list.toArray(new Periodo[list.size()]);
	}
}

