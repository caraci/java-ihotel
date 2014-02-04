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

public class PeriodoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DateExpression _dataInizio;
	public final DateExpression _dataFine;
	
	public PeriodoDetachedCriteria() {
		super(com.iHotel.persistentModel.Periodo.class, com.iHotel.persistentModel.PeriodoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_dataInizio = new DateExpression("_dataInizio", this.getDetachedCriteria());
		_dataFine = new DateExpression("_dataFine", this.getDetachedCriteria());
	}
	
	public PeriodoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.PeriodoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_dataInizio = new DateExpression("_dataInizio", this.getDetachedCriteria());
		_dataFine = new DateExpression("_dataFine", this.getDetachedCriteria());
	}
	
	public Periodo uniquePeriodo(PersistentSession session) {
		return (Periodo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Periodo[] listPeriodo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Periodo[]) list.toArray(new Periodo[list.size()]);
	}
}

