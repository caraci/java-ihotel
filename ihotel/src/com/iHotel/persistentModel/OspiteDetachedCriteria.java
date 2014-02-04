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

public class OspiteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression _nome;
	public final StringExpression _cognome;
	public final StringExpression _email;
	public final StringExpression _telefono;
	
	public OspiteDetachedCriteria() {
		super(com.iHotel.persistentModel.Ospite.class, com.iHotel.persistentModel.OspiteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_cognome = new StringExpression("_cognome", this.getDetachedCriteria());
		_email = new StringExpression("_email", this.getDetachedCriteria());
		_telefono = new StringExpression("_telefono", this.getDetachedCriteria());
	}
	
	public OspiteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.iHotel.persistentModel.OspiteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_cognome = new StringExpression("_cognome", this.getDetachedCriteria());
		_email = new StringExpression("_email", this.getDetachedCriteria());
		_telefono = new StringExpression("_telefono", this.getDetachedCriteria());
	}
	
	public Ospite uniqueOspite(PersistentSession session) {
		return (Ospite) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ospite[] listOspite(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ospite[]) list.toArray(new Ospite[list.size()]);
	}
}

